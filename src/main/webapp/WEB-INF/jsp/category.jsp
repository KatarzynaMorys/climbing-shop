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
                    <li class="list-group-item">${product.productType} ${product.productSubtype}</li>
                    <li class="list-group-item">${product.productColor}</li>
                    <li class="list-group-item">${product.productSize}</li>
                    <li class="list-group-item">${product.price.basePrice}</li>
                    <li class="list-group-item">${product.price.discountValue}</li>
                    <li class="list-group-item">${product.quantity} item/s in stock</li>
                </ul>
                <div class="card-body">
                    <form action="/addToShoppingBag/${product.productId}" method="get">
                        <div class="form-row">
                            <div class="col">
                                <input type="number" min="1" max="${product.quantity}" name="quantity" id="quantity"
                                       class="form-control" placeholder="Quantity">
                            </div>
                            <div class="col">
                                <input type="submit" class="btn btn-light" value="Add to bag">
                            </div>
                        </div>
                    </form>
                    <a href="#" class="card-link">Review</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>