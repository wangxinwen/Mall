<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="well sidebar-nav">
    <ul class="nav nav-list">
        <c:forEach var="categoryMap" items="${requestScope.sidebar}">
            <%-- 父類別 --%>
            <c:set var="parentCategory" value="${categoryMap.key}"/>
            <%-- 子類別列表 --%>
            <c:set var="childCategoryList" value="${categoryMap.value}"/>
            
            <li class="nav-header">${parentCategory.name}</li>
            <c:forEach var="childCategory" items="${childCategoryList}">
                <li><a href="${childCategory.id}">${childCategory.name}</a></li>
            </c:forEach>
        </c:forEach>
    </ul>
</div>
