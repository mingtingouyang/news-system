<%@page import="jdbc.pojo.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=375px,user-scalable=no" />
    <title></title>
    <script src="<%=request.getContextPath() %>/js/mui.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <link href="<%=request.getContextPath() %>/css/mui.min.css" rel="stylesheet"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index.css">
    <script type="text/javascript" charset="utf-8">
      	mui.init();
    </script>
</head>
<body>
	<nav class="mui-bar mui-bar-tab">
		<a href="#tabbar-news" class="mui-tab-item mui-active">
			<span class="mui-icon mui-icon-news"></span>
			<span class="mui-tab-label">新闻</span>
		</a>
		<a href="#tabbar-friend" class="mui-tab-item">
			<span class="mui-icon mui-icon-friend"></span>
			<span class="mui-tab-label">好友</span>
		</a>
		<a href="#tabbar-moment" class="mui-tab-item">
			<span class="mui-icon mui-icon-moment"></span>
			<span class="mui-tab-label">朋友圈</span>
		</a>
		<a href="#tabbar-info" class="mui-tab-item">
			<span class="mui-icon mui-icon-userinfo"></span>
			<span class="mui-tab-label">资料</span>
		</a>
	</nav>
	<div class="mui-content">
		<div id="tabbar-news" class="mui-control-content mui-active">
			<!--新闻内容  -->
		</div>
		<div id="tabbar-friend" class="mui-control-content">
			<!-- 好友搜索 -->
			<form action="search" method="post">
				<div class="username">
					<input placeholder="请输入要查找的用户名" name="username" type="text">
				</div>
				<div class="search">
					<input type="submit" value=""/>
				</div>
			</form>
			<div class="request">
			</div>
			<ul class="friend-list">
			</ul>
		</div>
		<div id="tabbar-moment" class="mui-control-content">
			<div class="mui-input-row">
				<textarea rows="5" id="moment" placeholder="发布新动态"></textarea>
			</div>
			<button id="send" type="button" class="mui-btn mui-btn-primary" disabled="disabled">发送</button>
		</div>
		<div id="tabbar-info" class="mui-control-content">
			<div class="userimg">
				<img src="<%=request.getContextPath() %>/userimg/${member.getUserimg()}" alt="">
			</div>
			<div class="mui-card">
				<form class="mui-input-group" id="userinfo" enctype="multipart/form-data">
					<input type="text" value="${member.getUsername()}" name="username" hidden="hidden">
					<div class="mui-input-row">
						<label>用户名</label>
						<input type="text" disabled="disabled" value="${member.getUsername()}" style="color: #CCCCCC;">
					</div>
					<div class="mui-input-row">
						<label>头像</label>
						<input type="file" name="userimg" style="margin: 5px 0;">
					</div>
					<h5 class="mui-content-padded">性别</h5>
					<div class="mui-input-row mui-radio">
						<label>男生</label>
						<%if(((Member)request.getSession().getAttribute("member")).getGender().equals("male")) {%>
							<input name="gender" type="radio" value="male" checked="checked">
						<%}else{ %>
							<input name="gender" type="radio" value="male">
						<%} %>
					</div>
					<div class="mui-input-row mui-radio">
						<label>女生</label>
						<%if(((Member)request.getSession().getAttribute("member")).getGender().equals("female")) {%>
							<input name="gender" type="radio" value="female" checked="checked">
						<%}else{ %>
							<input name="gender" type="radio" value="female">
						<%} %>
					</div>
					<h5 class="mui-content-padded">联系资料</h5>
					<div class="mui-input-row">
						<label>手机</label>
						<input type="text" name="phone" value="${member.getPhone()}">
					</div>
					<div class="mui-input-row">
						<label>邮箱</label>
						<input type="text" name="email" value="${member.getEmail()}">
					</div>
					<div class="mui-input-row">
						<label>地址</label>
						<input type="text" name="address" value="${member.getAddress()}">
					</div>
					<h5 class="mui-content-padded">修改密码</h5>
					<div class="mui-input-row">
						<label>密码</label>
						<input type="password" id="password" name="password" value="${member.getPassword()}">
					</div>
					<div class="mui-input-row">
						<label>重复密码</label>
						<input type="password" id="repassword" name="repassword" value="${member.getPassword()}">
					</div>
					<div class="mui-button-row">
						<button type="button" class="mui-btn mui-btn-primary" id="upload" >更新</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath() %>/js/index.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>