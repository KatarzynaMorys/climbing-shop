<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Climbing Gear</title>
    <%--    <link rel="stylesheet" href="CSS_01.css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Cambria sans-serif;
            font-size: x-large;
        }

        * {
            box-sizing: border-box;
        }

        .position-fixed {
            position: fixed;
            width: 100%;
            min-height: 10rem;
            top: 75%;
        }

        .btn-light {
            opacity: 0.5;
        }

        .btn-work {
            width: 15%;
            height: 100px;
            margin: 0 auto;
            padding: 0;
            display: inline-block;
            line-height: 50px;
            text-align: center;
            vertical-align: middle;
            font-size: 18px;
        }

        .row {
            margin: -10px;
        }

        img {
            width: 100%;
            height: auto;
        }

    </style>

</head>

<body>
<%@ include file="header.jsp" %>

<div>
    <div>
        <img src="https://www.theuiaa.org/wp-content/uploads/2019/07/RCFA19-Korea-6.jpg" class="img-fluid">
    </div>
    <div class="position-fixed">
        <div class="row">
            <a class="btn-work btn-light" href="/climbingGear/shoes" role="button">Climbing shoes</a>
            <a class="btn-work btn-light" href="/climbingGear/carabiners" role="button">Carabiners</a>
            <a class="btn-work btn-light" href="/climbingGear/expresses" role="button">Climbing expresses</a>
            <a class="btn-work btn-light" href="/climbingGear/belay_rappel" role="button">Belay/ Rappel</a>
            <a class="btn-work btn-light" href="/climbingGear/ropes" role="button">Climbing ropes</a>
            <a class="btn-work btn-light" href="/climbingGear/helmets" role="button">Helmets</a>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>

</html>
