
/*
 * @author liubaigen 2008-10-14 
 *
 * 根据给定状态控制指定Id的对象的隐藏与显示
 */
function isDisplay(flag,id)
{
	var o = getCenter(id) ;
	if( o == null )	
	{
		return ;
	}
	o.style.display = flag ? "block" : "none" ;
}

/*
 *@author liubaigen
 * Judge whether the page element is existing ;
 * id：id of the element ;
 */
function isExist(id)
{
	if(!$chk(id))
	{
		return false ;
	}
	var elementObj = getCenter(id) ;
	if($chk(elementObj))
	{
		return true ;
	}
	else
	{
		return false ;
	} 
}



/*
 *@author liubaigen
 *判断字符串是否为“”
 *param strVal is a string 
 *return true or false
 */
function isEmpty(strVal){
	return !(strVal || strVal === 0);
}

/*
 *@author liubaigen
 *判断字符串是否为整数
 *param strVal is a string 
 *return true or false
 */
function isInteger(strVal)
{
	var numPat1 = /^[0-9]+$/;
	var matchArray1 = strVal.match(numPat1);
	if(matchArray1 != null)
	{
		return true;
	}
	else
	{
		return false;
	}
}

/*
 *@author liubaigen
 *判断字符串是否为数字
 *param strVal is a string 
 *return true or false
 */
function isDigit(strVal)
{ 
	var numPat1 = /^[0-9]+\.?[0-9]*$/;
	var numPat2 = /^0{1}[0-9]+.*$/;
	 
	var matchArray1 = strVal.match(numPat1);
	var matchArray2 = strVal.match(numPat2);
	if(matchArray1 != null && matchArray2 == null)
	{
		return true;
	}
	else
	{
		return false;
	}	  
}

//获取字符串长度。中文算两位
function strLength(str)
{
	return str.match(/[^x00-xff]/ig) + str.length;
}

/*
 *@author liubaigen
 *判断字符串长度是否超过指定最大值
 *param strVal is a string 
 *maxLength is a number
 *return true or false
 */
function lengthLargerThan(strVal, maxLength)
{
	
 	if(strLength(strVal) > maxLength)
 	{
 		return true;
 	}
 	else
 	{
 		return false;
 	}
}

/*
 *@author liubaigen
 *判断字符串长度是否小于指定最小值
 *param strVal is a string 
 *minLength is a number
 *return true or false
 */
function lengthLesserThan(strVal, minLength)
{
	if(!chk(strVal))
 	{
 		return true;
 	}
 	if(strLength(strVal) < minLength)
 	{
 		return true;
 	}
 	else
 	{
 		return false;
 	} 
}

/*
 *@author liubaigen
 *判断字符串长度是否等于指定值
 *param strVal is a string 
 *length is a number
 *return true or false
 */
function lengthEquals(strVal, length)
{
	if(!chk(strVal))
	{
		return false;
	} 
	if(strLength(strVal) == length)
	{
		return true;
	}
	else
	{
		return false;
	}
}

/*
 *@author liubaigen
 *判断值是否小于最小值
 *param strVal is a string 
 *minVal is a float
 *return true or false
 */
function smallerThan(strVal, minVal)
{
	val = parseFloat(strVal);
	if(val < minVal)
	{
		return true;
	}
 	else
 	{
 		return false;
 	}
}

/*
 *@author liubaigen
 *判断值是否大于最大值
 *param strVal is a string 
 *maxVal is a float
 *return true or false
 */
function biggerThan(strVal, maxVal)
{
	val = parseFloat(strVal);
 	if(val > maxVal)
 	{
 		return true;
 	}  
 	else
 	{
 		return false;
 	}
}

/*
 *@author liubaigen
 *判断字符串是否带有引号
 *param strVal is a string 
 *return true or false
 */
function hasQuote(strVal)
{
 	if(!chk(strVal))
 	{
 		return false;
 	}
 	if(strVal.indexOf("\"") >= 0 || strVal.indexOf("'") >= 0)
 	{
 		return true;
 	}
 	else
 	{
 		return false;
 	}
}

