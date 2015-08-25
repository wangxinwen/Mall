<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>購物中心</title>
</head>

<body>
    <div class="span2">
        <c:import url="/WEB-INF/views/common/sidebar.jsp" />
    </div>
    <div class="span8">
        <c:forEach var="product" items="${productList}" varStatus="status">
            <c:if test="${status.index % 3 == 0}">
                <div class="row-fluid">
                <ul class="thumbnails">
            </c:if>
            <li class="span4">
                <div class="thumbnail">
                    <img data-src="holder.js/300x200" alt="" src="${product.imgUrl}">
                    <div class="caption">
                        <h3>${product.name}</h3>
                        <p>${product.detail}</p>
                    </div>
                </div>
            </li>
            <c:if test="${status.index % 3 == 2}">
                </ul>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <div class="span2">
        <c:import url="/WEB-INF/views/common/cart.jsp" />
    </div>
</body>

</html>