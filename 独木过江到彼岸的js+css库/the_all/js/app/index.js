
define(['jquery','app/cart'] ,function($,cart){
//	console.log($);
	$('#submit').click(function(event){
		event.preventDefault();
		var obj={
			username:$('#username').val(),
			age:$('#age').val(),
			score:$('#score').val()
		}
		if(obj.username&&obj.age&&obj.score){
			$.ajax({
				type:"post",
				url:"http://localhost:3000/users/add",
				data:obj,
				async:true, 
				success:function(data){
					if(data._id){
						$.ajax({
							type:"get",
							url:"http://localhost:3000/users/form",
							async:true,
							success:function(data){
								show(data);
							}
						});
					}
				}
			});
		}
		else{
			alert('')
		}
	});
	function show(data){
		$('#container').css('display','none');
		$('#showScore').css('display','block');
		var str='';
		var handleStr='';
		data.forEach(function(value,index){
			str+='<tr data-id="'+value._id+'">';
			str+='<td>'+'<input type="checkbox" class="selByCheck"/>'+'</td>';
			str+='<td>'+value.username+'</td>';
			str+='<td>'+value.age+'</td>';
			str+='<td>'+value.score+'</td>';
			str+='<td class="line-del">'+'删除'+'</td>';
			str+='<td class="mend" >'+'修改'+'</td>';
			str+='</tr>';
		});
//		console.log($('#showScore tbody'));
		$('#showScore tbody').html(str);
		handleStr='<button id="addone">增加</button><button id="del">删除</button><label>查找</label><input type="text"/ >';
		$('#handle').html(handleStr).css('display','block');
	};
	//事件
	$('#showScore tbody').click(function(event){
		if(event.target.className=='line-del'){
			var that=event.target;
			var id=$(event.target).parents('tr').attr('data-id');
			$.ajax({
				type:"post",
				url:"http://localhost:3000/users/del",
				data:{_id:id},
				async:true,
				success:function(data){
					//直接删除；
					$(that).parents('tr').remove();
					alert(data.count);
					
					//从新渲染
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
		}
		else if(event.target.className=='mend'){
			var that=event.target;
			var id=$(event.target).parents('tr').attr('data-id');
			localStorage.id=id;
			console.log(id)
			window.location.href='./page.html';
		}
	});
	$('#showScore').click(function(event){
		if(event.target.id=='del'){
			var obj={};
			var i=0;
			$('#showScore tbody input:checked').each(function(index,value){
				obj[i]=$(value).parents('tr').attr('data-id');
				i++;
			});
//			console.log(obj);
			$('#showScore tbody input:checked').parents('tr').remove();
			$.ajax({
					type:"post",
					url:"http://localhost:3000/users/del",
					data:obj,
					async:true,
					success:function(data){
						//直接删除；
						console.log(data);
						alert('删除'+data.deletedCount+'个')
					
						//从新渲染
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
		}
	});
	
	$('#showScore thead #allsel').click(function(event){
		$('#showScore tbody input').prop('checked',$(this).prop('checked'))
	})
})
