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
    <title>My JSP 'queryDetailGoods.jsp' starting page</title>
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
   查询的商品条形码:<input type="text" name="barCode" style="height: 35"/>(*必填)&nbsp;&nbsp;&nbsp;&nbsp;
     查询的商品ID:<input type="text" name="goodsDetailId" style="height: 35"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="submit" value="查询" class="btn btn-info"/>
  </form>
   <table id="show" border="1 #76aef0 solid" cellspacing="0" cellpadding="1" align="center" bgColor="#E4E8EF" width="" border="0">
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
    <s:iterator value="#request.list" id="list">
    <tr>
        <td width="50"><s:property value="#list.id"/></td>
        <td width="70"><s:property value="#list.goods.name"/></td>
        <td width="70"><s:property value="#list.name"/></td>
        <td width="70"><s:property value="#list.goodsCode"/></td>
        <td width="50"><s:property value="#list.shopCode"/></td>
        <td width="50"><s:property value="#list.barCode"/></td>
        <td width="80"><s:property value="#list.type1"/></td>
        <td width="80"><s:property value="#list.type2"/></td>
        <td width="80"><s:property value="#list.type3"/></td>
        <td width="80"><s:property value="#list.type4"/></td>
        <td width="80"><s:property value="#list.picGroupId"/></td>
        <td width="50"><s:property value="#list.stockPrice"/></td>
        <td width="50"><s:property value="#list.lastStockPrice"/></td>
        <td width="70"><s:property value="#list.retailPrice"/></td>
        <td width="50"><s:property value="#list.costPrice"/></td>
        <td width="100"><s:property value="#list.state"/></td>
        <td width="100">
         <s:if test="%{#list.state==1}">
            <input type="button" id="button" name="button" class="btn btn-danger" value="下架" style="width: 100px;height: 40px" onclick="change(<s:property value="#list.id"/>)"/>
        </s:if>
        <s:elseif test="%{#list.state!=1}">
            <input type="button" id="button" name="button" class="btn btn-success" value="上架" style="width: 100px;height: 40px" onclick="change(<s:property value="#list.id"/>)"/>
        </s:elseif>
        </td>
    </tr>
    </s:iterator>
    </table>
    <br>
    <table  border="0" align="center">
    <s:iterator value="#request.pageBean" id="pageBean">
    <tr>
      <td bgcolor="#E0EEEE" colspan="10">
                          第<s:property value="pageBean.currentPage" />页
                         共<s:property value="pageBean.allPage"/>页
                        
      <a href="listallDetailGoods.action?page=<s:property value='pageBean.firstPage'/>">首页</a>
      <a href="listallDetailGoods.action?page=<s:property value='pageBean.previousPage'/>">上一页</a>
      <a href="listallDetailGoods.action?page=<s:property value='pageBean.nextPage'/>">下一页</a>
      <a href="listallDetailGoods.action?page=<s:property value='pageBean.lastPage'/>">尾页</a>
              共<s:property value="pageBean.allRecords"/>条
      </td>
    </tr>
    </s:iterator>
    </table>
    <center>
      <a href="./index.jsp" class="btn btn-info">返回首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="./DetailGoods/addDetailGoods.jsp" class="btn btn-info">添加商品</a>
    </center>
  </body>
  <script type="text/javascript">
  window.onload = function(){
  var tbmain=document.getElementById("show"); 
   for(var i=1;i<tbmain.rows.length;i++) 
    { 
       /* 
               添加单击事件属性。此处不可使用setAttribute方法。 
       */ 
      tbmain.rows[i].cells[10].onclick=AddObjOfText; 
    }
  };
  /* 
单击事件，将Td内容更新为一个Div，其中装载了一个Text，用于用户输入新的Td的值， 
一个确定按钮，一个取消按钮，用于保存或取消用户的输入内容。 
一个Hidden，保存用户输入新值前的Td的值，以便用户取消时恢复。 
*/ 
function AddObjOfText() 
{ 
var tdcag=document.getElementById("tdcag"); 
if(tdcag!=null) 
{ 
return; 
} 

var tdid=window.event.srcElement; 
var tdtxt=tdid.innerText; 

var str="<div id='tdcag'><input type='text' id='txtId' value='"+tdtxt+"'>"; 
str+="<input type='button' value='确定' onclick='ChangeTdText()'>"; 
str+="<input type='button' value='取消' onclick='CancelTdChanged()'>"; 
str+="<input type='hidden' id='tdInitValue' value='"+tdtxt+"'>"; 
str+="</div>"; 
tdid.innerHTML=str; 

} 
/* 
取消更改，把Hidden值赋给Td 
*/ 
function CancelTdChanged() 
{ 
var tdInitValue=document.getElementById("tdInitValue"); 
var tdtxt=tdInitValue.value; 
var tdid=document.getElementById("tdcag").parentNode; 
tdid.innerText=tdtxt; 
} 
/* 
保存用户更改，把Text值赋值给Td 
*/ 
function ChangeTdText() 
{ 
var txtId=document.getElementById("txtId"); 
var tdid=document.getElementById("tdcag").parentNode; 
tdid.innerText=txtId.value;
} 

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
            alert("更新失败！概要商品可能已下架");
          }
       }
     });
   };
  </script>
  <script type="text/javascript" src="./jquery/jquery-1.7.2.js"></script>
</html>
