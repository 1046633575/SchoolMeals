<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String rootPath = request.getContextPath();
%>
<html>
<head>

    <meta charset="utf-8">
    <title>后台登录</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">

        var errMsg = "${errMsg}";
        if(errMsg != null && errMsg != ""){
            alert(errMsg);
        }

        function verification(){
            //得到name输入框对象
            var name = document.getElementById("username");
            //判断输入框是否有内容
            if(name.value.length==0){
                confirm("用户名不能为空");
                return false;
            }
            var pass = document.getElementById("password");
            if(pass.value.length==0){
                confirm("密码不能为空");
                return false;
            }
            return true;
        }

    </script>
    <style>
        #login{
            margin: auto;
            float: center;
            height: 50%;
            width: 23%;
            margin-top: 200px;
            /*display: inline;*/
            /*z-index: 999;*/
            border: 0;
        }
        #top{
            text-align: center;
            margin-bottom: 50px;
        }

    </style>

</head>
<body>


<div class="panel panel-default" id="login">
    <div class="panel-body">
        <div id="top">
            <h1><b>管理员登录</b></h1>
        </div>
        <form class="form-horizontal" action="<%=rootPath%>/admin/login" method="post" onsubmit="return verification()">
            <div class="form-group">
                <label for="username">username</label>
                <input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名">
            </div>
            <div class="form-group">
                <label for="password">password</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码">
            </div>
            <input type="submit" class="btn btn-primary  btn-block"
                    value="login" />
        </form>
    </div>
</div>

</body>
</html>
