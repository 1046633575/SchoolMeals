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
            height: 145px;
            text-align: center;
            float: left;
        }
    </style>
      <script>
          var Msg = "${Msg}";
          if(Msg != null && Msg != ""){
              alert(Msg);
          }


          function deleteMerchant(e) {
              var msg1 = "您确定要删除吗?";
              if(confirm(msg1)==true){
                  var mid = e;
                  $.ajax({
                      type: "post",
                      url : "/admin/deleteMerchant",
                      data : {"mid" : mid},
                      dataType : "json",
                      success: function (data) {
                          alert(data.mmsg);
                          location.reload(true);
                      },
                      error: function () {
                          alert("请先删除店铺下的商品");
                      }
                  });
              }}
      </script>
  </head>
  
  <body>

    <c:forEach items="${list}" var="list">
        <div class="icon">
            <a href="/admin/findFoodDetail?mid=${list.mid}"><img src="${list.mimage}" border="0"/></a><br>
            <button type="button" class="btn btn-danger" onclick="deleteMerchant(${list.mid})">删除</button>
        </div>

    </c:forEach>
  </body>
 
</html>