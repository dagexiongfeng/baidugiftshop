<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <base href="<%=basePath%>">
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
                            <li><a tabindex="-1" href="./logout.action">Logout</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="./Subbranch/index.jsp"><span class="first">Baidu</span> <span class="second">ShiftShop</span></a>
        </div>
    </div>
    

    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>首页</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li ><a href="./Subbranch/Index.jsp">Home</a></li>
            <li ><a href="reset-password.jsp">Rset Password</a></li>
            <li ><a href="./Subbranch/user.jsp">Sample Item</a></li>
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>分类信息<span class="label label-info">1</span></a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="./subbranchClassify.action">&nbsp&nbsp&nbsp 绑定分类信息</a></li>
        </ul>
        <a href="#accounts-menu2" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>概要商品<span class="label label-info">1</span></a>
        <ul id="accounts-menu2" class="nav nav-list collapse">
            <li ><a href="./Subbranch/bundlBrief.jsp">&nbsp&nbsp&nbsp 绑定概要信息</a></li>
        </ul>
        <a href="#accounts-menu3" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>明细商品<span class="label label-info">1</span></a>
        <ul id="accounts-menu3" class="nav nav-list collapse">
            <li ><a href="./Subbranch/bundlDetail.jsp">&nbsp&nbsp&nbsp 分店绑定明细商品</a></li>
        </ul>
        <a href="#accounts-menu4" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>订单管理<span class="label label-info">1</span></a></a>
        <ul id="accounts-menu4" class="nav nav-list collapse">
            <li ><a href="./listAllOrders.action?subbranch_id=${user.subbranchId }">&nbsp&nbsp&nbsp 订单管理</a></li>
        </ul>

       <!--  <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>Error Pages <i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="403.html">403 page</a></li>
            <li ><a href="404.html">404 page</a></li>
            <li ><a href="500.html">500 page</a></li>
            <li ><a href="503.html">503 page</a></li>
        </ul> -->

        <a href="help.html" class="nav-header" ><i class="icon-question-sign"></i>Help</a>
    </div>
    

    
    <div class="content">
        <center>
        <br><br>
        <br><br>
        <br><br><br><br>
        <h1>Welcome Baidu GiftShop Managerment!</h1>
        </center>
    </div>

    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>