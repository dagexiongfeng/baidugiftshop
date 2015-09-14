<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
  </head>
  
  <body>
   	<form action="./uploadsdk.action" method="post" enctype="multipart/form-data">
    		用户名称：<input type="text" name="username"><br>
    		上传文件：<input type="file" name="upload"><br>
    			<input type="submit" value="上传">
    	</form>
  </body>
</html>
