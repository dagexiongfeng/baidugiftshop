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
    <title>显示所有的分类信息</title>
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
    <table border="1 #76aef0 solid" cellspacing="0" cellpadding="1" align="center" bgColor="#F8F8FF" width="750" border="0">
    <tr>
        <td width="150">ID</td>
        <td width="150">分类代码</td>
        <td width="150">分类名</td>
        <td width="150">操作</td>
        <td width="150">刪除</td>
    </tr>
     <s:iterator value="#request.list" id="list">
    <tr>
        <td width="150"><s:property value="#list.id"/></td>
        <td width="150"><s:property value="#list.code"/></td>
        <td width="150"><s:property value="#list.name"/></td>
        <td width="150"><a href="EditClassify.action?id=<s:property value="#list.id"/>" class="btn btn-primary">修改</a></td>
        <td width="150"><button class="btn btn-danger" onclick="Delete(<s:property value="#list.id"/>)">刪除</button></td>
    </tr>
    </s:iterator>
    </table>
    <br>
    <center>
    <a href="./index.jsp" class="btn btn-info">返回首页</a>
    </center>
  </body>
  <script type="text/javascript">
  function Delete(id){
	  $.ajax({
		  type:"get",
		  url:"./DeleteClassify.action",
		  data:{id:id},
		  success:function(data){
			  alert("操作完成！数据未发生变化则因分店未解除绑定,请解除分店绑定再来删除！");
			  location.href ="./listallBrief.action";
			  /* var con = data.code;
			  alert(data.code);
			  if(con==101){
				  alert("删除成功");
				  location.href ="./listallBrief.action";
			  }else{
				  alert("该类商品有概要商品或明细商品，删除失败");
			  } */
		  }
	  });
  }
  </script>
</html>
