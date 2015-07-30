<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title><decorator:title/></title>
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
                <a class="brand" href="/">購物中心</a>
                <div class="nav-collapse collapse">
                    <p class="navbar-text pull-right"><a href="/Login" class="navbar-link">登入</a>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
        	<decorator:body/>
        </div>
    </div>
    
    <script src="/resources/jquery/jquery-1.11.3.js"></script>
    <script src="/resources/bootstrap/bootstrap.js"></script>
    <script src="/resources/js/common/redirect.js"></script>
</body>

</html>