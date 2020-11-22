<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>

<body>
<%@ include file="header.jsp" %>

<div container>
    <div>
        <h3>${category.categoryName}</h3>
    </div>

    <div>
        <%@ include file="filter.jsp"%>
    </div>

    <div>
        <%@ include file="category.jsp"%>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>

</html>