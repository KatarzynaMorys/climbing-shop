<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--@elvariable id="product" type="pl.sda.climbing_shop.product.Product"--%>

<div>
    <div>
        <div class="card-body">
            <form:form method="get"
                       action="${category.categoryName}"
                       modelAttribute="product">
                <div>
                    <h5>Product type</h5>
                    <c:forEach var="subtype" items="${subtypes}">
                        <form:radiobutton path="productSubtype" id="subtype_id"
                                          value="${subtype}"
                                          onclick="this.form.submit()"/>
                        <label class="form-check-label" for="subtype_id">${subtype}</label><br>
                    </c:forEach>
                </div><br>
                <div>
                    <h5>Brand</h5>
                    <c:forEach var="brand" items="${brands}">
                        <form:radiobutton path="brand" id="brand_id"
                                          value="${brand.brandName}"
                                          onclick="this.form.submit()"/>
                        <label class="form-check-label" for="brand_id">${brand.brandName}</label><br>
                    </c:forEach>
                </div><br>
                <div>
                    <h5>Size</h5>
                    <c:forEach var="size" items="${sizes}">
                        <form:radiobutton path="productSize" id="size_id"
                                          value="${size}"
                                          onclick="this.form.submit()"/>
                        <label class="form-check-label" for="size_id">${size}</label><br>
                    </c:forEach>
                </div><br>
                <div>
                    <h5>Color</h5>
                    <c:forEach var="color" items="${colors}">
                        <form:radiobutton path="productColor" id="color_id"
                                          value="${color}"
                                          onclick="this.form.submit()"/>
                        <label class="form-check-label" for="color_id">${color}</label><br>
                    </c:forEach>
                </div><br>
                <div>
                    <button type="submit" class="btn btn-light col-auto">Submit</button>
                </div>
            </form:form>
        </div>
    </div>

    <div>
        <form method="post"
              action="${category.categoryName}">
            <div>
                <button type="submit" class="btn btn-light col-auto">Remove filters</button>
            </div>
        </form>
    </div>
</div>



