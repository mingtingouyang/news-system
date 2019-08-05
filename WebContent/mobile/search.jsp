<%@page import="jdbc.pojo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=375px,user-scalable=no" />
		<title></title>
		<script src="<%=request.getContextPath() %>/js/mui.min.js"></script>
		<link href="<%=request.getContextPath() %>/css/mui.min.css" rel="stylesheet"/>
		<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
		<link href="<%=request.getContextPath() %>/css/search.css" rel="stylesheet"/>
		<script type="text/javascript" charset="utf-8">
		  	mui.init();
		</script>
	</head>
	<body>
		<div id="search-detail">
			<header class="mui-bar mui-bar-nav">
				<a href="" class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
				<h1 class="mui-title">搜索结果</h1>
			</header>
			<div class="mui-content">
				<ul class="friend-list">
					<%List<Member> members = (List<Member>)request.getAttribute("members"); %>
					<%for(int i = 0; i < members.size(); i++){ 
						if(!((Member)request.getSession().getAttribute("member")).getUsername().equals(members.get(i).getUsername())) {
					%>
							<li>
								<span class="userimg" style="background-image: url(<%=request.getContextPath() %>/userimg/<%=members.get(i).getUserimg()%>);"></span>
								<span class="user"><%=members.get(i).getUsername()%></span>
								<a onclick="remove(this)" href="javascript:;" class="delete"></a>
							</li>
					<%	}
					} %>
				</ul>
			</div>
		</div>
		<script>
			// 添加好友
			function remove(object){
				$.ajax({
					url:"search",
					method:"POST",
					data:{
						add:$(object).parents("li").find(".user").html()
					},
					success:function(res){
						if(res == "yes"){
							$(object).parents("li").remove();
							mui.toast('已经发送申请',{ duration:'long', type:'div' }) 
						} else{
							mui.toast('对方已经是你的好友',{ duration:'long', type:'div' }) 
						}
						
					}
				})
			}
		</script>
	</body>
</html>