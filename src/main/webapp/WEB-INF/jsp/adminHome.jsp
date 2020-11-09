<!DOCTYPE html>
<html lang="en">

<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<h3>Add new product</h3>
<form action="/newProduct" method="post">
    <label>Category: <input type="text" name="categoryName"></label><br>
    <label>Brand: <input type="text" name="brandName"></label><br>
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
