<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
                </div>
                <div class="card-body">
                    <div class="list-group" id="rev_list" role="tablist">
                        <a class="list-group-item list-group-item-action list-group-item-secondary d-flex justify-content-between align-items-center"
                           data-toggle="list" href="#review${product.productId}" role="tab">Reviews
                            <span class="badge badge-secondary badge-pill">${fn:length(product.reviews)}</span></a>
                    </div>
                    <div class="tab-content">
                        <div class="tab-pane" id="review${product.productId}" role="tabpanel">
                            <c:forEach items="${product.reviews}" var="review">
                                <blockquote class="blockquote">
                                    <p class="mb-0">${review.content}</p>
                                    <footer class="blockquote-footer">${review.customer.firstName} <cite
                                            title="date">${review.createdAt}</cite></footer>
                                </blockquote>
                            </c:forEach>
                        </div>
                    </div>
                </div>

                <div class="card-body">
                    <div class="list-group" id="add_rev" role="tablist">
                        <a class="list-group-item list-group-item-action list-group-item-secondary d-flex justify-content-between align-items-center"
                           data-toggle="list" href="#add${product.productId}" role="tab">Add review</a>
                    </div>
                    <br>
                    <div class="tab-content">
                        <div class="tab-pane" id="add${product.productId}" role="tabpanel">
                            <form action="${product.category.categoryName}/addReview/${product.productId}"
                                  method="post">
                                <div><input type="text" name="content" class="form-control"
                                            placeholder="Your review..."></div>
                                <br>
                                <div class="input-group mb-3">
                                    <input type="number" min="1" max="5" name="rating">
                                </div>
                                <input type="submit" class="btn btn-light" value="Add">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>