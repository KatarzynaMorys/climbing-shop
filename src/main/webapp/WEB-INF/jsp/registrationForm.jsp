<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>
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

<%@ include file="header.jsp" %>

<div class="container">

    <h3>Create an account</h3>

    <form action="/register" method="post">

        <div class="form-group">
            <label for="firstName">First name</label>
            <input type="text" name="firstName" class="form-control" id="firstName">
        </div>
        <div class="form-group">
            <label for="lastName">Last name</label>
            <input type="text" name='lastName' class="form-control" id="lastName">
        </div>
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" name='email' class="form-control" id="email">
        </div>
        <div class="form-group">
            <label for="hashPassword">Password</label>
            <input type="password" name="hashPassword" class="form-control" id="hashPassword">
        </div>
        <button type="submit" class="btn btn-light btn-lg btn-block">Register</button>

    </form>

    <%@ include file="footer.jsp" %>

</div>

</body>