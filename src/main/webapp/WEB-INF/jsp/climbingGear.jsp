<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Climbing gear</title>
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

<div>
    <div class="card">
        <img src="https://www.rei.com/dam/harnois_071516_0544_main_lg.jpg"
             class="img-fluid">

        <div class="card-img-overlay">
            <a class="btn btn-outline-light" href="/climbingGear/shoes" role="button">Shoes</a>
            <a class="btn btn-outline-light" href="/climbingGear/harnesses" role="button">Harnesses</a>
            <a class="btn btn-outline-light" href="/climbingGear/belay&rappel" role="button">Belay & Rappel</a>
            <a class="btn btn-outline-light" href="/climbingGear/carabiners" role="button">Carabiners</a>
            <a class="btn btn-outline-light" href="/climbingGear/quickdraws" role="button">Quickdraws</a>
            <a class="btn btn-outline-light" href="/climbingGear/ropes" role="button">Ropes</a>
            <a class="btn btn-outline-light" href="/climbingGear/helmets" role="button">Helmets</a>
            <a class="btn btn-outline-light" href="/climbingGear/chalk&accessories" role="button">Chalk &
                Accessories</a>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>

</html>
