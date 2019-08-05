//评论内容不为空验证
$('#comment').on('input',function(){
	if($('#comment').val() != ''){
		$('#send').attr("disabled",false)
	}else{
		$('#send').attr("disabled","disabled")
	}
})
//发送评论
$('#send').click(function(){
	if($('#send').attr("disabled") != "disabled"){
		$.ajax({
			url:'newcomment',
			method: 'POST',
			data:{
				content:$('#comment').val(),
				id:$('#hidden-id').val()
			},
			success:function(res){
				mui.toast('发送成功',{ duration:'long', type:'div' })
				$('.comment').append(`
					<div class="comment-item">
						<div class="head">
							<img src="/TodayNews/userimg/${res[1]}" alt="" class="userimg">
							<div class="info">
								<h3>${res[0]}</h3>
								<h5>刚刚</h5>
							</div>
						</div>
						<div class="content">
							${$('#comment').val()}
						</div>
					</div>		
				`)
				$('#comment').val("") 
			}
		})
	}
})

//初始化评论区
$.get('getcomment?id='+$('#hidden-id').val()).then(function(res){
	for(let i = 0; i < res.length; i++){
		$('.comment').append(`
			<div class="comment-item">
				<div class="head">
					<img src="/TodayNews/userimg/${res[i].userimg}" alt="" class="userimg">
					<div class="info">
						<h3>${res[i].username}</h3>
						<h5>${res[i].time}</h5>
					</div>
				</div>
				<div class="content">
					${res[i].content}
				</div>
			</div>		
		`)
	}
})
