<html>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
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
            margin: 10px;
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
    <img src="https://www.lifehacker.com.au/content/uploads/sites/4/2019/03/rock-climbing.jpg" class="img-fluid">
    <div class="position-fixed">
        <div class="row">
            <a class="btn-work btn-light" href="/womenClothing/jackets" role="button">Jackets & Vests</a>
            <a class="btn-work btn-light" href="/womenClothing/pants" role="button">Pants & Shorts</a>
            <a class="btn-work btn-light" href="/womenClothing/shirts" role="button">T-Shirts & Shirts</a>
            <a class="btn-work btn-light" href="/womenClothing/baselayers" role="button">Baselayers</a>
            <a class="btn-work btn-light" href="/womenClothing/accessories" role="button">Climbing Hats & Accessories</a>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>

</html>