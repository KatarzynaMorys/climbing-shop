<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Men clothing</title>
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

<html>

<body>
<%@ include file="header.jsp" %>

<div class="img-wrapper">
    <img src="https://images.unsplash.com/photo-1583889250027-ed17e70239c7?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2850&q=80"
         class="img-fluid">

    <div class="img-overlay">
        <a class="btn btn-outline-light btn-lg" href="/men/jackets&vests" role="button">Jackets & Vests</a>
        <a class="btn btn-outline-light btn-lg" href="/men/pants&shorts" role="button">Pants & Shorts</a>
        <a class="btn btn-outline-light btn-lg" href="/men/t-shirts&shirts" role="button">T-Shirts & Shirts</a>
        <a class="btn btn-outline-light btn-lg" href="/men/baselayers" role="button">Baselayers</a>
        <a class="btn btn-outline-light btn-lg" href="/men/hats&accessories" role="button">Hats & Accessories</a>
    </div>

</div>

<%@ include file="footer.jsp" %>
</body>
