<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>管理後台</title>
</head>

<body>
    <div class="span2">
        <c:import url="/WEB-INF/views/admin/sidebar.jsp" />
    </div>
    <div class="span10">
        <h3>商品類別 - 列表</h3>
        <hr>
        <a href="/Admin/AddParentCategory" class="btn btn-primary" type="button">新增父類別</a>
        <a href="/Admin/AddChildCategory" class="btn btn-primary" type="button">新增子類別</a>
    </div>
</body>

</html>