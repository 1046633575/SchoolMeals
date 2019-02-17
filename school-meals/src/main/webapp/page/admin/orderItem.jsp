<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>orderItem</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<table class="table table-bordered">

    <thead>

    <tr style="color: orange">
        <th>id: ${order.oid}</th>
        <th>创建时间: ${order.ordertime}</th>
        <th>订单金额: ${order.total}</th>
        <th>收货电话: ${order.phone}</th>
        <th>收货地址: ${order.address}</th>
    </tr>
    <tr>
        <th>项id</th>
        <th>商品数量</th>
        <th>小计</th>
        <th>所属订单</th>
        <th>所属商品id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list3}" var="list">
        <td style="color: darkgreen">${list.fid}</td>
        <td style="color: crimson">${list.count}</td>
        <td style="color: brown">${list.subtotal}</td>
        <td style="color: blue">${list.oid}</td>
        <td style="color: blueviolet">${list.fid}</td>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
