<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title><decorator:title /></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="/resources/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/home.css" rel="stylesheet">
    <link href="/resources/bootstrap/bootstrap-responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
	   <script src=~/Scripts/BS2/html5shiv.js></script>
	<![endif]-->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/resources/bootstrap/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/resources/bootstrap/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/resources/bootstrap/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/resources/bootstrap/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="/resources/bootstrap/favicon.png">
</head>

<body>
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <c:if test="${sessionScope.validUser.admin}">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span> 
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </c:if>
                <a class="brand" href="/">購物中心</a>
                <div class="nav-collapse collapse">
                    <%-- 未登入顯示登入連結 --%>
                    <c:if test="${empty sessionScope.validUser}">
                        <p class="navbar-text pull-right">
                            <a href="/Login" class="navbar-link">登入</a>
                        </p>
                    </c:if>
                    
                    <%-- 管理者才顯示管理後台連接 --%>
                    <c:if test="${sessionScope.validUser.admin}">
                        <ul class="nav">
                            <li><a href="/Admin/Home">管理後台</a>
                        </ul>
                    </c:if>
                    
                    <%-- 登入後顯示會員功能下拉選單 --%>
                    <c:if test="${!empty sessionScope.validUser}">
                        <ul class="nav">
                            <li><a href="/Order/List">訂單管理</a>
                        </ul>
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown">
                                    ${sessionScope.validUser.name}<b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="/User/Logout">登出</a></li>
                                </ul>
                            </li>
                        </ul>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <script src="/resources/jquery/jquery-1.11.3.js"></script>
    <script src="/resources/bootstrap/bootstrap.js"></script>
    <script src="/resources/js/common/redirect.js"></script>
    
    <div class="container-fluid">
        <div class="row-fluid">
            <decorator:body />
        </div>
    </div>
</body>

</html>