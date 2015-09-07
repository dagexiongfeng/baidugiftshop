<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <title>Baidu GiftShop</title>
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
                            <i class="icon-user"></i> ${user.account}
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">My Account</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="sign-in.html">Logout</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="index.html"><span class="first">Baidu</span> <span class="second">GiftShop</span></a>
        </div>
    </div>
    


    
     <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>首页</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li ><a href="./index.jsp">Home</a></li>
            <li ><a href="./getAllUser.action">User management</a></li>
            <li ><a href="user.jsp">Personal information</a></li>
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>分类信息<span class="label label-info">2</span></a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="./goods.action">&nbsp&nbsp&nbsp增加分类信息</a></li>
            <li ><a href="./listallBrief.action">&nbsp&nbsp&nbsp查询分类信息</a></li>
        </ul>
        <a href="#accounts-menu2" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>概要商品<span class="label label-info">2</span></a>
        <ul id="accounts-menu2" class="nav nav-list collapse">
            <li ><a href="./briefGoods/addBriefGoods.jsp">&nbsp&nbsp&nbsp增加概要信息</a></li>
            <li ><a href="./queryAllBriefGoods.action">&nbsp&nbsp&nbsp查询概要信息</a></li>
        </ul>
        <a href="#accounts-menu3" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>明细商品<span class="label label-info">3</span></a>
        <ul id="accounts-menu3" class="nav nav-list collapse">
            <li ><a href="./DetailGoods/addDetailGoods.jsp">&nbsp&nbsp&nbsp增加明细信息</a></li>
            <li ><a href="./listallDetailGoods.action">&nbsp&nbsp&nbsp查询明细商品</a></li>
            <li ><a href="./DetailGoods/ModifyDetailGoods.jsp">&nbsp&nbsp&nbsp修改明细商品</a></li>
        </ul>
        <a href="#accounts-menu4" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>图片组别<span class="label label-info">3</span></a>
        <ul id="accounts-menu4" class="nav nav-list collapse">
            <li ><a href="./addPic.action">&nbsp&nbsp&nbsp增加一组图片</a></li>
            <li ><a href="./Picture/ShowPic.jsp">&nbsp&nbsp&nbsp查询一组图片</a></li>
            <li ><a href="./Picture/DeleteGroup.jsp">&nbsp&nbsp&nbsp删除一组图片</a></li>
        </ul>

        <!-- <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>Error Pages <i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="403.html">403 page</a></li>
            <li ><a href="404.html">404 page</a></li>
            <li ><a href="500.html">500 page</a></li>
            <li ><a href="503.html">503 page</a></li>
        </ul> -->

        <a href="help.html" class="nav-header" ><i class="icon-question-sign"></i>Help</a>
    </div>

        <!-- <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>Error Pages <i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="403.html">403 page</a></li>
            <li ><a href="404.html">404 page</a></li>
            <li ><a href="500.html">500 page</a></li>
            <li ><a href="503.html">503 page</a></li>
        </ul> -->

        <a href="help.html" class="nav-header" ><i class="icon-question-sign"></i>Help</a>
    </div>
    

    
    <div class="content">
        <div class="header">
            <h1 class="page-title">Users</h1>
        </div>
                <ul class="breadcrumb">
            <li><a href="index.html">Home</a> <span class="divider">/</span></li>
            <li class="active">Users</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <a href="./sign-up.html"><button class="btn btn-primary"><i class="icon-plus"></i> New User</button></a>
  <div class="btn-group">
  </div>
</div>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>Username</th>
          <th>SubbranchId</th>
          <th>Email</th>
          <th>Tel</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <s:iterator value="#request.list" id="list">
      <tbody>
        <tr>
          <td><s:property value="#list.account" /></td>
          <td><s:property value="#list.subbranchId" /></td>
          <td><s:property value="#list.email" /></td>
          <td><s:property value="#list.tel" /></td>
          <td>
              <s:if test="#list.account != 'administor'">
              <a href="./deleteUser.action?aid=<s:property value="#list.id"/>">删除</a>
              </s:if>
          </td>
        </tr>
      </tbody>
      </s:iterator>
    </table>
</div>
<div class="pagination">
    <s:iterator value="#request.pageBean" id="pageBean">
    <ul>
        <li><a href="./getAllUser.action?page=<s:property value='pageBean.firstPage'/>">Prev</a></li>
        <li><a href="./getAllUser.action?page=1">1</a></li>
        <li><a href="./getAllUser.action?page=2">2</a></li>
        <li><a href="./getAllUser.action?page=3">3</a></li>
        <li><a href="">...</a></li>
        <li><a href="./getAllUser.action?page=<s:property value='pageBean.nextPage'/>">Next</a></li>
        <li><a>共<s:property value="pageBean.allPage"/>页</a></li>
    </ul>
    </s:iterator>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Delete Confirmation</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button class="btn btn-danger" data-dismiss="modal">Delete</button>
    </div>
</div>
                    
            </div>
        </div>
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