//获取当前的年月日星期
function getCurrentTime(){
	var dd = new Date();
	var xq = dd.getDay();
	var day = "";
	switch(xq){
		case 0:
			day = "星期日";
			break;	
		case 1:
			day = "星期一";
			break;	
		case 2:
			day = "星期二";
			break;	
		case 3:
			day = "星期三";
			break;	
		case 4:
			day = "星期四";
			break;	
		case 5:
			day = "星期五";
			break;	
		case 6:
			day = "星期六";
			break;	
	}
	return dd.getFullYear()+ "年" + (dd.getMonth()+1) + "月" + dd.getDate() + "日" + " " + day;
}


/*
 * 判断是否为数字
 *
 * @param value ｃｈｅｃｋ的对象
 * @param title ｃｈｅｃｋ的项目名
 */
function isNum(value, title) {
	strValue = rTrim(value);
	if (strValue == "") {
		alert("\u8f93\u5165\u503c\u4e3a\u7a7a\uff01\u8bf7\u91cd\u65b0\u8f93\u5165");
		return false;
	}
	if (isNaN(strValue)) {
		alert(title + "\u5fc5\u987b\u662f\u6570\u5b57!");
		return false;
	}
	return true;
}
/**
  * 去除右边全半角空格
  * 
  * @param strValue String
  * @return String String
  */
function rTrim(strValue) {
	if (strValue != "") {
		nCur = 0;
		for (i = strValue.length - 1; i > -1; i--) {
			if ((strValue.charAt(i) != " ") && (strValue.charAt(i) != "\u3000")) {
				nCur = i;
				break;
			}
		}
		if ((nCur == 0) && ((strValue.charAt(0) == " ") || (strValue.charAt(0) == "\u3000"))) {
			return "";
		}
		return strValue.substring(0, nCur + 1);
	} else {
		return "";
	}
}


/*在table中删除所有行
 *tableId：需要删除的table
 * num : 从指定table的第几行开始删除（可选参数），默认第一行是列头，从第二行开始删除，
 */
function delAllRow(tableId,num){
	if(num == undefined){
		num = 1 ;
	}
	if(getCenter(tableId) == null)  return ;
	var tbody = getCenter(tableId).getElementsByTagName("TBODY") ;
	if(tbody.length == 0){
		return ;
	}
	var tbody0 = tbody[0] ;
	var trArr = tbody0.getElementsByTagName("tr") ;
	var trSize = trArr.length ;
	for(var i = num ; i < trSize ; i ++){
		tbody0.removeChild(trArr[num]) ;
	}
}

//计算两个日期相隔天数
 function getDistime( start , end , split){
 	if( !$chk(split))
 	{
 		split = "-" ;
 	}
	var v1=start.split(split);
	tt=new Date(parseInt(v1[0]),parseInt(v1[1]),parseInt(v1[2]));
	var v2=end.split(split);
	nn=new Date(parseInt(v2[0]),parseInt(v2[1]),parseInt(v2[2]));
	var d=1000*3600*24;
	return (nn.getTime()- tt.getTime()) / d ;
}

//是否为Email格式 
function isEmail(str)
{
	var email = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(email.test(str))
	{
		return true;
	}
	return false ;
}

