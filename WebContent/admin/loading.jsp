<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>正在跳转</title>
<style>
    img{
    height: 200px;
    width: 200px;
    margin: 300px auto 10px;
    }
    h1{
    text-align: center;
    }
    p{
    text-align:center;
    }
</style>
</head>
<body>
    <img style= "display: block" src="<%=request.getContextPath() %>/static/images/loading.gif">
    <h1>${status }</h1>
    <p><span class="timeout">3</span> 秒后跳转至${page }页面</p>
    <script>
        let time = 3
        let timeout = document.querySelector(".timeout")
        let status = document.querySelector("h1")
        let countDown = setInterval(function(){
            time --
            timeout.innerHTML = time
            if(time == 0){
                clearInterval(countDown)
                location.href = "<%=request.getContextPath()%>/${url}"
            }
        },1000)
    </script>
</body>
</html>