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
  
 <script type="text/javascript">
 function changType(goodid,type){
	 if(confirm("确定要改变类型？")){
	 $.ajax({
	       type :"get",
	       url :"./changeType.action",
	       data:{goods_id:goodid,
	    	productType:type   
	       },
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
	 }
 }
 
 </script>
  </head>
  <body>
  <br>
   <form action="./querybriefgood.action" method="post">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	  查询的商品编号:<input type="text" id="goodcode" name="goodcode" style="width: 140px;height: 35px" />&nbsp;&nbsp;&nbsp;&nbsp;
     <select style="width: 140px;height: 35px" id="productType" name="productType" >
     		<option value="11" >------请选择------</option>
      	    <option value="0" >普通商品</option>
            <option value="1">热卖商品</option>
           <option value="2">新品上货</option>
      </select>
    &nbsp;&nbsp;&nbsp; <input type="submit" value="查询" class="btn btn-info"/>
  </form>
  
    <table border="1 #76aef0 solid" cellspacing="0" cellpadding="1" align="center" bgColor="#F0FFF0" width="1024" border="0">
    <tr>
        <td width="100">商品编号</td>
        <td width="100">分类名称</td>
        <td width="100">单位</td>
        <td width="100">概要商品名称</td>
        <td width="100">缩略图</td>
        <td width="100">高宽比</td>
        <td width="100">商品类型</td>
        <td width="100">状态(0为已下架)</td>
        <td width="100">上架或下架</td>
         <td width="100">删除</td>
    </tr>
     <s:iterator value="#request.birefGoodsList" id="list">
    <tr>
        <td width="100"><s:property value="#list.goods.goodcode"/></td>
        <td width="100"><s:property value="#list.goods.classify.name"/></td>
        <td width="100"><s:property value="#list.goods.unit"/></td>
        <td width="100"><s:property value="#list.goods.name"/></td>
        <td width="100"><img src="<%=root %>/<s:property value="#list.thumbPath"/>"/></td>
        <%-- <td width="100"><img src="./<s:property value="#list.thumbPath"/>"></td> --%>
        <td width="100"><s:property value="#list.ratio"/></td>
        
        <td width="100">
        <s:if test="%{#list.goods.productType==0}">
	        <select style="width: 100px;height: 35px" id="productType" onchange="changType(<s:property value="#list.goods.id"/>,this.value)">
	        	  <option value="0" selected="selected">普通商品</option>
	              <option value="1">热卖商品</option>
	             <option value="2">新品上货</option>
	        </select>
        </s:if>
        <s:if test="%{#list.goods.productType==1}">
	        <select style="width: 100px;height: 35px" id="productType" onchange="changType(<s:property value="#list.goods.id"/>,this.value)">
	        	  <option value="0" >普通商品</option>
	              <option value="1" selected="selected">热卖商品</option>
	             <option value="2">新品上货</option>
	        </select>
        </s:if>
        <s:if test="%{#list.goods.productType==2}">
	        <select style="width: 100px;height: 35px" id="productType" onchange="changType(<s:property value="#list.goods.id"/>,this.value)">
	        	  <option value="0" >普通商品</option>
	              <option value="1">热卖商品</option>
	             <option value="2" selected="selected">新品上货</option>
	        </select>
        </s:if>
        </td>
        
        
        <td width="100"><s:property value="#list.goods.state"/></td>
        <td width="100">
        <s:if test="%{#list.goods.state==1}">
           <input type="button" id="button" name="button"  class="btn btn-danger" value="下架" style="width: 100px;height: 40px" onclick="change(<s:property value="#list.goods.id"/>)"/>
        </s:if>
        <s:elseif test="%{#list.goods.state!=1}">
           <input type="button" id="button" name="button" class="btn btn-success" value="上架" style="width: 100px;height: 40px" onclick="change(<s:property value="#list.goods.id"/>)"/>
        </s:elseif>
        </td>
        <td width="100">
           <input type="button" id="button" name="button"   value="删除" style="width: 100px;height: 40px" onclick="deletegood(<s:property value="#list.goods.id"/>)"/>
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
                        
          <a href="querybriefgood.action?page=<s:property value='pageBean.firstPage'/>&productType=<s:property value='productType'/>">首页</a>
          <a href="querybriefgood.action?page=<s:property value='pageBean.previousPage'/>&productType=<s:property value='productType'/>">上一页</a>
          <a href="querybriefgood.action?page=<s:property value='pageBean.nextPage'/>&productType=<s:property value='productType'/>">下一页</a>
          <a href="querybriefgood.action?page=<s:property value='pageBean.lastPage'/>&productType=<s:property value='productType'/>">尾页</a>
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
function deletegood(goodsId){
	if(confirm("确定删除吗?删除后明细商品及分店绑定都将删除,但请手动删除商品图片")){
	   $.ajax({
	       type :"get",
	       url :"./deleteBriefgood.action",
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
	}
	};
</script>
<script type="text/javascript" src="./jquery/jquery-1.7.2.js"></script>
</html>
