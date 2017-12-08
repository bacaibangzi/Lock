/**
 * 比较两个时间控件值的大小
 * @param begin	开始时间控件ID
 * @param end	结束时间控件ID
 * @returns		开始时间大于结束时间，则为true，小于等于为否。 
 */
function compareCalendar(begin, end) 
{
	var beginStr = document.getElementById(begin).value;
	var endStr = document.getElementById(end).value;
	
	// 如果开始时间或结束时间为空，则亦返回true。
	if(beginStr == "" || endStr == "" || beginStr == null || endStr == null)
	{
		return true;
	}
	var beginTime = Date.parse(beginStr.replace(/-/g, "/"));	// 开始时间值
	var endTime = Date.parse(endStr.replace(/-/g, "/"));		// 结束时间值
	var result = endTime >= beginTime;	//比较结果
	return result;
}

function validateSubmit() 
{
	var beginTime = document.getElementById("beginTime").value;
	var endTime = document.getElementById("endTime").value;
	var timeAreas = document.getElementsByName("timeArea");
	if (beginTime.length != "" && endTime.length != "") {
		if (!compareCalendar("beginTime", "endTime")) {
			return false;
		}
		return true;
	} else {
		for (var i = 0; i < timeAreas.length; i++) {
			if (timeAreas[i].checked) {
				return true;
			}
		}
	}
	return false;
}

function dateToString(date) 
{
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	var s = "";
	s = s + y + "-";
	if (m < 10) {
		s = s + "0" + m + "-";
	} else {
		s = s + m + "-";
	}
	if (d < 10) {
		s = s + "0" + d;
	} else {
		s = s + d;
	}
	return s;
}

/**
 * 在开始时间和结束时间文本框中设置本日时间区间
 */
function writeToday() 
{
	var Nowdate = new Date();
	var enddate = new Date((Nowdate/1000+86400)*1000); 
	document.getElementById("beginTime").value = dateToString(Nowdate) + " 00:00:00";
	document.getElementById("endTime").value = dateToString(enddate) + " 00:00:00";
}

/**
 * 在开始时间和结束时间文本框中设置本周时间区间
 */
function writeWeekDay() 
{
	var NowDate = new Date();	// 获取当前日期对象
	var todayOfWeek = NowDate.getDay();	// 获取今天是本周的第几天，周日是0，周六是6.
	if(todayOfWeek == 0)		// 按照中国的习惯，周日才是一周的最后一天。
	{
		todayOfWeek = 6;
	}
	else
	{
		todayOfWeek -= 1;
	}
	var today = NowDate.getDate();		// 获取当前日
	var month = NowDate.getMonth();		// 获取当前月
	var year = NowDate.getFullYear();	// 获取当前年，getYear方法在Firefox下返回(year - 1900)。
	
	var WeekFirstDay = new Date(year,month,today - todayOfWeek);	// 本周第一天的日期
	var WeekLastDay = new Date((WeekFirstDay / 1000 + 7 * 86400) * 1000);
	document.getElementById("beginTime").value = dateToString(WeekFirstDay) + " 00:00:00";
	document.getElementById("endTime").value = dateToString(WeekLastDay) + " 00:00:00";
}

/**
 * 在开始时间和结束时间文本框中设置本月时间区间
 */
function writeMonthDay() 
{
	var Nowdate = new Date();
	var MonthFirstDay = new Date(Nowdate.getFullYear(), Nowdate.getMonth(), 1);
	var MonthNextFirstDay = new Date(Nowdate.getFullYear(), Nowdate.getMonth() + 1, 1);
	var MonthLastDay = new Date(MonthNextFirstDay);
	document.getElementById("beginTime").value = dateToString(MonthFirstDay) + " 00:00:00";
	document.getElementById("endTime").value = dateToString(MonthLastDay) + " 00:00:00";
}

/**
 * 日志信息查询，检查查询条件是否有效，存在无效的查询条件会给出相应的提示。
 */
