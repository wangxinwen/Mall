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
    <title>訂單管理 - 購物中心</title>
</head>

<body>
    <div class="span2">
        <c:import url="/WEB-INF/views/common/sidebar.jsp" />
    </div>
    <div class="span8">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>訂單編號</th>
                    <th>訂購時間</th>
                    <th>付款方式</th>
                    <th>狀態</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orderList}">
                    <tr>
                        <td>
                            ${order.id}
                        </td>
                        <td>
                        ${order.createTime}
                        </td>
                        <td>
                            <c:if test="${order.method == PAYMENT_METHOD_BANK}">銀行匯款</c:if>
                            <c:if test="${order.method == PAYMENT_METHOD_CARD}">信用卡匯款</c:if>
                            <c:if test="${order.method == PAYMENT_METHOD_DELIVERY}">貨到付款</c:if>
                        </td>
                        <td>
                            <c:if test="${order.state == ORDER_STATE_GET}">
                                <span class="label">收到訂單</span>
                            </c:if>
                            <c:if test="${order.state == ORDER_STATE_HANDLE}">
                                <span class="label label-warning">商品處理中</span>
                            </c:if>
                            <c:if test="${order.state == ORDER_STATE_SEND}">
                                <span class="label label-success">商品已寄出</span>
                            </c:if>
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