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
	<style type="text/css">
	.aui_icon div{
    	background: url("<%=basePath%>common/images/error.png") no-repeat scroll center center rgba(0, 0, 0, 0) !important;
	}
	</style> 
<div>
</div>

    <div class="all">
        <!---->  <div class="ttlogo">智能门锁管理平台</div>
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
                            <a href='<%=basePath %>sendPass.htm' title="找回密码">找回密码</a>
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
                
     <div class="title" style="height:30px;">
          	开发者账号注册&nbsp;&nbsp;&nbsp;&nbsp;<nobr style="color:green;">您已注册成功，现在可以登录！</nobr>
    </div>
    <div class="regForm">
        <!-- 
        <div class="regRow" style="height:20px;">
            <div class="leftCell">
                <label>
                   	 验证码：</label><input id="txtVCode" type="text" maxlength="10" /></div>
            <div id="chktxtVCode" class="rightCell">
                	请输入短信验证码</div>
            <div class="checkCell">
            </div>
        </div>
         -->
        <div class="regRow" style="height:20px;">
            <div class="leftCell">
                <label>
                  	 登录名：</label><input id="txtName" type="text" maxlength="10" /></div>
            <div id="chktxtName" class="rightCell">
                	请输入您的登录名</div>
        	</div>
        <div class="regRow" style="height:20px;">
            <div class="leftCell">
                <label>
                    	密码：</label><input id="txtPwd" type="password" maxlength="16" /></div>
            <div id="chktxtPwd" class="rightCell">
                	长度6~16位，数字、字母、下划线(包含特殊字符)</div>
       	 	</div>
        <div class="regRow" style="height:20px;">
            <div class="leftCell">
                <label>
                    	确认密码：</label><input id="txtRPwd" type="password" maxlength="16" /></div>
            <div id="chktxtRPwd" class="rightCell">
                	确认您的密码</div>
        	</div>
        <div class="regRow" style="height:20px;">
            <div class="leftCell">
                <label>
                    	手机号：</label><input id="txtMobi"  onfocus="if(value==defaultValue){value='';this.style.color='#000'}" onblur="if(!value){value=defaultValue;this.style.color='#999'}" style=" color:#999" type="text" maxlength="11" name="txtMobi"  /></div>
            
            <div id="chktxtMobi" class="rightCell">请输入手机号
            </div>
        </div>
          <div class="regRow" style="height:20px;">
            <div class="leftCell">
                <label>
                  	公司名称：</label><input id="txtCpn" type="text" maxlength="16" /></div>
            <div id="chktxtCpn" class="rightCell">
                	请输入公司名称</div>
        </div>
        <div class="regRow" style="height:20px;">
            <div class="leftCell">
                <label>
                  	公司电话：</label><input id="txtTlp" type="text" maxlength="16" /></div>
            <div id="chktxtTlp" class="rightCell">
                	请输入公司电话</div>
        </div>
        <div class="regRow" style="height:20px;">
            <div class="leftCell">
                <label>
                  	公司地址：</label><input id="txtAds" type="text" maxlength="16" /></div>
            <div id="chktxtAds" class="rightCell">
                	请输入公司地址</div>
        </div>
        <div class="regRow" style=" height:220px;">
            <div class="license" style=" padding-top:5px;">
                <div style=" margin-left:82px; margin-bottom:5px;">《用户服务条款》<span id="isChk" style=" color:#f00; margin-left:16px; font-size:12px;"></span></div>
                <textarea id="txtLicense" cols="70" rows="6" readonly  >尊敬的用户，在您注册之前请认真阅读以下注册协议。
