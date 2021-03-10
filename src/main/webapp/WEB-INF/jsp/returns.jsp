<!DOCTYPE html>
<html lang="en">
<head>
    <title>Returns</title>
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

<h3>Returns</h3>

Order Statuses:
Order Submitted - "Placed"
Once you have placed your order and your credit card has been authorized, your order status will appear as "Placed."

Order Processing - "In Progress"
Once you have placed your order, it will be sent to our warehouse to be processed and packed for shipment. During this
time, your order status will appear as "In Progress." Please allow 1 - 2 business days for the order to be processed and
prepared for shipment.

Order Delivery - "Shipped"
Once we have assigned a tracking number to your order, and it has left our warehouse, the order status will appear as
"Shipped."

Order Delivery - "Partially Shipped"
If your order will arrive in multiple shipments, once one of those shipments has left our warehouse, the order status
will appear as "Partially Shipped."

Order Returned - "Returned"
It takes up to 2 weeks to process a return and credit your credit card account. Once your order has been returned and
processed, the order status will show "Returned." We will notify you via email once your return has been processed.

<%@ include file="footer.jsp" %>
</body>

</html>