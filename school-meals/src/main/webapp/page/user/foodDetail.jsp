<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>foodDetail</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<table class="table table-striped">
    <h2></h2>
    <thead>
        <tr>
            <th>图片</th>
            <th>名称</th>
            <th>价格</th>
            <th>数量</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list2}" var="list">
            <tr>
                <td><image src="${list.fimage}"></image></td>
                <td>${list.fname}</td>
                <td>${list.price}</td>

                <td><button type="button" class="btn btn-info btn-lg"
                    onclick="javascript:window.location.href='/user/addCart?fid=${list.fid}'" >添加到购物车</button></td>
            </tr>

        </c:forEach>

    </tbody>
</table>


</body>
</html>
