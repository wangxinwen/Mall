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
                <a class="brand" href="#">購物中心</a>
                <div class="nav-collapse collapse">
                    <p class="navbar-text pull-right"><a href="#" class="navbar-link">登入</a>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span2">
                <div class="well sidebar-nav">
                    <ul class="nav nav-list">
                        <li class="nav-header">書籍
                        <li class="active"><a href="#">電腦資訊</a>
                        <li><a href="#">商業理財</a>
                        <li><a href="#">人文史地</a>
                        <li><a href="#">社會科學</a>
                        <li><a href="#">文學小說</a>
                        <li class="nav-header">電腦
                        <li><a href="#">桌上型電腦</a>
                        <li><a href="#">筆記型電腦</a>
                        <li><a href="#">平版電腦</a>
                        <li><a href="#">電腦螢幕</a>
                        <li><a href="#">喇叭</a>
                        <li><a href="#">鍵盤、滑鼠</a>
                        <li class="nav-header">汽車
                        <li><a href="#">Audi</a>
                        <li><a href="#">BMW</a>
                        <li><a href="#">TOYOTA</a>
                    </ul>
                </div>
            </div>
            <div class="span10">
            	<decorator:body/>
            </div>
        </div>
    </div>
    <script src="/resources/bootstrap/bootstrap.js"></script>
</body>

</html>