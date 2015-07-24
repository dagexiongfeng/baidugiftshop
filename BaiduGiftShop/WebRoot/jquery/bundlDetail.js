function updateSelect(){
 var classifyId = $("#classifyId").val();
 var subbranchId = $("#subbranchId").val();
 $("#goodsId").empty();
 $("#goodsId").append($("<option/>").text("-----------请选择-----------").attr("value","0"));
  $.ajax({
    type:"post",
    url:"./querySubgoods.action",
    data:"Id="+classifyId+"&subbranchId="+subbranchId,
    dataType :"json",
    success :function(result){
    var data = result.content;
	 for(var n=0;n<data.length;n++){
	  var names = data[n][0];
	  $("#goodsId").append("<option id='"+names+"' value='"+data[n][2]+"'>"+names+"</option>");
	 }
    }
});
}
function showDetail(){
     var goodsId = $("#goodsId").val();
     var subbranchId = $("#subbranchId").val();
     var input = document.getElementsByTagName("input");
     $("#show").empty();
     $("#show").append($("<tr/>").attr("id","tr"));
     $("#tr").append($("<td/>").text("商品名称").attr("width","120"));
     $("#tr").append($("<td/>").text("商品代码").attr("width","120"));
     $("#tr").append($("<td/>").text("店内码").attr("width","100"));
     $("#tr").append($("<td/>").text("条形码").attr("width","100"));
     $("#tr").append($("<td/>").text("分类属性1").attr("width","140"));
     $("#tr").append($("<td/>").text("分类属性2").attr("width","140"));
     $("#tr").append($("<td/>").text("分类属性3").attr("width","140"));
     $("#tr").append($("<td/>").text("分类属性4").attr("width","140"));
     $("#tr").append($("<td/>").text("进价").attr("width","100"));
     $("#tr").append($("<td/>").text("最后进价").attr("width","120"));
     $("#tr").append($("<td/>").text("零售价").attr("width","100"));
     $("#tr").append($("<td/>").text("成本价").attr("width","100"));
     $("#tr").append($("<td/>").text("数量").attr("width","100").attr("id","amount"));
     $("#tr").append($("<td/>").text("是否绑定").attr("width","120"));
   $.ajax({
     type : "get",
     url :"./listDetailByGid.action",
     data :"goodsId="+goodsId+"&subbranchId="+subbranchId,
     dataType:"json",
   success :function(result){
     var data = result.content;
     var pagebean = result.list;
     for(var n=0;n<data.length;n++){
       var detail = data[n];
       var tTr = "<tr><td>"+detail.name+"</td>"+
       "<td>"+detail.goodsCode+"</td>"+
       "<td>"+detail.shopCode+"</td>"+
       "<td>"+detail.barCode+"</td>"+
       "<td>"+detail.type1+"</td>"+
       "<td>"+detail.type2+"</td>"+
       "<td>"+detail.type3+"</td>"+
       "<td>"+detail.type4+"</td>"+
       "<td>"+detail.stockPrice+"</td>"+
       "<td>"+detail.lastStockPrice+"</td>"+
       "<td>"+detail.retailPrice+"</td>"+
       "<td>"+detail.costPrice+"</td>"+
       "<td>"+detail.picGroupId+"</td>"+
       "<td>"+"<input type='checkbox'; name='goodsDetId'; value='"+detail.id+"'; style='width: 20;height: 20' ></td></tr>";
       $("#show").append(tTr);
     }
     $.ajax({
     type :"get",
     url :"./querySubDetail.action",
     data :{subbranchId:subbranchId},
     dataType :"json",
     success:function(result){
	        var detail = result.content;
	        for(var k=0;k<detail.length;k++){
	          for(var n=0;n<data.length;n++){
	            if(detail[k]==data[n].id){
	               var j=n+1;
	               input[j].checked=true;
	            }else{
	            }
	          }
	        }
	      }
     });
   var tbmain=document.getElementById("show"); 
   for(var i=1;i<tbmain.rows.length;i++) 
    { 
       /* 
               添加单击事件属性。此处不可使用setAttribute方法。 
       */ 
      tbmain.rows[i].cells[12].onclick=AddObjOfText; 
    }
    
        pageStr="<center><span>共<input type='text' style='height:25px;width:35px' value='"+pagebean.allPage+"' readonly/>页</span>";
	    pageStr+="<span><a href='javascript:void(0)' rel='"+pagebean.previousPage+"'>上一页</a></span> ";
	    pageStr+="<span><a href='javascript:void(0)' rel='"+pagebean.nextPage+"'>下一页</a></span>";
	    pageStr+="<span>跳转到<input type='text' id='change' style='height:25px;width:40px' onblur='change()'/></span></center>";
	    $("#pagecount").html(pageStr);
   }
   }); 
}
/*
*/
function showDetailGoods(page){
     var goodsId = $("#goodsId").val();
     var subbranchId = $("#subbranchId").val();
     var input = document.getElementsByTagName("input");
     $("#show").empty();
     $("#show").append($("<tr/>").attr("id","tr"));
     $("#tr").append($("<td/>").text("商品名称").attr("width","120"));
     $("#tr").append($("<td/>").text("商品代码").attr("width","120"));
     $("#tr").append($("<td/>").text("店内码").attr("width","100"));
     $("#tr").append($("<td/>").text("条形码").attr("width","100"));
     $("#tr").append($("<td/>").text("分类属性1").attr("width","140"));
     $("#tr").append($("<td/>").text("分类属性2").attr("width","140"));
     $("#tr").append($("<td/>").text("分类属性3").attr("width","140"));
     $("#tr").append($("<td/>").text("分类属性4").attr("width","140"));
     $("#tr").append($("<td/>").text("进价").attr("width","100"));
     $("#tr").append($("<td/>").text("最后进价").attr("width","120"));
     $("#tr").append($("<td/>").text("零售价").attr("width","100"));
     $("#tr").append($("<td/>").text("成本价").attr("width","100"));
     $("#tr").append($("<td/>").text("数量").attr("width","100").attr("id","amount"));
     $("#tr").append($("<td/>").text("是否绑定").attr("width","120"));
   $.ajax({
     type : "get",
     url :"./listDetailByGid.action",
     data :"goodsId="+goodsId+"&subbranchId="+subbranchId+"&page="+page,
     dataType:"json",
   success :function(result){
     var data = result.content;
     var pagebean = result.list;
     for(var n=0;n<data.length;n++){
       var detail = data[n];
       var tTr = "<tr><td>"+detail.name+"</td>"+
       "<td>"+detail.goodsCode+"</td>"+
       "<td>"+detail.shopCode+"</td>"+
       "<td>"+detail.barCode+"</td>"+
       "<td>"+detail.type1+"</td>"+
       "<td>"+detail.type2+"</td>"+
       "<td>"+detail.type3+"</td>"+
       "<td>"+detail.type4+"</td>"+
       "<td>"+detail.stockPrice+"</td>"+
       "<td>"+detail.lastStockPrice+"</td>"+
       "<td>"+detail.retailPrice+"</td>"+
       "<td>"+detail.costPrice+"</td>"+
       "<td>"+detail.picGroupId+"</td>"+
       "<td>"+"<input type='checkbox'; name='goodsDetId'; value='"+detail.id+"'; style='width: 20;height: 20' ></td></tr>";
       $("#show").append(tTr);
     }
     $.ajax({
     type :"get",
     url :"./querySubDetail.action",
     data :{subbranchId:subbranchId},
     dataType :"json",
     success:function(result){
	        var detail = result.content;
	        for(var k=0;k<detail.length;k++){
	          for(var n=0;n<data.length;n++){
	            if(detail[k]==data[n].id){
	               var j=n+1;
	               input[j].checked=true;
	            }else{
	            }
	          }
	        }
	      }
     });
   var tbmain=document.getElementById("show"); 
   for(var i=0;i<tbmain.rows.length;i++) 
    { 
       /* 
               添加单击事件属性。此处不可使用setAttribute方法。 
       */ 
      tbmain.rows[i].cells[12].onclick=AddObjOfText; 
    }
    
        pageStr="<center><span>共<input type='text' style='height:25px;width:35px' value='"+pagebean.allPage+"' readonly/>页</span>";
	    pageStr+="<span><a href='javascript:void(0)' rel='"+pagebean.previousPage+"'>上一页</a></span> ";
	    pageStr+="<span><a href='javascript:void(0)' rel='"+pagebean.nextPage+"'>下一页</a></span>";
	    pageStr+="<span>跳转到<input type='text' id='change' style='height:25px;width:40px' onblur='change()'/></span></center>";
	    $("#pagecount").html(pageStr);
   }
   });
}

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

