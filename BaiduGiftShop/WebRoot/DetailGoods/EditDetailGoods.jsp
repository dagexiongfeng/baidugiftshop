<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'EditDetailGoods.jsp' starting page</title>
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
   <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">修改详细商品信息</p>
            <div class="block-body">
   <form action="addDetailGoods.action" method="post">
                           <input type="hidden" id="goodsDetaiId" name="goodsDetai.id" value="${goodsdetai.id }"/> 
                           <input type="hidden" id="classifyId" name="classifyId" value="${goodsdetai.goods.classify.id }"/>
                                 分类名称：    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   
							<input type="text" id="classifyName" name="classifyName" value="${goodsdetai.goods.classify.name }" readonly/><br>
                                  商品名称： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                  
                            <input type="text" id="goodsId" name="goodsId" value="${goodsdetai.goods.name }" readonly><br> 
							
                                  图片组ID：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                  
                            <input type="text" id="picGroupId" name="goodsDetai.picGroupId" value="${goodsdetai.picGroupId }"/><br>
                                  商品名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                  
                                  <input type="text" id="name" name="goodsDetai.name" size="20" value="${goodsdetai.name }"/><br>
                                  商品代码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                  
                                  <input type="text" id="goodsCode" name="goodsDetai.goodsCode" size="20" value="${goodsdetai.goodsCode }"/><br>
                                  店内代码:<input type="text" id="shopCode" name="goodsDetai.shopCode" size="20" value="${goodsdetai.shopCode }"/><br>
                                  
                                  条形码:<input type="text" id="barCode" name="goodsDetai.barCode" size="20" value="${goodsdetai.barCode }"/><br>
                                 
                                  分类属性1:<input type="text" id="type1" name="goodsDetai.type1" size="20" value="${goodsdetai.type1 }"/><br>
                                
                                  分类属性2:<input type="text" id="type2" name="goodsDetai.type2" size="20" value="${goodsdetai.type2 }"/><br>
                                
                                  分类属性3:<input type="text" id="type3" name="goodsDetai.type3" size="20" value="${goodsdetai.type3 }"/><br>
                                  
                                  分类属性4:<input type="text" id="type4" name="goodsDetai.type4" size="20" value="${goodsdetai.type4 }"/><br>
                                 
                                  进价*:(单位:元)<input type="text" id="stockPrice" name="goodsDetai.stockPrice" size="20" value="${goodsdetai.stockPrice }"/><br>
                                
                                  最后进价*:(单位:元)<input type="text" id="lastStockPrice" name="goodsDetai.lastStockPrice" size="20" value="${goodsdetai.lastStockPrice }"/><br>
                                  
                                  零售价*:(单位:元)<input type="text" id="retailPrice" name="goodsDetai.retailPrice" size="20" value="${goodsdetai.retailPrice }"/><br>
                                
                                  成本价*:(单位:元)<input type="text" id="costPrice" name="goodsDetai.costPrice" size="20" value="${goodsdetai.costPrice }"/><br>
              
              <input type="submit" value="Submit"/>
     </form>
     </div>
     </div>
     </div>
     </div>
  </body>
</html>
