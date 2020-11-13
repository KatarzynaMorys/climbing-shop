<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="product" items="${products}">
    <tr>
        <td>${product.category.categoryName}</td>
        <td>${product.brand.brandName}</td>
        <td>${product.productName}</td>
        <td>${product.productType}</td>
        <td>${product.productColor}</td>
        <td>${product.productSize}</td>
        <td>${product.price.basePrice}</td>
        <td>${product.price.discountValue}</td>
        <td>${product.quantity}</td>
    </tr><br>
</c:forEach>