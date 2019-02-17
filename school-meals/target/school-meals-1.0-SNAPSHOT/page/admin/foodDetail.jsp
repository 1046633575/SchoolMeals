<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>foodDetail</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function deleteFood(e) {
            var msg1 = "您确定要删除吗?";
            if(confirm(msg1)==true){
                var fid = e;
                alert(fid);
                $.ajax({
                    type: "post",
                    url : "/admin/deleteFood",
                    data : {"fid" : fid},
                    dataType : "json",
                    success: function (data) {
                        alert(data.mmsg);
                        location.reload(true);
                    },
                    error: function () {
                        alert("请求发送失败");
                    }
                });
            }}
    </script>
</head>

<body>
<table class="table table-striped">
    <h2></h2>
    <thead>
        <tr>
            <th>图片</th>
            <th>名称</th>
            <th>价格</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list5}" var="list">
            <tr class="success">
                <td><image src="${list.fimage}"></image></td>
                <td>${list.fname}</td>
                <td>${list.price}</td>
                <td><button type="button" class="btn btn-danger"
                            onclick="deleteFood(${list.fid})">删除</button></td>
            </tr>
        </c:forEach>

    </tbody>
</table>


</body>
</html>
