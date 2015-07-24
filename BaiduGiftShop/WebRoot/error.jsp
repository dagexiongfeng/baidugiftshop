<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加失败</title>
	
  </head>
  
  <body>
     Error 添加概要商品名重复或图片规格错误{要求规格（宽：480~1024）的正方形}<br>
     <a href="/BaiduGiftShop/left.jsp">返回到登陆</a>
  </body>
</html>
