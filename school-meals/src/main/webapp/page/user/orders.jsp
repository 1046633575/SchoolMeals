<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">
	<title>orders</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<table class="table table-bordered">

	<thead>
	<tr>
		<th>订单id</th>
		<th>创建时间</th>
		<th>订单金额</th>
		<th>订单状态</th>
		<th>操作</th>

	</tr>
	</thead>
	<tbody>
    <c:forEach items="${listOrders}" var="list">
        <tr>
            <td style="color: darkgreen">${list.oid}</td>
            <td style="color: tomato">${list.ordertime}</td>
            <td style="color: orangered">${list.total}元</td>
            <c:choose>
                <c:when test="${list.state == 1 }">
                    <td style="color: chocolate">未收货 <a href="/user/over?oid=${list.oid}">确认收货</a></td>
                </c:when>
                <c:otherwise>
                    <td style="color: blue">已收货</td>
                </c:otherwise>
            </c:choose>
            <td><a href="/user/orderDetail?oid=${list.oid}">查看详情</a></td>
        </tr>
    </c:forEach>
	</tbody>
</table>

</body>
</html>