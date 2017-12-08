/**
 * Ajax请求超时跳转
 *
 */
$(document).ajaxError(function(event,xmlRequest,ajaxOptions,throwError){
		//alert(xmlRequest.status+"------"+throwError+"------"+xmlRequest.responseText)
	//fh.alert('当前账户超时，请重新登录！',false,function(){
		if(xmlRequest.status == 302){
			top.location.href= xmlRequest.responseText;
		}
	//});
	
})
/**
 * 新增
 * 
 */
function add(url) {
	window.location.href = url;
}
/**
 * 修改
 * 
 */

function update(url) {
	window.location.href = url;
}
/**
 * 保存
 * 
 */
function save(url) {
	window.location.href = url;
	fh.alert("保存成功！");
}
/**
 * 返回
 * 
 */
function back(url) {
	window.location.href = url;
}


/**
 * 判断是否选中
 * 
 */
function isChecked(ids) {
	var hasChecked = false;
	if (ids.length == 0) {
		fh.alert("暂无选中记录！");
		return false;
	}
	for (var i = 0; i < ids.length; i++) {
		if (ids[i].checked) {
			hasChecked = true;
			break;
		}
	}
	return hasChecked;
}

/**
 * 全选
 * 
 */
function selectAll(obj) {
	var ids = document.getElementsByName('ids');
	for (var i = 0; i < ids.length; i++) {
		ids[i].checked = obj.checked;
	}
}

function batchDoIt(obj,str) {
	var rows = obj.rows;
	if (rows.length == 0) {
		fh.alert("请选择需要操作的记录！");
		return;
	}
	fh.confirm("确定"+str+"吗？", handleBatchDelete, false, obj);
} 
 
/**
 * 批量删除操作
 */
function batchDelete(obj) {
	var rows = obj.rows;
	if (rows.length == 0) {
		fh.alert("请选择需要操作的记录！");
		return;
	}
	fh.confirm("确定删除吗？", handleBatchDelete, false, obj);
}

/**
 * 批量删除操作
 */
function handleBatchDelete(obj) {
	var idField = obj.idField;
	var delIds = '';
	for (var i = 0; i < obj.rows.length; i++) {
		delIds += obj.rows[i][idField] + ',';
	}
	if (delIds != '') {
		delIds = delIds.substr(0, delIds.length - 1);
	}
	obj.actionUrl += delIds;
	window.location.href = obj.actionUrl;
}

 /**
 * Ajax批量删除操作
 * 
 * @param actionUrl
 *            和普通查询一样 url
 * @param callBack
 *            回调方法
 */
function submitAjax(obj, callBack,str,dlg) {
	var rows = obj.rows;
	var ischild = false;
	if(dlg){
		 ischild = true;
	}
	fh.confirm("确定"+str+"吗？",function(){handleBatchDeleteAjax(obj,callBack)}, ischild, obj, dlg);
	
} 
 
 
 /**
  * Ajax批量删除操作
  * 
  * @param actionUrl
  *            和普通查询一样 url
  * @param callBack
  *            回调方法
  */
 function batchDoAjax(obj, callBack,str,dlg) {
 	var rows = obj.rows;
 	var ischild = false;
 	if(dlg){
 		 ischild = true;
 	}
 	if (rows.length == 0) {
 		fh.alert("请选择需要操作的记录！",ischild,null,dlg);
 		return;
 	}

 	fh.confirm("确定"+str+"吗？",function(){handleBatchDeleteAjax(obj,callBack)}, ischild, obj, dlg);
 } 
 
 
/**
 * Ajax批量删除操作
 * 
 * @param actionUrl
 *            和普通查询一样 url
 * @param callBack
 *            回调方法
 */
function batchDeleteAjax(obj, callBack,dlg) {
	var rows = obj.rows;
	var ischild = false;
	if(dlg){
		 ischild = true;
	}
	if (rows.length == 0) {
		fh.alert("请选择需要操作的记录！",ischild,null,dlg);
		return;
	}

	fh.confirm("确定删除吗？",function(){handleBatchDeleteAjax(obj,callBack)}, ischild, obj, dlg);
}

/**
 * Ajax批量删除操作
 * 
 * @param actionUrl
 *            和普通查询一样 url
 * @param callBack
 *            回调方法
 */
function handleBatchDeleteAjax(obj, callBack) {
	var rows = obj.rows;
	var idField = obj.idField;
	var delIds = '';
	for (var i = 0; i < obj.rows.length; i++) {
		delIds += obj.rows[i][idField] + ',';
	}
	if (delIds != '') {
		delIds = delIds.substr(0, delIds.length - 1);
	}
	obj.actionUrl += delIds;
	$.post(obj.actionUrl, null, callBack, "json");
}

/**
 * 单个删除
 * 
 */
function singleDelete(actionUrl, obj) {

	// var row = $('#ui-grid').datagrid("getSelected");
	var param = {};
	param.actionUrl = actionUrl;
	// param.row = row;
	fh.confirm("确定删除吗？", handleDelete, false, param);
}

/**
 * 单个删除
 * 
 */
function ajaxSingleDelete(actionUrl, handel) {

	// var row = $('#ui-grid').datagrid("getSelected");
	var param = {};
	param.actionUrl = actionUrl;
	param.handel=handel;
	// param.row = row;
	fh.confirm("确定删除吗？", ajaxHandleDelete, false, param);
}
/**
 * 单个删除操作
 */
function ajaxHandleDelete(param) {
	var callBack=null;
	if(param.handel)
	{
		callBack=param.handel;
	}
	$.post(param.actionUrl, null, callBack, "json");
}

/**
 * 单个删除操作
 */
