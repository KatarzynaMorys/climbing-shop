<!DOCTYPE html>
<html lang="en">
<head>
    <title>Contact</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
</head>

<body>
<%@ include file="header.jsp" %>

<div class="row row-cols-2">

    <div class="col mb-4">

        <div class="card-header">Order</div>
        <c:forEach var="product" items="${sessionScope.shoppingBag}">
            <div class="card mb-4">
                <div class="row no-gutters">
                    <div class="col-md-4">
                        <img src="${product.image}" class="card-img" alt="...">
                    </div>
                    <div class="col-md-4 w-50">
                        <div class="card-body">
                            <h5 class="card-title">${product.brand.brandName}</h5>
                            <p class="card-text">${product.productName}</p>
                            <p class="card-text">${product.productType}</p>
                            <p class="card-text">Color ${product.productColor}</p>
                            <p class="card-text">Size ${product.productSize}</p>
                            <c:set var="priceAfterDiscount"
                                   value="${product.price.basePrice * (100 - product.price.discountValue) / 100}"/>
                            <p class="card-text">Price <c:out value="${priceAfterDiscount}"/></p>
                            <p class="card-text">Quantity ${product.quantity}</p>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="col mb-4">

        <div class="card">
            <div class="card-header">Delivery address</div>
            <div class="card-body">
                <h5 class="card-title">${customer.firstName} ${customer.lastName}</h5>

                <form action="/addAddress" method="post">
                    <div class="form-group">
                        <input type="text" name="state" class="form-control form-control-sm" id="state"
                               placeholder="state">
                    </div>
                    <div class="form-group">
                        <input type="text" name="city" class="form-control form-control-sm" id="city"
                               placeholder="city">
                    </div>
                    <div class="form-group">
                        <input type="text" name="street" class="form-control form-control-sm" id="street"
                               placeholder="street">
                    </div>
                    <div class="form-group">
                        <input type="text" name="streetNumber" class="form-control form-control-sm" id="streetNumber"
                               placeholder="street number">
                    </div>
                    <div class="form-group">
                        <input type="text" name="postalCode" class="form-control form-control-sm" id="postalCode"
                               placeholder="postal code">
                    </div>
                    <input type="submit" class="btn btn-light" value="Save">
                </form>
            </div>
        </div>

        <div class="card">
            <div class="card-header">Order summary</div>
            <div class="card-body">
                <p class="card-text">Total price ${totalPrice}</p>
                <form action="/order" method="get">
                    <input type="submit" class="btn btn-light" value="Order">
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>

</html>