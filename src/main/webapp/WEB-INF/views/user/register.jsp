<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     
<!DOCTYPE html>
<html lang="en">

<head>
    <title>註冊 - 購物中心</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="span6 offset3">
				<form:form class="form-horizontal" action="/Register" method="POST" modelAttribute="form">
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
						<label class="control-label" for="inputPasswordCheck">密碼確認</label>
						<div class="controls">
							<form:password class="input-medium" id="inputPasswordCheck" placeholder="密碼確認" path="passwordCheck" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmail">信箱</label>
						<div class="controls">
							<form:input class="input-medium" id="inputEmail" placeholder="信箱" path="email" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputName">暱稱</label>
						<div class="controls">
							<form:input class="input-medium" id="inputName" placeholder="暱稱" path="name" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-primary">註冊</button>
							<button type="button" class="btn" id="btn-cancel">取消</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>

</html>