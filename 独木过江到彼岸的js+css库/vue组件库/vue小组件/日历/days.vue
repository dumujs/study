<template>
       <div id='calendar'>
                <!-- 年份 月份 -->
                <div class='month'>
                    <slot name="header">
                    	<ul v-show="header">
                        <!--点击会触发pickpre函数，重新刷新当前日期 @click(vue v-on:click缩写) -->
	                        <li class='arrow' v-for="(p,index) in headerDate" :key='index'>
								<div  class="calendar-details">
									<div class="calendar-details-day">{{showDay(p)}}</div>
									<div class="calendar-details-month">{{monthArr[p?p.getMonth()+1:currentTime.getMonth()+1]}}月</div>
									<div class="calendar-details-week">{{weekArr[p?p.getDay():currentTime.getDay()]}}</div>
								</div>
	                        </li>
	                        
	                    </ul>
                    </slot>
	                <!-- 星期 -->
	                <slot name="week">
		                <ul class='weekdays'>
		                    <li>日</li>
		                    <li>一</li>
		                    <li>二</li>
		                    <li>三</li>
		                    <li>四</li>
		                    <li>五</li>
		                    <li>六</li>
		                </ul>
	                </slot>
                </div>

                <!-- 日期 -->
                <div class="calendar-month" v-for='p in showMonthsArr'>
                	<div class="calendar-month">
                	{{p.date.getFullYear()}}年-{{monthArr[p.date.getMonth()]}}月
	                </div>
	                <ul class='days'>
	                    <!-- 核心 v-for循环 每一次循环用<li>标签创建一天 -->
	                    <li  v-for='(dayobject,i) in p.days' :key='i' >
	                        <!--本月-->
	                        <!--如果不是本月  改变类名加灰色-->
	                        <span v-if='dayobject.day.getMonth()+1 != p.date.getMonth()+1&&dayobject.day.getTime()<p.date.getTime()' class='other-month'>{{ dayobject.day.getDate() }}</span>
	                        <span v-else-if='dayobject.day.getMonth()+1 != p.date.getMonth()+1&&dayobject.day.getTime()>p.date.getTime()' class='next-month' style="display: none;">{{ dayobject.day.getDate() }}</span>
	                        <!--如果是本月  还需要判断是不是这一天-->
	                      <!--今天  同年同月同日-->
                            <span :class="isActive(dayobject.day)" v-else-if='dayobject.day.getFullYear() == new Date().getFullYear() && dayobject.day.getMonth() == new Date().getMonth() && dayobject.day.getDate() == new Date().getDate()' class='active' @click="getDayTime(dayobject.day)">{{ dayobject.day.getDate() }}</span>
                            <span :class="isActive(dayobject.day)" v-else @click="sendDayTime(dayobject.day)">{{ dayobject.day.getDate() }}</span>
	                    </li>
	                </ul>
                </div>
            </div>
