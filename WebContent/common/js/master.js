$().ready(function() {
    master.initEventHandlers();
});

var chkResult = {//验证结果
    Error: 0,
    Correct: 1
};

var chkType = {//验证类别
    PhoneNumber: 0,
    VCode: 1,
    UserName: 2,
    PassWord: 3,
    Rpwd: 4
};

var chkMoudle = {
    chkPhone: function(type) {
        var phone = $("#txtMobi").val();
        //var terminal = "联系电话";

        //var regPhone = /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/;
        var regMobi = /^((\(\d{2,3}\))|(\d{3}\-))?((13\d{9})|(15\d{9})|(14\d{9})|(18\d{9}))$/;
        if (check("txtMobi", phone)) {
            if(!regMobi.test(phone)){
    			styleSwitch("#chktxtMobi", "手机号码格式错误");
    	        return false;
    		}else if(type!="find"){
    			$.ajax({
                  type: "GET",
                  url: "account/checkMobi",
                  data: { uiMobile: phone },
                  success: function(data) {
                      //debugger;
                      if (data == "1") {
                          styleSwitch("#chktxtMobi", "您输入的手机号已被注册");
                          return false;
                      }
                      else {
                          styleSwitch("#chktxtMobi", "输入正确", chkResult.Correct);
                          return true;
                      }
                  }
              });
    		
    		}else {
    			 styleSwitch("#chktxtMobi", "输入正确", chkResult.Correct);
                 return true;
    		}
            //debugger;
            //var testRes = false;
//            if (typeof type != "undefined") {
//                if (type == "mobi") {
//                    testRes = regMobi.test(phone);
//                    terminal = "手机号";
//                } else if (type == "local") {
//                    testRes = regPhone.test(phone);
//                    terminal = "固话号码";
//                } else if (type == "all") {
//                    testRes = regMobi.test(phone) || regPhone.test(phone);
//                    terminal = "联系电话";
//                }
//            } else {
//                testRes = regMobi.test(phone);
//                terminal = "手机号";
//            }
//            //debugger;
//
//            if (!testRes) {
//                styleSwitch("#chktxtMobi", "您输入的" + terminal + "不合法");
//                return false;
//            } else {
//                var location = window.location.pathname;
//                if (location.indexOf("reg") != -1) {//注册
//                    $.ajax({
//                        type: "GET",
//                        url: "reg.htm",
//                        data: { n: phone },
//                        async: false,
//                        success: function(data) {
//                            //debugger;
//                            if (data == "1") {
//                                styleSwitch("#chktxtMobi", "您输入的手机号已被注册");
//                                return false;
//                            }
//                            else {
//                                styleSwitch("#chktxtMobi", "输入正确", chkResult.Correct);
//                                return true;
//                            }
//                        }
//                    });
//                } else if (location.indexOf("sendPass") != -1) {//找回密码
//                    $.ajax({
//                        type: "GET",
//                        url: "reg.htm",
//                        data: { n: phone },
//                        async: false,
//                        success: function(data) {
//                            if (data == "1") {                                
//                                styleSwitch("#chktxtMobi", "输入正确", chkResult.Correct);
//                                return true;
//                            }
//                            else {
//                                styleSwitch("#chktxtMobi", "该账号不存在！");
//                                return false;
//                            }
//                        }
//                    });
//                } else {
//                    styleSwitch("#chktxtMobi", "输入正确", chkResult.Correct);
//                    return true;
//                }
//            }
        } else {
//            if (type == "all")
                styleSwitch("#chktxtMobi", "请输入您的手机号");
            return false;
        }
    },
    chkMail: function() {
        var mail = $("#txtEmail").val();
        if (check("txtEmail", mail)) {
            var regMail = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
            if (!regMail.test(mail)) {
                styleSwitch("#chktxtEmail", "邮箱填写错误");
                return false;
            } else {
                styleSwitch("#chktxtEmail", "输入正确", chkResult.Correct);
                return true;
            }
        } else {
            styleSwitch("#chktxtEmail", "请输入您正确的电子邮箱");
            return false;
        }
    },
    chkContent: function(content, len) {
        if (content) {
            if (content.indexOf("#") != -1) {
                content = content.replace("#", "");
            }
        }
        var cc = $("#" + content).val();
        //debugger;
        if (check(content, cc)) {
            //alert(cc.length);
            if (cc.length > 200) {
                styleSwitch("#chktxtContent", "必须少于200字");
                return false;
            } else {
                styleSwitch("#chktxtContent", "输入正确", chkResult.Correct);
                return true;
            }
        } else {
            styleSwitch("#chktxtContent", "请输入留言内容");
            return false;
        }
    },
    chkCode: function(sendType) {
        var checkCode = $("#txtVCode").val();
       // var phone = $("#txtMobi").val();
       // $("#chktxtVCode").html("");
        //debugger;
        if (check("txtVCode", checkCode)) {
            //$.ajax({
                //type: "GET",
                //url: "sendPass.htm",
                //data: { u: phone, c: checkCode, st: sendType },
                //async: false,
               // success: function(data) {
                    //debugger;
                   // if (data == 0) {
                        //styleSwitch("#chktxtVCode", "验证码输入错误，请重新输入");
                        //return false;
                    //} else if (data == 1) {
                        styleSwitch("#chktxtVCode", "已输入", chkResult.Correct);
                        return true;
                   // }
               // }
            //});
        } else {
            styleSwitch("#chktxtVCode", "请输入短信验证码");
            //if (checkCode == "") $("#txtVCode").focus();
            return false;
        }
    },
    checkUIName: function() {
        var name = $("#txtName").val();
        if (check("txtName", name)) {
            if (name.length > 40 || name.length < 1) {
                styleSwitch("#chktxtName", "登录名需在40位以内！");
                return false;
            } else {
                styleSwitch("#chktxtName", "输入正确", chkResult.Correct);
                return true;
            }
        } else {
            styleSwitch("#chktxtName", "请输入登录名");
            return false;
        }
    },
    checkPass: function() {
        var pass = $("#txtPwd").val();
        if (check("txtPwd", pass)) {
            var reg = /[a-zA-Z0-9_\-\!\#\$\%\^\&\*\.\~\@\(\)\+\=\?\/\>\<\`]$/;
            if (!reg.test(pass) || pass.length > 16 || pass.length < 6) {
                styleSwitch("#chktxtPwd", "长度6~16位，数字、字母、下划线(包含特殊字符)");
                return false;
            } else {
                styleSwitch("#chktxtPwd", "输入正确", chkResult.Correct);
                return true;
            }
        } else {
            styleSwitch("#chktxtPwd", "长度6~16位，数字、字母、下划线(包含特殊字符)");
            return false;
        }
    },
    checkRPass: function() {
        var pass = $("#txtPwd").val();
        var rpass = $("#txtRPwd").val();
        if (check("txtRPwd", rpass)) {
            if (pass != rpass) {
                styleSwitch("#chktxtRPwd", "密码输入不一致");
                return false;
            } else {
                styleSwitch("#chktxtRPwd", "输入正确", chkResult.Correct);
                return true;
            }
        } else {
            styleSwitch("#chktxtRPwd", "确认您的密码");
            return false;
        }
    },
    checkCpn: function() {
    	var txtCpn = $("#txtCpn").val();
    	if (check("txtCpn", txtCpn)) {
    		styleSwitch("#chktxtCpn", "输入正确", chkResult.Correct);
            return true;
    	}else{
	    	styleSwitch("#chktxtCpn", "请输入您的公司名称");
	        return false;
    	}
    },
    checkTlp: function() {
    	var txtTlp = $("#txtTlp").val();
    	var regPhone = /^[0-9]{8,9}$/;
    	if (check("txtTlp", txtTlp)) {
    		if(!regPhone.test(txtTlp)){
    			styleSwitch("#chktxtTlp", "电话号码必须为8到9位");
    	        return false;
    		}else{
    			styleSwitch("#chktxtTlp", "输入正确", chkResult.Correct);
    			return true;
    		}
    	}else{
	    	styleSwitch("#chktxtTlp", "请输入您的公司电话");
	        return false;
    	}
    },
    checkAds: function() {
    	var txtAds = $("#txtAds").val();
    	if (check("txtAds", txtAds)) {
    		styleSwitch("#chktxtAds", "输入正确", chkResult.Correct);
            return true;
    	}else{
	    	styleSwitch("#chktxtAds", "请输入您的公司地址");
	        return false;
    	}
    }
};

var elemtsdata = { div: [], input: [] };

var sRes = 0;
var loginTip;

var master = {
    initEventHandlers: function() {//初始化
        var location = window.location.pathname;

        //文本框提示层
        //master.vyTip("#account", "请输入您的登录账号");
        $("#showPwd").focus(function() {
            var val = $(this).val();
            if (val == this.defaultValue||val == "******") {
                $(this).hide();
                $("#password").show().focus();
            }
            //master.vyTip("#password", "请输入您的登录密码");
            $("#password").click();
        });
        //密码框切换
        $("#password").blur(function() {
            //debugger;
            if ($(this).val() == "") {
                $(this).hide();
                $("#showPwd").show();
            }
        });

        //按钮样式
        initBtnstyle();
        //登录按钮绑定功能

        //master.masterTip("#pwdblock", 24, -15, "请输入您的登录密码");

        //初始化登录框
        //debugger;
        var cookies = getCookie("userLogin");
        if (cookies != "" && cookies.indexOf('|') != -1) {
            if (cookies.split('|')[2] == "1") {
                $("#account").val(cookies.split('|')[0]);
                $("#password").val(cookies.split('|')[1]);
                $("#password").show();
                $("#showPwd").hide();
                $("#remeber").attr("checked", "true");
            }
        }

        $("#error").yitip({
            "showEvent": "click",
            "hideEvent": null
        });
        loginTip = $("#error").yitip("api");
        loginTip.setContent("<p style='color:#f00;'>您输入的账号和密码不匹配。<p>");


        /*$("#account").click(function() {
            loginTip.hide(100);
            //            var ischk = $("#remeber").attr("checked");
            //            if (ischk != "checked") {
            //                if ($("#account").val() != "") {
            //                    $("#account").val("");
            //                }
            //            }
        });
        
        $("#password").click(function() {
            loginTip.hide(100);
            if ($("#password").val() != "") {
                $("#password").val("");
            }
        });*/        
        
        $("#left-enter .denglu").click(function(e) {
            var $target = $(e.target);
            if ($target[0].id == "password") {
                if ($("#password").val() != "") $("#password").val("");
            }
            loginTip.hide(100);
        });
        
        //----------get initialize container's states after submit---------
        //debugger;
        var divElemts = $(".regForm div[id^=chk]");
        if (elemtsdata.div.length == 0) {
            for (var i = 0; i < divElemts.length; i++) {
                var el = divElemts[i];
                elemtsdata.div.push({ id: el.id, html: el.innerHTML, cls: el.className });
            }
        }
        if (elemtsdata.input.length == 0) {
            var inputElemts = $(".regForm input[id^=txt]");
            for (var i = 0; i < inputElemts.length; i++) {
                var el = inputElemts[i];
                elemtsdata.input.push({ id: el.id, val: el.value, cls: el.className });
            }
        }
        //------------------------------------------------------------------
    },
    loginFunction: function(ajaxUrl, succUrl, faliUrl) {//登录功能
        //debugger;
        var account = $("#account").val() == $("#account")[0].defaultValue ? "" : $("#account").val();
        var password = $("#password").val() == $("#password")[0].defaultValue ? "" : $("#password").val();

        if (check("account", account) && check("showPwd", password)) {
            var remeber;
            remeber = $("#remeber").attr("checked") ? "1" : "0";
            $.ajax({
                type: "POST",
                //type: "GET",
                url: ajaxUrl,
                dataType: "json",
                data: "ajaxTag=ajaxTag&j_username=" + account + "&j_password=" + password + "&r=" + remeber,
                beforeSend: function() {
                    $("#loader").show();
                },
                success: function(data, textStatus) {
                    $("#loader").hide();
                    //debugger;
                    if (data.success=='true') {
                        $("body").html("正在登录，请稍后...");
                        window.location = succUrl;
                    } else {
                        //window.location.href(faliUrl);
                        loginTip = $("#error").yitip("api");
                        //loginTip.setContent("<p style='color:#f00;'>您输入的账号和密码不匹配。<p>");
                        loginTip.setContent("<p style='color:#f00;'>"+data.errorInfo+"<p>");
                        $("#error").click();
                    }
                }
            });
        } else {
            loginTip = $("#error").yitip("api");
            loginTip.setContent("<p style='color:#f00;'>请输入您的登录账号和密码。<p>");
            $("#error").click();
        }
    },
    masterTip: function(target, x, y, content) {//弃用提示脚本
        //        $(target).poshytip({
        //            className: 'tip-yellowsimple',
        //            showOn: 'focus',
        //            alignTo: 'target',
        //            alignX: 'inner-right',
        //            offsetX: x,
        //            offsetY: y,
        //            content: content
        //        });
    },
    vyTip: function(target, msg) {//提示
        $(target).yitip({ "showEvent": "click", "hideEvent": null });
        var accTip = $(target).yitip("api");
        accTip.setContent(msg);
        $(target).blur(function() {
            $(".yitip").hide("slow");
        });
    },
    initializeMap: function() {//加载地图
        var latlng = new google.maps.LatLng(31.987, 118.944);
        var myOptions = {
            zoom: 8,
            center: latlng,
            mapTypeId: google.maps.MapTypeId.ROADMAP
            //, mapTypeControl: false,
            //scaleControl: false,
            //zoomControl: false,
            //streetViewControl: false,
            //panControl:false
        };
        map = new google.maps.Map(document.getElementById("map_canvas"),
        myOptions);
    },
    regFunc: function(type) {//注册功能
    	
        //        var isCheck = $("#chkLicense").attr("checked");
        //        //alert(isCheck);
        //        //debugger;
        //        if (!isCheck) {
        //            if ($("#isChk").html() == "")
        //                styleSwitch("#isChk", "必须同意云通途服务条款", chkResult.Error);
        //            $("#isChk").focus();
        //        } else {
    	
        //var cls_mobi = $.trim(document.getElementById("chktxtMobi").className);
        //var cls_code = $.trim(document.getElementById("chktxtVCode").className);
        //var cls_uname = $.trim(document.getElementById("chktxtName").className);
        //var cls_pwd = $.trim(document.getElementById("chktxtPwd").className);
        //var cls_rpwd = $.trim(document.getElementById("chktxtRPwd").className);
        //var cls_Cpn = $.trim(document.getElementById("chktxtCpn").className);
        //var cls_Tlp = $.trim(document.getElementById("chktxtTlp").className);
        //var cls_Ads = $.trim(document.getElementById("chktxtAds").className);
    	
        //debugger;
    	
        //var array = [cls_mobi, cls_code, cls_uname, cls_pwd, cls_rpwd, cls_Cpn, cls_Tlp, cls_Ads, "checkOK"];
        //var json = {};
        //for (var i = 0; i < array.length; i++) {
        //    json[array[i]] = json[array[i]] ? json[array[i]] + 1 : 1;
        //}
        //var counter = 0;
        //for (var e in json) {
            //counter++;
        //}
        //if (counter == 1) {
    //	alert("chkMoudle.chkPhone():"+chkMoudle.chkPhone());
    //alert("chkMoudle.chkCode(reg):"+chkMoudle.chkCode());
   // alert("chkMoudle.checkUIName():"+chkMoudle.checkUIName(type));
   // alert("chkMoudle.checkPass():"+chkMoudle.checkPass());
   // alert("chkMoudle.checkRPass():"+chkMoudle.checkRPass());
   // alert("chkMoudle.chkPhone():"+chkMoudle.chkPhone(type));
    //alert("chkMoudle.checkTlp():"+chkMoudle.checkTlp());
    //alert("chkMoudle.checkAds():"+chkMoudle.checkAds());
    //alert("->"+chkMoudle.checkUIName(type)&&chkMoudle.checkPass()&&chkMoudle.checkRPass()&&chkMoudle.chkPhone());
    	if(chkMoudle.checkUIName(type)&&chkMoudle.checkPass()&&chkMoudle.checkRPass()&&chkMoudle.chkMail()){
            //alert("ok");
            var uiMobile = $("#txtMobi").val();
            var code = $("#txtVCode").val();
            var uiLoginName = $("#txtName").val();
            var uiPassword = $("#txtPwd").val();
			var uiCompany = $("#txtCpn").val();
			var uiAddress = $("#txtAds").val();
			var uiTelphone = $("#txtTlp").val();
			var uiMail = $("#txtEmail").val();
			
			//alert(uiMail);
				
            $.ajax({
                type: "POST",
                url: "account/regist",
                //dataType: "json",
                data: "uiMobile=" + uiMobile + "&code=" + code + "&uiLoginName=" + uiLoginName+"&uiPassword="+uiPassword+"&uiCompany="+uiCompany+"&uiAddress="+uiAddress+"&uiTelphone="+uiTelphone+"&uiEmail="+uiMail,
                success: function(data) {
                	//alert("data :"+data);
                    //$("#loader").hide();
                    if (data=="success") {
                    	//ttalert("success", "注册成功");
                    	//window.location.href("default.htm");
                    window.location.href = "default.htm";
                    } else if (data=="nameRepeat"){
                        //ttalert("error", "用户名已经存在");
                    	alert("用户名已经存在");
                    } else if (data=="error"){
                    	ttalert("error", "注册出错!");
                    }else {
                        ttalert("error", "注册码错误")
                    }
                }
            });
       }
    },
    getVcode: function(sendType) {//发送短信验证码功能
        //$("#chktxtMobi").removeClass("checkOK").removeClass("checkNO").addClass("checkCell").html("");
        var phone = $("#txtMobi").val();
        //debugger;
        //var sFlag = chkMoudle.chkPhone();
        chkMoudle.chkPhone(sendType);
        //sleep(1000);

        //debugger;
        var cls = document.getElementById("chktxtMobi").className;
        sFlag = cls == "checkOK" ? true : false;
        //alert(sFlag);
        if (sFlag) {
        	$("#getvcodeClick").removeClass("huoqu").addClass("huoqujieshu").html("请等待").append("<span id='refTimer'></span>秒...");
        	$("#getvcodeClick").unbind("click");
    	//alert(chkMoudle.chkPhone());
    	//if(chkMoudle.chkPhone()){
        	var refTime = null;
        	clearTimeout(refTime);
        	var count = 30000 / 1000;
        	var fun = function() {
        		var o = document.getElementById('refTimer');
        		if (o) {
        			o.innerHTML = count;
        			count--
        		}
        		//debugger;                        
        		if (count > 0) {
        			refTime = setTimeout(fun, 1000);
        			//$("#getvcodeClick").unbind("click");
        		} else {
        			$("#getvcodeClick").removeClass("huoqujieshu").addClass("huoqu").html("").bind("click", function() { master.getVcode(sendType) });
        		}
        	};
        	fun();
            $.post("account/getCode", { telephone: phone, st: sendType }, function(data) {
                //debugger;
                //if (data == 1) {
                    styleSwitch("#chktxtMobi", "发送成功", chkResult.Correct);
                //} else {
                //    styleSwitch("#chktxtMobi", "验证码发送失败", chkResult.Error);
                //}
            });
        }
    },
    sendPassFunc: function(sendType) {

        //alert("密码修改成功！");
        //$(".regForm div").val(this.defaultValue);
        //alert($(".regForm #chktxtPwd").val($(".regForm #chktxtPwd")[0].defaultHtml));
        //debugger;
        //var cls_mobi = $.trim(document.getElementById("chktxtMobi").className);
        //var cls_code = $.trim(document.getElementById("chktxtVCode").className);
        //var cls_pwd = $.trim(document.getElementById("chktxtPwd").className);

        //var array = [cls_mobi, cls_code, cls_pwd, "checkOK"];
        //var json = {};
        //for (var i = 0; i < array.length; i++) {
          //  json[array[i]] = json[array[i]] ? json[array[i]] + 1 : 1;
        //}
        //var counter = 0;
        //for (var e in json) {
          //  counter++;
        //}
        if(chkMoudle.chkPhone(sendType)&&chkMoudle.chkCode()&&chkMoudle.checkPass()){
        	var uiMobile = $("#txtMobi").val();
        	var code = $("#txtVCode").val();
        	var uiPassword = $("#txtPwd").val();
            $.ajax({
                type: "POST",
                url: "account/sendPass",
                //dataType: "json",
                data: "uiMobile=" + uiMobile + "&code=" + code + "&uiPassword="+uiPassword,
                beforeSend: function() {
                    //$("#loader").show();
                },
                success: function(data) {
                    //$("#loader").hide();
                    if (data=="success") {
                        ttalert("succeed", "密码修改成功！"); //window.location.reload(); //window.location.href("Default.htm");
                        //$(".regForm").val(this.defaultValue);
                        //debugger;
                        aftsubmit();
                    } else if (data=="null"){
                    	ttalert("error", "还未获取验证码");
                    } else if (data=="error"){
                    	ttalert("error", "密码修改出错~");
                    }else {
                        ttalert("error", "验证码错误")
                    }
                }
            });
        } else {
            //ttalert("error", "修改密码失败");
        }

    },
    submitMessage: function() {
        var cls_mobi = $.trim(document.getElementById("chktxtMobi").className);
        var cls_uname = $.trim(document.getElementById("chktxtName").className);
        var cls_email = $.trim(document.getElementById("chktxtEmail").className);
        var cls_content = $.trim(document.getElementById("chktxtContent").className);
        //debugger;
        var array = [cls_mobi, cls_uname, cls_email, cls_content, "checkOK"];
        var json = {};
        for (var i = 0; i < array.length; i++) {
            json[array[i]] = json[array[i]] ? json[array[i]] + 1 : 1;
        }
        var counter = 0;
        for (var e in json) {
            counter++;
        }
        //debugger;
        if (counter == 1) {
            var name = $("#txtName").val();
            var mobi = $("#txtMobi").val();
            var email = $("#txtEmail").val();
            var content = $("#txtContent").val();

            $.ajax({
                type: "POST",
                url: "ajax/ajaxMessagerHandler.ashx",
                dataType: "json",
                data: "n=" + name + "&p=" + mobi + "&e=" + email + "&c=" + content,
                beforeSend: function() {
                    //$("#loader").show();
                },
                success: function(data, textStatus) {
                    //$("#loader").hide();
                    //debugger;
                    if (data.result == 0) {
                        ttalert("error", "提交失败");
                    } else if (data.result == 1) {
                        ttalert("succeed", "提交成功！"); //window.location.href = "Default.htm";
                        //window.location.reload();
                        aftsubmit();
                        $("textarea").val("");
                    }
                }
            });
        }
    },
    searchFunc: function(micode) {//货单查询功能
        if (markersArray) {
            for (i in markersArray) {
                markersArray[i].setMap(null);
            }
            markersArray.length = 0;
        }

        if (micode == "") {
            $("#err").show();
            $("#err").html("请输入货单号");
            $("#tblRes").hide();
        } else {
            $("#err").html("");
            $("#err").hide();
            $.ajax({
                type: "POST",
                dataType: "json",
                url: 'trackGoods.htm',
                data: "mi=" + micode,
                beforeSend: function() {
                    $("#tblRes").hide();
                    $("#loading").show();
                },
                success: function(json) {
                    $("#tblRes").show();
                    $("#loading").hide();
                    $("#tblRes").html("");
                    $("#err").hide();
                    //debugger;
                    var tbody = "";
                    if (json != 0) {
                        var resData = json.miList;
                        //debugger;
                        var latlngbound = new google.maps.LatLngBounds();
                        var len = eval(resData).length;

                        if (len > 1) {
                            for (var i = 0; i < len; i++) {
                                var slat = parseInt(resData[i].VI_LAT) / 1000000;
                                var slng = parseInt(resData[i].VI_LNG) / 1000000;
                                if (slat != 0 && slng != 0 && !isNaN(slat) && !isNaN(slng)) {
                                    latlngbound.extend(new google.maps.LatLng(slat, slng));
                                }
                            }
                            var center = latlngbound.getCenter();
                            if (latlngbound != null)
                                map.setCenter(center);
                            dwJSON(resData, len);
                        } else {
                            if (isNaN(parseInt(resData[0].VI_LAT) / 1000000) || isNaN(parseInt(resData[0].VI_LNG) / 1000000)) {
                                ttalert("error", "该货单承运车辆位置不明确，暂时无法提供定位！<BR />请稍后重试...");
                                //return;
                            } else {
                                dwJSON(resData);
                                map.setCenter(new google.maps.LatLng(parseInt(resData[0].VI_LAT) / 1000000, parseInt(resData[0].VI_LNG) / 1000000));
                            }
                        }

                    } else {
                        tbody = "<p style='color:#ff0000; margin-top:10px; '>未查询到相关数据</p>";
                        $("#tblRes").html(tbody);
                    }
                    //$("#tblRes").html(tbody);
                }
            });
        }
    }
};

function dwJSON(resData,count) {
    $.each(resData, function(i, n) {
        var trs = "";
        var mcode = n.MI_CODE;
        var mlic = n.VI_LICENSE;
        var pos = n.VI_PROVINCE + n.VI_CITY + n.VI_AREA;
        var speed = n.VI_SPEED;
        var lxr = n.VI_IS_PUBLIC == "0" ? "该车辆未公开联系人" : n.VI_PUBLIC_PERSON;
        var lxdh = n.VI_IS_PUBLIC == 0 ? "该车辆未公开联系电话" : n.VI_PUBLIC_MOBILE;
        var lng = parseInt(n.VI_LNG) / 1000000;
        var lat = parseInt(n.VI_LAT) / 1000000;
        var time = n.VI_GPSTIME;

        //debugger;
        document.getElementById("ifrAddr").src = "p.html?lat=" + lat + "&lng=" + lng;

        //        setTimeout(function() {
        //            if (art.dialog.data('test')) {
        //                pos = art.dialog.data('test');
        //            }
        //        }, 1000);
        //pos = document.frames['ifrAddr'].contentWindow.addr;
        //pos = GetIframeInnerHtml(document.all.ifrAddr);
        //pos = document.all.ifrAddr.contentWindow.addr;

        var guid = n.VI_GUID;
        var weather = "";
        weather = n.WI_MEMO != "" ? n.WI_MEMO + "，" + n.WI_AIR + "，" + n.WI_WIND : "晴";
        //var dw = "<p><a href=javascript:createMark(" + lat + "," + lng + "," + msg + ")>地图定位</a></p>";
        //trs += "<p>单号：" + mcode + "</p><p>承运车辆：" + mlic + "</p><p>当前位置：" + pos + "</p><p>速度：" + speed + "km/h</p><p>天气：" + weather + "</p><p>联系人:" + lxr + "</p><p>联系电话：" + lxdh + "</p>";
        //tbody += trs;

        var key = getReqKey();
        //_.ajax.jsonp("http://localhost:3730/interface/default.htm" + "?id=10&code=" + key + "&type=googleLocalSearch" + "&lat=" + lat + "&lng=" + lng + "&callback=addrCallback");
        //var detailPos = getdetailAddr();
        //var detailPos = rr;
        //pos = detailPos == "" ? pos : detailPos;
        var content = "<p>单号：" + mcode + "</p><p>承运车辆：" + mlic + "</p><p>当前位置：" + pos + "</p><p>速度：" + speed + "km/h</p><p>天气：" + weather + "</p><p>联系人:" + lxr + "</p><p>联系电话：" + lxdh + "</p>";
        var active = n.VI_ACTIVESTATE;

        createMark(lat, lng, content, count);
    });
}

var rr = "";
function addrCallback(obj) {
    //debugger;
    if (obj.result == 0) {
        rr = obj.msg;
    }
}

function getdetailAddr(lat,lng) {
    var req = "http://localhost:3730/interface/default.htm";
    var key = getReqKey();
    var retAddr;
    
    //debugger;
    $.ajax({
        type: "POST",
        url: req,
        async: false,
        data: { id: 10, code: key, type: "googleLocalSearch", lat: lat, lng: lng },
        dataType: "jsonp",
        cache: false,
        success: function(data, textStatus) {
            debugger;
            if (data.result == 0) {
                retAddr = data.msg;
            }
        }
    });
    if (retAddr != null) return retAddr;
    else return "";
}

function getReqKey() {
    var retKey;
    $.ajax({
        type: "POST",
        url: window.location,
        async: false,
        data: { getKey: 10 },
        cache: false,
        success: function(msg) {
            if (msg) {
                retKey = msg;
            }
        }
    });
    if (retKey != null) return retKey;
    else return "";
}

function GetIframeInnerHtml(objIFrame) {
    var iFrameHTML = "";
    if (objIFrame.contentDocument) {
        // For NS6
        iFrameHTML = objIFrame.contentDocument.innerHTML;
    }
    else if (objIFrame.contentWindow) {
        // For IE5.5 and IE6
        iFrameHTML = objIFrame.contentWindow.document.body.innerHTML;
    }
    else if (objIFrame.document) {
        // For IE5
        iFrameHTML = objIFrame.document.body.innerHTML;
    }

    return iFrameHTML;
} 


var map;
var markersArray = [];

function createMark(lat, lng, msg,count) {
    if (isNaN(lat) || isNaN(lng)) {
        //alert("承运车辆位置不明确，暂时无法定位！\r\n请稍后重试...");
        return ;
    } else {
        var point = new google.maps.LatLng(lat, lng);
        //map.setCenter(point);
        var marker = new google.maps.Marker({
            position: point,
            map: map
        });
        markersArray.push(marker);
        var infowindow = new google.maps.InfoWindow({
            content: msg,
            size: new google.maps.Size(50, 50)
        });
        google.maps.event.addListener(marker, 'click', function() {
            infowindow.open(map, marker);
        });
        $("#tblRes").hide();
        //debugger;
        if (typeof count == "undefined") infowindow.open(map, marker);
    }
}

function gzVeh(guid) {//此功能已经除去
    $.post(window.location.href, { gid: guid }, function(data) {
        if (data == -2) {
            //window.location.href = "../Login.htm";
            alert("您还没有登录，请先登录！");
            $("#txtCode").val("");
            $("#account").focus();
        } else if (data == -1) {
            alert("对不起，您已经提交过申请或者您已经关注了该车，请确认！");
        } else if (data == 9) {
            alert("不能将自己作为关注用户，请重新输入！");
        } else if (data == 10) {
            alert("关注车辆已经超出您的关注上限，您可以删除一些关注车辆，或者购买服务！");
        } else if (data == 11) {
            alert("您的服务期限已经到了，请重新购买服务！");
        } else if (data == 12) {
            alert("已购买服务用户，您好！您的关注车辆已经超出您的关注上限，您可以删除一些关注车辆，或者再购买服务！");
        } else if (data == 13) {
            alert("对不起，该货单的承运车不存在！");
        } else if (data == 1) {
            alert("申请关注成功！");
        } else if (data == 0) {
            alert("处理超时，请稍后重试...");
        } else {
            alert("对不起，申请失败！");
        }
    });
    $("#tblRes").hide();
}

var getType = function(obj) {
    var _toString = Object.prototype.toString, undefined;
    return obj === null ? "Null" :
        obj === undefined ? "Undefined" :
        _toString.call(obj).slice(8, -1);
};

function sleep(numberMillis) {
    var now = new Date();
    var exitTime = now.getTime() + numberMillis;
    while (true) {
        now = new Date();
        if (now.getTime() > exitTime) return;
    }
}

//按钮样式
function initBtnstyle() {
    $("#login").hover(
            function() {
                $(this).removeClass("btnOff").addClass("btnOn");
            },
            function() {
                $(this).removeClass("btnOn").addClass("btnOff");
            }
    );
    $("#reg").hover(
            function() {
                $(this).removeClass("btnOff").addClass("btnOn");
            },
            function() {
                $(this).removeClass("btnOn").addClass("btnOff");
            }
    );
}



// 表单验证(控件id，控件值)
var check = function(input, val) {
    //alert(input);
    //debugger;
    if (val === '' || val == document.getElementById(input).defaultValue) {
        inputError(input);
        //if (input != "txtVCode")
        //$("#" + input).focus();
        if (input == "showPwd") {
            $("#password").blur();
        }
        return false;
    } else {
        return true;
    };
}

// 输入错误提示
var inputError = function(input) {
    clearTimeout(inputError.timer);
    var num = 0;
    //debugger
    var fn = function() {
        inputError.timer = setTimeout(function() {
            //debugger;
            var className = document.getElementById(input).className;
            document.getElementById(input).className = document.getElementById(input).className === '' ? 'login-form-error' : '';
            if (num === 5) {
                document.getElementById(input).className === '';
            } else {
                fn(num++);
            };
        }, 150);
    };
    fn();
}

function aftsubmit() {
    var iptErr = $(".regForm input");
    for (var i = 0; i < iptErr.length; i++) {
        $("#" + iptErr[i].id).val(iptErr[i].defaultValue);
        if (iptErr[i].defaultValue) {            
            $("#" + iptErr[i].id).attr("style", "color:#999");
        }
    }
    var divErr = elemtsdata.div;
    for (var i = 0; i < divErr.length; i++) {
        $("#" + divErr[i].id).html(divErr[i].html);
        $("#" + divErr[i].id).attr("class", divErr[i].cls);
    }
}

function removeCls() {
    var txtVCodeCls = "";
    var txtNameCls = "";
    var txtPwdCls = "";
    var txtRPwdCls = "";
    var txtEmailCls = "";
    var txtMobiCls = "";
    var txtContCls = "";
    var txtCpn = "";
    var txtTlp = "";
    var txtAds = "";
    
    if (document.getElementById("txtVCode"))
        txtVCodeCls = document.getElementById("txtVCode").className;
    if (document.getElementById("txtName"))
        txtNameCls = document.getElementById("txtName").className;
    if (document.getElementById("txtPwd"))
        txtPwdCls = document.getElementById("txtPwd").className;
    if (document.getElementById("txtRPwd"))
        txtRPwdCls = document.getElementById("txtRPwd").className;
    if (document.getElementById("txtEmail"))
        txtEmailCls = document.getElementById("txtEmail").className;
    if (document.getElementById("txtMobi"))
        txtMobiCls = document.getElementById("txtMobi").className;
    if (document.getElementById("txtCpn"))
        txtContCls = document.getElementById("txtCpn").className;
    if (document.getElementById("txtTlp"))
        txtContCls = document.getElementById("txtTlp").className;
    if (document.getElementById("txtAds"))
        txtContCls = document.getElementById("txtAds").className;
    
    if (txtVCodeCls == "login-form-error")
        document.getElementById("txtVCode").className = "";
    if (txtNameCls == "login-form-error")
        document.getElementById("txtName").className = "";
    if (txtPwdCls == "login-form-error")
        document.getElementById("txtPwd").className = "";
    if (txtRPwdCls == "login-form-error")
        document.getElementById("txtRPwd").className = "";
    if (txtEmailCls == "login-form-error")
        document.getElementById("txtEmail").className = "";
    if (txtMobiCls == "login-form-error")
        document.getElementById("txtMobi").className = "";
    if (txtCpn == "login-form-error")
        document.getElementById("txtCpn").className = "";
    if (txtTlp == "login-form-error")
        document.getElementById("txtTlp").className = "";
    if (txtAds == "login-form-error")
        document.getElementById("txtAds").className = "";
}


//输出出错提示
function styleSwitch(container, msg, res) {
    //debugger;
    if (msg != "") {
        $(container).html(msg);
    }
    if (typeof res != "undefined") {
        if (res == chkResult.Error) {
            $(container).removeClass("checkCell").removeClass("checkOK").removeClass("rightCell").addClass("checkNO");
        } else if (res == chkResult.Correct) {
            sRes = 1;
            $(container).removeClass("checkCell").removeClass("checkNO").removeClass("rightCell").addClass("checkOK");
        }
    } else {
        $(container).removeClass("checkCell").removeClass("checkOK").removeClass("rightCell").addClass("checkNO");
    }
}

//type:succeed/error
function ttalert(type, msg) {
    art.dialog({ content: msg, lock: 'true',  icon: type });
}


function addCookie(objName, objValue, objHours) {
    var str = objName + "=" + escape(objValue);
    if (objHours > 0) {//为0时不设定过期时间，浏览器关闭时cookie自动消失
        var date = new Date();
        var ms = objHours * 3600 * 1000;
        date.setTime(date.getTime() + ms);
        str += "; expires=" + date.toGMTString();
    }
    document.cookie = str;
}

function getCookie(objName) {
    var arrStr = document.cookie.split("; ");
    var res = "";
    for (var i = 0; i < arrStr.length; i++) {
        var temp = arrStr[i].split("=");
        if (temp[0] == objName) {
            res = unescape(temp[1]);
        }
    }
    return res;
}
