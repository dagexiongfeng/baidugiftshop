<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="jquery/jquery-1.7.2.js"></script>
</head>
</body>
<form name=formTest action="addpicgroup.action" method="post" 
enctype="multipart/form-data"> 
<input name="up" type="submit" value="上传" /> 
<button type="button" onclick='addRow();'>加入一行</button>
<button type="button" onclick='deleteRow()'>删除一行</button><br/>
<input type="file" size="30" name="test" id="test"/> 
<br /> 
</form>
<script language=javascript>
function addRow(){
var f = document.forms['formTest'];
var input = document.createElement('input');
input.setAttribute("type","file");
input.setAttribute("size","30");
input.setAttribute("name","test");
input.setAttribute("id", "test");
f.appendChild(input);
var br = document.createElement('br');
f.appendChild(br);
}
function deleteRow(){
$("#test").remove(); 
}
</script>
</body> 
</html>