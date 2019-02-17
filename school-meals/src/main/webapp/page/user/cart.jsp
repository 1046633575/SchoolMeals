<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>cart</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
        <table class="table table-bordered">
            <tr>
                <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
                    <a href="<c:url value='/user/deleteAll'/>">清空购物车</a>
                </td>
            </tr>
            <tr>
                <th>商品图片</th>
                <th>商品名称</th>
                <th>商品单价</th>
                <th>商品数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${sessionScope.cart.cartItems }" var="cartItem">
                <tr>
                    <td><div><img src="<c:url value='/${cartItem.food.fimage }'/>"/></div></td>
                    <td>${cartItem.food.fname }</td>
                    <td>${cartItem.food.price }元</td>
                    <td>${cartItem.count }</td>
                    <td>${cartItem.subtotal }元</td>
                    <td><a href="/user/delete?fid=${cartItem.food.fid}" style="font-size: 13pt; font-weight: 800">删除此条</a></td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
                    合计：<b style="color: brown">${sessionScope.cart.total }</b>元
                </td>
            </tr>
            <tr>
                <td>当前账户余额 <b style="color: crimson">${sessionScope.user.balance}</b> 元</td>
                <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
                    <button type="button" class="btn btn-success"
                            onclick="javascript:window.location.href='/user/judge'" >去支付</button>
                </td>
            </tr>
        </table>
</body>
</html>
