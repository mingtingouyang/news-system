<%@page import="jdbc.pojo.Article"%>
<%@page import="jdbc.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>文章列表-明日头条后台管理系统-WeAdmin 1.0</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/font.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/weadmin.css">
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>

	<body>
		<div class="weadmin-nav">
			<span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">文章管理</a>
        <a>
          <cite>文章列表</cite></a>
      </span>
			<a class="layui-btn layui-btn-sm" style="line-height:1.6em;margin-top:3px;float:right" href="<%=request.getContextPath() %>/admin/articlelist" title="刷新">
				<i class="layui-icon" style="line-height:30px">ဂ</i></a>
		</div>
		<div class="weadmin-body">
			<div class="layui-row">
				<form class="layui-form layui-col-md12 we-search" method="POST" action="<%=request.getContextPath() %>/admin/articlelist">
				<!-- 
					<div class="layui-inline">
						<input class="layui-input" placeholder="开始日" name="start" id="start">
					</div>
					<div class="layui-inline">
						<input class="layui-input" placeholder="截止日" name="end" id="end">
					</div>
			 	-->	
					<div class="layui-inline">
						<input type="text" name="search" placeholder="请输入文章名" autocomplete="off" class="layui-input">
					</div>
					<button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
				</form>
			</div>
			<div class="weadmin-block">
				<button class="layui-btn" onclick="WeAdminShow('添加文章','<%=request.getContextPath() %>/admin/article/new')"><i class="layui-icon"></i>添加</button>
				<span class="fr" style="line-height:40px">共有数据：${totalArticles} 条</span>
			</div>
			<table class="layui-table">
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
						</th>
						<th>ID</th>
						<th>标题</th>
						<th>作者</th>
						<th>分类</th>
						<th>封面图片</th>
						<th>修改时间</th>
						<th>状态</th>
						<th>操作</th>
				</thead>
				<tbody>
					<%
						List<Article> articles = ((List<Article>)request.getAttribute("articles"));
						for(int i = 0; i < articles.size(); i++) {
					%>
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
						</td>
						<td class="id"><%=articles.get(i).getId()%></td>
						<td><%=articles.get(i).getTitle()%></td>
						<td><%=articles.get(i).getAuthor()%></td>
						<td><%=articles.get(i).getCategory()%></td>
						<td><img style="width:auto;height:90px" src="<%=request.getContextPath()%>/articleimg/<%=articles.get(i).getImg() %>"></td>
						<td><%=articles.get(i).getTime() %></td>
						<td class="td-status">
							<%if(articles.get(i).getStatus().equals("active")){%>
								<span class="layui-btn layui-btn-normal layui-btn-xs">已启用</span></td>
							<%} else {%>
								<span class="layui-btn layui-btn-normal layui-btn-xs layui-btn-disabled">已停用</span></td>
							<%} %>
						<td class="td-manage">
							<%if(articles.get(i).getStatus().equals("active")){%>
								<a onclick="member_stop(this,'10001')" href="javascript:;" title="停用">
								<i class="layui-icon">&#xe601;</i>
							</a>
							<%} else {%>
								<a onclick="member_stop(this,'10001')" href="javascript:;" title="启用">
								<i class="layui-icon">&#xe62f;</i>
							</a>
							<%} %>
							<a title="编辑" onclick="WeAdminShow('编辑','<%=request.getContextPath()%>/admin/article/edit?edit=<%=articles.get(i).getId() %>')" href="javascript:;">
								<i class="layui-icon">&#xe642;</i>
							</a>
							<a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
								<i class="layui-icon">&#xe640;</i>
							</a>
						</td>
					</tr>
					<%} %>
				</tbody>
			</table>
			<div class="page">
				<div>
				
				<%if((Integer)(request.getAttribute("page")) != 1) {%>
					<a class="prev" href="<%=request.getContextPath() %>/admin/articlelist?page=${page - 1}">&lt;&lt;</a>
					<a class="num" href="<%=request.getContextPath() %>/admin/articlelist?page=${page - 1}">${page - 1 }</a>
				<%} %>
					<span class="current">${page }</span>
				<%if((Integer)(request.getAttribute("page")) != (Integer)(request.getAttribute("totalPage"))) {%>
					<a class="num" href="<%=request.getContextPath() %>/admin/articlelist?page=${page + 1}">${page + 1 }</a>
				<%} %>
				<%if((Integer)(request.getAttribute("page")) < (Integer)(request.getAttribute("totalPage")) - 1) {%>
					<span class="num">...</span>
					<a class="num" href="<%=request.getContextPath() %>/admin/articlelist?page=${totalPage }">${totalPage }</a>
				<%} %>
				<%if((Integer)(request.getAttribute("page")) != (Integer)(request.getAttribute("totalPage"))) {%>
					<a class="next" href="<%=request.getContextPath() %>/admin/articlelist?page=${page + 1}">&gt;&gt;</a>
				<%} %>
				
				</div>
			</div>
		</div>
		<script src="<%=request.getContextPath() %>/lib/layui/layui.js" charset="utf-8"></script>
		<script>	
			layui.extend({
				admin: '<%=request.getContextPath() %>/static/js/admin'
			});
			layui.use(['laydate', 'jquery', 'admin'], function() {
				var laydate = layui.laydate,
					$ = layui.jquery,
					admin = layui.admin;
				//执行一个laydate实例
				laydate.render({
					elem: '#start' //指定元素
				});
				//执行一个laydate实例
				laydate.render({
					elem: '#end' //指定元素
				});
				/*用户-停用*/
				window.member_stop = function (obj, id) {
					layer.confirm('确认要更改吗？', function(index) {
						if($(obj).attr('title') == '停用') {

							//发异步把用户状态进行更改
							$(obj).attr('title', '启用')
							$(obj).find('i').html('&#xe62f;');

							$(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
							layer.msg('已停用!', {
								icon: 5,
								time: 1000
							});
							let id = $(obj).parents("tr").find(".id").html();
							$.ajax({
								url:"<%=request.getContextPath() %>/admin/articlelist",
								method:"POST",
								data:{
									susp: id
								}
							})
						} else {
							$(obj).attr('title', '停用')
							$(obj).find('i').html('&#xe601;');

							$(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
							layer.msg('已启用!', {
								icon: 1,
								time: 1000
							});
							let id = $(obj).parents("tr").find(".id").html();
							$.ajax({
								url:"<%=request.getContextPath() %>/admin/articlelist",
								method:"POST",
								data:{
									recv: id
								}
							})
						}
					});
				}

				/*用户-删除*/
				window.member_del = function (obj, id) {
					layer.confirm('确认要删除吗？', function(index) {
						//发异步删除数据
						$(obj).parents("tr").remove();
						layer.msg('已删除!', {
							icon: 1,
							time: 1000
						});
						let id = $(obj).parents("tr").find(".id").html();
						$.ajax({
							url:"<%=request.getContextPath() %>/admin/articlelist",
							method:"POST",
							data:{
								del: id
							}
						})
					});
				}

				window.delAll = function (argument) {
					var data = tableCheck.getData();
					layer.confirm('确认要删除吗？' + data, function(index) {
						//捉到所有被选中的，发异步进行删除
						layer.msg('删除成功', {
							icon: 1
						});
						$(".layui-form-checked").not('.header').parents('tr').remove();
					});
				}
			});
		</script>
		<%-- 
    	<script src="<%=request.getContextPath() %>/static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>
    	--%>
	</body>

</html>