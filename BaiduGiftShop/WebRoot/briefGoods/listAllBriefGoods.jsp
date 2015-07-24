<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String realpath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    String root = realpath.substring(0,realpath.lastIndexOf("/"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>显示概要商品的列表</title>
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
    <table border="1 #76aef0 solid" cellspacing="0" cellpadding="1" align="center" bgColor="#F0FFF0" width="1024" border="0">
    <tr>
        <td width="100">概要商品ID</td>
        <td width="100">分类代码</td>
        <td width="100">单位</td>
        <td width="100">概要商品名称</td>
        <td width="100">缩略图</td>
        <td width="100">高宽比</td>
        <td width="100">状态(0为已下架)</td>
        <td width="100">上架或下架</td>
    </tr>
     <s:iterator value="#request.birefGoodsList" id="list">
    <tr>
        <td width="100"><s:property value="#list.goods.id"/></td>
        <td width="100"><s:property value="#list.goods.classify.name"/></td>
        <td width="100"><s:property value="#list.goods.unit"/></td>
        <td width="100"><s:property value="#list.goods.name"/></td>
        <td width="100"><img src="<%=root %>/<s:property value="#list.thumbPath"/>"/></td>
        <%-- <td width="100"><img src="./<s:property value="#list.thumbPath"/>"></td> --%>
        <td width="100"><s:property value="#list.ratio"/></td>
        <td width="100"><s:property value="#list.goods.state"/></td>
        <td width="100">
        <s:if test="%{#list.goods.state==1}">
           <input type="button" id="button" name="button"  class="btn btn-danger" value="下架" style="width: 100px;height: 40px" onclick="change(<s:property value="#list.goods.id"/>)"/>
        </s:if>
        <s:elseif test="%{#list.goods.state!=1}">
           <input type="button" id="button" name="button" class="btn btn-success" value="上架" style="width: 100px;height: 40px" onclick="change(<s:property value="#list.goods.id"/>)"/>
        </s:elseif>
        </td>
    </tr>
    </s:iterator>
    </table>
    <br>
    <div id="tb">
    <table  border="0" align="center" id="show">
    <s:iterator value="#request.pageBean" id="pageBean">
    <tr>
      <td bgcolor="#E0EEEE" colspan="10">
                          第<s:property value="pageBean.currentPage" />页
                         共<s:property value="pageBean.allPage"/>页
                        
          <a href="queryAllBriefGoods.action?page=<s:property value='pageBean.firstPage'/>">首页</a>
          <a href="queryAllBriefGoods.action?page=<s:property value='pageBean.previousPage'/>">上一页</a>
          <a href="queryAllBriefGoods.action?page=<s:property value='pageBean.nextPage'/>">下一页</a>
          <a href="queryAllBriefGoods.action?page=<s:property value='pageBean.lastPage'/>">尾页</a>
           共<s:property value="pageBean.allRecords"/>条
      </td>
    </tr>
    </s:iterator>
    </table>
    </div>
    <center>
    <a href="./index.jsp" class="btn btn-info">返回到首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="./briefGoods/addBriefGoods.jsp" class="btn btn-info">添加商品</a>
    </center>
  </body>
<script type="text/javascript">
function change(goodsId){
   $.ajax({
       type :"get",
       url :"./DeleteBrief.action",
       data:{goods_id:goodsId},
       dataType:"json",
       success :function(result){
          var data = result.content;
          if(data==101){
            alert("更新成功!");
            location.href ="./queryAllBriefGoods.action";
          }else{
            alert("更新失败！");
          }
       }
     });
};
</script>
<script type="text/javascript" src="./jquery/jquery-1.7.2.js"></script>
</html>
