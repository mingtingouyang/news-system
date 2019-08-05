<%@page import="jdbc.pojo.Article"%>
<%@page import="jdbc.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>管理员资料修改页面-WeAdmin Frame型后台管理系统-WeAdmin 1.0</title>
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
        <form class="layui-form" action="<%=request.getContextPath() %>/admin/article/new" method="POST" enctype="multipart/form-data">
          <div class="layui-form-item">
          		<p><img style="width:100px;height:100px;margin:10px 150px" src="<%=request.getContextPath()%>/articleimg/default.png"></p>
              <label for="L_email" class="layui-form-label">
                  <span class="we-red"></span>封面图片
              </label>
              <div class="layui-input-inline" style="padding-top:6px">
                  <input type="file" name="img">
              </div>
              <div class="layui-form-mid layui-word-aux" style="padding:0 !important"> 
              </div>
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="we-red">*</span>文章标题
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="" id="title" name="title" required="" 
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red"></span>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="we-red">*</span>作者
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="" id="author" name="author" required="" 
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red"></span>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="we-red">*</span>类别
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="" id="category" name="category" required="" 
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red"></span>
              </div>
          </div>
          <input hidden="hidden" type="text" value="" id="content" name="content" autocomplete="off">
          <div id="editor" style="margin: 20px 0">
          
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button disabled="disabled" style="background-color:#CCC" class="layui-btn" lay-filter="add" lay-submit="">
                  	添加
              </button>
          </div>
      </form>
    </div>
		<script src="<%=request.getContextPath() %>/lib/layui/layui.js" charset="utf-8"></script>
		<script src="<%=request.getContextPath() %>/static/js/wangEditor.min.js" type="text/javascript"></script>
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
        });
	    
	    //文章内容不为空验证
	    let form = document.querySelector('.layui-form')
	    let title = document.querySelector("input[name=title]")
	    let author = document.querySelector("input[name=author]")
	    let category = document.querySelector("input[name=category]")
	    let content = document.querySelector("input[name=content]")
	    let submit = document.querySelector(".layui-btn")
	    form.oninput = function(){
	    	if(title.value != "" && author.value != "" && category != "" && content.value != ""){
	    		submit.disabled = false
    			submit.style.backgroundColor = "#189f92"
	    	} else {
	    		submit.disabled = "disabled"
       			submit.style.backgroundColor = "#CCC"
	    	}
	    		
	    }
	    
	    //编辑器设置
	   	var E = window.wangEditor
   		var editor = new E('#editor')
	   	editor.customConfig.onchange = function (html) {
            // 监控变化，同步更新到 textarea
            content.value = html
        }
	    editor.create()
    </script>
  </body>

</html>