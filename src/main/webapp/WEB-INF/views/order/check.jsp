<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="tw.roysu.mall.constant.AppConstant" %>

<c:set var="IMG_PRODUCT_NO_IMG_URL" value="<%=AppConstant.IMG_PRODUCT_NO_IMG_URL %>"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>訂單確認 - 購物中心</title>
</head>

<body>
    <div class="span2">
        <c:import url="/WEB-INF/views/admin/sidebar.jsp" />
    </div>
    <div class="span8">
        <h3>訂單確認</h3>
        <hr>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th class="span3">商品圖片</th>
                    <th>價格</th>
                    <th>功能</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>
                            <%-- 有商品圖顯示商品圖, 沒圖顯示預設無圖片的圖 --%>
                            <c:set var="imgUrl" value="${empty product.imgUrl ? IMG_PRODUCT_NO_IMG_URL : product.imgUrl}"/>
                            
                            <a target="_blank" href="${imgUrl}" class="thumbnail"> 
                                <img src="${imgUrl}" 
                                     data-src="holder.js/160x120" 
                                     alt="${product.name}">
                            </a>
                        </td>
                        <td>${product.actualPrice}</td>
                        <td>
                            <a href="">移除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="span2">
        <c:import url="/WEB-INF/views/common/cart.jsp" />
    </div>
</body>

</html>