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
</head>

<body>
    <header>
        <div class="news_ticker_sec">
            <div class="container">
                <div class="news_ticker">
                    <div class="title">Breaking News</div>
                    <div class="news-container">${articles.get(0).title }...<a href="<%=request.getContextPath() %>/page?id=${articles.get(0).id }"> Read More</a></div>
                    <div class="share-sec right">
                        
                    </div>
                </div>
            </div>
        </div>
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
    <section class="news-banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-sm-12">
                    <div class="big-img" style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(1).img });">
                        <div class="post-content">
                            <div class="content">
                                <a href="<%=request.getContextPath() %>/category?c=${articles.get(1).category }" class="category-ttl">${articles.get(1).category }</a>
                                <a href="<%=request.getContextPath() %>/page?id=${articles.get(1).id }">
                                    <h3 class="post-ttl">${articles.get(1).title }</h3>
                                </a>
                                <ul class="post-tools">
                                    <li class="admin">${articles.get(1).author } </li>
                                    <li class="date">${articles.get(1).time }</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-12">
                    <div class="small-img" style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(2).img });">
                        <div class="post-content">
                            <div class="content">
                                <a href="<%=request.getContextPath() %>/category?c=${articles.get(2).category }" class="category-ttl">${articles.get(2).category }</a>
                                <a href="<%=request.getContextPath() %>/page?id=${articles.get(2).id }">
                                    <h3 class="post-ttl">${articles.get(2).title }</h3>
                                </a>
                                <ul class="post-tools">
                                    <li class="admin">  ${articles.get(2).author } </li>
                                    <li class="date">${articles.get(2).time }</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="small-img" style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(3).img });">
                        <div class="post-content">
                            <div class="content">
                                <a href="<%=request.getContextPath() %>/category?c=${articles.get(3).category }" class="category-ttl">${articles.get(3).category }</a>
                                <a href="<%=request.getContextPath() %>/page?id=${articles.get(3).id }">
                                    <h3 class="post-ttl">${articles.get(3).title }</h3>
                                </a>
                                <ul class="post-tools">
                                    <li class="admin"> ${articles.get(3).author } </li>
                                    <li class="date">${articles.get(3).time }</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="trending-news mb-100">
        <div class="title-sec">
            <div class="title-container">
                <h2 class="title">Top Trending news</h2>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-7 col-md-7 col-sm-12">
                    <div class="post-content">
                        <figure style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(4).img })"></figure>
                        <a href="<%=request.getContextPath() %>/category?c=${articles.get(4).category }" class="category-ttl">${articles.get(4).category }</a>
                        <ul class="post-tools right">
                            <li class="admin"> ${articles.get(4).author }</li>
                            <li class="date">${articles.get(4).time }</li>
                        </ul>
                        <a href="<%=request.getContextPath() %>/page?id=${articles.get(4).id }">
                            <h3 class="post-ttl">${articles.get(4).title }</h3>
                        </a>
                    </div>
                </div>
                <div class="col-lg-5 col-md-5 col-sm-12">
                    <div class="post-content">
                        <figure style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(5).img })"></figure>
                        <a href="<%=request.getContextPath() %>/category?c=${articles.get(5).category }" class="category-ttl">${articles.get(5).category }</a>
                        <a href="<%=request.getContextPath() %>/page?id=${articles.get(5).id }">
                            <h3 class="post-ttl">${articles.get(5).title }</h3>
                        </a>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="small-post">
                        <div class="row">
                            <div class="col-md-6 col-sm-4 col-5 img-sec">
                                <figure style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(6).img })"></figure>
                            </div>
                            <div class="col-md-6 col-sm-8 col-7">
                                <a href="<%=request.getContextPath() %>/page?id=${articles.get(6).id }">
                                    <h3 class="post-ttl">${articles.get(6).title }</h3>
                                </a>
                                <h5 class="post-text">
                            	</h5>
                                <ul class="post-tools">
                                    <li class="admin">   ${articles.get(6).author }</li>
                                    <li class="date">${articles.get(6).time }</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="small-post">
                        <div class="row">
                            <div class="col-md-6 col-sm-4 col-5 img-sec">
                                <figure style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(7).img })"></figure>
                            </div>
                            <div class="col-md-6 col-sm-8 col-7">
                                <a href="<%=request.getContextPath() %>/page?id=${articles.get(7).id }">
                                    <h3 class="post-ttl">${articles.get(7).title }</h3>
                                </a>
                                <h5 class="post-text">
                            	</h5>
                                <ul class="post-tools">
                                    <li class="admin">   ${articles.get(7).author } </li>
                                    <li class="date">${articles.get(7).time }</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Ad section -->
    <div class="responsive ad-sec">
        <div class="container">
            <img src="images/responsive-ad.jpg" alt="ad">
        </div>
    </div>
    <!-- End ad section -->
    <section class="trending-tabsec">
        <div class="container">
      <!--       <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" href="#health" role="tab" data-toggle="tab">Health</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#music" role="tab" data-toggle="tab">Music</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#food" role="tab" data-toggle="tab">Food</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#technology" role="tab" data-toggle="tab">Technology</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#entertainment" role="tab" data-toggle="tab">Entertainment</a>
                </li>
            </ul> -->
            <!-- Tab panes -->
            <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="health">
                 <div class="row">
                     <div class="col-md-5">
                         <div class="big-img" style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(8).img })">
                             <div class="content">
                                 <a href="<%=request.getContextPath() %>/category?c=${articles.get(8).category }" class="category-ttl">${articles.get(8).category }</a>
                                 <a href="<%=request.getContextPath() %>/page?id=${articles.get(8).id }">
                                     <h3 class="post-ttl">${articles.get(8).title }</h3>
                                 </a>
                                 <ul class="post-tools">
                                     <li class="admin">${articles.get(8).author } </li>
                                     <li class="date">${articles.get(8).time }</li>
                                 </ul>
                             </div>
                         </div>
                     </div>
                     <div class="col-md-7">
                         <div class="row">
                             <div class="col-md-6">
                                 <div class="img-sec" style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(9).img })">
                                     <a href="<%=request.getContextPath() %>/category?c=${articles.get(9).category }" class="category-ttl">${articles.get(9).category }</a>
                                 </div>
                                 <div class="content-text">
                                     <a href="<%=request.getContextPath() %>/page?id=${articles.get(9).id }">
                                         <h3 class="post-ttl">${articles.get(9).title }</h3>
                                     </a>
                                     <h5 class="post-text">
                                      Lorem Ipsum is simply dummy text of the printing and typesetbeen the industry's standard dummy text ever since the 1500s, when an unknown printer 
                                  </h5>
                                     <ul class="post-tools">
                                         <li class="admin">${articles.get(9).author }</li>
                                         <li class="date">${articles.get(9).time }</li>
                                     </ul>
                                 </div>
                             </div>
                             <div class="col-md-6">
                                 <div class="img-sec" style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(10).img })">
                                     <a href="<%=request.getContextPath() %>/category?c=${articles.get(10).category }" class="category-ttl">${articles.get(10).category }</a>
                                 </div>
                                 <div class="content-text">
                                     <a href="<%=request.getContextPath() %>/page?id=${articles.get(10).id }">
                                         <h3 class="post-ttl">${articles.get(10).title }</h3>
                                     </a>
                                     <h5 class="post-text">
                                      Lorem Ipsum is simply dummy text of the printing and typesetbeen the industry's standard dummy text ever since the 1500s, when an unknown printer 
                                  </h5>
                                     <ul class="post-tools">
                                         <li class="admin">${articles.get(10).author }</li>
                                         <li class="date">${articles.get(10).time }</li>
                                     </ul>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
                 <div class="row small-post">
                     <div class="col-md-4 col-sm-8">
                         <div class="post-content">
                             <figure style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(11).img })"></figure>
                             <div class="content">
                                 <a href="<%=request.getContextPath() %>/page?id=${articles.get(11).id }">
                                     <h3 class="post-ttl">${articles.get(11).title }</h3>
                                 </a>
                                 <ul class="post-tools">
                                     <li class="admin">${articles.get(11).author } </li>
                                     <li class="date">${articles.get(11).time }</li>
                                 </ul>
                             </div>
                         </div>
                     </div>
                     <div class="col-md-4 col-sm-8">
                         <div class="post-content">
                             <figure style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(12).img })"></figure>
                             <div class="content">
                                 <a href="<%=request.getContextPath() %>/page?id=${articles.get(12).id }">
                                     <h3 class="post-ttl">${articles.get(12).title }</h3>
                                 </a>
                                 <ul class="post-tools">
                                     <li class="admin">${articles.get(12).author } </li>
                                     <li class="date">${articles.get(12).time }</li>
                                 </ul>
                             </div>
                         </div>
                     </div>
                     <div class="col-md-4 col-sm-8">
                         <div class="post-content">
                             <figure style="background:url(<%=request.getContextPath() %>/articleimg/${articles.get(13).img })"></figure>
                             <div class="content">
                                 <a href="<%=request.getContextPath() %>/page?id=${articles.get(13).id }">
                                     <h3 class="post-ttl">${articles.get(13).title }</h3>
                                 </a>
                                 <ul class="post-tools">
                                     <li class="admin">${articles.get(13).author } </li>
                                     <li class="date">${articles.get(13).time }</li>
                                 </ul>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
          </div>
    </section>
    <!-- Ad section -->
    <div class="responsive ad-sec">
        <div class="container">
            <img src="images/responsive-ad.jpg" alt="ad">
        </div>
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