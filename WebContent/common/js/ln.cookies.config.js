
/*
*设置与获取Cookie
*/
var Cookie = {}
//写入Cookie，key为键，value是值
//duration过期时间（天为单位，默认1天）
Cookie.write = function (key, value, duration)
{
    Cookie.remove(key);
    var d = new Date();
    if (duration <= 0)
        duration = 1;
    d.setTime(d.getTime() + 1000 * 60 * 60 * 24 * duration);
    document.cookie = key + "=" + encodeURI(value) + "; expires=" + d.toGMTString() + ";path=/";
};
//移除Cookie,key为键
Cookie.remove = function (key)
{
    var d = new Date();
    if (Cookie.read(key) != "")
    {
        d.setTime(d.getTime() - (86400 * 1000 * 1));
        document.cookie = key + "=;expires=" + d.toGMTString();
    }
};
//读取Cookie，key是键
//不存在返回空字符串""
Cookie.read = function (key)
{
    var arr = document.cookie.match(new RegExp("(^| )" + key + "=([^;]*)(;|$)"));
    if (arr != null)
        return decodeURIComponent(arr[2]);
    return "";
};