//是否为电话号码
function isPhone(str)
{
	var phone = /^((\(\d{3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}$/;
	if(phone.test(str))
	{
		return true;
	}
	return false ;
}

//是否为手机号码(现在只支持13 开头和15开头的号段)
function isMobile(str)
{
	var mobile = /^((\(\d{3}\))|(\d{3}\-))?((13)|(15)|(18))\d{9}$/;
	if(mobile.test(str))
	{
		return true;
	}
	return false ;
}

//是否为联系方式，即电话号码或手机号码(现在只支持13 开头和15开头的号段)
function isMobilephone(str)
{
	if(isPhone(str) || isMobile(str))
	{
		return true;
	}
	return false;
}

//是否为url
function isUrl(str)
{
	   var strRegex = "^((https|http|ftp|rtsp|mms)?://)" 
  		+ "?(([0-9a-zA-Z_!~*'().&=+$%-]+: )?[0-9a-zA-Z_!~*'().&=+$%-]+@)?" //ftp的user@ 
        + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184 
        + "|" // 允许IP和DOMAIN（域名）
        + "([0-9a-zA-Z_!~*'()-]+\.)*" // 域名- www. 
        + "([0-9a-zA-Z][0-9a-zA-Z-]{0,61})?[0-9a-zA-Z]\." // 二级域名 
        + "[a-z]{2,6})" // first level domain- .com or .museum 
        + "(:[0-9]{1,4})?" // 端口- :80 
        + "((/?)|" // a slash isn't required if there is no file name 
        + "(/[0-9a-zA-Z_!~*'().;?:@&=+$,%#-]+)+/?)$"; 
        var re=new RegExp(strRegex);
	if(re.test(str))
	{
		return true;
	}
	return false ;
}

//是否为身份证
function isIdCard(str)
{
	var idCard = /^\d{15}(\d{2}[A-Za-z0-9])?$/;
	if(idCard.test(str))
	{
		return true;
	}
	return false ;
}

//是否邮编
function isZip(str)
{
	var zip = /^[0-9]\d{5}$/;
	if(zip.test(str))
	{
		return true;
	}
	return false ;
}

//是否QQ号码
function isQq(str)
{
	var qq = /^[1-9]\d{4-8}$/;
	if(qq.test(str))
	{
		return true;
	}
	return false ;
}

//是否英文
function isEnglish(str)
{
	var english = /^[A-Za-z]+$/;
	if(english.test(str))
	{
		return true;
	}
	return false ;
}

//是否中文
function isChinese(str)
{
	var chinese = /^[\u0391-\uFFE5]+$/;
	if(chinese.test(str))
	{
		return true;
	}
	return false ;
}


//金额校验，最大为小数点前9位，小数点后4位
function isPrise(str)
{
	var prise =  /^((([1-9]{1}\d{0,8})|0)(\.\d{1,4})?)$/ ;
	if(prise.test(str))
	{
		return true;
	}
	return false ;
}
//数量校验，最大为小数点前9位，小数点后4位
function isQty(str)
{
	var qty =  /^((([1-9]{1}\d{0,8})|0)(\.\d{1,4})?)$/ ;
	if(qty.test(str))
	{
		return true;
	}
	return false ;
}
//数量校验，小数点后4位 浮点数验证
function isQty2(str)
{
	var qty =  /^(-?\d+)(\.\d{1,4})?$/ ;
	if(qty.test(str))
	{
		return true;
	}
	return false ;
}


// 手机号码验证     
$.validator.addMethod("isMobile", function(value, element) {   
  var length = value.length;     
  return this.optional(element) || (length == 11 && isMobile(value));     
},"手机号码格式有误")

// 电话号码验证     
$.validator.addMethod("isPhone", function(value, element) {     
  var tel = /^(\d{3,4}-?)?\d{7,9}$/;     
  return this.optional(element) || isPhone(value);     
}, "电话号码格式有误")

// 身份证号码验证     
$.validator.addMethod("isIdCard", function(value, element) {     
	//alert(value+"----"+element.name);
       return this.optional(element) || isIdCard(value);     
   }, "身份证号码有误")
 //ip地址范围验证
jQuery.validator.addMethod("validateIPRange", function(value, element){
	var a = value.split('~');
	if (a.length !=2 )return false;
	var re = /^(?:[01]?\d{1,2}|2[0-4]\d|25[0-5])(?:\.(?:[01]?\d{1,2}|2[0-4]\d|25[0-5])){3}$/;
	if(!re.test(a[0]) || !re.test(a[1])) return false;
	a[0] = a[0].split('.');
	a[1] = a[1].split('.');
	a[0] = a[0][0]*16777216 + a[0][1]*65536 + a[0][2]*256 + a[0][3]*1;
	a[1] = a[1][0]*16777216 + a[1][1]*65536 + a[1][2]*256 + a[1][3]*1;
	if(a[0] > a[1]) return false;
	return true;
},"请填写正确的ip地址范围");  
   