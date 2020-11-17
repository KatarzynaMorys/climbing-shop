<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                    <li class="list-group-item">${product.productType}</li>
                    <li class="list-group-item">${product.productSubtype}</li>
                    <li class="list-group-item">${product.productColor}</li>
                    <li class="list-group-item">${product.productSize}</li>
                    <li class="list-group-item">${product.price.basePrice}</li>
                    <li class="list-group-item">${product.price.discountValue}</li>
                    <li class="list-group-item">${product.quantity}</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Review</a>
                    <a href="#" class="card-link">Add to the shopping bag</a>
                </div>
            </div>
        </div>

    </c:forEach>
</div>
