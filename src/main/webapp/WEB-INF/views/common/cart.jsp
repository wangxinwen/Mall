<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="well sidebar-nav">
    <ul class="nav nav-list">
        <li class="nav-header">購物車</li>
        <c:if test="${!empty cart}">
            <c:forEach var="product" items="${cart}">
                <li>
                    <a href="/Product/Detail/${product.id}">${product.name}</a>
                </li>
            </c:forEach>
        </c:if>
    </ul>
</div>
