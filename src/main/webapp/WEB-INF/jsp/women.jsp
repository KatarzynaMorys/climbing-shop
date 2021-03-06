<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Women clothing</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        <%@include file="../css/position.css"%>
    </style>
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
<%@ include file="header.jsp" %>

<div class="card">
    <img src="https://www.liveabout.com/thmb/nxNSPsJEvBOiK3RUZnutkDSoCbQ=/2048x1152/smart/filters:no_upscale()/8586997093_d9da01308f_k-5c576c2ac9e77c00016b367c.jpg"
         class="img-fluid">

        <div class="card-img-overlay">
            <a class="btn btn-outline-light" href="/women/jackets&vests" role="button">Jackets & Vests</a>
            <a class="btn btn-outline-light" href="/women/pants&shorts" role="button">Pants & Shorts</a>
            <a class="btn btn-outline-light" href="/women/t-shirts&shirts" role="button">T-Shirts & Shirts</a>
            <a class="btn btn-outline-light" href="/women/baselayers" role="button">Baselayers</a>
            <a class="btn btn-outline-light" href="/women/hats&accessories" role="button">Hats & Accessories</a>
        </div>

</div>

<%@ include file="footer.jsp" %>
</body>

</html>