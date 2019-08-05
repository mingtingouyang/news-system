$(".login .signup").click(function(){
	$(".login").css("left","-100vw")
	$(".newUser").css("left","0")
})

// 注册页面密码输入相同验证
$(".newUser .usrNpsw").on("input",function(){
	if($(".newUser .username").val() != '' && $(".newUser .password").val() != '' && $(".newUser .repassword").val() == $(".newUser .password").val()) {
		$(".newUser .signup").css("backgroundColor","rgba(0,0,0,0.7)").attr("disabled",false)
	} else {
		$(".newUser .signup").css("backgroundColor","rgba(0,0,0,0.3)").attr("disabled","disabled")
	}
})
$(".newUser .signup").on('click',function(){
	if($(".newUser .signup").attr("disabled") != "disabled"){
		// 点击注册按钮后执行服务器通信
		$.ajax({
			url:"signup",
			method:"POST",
			data:{
				username:$(".newUser .username").val(),
				password:$(".newUser .password").val()
			},
			success:function(res){
				if(res == "yes"){
					$(".login").css("left","0")
					$(".newUser").css("left","100vw")
				}else{
					$(".newUser .info").html("<span>用户名已存在</span>")
				}
			}
		})
	}
});


//登陆界面有效输入验证
$(".login .usrNpsw").on("input",function(){
	if($('.login .username').val() != '' && $('.login .password').val() != ''){
		$(".login .signin").css("backgroundColor","rgba(0,0,0,0.7)").attr("disabled",false)
	} else {
		$(".login .signin").css("backgroundColor","rgba(0,0,0,0.3)").attr("disabled","disabled")
	}
})

$(".login .signin").on('click',function(){
	if($('.login .signin').attr("disabled") != "disabled"){
		// 点击登录按钮后执行服务器通信
		$.ajax({
			url:"login",
			method:"POST",
			data:{
				username:$(".login .username").val(),
				password:$(".login .password").val()
			},
			success:function(res){
				if(res == "yes"){
					location.href = "home"
				}else{
					$(".login .info").html("<span>密码错误或账号不存在</span>")
				}
			}
		})
	}
});