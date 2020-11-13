<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript">
        function updateLabel(id, lab) {
            let element = document.getElementById(id)
            let label = document.getElementById(lab);
            label.value = element.value;
        }
    </script>
</head>

<body>
<h3>Add new product</h3>

<form action="/newProduct" method="post">
    <label for="cat_id">Select category: </label>
    <select name="categories" id="cat_id" onchange="updateLabel('cat_id', 'cat_label')">
        <c:forEach var="category" items="${categories}">
            <option value="${category.categoryName}">${category.categoryName}</option>
        </c:forEach>
    </select>
    <label> or create a new category: <input id="cat_label" type="text" name="categoryName"></label><br>

    <label for="bra_id">Select brand: </label>
    <select name="brands" id="bra_id" onchange="updateLabel('bra_id', 'bra_label')">
        <c:forEach var="brand" items="${brands}">
            <option value="${brand.brandName}">${brand.brandName}</option>
        </c:forEach>
    </select>
    <label> or create a new brand: <input id="bra_label" type="text" name="brandName"></label><br>

    <label>Product name: <input type="text" name="productName"></label><br>
    <label>Product type: <input type="text" name="productType"></label><br>
    <label>Product color: <input type="text" name="productColor"></label><br>
    <label>Product price: <input type="number" name="basePrice"></label><br>
    <label>Product discount: <input type="number" name="discountValue"></label><br>
    <label>Product size: <input type="text" name="productSize"></label><br>
    <label>Quantity: <input type="number" name="quantity"></label><br>
    <input type="submit" value="Register">

</form>

</body>

</html>
