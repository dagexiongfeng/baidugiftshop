<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="baidu.giftshop.frk.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'addGoods.jsp' starting page</title>
    <%
     %>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

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
          <p class="block-heading">修改分类信息</p>
            <div class="block-body">
<form action="modifyClassify.action?id=${classify.id }" method="post" name="modify">
            分类代码: <input type="text" id="code" class="span12" name="code" value="${classify.code }" readonly/><br><br>
             分类名 : &nbsp;<input type="text" class="span12" id="name" name="classifyname" value="${classify.name }"/><br><br>
     <input type="submit" value="修改" class="btn btn-primary"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="reset" value="取消" class="btn btn-info"/>
 </form>
 </div>
 </div>
 </div>
 </div>
  </body>
</html>
