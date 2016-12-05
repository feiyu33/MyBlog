<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/18
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://cdn.bootcss.com/bootstrap/3.0.1/js/dropdown.js"></script>
</head>
<body>
<!-- 顶部导航 -->
<nav class="navbar navbar-inverse navbar-static-top" role="navigation" style="background-color: #008B45">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${path}/show/main" style="color: #dff1ff">${user.userName}的博客</a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                <li><a href="${path}/show/main">首页</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">分类 <strong class="caret"></strong></a>
                    <ul class="dropdown-menu" id="classifitions">
                        <c:forEach items="${classificationPOs}" var="c" varStatus="status">
                            <li><a href="${path}/show/classification?classification=${c.dictEntity.dictValue}&currentPage=1" id="${c.dictEntity.dictValue}">${c.dictEntity.dictName}</a></li>
                            <c:if test="${status.index < classificationPOs.size()-1}">
                                <li role="separator" class="divider"></li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="#" data-toggle="modal" data-target="#about-modal">关于</a></li>
            </ul>
            <div style="float: right;">
                <div class="input-group" style="padding-top: 9px">
                    <form action="${path}/show/searchByKey" method="post">
                        <input style="font-size:18px;width: 280px" class="form-control" name="key" placeholder="搜索你感兴趣的内容...">
                        <button class="btn btn-default" type="submit">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</nav>
<div class="modal fade" id="about-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span
                        aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                <h4 class="modal-title" id="modal-label">关于</h4>
            </div>
            <div class="modal-body">
                <div style="text-align: center;padding-top:30px;padding-bottom: 10px">
                    <p>这是一个分享、记录技术与生活的博客</p>
                    <img src="${user.imageUrl}" width="100px" height="100px" class="img-circle">
                    <div style="padding-top: 20px">
                        <p>博主邮箱 : ${user.email}</p>
                        <p>现居城市 : ${user.presentAddress}</p>
                        <p>教育程度 : ${user.diploma}</p>
                        <p>个人标签 : ${user.labels}</p>
                        <p>github : <a href="https://github.com/feiyu33" target="_blank">https://github.com/feiyu33</a></p>
                        <p>听从自己内心的声音,做自己想做的事情.</p>
                    </div>
                </div>
                <p style="text-align: right">By ${user.userName}</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">了解</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
