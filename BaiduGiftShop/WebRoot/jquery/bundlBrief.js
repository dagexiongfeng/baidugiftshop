 function showBriefGoods(){
     var input = document.getElementsByTagName("input");
     var subbranchId = $("#subbranchId").val();
     var classifyId = $("#classifyId").val();
     $("#show").empty();
     $("#show").append($("<tr/>.").attr("id","tr"));
     $("#tr").append($("<td/>").text("名称").attr("width","100"));
     $("#tr").append($("<td/>").text("单位").attr("width","100"));
     $("#tr").append($("<td/>").text("是否绑定").attr("width","100"));
     $.ajax({
       type :"get",
	   url :"./querygoodsById.action",
	   data:"Id="+classifyId+"&page=1",
	   dataType :"json",
	   success:function(result){
	     var data = result.content;
	     var pagebean = result.list;
	      for(var n=0;n<data.length;n++){
	          var tTr = "<tr><td>"+data[n][0]+"</td><td>"+data[n][2]+"</td><td>"+"<input type='checkbox'; name='goodsId'; value='"+data[n][3]+"'; style='width: 20;height: 20' ></td></tr>";
	          $("#show").append(tTr);
	      }
	      $.ajax({
	      type : "post",
	      url : "./querySubBrief.action",
	      data : {subbranchId:subbranchId},
	      dataType : "json",
	      success:function(result){
	        var classify = result.content;
	        for(var k=0;k<classify.length;k++){
	          for(var n=0;n<data.length;n++){
	            if(classify[k]==data[n][3]){
	               var j=n+1;
	               input[j].checked=true;
	            }else{
	            }
	          }
	        }
	      }
	      });
	    pageStr="<center><span>共<input type='text' style='height:25px;width:35px' value='"+pagebean.allPage+"' readonly/>页</span>";
	    pageStr+="<span><a href='javascript:void(0)' rel='"+pagebean.previousPage+"'>上一页</a></span> ";
	    pageStr+="<span><a href='javascript:void(0)' rel='"+pagebean.nextPage+"'>下一页</a></span>";
	    pageStr+="<span>跳转到<input type='text' id='change' style='height:25px;width:40px' onblur='change()'/></span></center>";
	    $("#pagecount").html(pageStr); 
	   }
     });
 }
 //提交更新的方法
function subBriefGoods(){
   var rows = document.getElementById("show").rows; 
   var a = document.getElementsByName("goodsId"); 
   window["ss"]=0;
   for(var i=0;i<a.length;i++) { 
		if(a[i].checked){ 
		  var row = a[i].parentElement.parentElement.rowIndex; 
		  //alert(a[i].value); 
		  //alert(rows[row].cells[12].innerHTML); 
		  var goodsId=a[i].value;
		  var subbranchId = $("#subbranchId").val();
		  var classifyId = $("#classifyId").val();
		   $.ajax({
		     type: "get",
		     url :"./subBriefGoods.action",
		     data :"subbranchId="+subbranchId+"&goodsId="+goodsId+"&classifyId="+classifyId,
		     dataType:"json",
		     success :function(result){
			     var content = result.content;
			     if(content==101){
			       window["ss"]++;
			     }else{
			       alert("绑定过程中"+rows[row].cells[0].innerHTML+"发生错误,已下架！");
			     }
		     },
		   async:false
		   });
		}else{
			  var row = a[i].parentElement.parentElement.rowIndex; 
			  //alert(a[i].value); 
			  //alert(rows[row].cells[12].innerHTML); 
			  var goodsId=a[i].value;
			  var subbranchId = $("#subbranchId").val();
			   $.ajax({
			     type: "get",
			     url :"./deletesubBriefGoods.action",
			     data :"subbranchId="+subbranchId+"&goodsId="+goodsId,
			     dataType:"json",
			     success :function(result){
				     var content = result.content;
				     if(content==101){
				       window["ss"]++;
				     }else{
				       alert("绑定过程中"+rows[row].cells[0].innerHTML+","+a[i].value+"发生错误！！！");
				     }
			     },
			    async:false
			  });
			}
		}
		if(window["ss"]==a.length){
		 alert("数据库更新完成！！！");
		}
		}

function showGoods(page){
     var input = document.getElementsByTagName("input");
     var subbranchId = $("#subbranchId").val();
     var classifyId = $("#classifyId").val();
     $("#show").empty();
     $("#show").append($("<tr/>.").attr("id","tr"));
     $("#tr").append($("<td/>").text("名称").attr("width","100"));
     $("#tr").append($("<td/>").text("单位").attr("width","100"));
     $("#tr").append($("<td/>").text("是否绑定").attr("width","100"));
     $.ajax({
       type :"get",
	   url :"./querygoodsById.action",
	   data:"Id="+classifyId+"&page="+page,
	   dataType :"json",
	   success:function(result){
	      var data = result.content;
	      var pagebean = result.list;
	      for(var n=0;n<data.length;n++){
	          var tTr = "<tr><td>"+data[n][0]+"</td><td>"+data[n][1]+"</td><td>"+"<input type='checkbox'; name='goodsId'; value='"+data[n][2]+"'; style='width: 20;height: 20' ></td></tr>";
	          $("#show").append(tTr);
	      }
	      $.ajax({
	      type : "post",
	      url : "./querySubBrief.action",
	      data : {subbranchId:subbranchId},
	      dataType : "json",
	      success:function(result){
	        var classify = result.content;
	        for(var k=0;k<classify.length;k++){
	          for(var n=0;n<data.length;n++){
	            if(classify[k]==data[n][2]){
	               var j=n+1;
	               input[j].checked=true;
	            }else{
	            }
	          }
	        }
	      }
	      });
	    pageStr="<center><span>共<input type='text' style='height:25px;width:35px' value='"+pagebean.allPage+"' readonly/>页</span>";
	    pageStr+="<span><a href='javascript:void(0)' rel='"+pagebean.previousPage+"'>上一页</a></span> ";
	    pageStr+="<span><a href='javascript:void(0)' rel='"+pagebean.nextPage+"'>下一页</a></span>";
	    pageStr+="<span>跳转到<input type='text' id='change' style='height:25px;width:40px' onblur='change()'/></span></center>";
	    $("#pagecount").html(pageStr); 
	   }
     });
 }
 
 function change(){
  var page = $("#change").val();
  if(page!=0){
    showGoods(page);
  }else{
    page = 1;
    showGoods(page);
  }
 }