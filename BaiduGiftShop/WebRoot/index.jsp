<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%-- 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
--%>
 <!-- 
<base href="http://localhost:8080/baidugift/">

${pageContext.request.contextPath}输出的是/baidugiftshop;有斜杠
-->

<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <title>BaiduGiftShop</title>
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
  body {
  margin: 0;
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  line-height: 20px;
  color: #333333;
  background-color: #ffffff;
}
  
  </style>  
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

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="lib/html5.js"></script>
    <![endif]-->
    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
  </head>
  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> ${user.account }
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">My Account</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="./logout.action">退出</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="index.jsp"><span class="first">Baidu</span> <span class="second">ShiftShop</span></a>
        </div>
    </div>
    
    <div class="sidebar-nav">
        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>首页</a>
        <ul id="accounts-menu" class="nav nav-list collapse">
                <li ><a href="./getAllUser.action">&nbsp&nbsp&nbsp分店用户管理</a></li>
            <li ><a href="user.jsp">&nbsp&nbsp&nbsp个人中心</a></li>
            <li ><a href="sdkupload.jsp">&nbsp&nbsp&nbsp文件上传</a></li>
        </ul>
        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>分类信息<span class="label label-info">2</span></a>
        <ul id="accounts-menu" class="nav nav-list collapse in">
            <li ><a href="./goods.action">&nbsp&nbsp&nbsp增加分类信息</a></li>
            <li ><a href="./listallBrief.action">&nbsp&nbsp&nbsp查询分类信息</a></li>
        </ul>
        <a href="#accounts-menu2" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>商品信息<span class="label label-info">2</span></a>
        <ul id="accounts-menu2" class="nav nav-list collapse in">
            <li ><a href="./briefGoods/addBriefGoods.jsp">&nbsp&nbsp&nbsp增加商品信息</a></li>
            <li ><a href="./queryAllBriefGoods.action">&nbsp&nbsp&nbsp查询商品信息</a></li>
        </ul>
        <a href="#accounts-menu3" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>商品明细<span class="label label-info">3</span></a>
        <ul id="accounts-menu3" class="nav nav-list collapse in">
            <li ><a href="./DetailGoods/addDetailGoods.jsp">&nbsp&nbsp&nbsp增加明细信息</a></li>
            <li ><a href="./listallDetailGoods.action">&nbsp&nbsp&nbsp查询明细商品</a></li>
            <li ><a href="./DetailGoods/ModifyDetailGoods.jsp">&nbsp&nbsp&nbsp修改明细商品</a></li>
        </ul>
        <a href="#accounts-menu4" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>图片组别<span class="label label-info">3</span></a>
        <ul id="accounts-menu4" class="nav nav-list collapse in">
            <li ><a href="./addPic.action">&nbsp&nbsp&nbsp增加一组图片</a></li>
            <li ><a href="./Picture/ShowPic.jsp">&nbsp&nbsp&nbsp查询一组图片</a></li>
            <li ><a href="./Picture/DeleteGroup.jsp">&nbsp&nbsp&nbsp删除一组图片</a></li>
        </ul>
        
 	 <a href="#accounts-menu5" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>订单管理<span class="label label-info">1</span></a></a>
        <ul id="accounts-menu5" class="nav nav-list collapse">
            <li ><a href="./ListAllOrder.action">&nbsp&nbsp&nbsp全部订单</a></li>
        </ul>
        <!-- <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>Error Pages <i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="403.html">403 page</a></li>
            <li ><a href="404.html">404 page</a></li>
            <li ><a href="500.html">500 page</a></li>
            <li ><a href="503.html">503 page</a></li>
        </ul> -->
         <a href="help.jsp" class="nav-header" ><i class="icon-question-sign"></i>帮助</a> 
    </div>
    <div class="content">
        <center>
        <br><br>
        <br><br>
        <br><br><br><br>
        <h1>Welcome Baidu GiftShop Managerment!</h1>
        </center>
    </div>
    <!-- <div class="content">
        <center>
        Welcome to BaiduGiftShop Manager System!
        </center>
    </div> -->

    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>
