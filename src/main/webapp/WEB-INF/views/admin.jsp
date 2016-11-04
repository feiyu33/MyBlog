<%--
  Created by IntelliJ IDEA.
  User: feiyu
  Date: 2016/10/19
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                            ${c.dictEntity.dictName}
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
                <li>
                    Lorem ipsum dolor sit amet
                </li>
                <li>
                    Consectetur adipiscing elit
                </li>
                <li>
                    Integer molestie lorem at massa
                </li>
                <li>
                    Facilisis in pretium nisl aliquet
                </li>
                <li>
                    Nulla volutpat aliquam velit
                </li>
                <li>
                    Faucibus porta lacus fringilla vel
                </li>
                <li>
                    Aenean sit amet erat nunc
                </li>
                <li>
                    Eget porttitor lorem
                </li>
            </ul>
            <ul class="pagination">
                <li>
                    <a href="#">Prev</a>
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
                    <a href="#">Next</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