function checkSearch(path)
{
	var validTime = checkTimeArea();	// 检查用于筛选的结束时间是否晚于开始时间，不晚于则给出提示。
	if(!validTime)
	{
		return;
	}
	var url = path + "/log/logQuery.action";	// AJAX异步查询请求URL
	
	// 动态查询条件链，包括页面查询栏所有查询控件的值。
	var argChain = "?logInfo.operateDateBegin=" + $("#beginTime").val() + 		// 开始时间
						"&logInfo.operateDateEnd=" + $("#endTime").val() + 		// 结束时间
						"&logInfo.accountName=" + $.trim($("#accountName").val()) + 	// 操作人
						"&selectTypes=" + $("#selectTypes").val() + 			// 操作类型字串叠加
						"&selectModules=" + $("#selectModules").val();			// 系统模块
	
	// 检查输入IP合法性，并给出相应提示。
	/*
	var validIp = checkIpRuleValue();
	if(!validIp)
	{
		return;
	}*/
	/*
	 * Get方式传汉字，要进行两次编码。
	 * 浏览器认为%是个转义字符，经过一次编码解码之后再传递给处理页面，这样的话服务器端就得不到正确结果了。
	 */
	var content = encodeURI(encodeURI($.trim($("#opContent").val())));
	var employeeName = encodeURI(encodeURI($.trim($("#opUser").val())));	// 员工姓名
	
	argChain += "&logInfo.operateContent=" + content + 	// 日志内容
		"&logInfo.accountIp=" + $.trim($("#accountIp").val()) +	// 登录IP
		"&logInfo.employeeName=" + employeeName;
	
	var radioResults = $("input:[name='opResult']");	// 获取操作结果单选框组
	
	$.each(radioResults,function(i,result){
		if(result.checked)
		{
			// 获取用户选择的操作结果
			var opResult = result.value;
			
			// 如果用户选择了操作结果查询条件，则追加之。
			argChain += "&logInfo.operateIsSuccess=" + opResult;
		}
	});
	var encodeUrl = url + argChain;	// 对可能包含汉字的URL进行编码处理
	
	// 查询条件通过验证，执行异步查询并生成新的数据表格。
	//dataGridLoad(encodeUrl, 1, 10, [[{field:'checkbox',checkbox:false}]]);
	return encodeUrl;
}

/**
 * 日志信息统计，检查查询条件是否有效，存在无效的查询条件会给出相应的提示。
 */
function checkSummary(path)
{
	var validTime = checkTimeArea();	// 检查用于筛选的结束时间是否晚于开始时间，不晚于则给出提示。
	if(!validTime)
	{
		return;
	}
	var url = path + "/log/summaryQuery.action";	// AJAX异步查询请求URL
	
	// 动态查询条件链，包括页面查询栏所有查询控件的值。
	var argChain = "?logInfo.operateDateBegin=" + $("#beginTime").val() + 		// 开始时间
						"&logInfo.operateDateEnd=" + $("#endTime").val() + 		// 结束时间
						"&logInfo.accountName=" + $.trim($("#accountName").val()) + 	// 操作人
						"&selectTypes=" + $("#selectTypes").val() + 			// 操作类型字串叠加
						"&selectModules=" + $("#selectModules").val();			// 系统模块
	var employeeName = encodeURI(encodeURI($.trim($("#opUser").val())));	// 员工姓名
	argChain = argChain + "&logInfo.employeeName=" + employeeName;
	var encodeUrl = url + argChain;		// 对可能包含汉字的URL进行编码处理
	
	// 查询条件通过验证，执行异步查询并生成新的数据表格。
	//dataGridLoad(encodeUrl, 1, 10, [[{field:'checkbox',checkbox:false}]]);
	return encodeUrl;
}

/**
 * 清空所有的查询条件，在日志信息查询和统计页面中均有调用，故以pageFlag来标识调用者是哪个页面。
 */
function clearQuerys(pageFlag)
{
	$("#beginTime").val("");
	$("#endTime").val("");
	var timeAreas = $("input:[name='timeArea']");	// 通过name属性获取一组单选按钮
	$.each(timeAreas,function(i,area)
	{
		area.checked = false;		// 取消单选选择
	});
	$("#accountName").val("");
	$("#opUser").val("");
	$("#opTypeStr").val("");		// 清空只读的操作类型文本框
	$("#selectTypes").val("");		// 清空对应的操作类型隐藏域
	//$("#operateClass").val("-1");	// 将select控件的值重置为默认选项
	$("#opModuleStr").val("");
	$("#selectModules").val("");
	
	var results = $("input:[name='opResult']");
	$.each(results,function(i,result)	// 复原被选中的操作结果单选按钮
	{
		result.checked = false;		// 将单选按钮的选中属性置为false则取消选中
	});
	if(pageFlag == "logQuery")		// 如果是日志查询页面，则清除其相比统计页面多出的查询控件。
	{
		$("#opContent").val("");
		$("#accountIp").val("");
	}
}

/**
  * 设置文件大小单位隐藏域的值
  */
