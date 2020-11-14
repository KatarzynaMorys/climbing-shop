<!DOCTYPE html>
<html lang="en">
<head>
    <title>Climbing shoes</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>

<body>
<%@ include file="header.jsp" %>

<div container>
    <div>
        <h3>${category.categoryName}</h3>
    </div>
    <div>
        <div class="row">
            <c:forEach var="product" items="${products}">
                <div class="col-sm-3">
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="${product.image}" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${product.brand.brandName} ${product.productName}</h5>
                            <p class="card-text">${product.productDescription}</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">${product.productColor}</li>
                            <li class="list-group-item">${product.productSize}</li>
                            <li class="list-group-item">${product.price.basePrice}</li>
                            <li class="list-group-item">${product.price.discountValue}</li>
                            <li class="list-group-item">${product.quantity}</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link">Review</a>
                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>

</html>