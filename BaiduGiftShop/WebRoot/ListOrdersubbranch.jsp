<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
     String path = request.getContextPath();
     String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>订单管理</title>
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
     <form action="./listAllOrderbysubbranch.action" method="get">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <select style="width: 140px;height: 35px" id="subbranchId" name="subbranchId" >
     		<option value="11" >------请选择------</option>
      </select>
    &nbsp;&nbsp;&nbsp; <input type="submit" value="查询" class="btn btn-info"/>
  </form>
  <table id="show" border="1 #76aef0 solid" cellspacing="0" cellpadding="1" align="center" bgColor="#E4E8EF" width="1024" border="0">
    <tr id="tr">
        <td width="100">订单编号</td>
        <td width="100">商品名称</td>
        <td width="100">商品码</td>
        <td width="100">数量</td>
        <td width="100">总价钱</td>
        <td width="100">收货人</td>
        <td width="100">地址信息</td>
        <td width="100">电话</td>
        <td width="100">状态</td>
      <td width="100">发货</td> 
    </tr>
     <s:iterator value="#request.list" id="list">
    <tr>
       <td width="100"><s:property value="#list.orderid"/></td>
        <td width="100"><s:property value="#list.goodsname"/></td>
        <td width="100"><s:property value="#list.goodscode"/></td>
        <td width="100"><s:property value="#list.num"/></td>
        <td width="100"><s:property value="#list.totalMoney"/></td>
        <td width="60"><s:property value="#list.addressee"/></td>
        <td width="200"><s:property value="#list.address"/></td>
        <td width="200"><s:property value="#list.phone"/></td>
        <td width="100"><s:property value="#list.state"/></td>
       <td width="100">
        <s:if test="%{#list.state=='已支付'}">
          <a href="./Subbranch/logistics.jsp?orderid=<s:property value="#list.orderid"/>&&userid=<s:property value="#list.userid"/>"> <input type="button" id="button" name="button" value="发货" style="width: 100px;height: 40px" class="btn btn-danger"/></a>
        </s:if>
        <s:elseif test="%{#list.state!='已支付'}">
           <input type="button" id="button" name="button" value="发货" style="width: 100px;height: 40px" class="btn btn-success" readonly/>
        </s:elseif>
        </td> 
    </tr>
    </s:iterator>
   </table>   <br>
   <table  border="0" align="center">
   <s:iterator value="#request.pageBean" id="pageBean">
    <tr>
      <%-- <td bgcolor="#E0EEEE" colspan="10">
                             第${pageBean.currentPage }页
                             共${pageBean.allPage }页
                        
      <a href="listAllOrders.action?page=${pageBean.firstPage }&subbranch_id=${user.subbranchId}">首页</a>
      <a href="listAllOrders.action?page=${pageBean.previousPage }&subbranch_id=${user.subbranchId}">上一页</a>
      <a href="listAllOrders.action?page=${pageBean.nextPage }&subbranch_id=${user.subbranchId}">下一页</a>
      <a href="listAllOrders.action?page=${pageBean.lastPage }&subbranch_id=${user.subbranchId}">尾页</a>
              共${pageBean.allRecords }条 
      </td>--%>
      <td bgcolor="#E0EEEE" colspan="10">
                             第<s:property value="#pageBean.currentPage"/>页
                             共<s:property value="#pageBean.allPage"/>页
                        
      <a href="listAllOrderbysubbranch.action?page=<s:property value="#pageBean.firstPage"/>&subbranchId=${subbranchId}">首页</a>
      <a href="listAllOrderbysubbranch.action?page=<s:property value="#pageBean.previousPage"/>&subbranchId=${subbranchId}">上一页</a>
      <a href="listAllOrderbysubbranch.action?page=<s:property value="#pageBean.nextPage"/>&subbranchId=${subbranchId}">下一页</a>
      <a href="listAllOrderbysubbranch.action?page=<s:property value="#pageBean.lastPage"/>&subbranchId=${subbranchId}">尾页</a>
              共<s:property value="#pageBean.allRecords"/>条 
      </td>
    </tr>
    </s:iterator>
    </table>
    <center>
    <a href="./index.jsp" class="btn btn-primary">返回首页</a>
    </center>
  </body>
  <script type="text/javascript">
  window.onload = function(){ 
		 $.ajax({
		 type :"get",
		 url :"./subbranch.action",
		 dataType :"json",
		 success :function(result){
		 var data = result.content;
		 for(var n=0;n<data.length;n++){
		  $("#subbranchId").append("<option id='"+data[n].id+"' value='"+data[n].id+"'>"+data[n].name+"</option>");
		 }
		 }
	     });
	     };
  </script>
<script type="text/javascript" src="./jquery/jquery.lightbox_me.js"></script>
<script type="text/javascript" src="./jquery/jquery-1.7.2.js"></script>
</html>
