<%--
  Created by IntelliJ IDEA.
  User: feiyu
  Date: 2016/10/19
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>博主首页</title>
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
    <!--搜索和切换tab-->
    <script src="${path}/static/js/turnAndSerach.js"></script>
</head>
<body>


<div class="container" style="margin-top: 100px">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <div style="margin-left: 100px;">
                <img alt="140x140" src="${user.imageUrl}" height="140px" width="140px" class="img-circle"/><br/><br/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-default btn-sm" onclick="location.href='${path}/user/showUser'">
                    <span class="glyphicon glyphicon-user"></span> <b>${user.userName}</b>
                </button><br/><br/>
                <button type="button" class="btn btn-info" onclick="location.href='${path}/blog/toWrite'">写博客</button>
                <button type="button" class="btn btn-link" onclick="location.href='${path}/blog/toDrafts?currentPage=1'">草稿箱(${draftCounts})</button>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th>
                        <b>分类</b>
                    </th>
                    <th>
                        <b>篇数</b>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${classificationPOs}" var="c">
                    <tr>
                        <td>
                            <a href="#">${c.dictEntity.dictName}</a>
                        </td>
                        <td>
                                ${c.blogCounts}
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="col-md-8 column" id="right">
            <input type="hidden" id="flag" value="new"/>
            <nav class="navbar navbar-default navbar-static-top" role="navigation">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav" id="active">
                        <li class="active" id="new">
                            <a>最新</a>
                        </li>
                        <li id="hot">
                            <a>最热</a>
                        </li>
                    </ul>
                    <form id="search" class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" name="keyword" id="keyword"/>
                        </div>
                        <button type="button" class="btn btn-default" onclick="searchKey();">搜索</button>
                    </form>
                </div>
            </nav>
            <ul id="blog">
                <c:forEach items="${blogPageWrap.data}" var="b">
                    <li>
                        <a href="${path}/blog/showDetails?bid=${b.blog.id}" style="font-family: italic;font-size: 18px;color:#1e90ff">${b.blog.title}</a><br/>
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
