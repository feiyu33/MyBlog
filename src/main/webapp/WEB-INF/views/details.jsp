<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/6
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>博文详情</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/static/iconfont/iconfont.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/static/css/animate.css" type="text/css"/>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
    <script src="${path}/static/js/timeUtilJs.js"></script>
    <script src="http://malsup.github.io/min/jquery.form.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var options = {
                dataType: 'json',
                data: $("#comment_id").serialize(),
                success: function (data) {
                    var temp = "";
                    for (var i = 0; i < data.commentses.length; i++) {
                        temp += "<span style='color:black;width: 40px'>" + (i + 1) + "楼</span>"
                                + "&nbsp;&nbsp;&nbsp;&nbsp;"
                                + "<span class='glyphicon glyphicon-user' style='color: gray ;width:150px' aria-hidden='true'>&nbsp;" + data.commentses[i].userName + "</span>"
                                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                + "<span class='glyphicon glyphicon-envelope' style='color: gray;width:300px' aria-hidden='true'>&nbsp;" + data.commentses[i].email + "</span>"
                                + "<div style='font-size:16px;padding: 20px 50px 10px 45px;'>" + data.commentses[i].comments + "</div>"
                                + "<div style='color:gray;float: right'>"
                                + "<i>评论于 " + getTime(data.commentses[i].commentTime) + "</i></div> <hr>"

                    }
                    var commentCounts = $("#commentCounts").html();
                    $("#commentCounts").html(parseInt(commentCounts)+1);
                    $("#commentCounts1").html(parseInt(commentCounts)+1);
                    $("#comments").empty();
                    $("#comments").append(temp);
                    $("#comment_id")[0].reset();
                }
            };
            $("#comment_id").ajaxForm(options);

            $("#thumbUp").click(function () {

            })
        });


    </script>
</head>
<body>
<%@include file="navigationBar.jsp" %>
<div class="container table_box" style="margin-top: 30px">
    <!-- <h2 >40</h2> -->
    <h2 style="text-align:left;"><b> ${blogPO.blog.title}</b></h2>
    <div style="text-align: right;font-size: 16px;padding-top: 10px">
        <div style="float: left">
            标签：
            <a href="#" class="label label-success" style="font-size: 16px">${blogPO.blog.classification}</a>
        </div>
        <br>
        <label style="font-size: 15px;text-align: left"><span class="glyphicon glyphicon-eye-open" style="color: gray"
                                                              aria-hidden="true"></span> <a
                style="text-decoration:none;">阅读(${blogPO.blog.readCounts})</a></label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label style="font-size: 15px;text-align: left"><span class="glyphicon glyphicon-edit" style="color: gray"
                                                              aria-hidden="true"></span> <a
                style="text-decoration:none;">评论(<span id="commentCounts">${blogPO.commentCounts}</span>)</a></label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label style="font-size: 15px;text-align: left"><span class="glyphicon glyphicon-thumbs-up" style="color: gray"
                                                              aria-hidden="true"></span> 推荐(<span
                id="thumbUp">${blogPO.blog.thumbUpNumber}</span>)</label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label style="font-size: 15px">发布于 ${fns:formatDate(blogPO.blog.releaseTime, 'yyyy-MM-dd HH:mm:ss')}</label>
    </div>
    <hr>
    <div style="padding-top: 4px;padding-left: 10px;padding-right: 10px;text-align: center">
        ${blogPO.blog.content}
    </div>

    <hr style="border: 1px solid silver;"/>
    <div class="opera" style="float: right">
    <span id="btn">
        <a class="btn btn-success btn-sm">
          <span class="glyphicon glyphicon-thumbs-up"></span> 点赞
        </a>
    </span>
    </div>
    <!-- 分享 -->
    <div class="jiathis_style">
        <span class="jiathis_txt">分享到：</span>
        <a class="jiathis_button_cqq">QQ好友</a>
        <a class="jiathis_button_qzone">QQ空间</a>
        <a class="jiathis_button_weixin">微信</a>
        <a class="jiathis_button_tsina">新浪微博</a>
    </div>
    <script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
    <br>
    <h3 style="padding-top: 10px">评论列表&nbsp;&nbsp;&nbsp;&nbsp;<span id="commentCounts1">${blogPO.commentCounts}</span>条</h3>

    <div style="padding-top: 10px;padding-left: 10px;padding-right: 10px" id="comments">
        <c:forEach items="${blogPO.comments}" var="b" varStatus="vb">
            <span style="color:black;width: 40px">${vb.index+1}楼</span>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span class="glyphicon glyphicon-user" style="color: gray ;width:150px"
                  aria-hidden="true">&nbsp;${b.userName}</span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span class="glyphicon glyphicon-envelope" style="color: gray;width:300px"
                  aria-hidden="true">&nbsp;${b.email}</span>
            <div style="font-size:16px;padding: 20px 50px 10px 45px;">${b.comments}</div>
            <div style="color:gray;float: right">
                <i>评论于 ${fns:formatDate(b.commentTime, 'yyyy-MM-dd HH:mm:ss')}</i>
            </div>
            <hr>
        </c:forEach>
    </div>
    <form id="comment_id" action="${path}/show/comment" method="post">
        <input value="${blogPO.blog.id}" type="hidden" name="blogId" id="blogId">
        <c:if test="${blogPO.blog.isComments == 0}">

            <fieldset>
                <legend>评论</legend>
                <div class="form-inline">
                    <div class="form-group col-lg-offset-1">
                        <label style="font-size: 15px;width: 60px;">* 姓 名：</label>
                        <input style="width:200px;font-size: 15px" type="text" minlength="4" maxlength="30"
                               class="form-control" name="userName" required>
                    </div>
                </div>
                <div class="form-inline">
                    <div class="form-group  col-lg-offset-1">
                        <label style="font-size: 15px;width: 60px;padding-top: 20px">* 邮 箱：</label>
                        <input style="width:200px;font-size: 15px" type="email" class="form-control" name="email"
                               required>
                    </div>
                </div>
                <div class="form-inline" style="padding-top: 20px">
                    <div class="form-group  col-lg-offset-1">
                        <label style="font-size: 15px;width: 60px">* 内 容：</label>
                        <textarea name="comments" style="width: 500px" class="form-control" rows="4"></textarea>
                    </div>
                </div>

                <div class="col-lg-offset-1" style="padding-top: 20px;padding-left: 60px;padding-bottom: 15px">
                    <button type="submit" style="width: 200px;text-align: center" class="btn btn-info"
                            id="commentButton">评论
                    </button>
                </div>
            </fieldset>

        </c:if>
    </form>