</template>
<script>
export default {
  data () {
  	return {
  		showMonthsArr:[],
	  	currentTime:new Date()
  	}
  },
  props:{
  	header:{
  		Type:Boolean,
  		default:true
  	},
  	monthArr:{
  		Type:Array,
  		default:()=>['一','二','三','四','五','六','七','八','九','十','十一','十二'],
  	},
  	weekArr:{
  		Type:Array,
  		default:()=>['周日','周一','周二','周三','周四','周五','周六'],
  	},
  	startEnd:{
  		Type:Number,
  		default:0//0,1,2...
  	},
  	headerDate:{
  		Type:Array,
  		default:()=>[]
  	},
  	monthNum:{
  		Type:Number,
  		default:12
  	}
  	
  },
  created(){
//	console.log(this.$route.params.id)
  	for(let i=0;i<=this.monthNum;i++){
  		this.showMonthsArr.push(this.pickNext(2019,this.currentTime.getMonth()+i))
  	}
//	console.log(this.showMonthsArr)
  },
  methods: {
  	sendDayTime(day){
  		this.$emit('getDayTime',day)
  	},
    initData: function (cur) {
      // var leftcount = 0 // 存放剩余数量
      var date
      if (cur) {
        date = new Date(cur)
      } else {
        var now = new Date()
        var d = new Date(this.formatDate(now.getFullYear(), now.getMonth(), 1))
        d.setDate(35)
        date = new Date(this.formatDate(d.getFullYear(), d.getMonth() + 1, 1))
      }
      let currentDay = date.getDate()
      let currentYear = date.getFullYear()
      let currentMonth = date.getMonth() + 1
      let currentWeek = date.getDay() // 1...6,0
      if (currentWeek === 0) {
        	currentWeek = 7
      }
      var str = this.formatDate(
        currentYear,
        currentMonth,
        currentDay
      )
      let days= []
      // 今天是周日，放在第一行第7个位置，前面6个
      // 初始化本周
     for (var i = currentWeek!=7?currentWeek:0; i >= 0; i--) {
        var d2 = new Date(str)
        d2.setDate(d2.getDate() - i)
        var dayobjectSelf = {} // 用一个对象包装Date对象  以便为以后预定功能添加属性
        dayobjectSelf.day = d2
        days.push(dayobjectSelf) // 将日期放入data 中的days数组 供页面渲染使用
      }
      // 其他周
      
      for (var j = 1; j <42 -currentWeek; j++) {
        var d3 = new Date(str)
        d3.setDate(d3.getDate() + j)
        var dayobjectOther = {}
        dayobjectOther.day = d3
        days.push(dayobjectOther)
      }
//    console.log(dayObj.getMonth()+1==currentMonth)
      return {days,date};
    },
    isActive(day){
//  	console.log(this.headerDate)
    	if(this.startEnd==1){
    		if(day.getTime()==this.headerDate[0].getTime()){
    			return 'days-items days-start'
    		}
    	}else if(this.startEnd==2){
    		if(day.getTime()>this.headerDate[0].getTime()&&day.getTime()<this.headerDate[1].getTime()){
    			return 'days-items'
    		}else if(day.getTime()==this.headerDate[0].getTime()){
    			return 'days-items days-start'
    			
    		}else if(day.getTime()==this.headerDate[1].getTime()){
    			return 'days-items days-end'
    		}
    	}
    },
    
    showDay(d){
		let str=(d?d.getDate():this.currentTime.getDate())+'';
		if(!str[1]){
			str=0+str
		}
		return str
	},
    pickPre: function (year, month) {
      // setDate(0); 上月最后一天
      // setDate(-1); 上月倒数第二天
      // setDate(dx) 参数dx为 上月最后一天的前后dx天
      var d = new Date(this.formatDate(year, month, 1))
      d.setDate(0)
     return  this.initData(this.formatDate(d.getFullYear(), d.getMonth() + 1, 1))
    },
    pickNext: function (year, month) {
    	year=year+parseInt((month-1)/12);
    	month=month%12?month%12:12;
        var d = new Date(this.formatDate(year, month, 1))
        d.setDate(35)
        return  this.initData(this.formatDate(d.getFullYear(), d.getMonth() + 1, 1))
    },
    // 返回 类似 2016-01-02 格式的字符串
    formatDate: function (year, month, day) {
      var y = year
      var m = month
      if (m < 10) m = '0' + m
      var d = day
      if (d < 10) d = '0' + d
      return y + '-' + m + '-' + d
    }
  }
}
</script>
<style>
#calendar {
  width: 100%;
  background: black;
  margin: 0 auto;
  color:white;
  padding-bottom: 100px;
  box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.1),
    0 1px 5px 0 rgba(0, 0, 0, 0.12);
}
.month{
	width: 100%;
	color: white;
	opacity: 1;
	background: black;
	position: sticky;
	z-index: 100;
	top:0px;
}
.month ul {
  margin: 0;
  display: flex;
  justify-content: space-between;
  padding:1rem 1.5rem;
  
}
.year-fenge {
  font-size: 6rem;
  font-weight: 100;
}
.choose-month {
  text-align: center;
  font-size: 12px;
}
.month ul li {
  text-transform: uppercase;
  letter-spacing: 3px;
  color:white;
}
.weekdays {
  margin: 0;
  padding: 10px;
  display: flex;
  flex-wrap: wrap;
  color: white;
  font-size: 2.5rem;
  justify-content: space-around;
}
.weekdays li {
  display: inline-block;
  width: 13.6%;
  text-align: center;
}
.days {
  padding: 10px;
  margin: 0;
  display: flex;
  flex-wrap: wrap;
  box-sizing:border-box;
}
.days li {
  list-style-type: none;
  display: inline-block;
  width: 14.2%;
  height:32px;
  margin-top: 5px;
  line-height: 32px;
  box-sizing:border-box;
  text-align: center;
  font-size: 12px;
}
.days span.days-items{
	display: inline-block;
	height:32px;
	width:100%;
    color:black;
    background: white;
    border-left:1px solid;
    position: relative;
  	z-index: 99;
}
.days li .active {
  	display: inline-block;
	height:32px;
	width:100%;
    color:black;
    background: green;
    position: relative;
  	z-index: 99;
}
.days li .other-month {
  	display: inline-block;
	height:32px;
	width:100%;
    color:gray;
}
.days li:hover>span>span {
    padding: 6px 10px;
    border-radius: 50%;
    background: #e1e1e1;
    color: #fff;
}
.arrow{
	width:35%;
}
.calendar-details{
	width:100%;
}
.calendar-details .calendar-details-day{
	float: left;
	line-height: 60px;
	font-size: 8rem;
}
.calendar-details-month, .calendar-details-week{
	line-height: 30px;
}
.next-month{
	display: none;
}
.calendar-month{
	font-size: 4rem;
}
 .days-start:before{
 	content:'';
 	display: block;
 	width:70%;
 	height:32px;
 	background: #dcdcdc;
 	position: absolute;
 	z-index: -1;
 }
 .days-start:after{
 	content:'';
 	display: block;
 	width:0;
 	height:0;
 	border-width:16px 13px;
 	border-style: solid;
 	transform: translateX(50%);
 	border-color: transparent transparent transparent #dcdcdc;
 	position: absolute;
 	top:0;
 	right:0px;
 }
 .days-end:before{
 	content:'';
 	display: block;
 	width:70%;
 	height:32px;
 	background: #dcdcdc;
 	position: absolute;
 	z-index: -1;
 	right:0px;
 }
 .days-end:after{
 	content:'';
 	display: block;
 	width:0;
 	height:0;
 	border-width:16px 14px;
 	border-style: solid;
 	transform: translateX(-50%);
 	border-color: transparent #dcdcdc transparent transparent ;
 	position: absolute;
 	top:0;
 	left:0px;
 }
</style>
