(function(tool){
	function myAjax(obj callback){
		//first
		var xhr=new XMLHttpRequest();
		var mothed=obj.mothed;
		var isSync=obj.isSync;
		var url=obj.url;
		var data=obj.data;
		var headSetting=obj.headSetting;
		//second
		if(isSync){
			xhr.open(mothed,url,isSync);
		}else{
			xhr.open(mothed,url);
		}
		if(headSetting){
			for(key in headSetting){
				xhr.setRequestHeader(key,headSetting[key]);
			}
		}
		//third
		xhr.send(data?data:null);
		//fourth
		xhr.onreadystatechange=function(event){
			if(xhr.readyState==4){
				console.log(xhr.responseText);
				var returnData=xhr.responseText;
				callback&&callback(returnData);
			}
		}
	}
	var tool={};
	tool.ajax=myAjax;
})(window.tool||{});
