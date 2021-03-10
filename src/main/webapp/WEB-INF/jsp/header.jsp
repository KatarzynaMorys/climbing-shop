<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Header</title>
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

<div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
    <div class="btn-group" role="group" aria-label="First group">
        <a class="btn btn-light btn-lg" href="/home" role="button">Home</a>
        <a class="btn btn-light btn-lg" href="/women" role="button">Women</a>
        <a class="btn btn-light btn-lg" href="/men" role="button">Men</a>
        <a class="btn btn-light btn-lg" href="/climbingGear" role="button">Climbing gear</a>
        <button type="button" class="btn btn-light btn-lg" disabled>
            <c:if test="${not empty username}">
                <div>
                    You have been logged in with email <c:out value="${username}"></c:out>
                </div>
            </c:if>
        </button>
    </div>

    <div class="btn-group dropleft">
        <button class="btn btn-light btn-lg" type="button" id="dropdownMenuButton"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person"
                 fill="currentColor"
                 xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd"
                      d="M10 5a2 2 0 1 1-4 0 2 2 0 0 1 4 0zM8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6 5c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
            </svg>
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="/login">Login</a>
            <a class="dropdown-item" href="/register">Register</a>
            <a class="dropdown-item" href="/account">Your account</a>
            <a class="dropdown-item" href="/logout">Logout</a>
        </div>
        <div>
            <a class="btn btn-light btn-lg" href="/shoppingBag" role="button">
                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-bag" fill="currentColor"
                     xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd"
                          d="M8 1a2.5 2.5 0 0 0-2.5 2.5V4h5v-.5A2.5 2.5 0 0 0 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5v9a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V5H2z"/>
                </svg>
            </a>
        </div>
    </div>
</div>

</body>
</html>