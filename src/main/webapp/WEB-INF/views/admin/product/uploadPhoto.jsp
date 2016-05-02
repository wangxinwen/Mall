<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
        <h3>商品 - 上傳圖片</h3>
        <hr>
        <form action="/admin/products/upload-photo/${productId}" method="POST" enctype="multipart/form-data">
            <div class="control-group">
                <div class="controls">
                    <input type="file" name="file">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-primary">上傳</button>
                </div>
            </div>
        </form>
    </div>
</body>

</html>