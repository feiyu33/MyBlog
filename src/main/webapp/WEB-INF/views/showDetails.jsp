<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/6
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>博文详情</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container table_box" style="margin-top: 30px">
    <a href="${path}/blog/showAdmin" style="font-size: 20px">${name}的博客</a>>详情
    <!-- <h2 >40</h2> -->
    <h2 style="text-align:left;"><b> ${blogPO.blog.title}</b></h2>
    <div style="text-align: right;font-size: 16px;padding-top: 10px">
        <div style="float: left">
            标签：
            <a href="#" class="label label-success" style="font-size: 16px">${blogPO.blog.classification}</a>
        </div><br>
        <label style="font-size: 15px;text-align: left"><span class="glyphicon glyphicon-eye-open" style="color: gray" aria-hidden="true"></span> <a style="text-decoration:none;">阅读(${blogPO.blog.readCounts})</a></label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label style="font-size: 15px;text-align: left"><span class="glyphicon glyphicon-edit" style="color: gray" aria-hidden="true"></span>  <a style="text-decoration:none;">评论(${blogPO.commentCounts})</a></label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label style="font-size: 15px;text-align: left"><span class="glyphicon glyphicon-thumbs-up" style="color: gray" aria-hidden="true"></span>  推荐(${blogPO.blog.thumbUpNumber})</label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label style="font-size: 15px">发布于 ${fns:formatDate(blogPO.blog.releaseTime, "yyyy-MM-dd hh:MM:ss")}</label>
    </div>
    <hr>
    <div style="padding-top: 4px;padding-left: 10px;padding-right: 10px;text-align: center">
        ${blogPO.blog.content}
    </div>

    <hr style="border: 1px solid silver;"/>
    <h3 style="padding-top: 10px">评论列表&nbsp;&nbsp;&nbsp;&nbsp;${blogPO.commentCounts}条</h3>

    <div style="padding-top: 10px;padding-left: 10px;padding-right: 10px">
        <c:forEach items="${blogPO.comments.data}" var="b">
            <%--<span style="color:black;width: 40px">楼</span>
            &nbsp;&nbsp;&nbsp;&nbsp;--%>
            <span class="glyphicon glyphicon-user" style="color: gray ;width:150px" aria-hidden="true">&nbsp;${b.userName}</span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span class="glyphicon glyphicon-envelope" style="color: gray;width:300px" aria-hidden="true">&nbsp;${b.email}</span>
            <div style="font-size:16px;padding: 20px 50px 10px 45px;">${b.data.content}</div>
            <div style="color:gray;float: right">
                <i>评论于 ${fns:formatDate(b.commentTime, "yyyy-MM-dd hh:MM:ss")}</i>
            </div>
            <hr>
        </c:forEach>
    </div>
</body>
</html>
