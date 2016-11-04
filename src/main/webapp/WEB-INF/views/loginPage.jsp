<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/23
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>

<html>
<head>
    <meta charset="utf-8">
    <title>登录系统</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap-theme.min.css" rel="stylesheet">

</head>
<body>
<div style="margin-top: 150px;">
    <h3 style="text-align: center">博客登录</h3>
    <hr>
    <section>
        <form action="${path}/user/login" method="post" class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-sm-5" style="font-size: 18px;">用户名 ：</label>
                <div class="col-sm-5" style="">
                    <input style="width:180px;font-size: 18px" type="text" class="form-control" name="name" placeholder="admin">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-5" style="font-size: 18px">密&nbsp;&nbsp;&nbsp;&nbsp;码 ：</label>
                <div class="col-sm-5">
                    <input style="width:180px;font-size: 18px" type="password" class="form-control" name="password" placeholder="123456">
                </div>
            </div>
            <hr>
            <center>
                <div class="col-lg-offset-0" style="width: 360px;">
                    <p style="color: red">${msg}</p>
                    <button style="font-size: 18px;"  type="submit" class="btn btn-info">登录</button>
                </div>
            </center>
        </form>
    </section>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>