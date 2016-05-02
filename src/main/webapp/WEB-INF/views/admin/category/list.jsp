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
        <div class="span6">
            <h3>商品類別 - 列表</h3>
            <hr>
            <a href="/admin/categorys/parents/create" class="btn btn-primary" type="button">新增父類別</a>
            <a href="/admin/categorys/childs/create" class="btn btn-primary" type="button">新增子類別</a>
            <br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>編號</th>
                        <th>名稱</th>
                        <th>所屬類別編號</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="category" items="${categoryList}">
                        <tr>
                            <td>${category.id}</td>
                            <td>${category.name}</td>
                            <c:choose>
                                <c:when test="${category.parentId == 0}">
                                    <td>已是最上層類別</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${category.parentId}</td>
                                </c:otherwise>
                            </c:choose>
                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>