<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'subClassifySuc.jsp' starting page</title>
  </head>
  <body>
             分店修改分类商品成功<br><br>
     <a href="./subbranchClassify.action">查看分店绑定的分类信息</a>
  </body>
</html>
