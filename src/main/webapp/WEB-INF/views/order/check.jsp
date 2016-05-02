<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="tw.roysu.mall.constant.AppConstant" %>

<%-- 付款方式 --%>
<c:set var="PAYMENT_METHOD_BANK" value="<%=AppConstant.PAYMENT_METHOD_BANK %>"/>
<c:set var="PAYMENT_METHOD_CARD" value="<%=AppConstant.PAYMENT_METHOD_CARD %>"/>
<c:set var="PAYMENT_METHOD_DELIVERY" value="<%=AppConstant.PAYMENT_METHOD_DELIVERY %>"/>

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
        <h4>商品確認</h4>
        <table class="table">
            <thead>
                <tr>
                    <th>商品</th>
                    <th>價格</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>
                            <a target="_blank" href="/products/${product.id}"> 
                                ${product.name}
                            </a>
                        </td>
                        <td>${product.actualPrice}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><span class="text-error">總計</span></td>
                    <td><span class="text-error">${total}</span></td>
                </tr>
            </tbody>
        </table>
        <form:form action="/carts/checkout" method="POST" modelAttribute="form">
            付款方式：
            <form:select path="method">
                <form:option value="-1" label="請選擇" />
                <form:option value="${PAYMENT_METHOD_BANK}" label="銀行匯款" />
                <form:option value="${PAYMENT_METHOD_CARD}" label="信用卡" />
                <form:option value="${PAYMENT_METHOD_DELIVERY}" label="貨到付款" />
            </form:select><br>
            寄送地址：
            <form:input type="text" class="input-xlarge" path="address"/><br>
            <input type="submit" class="btn btn-primary" value="確認購買">
        </form:form>
        <%-- 如果驗證不通過, 顯示錯誤提示訊息 --%>
        <c:import url="/WEB-INF/views/common/errMsgList.jsp" />
    </div>
    <div class="span2">
        <c:import url="/WEB-INF/views/common/cart.jsp" />
    </div>
</body>

</html>