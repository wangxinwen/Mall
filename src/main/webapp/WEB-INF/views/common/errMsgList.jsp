<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${!empty form.errMsgList}">
	<div class="control-group">
		<div class="controls">
			<c:forEach var="errMsg" items="${form.errMsgList}">
				<span class="text-error">${errMsg}</span><br>
			</c:forEach>
		</div>
	</div>
</c:if>
