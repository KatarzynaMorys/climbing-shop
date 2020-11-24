<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Shopping bag</title>
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
        <div class="card-header">Your bag</div>

        <c:if test="${empty sessionScope.shoppingBag}">
            <br>
            <h5 class="card-title">Looks like your bag is empty</h5>
        </c:if>

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
                            <p class="card-text">Price ${product.price.basePrice}</p>
                            <c:set var="priceAfterDiscount"
                                   value="${product.price.basePrice * (100 - product.price.discountValue) / 100}"/>
                            <p class="card-text">After discount <c:out value="${priceAfterDiscount}"/></p>
                        </div>
                    </div>
                    <div class="col-md-4">

                        <form action="/update/${product.productId}" method="post">
                            <br>
                            <div>
                                <input type="number" min="1" name="quantity" id="quantity"
                                       placeholder="${product.quantity}">
                            </div>
                            <br>
                            <button type="submit" class="btn btn-light">Update</button>

                        </form>
                        <br>
                        <form action="/delete/${product.productId}" method="get">
                            <button type="submit" class="btn btn-light">
                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash"
                                     fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                    <path fill-rule="evenodd"
                                          d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                </svg>
                                Remove
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="col mb-4">
        <div class="card" style="width: 18rem;">
            <div class="card-header">Order summary</div>
            <div class="card-body">
                <p class="card-text">Total price ${totalPrice}</p>
                <form action="/checkout" method="get">
                    <input type="submit" class="btn btn-light" value="Checkout">
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>

</html>