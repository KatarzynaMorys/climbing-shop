<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Men clothing</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/products_menu.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
</head>

<html>

<body>
<%@ include file="header.jsp" %>

<div>
    <img src="https://vimff.org/wp-content/uploads/2020/01/vimff-2020-best-of-climbing-drew-smith-title-bg.jpg"
         class="img-fluid">
    <div class="position-fixed">
        <div class="row">
            <a class="btn-work btn-light" href="/men/jackets&vests" role="button">Jackets & Vests</a>
            <a class="btn-work btn-light" href="/men/pants&shorts" role="button">Pants & Shorts</a>
            <a class="btn-work btn-light" href="/men/t-shirts&shirts" role="button">T-Shirts & Shirts</a>
            <a class="btn-work btn-light" href="/men/baselayers" role="button">Baselayers</a>
            <a class="btn-work btn-light" href="/men/hats&accessories" role="button">Hats & Accessories</a>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
