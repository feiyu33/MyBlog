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
<c:set var="path" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>博主登录</title>
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


<div class="container" style="margin-top: 100px">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <div style="margin-left: 100px;">
                <img alt="140x140" src="${user.imageUrl}" height="140px" width="140px" class="img-circle"/><br/><br/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-default btn-sm">
                    <span class="glyphicon glyphicon-user"></span> <b>${user.userName}</b>
                </button><br/><br/>
                <button type="button" class="btn btn-info" onclick="location.href='${path}/blog/toWrite'">写博客</button>
                <button type="button" class="btn btn-link">草稿箱(${draftCounts})</button>
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

        <div class="col-md-8 column">
            <nav class="navbar navbar-default navbar-static-top" role="navigation">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">最新</a>
                        </li>
                        <li>
                            <a href="#">最热</a>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control"/>
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>
                </div>
            </nav>
            <ul>
                <c:forEach items="${blogPageWrap.data}" var="b">
                    <li>
                        <a href="#" style="font-family: 微软雅黑;font-size: 18px;color:#1e90ff">${b.title}</a><br/>
                        <span>阅读(${b.readCounts})&nbsp;&nbsp;·评论(0)&nbsp;&nbsp;·推荐(${b.thumbUpNumber})&nbsp;&nbsp;·(<a href="#">编辑</a>|<a href="#">删除</a>)</span>
                        <p>${fns:formatDate(b.releaseTime,'yyyy-MM-dd HH:mm:ss' )}</p>
                    </li>
                </c:forEach>
            </ul>
            <ul class="pagination">
                <li>
                    <a href="#">上一页</a>
                </li>
                <li>
                    <a href="#">1</a>
                </li>
                <li>
                    <a href="#">2</a>
                </li>
                <li>
                    <a href="#">3</a>
                </li>
                <li>
                    <a href="#">4</a>
                </li>
                <li>
                    <a href="#">5</a>
                </li>
                <li>
                    <a href="#">下一页</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
