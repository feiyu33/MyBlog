<!--上一页-->

//获取当前页面的项目路径
var strPath = window.document.location.pathname;
//获取当前页面所在项目的项目名
var postPath =strPath.substring(0,strPath.substr(1).indexOf('/')+1);
$(function () {
    var totalPage = parseInt($("#totalPage").val());
    if(totalPage <= 1){
        $("#page").hide();
    }
})
function prePage(){
    var currentPage = parseInt($("#currentPage").val());
    var flag = $("#flag").val();
    if (currentPage <= 1){
        alert("当前已是第一页！");
        return false;
    }else{
        $.ajax({
            url:postPath+"/blog/turnPage",
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
    var totalPage = parseInt($("#totalPage").val());
    var flag = $("#flag").val();
    if (currentPage >= totalPage){
        alert("当前已是最后一页！");
        return false;
    }else{
        $.ajax({
            url:postPath+"/blog/turnPage",
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
                url:postPath+"/blog/turnPage",
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
function turnByPage() {
    var flag = $("#flag").val();
    var currentPage = parseInt($("#currentPage").val());
    var totalPage = parseInt($("#totalPage").val());
    var pages = parseInt($("#pages").val());
    if (currentPage > totalPage){
        alert("输入页码大于总页数");
        $("#currentPage").val(pages);
        return false;
    }
    var req = /^[0-9]*$/;
    if (!req.test(currentPage)){
        alert("请输入正确的页码值");
        return false;
    }else{
        $.ajax({
            url:postPath+"/blog/turnPage",
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
                $("#currentPage").val(datas.blogPOs.currentPage);
            },
            error:function () {
                alert("请求错误，请重试！");
            }

        })
    }
}