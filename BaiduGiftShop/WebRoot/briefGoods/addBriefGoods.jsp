<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>增加概要商品信息</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>
  </head>
  
  <body>
  <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">添加商品信息</p>
            <div class="block-body">
                  <form action="addGoods.action" method="post" name="form1" enctype="multipart/form-data" onsubmit="return beforeSubmit(this);">
							 分类ID：&nbsp;
							 <select id="classifyId" name="classifyId">
                              <option value="0" selected="selected">-----------请选择-----------</option>
                                  </select><br>      
                                                                        单位：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="unit" name="unit" class="span12"/><br>
                                                                        货品名：&nbsp;&nbsp;<input type="text" id="name" name="name" class="span12"/><br>
                              <select name="productType">
	                               <option value="0" selected="selected">普通商品</option>
	                               <option value="1">热卖商品</option>
	                               <option value="2">新品上货</option>
                              </select> 
                              <br>                                                                             
                              &nbsp   上传图片：<input type="file" id="pic" name="pic"><br>（要求规格（宽：480~1024）的正方形）<br>                                         
							 <input type="submit" value="增加商品信息" class="btn btn-primary"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							 <input type="reset"  value="重置" class="btn btn-info">
	               </form>
	  </div>
	  </div>
	  <p><a href="index.jsp">返回首页</a></p>
	  </div>
	  </div>
  </body>
  <script type="text/javascript">
 window.onload = function(){ 
	 $.ajax({
	 type :"get",
	 url :"./allclassify.action",
	 dataType :"json",
	 success :function(result){
	 var data = result.content;
	 for(var n=0;n<data.length;n++){
	  //var ids = data[n].id;
	  //var names = data[n].name;
	  $("#classifyId").append("<option id='"+data[n].id+"' value='"+data[n].id+"'>"+data[n].name+"</option>");
	 }
	 }
     });
     };
     function beforeSubmit(form){
 	    if(form.classifyId.value=='0'){
 		 alert('没有选择分类');
 		 form.classifyId.focus();
 		 return false;
 		 }
 		 if($.trim(form.unit.value)=='' || form.unit.value==''){
 		 alert('没有填写单位');
 		 form.unit.focus();
 		 return false;
 		 }
 		 if($.trim(form.unit.value)=='' || form.name.value==''){
 			 alert('没填写货品名');
 			 form.name.focus();
 			 return false;
 	     }
 		 if(form.pic.value==''){
 			 alert('没有选择图片');
    		 form.pic.focus();
    		 return false;
 		 }
 }
	</script>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="./jquery/jquery-1.7.2.js"></script>
</html>
