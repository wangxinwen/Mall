<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
    使用此分頁功能, 需傳入除最後頁數的連結URL, 參數標題為「linkUrl」, 
    例子：<c:param name="linkUrl" value="/products/category-pages/${categoryId}" />
    同時請求中必須有參數標題為「pagingBean」的分頁相關資料, 才可正常運作
--%>

<c:set var="linkUrl" value="${param.linkUrl}" />

<div class="pagination">
    <ul>
        <li><a href="${linkUrl}">最前</a></li>

        <%-- 上頁 --%>
        <c:choose>
            <c:when test="${pagingBean.hasPrev}">
                <li><a href="${linkUrl}/${pagingBean.page - 1}">上頁</a></li>
            </c:when>
            <c:otherwise>
                <li class="disabled"><a>上頁</a></li>
            </c:otherwise>
        </c:choose>

        <%-- 下頁 --%>
        <c:choose>
            <c:when test="${pagingBean.hasNext}">
                <li><a href="${linkUrl}/${pagingBean.page + 1}">下頁</a></li>
            </c:when>
            <c:otherwise>
                <li class="disabled"><a>下頁</a></li>
            </c:otherwise>
        </c:choose>

        <li><a href="${linkUrl}/${pagingBean.pageTotal}">最後</a></li>
    </ul>
</div>