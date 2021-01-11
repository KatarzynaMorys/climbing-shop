<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--@elvariable id="product" type="pl.sda.climbing_shop.product.Product"--%>
<form:form method="post"
           action="${category.categoryName}"
           modelAttribute="product">
    <div class="form-inline">
        <div class="form-group">
            <label for="subtype_id" class="control-label col-auto my-1 mr-2">Type</label>
            <form:select path="productSubtype" class="form-control col-auto my-1 mr-2" name="subtypes" id="subtype_id">
                <c:forEach var="subtype" items="${subtypes}">
                    <option value="${subtype}">${subtype}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-light col-auto">Submit</button>
        </div>
    </div>
</form:form>
<form:form method="post"
           action="${category.categoryName}"
           modelAttribute="product">
    <div class="form-inline">
        <div class="form-group">
            <label for="brand_id" class="control-label col-auto my-1 mr-2">Brand</label>
            <form:select path="brand.brandName" class="form-control col-auto my-1 mr-2" name="brands" id="brand_id">
                <c:forEach var="brand" items="${brands}">
                    <option value="${brand}">${brand}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-light col-auto">Submit</button>
        </div>
    </div>
</form:form>
<form:form method="post"
           action="${category.categoryName}"
           modelAttribute="product">
    <div class="form-inline">
        <div class="form-group">
            <label for="size_id" class="control-label col-auto my-1 mr-2">Size</label>
            <form:select path="productSize" class="form-control col-auto my-1 mr-2" name="sizes" id="size_id">
                <c:forEach var="size" items="${sizes}">
                    <option value="${size}">${size}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-light col-auto">Submit</button>
        </div>
    </div>
</form:form>
<form:form method="post"
           action="${category.categoryName}"
           modelAttribute="product">
    <div class="form-inline">
        <div class="form-group">
            <label for="col_id" class="control-label col-auto my-1 mr-2">Color</label>
            <form:select path="productColor" class="form-control col-auto my-1 mr-2" name="colors" id="col_id">
                <c:forEach var="color" items="${colors}">
                    <option value="${color}">${color}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-light col-auto">Submit</button>
        </div>
    </div>
</form:form>

