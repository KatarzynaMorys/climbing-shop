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

        .bg-img {
            /* The image used */
            background-image: url("https://www.theuiaa.org/wp-content/uploads/2019/07/RCFA19-Korea-6.jpg");

            min-height: 100%;

            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;

            /* Needed to position the navbar */
            position: relative;
        }

        /* Position the navbar container inside the image */
        .container-fluid {
            position: absolute;
            margin: 20px;
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
    </style>

</head>

<body>
<%@ include file="header.jsp" %>

<div class="bg-img">
    <%--    <img src="https://www.theuiaa.org/wp-content/uploads/2019/07/RCFA19-Korea-6.jpg">--%>
    <div class="container-fluid">
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

<%--<img src="https://www.theuiaa.org/wp-content/uploads/2019/07/RCFA19-Korea-6.jpg">--%>

<%--<h3>Climbing gear</h3>--%>
<%--<div class="row">--%>
<%--    <div class="col-4">--%>
<%--        <div class="list-group" id="list-climbing-gear" role="tablist">--%>
<%--            <a class="list-group-item list-group-item-action active" data-toggle="list" href="#expresses">Climbing--%>
<%--                expresses</a>--%>
<%--            <a class="list-group-item list-group-item-action" data-toggle="list" href="#carabiners">Carabiners/--%>
<%--                Quickdraws</a>--%>
<%--            <a class="list-group-item list-group-item-action" data-toggle="list" href="#belay">Belay/ Rappel</a>--%>
<%--            <a class="list-group-item list-group-item-action" data-toggle="list" href="#ropes">Climbing ropes</a>--%>
<%--            <a class="list-group-item list-group-item-action" data-toggle="list" href="#helmets">Helmets</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="col-8">--%>
<%--        <div class="tab-content" id="nav-tabContent1">--%>
<%--            <div id="expresses" class="tab-pane fade show active">--%>
<%--                <h3>Climbing expresses</h3>--%>
<%--                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut--%>
<%--                    labore et dolore magna aliqua.</p>--%>
<%--            </div>--%>
<%--            <div id="carabiners" class="tab-pane fade show">--%>
<%--                <h3>Carabiners/ Quickdraws</h3>--%>
<%--                <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea--%>
<%--                    commodo consequat.</p>--%>
<%--            </div>--%>
<%--            <div id="belay" class="tab-pane fade show">--%>
<%--                <h3>Belay/ Rappel</h3>--%>
<%--                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque--%>
<%--                    laudantium, totam rem aperiam.</p>--%>
<%--            </div>--%>
<%--            <div id="ropes" class="tab-pane fade show">--%>
<%--                <h3>Climbing ropes</h3>--%>
<%--                <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt--%>
<%--                    explicabo.</p>--%>
<%--            </div>--%>
<%--            <div id="helmets" class="tab-pane fade show">--%>
<%--                <h3>Helmets</h3>--%>
<%--                <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt--%>
<%--                    explicabo.</p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script>--%>
<%--    $('#list-climbing-gear a').on('click', function (e) {--%>
<%--        e.preventDefault()--%>
<%--        $(this).tab('show')--%>
<%--    })--%>
<%--</script>--%>

<%--<img src="https://image.freepik.com/free-photo/closeup-shot-many-colorful-climbing-carabiners-knots-wooden-surface_181624-18018.jpg">--%>
<%@ include file="footer.jsp" %>
</body>

</html>
