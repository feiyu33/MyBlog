<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/7
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>用户信息</title>
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
<div class="container" style="margin-top: 30px;">
    <a href="${path}/blog/showAdmin" style="font-size: 20px">${name}的博客</a>>个人信息
    <div class="row clearfix" style="text-align: center">
        <div class="col-md-12 column">
            <img alt="140x140" src="${user.imageUrl}" height="140px" width="140px" class="img-circle" data-toggle="modal" data-target="#updateImage"/>
            <table class="table" style="text-align: center;margin-top: 20px;margin-left: 120px">
                <tr>
                    <td style="text-align: right"><span style="font-size: 18px;">博主姓名 ：</span></td>
                    <td style="text-align: left"><span style="font-size: 18px;">${user.userName}</span></td>
                </tr>
                <tr>
                    <td style="text-align: right"><span style="font-size: 18px;">博主邮箱 ：</span></td>
                    <td style="text-align: left"><span style="font-size: 18px;">${user.email}</span></td>
                </tr>
                <tr>
                    <td style="text-align: right"><span style="font-size: 18px;">现居城市 ：</span></td>
                    <td style="text-align: left"><span style="font-size: 18px;">${user.presentAddress}</span></td>
                </tr>
                <tr>
                    <td style="text-align: right"><span style="font-size: 18px;">教育程度 ：</span></td>
                    <td style="text-align: left"><span style="font-size: 18px;">${user.diploma}</span></td>
                </tr>
                <tr>
                    <td style="text-align: right"><span style="font-size: 18px;">个人标签 ：</span></td>
                    <td style="text-align: left"><span style="font-size: 18px;">${user.labels}</span></td>
                </tr>
                <tr>
                    <td style="text-align: right"><button type="button" class="btn btn-default btn-success" data-toggle="modal" data-target="#updateUser">修改个人信息</button></td>
                    <td style="text-align: left"><button type="button" class="btn btn-default btn-info" data-toggle="modal" data-target="#updatePwd">修改密码</button></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div id="msg"></div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<!-- 模态框（Modal） -->
<!--修改博主头像-->
<div class="modal fade" id="updateImage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" >
                    修改博主头像
                </h4>
            </div>
            <div class="modal-body">
                <img alt="140x140" src="${user.imageUrl}" height="140px" width="140px" class="img-circle"/>
                <form method="post" action=" " enctype="multipart/form-data">
                    <input type="file" name="file">
                    <input type="submit" value="上传">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
            </div>
        </div>
    </div>
</div>
<!--修改个人信息-->
<div class="modal fade" id="updateUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <form action="${path}/user/update" method="post">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    修改博主信息
                </h4>
            </div>
            <div class="modal-body">
                <table class="table" style="text-align: center;margin-top: 20px">
                    <tr>
                        <td style="text-align: right">
                            <span style="font-size: 18px;">博主姓名 ：</span>
                        </td>
                        <td style="text-align: left">
                            <input style="width:180px;font-size: 18px" type="text" class="form-control" name="userName" value="${user.userName}">
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right">
                            <span style="font-size: 18px;">博主邮箱 ：</span>
                        </td>
                        <td style="text-align: left">
                            <input style="width:180px;font-size: 18px" type="text" class="form-control" name="email" value="${user.email}">
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right">
                            <span style="font-size: 18px;">现居城市 ：</span>
                        </td>
                        <td style="text-align: left">
                            <input style="width:180px;font-size: 18px" type="text" class="form-control" name="presentAddress" value="${user.presentAddress}">
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right">
                            <span style="font-size: 18px;">教育程度 ：</span>
                        </td>
                        <td style="text-align: left">
                            <input style="width:180px;font-size: 18px" type="text" class="form-control" name="diploma" value="${user.diploma}">
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right">
                            <span style="font-size: 18px;">个人标签 ：</span>
                        </td>
                        <td style="text-align: left">
                            <input style="width:180px;font-size: 18px" type="text" class="form-control" name="labels" value="${user.labels}">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="submit" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div>
    </div>
    </form>
</div>

<!--修改博主密码-->
<div class="modal fade" id="updatePwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <form action="${path}/user/updatePwd" method="post" name="pwdForm">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">
                        修改博主密码
                    </h4>
                </div>
                <div class="modal-body">
                    <table class="table" style="text-align: center;margin-top: 20px">
                        <tr>
                            <td style="text-align: right">
                                <span style="font-size: 18px;">用户名 ：</span>
                            </td>
                            <td style="text-align: left">
                                <input style="width:180px;font-size: 18px" type="text" class="form-control" name="userName">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: right">
                                <span style="font-size: 18px;">原密码 ：</span>
                            </td>
                            <td style="text-align: left">
                                <input style="width:180px;font-size: 18px" type="password" class="form-control" name="password">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: right">
                                <span style="font-size: 18px;">修改密码 ：</span>
                            </td>
                            <td style="text-align: left">
                                <input style="width:180px;font-size: 18px" type="password" class="form-control" name="rePwd" id="firstPwd">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: right">
                                <span style="font-size: 18px;">确认密码 ：</span>
                            </td>
                            <td style="text-align: left">
                                <input style="width:180px;font-size: 18px" type="password" class="form-control" id="confirm">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center" colspan="2">
                                <span style="font-size: 18px;" id="text"></span>
                                <input type="reset" style="display:none;" />
                            </td>

                        </tr>
                    </table>
                </div>
                <script type="text/javascript">
                    $("#confirm").blur(function check() {
                        var firstPwd = $("#firstPwd").val();
                        var confirm = $("#confirm").val();
                        if(firstPwd != confirm){
                            $("#text").html("<p style='color: red'>两次密码不一致，请重新输入！</p>");
                            $("input[type=reset]").trigger("click");
                            return false;
                        }
                    });

                </script>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" class="btn btn-primary">
                        提交更改
                    </button>
                </div>
            </div>
        </div>
    </form>

</div>
<script type="text/javascript">
    $(function () {
        if("${flag}" == 1){
            $("#msg").html("<p style='color: red;size:18px'>${msg}</p>").hide(5000);
        }
    })
</script>
</body>
</html>
