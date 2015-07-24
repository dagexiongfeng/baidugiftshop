<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String orderid = request.getParameter("orderid");
    String userid = request.getParameter("userid");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>填写物流信息</title>
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
            <p class="block-heading">填写物流信息</p>
            <div class="block-body">
   <form action="./Setlogistics.action">
   <input type="hidden" id="userid" name="userid" value="<%=userid %>"/>
   <input type="hidden" id="orderid" name="orderid" value="<%=orderid %>"/>
     货运号：&nbsp;<input type="text" id="shipnum" name="shipnum" class="span12"><br><br>
     物流公司：<input type="text" id="fedex" name="fedex" class="span12"><br><br>
   <input type="submit" value="确定" class="btn btn-info">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="reset" value="取消" class="btn btn-danger">
   </form>
   </div>
   </div>
   </div>
   </div>
  </body>
</html>
