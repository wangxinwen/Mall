<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>登入 - 購物中心</title>
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="span6 offset3">
                <form:form class="form-horizontal" action="/login" method="POST" modelAttribute="form">
                    <div class="control-group">
                        <label class="control-label" for="inputAccount">帳號</label>
                        <div class="controls">
                            <form:input class="input-medium" id="inputAccount" placeholder="帳號" path="account" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">密碼</label>
                        <div class="controls">
                            <form:password class="input-medium" id="inputPassword" placeholder="密碼" path="password" />
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <button type="submit" class="btn btn-primary">登入</button>
                            <button type="button" class="btn" id="btn-cancel">取消</button>
                            <button type="button" class="btn btn-info" id="btn-register">註冊</button>
                        </div>
                    </div>
                    <%-- 如果驗證不通過, 顯示錯誤提示訊息 --%>
                    <c:import url="/WEB-INF/views/common/errMsgList.jsp" />
                    <div class="control-group">
                        <div class="controls">
                            <p class="text-info">
                                <a href="">忘記密碼</a>
                            </p>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>

</html>