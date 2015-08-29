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
    删除成功<br>
    
  <a href="./Picture/DeleteGroup.jsp">继续删除</a>
    <a href="./index.jsp">返回首页</a>
  </body>
</html>
