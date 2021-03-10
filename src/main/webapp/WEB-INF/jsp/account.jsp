<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<br lang="en">
<head>
    <title>Account</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script>
        function displayForm(form) {
            document.getElementById(form).style.display = 'block';
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
</head>


<%@ include file="header.jsp" %>

<div class="container">
    <br>
    <h5>Welcome ${customer.firstName}</h5>
    <div class="accordion" id="accordionExample">
        <p>
            <button class="btn btn-light" type="button" data-toggle="collapse" data-target="#collapseOne">
                Your details
            </button>
            <button class="btn btn-light collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo">
                Your contact details
            </button>
            <button class="btn btn-light collapsed" type="button" data-toggle="collapse" data-target="#collapseThree">
                Orders
            </button>
        </p>

        <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
            <div class="card card-body">
                <h5>View and update your details right here. Manage your login options and passwords here.</h5>
                <br>
                <h5>Name
                    <button onclick="displayForm('form1')" class="btn btn-light">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-pencil" viewBox="0 0 16 16">
                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                        </svg>
                        Edit
                    </button>
                </h5>
                <p>${customer.firstName} ${customer.lastName}</p>
                <h5>Email
                    <button onclick="displayForm('form2')" class="btn btn-light">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-pencil" viewBox="0 0 16 16">
                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                        </svg>
                        Edit
                    </button>
                </h5>
                <p>${customer.email}</p>
                <h5>Password
                    <button onclick="displayForm('form3')" class="btn btn-light">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-pencil" viewBox="0 0 16 16">
                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                        </svg>
                        Edit
                    </button>
                </h5>
                <p>**********</p>

                <form action="/changeName" method="post" id="form1" style="display: none">
                    <div class="form-group">
                        <input type="text" name="firstName" class="form-control form-control-sm" id="firstName"
                               placeholder="firstName" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="lastName" class="form-control form-control-sm" id="lastName"
                               placeholder="lastName" required>
                    </div>
                    <input type="submit" class="btn btn-light" value="Save">
                </form>
                <br>

                <form action="/changeEmail" method="post" id="form2" style="display: none">
                    <div class="form-group">
                        <input type="email" name="email" class="form-control form-control-sm" id="email"
                               placeholder="email" required>
                    </div>
                    <input type="submit" class="btn btn-light" value="Save">
                </form>
                <br>

                <form action="/changePassword" method="post" id="form3" style="display: none">
                    <div class="form-group">
                        <input type="password" name="hashPassword" class="form-control form-control-sm"
                               id="hashPassword"
                               placeholder="**********" required>
                    </div>
                    <input type="submit" class="btn btn-light" value="Save">
                </form>
                <br>

            </div>
        </div>

        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
            <div class="card card-body">
                <h5>Add or manage your addresses and phone number right here.</h5>
                <br>
                <c:if test="${not empty customer.address}">
                    <h5>Mobile number</h5>
                    <p class="card-text">${customer.phone}</p>
                    <h5>Address</h5>
                    <p class="card-text">${customer.address.street} ${customer.address.streetNumber}</p>
                    <p class="card-text">${customer.address.postalCode} ${customer.address.city}</p>
                    <p class="card-text">${customer.address.state}</p>
                    <button onclick="displayForm('form4')" class="btn btn-light">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-pencil" viewBox="0 0 16 16">
                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                        </svg>
                        Edit
                    </button>
                </c:if>

                <c:if test="${empty customer.address}">
                    <p class="card-text"> Please add your contact details</p>
                    <button onclick="displayForm('form2')" class="btn btn-light">Add contact details</button>
                </c:if>

                <form action="/changeContactDetails" method="post" id="form4" style="display: none">
                    <div class="form-group">
                        <input type="text" name="phone" class="form-control form-control-sm" id="phone"
                               placeholder="phone" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="state" class="form-control form-control-sm" id="state"
                               placeholder="state" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="city" class="form-control form-control-sm" id="city"
                               placeholder="city" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="street" class="form-control form-control-sm" id="street"
                               placeholder="street" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="streetNumber" class="form-control form-control-sm" id="streetNumber"
                               placeholder="street number" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="postalCode" class="form-control form-control-sm" id="postalCode"
                               placeholder="postal code" required>
                    </div>
                    <input type="submit" class="btn btn-light" value="Save">
                </form>
            </div>
        </div>

        <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
            <div class="card card-body">

                <c:if test="${orderedProducts.size() > 0}">
                    <h5>Here you'll find all of the information about the order you have placed.</h5>
                </c:if>

                <c:if test="${orderedProducts.size() eq 0}">
                    <h5>You haven’t shopped with us yet. Is today the day?</h5>
                </c:if>

                <br>
                <c:forEach var="p" items="${orderedProducts}">
                    <div class="card mb-3" style="max-width: 540px;">
                        <div class="row g-0">
                            <div class="col-md-4">
                                <img src="${p.product.image}" width="200">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">Order number ${p.order.orderId}</h5>
                                    <p class="card-text">Order date ${p.order.orderDate}</p>
                                    <p class="card-text"><small class="text-muted">${p.product.productName}
                                        size ${p.product.productSize}</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>
</div>


<%@ include file="footer.jsp" %>