</div>
<script type="text/javascript">
    (function ($) {
        $.extend({
            tipsBox: function (options) {
                options = $.extend({
                    obj: null, //jq对象，要在那个html标签上显示
                    str: "+1", //字符串，要显示的内容;也可以传一段html，如: "<b style='font-family:Microsoft YaHei;'>+1</b>"
                    startSize: "12px", //动画开始的文字大小
                    endSize: "30px",  //动画结束的文字大小
                    interval: 600, //动画时间间隔
                    color: "red",  //文字颜色
                    callback: function () {
                    }  //回调函数
                }, options);
                $("body").append("<span class='num'>" + options.str + "</span>");
                var box = $(".num");
                var left = options.obj.offset().left + options.obj.width() / 2;
                var top = options.obj.offset().top - options.obj.height();
                box.css({
                    "position": "absolute",
                    "left": left + "px",
                    "top": top + "px",
                    "z-index": 9999,
                    "font-size": options.startSize,
                    "line-height": options.endSize,
                    "color": options.color
                });
                box.animate({
                    "font-size": options.endSize,
                    "opacity": "0",
                    "top": top - parseInt(options.endSize) + "px"
                }, options.interval, function () {
                    box.remove();
                    options.callback();
                });
            }
        });
    })(jQuery);
    function niceIn(prop) {
        prop.find('i').addClass('niceIn');
        setTimeout(function () {
            prop.find('i').removeClass('niceIn');
        }, 1000);
    }
    $(function () {
        //获取当前页面的项目路径
        var strPath = window.document.location.pathname;
        //获取当前页面所在项目的项目名
        var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
        var bid = $("#blogId").val();
        $("#btn").click(function () {
            $.ajax({
                url: postPath + '/show/thumbUp',
                type: 'get',
                dataType: 'json',
                data: {
                    'bid': bid
                },
                success: function (data) {
                    $("#thumbUp").html(data.thumbUpNumber);
                }
            });
            $.tipsBox({
                obj: $(this),
                str: "+1",
                callback: function () {
                }
            });
            niceIn($(this));
        });
    });
</script>
</body>
</html>
