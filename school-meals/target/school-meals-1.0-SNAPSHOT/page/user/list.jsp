<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="utf-8">
	<title>list</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            font-size: 10pt;
        }
        .icon {

            margin:45px;
            border: solid 1px gray;
            width: 302px;
            height: 112px;
            text-align: center;
            float: left;
        }
    </style>
  </head>
  
  <body>

    <c:forEach items="${list}" var="list">
        <div class="icon">
            <a href="/user/findFoodDetail?mid=${list.mid}"><img src="${list.mimage}" border="0"/></a><br>
        </div>

    </c:forEach>
  </body>
 
</html>