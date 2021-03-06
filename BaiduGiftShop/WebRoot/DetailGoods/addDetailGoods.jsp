<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>增加明细商品信息</title>
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
            <p class="block-heading">添加商品信息</p>
            <div class="block-body">
  <form action="addDetailGoods.action" method="post" name="form" onsubmit="return beforeSubmit(this);">
                                  分类名称：    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select id="classifyId" name="classifyId" onchange="updateSelect()">
                             <option value="0">---请选择---</option>
                                  </select><br>
                                  商品名称： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select id="goodsId" name="goodsId" onchange="changname(this.value)">
                             <option value="0">---请选择---</option>
                                  </select><br>
                        <!--           图片编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select id="picGroupId" name="goodsDetai.picGroupId">
                             <option value="0">---请选择---</option>
                                  </select><br> --> 
                                   图片编号: 
                                  <input type="text" id="picGroupId"  name="goodsDetai.picGroupId" readonly="readonly"  class="span12"  /><br>
                                  商品名: 
                                  <input type="text" id="name" name="goodsDetai.name" class="span12" /><br>
                                  商品编号:
                                  <input type="text" id="goodsCode" name="goodsDetai.goodsCode" readonly="readonly"  class="span12" /><br>
                     <!--             店内代码:
                                  <input type="text" id="shopCode" name="goodsDetai.shopCode" class="span12"/><br> -->
                                  条形码:
                                  <input type="text" id="barCode" name="goodsDetai.barCode"   onblur="checkbarcode()" class="span12"/><br>
                                  分类属性1:(颜色)
                                  <input type="text" id="type1" name="goodsDetai.type1" class="span12"/><br>
                                  分类属性2:(大小)
                                  <input type="text" id="type2" name="goodsDetai.type2" class="span12"/><br>
                                  分类属性3:
                                  <input type="text" id="type3" name="goodsDetai.type3" class="span12"/><br>
                                  分类属性4:
                                  <input type="text" id="type4" name="goodsDetai.type4" class="span12"/><br>
                                  进价*:(单位:元)
                                  <input type="text" id="stockPrice" name="goodsDetai.stockPrice" class="span12"/><br>
                                  百度员工价*:(单位:元)
                                  <input type="text" id="baiduPrice" name="goodsDetai.baiduPrice" class="span12"/><br>
                                  零售价*:(单位:元)
                                  <input type="text" id="retailPrice" name="goodsDetai.retailPrice" class="span12"/><br>
                        <!--                     成本价*:(单位:元)
                                  <input type="text" id="costPrice" name="goodsDetai.costPrice" class="span12"/><br>-->
                                  <input type="submit" value="Submit" class="btn btn-primary"/>  
       </form>    
       </div>
       </div>
       </div>
       </div>                     
  </body>
<script type="text/javascript">
 window.onload = function(){ 
	 //查出所有的分类
	 $.ajax({
		 type :"post",
		 url :"./allclassify.action",
		 dataType :"json",
		 success :function(result){
		 var data = result.content;
			 for(var n=0;n<data.length;n++){
			  $("#classifyId").append("<option id='"+data[n].id+"' value='"+data[n].id+"'>"+data[n].name+"</option>");
			 }
		 }
     });
      //查出商品图片
     $.ajax({
    	 type :"post",
    	 url :"./listgroupId.action",
    	 dataType :"json",
    	 success :function(data){
    		 $.each(data.content,function(i,n){
    			  $("#picGroupId").append("<option id='"+n.id+"' value='"+n.id+"'>"+n.id+":  "+n.picGroupName+"</option>");
    		 })
    	   }
         });
     };
    
     function beforeSubmit(form){
    	
	    if(form.classifyId.value=='0'){
		 alert('没有选择分类');
		 form.classifyId.focus();
		 return false;
		 }
		 if(form.goodsId.value=='0'){
		 alert('没有选择概要商品');
		 form.goodsId.focus();
		 return false;
		 }
		 if(form.picGroupId.value=='0'){
			 alert('没有选择图片Id');
			 form.picGroupId.focus();
			 return false;
	     }
		 if(form.goodsCode.value==''){
			 alert('没有填写商品代码');
   		 form.goodsCode.focus();
   		 return false;
		 }
		 if(form.stockPrice.value==''){
			 alert('没有填写进价');
   		 form.stockPrice.focus();
   		 return false;
		 }
		 if(form.baiduPrice.value==''){
			 alert('没有填写百度员工价');
   		 form.baiduPrice.focus();
   		 return false;
		 }
		 if(form.retailPrice.value=='') {
			 alert('没有填写零售价');
			 form.retailPrice.focus();
			 return false;
		 }
		
}
    
     function changname(value){
    	 $("#picGroupId").val(value);
    	 $("#goodsCode").val(value);
    	 checkpic( $("#picGroupId").val());
     };
     
     //查出所有的商品名称
function updateSelect(){
 var classifyId = $("#classifyId").val();
 $("#goodsId").empty();
 $("#goodsId").append($("<option/>").text("---请选择---").attr("value","0"));
  $.ajax({
    type:"post",
    url:"./querygoodsById.action",
    data:{Id:classifyId},
    dataType :"json",
    success :function(result){
    var data = result.content;
	 for(var n=0;n<data.length;n++){
	  var names = data[n][0];
	  var goodcode = data[n][1];
	  $("#goodsId").append("<option id='"+names+"' value='"+goodcode+"'>"+names+"</option>");

	 }
    }
});
}
     //查询图片组中收否已添加改组图片
   
     function checkpic(picid){
    		$.ajax({
    		    type:"post",
    		    url:"./checkpic.action",
    		    data:{groupId:picid},
    		    dataType :"json",
    		    success :function(result){
    		    var data = result.content;
    			 if(data==102){
    				 alert("！图片编号不存在,请先添加图片");
    				//return true;
    			 }
    		    }
    		});
     }

//检查商品编号是否存在
function checkbarcode(){
	var barCode = $("#barCode").val();
	$.ajax({
	    type:"post",
	    url:"./checkbarcode.action",
	    data:{barCode:barCode},
	    dataType :"json",
	    success :function(result){
	    var data = result.content;
		 if(data==102){
			 alert("商品条形码已存在！");
			 document.getElementById("barCode").focus();
		 }
	    }
	});
}
</script>
<script type="text/javascript" src="./jquery/jquery-1.7.2.js"></script>  
</html>
