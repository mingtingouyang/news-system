<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>News Theme</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700|Roboto+Slab:300,400,700" rel="stylesheet">
		<link rel="stylesheet" href="css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<style>
			/* table 样式 */
			table {
				border-top: 1px solid #ccc;
				border-left: 1px solid #ccc;
			}
			table td,
			table th {
				border-bottom: 1px solid #ccc;
				border-right: 1px solid #ccc;
				padding: 3px 5px;
			}
			table th {
				border-bottom: 2px solid #ccc;
				text-align: center;
			}

			/* blockquote 样式 */
			blockquote {
				display: block;
				border-left: 8px solid #d0e5f2;
				padding: 5px 10px;
				margin: 10px 0;
				line-height: 1.4;
				font-size: 100%;
				background-color: #f1f1f1;
			}

			/* code 样式 */
			code {
				display: inline-block;
				*display: inline;
				*zoom: 1;
				background-color: #f1f1f1;
				border-radius: 3px;
				padding: 3px 5px;
				margin: 0 3px;
			}
			pre code {
				display: block;
			}

			/* ul ol 样式 */
			ul, ol {
				margin: 10px 0 10px 20px;
			}
			.content{
				width: 700px;
				margin:10px auto;
				padding-bottom: 20px;
				border-bottom: 1px solid #cccccc;
				line-height: 30px;
			}
			.content img{
				width: 100%;
				height: auto
			}
			h1{
				text-align: center;
				font-weight: 500;
				font-size: 50px;
				margin: 20px 0;
			}
			.info{
				text-align: center;
				margin:10px 30px;
				padding-bottom: 10px;
				border-bottom: 1px solid #cccccc;
			}
			.info span{
				margin: 0 20px;
				color: #252525;
			}
		</style>
	</head>
	<body>
		<header>
			<div class="main-menu">
				<div class="container">
					<nav class="navbar navbar-expand-lg navbar-light">
						<a class="navbar-brand" href="<%=request.getContextPath() %>/home"><img src="images/logo.png" alt="logo"></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav ml-auto">
								<li class="nav-item">
									<a href="<%=request.getContextPath() %>/category?c=国际" class="nav-link">国际</a>
								</li>
								<li class="navbar-item">
									<a href="<%=request.getContextPath() %>/category?c=两岸" class="nav-link">两岸</a>
								</li>
								<li class="navbar-item">
									<a href="<%=request.getContextPath() %>/category?c=科技" class="nav-link">科技</a>
								</li>
								<li class="navbar-item">
									<a href="<%=request.getContextPath() %>/category?c=财经" class="nav-link">财经</a>
								</li>
								<li class="navbar-item">
									<a href="<%=request.getContextPath() %>/category?c=体育" class="nav-link">体育</a>
								</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</header>
		<h1>${article.title }</h1>
		<div class="info">
			<span class="author">作者：${article.author }</span>
			<span class="time">修改时间：${article.time }</span>
		</div>
		<div class="content">
			${article.content }	
		</div>

		<footer>
			<div class="footer_copyright">
				<div class="container">
					<div class="row">
						<div class="col-lg-6 col-md-4 logo-side">
							<img src="images/logo.png" alt="logo">
						</div>
						<div class="col-lg-6 col-md-8">
							<h5 class="copy-right">Copyright &copy; 2018.Company name All rights reserved.</h5>
						</div>
					</div>
				</div>
			</div>
		</footer>

		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js">
		</script>
		<script defer src="js/all.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
	</body>
</html>