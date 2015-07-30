<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
     
<!DOCTYPE html>
<html lang="en">

<head>
    <title>登入 - 購物中心</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="span6 offset3">
				<form class="form-horizontal" action="/Login" method="POST">
					<div class="control-group">
						<label class="control-label" for="inputAccount">帳號</label>
						<div class="controls">
							<input type="text" class="input-medium" id="inputAccount" placeholder="帳號" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword">密碼</label>
						<div class="controls">
							<input type="password" class="input-medium" id="inputPassword" placeholder="密碼" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-primary">登入</button>
							<button type="button" class="btn">取消</button>
							<button type="button" class="btn btn-info">註冊</button>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<p class="text-info">
								<a href="">忘記密碼</a>
							</p>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>