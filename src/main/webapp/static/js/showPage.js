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
    }else{
        $.ajax({
            url:postPath+"/blog/turnPage",
            data:{
                "currentPage":currentPage-1,
                "flag":flag
            },
            dataType:'json',
            success:function (datas) {
                $("#blogs").empty();
                var temp = "";
                for (var i = 0; i < datas.blogPOs.data.length;i++){
                    temp += "<div class='col-md-12'>"
                         + "<div class='thumbnail'>"
                         + "<div class='caption'>"
                         + "<a style='font-size:25px;text-decoration:none;' href='"+postPath+"/show/showDetails?bid="+datas.blogPOs.data[i].blog.id+"'>"+datas.blogPOs.data[i].blog.title+"</a>"
                         + "<div class='row' style='padding-top: 12px;font-size:12px;height: 160px;overflow: hidden;'>"
                         + "<div class='col-lg-3 col-sm-3'>"
                         + judge(datas.blogPOs.data[i].img)
                         + "</div>"
                         + "<div class='col-lg-9 col-sm-9' style='font-size: 14px'>"
                         + "<div>"+datas.blogPOs.data[i].blog.content+"</div></div> </div> <br>"
                         + "<div style='text-align: right'>"
                         + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                         + "<label style='font-size: 12px;width: 70px;text-align: left'>"
                         + "<span class='glyphicon glyphicon-eye-open' style='color: gray' aria-hidden='true'></span>"
                         + "阅读("+datas.blogPOs.data[i].blog.readCounts+")</label>"
                         + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                         + "<label style='font-size: 12px;width: 70px;text-align: left'>"
                         + "<span class='glyphicon glyphicon-edit' style='color: gray' aria-hidden='true'></span>"
                         + "评论"+datas.blogPOs.data[i].commentCounts+")</label>"
                         + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                         + "<label style='font-size: 12px;width: 70px;text-align: left'>"
                         + "<span class='glyphicon glyphicon-thumbs-up' style='color: gray' aria-hidden='true'>"
                         + "</span>  推荐("+datas.blogPOs.data[i].blog.thumbUpNumber+")</label>"
                         + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                         + "<label style='font-size: 12px;'>"
                         + "发布于 "+getTime(datas.blogPOs.data[i].blog.releaseTime)+"</label></div></div></div></div> "
                }
                $("#currentPage").val(datas.blogPOs.currentPage);
                $("#blogs").append(temp);
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
    }else{
        $.ajax({
            url:postPath+"/blog/turnPage",
            data:{
                "currentPage":currentPage+1,
                "flag":flag
            },
            dataType:'json',
            success:function (datas) {
                $("#blogs").empty();
                var temp = "";
                for (var i = 0; i < datas.blogPOs.data.length;i++){
                    temp += "<div class='col-md-12'>"
                        + "<div class='thumbnail'>"
                        + "<div class='caption'>"
                        + "<a style='font-size:25px;text-decoration:none;' href='"+postPath+"/show/showDetails?bid="+datas.blogPOs.data[i].blog.id+"'>"+datas.blogPOs.data[i].blog.title+"</a>"
                        + "<div class='row' style='padding-top: 12px;font-size:12px;height: 160px;overflow: hidden;'>"
                        + "<div class='col-lg-3 col-sm-3'>"
                        + judge(datas.blogPOs.data[i].img)
                        + "</div>"
                        + "<div class='col-lg-9 col-sm-9' style='font-size: 14px'>"
                        + "<div>"+datas.blogPOs.data[i].blog.content+"</div></div> </div> <br>"
                        + "<div style='text-align: right'>"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + "<label style='font-size: 12px;width: 70px;text-align: left'>"
                        + "<span class='glyphicon glyphicon-eye-open' style='color: gray' aria-hidden='true'></span>"
                        + "阅读("+datas.blogPOs.data[i].blog.readCounts+")</label>"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + "<label style='font-size: 12px;width: 70px;text-align: left'>"
                        + "<span class='glyphicon glyphicon-edit' style='color: gray' aria-hidden='true'></span>"
                        + "评论"+datas.blogPOs.data[i].commentCounts+")</label>"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + "<label style='font-size: 12px;width: 70px;text-align: left'>"
                        + "<span class='glyphicon glyphicon-thumbs-up' style='color: gray' aria-hidden='true'>"
                        + "</span>  推荐("+datas.blogPOs.data[i].blog.thumbUpNumber+")</label>"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + "<label style='font-size: 12px;'>"
                        + "发布于 "+getTime(datas.blogPOs.data[i].blog.releaseTime)+"</label></div></div></div></div> "
                }
                $("#blogs").append(temp);
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
                    $("#blogs").empty();
                    var temp = "";
                    for (var i = 0; i < datas.blogPOs.data.length;i++){
                        temp += "<div class='col-md-12'>"
                            + "<div class='thumbnail'>"
                            + "<div class='caption'>"
                            + "<a style='font-size:25px;text-decoration:none;' href='"+postPath+"/show/showDetails?bid="+datas.blogPOs.data[i].blog.id+"'>"+datas.blogPOs.data[i].blog.title+"</a>"
                            + "<div class='row' style='padding-top: 12px;font-size:12px;height: 160px;overflow: hidden;'>"
                            + "<div class='col-lg-3 col-sm-3'>"
                            + judge(datas.blogPOs.data[i].img)
                            + "</div>"
                            + "<div class='col-lg-9 col-sm-9' style='font-size: 14px'>"
                            + "<div>"+datas.blogPOs.data[i].blog.content+"</div></div> </div> <br>"
                            + "<div style='text-align: right'>"
                            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                            + "<label style='font-size: 12px;width: 70px;text-align: left'>"
                            + "<span class='glyphicon glyphicon-eye-open' style='color: gray' aria-hidden='true'></span>"
                            + "阅读("+datas.blogPOs.data[i].blog.readCounts+")</label>"
                            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                            + "<label style='font-size: 12px;width: 70px;text-align: left'>"
                            + "<span class='glyphicon glyphicon-edit' style='color: gray' aria-hidden='true'></span>"
                            + "评论("+datas.blogPOs.data[i].commentCounts+")</label>"
                            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                            + "<label style='font-size: 12px;width: 70px;text-align: left'>"
                            + "<span class='glyphicon glyphicon-thumbs-up' style='color: gray' aria-hidden='true'>"
                            + "</span>  推荐("+datas.blogPOs.data[i].blog.thumbUpNumber+")</label>"
                            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                            + "<label style='font-size: 12px;'>"
                            + "发布于 "+getTime(datas.blogPOs.data[i].blog.releaseTime)+"</label></div></div></div></div> "
                    }
                    $("#blogs").append(temp);
                    $("#currentPage").val(datas.blogPOs.currentPage);
                },
                error:function () {
                    alert("请求错误，请重试！");
                }

            })
        }
    })
})

function judge(imgurl) {
    if(imgurl != null && imgurl != "[]"){
        var img = "<div style='text-align: center;'><img alt='图片加载失败' src="+imgurl+" width='140' height='100'/></div>"
        return img;
    }else {
        return "";
    }
}