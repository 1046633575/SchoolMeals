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
            <th>商品图片</th>
            <th>商品名称</th>
            <th>商品数量</th>
            <th>小计</th>
            <th>所属订单</th>
        </tr>
        </thead>

            <c:forEach items="${listOrderItem}" var="list" varStatus="s">
                <tr>
                    <td style="color: darkgreen">
                        <image id="fimage" src="${listFood[s.index].fimage}"></image>
                    </td>
                    <td>${listFood[s.index].fname}</td>
                    <td style="color: crimson">${list.count}</td>
                    <td style="color: brown">${list.subtotal}</td>
                    <td style="color: blue">${list.oid}</td>
                </tr>
        </c:forEach>

    </table>

</body>
</html>
