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
          修改状态成功<br><br>
    <a href="./listAllOrders.action?subbranch_id=${user.subbranchId }">订单管理</a></li>
  </body>
</html>
