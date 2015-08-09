<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="tw.roysu.mall.constant.AppConstant" %>

<c:set var="IMG_PRODUCT_NO_IMG_URL" value="<%=AppConstant.IMG_PRODUCT_NO_IMG_URL %>"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>商品列表 - 購物中心</title>
</head>

<body>
    <div class="span2">
        <c:import url="/WEB-INF/views/common/sidebar.jsp" />
    </div>
    <div class="span10">
        <%-- 分頁 --%>
        <c:import url="/WEB-INF/views/common/pagination.jsp">
            <c:param name="linkUrl" value="/Product/List/${categoryId}" />
        </c:import>
        
        <div class="row-fluid">
            <ul class="media-list">
                <c:forEach var="product" items="${productList}">
                    <li class="media">
                        <a class="pull-left" href="#">
                            <%-- 有商品圖顯示商品圖, 沒圖顯示預設無圖片的圖 --%>
                            <c:set var="imgUrl" value="${empty product.imgUrl ? IMG_PRODUCT_NO_IMG_URL : product.imgUrl}"/>
                            
                            <img src="${imgUrl}" 
                                 data-src="holder.js/64x64" 
                                 class="media-object">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">${product.name}</h4>
                            <p>${product.detail}</p>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</body>

</html>