<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String rootPath = request.getContextPath();
%>
<html>
  <head>
    <meta charset="utf-8">
	<title>top</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
		
<style type="text/css">
	body {
		background: #ffffff; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
	.top{
		margin-top: 20px;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">校园外卖系统</h1>
<div style="font-size: 10pt;" class="top">
	<c:choose>
		<c:when test="${empty sessionScope.user }">
			<nav class="navbar navbar-inverse" role="navigation">
				<div class="container-fluid">

					<ul class="nav navbar-nav navbar-left">
						<li><a href="#"><span class="glyphicon glyphicon-plus-sign"></span> 注册</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
					</ul>
				</div>
			</nav>
		</c:when>
		<c:otherwise>
			<nav class="navbar navbar-inverse" role="navigation">
				<div class="container-fluid">

					<ul class="nav navbar-nav navbar-left">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span>${sessionScope.user.username }</a><li>
						<li><a href="cart.jsp" target="body"><span class="glyphicon glyphicon-shopping-cart" ></span>我的购物车</a></li>
						<li><a href="/user/findOrders?uid=${sessionScope.user.uid}" target="body"><span class="glyphicon glyphicon-briefcase"></span>我的订单</a></li>
						<li><a href="/user/logout" target="_top"><span class="glyphicon glyphicon-log-out" ></span>退出</a></li>
					</ul>
				</div>
			</nav>
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>