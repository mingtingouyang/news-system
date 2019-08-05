$.get("getrequest").then(function(res){
	if(res == "yes"){
		$(".request").append(`
			<a href="requestlist" class="notification">您收到了好友申请</a>	
		`)
	}
})

$.get("getfriend").then(function(res){
	$(".friend-list").html("");
	for(let i = 0; i < res.length; i++){
		$(".friend-list").append(`
				<li>
					<span class="userimg" style="background-image: url(/TodayNews/userimg/${res[i].userimg});"></span>
					<span class="user">${res[i].username}</span>
					<a onclick="remove(this)" href="javascript:;" class="delete"></a>
				</li>
		`)
	}
})

$.get("getnews").then(function(res){
	$("#tabbar-news").html("");
	for(let i = 0; i < res.length; i++){
		$("#tabbar-news").append(`
			<div class="mui-card">
			<div class="mui-card-header mui-card-meidia" style="height:40vw;background-image:url(/TodayNews/articleimg/${res[i].img})"></div>
			<div class="mui-card-content">
				<div class="mui-card-content-inner">
					<p>Posted on ${res[i].time}</p>
					<p style="color:#333">${res[i].title}</p>
				</div>
			</div>
			<div class="mui-card-footer">
				<a href="getarticle?c=${res[i].category}&id=${res[i].id}" class="mui-card-link">Read more</a>
			</div>
			</div>
		`);
	}
})

// 删除好友
function remove(object){
	$.ajax({
		url:"delete",
		method:"POST",
		data:{
			del:$(object).parents("li").find(".user").html()
		},
		success:function(res){
			$(object).parents("li").remove();
			mui.toast('成功删除好友',{ duration:'long', type:'div' }) 
		}
	})
}

//密码相同验证
$('#userinfo').on('input',function(){
	if($('#userinfo #password').val() != '' && $('#userinfo #password').val() == $('#userinfo #repassword').val()){
		$('#upload').attr('disabled',false)
	}else{
		$('#upload').attr('disabled','disabled')
	}
})

//修改个人资料
$('#upload').click(function(){
	if($('#upload').attr("disabled") != "disabled"){
		$.ajax({
		    url: 'edit',
		    type: 'POST',
		    cache: false,
		    data: new FormData($('#userinfo')[0]),
		    processData: false,
		    contentType: false,
		    success: function(){
		    	mui.toast('修改成功',{ duration:'long', type:'div' }) 
		    }
		})
	}
})

//朋友圈内容不为空验证
$('#moment').on('input',function(){
	if($('#moment').val() != ''){
		$('#send').attr("disabled",false)
	}else{
		$('#send').attr("disabled","disabled")
	}
})

//发送朋友圈
$('#send').click(function(){
	if($('#send').attr("disabled") != "disabled"){
		$.ajax({
			url:'newmoment',
			method: 'POST',
			data:{
				content:$('#moment').val(),
			},
			success:function(res){
				mui.toast('发送成功',{ duration:'long', type:'div' })
				$(`
					<div class="moment-item">
						<div class="head">
							<img src="/TodayNews/userimg/${res[1]}" alt="" class="userimg">
							<div class="info">
								<h3>${res[0]}</h3>
								<h5>刚刚</h5>
							</div>
						</div>
						<div class="content">
							${$('#moment').val()}
						</div>
					</div>
				`).insertAfter('#send')
				$('#moment').val("")
			}
		})
	}
})

//初始化朋友圈
$.get('getmoment').then(function(res){
	for(let i = 0; i < res.length; i++){
		$(`
			<div class="moment-item">
				<div class="head">
					<img src="/TodayNews/userimg/${res[i].authorimg}" alt="" class="userimg">
					<div class="info">
						<h3>${res[i].author}</h3>
						<h5>${res[i].time}</h5>
					</div>
				</div>
				<div class="content">
					${res[i].content}
				</div>
			</div>
		`).insertAfter('#send')
	}
})



