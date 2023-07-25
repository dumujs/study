(function(tool){
	function myAjax(obj = {}, callback){
		//first
		const xhr=new XMLHttpRequest();
		const method=obj.method;
		const isSync=obj.isSync;
		const url=obj.url;
		const data=obj.data;
		const {headSetting}=obj;
		//second
		if(isSync){
			xhr.open(method,url,isSync);
		}else{
			xhr.open(method,url);
		}
		if(headSetting){
			for(let key in headSetting){
				xhr.setRequestHeader(key,headSetting[key]);
			}
		}
		//third
		xhr.send(data?data:null);
		//fourth
		xhr.onreadystatechange=function(event){
			if(xhr.readyState==4){
				console.log(xhr.responseText);
				const returnData=xhr.responseText;
				callback&&callback(returnData);
			}
		}
	}
	tool.ajax=myAjax;
})(window.tool||{});
