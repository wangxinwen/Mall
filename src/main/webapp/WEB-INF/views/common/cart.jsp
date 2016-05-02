<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
    <table class="table">
        <thead>
            <tr>
                <th>
                    <div class="text-center">購物車</div>
                </th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${!empty cart}">
                <c:forEach var="product" items="${cart}">
                    <tr>
                        <td>
                            <div class="text-center">
                                <a href="/products/${product.id}">${product.name}</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>
                        <a class="btn btn-small btn-block btn-primary" href="/carts/checkout">結帳</a>
                    </td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>