function getTDtext() 
{
var rows = document.getElementById("show").rows; 
var a = document.getElementsByName("goodsDetId"); 
window["ss"]=0;
for(var i=0;i<a.length;i++) 
{ 
if(a[i].checked){ 
var row = a[i].parentElement.parentElement.rowIndex; 
//alert(a[i].value); 
//alert(rows[row].cells[12].innerHTML); 
var goodsDetId=a[i].value;
var amount = rows[row].cells[12].innerHTML;
var subbranchId = $("#subbranchId").val();
   $.ajax({
     type: "get",
     url :"./subDetailGoods.action",
     data :"subbranchId="+subbranchId+"&amount="+amount+"&goodsDetId="+goodsDetId,
     dataType:"json",
   success :function(result){
     var content = result.content;
     if(content==101){
       window["ss"]++;
     }else{
       //alert("绑定过程中"+rows[row].cells[12].innerHTML+","+a[i].value+"发生错误！！！");
       alert("绑定失败！商品可能已下架！");
     }
   },
   async:false
});
}else{
  var row = a[i].parentElement.parentElement.rowIndex; 
  //alert(a[i].value); 
  //alert(rows[row].cells[12].innerHTML); 
  var goodsDetId=a[i].value;
  var subbranchId = $("#subbranchId").val();
   $.ajax({
     type: "get",
     url :"./deleteSubDetGoods.action",
     data :"subbranchId="+subbranchId+"&goodsDetId="+goodsDetId,
     dataType:"json",
   success :function(result){
     var content = result.content;
     if(content==101){
       window["ss"]++;
     }else{
       alert("绑定过程中"+rows[row].cells[12].innerHTML+","+a[i].value+"发生错误！！！");
     }
   },
   async:false
});
} 
}
if(window["ss"]==a.length){
 alert("更新完成！！！");
}
} 
 function change(){
  var page = $("#change").val();
  if(page!=0){
    showDetailGoods(page);
  }else{
    page = 1;
    showDetailGoods(page);
  }
 }