function setFilePatternHidden(pattern)
{
	$("#hidFilePattern").val(pattern);
	var num = $("#maxFileSize").val();	// 重新获取文件大小数值，使该验证规则具有通用性。
	var pattern = getCheckRadioValue("maxFileSizeStr");	// 文件大小单位
	var maxSizeMb = 100;		// 最大文件尺寸：MB
	var maxSizeKb = 1024 * 100;	// 最大文件尺寸：KB
	var sizeValid = true;		// 假设文件大小合法
	
	if(pattern == "MB" && num > maxSizeMb)
	{
		sizeValid = false;
	}
	else if(pattern == "KB" && num > maxSizeKb)
	{
		sizeValid = false;
	}
	if(sizeValid)	// 如果最大文件大小设置合法，则隐藏maxFileSize字段的提示。
	{
		var labelMaxSize = $("label:[for = 'maxFileSize']");
		if(labelMaxSize != undefined && labelMaxSize != null)
		{
			labelMaxSize.hide();
		}
	}
}

/**
  * 获取单选框的选中的值，如果没有选中的，则为null。
  */
function getCheckRadioValue(radioName)
{
	var radios = $("input:[name = '" + radioName + "']");	// 取得单选按钮组
	var checkValue = null;
	if(radios == null || radios.length == 0)
	{
		return checkValue;
	}
	radios.each(function()
	{
		if(this.checked || this.checked == 'checked')
		{
			checkValue = this.value;		
		}
	});
	return checkValue;
}

/**
 * 为日志策略设置表单设置验证规则
 */
function defineValidate()
{
	/*----- 用户操作日志设置表单校验 -----*/
	$("#userLogPolicyForm").validate({
		focusInvalid:false,	// 聚焦到非法输入控件
		submitHandler:function(form)	// 表单提交时验证
		{
			form.submit();
		},
		rules:	// 表单控件验证规则
		{
			"userLogPolicy.maxUserLogHistory":	// 日志保留期限
			{
				required:true,
				mustInteger:true
			},
			"userLogPolicy.maxUserLogNum":		// 日志最大数量
			{
				mustInteger:true
			},
			"userLogPolicy.clearRate":			// 日志清除比例
			{
				mustInteger:true
			}
		}
	});

	/*----- 系统运行日志设置表单校验 -----*/
	$("#logPolicyForm").validate({
		focusInvalid:false,	// 聚焦到非法输入控件
		submitHandler:function(form)
		{
			form.submit();
		},
		rules:
		{
			"logPolicy.logFileName":		// 日志文件名
			{
				required:true,
				validFileName:true
			},
			"logPolicy.logFilePath":		// 日志存档目录
			{
				required:true,
				noChinese:true
			},
			"logPolicy.maxHistory":			// 日志保留期限
			{
				required:true,
				mustInteger:true
			},
			"logPolicy.maxFileSize":		// 日志文件归档大小
			{
				mustInteger:true,
				maxSingleFile:true
			},
			"logPolicy.maxFileSizeStr":		// 日志文件归档大小单位
			{
				fileSizePattern:true
			}
		},
		messages:
		{
		}
	});
}

/**
 * 重新加载日志信息显示区
 */
function reloadLogMonitor()
{
	$('#divLog').panel('refresh','logManage.action');
}

/**
  * 检查是否为整数，返回验证结果。
  */
function checkLineNum(num)
{
	var intExp = /^[0-9]+$/;	// 整数表达式
	var isInteger = intExp.test(num) && num > 0;	// 判断是否是大于0的正整数
	return isInteger;
}

/**
 * 清空所有的查询条件，在日志监控页面中调用。
 */
function clearMonitorQuerys()
{
	$("#logLevel").val("");		// 将select控件的值重置为默认选项
	$("#opContent").val("");
}

/**
  * 日志监控，下一页。
  */
function nextPage()
{
	var nextPoint = $("#nextPoint").val();	// 下一页起始字节点，表单外。
	$("#next").val(nextPoint);				// 存放当前已读取到的日志文件字节点
	$("#monitorForm").submit();				// 提交表单
}

/**
  * 日志监控，上一页。
  */
function prevPage()
{
	var prevPoint = $("#prevPoint").val();	// 上一页起始字节点，表单外。
	$("#prev").val(prevPoint);				// 存放当前已读取到的日志文件字节点
	$("#monitorForm").attr("action","readPrevPage.action");
	$("#monitorForm").submit();				// 提交表单
}
