<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改明细商品信息</title>
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
            <p class="block-heading">添加商品信息</p>
            <div class="block-body">
  <form action="./ModifyDetailGoods.action" method="post">
              
           修改的商品条形码:(*必填)<input type="text" name="barCode" class="span12"/>
           
        <!--   修改的商品ID:<input type="text" name="goodsDetailId" class="span12"/> --> 
          
               <input type="submit" value="查询" class="btn btn-primary"/>
               
     </form>
     <br>
     
     <a href="./index.jsp" >返回到首页</a>
  </div>
  </div>
  </div>
  </div>
  </body>
</html>
