<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/12 0012
  Time: 下午 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付成功页面</title>
</head>
<body>
    <h1>支付成功，等待送货上门吧！</h1>
    <h3>订单id <b style="color: blue">${order.oid}</b></h3>
    <h3>本次共花费<b style="color: crimson">${order.total}</b>元</h3>
</body>
</html>
