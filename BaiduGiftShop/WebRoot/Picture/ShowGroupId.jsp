<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  </head>

  <body>
            <center> 
    <br><br><br><br><br> <br><br><br><br><br>
            	  您刚才添加的商品图片编号是${groupId }<br>
     	 <a href="./addPic.action">继续添加</a>
         <a href="./index.jsp">返回首页</a>
     </center>
  </body>
</html>