function handleDelete(param) {

	/*
	 * var row = $('#ui-grid').datagrid("getSelected"); var idField =
	 * $('#ui-grid').datagrid("options").idField; var delId = row[idField];
	 * actionUrl += delId;
	 * 
	 * $.ajax({ type: "POST", url: actionUrl, data: "", success: function(msg){
	 * if(msg == "true"){ var row = $('#ui-grid').datagrid("getSelected"); var
	 * rowindex = $('#ui-grid').datagrid("getRowIndex", row);
	 * $('#ui-grid').datagrid("deleteRow", rowindex); fh.alert("删除成功！"); }else{
	 * fh.alert('删除失败！'); } } });
	 */

	// var idField = $('#ui-grid').datagrid("options").idField;
	// var delId = param.row[idField];
	// var actionUrl = param.actionUrl
	// actionUrl += delId;
	window.location.href = param.actionUrl;
}

/**
 * 清空表单数据
 * 
 * @param id
 *            容器标识
 */
function clearForm(id) {
	$(':input', '.' + id).not(':button, :submit, :reset').val('')
			.removeAttr('checked').removeAttr('selected');
	/*
	 * var elements =$("#"+id+" input,select"); for (var i=0; i<elements.length;
	 * i++) { var element = elements[i]; if (element.type == 'submit') {
	 * continue; } else if (element.type == 'reset') { continue; } else if
	 * (element.type == 'button') { continue; } else if (element.type ==
	 * 'hidden') { element.value = ""; } else if (element.type == 'text') {
	 * element.value = ""; } else if (element.type == 'textarea') {
	 * element.value = ""; } else if (element.type == 'checkbox') {
	 * element.checked = false; } else if (element.type == 'radio') {
	 * element.checked = false; } else if (element.type == 'select-multiple') {
	 * element.selectedIndex = 0; } else if (element.type == 'select-one') {
	 * element.selectedIndex = 0; } }
	 */
}

/**
 * 获取列表选中行id字符串，逗号分隔
 */
function getSelectedIds(rows) {
	var selectIds = "";
	if (rows.length != 0) {
		for (var i = 0; i < rows.length; i++) {
			if (i == rows.length - 1) {
				selectIds = selectIds + rows[i].idStr;
			} else {
				selectIds = selectIds + rows[i].idStr + ",";
			}
		}
	}

	return selectIds;
}

/**
 * 获取父窗口对象
 */
function getPwin(obj) {
	if (obj) {
		var ifm = top.document.getElementById(obj)
				.getElementsByTagName("iframe");
		if (ifm) {
			return ifm[0].contentWindow;
		}
	}
	return frameElement.lhgDG.curWin;
}

/**
 * 
 * 回车设置时间
 */
function setSelectedDate(event) {
	obj = event.srcElement ? event.srcElement : event.target;
	if (event.keyCode == 13) {
		if (typeof($dp) != 'undefined') {
			try {
				$(obj).val($dp.cal.getNewDateStr());
				$dp.hide();
			} catch (e) {
			}
		}
	}
}

/**
 * 显示错误信息
 */
function showErrorTip(error, element) {
	var id = element.attr("id") + "Tip";
	if ($("#" + id)) {
		$("#" + id).html(error);
	}
}

/**
 * 获取label对象
 */
function hideLabel(obj) {
	var errorTips = $(obj).nextAll("div.errorTip");
	if (errorTips.size() > 0) {
		var labelObj = $(errorTips.get(0)).children("label[class='error']");
		if (labelObj.size() > 0) {
			if ("none" != labelObj.css("display")) {
				labelObj.hide();
			}
		}
	}
}

/**
 * importUrl:导入表单中默认的表单提交地址
 * reImportUrl:继续导入需要处理的地址
 * templateUrl:模板放置位置URL
 * templateFileName:模板文件名称
 */
function createImportUrl(importUrl,reImportUrl,templateUrl,templateFileName)
{
	return "export/toImport.action?importUrl="+encodeURIComponent(importUrl)+"&reImportUrl="+encodeURIComponent(reImportUrl)+
		   "&templateUrl="+encodeURIComponent(templateUrl)+"&templateFileName="+encodeURI(templateFileName);
}

/**
 * 在js脚本中，通过自身的导入路径，获取web部署路径
 * @returns {String}
 */
function getBasePath()
{
	var scripts  = document.getElementsByTagName("script");
	var fullpath = "";
	//自身脚本的位置，如果函数迁移到别的文件，这个正则需要相应修改
	var jsPattern    = /^(.*)\/common\/js\/commonoperate\.js$/;
	//http://开头
	var httpPattern  = /^http:\/\/(.*)$/;
	//中间包含/
	var slashPattern = /^[^\/]*\/(.*)$/;
	
	$.each(scripts, function(){
		var src = this.src;
		if(jsPattern.test(src))
		{
			fullpath = jsPattern.exec(src)[1];
			return false;
		}
	});
	
	if(httpPattern.test(fullpath))
	{
		fullpath = httpPattern.exec(fullpath)[1];
		
		if(slashPattern.test(fullpath))
		{
			var str = "/" + slashPattern.exec(fullpath)[1];
			return str;
		}
		return "";
	}
	return "/" + fullpath;
}


 //照片预览
function createLightbox(obj,id,isParent){
	var width=top.document.documentElement.clientWidth + 35;
	var height=top.document.documentElement.clientHeight;
	var parentId = null;
	if(isParent){
		 parentId = frameElement.lhgDG;
	}else{
		if($(top.document.body).find("iframe[id^='lhgfrm_']").length>0){
			parentId = frameElement.lhgDG;
		}
	}
	
	commonOpenDialog("showimg","图片预览",width,height, getBasePath() + "/application/jsp/openImg/imgbox.jsp",null,id,null,parentId,null,false);
}
