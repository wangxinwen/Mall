<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="tw.roysu.mall.constant.AppConstant" %>

<%-- 付款方式 --%>
<c:set var="PAYMENT_METHOD_BANK" value="<%=AppConstant.PAYMENT_METHOD_BANK %>"/>
<c:set var="PAYMENT_METHOD_CARD" value="<%=AppConstant.PAYMENT_METHOD_CARD %>"/>
<c:set var="PAYMENT_METHOD_DELIVERY" value="<%=AppConstant.PAYMENT_METHOD_DELIVERY %>"/>

<%-- 訂單狀態 --%>
<c:set var="ORDER_STATE_GET" value="<%=AppConstant.ORDER_STATE_GET %>"/>
<c:set var="ORDER_STATE_HANDLE" value="<%=AppConstant.ORDER_STATE_HANDLE %>"/>
<c:set var="ORDER_STATE_SEND" value="<%=AppConstant.ORDER_STATE_SEND %>"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>訂單明細 - 購物中心</title>
</head>

<body>
    <div class="span2">
        <c:import url="/WEB-INF/views/common/sidebar.jsp" />
    </div>
    <div class="span8">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>商品編號</th>
                    <th>名稱</th>
                    <th>價格</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>
                            ${product.id}
                        </td>
                        <td>
                            ${product.name}
                        </td>
                        <td>
                            ${product.actualPrice}
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