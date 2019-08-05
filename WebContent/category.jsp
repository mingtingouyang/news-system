<%@page import="jdbc.pojo.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>明日头条</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700|Roboto+Slab:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <style>
    	.page a{
    		margin:10px;
    	}
    	.page .current{
    		margin:10px;
    		color:red;
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
                        	<%if(request.getAttribute("category").equals("国际")){ %>
	                            <li class="nav-item active">
	                                <a href="<%=request.getContextPath() %>/category?c=国际" class="nav-link">国际</a>
	                            </li>
	                        <%} else{%>
	                        	<li class="nav-item">
	                                <a href="<%=request.getContextPath() %>/category?c=国际" class="nav-link">国际</a>
	                            </li>
	                        <%} %>
                            <%if(request.getAttribute("category").equals("两岸")){ %>
	                            <li class="nav-item active">
	                                <a href="<%=request.getContextPath() %>/category?c=两岸" class="nav-link">两岸</a>
	                            </li>
	                        <%} else{%>
	                        	<li class="nav-item">
	                                <a href="<%=request.getContextPath() %>/category?c=两岸" class="nav-link">两岸</a>
	                            </li>
	                        <%} %>
                            <%if(request.getAttribute("category").equals("科技")){ %>
	                            <li class="nav-item active">
	                                <a href="<%=request.getContextPath() %>/category?c=科技" class="nav-link">科技</a>
	                            </li>
	                        <%} else{%>
	                        	<li class="nav-item">
	                                <a href="<%=request.getContextPath() %>/category?c=科技" class="nav-link">科技</a>
	                            </li>
	                        <%} %>
                           	<%if(request.getAttribute("category").equals("财经")){ %>
	                            <li class="nav-item active">
	                                <a href="<%=request.getContextPath() %>/category?c=财经" class="nav-link">财经</a>
	                            </li>
	                        <%} else{%>
	                        	<li class="nav-item">
	                                <a href="<%=request.getContextPath() %>/category?c=财经" class="nav-link">财经</a>
	                            </li>
	                        <%} %>
                            <%if(request.getAttribute("category").equals("体育")){ %>
	                            <li class="nav-item active">
	                                <a href="<%=request.getContextPath() %>/category?c=体育" class="nav-link">体育</a>
	                            </li>
	                        <%} else{%>
	                        	<li class="nav-item">
	                                <a href="<%=request.getContextPath() %>/category?c=体育" class="nav-link">体育</a>
	                            </li>
	                        <%} %>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </header>
    <section class="blog-sec">
        <div class="container">
            <div class="main-content">
                <h1>${category }</h1>
                <%List<Article> articles =  (List<Article>)request.getAttribute("articles");%>
                <%for(int i = 0; i < articles.size(); i++){ %>
	                <div class="post_item">
	                    <img src="<%=request.getContextPath() %>/articleimg/<%=articles.get(i).getImg()%>">
	                    <a href="<%=request.getContextPath() %>/category?page=1&c=<%=articles.get(i).getCategory()%>" class="category-ttl"><%=articles.get(i).getCategory()%></a>
	                    <div class="shared-sec right">
	                        
	                    </div>
	                    <h2><a href="<%=request.getContextPath() %>/page?id=<%=articles.get(i).getId()%>"><%=articles.get(i).getTitle()%></a></h2>
	                    <ul class="post-tools">
	                        <li class="admin"><%=articles.get(i).getAuthor()%></li>
	                        <li class="date"><%=articles.get(i).getTime()%></li>
	                    </ul>
	                    <h6>Lorem Ipsum is simply dummy text of the printing and typetook a galley of type and scrambled it to make a type <a href="#">specimen book</a>. It has survived not only fiveLorem Ipsum is simply dummy text of the printing and typetook a galley of type and scrambled it to make a type specimen book. It has survived not only </h6> 
	                </div>
                <%} %>
                <div class="page">
					<div>
					
						<%if((Integer)(request.getAttribute("page")) != 1) {%>
							<a class="prev" href="<%=request.getContextPath() %>/category?page=${page - 1}&c=${category}">&lt;&lt;</a>
							<a class="num" href="<%=request.getContextPath() %>/category?page=${page - 1}&c=${category}">${page - 1 }</a>
						<%} %>
							<span class="current">${page }</span>
						<%if((Integer)(request.getAttribute("page")) != (Integer)(request.getAttribute("totalPage"))) {%>
							<a class="num" href="<%=request.getContextPath() %>/category?page=${page + 1}&c=${category}">${page + 1 }</a>
						<%} %>
						<%if((Integer)(request.getAttribute("page")) < (Integer)(request.getAttribute("totalPage")) - 1) {%>
							<span class="num">...</span>
							<a class="num" href="<%=request.getContextPath() %>/category?page=${totalPage }&c=${category}">${totalPage }</a>
						<%} %>
						<%if((Integer)(request.getAttribute("page")) != (Integer)(request.getAttribute("totalPage"))) {%>
							<a class="next" href="<%=request.getContextPath() %>/category?page=${page + 1}&c=${category}">&gt;&gt;</a>
						<%} %>
					
					</div>
				</div>
            </div>
            <aside class="aside-sec">
                <div class="ads-sec">
                    <h2>Advertisement</h2>
                    <img src="images/600-ad.jpg" alt="ad">
                </div>
                <div class="popular-posts">
                    <h2>Popular Posts</h2>
                    <div class="p_post-item">
                        <div class="img-sec">
                            <img src="images/pop-post1.jpg" alt="pop-post">
                            <a href="#" class="category-ttl">Health</a>
                        </div>
                        <h3>Girl walking on the road in early morning for mood.</h3>
                        <h6>Lorem Ipsum is simply dummy text of the printing and typesetbeen the industry's standard dummy text ever since the 1500s, when an unknown printer</h6>
                        <ul class="post-tools">
                            <li class="admin"><a href="#">Admin </a></li>
                            <li class="date">23 Jan 2018</li>
                        </ul>
                    </div>
                    <div class="p_post-item">
                        <div class="img-sec">
                            <img src="images/pop-post2.jpg" alt="pop-post">
                            <a href="#" class="category-ttl">Health</a>
                        </div>
                        <h3>Girl walking on the road in early morning for mood.</h3>
                        <h6>Lorem Ipsum is simply dummy text of the printing and typesetbeen the industry's standard dummy text ever since the 1500s, when an unknown printer</h6>
                        <ul class="post-tools">
                            <li class="admin"><a href="#">Admin </a></li>
                            <li class="date">23 Jan 2018</li>
                        </ul>
                    </div>
                    <div class="p_post-item">
                        <div class="img-sec">
                            <img src="images/pop-post1.jpg" alt="pop-post">
                            <a href="#" class="category-ttl">Health</a>
                        </div>
                        <h3>Girl walking on the road in early morning for mood.</h3>
                        <h6>Lorem Ipsum is simply dummy text of the printing and typesetbeen the industry's standard dummy text ever since the 1500s, when an unknown printer</h6>
                        <ul class="post-tools">
                            <li class="admin"><a href="#">Admin </a></li>
                            <li class="date">23 Jan 2018</li>
                        </ul>
                    </div>
                </div>
            </aside>
        </div>
    </section>
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