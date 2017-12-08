//获取当前时间
function Gettime()
{
    var now=new Date;
    var vYear = now.getFullYear();
    var vMon = now.getMonth() + 1;
    var vDay = now.getDate();
    var vHour = now.getHours();
    var vMinute = now.getMinutes();
    var vSecond = now.getSeconds();
    vMon = vMon<10 ? "0" + vMon : vMon;
    vDay = vDay<10 ? "0" + vDay : vDay;
    vHour = vHour<10 ? "0" + vHour : vHour;
    vMinute = vMinute<10 ? "0" + vMinute : vMinute;
    vSecond = vSecond<10 ? "0" + vSecond : vSecond;
    return vYear + "-" + vMon + "-" + vDay + " " + vHour + ":" + vMinute + ":" + vSecond;
}
//判断是否选择列表中的checkbox以及确认
function listchoose(a,b,divId){
    var chkList = $("#"+divId).find('input[type=checkbox]');       
    if(chkList.length>0){
        var tmpList = "";
        for(i=0;i<chkList.length;i++){
            if(chkList[i].checked == true){
                tmpList = tmpList + chkList[i].value + ",";
            }
        }
        tmpList = tmpList.substring(0,tmpList.length-1);                
        if(tmpList.length>0){
            if(confirm(a)){             //确认删除**么？
                return true;
            }else{
                return false;
            }
        }else{
            alert(b);                  //请选择需要删除的**！
            return false;
        }
    }else{
    alert(b);       //add 表中没有数据的时候 点按钮也给提示
        return false;
    }
}
//字符串验证
function str(field,errorbox,r,min,max,title) {
	var str = field.val();
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",title+'不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    }
	}
	if (str != "")
	{
	    var reg = /^[0-9a-zA-Z_\-\u0391-\uFFE5]+$/;
	    if (str.length > max)
	    {
		    errormsg(errorbox,"wrong",title+'的长度不能超过'+max+'位字符！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	    else if(reg.test(str)==false)
	    {
	        errormsg(errorbox,"wrong",title+'只能由中文、字母、数字、横线以及下划线组成！');
	        errorbox.className = "NotPassCheck";
	        button_check();
		    return false;
	    }
	    else
	    {
		    errormsg(errorbox,"correct",'');
		    errorbox.className = "PassCheck";
		    button_check();
		    return true;
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}

//长度验证
function strlength(field,errorbox,r,min,max,title) {
	var str = field.val();
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",title+'不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    }
	}
	if (str != "")
	{
	    if (str.length > max)
	    {
		    errormsg(errorbox,"wrong",title+'的长度不能超过'+max+'位字符！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    }
	    else
	    {
		    errormsg(errorbox,"correct",'');
		    errorbox.className = "PassCheck";
		    button_check();
		    return true;
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}
///验证密码合法性：无强度提示  add by zhengjunzhe @ 2011-12-13
function spassword(field,errorbox,r,min,max) {
	var str = field.val().replace(/^\s+|\s+$/g,"");


	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",'密码不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	}
	if (str != "")
	{
	    var reg = /[a-zA-Z0-9_\-\!\#\$\%\^\&\*\.\~\@\(\)\+\=\?\/\>\<\`]$/; //匹配英文字母、数字以及(-_)和特殊字符  @update by zhengjunzhe@2011-10-18
	    var words = /^[\s\S]*$/;          //匹配任意字符
	    var strInt = /^[\s\S]{6,12}$/;          //匹配6-9个纯数字
	    var strRou = /^((\d+)|([a-zA-Z]+)|([^a-zA-Z0-9])){6,}$/;         //匹配弱
	    var strChar = /^(\d+|[a-zA-Z]+|[\u4E00-\u9FA5]+){9,11}$/;         //匹配字符，数字，特殊字符
	    var strDS = /^(\d+|[a-zA-Z]+|[\u4E00-\u9FA5]+){12}$/;          //匹配较强，9位以上纯数字，6-9的字符，特殊字符
	    if (reg.test(str)==false || str.length > max || str.length < min) 
	    {
		    errormsg(errorbox,"wrong",'密码只能由'+min+'-'+max+'位字母、数字、下划线（包含特殊字符）组成，字母区分大小写！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	    else 
	    {
		    errormsg(errorbox,"correct",'');
		    errorbox.className = "PassCheck";
		    button_check();
		    return true;
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}


//密码合法性验证
function password(field,errorbox,r,min,max) {
	var str = field.val().replace(/^\s+|\s+$/g,"");
	var csint = checkStrong(str);
	switch(csint) {
	case 0:
		$("#passChar").html("");
		$("#passCheck").removeClass(getClass("passCheck"));
	    $("#passCheck").addClass("passCheck1");
		break;
	case 1:
		$("#passChar").html("弱");
		$("#passCheck").removeClass(getClass("passCheck"));
	    $("#passCheck").addClass("passCheck2");
		break;
	case 2:
		$("#passChar").html("较强");
		$("#passCheck").removeClass(getClass("passCheck"));
	    $("#passCheck").addClass("passCheck3");
		break;
	case 3:
		$("#passChar").html("强");
		$("#passCheck").removeClass(getClass("passCheck"));
	    $("#passCheck").addClass("passCheck4");
		break;
    case 4:		
		$("#passChar").html("强");
		$("#passCheck").removeClass(getClass("passCheck"));
	    $("#passCheck").addClass("passCheck4");
		break;
	}
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",'密码不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	}
	if (str != "")
	{
	    var reg = /[a-zA-Z0-9_\-\!\#\$\%\^\&\*\.\~\@\(\)\+\=\?\/\>\<\`]$/; //匹配英文字母、数字以及(-_)和特殊字符  @update by zhengjunzhe@2011-10-18
	    var words = /^[\s\S]*$/;          //匹配任意字符
	    var strInt = /^[\s\S]{6,12}$/;          //匹配6-9个纯数字
	    var strRou = /^((\d+)|([a-zA-Z]+)|([^a-zA-Z0-9])){6,}$/;         //匹配弱
	    var strChar = /^(\d+|[a-zA-Z]+|[\u4E00-\u9FA5]+){9,11}$/;         //匹配字符，数字，特殊字符
	    var strDS = /^(\d+|[a-zA-Z]+|[\u4E00-\u9FA5]+){12}$/;          //匹配较强，9位以上纯数字，6-9的字符，特殊字符
	    if (reg.test(str)==false || str.length > max || str.length < min) 
	    {
		    errormsg(errorbox,"wrong",'密码只能由'+min+'-'+max+'位字母、数字、下划线（包含特殊字符）组成，字母区分大小写！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	    else 
	    {
		    errormsg(errorbox,"correct",'');
		    errorbox.className = "PassCheck";
		    button_check();
		    return true;
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}

//重复密码验证
function repwd(field,errorbox,pwd,r) {
	if (field.val()!="" || r) 
	{
	    if (field.val().replace(/^\s+|\s+$/g,"")!=pwd.val().replace(/^\s+|\s+$/g,"")|| field.val().replace(/^\s+|\s+$/g,"")=="") 
	    {
		    errormsg(errorbox,"wrong",'密码前后输入不一致！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	    else 
	    {
		    errormsg(errorbox,"correct",'');
		    errorbox.className = "PassCheck";
		    button_check();
		    return true;
	    }
	}
}

//密码正确性验证
function existpassword(field,errorbox,mobile,r,min,max) {
	var str = field.val();
	str=str.replace(/^\s+|\s+$/g,"");//去除两头空格  add by zhengjunzhe 2012-04-09
	var strMobile = mobile.val();
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",'密码不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	}
	
	if (str != "")
	{
	    var reg = /[a-zA-Z0-9_\-\!\#\$\%\^\&\*\.\~\@\(\)\+\=\?\/\>\<\`]$/;     //匹配英文字母、数字以及(-_)和特殊字符 @update by zhengjunzhe 2011-10-18
	    var words = /^[\s\S]*$/;          //匹配任意字符
	    var strInt = /^[\s\S]{6,12}$/;          //匹配6-9个纯数字
	    var strRou = /^((\d+)|([a-zA-Z]+)|([^a-zA-Z0-9])){6,}$/;         //匹配弱
	    var strChar = /^(\d+|[a-zA-Z]+|[\u4E00-\u9FA5]+){9,11}$/;         //匹配字符，数字，特殊字符
	    var strDS = /^(\d+|[a-zA-Z]+|[\u4E00-\u9FA5]+){12}$/;          //匹配较强，9位以上纯数字，6-9的字符，特殊字符
	    if (reg.test(str)==false || str.length > max || str.length < min) 
	    {
		    errormsg(errorbox,"wrong",'密码只能由'+min+'-'+max+'位字母、数字、下划线（包含特殊字符）组成，字母区分大小写！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	    else 
	    {
	        var time = (Gettime());
	        $.get("changePwd.htm",{s:'1',password:str,mobile:strMobile,time:time},function(strR){
	            if(strR=="2")
	            {
	                errormsg(errorbox,"correct",'');
	                errorbox.className = "PassCheck";
	                button_check();
	                return true;
	            }
	            else
	            {
	                errormsg(errorbox,"wrong",'密码输入错误！');
	                errorbox.className = "NotPassCheck";
	                button_check();
	                return false;
	            }   
	        });
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}

//手机号码合法性验证（登录名）
function mobile(field,errorbox,r) {
	var str = field.val();
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",'手机号码不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	}
	if (str != "")
	{
	    var reg = /^((\(\d{2,3}\))|(\d{3}\-))?((13\d{9})|(15\d{9})|(14\d{9})|(18\d{9}))$/;
	    if (reg.test(str)==false) 
	    {
		    errormsg(errorbox,"wrong",'手机号码填写错误！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	    else
	    {
	        var time = (Gettime());
	        $.get(PlatFormUrl+"Login.htm",{s:'1',mobile:str,time:time},function(strR){
	            if(strR=="0")
	            {
	                errormsg(errorbox,"correct",'');
	                errorbox.className = "PassCheck";
	                button_check();
	                return true;
	            }
	            else
	            {
	                errormsg(errorbox,"wrong",'手机号码已存在！');
	                errorbox.className = "NotPassCheck";
	                button_check();
	                return false;
	            }   
	        });  
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}

//手机号码合法性验证
function mobileonly(field,errorbox,r) {
	var str = field.val();
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",'手机号码不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	}
	if (str != "")
	{
	    var reg = /^((\(\d{2,3}\))|(\d{3}\-))?((13\d{9})|(15\d{9})|(14\d{9})|(18\d{9}))$/;
	    if (reg.test(str)==false) 
	    {
		    errormsg(errorbox,"wrong",'手机号码填写错误！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	    else
	    {
	        errormsg(errorbox,"correct",'');
            errorbox.className = "PassCheck";
            button_check();
            return true;
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}

//sim卡号合法性验证 add by zhengjunzhe @ 2011-12-05
function sim(field,errorbox,r)
{var str = field.val();
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",'sim卡号不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	}
	if (str != "")
	{
	    var reg = /^((\(\d{2,3}\))|(\d{3}\-))?((13\d{9})|(15\d{9})|(14\d{9})|(18\d{9}))$/;
	    if (reg.test(str)==false) 
	    {
		    errormsg(errorbox,"wrong",'sim卡号格式应为手机号码！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	    else
	    {
	        errormsg(errorbox,"correct",'');
            errorbox.className = "PassCheck";
            button_check();
            return true;
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}



}

//电话号码合法性验证
function phone(field,errorbox,r) {
	var str = field.val();
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",'电话号码不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	}
	if (str != "")
	{
	    var reg = /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{4,7}(\-\d{1,4})?$/;
	    if (reg.test(str)==false) 
	    {
		    errormsg(errorbox,"wrong",'电话号码格式不正确！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	    else 
	    {
		    errormsg(errorbox,"correct",'');
		    errorbox.className = "PassCheck";
		    button_check();
		    return true;
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}

//Email地址合法性验证
function email(field,errorbox,r) {
	var str = field.val();
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",'邮箱不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	}
	if (str != "")
	{
	    var reg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
	    if (reg.test(str)==false) 
	    {
		    errormsg(errorbox,"wrong",'邮箱填写错误！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	    else 
	    {
		    errormsg(errorbox,"correct",'');
		    errorbox.className = "PassCheck";
		    button_check();
		    return true;
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}

//真实姓名合法性验证
function realname(field,errorbox,r) {
	var str = field.val();
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",'真实姓名不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	}
	if (str != "")
	{
	    var reg = /^[\u4e00-\u9fa5]+$/;
	    if (reg.test(str)==false || str.length > 10 || str.length < 2) 
	    {
		    errormsg(errorbox,"wrong",'真实姓名只能由2-10位汉字组成！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	    else 
	    {
		    errormsg(errorbox,"correct",'');
		    errorbox.className = "PassCheck";
		    button_check();
		    return true;
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}

//验证码验证
function code(field,errorbox,r) {
	var str = field.val();
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",'验证码不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    } 
	}
	if (str != "")
	{
	    if (str.length!=4) 
	    {
		    errormsg(errorbox,"wrong",'验证码填写错误！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    }
	    else
	    {
	        var time = (Gettime());
	        $.get(PlatFormUrl+"Login.htm",{s:'2',code:str,time:time},function(strR){
	            if(strR=="1")
	            {
	                errormsg(errorbox,"correct",'');
	                errorbox.className = "PassCheck";
	                button_check();
	                return true;
	            }
	            else
	            {
	                errormsg(errorbox,"wrong",'验证码填写错误！');
	                errorbox.className = "NotPassCheck";
	                button_check();
	                return false;
	            }   
	        });  
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}
//输入分钟验证 只能在1~1440之间
function minutes(field,errorbox,r,title)
{
    var str=field.val();
    if(r==1)
    {
        if(str.length==0||str=="")
        {
            errormsg(errorbox,"wrong",title+"不能为空！");
            errorbox.className="NotPassCheck";
            return false;
        }
    }
    if(str!="")
    {
        var reg = /^\d{1,4}$/;
        if(reg.test(str)==false)
        {
            errormsg(errorbox,"wrong",title+'只能是数字，且在1~1440之间');
            errorbox.className = "NotPassCheck";
            button_check();
	        return false;
        }
       if(str>1440||str<1)
	    {
		        errormsg(errorbox,"wrong",title+'只能是数字，且在1~1440之间');
		        errorbox.className="NotPassCheck";
		        return false;
		 
	    }
	    else
	    {
		    errormsg(errorbox,"correct",'填写正确');
		    errorbox.className = "PassCheck";
		    button_check();
		    return true;
	    }
    }
    else
	    {
	        errormsg(errorbox,"normal",'');
	        errorbox.className = "PassCheck";
	        return true;
        }
    
}
//数字类型验证
function number(field,errorbox,r,min,max,title) {
    var str = field.val();
    if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",title+'不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    }
	}
	if(r == 2)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",title+'不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    }
	}
    if (str != "")
	{
	    if(min==2 && max==2)
	    {
	        var reg = /^\d{1,2}(\.\d{1,2})?$/;
	        if(reg.test(str)==false)
	        {
	            errormsg(errorbox,"wrong",title+'格式错误，只能在0~99.99之间！');
	            errorbox.className = "NotPassCheck";
	            button_check();
		        return false;
	        }
	        else
	        {
		        errormsg(errorbox,"correct",'');
		        errorbox.className = "PassCheck";
		        button_check();
		        return true;
	        }
	    }  
	    else if(min==0&&max==333)
	    {
	        var reg=/^\d{1,2}$/;
	        if(reg.test(str)==false)
	        {
	            errormsg(errorbox,"wrong",title+'需为1~3之间的整数！');
	            errorbox.className="NotPassCheck";
	            button_check();
	            return false;
	        }
	        else if(str>0&&str<4)
	        {
	            errormsg(errorbox,"correct",'');
	            errorbox.className="PassCheck";
	            button_check();
	            return true;
	        }
	        else
	        {
	            errormsg(errorbox,"wrong",title+'需为1~3之间的整数！');
	            errorbox.className="NotPassCheck";
	            button_check();
	            return false;
	        }
	    }
	    else if(min==0&&max==10)
	    {
	        var reg = /^\d{1,2}$/;
	        if(reg.test(str)==false)
	        {
	            errormsg(errorbox,"wrong",title+'需为1~10之间的整数！');
	            errorbox.className = "NotPassCheck";
	            button_check();
		        return false;
	        }
	        else if(str>0&&str<11)
	        {
		        errormsg(errorbox,"correct",'');
		        errorbox.className = "PassCheck";
		        button_check();
		        return true;
	        }
	        else
	        {
	            errormsg(errorbox,"wrong",title+'需为1~10之间的整数！');
	            errorbox.className = "NotPassCheck";
	            button_check();
		        return false;
	        }
	    }
	    else if(min==1 && max==3)
	    {
	        var reg = /^\d{1,3}(\.\d{1,1})?$/;
	        if(reg.test(str)==false)
	        {
	            errormsg(errorbox,"wrong",title+'格式错误，只能在0~999.9之间！');
	            errorbox.className = "NotPassCheck";
	            button_check();
		        return false;
	        }
	        else
	        {
		        errormsg(errorbox,"correct",'');
		        errorbox.className = "PassCheck";
		        button_check();
		        return true;
	        }
	    }
	    else if(min==0 && max==4)
	    {
	        var reg = /^\d{1,4}$/;
	        if(reg.test(str)==false)
	        {
	            errormsg(errorbox,"wrong",title+'格式错误，只能在0~9999之间的整数！');
	            errorbox.className = "NotPassCheck";
	            button_check();
		        return false;
	        }
	        else
	        {
		        errormsg(errorbox,"correct",'');
		        errorbox.className = "PassCheck";
		        button_check();
		        return true;
	        }
	    }
	    else if(min==0 && max==3)
	    {
	        var reg = /^\d{1,3}$/;
	        if(reg.test(str)==false)
	        {
	            errormsg(errorbox,"wrong",title+'格式错误，只能在0~999之间的整数！');
	            errorbox.className = "NotPassCheck";
	            button_check();
		        return false;
	        }
	        else
	        {
		        errormsg(errorbox,"correct",'');
		        errorbox.className = "PassCheck";
		        button_check();
		        return true;
	        }
	    }
	    else if(min==0 && max==2)
	    {
	        var reg = /^\d{1,2}$/;
	        if(reg.test(str)==false)
	        {
	            if(r == 2)
	            {
	                errormsg(errorbox,"wrong",title+'格式错误，只能在1~99之间的整数！');
	                errorbox.className = "NotPassCheck";
	                button_check();
		            return false;
	            }
	            else
	            {
	                errormsg(errorbox,"wrong",title+'格式错误，只能在0~99之间的整数！');
	                errorbox.className = "NotPassCheck";
	                button_check();
		            return false;
	            } 
	        }
	        else
	        {
	            if(r == 2 && str == "0")
	            {
	                errormsg(errorbox,"wrong",title+'格式错误，只能在1~99之间的整数！');
	                errorbox.className = "NotPassCheck";
	                button_check();
		            return false;
	            }
                errormsg(errorbox,"correct",'');
	            errorbox.className = "PassCheck";
	            button_check();
	            return true;     
	        }
	    }
	    else if(min==2 && max==4)
	    {
	        var reg = /^\d{1,4}(\.\d{1,2})?$/;
	        if(reg.test(str)==false)
	        {
	            errormsg(errorbox,"wrong",title+'格式错误，只能在0~9999.99之间！');
	            errorbox.className = "NotPassCheck";
	            button_check();
		        return false;
	        }
	        else
	        {
		        errormsg(errorbox,"correct",'');
		        errorbox.className = "PassCheck";
		        button_check();
		        return true;
	        }
	    }
	}
	else
	{
	    errormsg(errorbox,"normal",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}

//身份证号码合法性验证
function idnum(field,errorbox,r) {
	if (field.val()!=""||r) {
	var isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
	var isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
	if (isIDCard1.test(field.val())==false||isIDCard2.test(field.val())==false) {
		errormsg(errorbox,"wrong");
		return false;
	} else {
		errormsg(errorbox,"correct");
		return true;
	}
	}
}

//永远正确验证
function correct(field,errorbox,r) {
	errormsg(errorbox,"correct");
	return true;
}

//永远错误验证
function wrong(field,errorbox,r) {
	errormsg(errorbox,"wrong");
	return false;
}

//空值验证
function empty(field,errorbox,r,title) {
	var str = field.val();
	if(r == 1)
	{
	    if (str.length == 0 || str == "")
	    {
		    errormsg(errorbox,"wrong",title+'不能为空！');
		    errorbox.className = "NotPassCheck";
		    button_check();
		    return false;
	    }
	}
	else
	{
	    errormsg(errorbox,"correct",'');
	    errorbox.className = "PassCheck";
	    button_check();
	    return true;
	}
}


//通用提示信息
function errormsg(id,method,content) {
	switch(method) {
		case "wrong":
			id.innerHTML='<span class=\"wrong sprite\">'+content+'</span>';
			break;
		case "correct":
			id.innerHTML='<span class=\"correct sprite\">填写正确！</span>';
			break;
		case "normal":
			id.innerHTML='';
			break;
	}
}
//鼠标获得单个input焦点时
function focusinput(id,box,txt) {
    var id = $("[id$="+id+"]");
	var bx = document.getElementById(box);
	var tr = bx.parentNode;
	if(id.val()=="")
	{
	    bx.innerHTML='<span class=\"tip sprite\">'+txt+'</span>';
	}
	tr.style.cssText='background:#DBEDFF';
	
}
//鼠标离开单个input焦点时
function blurinput(id,box,method,pwdfield,r,min,max,title,type) 
{
    //参数说明：id=当前input的ID；box=提示信息显示的元素ID；method=验证方法；pwdfield=密码字段的ID；r=是否必填项，值为0和1；min=最小长度；max=最大长度；title=字段名称；type=类型
	var bx = document.getElementById(box);
	var tr = bx.parentNode;
	var id = $("[id$="+id+"]");
	var box = document.getElementById(box);
	var pwdfield = $("[id$="+pwdfield+"]");
	//移除鼠标经过的提示文字和背景色

	if(type!=2)
	{
	    if(type==0)
	    {
	        tr.style.cssText='';
	    }
	    bx.innerHTML='';
	}
	
	//验证表单
	switch(method) {
	    case "str":
			if (str(id,box,r,min,max,title)==false) {
				return false;
			}
			break;
		case "strlength":
			if (strlength(id,box,r,min,max,title)==false) {
				return false;
			}
			break;
		case "password":
			if (password(id,box,r,min,max)==false) {
				return false;
			}
			break;
	    case "spassword":
			if (spassword(id,box,r,min,max)==false) {
				return false;
			}
			break;
		case "repwd":
			if (repwd(id,box,pwdfield,r)==false) {
				return false;
			}
			break;
		case "existpassword":
			if (existpassword(id,box,pwdfield,r,min,max)==false) {
				return false;
			}
			break;
		case "mobile":
			if (mobile(id,box,r)==false) {
				return false;
			}
			break;
			case "sim": // add by zhengjunzhe 
			if (sim(id,box,r)==false) {
				return false;
			}
			break;
		case "mobileonly":
			if (mobileonly(id,box,r)==false) {
				return false;
			}
			break;
		case "phone":
			if (phone(id,box,r)==false) {
				return false;
			}
			break;
		case "email":
			if (email(id,box,r)==false) {
				return false;
			}
			break;	
		case "realname":
			if (realname(id,box,r)==false) {
				return false;
			}
			break;		
		case "number":
			if (number(id,box,r,min,max,title)==false) {
				return false;
			}
			break;
		case "email":
			if (email(id,box,r)==false) {
				return false;
			}
			break;
		case "code":
			if (code(id,box,r)==false) {
				return false;
			}
			break;
		case "idnum":
			if (idnum(id,box,r)==false) {
				return false;
			}
			break;
		case "wrong":
			if (wrong(id,box,r)==false) {
				return false;
			}
			break;
		case "correct":
			if (correct(id,box,r)==false) {
				return false;
			}
			break;
		case "empty":
			if (empty(id,box,r,title)==false) {
				return false;
			}
			break;
		case "minutes":
		    if(minutes(id,box,r,title)==false){
		        return false;
		    }
		    break;
	}
	return true;
}

//返回密码的强度级别 
function checkStrong(pwd){ 
	modes=0; 
	for (i=0;i<pwd.length;i++){ 
		//测试每一个字符的类别并统计一共有多少种模式. 
		modes|=charMode(pwd.charCodeAt(i)); 
	} 
	return bitTotal(modes);
}
function charMode(iN){ 
	if (iN>=48 && iN <=57) //数字 
	return 1; 
	if (iN>=65 && iN <=90) //大写字母 
	return 2; 
	if (iN>=97 && iN <=122) //小写 
	return 4;
	else 
	return 8; //特殊字符 
} 
//计算出当前密码当中一共有多少种模式 
function bitTotal(num){ 
	modes=0; 
	for (i=0;i<4;i++){ 
		if (num & 1) modes++; 
		num>>>=1; 
	} 
	return modes; 
} 

//返回样式类型
function getClass(parm)
{ 
	return document.getElementById(parm).className;
}

//同意是否显示
function button_check()
{
    if(document.getElementById("check_txtUserNameReg"))
    {
        if(getClass("check_txtUserNameReg")=="PassCheck" && 
	        getClass("check_txtPwRreg")=="PassCheck" && 
	        getClass("check_txtPwdD")=="PassCheck" && 
	        getClass("check_txtUserRealName")=="PassCheck" && 
	        getClass("check_txtCiName")=="PassCheck" && 
	        getClass("check_txtTel")=="PassCheck" && 
	        getClass("check_txtAddr")=="PassCheck" && 
	        getClass("check_txtEmail")=="PassCheck" && 
	        getClass("check_tbCode")=="PassCheck")
	    {
	        $("#btnReg").attr("disabled","");
	    }
	    else
	    {
		    $("#btnReg").attr("disabled","disabled");
	    }	
    }	
}