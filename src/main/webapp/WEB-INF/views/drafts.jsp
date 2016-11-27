<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/18
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>草稿箱</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
    <!--时间转化-->
    <script src="${path}/static/js/timeUtilJs.js"></script>
    <!--分页-->
    <script src="${path}/static/js/page.js"></script>
</head>
<body>
<div class="container" style="margin-top: 20px">
    <a href="${path}/blog/showAdmin" style="font-size: 20px">${name}的博客</a>>草稿箱<br>
    <input type="hidden" id="flag" value=""/>
    <div class="row clearfix" style="margin-top: 20px">
        <div class="col-md-12 column">
            <ul id="blog">
                <c:forEach items="${blogPageWrap.data}" var="b">
                    <li>
                        <a href="${path}/blog/showDetails?bid=${b.blog.id}&currentPage=1" style="font-family: italic;font-size: 18px;color:#1e90ff">${b.blog.title}</a><br/>
                        <span>阅读(${b.blog.readCounts})&nbsp;&nbsp;·评论(${b.commentCounts})&nbsp;&nbsp;·推荐(${b.blog.thumbUpNumber})&nbsp;&nbsp;·(<a href="${path}/blog/toEditor?bid=${b.blog.id}">编辑</a>|<a href="${path}/blog/delete?bid=${b.blog.id}" onclick="return confirm('确定要删除吗？')">删除</a>)</span>
                        <p>${fns:formatDate(b.blog.releaseTime,'yyyy-MM-dd HH:mm:ss' )} 发布</p>
                    </li>
                </c:forEach>
            </ul>

            <%@include file="page.jsp"%>
        </div>
    </div>
</div>
</body>
</html>
