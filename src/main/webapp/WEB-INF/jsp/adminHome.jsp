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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>

<body>
<div class="container">

    <h3>Add new product</h3>
    <form action="/newProduct" method="post">
        <div class="form-group">
            <label for="cat_id">Select category</label>
            <select class="form-control" name="categories" id="cat_id" onchange="updateLabel('cat_id', 'cat_label')">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.categoryName}">${category.categoryName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="cat_label"> or create a new category</label>
            <input type="text" class="form-control" id="cat_label" name="categoryName">
        </div>
        <div class="form-group">
            <label for="bra_id">Select brand</label>
            <select class="form-control" name="brands" id="bra_id" onchange="updateLabel('bra_id', 'bra_label')">
                <c:forEach var="brand" items="${brands}">
                    <option value="${brand.brandName}">${brand.brandName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label> or create a new brand</label>
            <input type="text" class="form-control" id="bra_label" name="brandName">
        </div>
        <div class="form-group">
            <label for="pro_name">Product name</label>
            <input type="text" class="form-control" id="pro_name" name="productName">
        </div>
        <div class="form-group">
            <label for="pro_type">Product type</label>
            <input type="text" class="form-control" id="pro_type" name="productType">
        </div>
        <div class="form-group">
            <label for="pro_color">Product color</label>
            <input type="text" class="form-control" id="pro_color" name="productColor">
        </div>
        <div class="form-group">
            <label for="pro_price">Product price</label>
            <input type="number" class="form-control" id="pro_price" name="basePrice">
        </div>
        <div class="form-group">
            <label for="pro_discount">Product discount</label>
            <input type="number" class="form-control" id="pro_discount" name="discountValue">
        </div>
        <div class="form-group">
            <label for="pro_size">Product size</label>
            <input type="text" class="form-control" id="pro_size" name="productSize">
        </div>
        <div class="form-group">
            <label for="pro_quantity">Quantity</label>
            <input type="number" class="form-control" id="pro_quantity" name="quantity">
        </div>
        <div>
            <input type="submit" value="Register">
        </div>
    </form>

</div>
</body>

</html>
