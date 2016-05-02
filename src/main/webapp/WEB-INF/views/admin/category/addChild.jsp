<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>管理後台</title>
</head>

<body>
    <div class="span2">
        <c:import url="/WEB-INF/views/admin/sidebar.jsp" />
    </div>
    <div class="span10">
        <h3>商品類別 - 新增子類別</h3>
        <hr>
        <form:form action="/admin/categorys/childs/create" method="POST" modelAttribute="form">
            <div class="control-group">
                <div class="controls">
                    <form:select path="parentId">
                        <form:option value="-1" label="請選擇父類別" />
                        <c:forEach var="category" items="${parentCategoryList}">
                            <form:option value="${category.id}" label="${category.name}" />
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <form:input class="input-medium" id="inputName" placeholder="類別名稱" path="name" />
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-primary">新增</button>
                </div>
            </div>
            <%-- 如果驗證不通過, 顯示錯誤提示訊息 --%>
            <c:import url="/WEB-INF/views/common/errMsgList.jsp" />
        </form:form>
    </div>
</body>

</html>