//将时间戳转化为标准时间显示
function getTime(obj){
    var date = new Date(obj);
    var str;
    var year = date.getFullYear();
    var month = parseInt(date.getMonth()) + 1;
    if(month <= 9)
        month = '0'+month;
    var day = date.getDate() < 9 ? '0'+date.getDate() : date.getDate();
    var hours = date.getHours() < 9 ? '0'+date.getHours() : date.getHours();
    var minutes = date.getMinutes() < 9 ? '0'+date.getMinutes() : date.getMinutes();
    var seconds = date.getSeconds() < 9 ? '0'+date.getSeconds() : date.getSeconds();
    str = year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
    return str;
}