感谢您访问本网站。在使用本网站前，请仔细阅读以下使用条款，该使用条款中包含您作为本网站用户所享有的权利和义务等重要内容。 请注意：访问、使用本网站（如复制任何信息、注册成为网站用户等）即表示您接受该使用条款。如果不接受该使用条款，请您立即停止使用本网站并删除、 销毁所有包含本网站内容的复制品。
1 有关定义
1.1 “本网站”：是指由摇钱数软件有限公司运营管理的、明示或引用并要求用户遵守本使用条款的网站。
1.2 “本公司”：是指由摇钱数软件有限公司；“本公司产品”指由本公司生产的标有“云通途”商标标识的正品产品。
1.3 “服务”：是指本网站提供的任何功能、设施、应用、信息或其他服务。
1.4 “网站内容”：是指本网站包含的任何数据、图表、图片、设计、描述、文档、音视频作品、软件、工具、链接、用户在本网站订阅的信息等内容。
1.5 “您”或“用户”：是指任何访问或使用本网站的人，无论其是否属于本网站或本网站某项服务的注册用户。
1.6 “用户提供信息”：是指用户依照本网站指示上传至本网站的图片、音视频资料、数据、个人信息、意见、评论、文件、文档等信息。 用户提供信息
2 用户提供信息
2.1 用户保证：
2.1.1 用户提供信息是正确、完整、真实、合法的，不存在虚假、欺诈、骚扰性的、中伤他人的、伤害性的、诽谤、侮辱、恐吓、庸俗淫秽等违反法 律、公序良俗或社会伦理道德的信息或内容，也不存在危害网络或计算机系统的安全性、完整性、稳定性、连续性的病毒、木马程序等电脑软件、 文档或其他数据资料。
2.1.2 用户对用户提供信息拥有完整的、独立的权利，保证本公司使用用户提供信息不会侵犯任何第三方的著作权或其他合法权利，亦不会违反用户与 任何第三方的约定。
2.2 如果用户提供信息有违反第2.1条规定的情形，或本公司有理由相信有上述情形，则本网站有权利拒绝用户使用本网站的服务。对于用户因此而无法 获得来自本网站的信息或其他服务，本公司不负任何责任。
2.3 对于用户提供信息中所涉及的用户个人信息，本公司依照国家相关法律法规的规定予以保护。 用户的用户名、密码和安全性
3 用户的用户名、密码和安全性
3.1 本网站可能会邀请用户就本网站或本网站某项服务的使用进行身份注册，本网站完全尊重用户自主决定是否进行身份注册。如果用户选择进行身 份注册，用户还应遵守本网站指示的其他条款和条件，包括但不限于注册条款。
3.2 用户一旦注册成功并获得用户名和密码，用户应妥善保管该用户名和密码，不得将其转让或授予他人使用，并对以其用户名从事的一切活动承担 责任。
3.3 如用户发现其用户名和密码遭他人非法使用，应立即通知本网站。因黑客行为或用户的保管疏忽等非本网站方面的原因导致用户名和密码遭他人 非法使用的，本网站不承担任何责任。
3.4 本网站保留无需任何理由随时终止用户访问本网站的权利及其注册身份，如发生这种情况，本网站将尽合理的努力通知该用户。
3.5 一旦用户的注册身份被终止，用户应立即停止使用本网站，并删除、销毁其保留的所有包含本网站内容的复制件。
4 网站使用规则
4.1 在用户遵守本使用条款的前提下，本公司授予用户关于本网站的有限的、不可转让的、非独占的、可撤销的、仅为个人用途而非商业性使用的权 利。在任何情形下，本网站内容及服务（包括但不限于用户获得的用户名等身份信息）仅被许可由用户个人使用而不得被出售或转让或共用。本公司 保留本使用条款未特别授予的所有权利。
4.2 用户在使用本网站过程中，必须遵循以下原则：
4.2.1 遵守相应国家法律和法规；
4.2.2 遵守本使用条款及所有相关的协议、规定和程序，同时也必须遵循与因特网有关的程序和惯例；
4.2.3 不得利用本网站从事违法犯罪的活动、有损社会公共利益的行为；
4.2.4 不得利用本网站进行任何可能对互联网正常运转造成不利影响的行为； 4.2.5 不得侵犯本公司或其他任何第三方的专利权、著作权、商标权等知识产权、名誉权或其他任何合法权益，或从事损害本公司利益或对本公司 造成不利影响的行为。 4.3 除非已遵守了本使用条款的其它规定或已取得了本公司事先许可，用户不得为任何目的从事以下行为： －下载、复制、展示、分发、传播、上载、出版、发行本网站内容； －修改、编辑或以其他方式演绎本网站内容； －转让、转售、出租本网站内容或服务。 4.4 用户在使用本网站时违反任何上述规定，本公司可自行判断后要求用户纠正或采取一切必要的措施（包括但不限于删除用户上传的内容、暂停或 终止(用户使用本网站的权利）以减轻用户不当行为造成的影响。
5 知识产权
5.1 本公司对所拥有的商标、标识、图案、软件著作权、产品型号及名称、本网站的名称、域名或其衍生物拥有相应权利。本使用条款亦不授予用户 上述任何权利或权益。在未经本公司事先书面同意的情况下，用户不得在任何宣传或促销材料、出版物中或媒体上使用本公司标识 。
5.2 除第5.1条的规定外，本网站中包含的任何信息、文本、图形等网站内容均受著作权法、商标法和其他知识产权法等相关法律的保护，其相关权 利归本公司或该内容提供者所有。未经本公司或有关权利人事先同意，用户不得复制、分发、传播、修改、编辑，或在任何媒体直接或间接发布、 播放该些内容，或者将该些内容用于任何商业目的。
5.3 在本公司或有关权利人事先同意的前提下，在遵循本公司或有关权利人指示的基础上，用户可以对网站内容进行复制或分发，但用户必须确保复 制和分发是完整和真实的，包括但不仅限于所有有关电子文档、著作权和商标等，亦包括本使用条款本身。
6 关于软件下载的特别规定
6.1 任何可从本网站下载的软件及有关文档的著作权及相关权利均为本公司或其他内容提供者所有。用户应遵守本使用条款第5条的规定。
6.2 软件下载仅可以用户个人使用为目的，且软件使用应遵循软件附带或包含在软件内的最终用户许可协议（以下简称“许可协议”）的规定。
6.3 若软件带有任何保证，将仅以许可协议的规定为准。除许可协议承诺的之外，本公司不做任何明示或暗示的保证，包括但不限于准确性、可靠性、 适销性、适用于特殊目的或不侵权的保证，亦不承担任何因安装或使用软件而导致的数据丢失或其他损失的责任。
7 外部链接
本网站内容可能含有与其他网站的链接，这些外部链接仅为用户提供便利，不代表本公司经营或参与经营这些网站，亦不代表用户被授予访问或使用 这些网站的许可，用户应以自己的责任（包括但不限于遵守这些网站的使用条款）和费用访问这些网站，本公司不对这些网站的内容和行为负责。
8 责任
8.1 本公司不能保证向用户提供的服务是连续的、即时的、准确的，不能保证缺陷一定会被及时纠正，也不能保证所提供的服务或服务器不受病毒或 黑客等有害成分的侵袭。服务和网站内容依现状提供，本公司不作任何形式的有关服务或网站内容的准确性、完整性、令人满意的品质、不侵权 或适合某一特殊目的的保证。
8.2 本公司保留随时修改、增减、取消、暂停、中断或终止提供本网站的服务（全部或部分）而无需事先告知用户的权利，本公司在行使前述各项权 利时亦无需对用户承担任何责任。
8.3 本公司将尽可能地在本网站提供准确的信息。本网站所载产品图片与实物可能有细微区别，有关本公司产品的外观（包括但不限于颜色）请以实 物为准。
8.4 本公司保留随时更改网站内容所涉及的本公司产品的设计、规格、工艺、材料的权利，而无需事先通知用户。
8.5 限于篇幅, 网站中所包含的信息(包括但不限于产品规格、功能说明等)可能不完整，请以有关产品使用说明书的具体信息为准。
8.6 本网站服务器如因系统维护或升级而需暂停服务时，将尽量事先公告。如因系统维护、升级而需暂停服务或因服务器故障、硬件故障、其他不可 抗力因素而导致停止服务，于暂停服务期间造成的一切不便和资料、数据等遗失，本网站将尽力挽救恢复；如确实无法恢复，本网站不承担任何 责任。
8.7 本公司不承担由于用户提供信息而可能产生的任何责任，包括但不限于因其他用户在没有获得授权的情形下使用用户提供信息，或因用户提供信 息包含错误、不准确、病毒、诽谤、中伤、侵权等著作权法、民法或其他任何法律所禁止的内容或其他内容而产生的任何责任。本公司亦不对用 户提供信息在任何情形下的丢失、删除、移除或传输失败承担任何责任，用户应对其提供信息自行保留备份。本公司保留随时删除或移除任何用 户提供信息的权利，而无需通知用户，且不需承担任何责任。
8.8 对于用户通过本网站或外部链接与第三方发生的任何法律行为，包括但不限于与第三方的交易，由用户与该第三方自行承担全部的责任，本公司 不承担任何责任。
8.9 用户承认并接受：对于用户因使用本网站而遭受的任何直接或间接的损失，包括但不限于由于网站内容或服务的延误、不准确、错误和遗漏而产 生的任何损害、责任、请求、损失或费用，本公司不承担任何责任。
修改
本公司有权在必要时对本使用条款予以修改而无需事先通知用户。一旦发生变动，本公司将尽可能及时地在本网站上进行更新。如用户不同意所修改的 内容，可主动停止使用本网站。如用户继续使用本网站，则被视为接受修改后的使用条款。
其他协议或条款
用户在使用本网站的服务时，根据所涉及的服务内容，可能需要同时遵守其他协议或条款，包括但不限于有关会员的注册条款，软件的许可协议，购买 本公司产品的销售条款，文档下载的许可协议等所有适用的条款。用户仅在完全同意该条款的前提下，方可使用该有关的服务。 对于使用条款的修改或其他重要事项，本公司可依其选择通过网站公告、电子邮件或其他方式通知用户。
适用法律和争议解决
本网站使用条款的解释和执行均适用中华人民共和国法律。本使用条款及本网站内公布的任何附加条款，构成本公司与用户之间关于使用本网站的完整 协议。如果该协议的内容与现行的家法律规定不一致，则以法律规定为准。因该协议的履行产生的任何纠纷，首先由双方协商解决；协商不成的，任何 一方均可向南京市有管辖权的法院提起诉讼。 如在使用本网站的过程中遇到任何问题，请通过此邮件地址(info@hotmail.com)与我们联系。
</textarea></div>
        </div>
        
        <div>
            <button type="button" class="signsub" id="regClick">
            </button>
        </div>

    </div>
	    <script type="text/javascript" language="javascript">
        $("#getvcodeClick").bind("click", function() {
            master.getVcode("reg");
        });
        $("#regClick").bind("click", function() {
            master.regFunc("reg");
        });
        $("#txtMobi").bind("blur", function() {
            chkMoudle.chkPhone("reg");
            removeCls();
        });
        $("#txtVCode").bind("blur", function() {
            chkMoudle.chkCode();
            removeCls();
        });
        $("#txtName").bind("blur", function() {
            chkMoudle.checkUIName();
            removeCls();
        });
        $("#txtPwd").bind("blur", function() {
            chkMoudle.checkPass();
            removeCls();
        });
        $("#txtRPwd").bind("blur", function() {
            chkMoudle.checkRPass();
            removeCls();
        });
        $("#txtCpn").bind("blur", function() {
            //chkMoudle.checkCpn();
            removeCls();
        });
        $("#txtTlp").bind("blur", function() {
            //chkMoudle.checkTlp();
            removeCls();
        });
        $("#txtAds").bind("blur", function() {
            //chkMoudle.checkAds();
            removeCls();
        });
        
        //removeCls();

        
        
    </script>
	
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
	        window.location.href = '<%=basePath %>toReg.htm';
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

     	// 绑定键盘按下事件  
		   $(document).keypress(function(e) {  
		    // 回车键事件  
		       if((e.which||e.keycode) == 13) { 
			        
		    	   $("#login").click();
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
