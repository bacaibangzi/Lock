<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>
	智能门锁管理平台
</title></head>
<body>

    <link href='<%=basePath %>common/css/mainpage.css' rel="stylesheet" type="text/css">
    <link href='<%=basePath %>common/css/jquery.yitip.css' rel="stylesheet" type="text/css">
    <script src='<%=basePath %>common/js/jquery-1.7.1.min.js' type="text/javascript"></script>
    <script src='<%=basePath %>common/js/jquery.yitip.js' type="text/javascript"></script>
    <script type="text/javascript" src='<%=basePath %>common/js/artDialog.js?skin=default'></script>
    <script type="text/javascript" src='<%=basePath %>common/js/artDialog.iframeTools.js'></script>
    <script type="text/javascript" src='<%=basePath %>common/js/dialogGlobal.js'></script>
    <script type="text/javascript" src='<%=basePath %>common/js/jquery.cookie.js'></script>

    <!--[if IE 6]>
	<script type="text/javascript" src='/home/js/DD_belatedPNG_0.0.8a.js'></script>
	<script defer="defer" type="text/javascript">
		DD_belatedPNG.fix('#titleLogo');
	</script>
	<![endif]-->

    <script src='<%=basePath %>common/js/master.js' type="text/javascript"></script>

<div>
</div>

    <div class="all">
        <div class="ttlogo">智能门锁管理平台</div>
        <div id="topbar">
            <ul>
                <li><a href="<%=basePath %>toLogin.htm" class="register">返回首页</a></li>
                <li><a href="<%=basePath %>toReg.htm" class="register">账号注册</a></li>
                <li><a href="<%=basePath %>toContact.htm" class="callme">联系我们</a></li>
            </ul>
        </div>
        <div id="main">
            <div id="left-enter">
                <div class="m1">
                </div>
                <div class="parts">
                    <div class="part1">                    
                        <div class="denglu">
                            <label for="account">
                                账号：</label>
                                <div id="error" autocomplete="off" style=" width:1px; height:1px; overflow:hidden; margin-left:80px;">！</div>
                            <input type="text" id="account" name="account" value="请输入登录账号" maxlength="16" onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
                                onblur="if(!value){value=defaultValue;this.style.color='#999'}" style="color: #999" />
                            <label for="password" id="lbPwd" style="margin-top: 12px;">
                                密码：</label>
                            <input type="text" id="showPwd" name="showPwd" value="请输入登录密码" maxlength="16" style="color: #999;
                                float: left" />
                            <input name="password" type="password" id="password" maxlength="16" style="display: none; float: left" />
                        </div>
                        <div class="remember">
                            <input type="checkbox" id="remeber" name="remeber" class="input_align" />
                            <label for="remeber">
                                记住登录信息</label>
                            <a href='<%=basePath %>toPass' title="找回密码">找回密码</a>
                        </div>
                        <input type="button" id="login" class="btnOff" />
                        <div id="loader" style="height: 30px; padding-top: 28px; padding: 28px 0px 0px 14px;
                            display: none;">
                            数据提交中...</div>
                        <strong></strong>
                    </div>
                                        <div class="part2">
                        <p>还没有注册您的开发者账号？</p>
                        <input type="button" id="reg" class="btnOff" />
                        <strong></strong>
                    </div>
                    <div class="part5">
                        <p>客户服务热线</p>
                        <div class="telcenter1">
                        	&nbsp;&nbsp;&nbsp;&nbsp;40066 77880
                        </div>
                        <p>电子邮件</p>
                        <div class="telcenter1">
                        	&nbsp;&nbsp;&nbsp;&nbsp;developer@info.com
                        </div>
                    </div>
                    <div class="part5">
                    </div>
                </div>
            </div>
            <div id="content">
                
    
    
    <div class="detailstitle">
        <div style="font-size: 22px; color: #213a73; margin-left: 10px">
            <span>安装我是老板Android版</span>
        </div>
        <div style="height: 10px; width: 670px; background: url(<%=basePath %>common/images/titleline.gif) repeat-x;
            margin-top: 5px">
        </div>
    </div>
    
    
    <div class="detailscontent">
        <div class="dleft">
            <div class="android">
                <div style="width: 178px; height: 296px; margin-left: 41px; _margin-left: 20px; margin-top: 51px;
                    float: left">
                    <img id="imgAndroid" src="<%=basePath %>common/images/andriod02.png" width="178" height="296">
                </div>
            </div>
        </div>
        <div class="dright">
            <div class="ptitle">
                <div class="timg android">
                </div>
            </div>
            <div class="pversion">
                <ul>
                    <li><span style="font-weight: bold;">最新版本：</span></li>
                    <li><span>我是老板Android版 V1.00 2015年3月30日</span></li>
                    <li><span>适用于Android4.0及以上固件</span></li>
                </ul>
            </div>
            <div class="dmemo">
                <span style="font-weight: bold">点击按钮下载：</span>
            </div>
            <div class="download">
                <input type="button" id="DownLoadAndroid" class="androidbtnOff">
            </div>
            <div class="tutorial">
                 <!-- <a href="javascript:openGuide("/home/AndriodHelp.aspx")">安装教程</a> -->
                 	<a href="#">扫描二维码&nbsp;&nbsp;</a>
                 	<img src="<%=basePath %>common/images/android_ew.png" width="80px" height="80px"/>
            </div>
            <div class="downloadtype">
                <div class="bj_tabs_tab">
                    <ul>
		                <li class="active"><a href="javascript:void(0);">电脑下载</a></li>
		                <li><a href="javascript:void(0);">手机下载</a></li>
	                </ul>
	                <div id="btnClose" class="divclose">
	                    <img src="common/images/closebutton.gif">
	                </div>
                </div>
                <div class="bj_tabs_content">
                    <div class="tabs_content show">
                        <div class="pctitle">下载客户端的apk文件到您的电脑，通过数据线同步到您的安卓手机上安装即可</div>
                        <div class="pcdown"><a href="<%=basePath %>client/DietSystem.apk">下载客户端</a></div>
                    </div>
				    <div class="tabs_content">
				        <div class="mobiletitle">手机短信免费获取下载地址，直接在您的安卓手机上下载安装</div>
				        <div>
				            <input id="txtMobile" type="text" value="请输入您的手机号码" maxlength="11" onfocus="if(value==defaultValue){value=&#39;&#39;;this.style.color=&#39;#000&#39;}" onblur="if(!value){value=defaultValue;this.style.color=&#39;#999&#39;}" style="color: #999">
                            <input id="btnSend" type="button" class="sengurl" value="发送地址" onclick="sendMessage();">
				        </div>
				    </div>
                </div>
            </div>
            <div>
                <div class="updatetitle">
                    <span style="font-weight: bold">更新内容：</span>
                </div>
                <div class="update">
                    <div class="update_t">
                        <div class="tl">
                        </div>
                        <div class="tm">
                        </div>
                        <div class="tr">
                        </div>
                    </div>
                    <div class="update_c">
                        <ul>
                            <li><em></em><span>1. 全新UI界面设计。</span></li>
                            <li><em></em><span>2. 菜品、销售统计分析。</span></li>
                            <li><em></em><span>3. 菜品、销售图形报表。</span></li>
                            <li><em></em><span>4. 会员信息统计。</span></li>
                        </ul>
                    </div>
                    <div class="update_b">
                        <div class="bl">
                        </div>
                        <div class="bm">
                        </div>
                        <div class="br">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        //电脑下载与手机下载切换
        $(".bj_tabs_tab > ul > li").click(function(i) {
	        var i = $(".bj_tabs_tab > ul > li").index($(this));
	        $(".bj_tabs_content > .show").removeClass("show");
	        $(".bj_tabs_content > .tabs_content").eq(i).addClass("show");
	        $(".bj_tabs_tab > ul > li").eq(i).addClass("active").siblings().removeClass("active");
        });

        //显示下载区域
        $("#DownLoadAndroid").click(function() {
	        $(".downloadtype").show(100);
        });
        
        //隐藏下载区域
        $("#btnClose").click(function() {
	        $(".downloadtype").hide(100);
        });
        
        //下载按钮图片切换
        var btnDown = $("#DownLoadAndroid");
        btnDown.mouseover(
        function () { 
            btnDown.removeClass("androidbtnOff");
            btnDown.addClass("androidbtnOn");
        });
        btnDown.mouseout(
        function () { 
            btnDown.removeClass("androidbtnOn");
            btnDown.addClass("androidbtnOff");
        });
        
        //发送短信
        function sendMessage()
        {
            var mobile = $("#txtMobile").val();
            var regMobile = /^((\(\d{2,3}\))|(\d{3}\-))?((13\d{9})|(15\d{9})|(14\d{9})|(18\d{9}))$/;
            
            if(mobile != "请输入您的手机号码")
            {
                if(regMobile.test(mobile) == true)
                {
                    document.getElementById("btnSend").disabled = "true";
                    $.post("DownLoadAndriod.aspx", { s: "1", Mobile: mobile }, function(data) {
                        if(data == 1)
                        {
                            art.dialog({content: '短信已发送！',lock: 'true',skin: 'aero', icon: 'succeed'});
                            $("#txtMobile").val("");
                            document.getElementById("btnSend").disabled = "";
                        }
                        else
                        {
                            art.dialog({content: '短信发送失败，如有疑问请拨打客服电话：400-800-7999！',lock: 'true',skin: 'aero', icon: 'error'});
                            document.getElementById("btnSend").disabled = "";
                        }
                    });
                }
                else
                {
                    art.dialog({content: '请填写正确的手机号码！',lock: 'true',skin: 'aero', icon: 'error'});
                }
            }
            else
            {
                art.dialog({content: '请填写手机号码！',lock: 'true',skin: 'aero', icon: 'error'});
            }  
        }
        
        //手机客户端演示图片切换
        var num = 1;
        function ChangeImage() {
            document.getElementById("imgAndroid").src = "common/images/andriod0" + num + ".jpeg";
            if(num == 4)
            {
                num = 1;
            }
            else
            {
                num++;
            }
            window.setTimeout(ChangeImage,5000);
        }
        ChangeImage();
    </script>    
    
    
    
    
    
    
    
    
    
    
        
        </div>

    </div>

            </div>
        </div>
        <div id="footer">
            <p> 智能门锁管理平台 版权所有 All Rights Reserved</p>
            <p>公司地址： 智能门锁管理平台</p>
            <p>Built By scpos 苏ICP备xxxxxxxxxx号-1</p>
        </div>
    </div>
    
    <script language="javascript" type="text/javascript">
        $("#reg").bind("click", function() {
            window.location.href = '<%=basePath %>reg';
        });

        $("#login").bind("click", function() {
        	 var remeber = $("#remeber").attr("checked");
             if(remeber=="checked"){
                 var account = $("#account").val();
                 var password = $("#password").val();
                 $.cookie("account", account, { expires: 7 });
                 $.cookie("password", password, { expires: 7 });
             }else{
            	$.cookie("account", null);
            	$.cookie("password", null); 
            }
            master.loginFunction('<%=basePath %>j_spring_security_check', '<%=basePath %>main.htm', '<%=basePath %>toLogin.htm');
        })
        .focus();

        $("#password").keypress(function(event) {
            if (event.which == 13) {
            }
        });
        
        $(function() {
            $(window).scroll(function() {
                $(".qq").stop();
                $(".qq").animate({ top: (document.documentElement.scrollTop || document.body.scrollTop) + 300 }, 10);
            });
        });
        //读取cookies
        $(document).ready(function(){
        	var account = $.cookie("account");
        	var password = $.cookie("password");
        	if(account!=null&&password!=null){
	        	$("#account").val(account);
	        	$("#showPwd").val("******");
	        	$("#password").val(password);
	        	$("#remeber").attr("checked","checked");
        	}            
        });
    </script>

</body>
</html>
