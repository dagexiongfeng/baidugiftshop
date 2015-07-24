<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>图片组上传失败</title>
  </head>
  <body>
        上传失败，没有按规定上传图片<br>
   <a href="./Picture/AddPic.jsp">继续添加</a>
  </body>
</html>
