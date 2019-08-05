<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>会员注册-明日头条后台管理系统-WeAdmin 1.0</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="shortcut icon" href="<%=request.getContextPath() %>/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/font.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/weadmin.css">
<script src="<%=request.getContextPath() %>/lib/layui/layui.js" charset="utf-8"></script>
</head>
<body class="login-bg">
	<div class="login">
        <div class="message">会员注册</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" action="<%=request.getContextPath()%>/admin/member/signup">
            <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input name="repassword" lay-verify="required" placeholder="重复密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input disabled="disabled" style="background-color: #ccc" class="loginin" value="注册" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
            <div class = "info">
            	请输入用户名、密码注册。
            </div>
        </form>
    </div>

    <script type="text/javascript">
    	let username = document.querySelector("input[name=username]")
    	let password = document.querySelector("input[name=password]")
    	let repassword = document.querySelector("input[name=repassword]")
    	let submit = document.querySelector(".loginin")
    	let info = document.querySelector(".info")
    	repassword.oninput = function(){
    		if(password.value == ''){
    			info.innerHTML = "密码不能为空"
       			submit.disabled = "disabled"
       			submit.style.backgroundColor = "#CCC"
       			password.style.backgroundColor = "indianred"
       			repassword.style.backgroundColor = "indianred"
    		}else if(repassword.value == password.value && username.value != ''){
    			info.innerHTML = "请点击注册按钮"
    			submit.disabled = false
    			submit.style.backgroundColor = "#189f92"
    			repassword.style.backgroundColor = "rgb(232, 240, 254)"
    		}else{
    			info.innerHTML = "两次输入的密码不相同"
        		submit.disabled = "disabled"
       			submit.style.backgroundColor = "#CCC"
        		repassword.style.backgroundColor = "indianred"
    		}
    	}
    	password.oninput = function(){
    		if(password.value != ''){
    			password.style.backgroundColor = "rgb(232, 240, 254)"
    		}
    		if(password.value == ''){
    			info.innerHTML = "密码不能为空"
           			submit.disabled = "disabled"
           			submit.style.backgroundColor = "#CCC"
           			password.style.backgroundColor = "indianred"
           			repassword.style.backgroundColor = "indianred"
    		}else if(repassword.value == password.value && username.value != ''){
    			info.innerHTML = "请点击注册按钮"
    			submit.disabled = false
    			submit.style.backgroundColor = "#189f92"
    			repassword.style.backgroundColor = "rgb(232, 240, 254)"
    		}else{
    			info.innerHTML = "两次输入的密码不相同"
        		submit.disabled = "disabled"
        		submit.style.backgroundColor = "#CCC"
        		repassword.style.backgroundColor = "indianred"
    		}
    	}
    	username.oninput = function(){
    		if(username.value != ''){
    			info.innerHTML = "请输入用户名、密码注册"
    			username.style.backgroundColor = "rgb(232, 240, 254)"
    		}else{
    			info.innerHTML = "请输入用户名"
        		username.style.backgroundColor = "indianred"
    		}
    	}
    </script>  
    <!-- 底部结束 -->
</body>
</html>