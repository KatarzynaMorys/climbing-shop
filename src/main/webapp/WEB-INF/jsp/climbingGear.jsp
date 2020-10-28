<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Climbing Gear</title>
    <%--    <link rel="stylesheet" href="CSS_01.css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<%@ include file="header.jsp" %>
<h3>Climbing gear</h3>
<div class="row">
    <div class="col-4">
        <div class="list-group" id="list-climbing-gear" role="tablist">
            <a class="list-group-item list-group-item-action active" data-toggle="list" href="#expresses">Climbing
                expresses</a>
            <a class="list-group-item list-group-item-action" data-toggle="list" href="#carabiners">Carabiners/
                Quickdraws</a>
            <a class="list-group-item list-group-item-action" data-toggle="list" href="#belay">Belay/ Rappel</a>
            <a class="list-group-item list-group-item-action" data-toggle="list" href="#ropes">Climbing ropes</a>
            <a class="list-group-item list-group-item-action" data-toggle="list" href="#helmets">Helmets</a>
        </div>
    </div>
    <div class="col-8">
        <div class="tab-content" id="nav-tabContent1">
            <div id="expresses" class="tab-pane fade show active">
                <h3>Climbing expresses</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                    labore et dolore magna aliqua.</p>
            </div>
            <div id="carabiners" class="tab-pane fade show">
                <h3>Carabiners/ Quickdraws</h3>
                <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                    commodo consequat.</p>
            </div>
            <div id="belay" class="tab-pane fade show">
                <h3>Belay/ Rappel</h3>
                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                    laudantium, totam rem aperiam.</p>
            </div>
            <div id="ropes" class="tab-pane fade show">
                <h3>Climbing ropes</h3>
                <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt
                    explicabo.</p>
            </div>
            <div id="helmets" class="tab-pane fade show">
                <h3>Helmets</h3>
                <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt
                    explicabo.</p>
            </div>
        </div>
    </div>
</div>

<script>
    $('#list-climbing-gear a').on('click', function (e) {
        e.preventDefault()
        $(this).tab('show')
    })
</script>

</body>

</html>
