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
        <h3>商品 - 列表</h3>
        <hr>
        <a href="/Admin/AddProduct" class="btn btn-primary" type="button">新增商品</a>
        <div class="pagination">
            <ul>
                <li><a href="/Admin/ListProduct/1">最前</a></li>

                <%-- 上頁 --%>
                <c:choose>
                    <c:when test="${pagingBean.hasPrev}">
                        <li><a href="/Admin/ListProduct/${pagingBean.page - 1}">上頁</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="disabled"><a>上頁</a></li>
                    </c:otherwise>
                </c:choose>

                <%-- 下頁 --%>
                <c:choose>
                    <c:when test="${pagingBean.hasNext}">
                        <li><a href="/Admin/ListProduct/${pagingBean.page + 1}">下頁</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="disabled"><a>下頁</a></li>
                    </c:otherwise>
                </c:choose>

                <li><a href="/Admin/ListProduct/${pagingBean.pageTotal}">最後</a></li>
            </ul>
        </div>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>商品編號</th>
                    <th>所屬類別編號</th>
                    <th>名稱</th>
                    <th>功能</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.categoryId}</td>
                        <td>${product.name}</td>
                        <td><a href="">內容</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>

</html>