<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="baidu.giftshop.frk.*" %>
<%@ page import="baidu.giftshop.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%
      HttpSession s = request.getSession();
      Account account = (Account)s.getAttribute("user");
      Integer uid = account.getId();
      String id = AESDAO.encrytStr(uid.toString());
    %>
    <base href="<%=basePath%>">
    <title>修改密码</title>
<style> 
body{ text-align:center} 
.div{ margin:0 auto; width:400px; height:100px; border:1px solid #F00} 
/* css注释：为了观察效果设置宽度 边框 高度等样式 */ 
</style>
  </head>
  
  <body>
  <div id="div">
    <br>
    <br>
<form action="changPassword.action?id=<%=id %>>" method="post" name="changPassword">
     用户名 : <input type="text" id="code" name="code" value="${user.account }" readonly/><br><br>
     新密码 : &nbsp;<input type="password" id="password" name="password"/><br><br>
     <input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="reset" value="取消"/>
 </form>
   </div>
  </body>
</html>
