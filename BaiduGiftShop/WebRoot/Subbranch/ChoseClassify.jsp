<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>分店绑定分类信息</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
    <!-- Demo page code -->
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

  </head>
  <body>
  <br>
   <br>
    <br>
     <br>
      <br>
  <form action="./subclassify.action">
  <input type="hidden" id="subbranchId" name="subbranchId" value=${user.subbranchId }>
  <input type="hidden" id="size" name="size" value="${checkbox }">
    <table id="tb" border="1 #76aef0 solid" cellspacing="0" cellpadding="1" align="center" bgColor="#E4E8EF" width="750" border="0">
    <tr>
        <td width="150">ID</td>
        <td width="150">分类代码</td>
        <td width="150">分类名</td>
        <td width="150">是否绑定分类</td>
    </tr>
     <s:iterator value="#request.list" id="list">
    <tr>
        <td width="150"><s:property value="#list.id"/></td>
        <td width="150"><s:property value="#list.code"/></td>
        <td width="150"><s:property value="#list.name"/></td>
        <td width="150"><input type="checkbox" name="classifyId" style="width: 20;height: 20" value="<s:property value="#list.id"/>"/></td>
    </tr>
    </s:iterator>
    </table>
    <br>
         <center>
         <input type="submit" value="更新" style=" width: 100px" class="btn btn-primary"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
         <a href="./Subbranch/Index.jsp">返回首页</a>
         </center>
   </form>
  </body>
  <script type="text/javascript">
   $(document).ready(function(){
      var subbranchId = $("#subbranchId").val();
      var input = document.getElementsByTagName("input");
      $.ajax({
      type :"post",
      url :"./checkboxclassify.action",
      dataType :"json",
      async: false,
      data:{subbranchId:subbranchId},
      success:function(result){
       var data = result.content;
       var size = $("#size").val();
       for(var n =0;n<data.length;n++){
         for(var j = 1;j<=size;j++){
             var classifyId=document.getElementById("tb").rows[j].cells[0]; 
             var cId = classifyId.innerHTML;
             if(cId == data[n]){
                   var k = j+1;
                   input[k].checked = true;
                 }else{
                 }
              }
          }
       }
      });
  });
  </script>
</html>
