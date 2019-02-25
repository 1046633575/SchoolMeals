<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="utf-8">
	<title>body</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
		body {
		font-size: 10pt;
		}
		#form{
			width: 800px;
		}
        .form-control{
            width: 500px;
        }
	</style>

  </head>
  
  <body>
    <form action="<c:url value='/admin/addMerchant'/>" method="post" enctype="multipart/form-data" class="form-horizontal" role="form" id="form">
        <div class="form-group" >
            <label  class="col-sm-2 control-label">店铺名称</label>
            <div class="col-sm-10" style="width: 300px;">
                <input type="text" name="mname" class="form-control" id="merchant-name"
                       placeholder="请输入店铺名称">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">选择餐厅</label>
            <div class="col-xs-2">
                <select class="form-control" name="cid">
                    <c:forEach items="${list1}" var="list1">
                        <option value="${list1.cid}">${list1.cname}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="form-group">
            <label  class="col-sm-2 control-label">店铺图片</label>
            <div class="form-group">
            <label class="sr-only" for="file">文件输入</label>
            <input type="file" id="file" name="file">
        </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">添加店铺</button>
            </div>
        </div>
    </form>

  </body>
</html>