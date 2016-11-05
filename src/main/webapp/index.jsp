<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>test</title>
    <script type="text/javascript"src="${path}/static/js/ckeditor/ckeditor.js"></script>
</head>
<body>
<div align="center">
    <h1>上传文件</h1>
    <form method="post" action="file/uploadImg" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="上传">
    </form>
    <form method="post" action="test/login">
        用户名：<input type="text" name="userName"/>
        密码：<input type="password" name="password"/>
        <input type="submit" value="登录">
        <textarea id="editor1" class="ckeditor">Sample Text</textarea>
    </form>

</div>
</body>
</html>
