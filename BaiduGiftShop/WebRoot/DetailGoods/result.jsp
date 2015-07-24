<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'result.jsp' starting page</title>
  </head>
  
  <body>
    详细商品添加成功<br>
    <a href="./DetailGoods/addDetailGoods.jsp">继续添加</a><br>
    <a href="./listallDetailGoods.action">查看所有商品</a><br>
    <a href="./index.jsp">返回首页</a>
  </body>
</html>
