//获取当前页面的项目路径
var strPath = window.document.location.pathname;
//获取当前页面所在项目的项目名
var postPath =strPath.substring(0,strPath.substr(1).indexOf('/')+1);
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
                $("#keyword").val("");
                $("#currentPage").val(datas.blogPOs.currentPage);
            },
            error:function () {
                alert("请求错误，请重试！");
            }

        })
    })
})

//搜索
function searchKey() {
    var keyword = $("#keyword").val();
    $.ajax({
        url: postPath+'/blog/byKeyword',
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
            $("#page").hide();
        }
    });
}