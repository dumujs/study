define(['jquery'],function(){
	id=localStorage.id;
	$.ajax({
				type:"post",
				url:"http://localhost:3000/users/getone",
				data:{_id:id},
				async:true,
				success:function(data){
					//直接删除；
					$('#mend').css('display','block');
					$('#mend .username').val(data.willOne.username);
					$('#mend .age').val(data.willOne.age);
					$('#mend .score').val(data.willOne.score);
					$('#mend .baocun').attr('data-id',id);
					
					/*$.ajax({
							type:"get",
							url:"http://localhost:3000/users/form",
							async:true,
							success:function(data){
								show(data);
							}
						});*/
				}
			});
	$('#mend .baocun').click(function(){
		var obj={
			username:$('.username').val(),
			age:$('.age').val(),
			score:$('.score').val(),
			_id:id
		};
		console.log(obj);
		if(obj.username&&obj.age&&obj.score){
			$.ajax({
				type:"post",
				url:"http://localhost:3000/users/put",
				data:obj,
				async:true,
				success:function(data){
					console.log(data);
					window.location.href='./index.html';
				}
				
			});
		}
	})
})