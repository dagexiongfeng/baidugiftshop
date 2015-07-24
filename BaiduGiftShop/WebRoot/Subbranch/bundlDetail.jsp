<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>分店绑定具体的商品信息</title>
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
             <input type="hidden" id="subbranchId" name="subbranchId" value=${user.subbranchId }>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                 分类名称：    &nbsp;&nbsp;&nbsp;
							<select id="classifyId" name="classifyId" onchange="updateSelect()">
                             <option value="0">-----------请选择-----------</option>
                                  </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                  商品名称： &nbsp;&nbsp;&nbsp;
							<select id="goodsId" name="goodsId" onchange="showDetail()">
                             <option value="0">-----------请选择-----------</option>
                                  </select><br>
  <table id="show" border="1 #76aef0 solid" cellspacing="0" cellpadding="1" align="center" bgColor="#E4E8EF" width="1024" border="0">
    <tr id="tr">
        <td width="120">商品名称</td>
        <td width="120">商品代码</td>
        <td width="100">店内码</td>
        <td width="100">条形码</td>
        <td width="140">分类属性1</td>
        <td width="140">分类属性2</td>
        <td width="140">分类属性3</td>
        <td width="140">分类属性4</td>
        <td width="100">进价</td>
        <td width="120">最后进价</td>
        <td width=100>零售价</td>
        <td width="100">成本价</td>
        <td width="100" id="amount">数量</td>
        <td width="120">是否选中</td>
    </tr>
  </table><br>
  <div id="pagecount"></div>
  <center>
  <input type="button" value="更新" style=" width:100px " onclick="getTDtext()" class="btn btn-primary"/><br>   
  <a href="./Subbranch/Index.jsp">返回首页</a>
  </center>  
  </body>
  
<script type="text/javascript">
 window.onload = function(){
     var subbranchId = $("#subbranchId").val();
	 $.ajax({
	 type :"get",
	 url :"./querySubClas.action",
	 data:{subbranchId:subbranchId},
	 dataType :"json",
	 success :function(result){
	 var data = result.content;
	 for(var n=0;n<data.length;n++){
	  var names = data[n].name;
	  $("#classifyId").append("<option id='"+data[n].id+"' value='"+data[n].id+"'>"+names+"</option>");
	 }
	 }
     });
     $("#pagecount span a").live('click',function(){ 
        var rel = $(this).attr("rel"); 
        if(rel){ 
            showDetailGoods(rel); 
        } 
    });
     };
</script>
<script type="text/javascript" src="./jquery/bundlDetail.js"></script>
</html>
