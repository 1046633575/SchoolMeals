<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>pay</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">

        var errMsg = "${errMsg}";
        if(errMsg != null && errMsg != ""){
            alert(errMsg);
        }

        function verification(){

            var phone = document.getElementById("phone");
            if(phone.value.length==0){
                confirm("电话不能为空");
                return false;
            }
            var address = document.getElementById("address");
            if(address.value.length==0){
                confirm("收货地址不能为空");
                return false;
            }
            return true;
        }

    </script>
</head>
<body>
        <form class="form-horizontal" role="form" style="width: 600px" action="/user/addOrder" method="post" onsubmit="return verification()">

            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">电话</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone" name="phone"
                           placeholder="请输入联系电话">
                </div>
            </div>
            <div class="form-group">
                <label for="address" class="col-sm-2 control-label">收货地址</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="address" name="address"
                           placeholder="请输入收货地址">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success">购买</button>
                </div>
            </div>
        </form>

</body>
</html>

