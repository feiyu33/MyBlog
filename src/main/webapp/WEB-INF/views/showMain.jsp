<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/18
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>博客首页</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

    <link href="http://apps.bdimg.com/libs/bootstrap/3.0.1/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.0.1/js/dropdown.js"></script>
    <!--时间转化-->
    <script src="${path}/static/js/timeUtilJs.js"></script>
    <!--分页-->
    <script src="${path}/static/js/showPage.js"></script>

</head>
<body>
<%@include file="navigationBar.jsp"%>
<input type="hidden" id="flag" value="new"/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-8 column" style="padding-left: 10%" >
            <div class="col" id="blogs">
                <c:forEach items="${blogPageWrap.data}" var="b">
                    <div class="col-md-12">
                        <div class="thumbnail">
                            <div class="caption">
                                <a style="font-size:25px;text-decoration:none;" href="${path}/show/showDetails?bid=${b.blog.id}">${b.blog.title}</a>
                                <div class="row" style="padding-top: 12px;font-size:12px;height: 160px;overflow: hidden;">
                                    <div class="col-lg-3 col-sm-3">
                                        <c:if test="${b.img != null && b.img != '[]'}">
                                            <div style="text-align: center;"><img alt="图片加载失败" src="${b.img}" width="140" height="100"/></div>
                                        </c:if>
                                    </div>
                                    <div class="col-lg-9 col-sm-9" style="font-size: 14px">
                                        <div>${b.blog.content}</div>
                                    </div>
                                </div>
                                <br>
                                <div style="text-align: right">
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <label style="font-size: 12px;width: 70px;text-align: left">
                                        <span class="glyphicon glyphicon-eye-open" style="color: gray" aria-hidden="true"></span>
                                        阅读(${b.blog.readCounts})
                                    </label>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <label style="font-size: 12px;width: 70px;text-align: left">
                                        <span class="glyphicon glyphicon-edit" style="color: gray" aria-hidden="true"></span>
                                        评论${b.commentCounts})
                                    </label>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <label style="font-size: 12px;width: 70px;text-align: left">
                                        <span class="glyphicon glyphicon-thumbs-up" style="color: gray" aria-hidden="true">
                                        </span>  推荐(${b.blog.thumbUpNumber})
                                    </label>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <label style="font-size: 12px;">
                                        发布于 ${fns:formatDate(b.blog.releaseTime,'yyyy-MM-dd HH:mm:ss' )}
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-md-4 column">
            <h4>阅读排行</h4>
            <ol>
                <c:forEach items="${readBlogs}" var="r">
                    <li>
                        <a style="font-size:15px;" href="${path}/show/showDetails?bid=${r.id}">${r.title}</a>
                    </li>
                </c:forEach>
            </ol>
            <h4>热门排行</h4>
            <ol>
                <c:forEach items="${rankBlogs}" var="b">
                    <li>
                        <a style="font-size:15px;" href="${path}/show/showDetails?bid=${b.id}">${b.title}</a>
                    </li>
                </c:forEach>
            </ol>
            <div style="padding-top: 30px;">
                <fieldset>
                    <div><label>当日访问：${visitCounts} 次</label></div>
                    <div><label>历史访问：${historyVisits} 次</label></div>
                </fieldset>

            </div>

        </div>
    </div>
    <div align="center"><%@include file="page.jsp"%></div>
</div>
</body>
</html>
