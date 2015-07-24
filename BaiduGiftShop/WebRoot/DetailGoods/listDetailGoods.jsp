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
    <title>My JSP 'listDetailGoods.jsp' starting page</title>
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
  <br>
  <body>
  <form action="./queryDetailGoods.action" method="post">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   查询的商品条形码:<input type="text" name="barCode"/>(*必填)&nbsp;&nbsp;&nbsp;&nbsp;
     查询的商品ID:<input type="text" name="goodsDetailId"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="submit" value="查询"/>
  </form>
  <table border="1 #76aef0 solid" cellspacing="0" cellpadding="1" align="center" bgColor="#E4E8EF" width="" border="0">
    <tr>
        <td width="50">商品ID</td>
        <td width="70">分类名称</td>
        <td width="70">商品名称</td>
        <td width="70">商品代码</td>
        <td width="50">店内码</td>
        <td width="50">条形码</td>
        <td width="80">分类属性1</td>
        <td width="80">分类属性2</td>
        <td width="80">分类属性3</td>
        <td width="80">分类属性4</td>
        <td width="80">对应的一组图片ID</td>
        <td width="50">进价</td>
        <td width="50">零售价</td>
        <td width="70">最后进价</td>
        <td width="50">成本价</td>
        <td width="100">状态(0为下架商品)</td>
        <td width="100">上架或下架</td>
    </tr>
    <tr>
        <td width="50">${goodsdetai.id }</td>
        <td width="70">${goodsdetai.goods.name }</td>
        <td width="70">${goodsdetai.name }</td>
        <td width="70">${goodsdetai.goodsCode }</td>
        <td width="50">${goodsdetai.shopCode }</td>
        <td width="50">${goodsdetai.barCode }</td>
        <td width="80">${goodsdetai.type1 }</td>
        <td width="80">${goodsdetai.type2 }</td>
        <td width="80">${goodsdetai.type3 }</td>
        <td width="80">${goodsdetai.type4 }</td>
        <td width="80">${goodsdetai.picGroupId }</td>
        <td width="50">${goodsdetai.stockPrice }</td>
        <td width="50">${goodsdetai.lastStockPrice }</td>
        <td width="70">${goodsdetai.retailPrice }</td>
        <td width="50">${goodsdetai.costPrice }</td>
        <td width="100">${goodsdetai.state }</td>
        <td width="100">
         <s:iterator value="#session.goodsdetai" id="goodsdetai">
         <s:if test="%{#goodsdetai.state==1}">
           <input type="button" id="button" name="button" value="下架" style="width: 100px;height: 40px" onclick="change(${goodsdetai.id })"/>
        </s:if>
        <s:elseif test="%{#goodsdetai.state!=1}">
           <input type="button" id="button" name="button" value="上架" style="width: 100px;height: 40px" onclick="change(${goodsdetai.id })"/>
        </s:elseif>
        </s:iterator>
        </td>
    </tr>
    </table>
  </body>
<script type="text/javascript">
 function change(DetailGoodsId){
   $.ajax({
       type :"get",
       url :"./deleteDetail.action",
       data:{goods_detail_id:DetailGoodsId},
       dataType:"json",
       success :function(result){
          var data = result.content;
          if(data==101){
            alert("更新成功!");
            location.href ="./listallDetailGoods.action";
          }else{
            alert("更新失败！");
          }
       }
     });
 }
</script>
<script type="text/javascript" src="./jquery/jquery-1.7.2.js"></script>
</html>
