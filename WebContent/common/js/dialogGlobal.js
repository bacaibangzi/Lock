$.fn.runCode = function() {
    var getText = function(elems) {
        var ret = "", elem;

        for (var i = 0; elems[i]; i++) {
            elem = elems[i];
            if (elem.getAttribute("href") && elem.getAttribute("rel") && elem.getAttribute("title")) {
                var title = elem.getAttribute("title"); //title
                var href = elem.getAttribute("href"); //iframe地址
                var rel = elem.getAttribute("rel"); //存放参数 rel="gb_page_center[800, 300]"
                if (rel.indexOf("gb_") == 0) {
                    var _17 = rel.match(/\w+/)[0];
                    var _18 = rel.match(/\[(.*)\]/)[1];
                    if (_17 == "gb_page_center") {
                        var sp = _18.split(/, ?/);
                        ret += "art.dialog.open('" + href + "', {title: '" + title + "',lock: true, width: " + sp[0] + ", height: " + sp[1] + "});";
                    }
                }

            }
        };
        return ret;
    };

    var code = getText(this);
    new Function(code).call(window);

    return this;
};

//模仿greybox遍历页面中相应按钮添加点击事件
$(function() {
    $(document).bind('click', function(event) {
        var target = event.target,
			$target = $(target);

        if ($target.hasClass('btncss alert')) {
            $('#' + target.id).runCode();
            //art.dialog.open('default.htm', { title: '车队新增', width: 800, height: 300,lock:true });
            return false;
        };
    });
});

///弹出，关闭时刷新父页面
function GB_showCenterArt(title, url, height, width) {
    art.dialog.open(url, { title: title, lock: true, width: width, height: height,
        closeFn: function() {
            this.hide();
            top.location.reload();
            return false;
        }
    });
    return false;
}

function GB_showCenter(title, url, height, width) {
    art.dialog.open(url, {id:'KDF', title: title, lock: true, width: width, height: height
    });
    return false;
}

function GB_showCenterForTracking(title, url, height, width) {
    art.dialog.open(url, {
        id: 'KDF',
        title: title,
        lock: true,
        width: width,
        height: height,
        closeFn: function() {
            this.hide();
            return false;
        }
    });
    return false;
}

///数据共享
function GB_showCenterData(title, url, height, width, data) {
    art.dialog.data("text", data[0]);
    art.dialog.data("url", data[1]);
    art.dialog.open(url, { title: title, lock: true, width: width, height: height,drag: false,resize: false
    });
    return false;
}

//弹出，关闭时执行回调函数
//调用方式：
// function aaaaaa() {alert("回调了");}
//<a href="wap.htm" onclick='return GB_showCenterCallBack("终端激活", this.href, 380, 750, aaaaaa);'>click</a>
function GB_showCenterCallBack(title, url, height, width, fn) {
    try {
        art.dialog.open(url, { title: title, lock: true, width: width, height: height,
            closeFn: function() {
                this.hide();
                fn();
            }
        });
        //return false;
    } catch (err) {
        alert(err);
        //return false;
    }    
}

function GB_hide() {
    art.dialog.close();
}

var cc;
function artAlert(content) {
    if (typeof(content)) cc = "修改成功！";
    else cc = content;
    //cc = typeof (content) ? cc : content;
    if (document.readyState == "complete")
        art.dialog({ content: cc }).time(2);
    else {
        setTimeout(artAlert, 100);
    }
}

$(function() {
    var $skin = $('#nav-skin');
    $skin[0] && $skin.bind('click', function() {
        _demoSkin();
        return false;
    });
});

//弹出成功提示，关闭刷新页面
function alertArtQuery(content){
    art.dialog({content:content,
    closeFn:function(){
        this.hide();
        top.location.reload();
        },
    time:'4'
    }
    );
}
//弹出成功提示，关闭，不刷新
function alertArt(content)
{
    art.dialog({
        content:content,
        closeFn:function(){
            GB_hide();
        },
        time:'4'
    });
}
