<%@page import="jdbc.pojo.Member"%>
<%@page import="jdbc.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>会员资料修改页面-WeAdmin Frame型后台管理系统-WeAdmin 1.0</title>
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
    <div class="weadmin-body">
        <form class="layui-form" action="<%=request.getContextPath() %>/admin/member/edit" method="POST" enctype="multipart/form-data">
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  	登录名
              </label>
              <input type="text" hidden="hidden" name="username" value="<%=((Member)request.getAttribute("member")).getUsername() %>">
              <div class="layui-input-inline">
                  <input disabled="disabled" type="text" id="username" name="user" required="" lay-verify="required"
                  autocomplete="off" value="<%=((Member)request.getAttribute("member")).getUsername() %>" class="layui-input" style="background-color:#ccc">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>用户名不可更改
              </div>
          </div>
          <div class="layui-form-item">
          		<p><img style="width:100px;height:100px;margin:10px 150px" src="<%=request.getContextPath()%>/userimg/<%=((Member)request.getAttribute("member")).getUserimg() %>"></p>
              <label for="L_email" class="layui-form-label">
                  <span class="we-red"></span>用户头像
              </label>
              <div class="layui-input-inline" style="padding-top:6px">
                  <input type="file" name="userimg">
              </div>
              <div class="layui-form-mid layui-word-aux" style="padding:0 !important"> 
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label"><span class="we-red"></span>性别</label>
              <div class="layui-input-block">
              <%if(((Member)request.getAttribute("member")).getGender().equals("male")) {%>
                <input type="radio" name="gender" lay-skin="primary" title="男生" value="male" checked="">
                <input type="radio" name="gender" lay-skin="primary" title="女生" value="female">
              <%} else {%>
              	<input type="radio" name="gender" lay-skin="primary" title="男生" value="male" >
                <input type="radio" name="gender" lay-skin="primary" title="女生" value="female" checked="">
              <%} %>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="we-red"></span>手机
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="<%=((Member)request.getAttribute("member")).getPhone() %>" id="phone" name="phone" required="" lay-verify="phone"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>重要联系方式
              </div>
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="we-red"></span>邮箱
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="<%=((Member)request.getAttribute("member")).getEmail() %>" id="email" name="email" required="" 
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>重要联系方式
              </div>
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="we-red"></span>地址
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="<%=((Member)request.getAttribute("member")).getAddress() %>" id="address" name="address" required="" 
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red"></span>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="we-red">*</span>密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="password" required="" lay-verify="pass"
                  autocomplete="off" class="layui-input" value="<%=((Member)request.getAttribute("member")).getPassword() %>">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="we-red">*</span>确认密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repassword" required="" lay-verify="repass"
                  autocomplete="off" class="layui-input" value="<%=((Member)request.getAttribute("member")).getPassword() %>">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button class="layui-btn" lay-filter="add" lay-submit="">
                  	修改
              </button>
          </div>
      </form>
    </div>
		<script src="<%=request.getContextPath() %>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript">
    	layui.extend({
				admin: '<%=request.getContextPath() %>/static/js/admin'
			});
	    layui.use(['form','layer','admin'], function(){
	      var form = layui.form,
	      	admin = layui.admin,
	      	layer = layui.layer;
        <%--
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });

          //监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
          });
          --%>
          	//密码相同校验
	      	let password = document.querySelector("input[name=password]")
	      	let repassword = document.querySelector("input[name=repassword]")
	      	let submit = document.querySelector(".layui-btn")
	      	repassword.oninput = function(){
	    		if(password.value == ''){
	       			submit.disabled = "disabled"
	       			submit.style.backgroundColor = "#CCC"
	       			password.style.backgroundColor = "indianred"
	       			repassword.style.backgroundColor = "indianred"
	    		}else if(repassword.value == password.value && username.value != ''){
	    			submit.disabled = false
	    			submit.style.backgroundColor = "#189f92"
	    			repassword.style.backgroundColor = "rgb(232, 240, 254)"
	    		}else{
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
	           			submit.disabled = "disabled"
	           			submit.style.backgroundColor = "#CCC"
	           			password.style.backgroundColor = "indianred"
	           			repassword.style.backgroundColor = "indianred"
	    		}else if(repassword.value == password.value && username.value != ''){
	    			submit.disabled = false
	    			submit.style.backgroundColor = "#189f92"
	    			repassword.style.backgroundColor = "rgb(232, 240, 254)"
	    		}else{
	        		submit.disabled = "disabled"
	        		submit.style.backgroundColor = "#CCC"
	        		repassword.style.backgroundColor = "indianred"
	    		}
	    	}
        });
    </script>
  </body>

</html>