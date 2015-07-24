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
  <form action="<%=request.getContextPath()%>/upload.action?briefgoods=${goodsid }" method="POST" enctype="multipart/form-data">  
         选择文件：<input type="file" name="pic" size="50"/><br/>   
       <input type="submit" value=" 上传 "/>         
    </form>
  </body>
</html>
