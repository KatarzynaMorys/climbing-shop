<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--@elvariable id="product" type="pl.sda.climbing_shop.product.Product"--%>

<div>
    <div>
        <div class="card-body">
            <h5 class="card-title">Product type</h5>
            <form:form method="post"
                       action="${category.categoryName}"
                       modelAttribute="product">
                <div>
                    <c:forEach var="type" items="${types}">
                        <form:radiobutton path="productType" id="type_id"
                                          value="${type}"
                                          onclick="this.form.submit()"/>
                        <label class="form-check-label" for="subtype_id">${type}</label><br>
                    </c:forEach>
                </div>
            </form:form>
        </div>
    </div>

    <div>
        <div class="card-body">
            <h5 class="card-title">Brand</h5>
            <form:form method="post"
                       action="${category.categoryName}"
                       modelAttribute="product">
                <div>
                    <c:forEach var="brand" items="${brands}">
                        <form:radiobutton path="brand" id="brand_id"
                                          value="${brand.brandId}"
                                          onclick="this.form.submit()"/>
                        <label class="form-check-label" for="brand_id">${brand.brandName}</label><br>
                    </c:forEach>
                </div>
            </form:form>
        </div>
    </div>

    <div>
        <div class="card-body">
            <h5 class="card-title">Size</h5>
            <form:form method="post"
                       action="${category.categoryName}"
                       modelAttribute="product">
                <div>
                    <c:forEach var="size" items="${sizes}">
                        <form:radiobutton path="productSize" id="size_id"
                                          value="${size}"
                                          onclick="this.form.submit()"/>
                        <label class="form-check-label" for="size_id">${size}</label><br>
                    </c:forEach>
                </div>
            </form:form>
        </div>
    </div>

    <div>
        <div class="card-body">
            <h5 class="card-title">Color</h5>
            <form:form method="post"
                       action="${category.categoryName}"
                       modelAttribute="product">
                <div>
                    <c:forEach var="color" items="${colors}">
                        <form:radiobutton path="productColor" id="color_id"
                                          value="${color}"
                                          onclick="this.form.submit()"/>
                        <label class="form-check-label" for="color_id">${color}</label><br>
                    </c:forEach>
                </div>
            </form:form>
        </div>
    </div>

    <div>
        <form method="post"
              action="${category.categoryName}/removeFilters">
            <div>
                <button type="submit" class="btn btn-light col-auto">Remove filters</button>
            </div>
        </form>
    </div>
</div>