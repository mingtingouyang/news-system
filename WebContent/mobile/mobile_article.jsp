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
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/article.css">
		<script type="text/javascript" charset="utf-8">
		  	mui.init();
		</script>
	</head>
	<body>
		<div id="article-detail">
			<header class="mui-bar mui-bar-nav">
				<a href="" class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
				<h1 class="mui-title">文章详情</h1>
			</header>
			<div class="mui-content">
				<h1>${article.getTitle() }</h1>
				<div class="info"><span>作者：${article.getAuthor() }</span><span>修改时间：${article.getTime() }</span></div>
				<div class="article-content">
					${article.getContent() }
				</div>
			</div>
			<div class="comment">
				<input type="text" hidden="hidden" value="${article.getId()}" id="hidden-id">
				<h5>评论</h5>
				<div class="mui-input-row">
					<textarea rows="5" id="comment" placeholder="发布评论"></textarea>
				</div>
				<button id="send" type="button" class="mui-btn mui-btn-primary" disabled="disabled">发送</button>
				<h5>评论区</h5>
			</div>
		</div>
		<script src="<%=request.getContextPath() %>/js/article.js"></script>
	</body>
</html>