<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>百度手机APP</title>
	

</head>
<body>
					<div align="center">
						<form action="register.action" method="post" name="form1">
							用户注册<br>
							用户名:<input type="text" id="account" name="account" size="20" onblur="valuationUsername()"/><br><br>
							密&nbsp;&nbsp;码:<input type="password" name="password" size="20"/><br><br>
							分店地址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select id="subbranch" name="subbranch">
                             <option value="0">---请选择---</option>
                                  </select><br><br>
                                                                      邮箱：<input type="text" id="email" name="email" onblur="valuationEmail()"/><br><br>
                                                                      电话：<input type="text" id="tel" name="tel"/><br><br>                                          
							<input type="submit" value="注册"/>
						</form>
					</div>
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
	  //var ids = data[n].id;
	  //var names = data[n].name;
	  $("#subbranch").append("<option id='"+data[n].id+"' value='"+data[n].name+"'>"+data[n].name+"</option>");
	 }
	 }
     });
     };
function valuationUsername(){
     var account = $("#account").val();
     if(account==""){
    	 alert("用户名不能为空");
    	 document.getElementById("account").focus();
     }
     $.ajax({
     type :"get",
     url :"./valuationUsername.action",
     data :{account:account},
     dataType :"json",
     success :function(result){
    var data = result.content;
    if(data){
    alert("用户名已存在");
    }else{
    }
    }
     });
     }
     function valuationEmail(){
     var email = $("#email").val();
     if(email==""){
    	 alert("邮箱不能为空");
    	 document.getElementById("email").focus();
     }
     $.ajax({
     type :"get",
     url :"./valuationEmail.action",
     data :{email:email},
     dataType :"json",
     success :function(result){
    var data = result.content;
    if(data){
    alert("邮箱已经注册");
    }else{
    }
    }
     });
     }

	</script>
<script type="text/javascript" src="./jquery/jquery-1.7.2.js"></script>
</html>