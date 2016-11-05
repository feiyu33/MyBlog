<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/1
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>写博客</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
    <!--导入ckeditor相关js-->
    <script type="text/javascript" src="${path}/static/js/ckeditor/ckeditor.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<div class="container" style="margin-top: 20px">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="${path}/blog/publish" method="post">
                <div class="form-group">
                    <label for="title">标题</label><input type="text" class="form-control" id="title" name="title"
                                                        placeholder="请输入博文标题"/>
                </div>
                <div class="form-group">
                    <label for="classification">分类</label>
                    <select class="form-control" id="classification" name="classification">
                        <c:forEach items="${classifications}" var="c">
                            <option value="${c.dictValue}">${c.dictName}</option>
                        </c:forEach>
                    </select>
                </div>

                <textarea id="editor1" class="ckeditor" name="content">博文内容</textarea>

                <div class="form-select-button">
                    <label>是否允许评论</label>
                    <input type="radio" name="isComments" value="0" checked>是
                    <input type="radio" name="isComments" value="1">否
                </div>
                <div class="btn-toolbar" role="toolbar">
                    <div class="btn-group">
                        <button type="submit" class="btn btn-success" name="isDraft" value="0">发布
                        </button>
                        <button type="submit" class="btn btn-info" name="isDraft" value="1">存为草稿</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>