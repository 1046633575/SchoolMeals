<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="UTF-8">
      <meta name="viewport" content="targrt-densitydpi=dpi,minimal-ui">
    <title>校园外卖系统</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>

	<style type="text/css">
		*{
			font-size:10pt;
		}
		body{
			text-align:center;
		}
		.table{
			width:1430px;
			height:100%;
			border:0px solid gray;//固定边框,1像素
		   
		}
		
		iframe {
			width: 100%;
			height: 100%;
		}
		
		li{
			list-style:none
		}
		
	</style>

  </head>
  
  <body>
<table class="table" align="center">
	<tr style="background: #ffffff; height: 120px;">
		<td colspan="2" align="center">
			<iframe frameborder="0" src="/page/admin/top.jsp" name="top"></iframe>

		</td>
	</tr>
	<tr>

		<td width="200" style="padding:5px;" align="center" valign="top" id="menu">
		<ul class="menu">

			<li >
				<a href="/admin/findAll"
				   class="list-group-item list-group-item-success" target="body">
					<h4 class="list-group-item-heading">
						所有店铺
					</h4>
				</a>
			</li>
			<li >
				<a href="/admin/findAllCategory"
				   class="list-group-item list-group-item-info" target="body">
					<h4 class="list-group-item-heading">
						添加店铺
					</h4>
				</a>
			</li>
			<li >
				<a href="/admin/findCategory"
				   class="list-group-item list-group-item-warning" target="body">
					<h4 class="list-group-item-heading">
						添加食物
					</h4>
				</a>
			</li>
			<li>
				<a href="/admin/findAllOrders"
				   class="list-group-item list-group-item-danger" target="body">
					<h4 class="list-group-item-heading">
						订单管理
					</h4>
				</a>
			</li>
		</ul>
		</td>

		<td height="730px">
			<iframe id="menuFrame" frameborder="0" src="" name="body"></iframe>
			

		</td>
	</tr>
</table>

  </body>
</html>