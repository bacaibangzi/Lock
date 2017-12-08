// 中文的验证 
jQuery.validator.addMethod("chinese", function(value, element)
{
	var chinese = /^[\u4e00-\u9fa5]+$/;
	return this.optional(element) || (chinese.test(value));
}, " 请输入中文！");
//中文、英文、数字
jQuery.validator.addMethod("notSpecilSign", function(value, element)
{
    var chinese = /^([\u4E00-\u9FA5]|\w)*$/;
    return this.optional(element) || (chinese.test(value));
}, " 不能输入特殊符号！");
// 非中文的验证 
jQuery.validator.addMethod("notChinese", function(value, element)
{
	var notChinese = /^[a-zA-Z0-9]+$/;
	return this.optional(element) || (notChinese.test(value));
}, " 请输入英文字母或数字！");

jQuery.validator.addMethod("onlyNumber", function(value, element)
{
	var number = /^[0-9]+$/;
	return this.optional(element) || (number.test(value));
}, " 请输入整数！");

jQuery.validator.addMethod("proportion", function(value, element)
{				 
	var number = /^(\d|1[0-9])(\d|1[0-9])-(\d|1[0-9])(\d|1[0-9])-(\d|1[0-9])(\d|1[0-9])$/;
	return this.optional(element) || (number.test(value));
}, " 请输入正确的格式。例如：99-99-99");

// 手机号码验证
jQuery.validator.addMethod("mobile", function(value, element)
{
	var length = value.length;
	var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	return this.optional(element) || (length == 11 && mobile.test(value));
}, " 手机号码格式错误！");

jQuery.validator.addMethod("checkNumbers", function(value, element)
{
	var floatType = "^\\d+(\\.\\d+)?$";
	var intType = "^[0-9]*[1-9][0-9]*$"; 
	var checkstate = false;
	if(value.match(floatType)!=null||value.match(intType)!=null){
		var arr = value.split(".");
		if(arr.length > 1 ){
			if(arr[1].length > 2){
				checkstate = false;
			}else{
				checkstate = true;
			}
		}else{
			checkstate = true;
		}
	}else{
		checkstate = false;
	}
	return this.optional(element) || (checkstate == true);
}, " 数字最多包含两位小数！");

jQuery.validator.addMethod("checkBigDecimal", function(value, element)
{
	var bigDecimal = /^\d{1,10}(\.\d{1,2})?$/;
	return this.optional(element) || (bigDecimal.test(value));
}, " 整数最多10位，小数最多2位！");

// 电话号码验证
jQuery.validator.addMethod("phone", function(value, element)
{
	var tel = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
	return this.optional(element) || (tel.test(value));
}, " 格式：025-88888888");

// 邮政编码验证
jQuery.validator.addMethod("zipCode", function(value, element)
{
	var tel = /^[0-9]{6}$/;
	return this.optional(element) || (tel.test(value));
}, " 邮政编码格式错误！");

// QQ号码验证
jQuery.validator.addMethod("qq", function(value, element)
{
	var tel = /^[1-9]\d{4,19}$/;
	return this.optional(element) || (tel.test(value));
}, " qq号码格式错误！");

// IP地址验证
jQuery.validator
		.addMethod(
				"ip",
				function(value, element)
				{
					var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
					return this.optional(element)
							|| (ip.test(value) && (RegExp.$1 < 256
									&& RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));
				}, " Ip地址格式错误！");

// 传真号码验证
jQuery.validator.addMethod("fax", function(value, element)
{
	var fax = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
	return this.optional(element) || (fax.test(value));
}, " 传真号码格式错误！");

// MSN验证
jQuery.validator.addMethod("msn", function(value, element)
{
	var msn = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/
	return this.optional(element) || (msn.test(value));
}, " MSN格式错误！");
// 手机号码或座机电话验证
jQuery.validator.addMethod("mobileOrPhone", function(value, element)
{
    var length = value.length;
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    var tel = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
    return this.optional(element) || (length == 11 && mobile.test(value)) || (tel.test(value));
    //var mobile = /(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/;
    //return this.optional(element) || (mobile.test(value));
}, " 联系电话格式错误！");

// 经纬度坐标验证
jQuery.validator.addMethod("locationCheck", function(value, element)
{
	var xy = /^\d+(\.\d+)?,\d+(\.\d+)?$/;
	return this.optional(element) || (xy.test(value));
}, " 请输入正确的经纬度坐标！");
