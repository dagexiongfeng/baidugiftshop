<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="baidu.giftshop.frk.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String realpath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
String root = realpath.substring(0,realpath.lastIndexOf("/"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'ShowPic.jsp' starting page</title>
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
    <%
    String url = "./queryGroup.action";
     %>
  </head>
  
  <body>
   <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">查询一组图片</p>
               <div class="block-body">
     <form action=<%=url %>>
                                  查询的组号：<input type="text" name="groupId" class="span12"/><br><br>
                       <input type="submit" value="确定" style="width: 100;height: 35" class="btn btn-primary"/>
     </form>
     <br>
               <s:iterator value="#request.thumbPath" id="thumbPath">
               <img src="<%=root %>/<s:property value="#thumbPath"/>">
               </s:iterator><br>
               
   </div>
   </div>
   <a href="./index.jsp">返回首页</a>
   </div>
   </div>
  </body>
</html>
