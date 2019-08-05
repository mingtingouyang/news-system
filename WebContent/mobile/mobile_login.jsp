<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=375px,user-scalable=no" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css">
		<title>登录</title>
	</head>
	<body>
		<div class="bg">
			<div class="login">
				<div class="usrNpsw">
					<div class="input-div">
						<input type="text" class="username" placeholder="请输入用户名" autocomplete="off">
					</div>
					<div class="input-div">
						<input type="password" class="password" placeholder="请输入密码" autocomplete="off">
					</div>
				</div>
				<div class="info"></div>
				<div class="button signin" disabled="disabled">
					<span>登 录</span>
				</div>
				<div class="button signup">
					<span>注 册</span>
				</div>
			</div>
			<div class="newUser">
				<div class="usrNpsw">
					<div class="input-div">
						<input type="text" class="username" placeholder="请输入用户名" autocomplete="off">
					</div>
					<div class="input-div">
						<input type="password" class="password" placeholder="请输入密码" autocomplete="off">
					</div>
					<div class="input-div">
						<input type="password" class="repassword" placeholder="请再次输入密码" autocomplete="off">
					</div>
				</div>
				<div class="info"></div>
				<div class="button signup" disabled="disabled">
					<span >注 册</span>
				</div>
			</div>
		</div>
		<script src="<%=request.getContextPath() %>/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath() %>/js/login.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
