<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="utf-8">
	<title>food</title>
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
	</style>
      <script type="text/javascript">

          var Msg = "${msg}";
          if(Msg != null && Msg != ""){
              alert(Msg);
          }

          //初始化就调用getNextClassify方法
          $(function () {
              getNextClassify();
          })
          //下拉框连动
          function getNextClassify() {
              //获取下拉框主键
              var cid=$("#cid").find('option:selected').val();
              $("#mid").empty();     //清空二级目录
              var classNext=$("#mid");
              $.ajax({
                  type: "post",
                  url : "/admin/findMerchant",
                  data : {"cid" : cid},
                  dataType: "json",
                  success: function (data) {
                      var beanList = data;
                      if(beanList){
                          for ( var i = 0; i < beanList.length; i++) {
                                  classNext.append("<option value="+beanList[i].mid+">"+beanList[i].mname+"</option>");
                               }
                               }else{
                                   classNext.append("<option value="+2+">---无---</option>");
                               }
                      },
                  error: function () {
                      alert("请求失败");
                  }
              });
          }


      </script>
  </head>
  
  <body>
    <form action="<c:url value='/admin/addFood'/>" method="post" enctype="multipart/form-data" class="form-horizontal" role="form" id="form">
        <div class="form-group" >
            <label  class="col-sm-2 control-label">食物名称</label>
            <div class="col-sm-10" style="width: 300px;">
                <input type="text" class="form-control" id="fname" name="fname"
                       style="border-top-right-radius: 10px; " placeholder="请输入食物名称">
            </div>
        </div>
        <div class="form-group" >
            <label  class="col-sm-2 control-label">食物价格</label>
            <div class="col-sm-10" style="width: 300px;">
                <input type="text" class="form-control" id="price" name="price"
                       placeholder="请输入食物价格">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">食物图片</label>
            <div class="form-group">
            <input type="file" name="file" id="file">
            </div>
        </div>
            <div class="form-group">
                <!-- 一级目录 -->
                <label class="col-sm-2 control-label">所属店铺:</label>
                <div class="col-xs-2">
                    <select class="form-control" name="cid" id="cid" onChange="getNextClassify()">
                        <c:forEach items="${list3}" var="list3">
                            <option value="${list3.cid}">${list3.cname}</option>
                        </c:forEach>
                    </select>
                </div>
                <!-- 二级目录 -->
                <div class="col-xs-2">
                    <select class="form-control" name="mid" id="mid">

                    </select>
                </div>
            </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">添加食物</button>
            </div>
        </div>
</form>

  </body>
</html>