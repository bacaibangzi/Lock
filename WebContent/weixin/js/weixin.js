/*
* 注意：
* 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
* 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
* 3. 完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
*
* 如有问题请通过以下渠道反馈：
* 邮箱地址：weixin-open@qq.com
* 邮件主题：【微信JS-SDK反馈】具体问题
* 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
*/
var share_sdk_config = {};
var _share=(function(e){
	var _self = this;
	var _get_ajax = function(url){
		var script = document.createElement('script');
		script.src = url;
		script.type = "text/javascript";
		document.getElementsByTagName('script')[0].appendChild(script);
		if (!+[1,]) {
				script.onreadystatechange = function() {
					if (this.readyState == 'loaded' || this.readyState == 'complete') {
							
					}
				}
			} else {
				script.onload = function() {
					
				}
			}
	};
	/**
	 * 页面加载执行
	 * @param pid
	 * @param bid
	 * @param shareLink
	 * @param shareTitle
	 * @param shareContent
	 * @param shareImg
	 * @param shareType
	 * @param shareDataUrl
	 */
	var _shareEvent = function(args){
		share_sdk_config.shareLink = args.optVal.shareLink;
		share_sdk_config.shareTitle = args.optVal.shareTitle;
		share_sdk_config.shareContent = args.optVal.shareContent;
		share_sdk_config.shareImg = args.optVal.shareImg;
		share_sdk_config.shareType = args.optVal.shareType;
		share_sdk_config.shareDataUrl = args.optVal.shareDataUrl;
		share_sdk_config.mUrl = args.mUrl;
		share_sdk_config.t_callback_func=args.optVal.t_callback_func;
		share_sdk_config.f_callback_func=args.optVal.f_callback_func;
		_get_ajax(args.mUrl+"/weixinjs/getsignpackage?pid="+args.pid+"&bid="+args.bid);
	};
	return {	
		push:function(fn,args){
			if(args.is_share_on=="off"){
				return false;
			}
			eval(fn).call(this,args);	
		}
	}	
})();
/**
_share.push("_shareEvent",{
		"is_share_on":"on", //开关
		"pid":"622",
		"bid":"820",
		"mUrl":"",
		"optVal":
			{
			"shareLink": "",
			"shareTitle": "",
			"shareContent": "",
			"shareImg":"",
			"shareType":"",     //分享好友
			"shareDataUrl":"" //分享好友
			}
});
*/
function _fnSucc(args){
	share_sdk_config.appId = args.appId;
    // alert(share_sdk_config.appId);
  
	//处理分享链接
	if( share_sdk_config.appId ){
		var url_arr = parseURL(share_sdk_config.shareLink);
		share_sdk_config.shareLink = _http_build_share_url(url_arr);
	}
	console.log(share_sdk_config);
	share_sdk_config.timestamp = args.timestamp;
	share_sdk_config.nonceStr = args.nonceStr;
	share_sdk_config.signature = args.signature;
	if( share_sdk_config.appId  && args.jsapi_ticket){
		wxShareStart();
	}
}

function _http_build_share_url(myUrl){
	var urlParams;
	var match,
        pl     = /\+/g,  // Regex for replacing addition symbol with a space
        search = /([^&=]+)=?([^&]*)/g,
        decode = function (s) { return decodeURIComponent(s.replace(pl, " ")); },
        //query  = window.location.search.substring(1);
    urlParams = {};
    while (match = search.exec(myUrl.query))
       urlParams[decode(match[1])] = decode(match[2]);
	
	var host_arr = myUrl.host.split('.');
	host_arr = host_arr.splice(1);
	var host_arr_len = host_arr.length;
	var host_domain = host_arr[host_arr_len-2]+'.'+host_arr[host_arr_len-1];
	host_arr.pop();
	host_arr.pop();
	//host_arr.remove(host_arr_len-2);
	//host_arr.remove(host_arr_len-1);
	var prefix_domain = host_arr.join(""); 
    var url = myUrl.protocol+"://"+share_sdk_config.appId+ (prefix_domain && '.'+prefix_domain) +'.'+host_domain+myUrl.path;
	// var url = myUrl.protocol+"://"+share_sdk_config.appId+'.'+prefix_domain+'.'+host_domain+myUrl.path;
	var arr=[],i=0;
	for(var key in urlParams){
		arr[i]= key+"="+encodeURIComponent(urlParams[key]);
		i++;
	}
	if(i > 0){
		var queryString = arr.join("&");
		//console.log(queryString);
		url +="?"+queryString
	}
	return url;
}

function wxShareStart(){
	
	wx.config({
		//debug: true,
		appId: share_sdk_config.appId,
		timestamp: share_sdk_config.timestamp,
		nonceStr: share_sdk_config.nonceStr,
		signature: share_sdk_config.signature,
		jsApiList: ['onMenuShareTimeline','onMenuShareAppMessage']// 所有要调用的 API 都要加到这个列表中
	});
	
	wx.ready(function () {
		funcMenuShareTimeline();
		funcMenuShareAppMessage();
	});
}

function funcMenuShareTimeline(){
		//分享到朋友圈
		wx.onMenuShareTimeline({
			title:share_sdk_config.shareTitle, // 分享标题
			link: share_sdk_config.shareLink, // 分享链接
			imgUrl:share_sdk_config.shareImg, // 分享图标
			success: function (share_sdk_config) { 
				// 用户确认分享后执行的回调函数
				//alert("success1");share_sdk_config.t_callback_func=args.optVal.t_callback_func;
				//share_sdk_config.f_callback_func=args.optVal.f_callback_func;

				if( share_sdk_config.t_callback_func != "" ){
					var fn  = share_sdk_config.t_callback_func;
					eval(fn).call(this);
				}
			},
			cancel: function () { 
				// 用户取消分享后执行的回调函数
				//alert('cancel1');

			}
		});
}
function funcMenuShareAppMessage(){
	wx.onMenuShareAppMessage({
			title:share_sdk_config.shareTitle, // 分享标题
			desc: share_sdk_config.shareContent, // 分享描述
			link: share_sdk_config.shareLink, // 分享链接
			imgUrl: share_sdk_config.shareImg, // 分享图标
			type: share_sdk_config.shareType, // 分享类型,music、video或link，不填默认为link
			dataUrl: share_sdk_config.shareDataUrl, // 如果type是music或video，则要提供数据链接，默认为空
			success: function (share_sdk_config) { 
				// 用户确认分享后执行的回调函数
				// alert("success2");
                // alert(share_sdk_config.f_callback_func);
				if( share_sdk_config.f_callback_func != "" ){
					var fn  = share_sdk_config.f_callback_func;
					eval(fn).call(this);
				}
			},
			cancel: function () { 
				// 用户取消分享后执行的回调函数
				//alert('cancel2');
			}
		});
}

