<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="tw.roysu.mall.constant.AppConstant" %>

<c:set var="IMG_PRODUCT_NO_IMG_URL" value="<%=AppConstant.IMG_PRODUCT_NO_IMG_URL %>"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>商品明細 - 購物中心</title>
</head>

<body>
    <div class="span2">
        <c:import url="/WEB-INF/views/common/sidebar.jsp" />
    </div>
    <div class="span4">
        <%-- 有商品圖顯示商品圖, 沒圖顯示預設無圖片的圖 --%>
        <c:set var="imgUrl" value="${empty product.imgUrl ? IMG_PRODUCT_NO_IMG_URL : product.imgUrl}" />
        
        <a href="${imgUrl}" class="thumbnail">
            <img src="${imgUrl}" alt="${product.name}" data-src="holder.js/360x270" >
        </a>
    </div>
    <div class="span6">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th class="span3">商品名稱</th>
                    <td>${product.name}</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>商品價格</th>
                    <td>${product.actualPrice}</td>
                </tr>
                <tr>
                    <th>商品簡介</th>
                    <td>${product.detail}</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>

</html>