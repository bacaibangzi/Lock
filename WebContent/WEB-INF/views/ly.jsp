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
                
    
    <div class="title">
        客户留言
    </div>
    <div class="regForm">
        <div class="regRow">
            <div class="leftCell">
                <label>
                    您的称呼：</label><input id="txtName" type="text" maxlength="10" /></div>
            <div id="chktxtName" class="rightCell">
            </div>
        </div>
        <div class="regRow">
            <div class="leftCell">
                <label>
                    联系电话：</label><input id="txtMobi" type="text" maxlength="16" /></div>
            <div id="chktxtMobi" class="rightCell">
            </div>
        </div>
        <div class="regRow">
            <div class="leftCell">
                <label>
                    电子邮箱：</label><input id="txtEmail" type="text" maxlength="25" /></div>
            <div id="chktxtEmail" class="rightCell">
            </div>
        </div>
        <div class="regRow" style="height: 140px; ">
            <div class="lyTitle">留言内容：</div>
            <div class="lyContent">
                <textarea id="txtContent" cols="70" rows="6"></textarea>
            </div>
            <div id="chktxtContent" class="rightCell">
            </div>
        </div>
        <div >
            <button id="messageClick" type="button" class="sendsub">
            </button>
        </div>
    </div>

    <script type="text/javascript" language="javascript">

	    $("#reg").bind("click", function() {
	        window.location.href = '<%=basePath %>toReg.htm';
	    });
	

        $("#messageClick").bind("click", function() {
            master.submitMessage();
            return false;
        });

        $("#txtName").bind("blur", function() {
            chkMoudle.checkUIName();
            removeCls();
        });
        $("#txtMobi").bind("blur", function() {
            chkMoudle.chkPhone("all");
            removeCls();
        });

        $("#txtEmail").bind("blur", function() {
            chkMoudle.chkMail();
            removeCls();
        });

        $("#txtContent").bind("blur", function() {
            chkMoudle.chkContent("txtContent", 200);
            removeCls();
        });
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
