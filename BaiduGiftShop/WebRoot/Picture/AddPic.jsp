<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <title>My JSP 'fileUpLoad.jsp' starting page</title> 
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	//检查商品编号是否存在
	function checkpictureCode(){
		
		var groupId = $("#groupId").val();
		$.ajax({
		    type:"post",
		    url:"./checkpicgroupId.action",
		    data:{groupId:groupId},
		    dataType :"json",
		    success :function(result){
		    var data = result.content;
			 if(data==102){
				 alert("商品图片编号已存在！");
				 document.getElementById("goodsCode").focus();
			 }
		    }
		});
	}
	
	</script>
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
            <p class="block-heading">添加商品的大小要求寬度480~1024,以jpg,gif,png,jpeg为后缀的正方形图片。</p>
               <div class="block-body">
             
                  <s:form action ="addpicgroup.action" method ="POST" enctype ="multipart/form-data" >   
                                            明细商品名称:<input type="text" name="picGroupName" style="width: 165px;height: 25px"><br/>                          
                                            商品图片编号:<input type="text"   id="groupId" name="groupId"   style="width: 165px;height: 23px"  onblur="checkpictureCode()">(与商品编号一致)
                  <s:file name ="myFile" label ="Image File1"/>  
  
                  <s:file name ="myFile" label ="Image File2"/>  
  
                  <s:file name ="myFile" label ="Image File3"/>  
                  
                  <s:file name ="myFile" label ="Image File4"/>  
                  
                  <s:file name ="myFile" label ="Image File5"/> 
  
                  <s:submit value="提交" class="btn btn-primary"/>  
                    </s:form>    
              </div>
              </div>
              <a href="./index.jsp">返回首页</a>
              </div>
              </div>
                
  </body>  
</html>  
