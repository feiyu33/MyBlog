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

    <script src="${path}/static/js/timeUtilJs.js"></script>
    <script type="text/javascript">
        <!--上一页-->
        function prePage(){
            var currentPage = parseInt($("#currentPage").val());
            var flag = $("#flag").val();
            if (currentPage <= 1){
                alert("当前已是第一页！");
            }else{
                $.ajax({
                    url:"${path}/blog/turnPage",
                    data:{
                        "currentPage":currentPage-1,
                        "flag":flag
                    },
                    dataType:'json',
                    success:function (datas) {
                        $("#blog").empty();
                        var temp = "";
                        for (var i = 0; i < datas.blogPOs.data.length;i++){
                            temp +="<li>"
                                    +"<a href='${path}/blog/showDetails?bid="+datas.blogPOs.data[i].blog.id+"&currentPage=1' style='font-family: italic;font-size: 18px;color:#1e90ff'>"+datas.blogPOs.data[i].blog.title+"</a><br/>"
                                    +"<span>阅读("+datas.blogPOs.data[i].blog.readCounts+")&nbsp;&nbsp;·评论("+datas.blogPOs.data[i].commentCounts+")&nbsp;&nbsp;·推荐("+datas.blogPOs.data[i].blog.thumbUpNumber+")&nbsp;&nbsp;·(<a href='${path}/blog/toEditor?bid="+datas.blogPOs.data[i].blog.id+"'>编辑</a>|<a href='${path}/blog/delete?bid="+datas.blogPOs.data[i].blog.id+"' onclick='return confirm('确定要删除吗？')'>删除</a>)</span>"
                                    +"<p>"+getTime(datas.blogPOs.data[i].blog.releaseTime)+" 发布</p>"
                                    +"</li>"
                        }
                        $("#currentPage").val(datas.blogPOs.currentPage);
                        $("#blog").append(temp);
                    },
                    error:function () {
                        alert("请求错误，请重试！");
                    }
                })
            }
        }

        <!--下一页-->
        function nextPage() {
            var currentPage = parseInt($("#currentPage").val());
            var flag = $("#flag").val();
            if (currentPage >= ${blogPageWrap.totalPages}){
                alert("当前已是最后一页！");
            }else{
                $.ajax({
                    url:"${path}/blog/turnPage",
                    data:{
                        "currentPage":currentPage+1,
                        "flag":flag
                    },
                    dataType:'json',
                    success:function (datas) {
                        $("#blog").empty();
                        var temp = "";
                        for (var i = 0; i < datas.blogPOs.data.length;i++){
                            temp +="<li>"
                                    +"<a href='${path}/blog/showDetails?bid="+datas.blogPOs.data[i].blog.id
                                    +"&currentPage=1' style='font-family: italic;font-size: 18px;color:#1e90ff'>"+datas.blogPOs.data[i].blog.title+"</a><br/>"
                                    +"<span>阅读("+datas.blogPOs.data[i].blog.readCounts+")&nbsp;&nbsp;·评论("+datas.blogPOs.data[i].commentCounts
                                    +")&nbsp;&nbsp;·推荐("+datas.blogPOs.data[i].blog.thumbUpNumber+")&nbsp;&nbsp;·(<a href='${path}/blog/toEditor?bid="
                                    +datas.blogPOs.data[i].blog.id+"'>编辑</a>|<a href='${path}/blog/delete?bid="+datas.blogPOs.data[i].blog.id
                                    +"' onclick='return confirm('确定要删除吗？')'>删除</a>)</span>"
                                    +"<p>"+getTime(datas.blogPOs.data[i].blog.releaseTime)+" 发布</p>"
                                    +"</li>"
                        }
                        $("#blog").append(temp);
                        $("#currentPage").val(datas.blogPOs.currentPage);
                    },
                    error:function () {
                        alert("请求错误，请重试！");
                    }

                })
            }
        }

        <!--根据页码翻页-->
        $(function () {
            $("#page li a").click(function () {
                var flag = $("#flag").val();
                var page = this.innerHTML;
                var req = /^[0-9]*$/;
                if (!req.test(page)){
                    return;
                }else{
                    $.ajax({
                        url:"${path}/blog/turnPage",
                        data:{
                            "currentPage":page,
                            "flag":flag
                        },
                        dataType:'json',
                        success:function (datas) {
                            $("#blog").empty();
                            var temp = "";
                            for (var i = 0; i < datas.blogPOs.data.length;i++){
                                temp +="<li>"
                                        +"<a href='${path}/blog/showDetails?bid="+datas.blogPOs.data[i].blog.id
                                        +"&currentPage=1' style='font-family: italic;font-size: 18px;color:#1e90ff'>"+datas.blogPOs.data[i].blog.title+"</a><br/>"
                                        +"<span>阅读("+datas.blogPOs.data[i].blog.readCounts+")&nbsp;&nbsp;·评论("+datas.blogPOs.data[i].commentCounts
                                        +")&nbsp;&nbsp;·推荐("+datas.blogPOs.data[i].blog.thumbUpNumber+")&nbsp;&nbsp;·(<a href='${path}/blog/toEditor?bid="
                                        +datas.blogPOs.data[i].blog.id+"'>编辑</a>|<a href='${path}/blog/delete?bid="+datas.blogPOs.data[i].blog.id
                                        +"' onclick='return confirm('确定要删除吗？')'>删除</a>)</span>"
                                        +"<p>"+getTime(datas.blogPOs.data[i].blog.releaseTime)+" 发布</p>"
                                        +"</li>"
                            }
                            $("#blog").append(temp);
                            $("#currentPage").val(datas.blogPOs.currentPage);
                        },
                        error:function () {
                            alert("请求错误，请重试！");
                        }

                    })
                }
            })
        })


        <!--切换tab-->
        $(function(){
            $("#active li").click(function () {
                var currentPage = parseInt($("#currentPage").val());
                var is_active = $(this).hasClass('active');
                var flag = this.id;
                $("#flag").val(flag);
                if(is_active){
                    return;
                }else{
                    $(this).siblings('li').removeClass('active');  // 删除其他兄弟元素的样式
                    $(this).addClass('active'); // 添加当前元素的样式
                }

                $.ajax({
                    url:"${path}/blog/turnPage",
                    data:{
                        "currentPage":currentPage,
                        "flag":flag
                    },
                    dataType:'json',
                    success:function (datas) {
                        $("#blog").empty();
                        var temp = "";
                        for (var i = 0; i < datas.blogPOs.data.length;i++){
                            temp +="<li>"
                                    +"<a href='${path}/blog/showDetails?bid="+datas.blogPOs.data[i].blog.id
                                    +"&currentPage=1' style='font-family: italic;font-size: 18px;color:#1e90ff'>"+datas.blogPOs.data[i].blog.title+"</a><br/>"
                                    +"<span>阅读("+datas.blogPOs.data[i].blog.readCounts+")&nbsp;&nbsp;·评论("+datas.blogPOs.data[i].commentCounts
                                    +")&nbsp;&nbsp;·推荐("+datas.blogPOs.data[i].blog.thumbUpNumber+")&nbsp;&nbsp;·(<a href='${path}/blog/toEditor?bid="
                                    +datas.blogPOs.data[i].blog.id+"'>编辑</a>|<a href='${path}/blog/delete?bid="+datas.blogPOs.data[i].blog.id
                                    +"' onclick='return confirm('确定要删除吗？')'>删除</a>)</span>"
                                    +"<p>"+getTime(datas.blogPOs.data[i].blog.releaseTime)+" 发布</p>"
                                    +"</li>"
                        }
                        $("#blog").append(temp);
                        $("#keyword").val("");
                        $("#currentPage").val(datas.blogPOs.currentPage);
                    },
                    error:function () {
                        alert("请求错误，请重试！");
                    }

                })
            })
        })

        <!--搜索-->
        function searchKey() {
            var keyword = $("#keyword").val();
            $.ajax({
                url: '${path}/blog/byKeyword',
                type: 'post',
                dataType:'json',
                data: $("#keyword").serializeArray(),
                data:{
                    "keyword":keyword
                },
                success: function(datas) {
                    $("#blog").empty();
                    var temp = "";
                    for (var i = 0; i < datas.blogPOs.length;i++){
                        temp +="<li>"
                                +"<a href='${path}/blog/showDetails?bid="+datas.blogPOs[i].blog.id
                                +"&currentPage=1' style='font-family: italic;font-size: 18px;color:#1e90ff'>"+datas.blogPOs[i].blog.title+"</a><br/>"
                                +"<span>阅读("+datas.blogPOs[i].blog.readCounts+")&nbsp;&nbsp;·评论("+datas.blogPOs[i].commentCounts
                                +")&nbsp;&nbsp;·推荐("+datas.blogPOs[i].blog.thumbUpNumber+")&nbsp;&nbsp;·(<a href='${path}/blog/toEditor?bid="
                                +datas.blogPOs[i].blog.id+"'>编辑</a>|<a href='${path}/blog/delete?bid="+datas.blogPOs[i].blog.id
                                +"' onclick='return confirm('确定要删除吗？')'>删除</a>)</span>"
                                +"<p>"+getTime(datas.blogPOs[i].blog.releaseTime)+" 发布</p>"
                                +"</li>"
                    }
                    $("#blog").append(temp);
                    $("#active li").removeClass('active');
                    $("#page").hidden;
                }
            });
        }
    </script>
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
                        <a href="${path}/blog/showDetails?bid=${b.blog.id}&currentPage=1" style="font-family: italic;font-size: 18px;color:#1e90ff">${b.blog.title}</a><br/>
                        <span>阅读(${b.blog.readCounts})&nbsp;&nbsp;·评论(${b.commentCounts})&nbsp;&nbsp;·推荐(${b.blog.thumbUpNumber})&nbsp;&nbsp;·(<a href="${path}/blog/toEditor?bid=${b.blog.id}">编辑</a>|<a href="${path}/blog/delete?bid=${b.blog.id}" onclick="return confirm('确定要删除吗？')">删除</a>)</span>
                        <p>${fns:formatDate(b.blog.releaseTime,'yyyy-MM-dd HH:mm:ss' )} 发布</p>
                    </li>
                </c:forEach>
            </ul>
            <c:if test="${blogPageWrap.data.size() > 0}">
                <ul class="pagination" id="page">

                    <input type="hidden" value="${blogPageWrap.currentPage}" id="currentPage"/>
                    <li>
                        <a onclick="prePage()">&laquo;</a>
                    </li>
                    <c:if test="${blogPageWrap.totalPages <= 5}">
                        <c:forEach var="p" begin="1" end="${blogPageWrap.totalPages}">
                            <li>
                                <a>${p}</a>
                            </li>
                        </c:forEach>
                    </c:if>
                    <c:if test="${blogPageWrap.totalPages > 5}">
                        <li>
                            <a>1</a>
                            <a>2</a>
                            <a>...</a>
                            <a>${blogPageWrap.totalPages-1}</a>
                            <a>${blogPageWrap.totalPages}</a>
                        </li>
                    </c:if>
                    <li>
                        <a onclick="nextPage()">&raquo;</a>
                    </li>
                </ul>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
