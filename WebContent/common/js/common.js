
window.onerror = function(err){
	if(typeof(console) != "undefined"){
		console.log(err);		
		return true;
	}
}

$(function() {

	$(".Js_contextMenuOpt").each(function() {
		var _this = $(this)
		var datableTable = $.fn.dataTable.fnTables(false);
		var _thisH = _this.find("th")
		_thisH.live("contextmenu", function(e) {
			var clickX = e.clientX;
			var clickY = e.clientY;
			var titleArrary = [];
			var that = $(this)
			$(".Js_tdMenu").hide()
			if (that.parents("table").hasClass("Js_contextMenuOpt")) {
				var parent = that.parents("table.Js_contextMenuOpt:visible")
	
				var parentth = parent.find("th")
				var curIndex = parentth.index(that)
				var thL = parentth.length
				var space = /^\s?$/
				for (var i = 0; i < thL; i++) {
					space.test($(parentth[i]).text()) || $.trim($(parentth[i]).text()).length == 0
							? titleArrary.push("选择")
							: titleArrary.push($(parentth[i]).text())
				}
				rightClick = "<div class='rightMenu Js_rightMenu'><ul>"
				for (var m = 0; m < thL; m++) {
					rightClick += "<li><a href='' rel='" + m + "'>"
							+ titleArrary[m] + "</a></li>"
				}
				rightClick += "</ul></div>"
				if ($(".Js_rightMenu").length <= 0) {
					$("body").append(rightClick)

				} else {
					$("body").find(".Js_rightMenu").show()
				}
				$("body").find(".Js_rightMenu").find("li:first").css("border",
						"none")
			
				if(document.documentElement.clientWidth<parseInt(clickX)+250)
				{
					$(".Js_rightMenu").removeAttr("style");
					$(".Js_rightMenu").css({
						"right" : document.documentElement.clientWidth - parseInt(clickX),
						"top" : parseInt(clickY)
								+ parseInt(document.documentElement.scrollTop)
					}).hover(function() {
					}, function() {
						$(this).hide()
					})
				}
				else
				{
					$(".Js_rightMenu").removeAttr("style");
					$(".Js_rightMenu").css({
						"left" : parseInt(clickX),
						"top" : parseInt(clickY)
								+ parseInt(document.documentElement.scrollTop)
					}).hover(function() {
					}, function() {
						$(this).hide()
					})
				}
				$("body").find(".Js_rightMenu a").each(function() {
					var _this = $(this)
					var index = _this.attr("rel")
					
					_this.unbind("click").live("click", function(e) {
						if (_this.attr("title") == "ok") {
							_this.removeAttr("title")
							_this.removeAttr("style")
							parent.find("tr").each(function() {
								var that = $(this)
								$(parent).dataTable().fnSetColumnVis(index,
										true)
								});
							return false;
						} else {
							if (_this.parents("ul").find("a")
									.not("a[title='ok']").length <= 1)
								return false;
							else {
								_this.attr("title", "ok")
								_this.css("background", "none")
								parent.find("tr").each(function() {
									var that = $(this)
									$(parent).dataTable().fnSetColumnVis(index,
											false)
									});
							}
							return false;
						}
						e.returnValue = false;
						e.preventDefault();
						return false;
					})
				})
				e.returnValue = false;
				return false;
			}
		})
	})
	$(document).click(function(e) {
		if (e.button == 0) {
			$(".rightMenu").hide();
		}
	})

	if ($("#Js_spitBarMod").hasClass("Js_closeBar")) {

		var closeBar = '<span class="closebar"></span>'
		$(".Js_closeBar").append(closeBar)
		$(".closebar").css({
			"left" : "0px",
			"top" : "50%",
			"margin-top" : "-5px",
			"cursor" : "pointer"
		})
		$(".closebar").live("click", function() {
			var sideW = $("#Js_asideMod").width();
			if ($("#Js_spitBarMod").css("left") == "0px") {
				$("#Js_spitBarMod").css("left", sideW - 6);
				$("#Js_asideMod").show();
				$("#Js_mainMod").css("marginLeft", sideW)
				$(this).removeClass("rightp")
			} else {
				$("#Js_spitBarMod").css("left", "0px");
				$("#Js_asideMod").hide();
				$("#Js_mainMod").css("marginLeft", "6px")
				$(this).addClass("rightp")
			}

		})
	}
});

$(function() {
	$("#Js_datatableCheck").live("click", function() {
		var _this = $(this)
		if (_this.is(":checked")) {
			var datableTable = $.fn.dataTable.fnTables(false);
			$("#grid-table").find("input:checkbox").attr("checked", "checked")
		} else {
			$("#grid-table").find("input:checkbox").removeAttr("checked")
		}
	})

	$(".form-btn").each(function() {
		var _this = $(this)
		_this.hover(function() {
			_this.addClass("form-btn-hover")
		}, function() {
			_this.removeClass("form-btn-hover")
		})
	})

	var fileLength = 0;
	var underUploading = []
	$("#Js_uploadFile").change(function(event) {
		var _this = $(this)

		var filepath = _this.val();
		underUploading.push(filepath)

		fileLength += 1;
		var fileroute = filepath.split("\\");

		var filename = fileroute[fileroute.length - 1];
		if (fileLength > 5) {
			alert("最多只能上传5个文件！")
		} else {
			var showhtml = "<li class='uploading_item'><a href='' class='Js_deleOpt'> 删除</a><span>"
					+ filename + "</span></li>"
			$(".Js_uploadBox").append(showhtml)
		}
		$("#Js_startUpload").val(underUploading.join(","));
		_this.val("")
		$(".Js_deleOpt").each(function() {
			var that = $(this)
			that.live("click", function() {
				var _thisparent = that.parent(".uploading_item")
				_thisparent.remove(".uploading_item");
				return false;
			})
		})

		event.stopImmediatePropagation();
		event.stopPropagation();
		event.preventDefault();
	})

	$(".Js_showSearch").click(function() {
		if($(".filter-mod:visible").size() == 0){
			$(".filter-mod").show();
			$(this).css("background-position", "0 -18px")
			$("#searchnav").text("关闭查询条件")
		}else{
			$(".filter-mod").hide();
			$(this).css("background-position", "0 0px")
			$("#searchnav").text("展开查询条件")
		}
	})
})
function barControlSplit(callback,reinstall) {

	var maxDis = 0;
	$("#Js_spitBarMod").each(function() {
		var _this = $(this)
		if (_this.hasClass("disabled")) {
			$(_this).css("cursor", "default");
			return;
		}
		_this[0].onmousedown = function(e) {
			// alert(document.body.clientWidth)
			$("body").attr("onselectstart", "return false;").css(
					"-webkit-user-select", "none")
			$("#Js_asideMod").css("zIndex", "-1");
			$("#Js_mainMod").css("zIndex", "-2")
			var d = document;
			e = e || window.event;

			if (_this[0].setCapture) {
				_this[0].setCapture();
			} else if (window.captureEvents) {
				window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP);
			}

			d.onmousemove = function(e) {
				e = e || window.event;
				var _thisLeftnav = _this.siblings("#Js_asideMod")
				var _thisRightCon = _this.siblings("#Js_mainMod")
				var mouseX = e.pageX ? e.pageX : e.clientX;
				var clickMod = mouseX
				var minusDis = parseInt(mouseX);
				var documentW = document.documentElement.clientWidth;
				if(reinstall){
					if(maxDis == 0){
						maxDis = _thisLeftnav.outerWidth(true);
					}
				}else{
					maxDis = documentW * 0.4;
				}
				if (minusDis < 120 || minusDis > maxDis) {
					return false;
				} else {
					_this.css("left", minusDis + "px")
					_thisLeftnav.css("width", minusDis + "px")
					_thisRightCon.css("margin-left", (minusDis + 6) + "px")
				}
			}
			d.onmouseup = function() {
				// 取消捕获范围
				if (_this[0].releaseCapture) {
					_this[0].releaseCapture();
				} else if (window.captureEvents) {
					window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP);
				}
				$("#Js_asideMod").css("zIndex", "1");
				$("#Js_mainMod").css("zIndex", "2")

				d.onmousemove = null;
				d.onmouseup = null;
				if (typeof(callback) == "function") {
					callback();
				}
			}

		}
	})
}

function commonOpenDialog(id, title, width, height, url, handle, param, resize,
		parentId, xButton,btnBar) {
	var args = {};
	if (handle != null) {
		args.handle = handle;
	}
	if (param != null) {
		args.param = param;
	}
	var obj = {
		id : id,
		title : title,
		cover : true,
		width : width,
		height : height,
		rang : true,
		page : url,
		args : args,
		xButton : (null == xButton) ? true : xButton,
		resize : (null == resize) ? false : resize,
		btnBar:btnBar!=undefined ? btnBar : true,
		dgOnLoad : function() {

			dgResize(this);
		},
		dgOnResize : function() {
			dgResize(null);
		}
	};
	if (parentId) {
		obj.parent = parentId;
		var commonDialog = new frameElement.lhgDG.curWin.$.dialog(obj);
	} else {
	
		var commonDialog = new $.dialog(obj);
	}
	commonDialog.ShowDialog();
	$("#lhgdlg_" + id, top.document).focus();
	return commonDialog;
}


function dgResize(obj){

	var iframeWin = null;
	var iframe = null;
	var sideTree = null;
	var mainBar = null;
	var mainCon = null;
	if(obj){
		 iframeWin = $(obj)[0].dgDoc.body;
		 iframe = $(obj)[0].dgFrm
	 	 sideTree = $(iframeWin).find("#Js_asideMod")
		 mainBar = $(iframeWin).find("#Js_spitBarMod")
		 mainCon = $(iframeWin).find("#Js_mainMod")
	}else{
		if($("iframe[id^='lhgfrm_']",top.document).size() != 0){
		  	 iframeWin = $("iframe[id^='lhgfrm_']",top.document)[0] ? $("iframe[id^='lhgfrm_']",top.document)[0] : null; 
			 iframe =  $("iframe[id^='lhgfrm_']",top.document)[0] ? $("iframe[id^='lhgfrm_']",top.document)[0] : null;
			 sideTree = $(iframeWin.contentWindow.document).find("#Js_asideMod");
		     mainBar = $(iframeWin.contentWindow.document).find("#Js_spitBarMod");
		     mainCon = $(iframeWin.contentWindow.document).find("#Js_mainMod");
		}
	}
	if(null != iframeWin){
		if (sideTree.length > 0 && mainBar.length > 0 && mainCon.length > 0) {
			var parentH = $(iframe).parent("td").attr("style").split(":")[1]
					.split(";")[0].slice(0, -2);
			if(obj){
				$(iframeWin).css("height", parentH + "px")
			}else{
				$(iframeWin.contentWindow.document).find("body").css("height", parentH + "px")
			}
			sideTree.height(parentH + "px")
			sideTree.find("iframe").height(sideTree.outerHeight(true))
			mainBar.height(parentH + "px")
			mainCon.height(parentH + "px")
			mainCon.find("iframe").height(sideTree.outerHeight(true))
		}
	}
}

var _row;
var _iDataIndex;

function hoverChangeTdBg(obj,iDataIndex,jbm) {
	
	if(jbm!='jbm'){
		obj.live("mouseover", function() {
			var _this = $(this);
			if(_iDataIndex==iDataIndex){
				return;
			}
			$("#grid-table").find("tr.contenttr").removeClass("contenttr")
			_this.addClass("hover_tr_tdbg")
		}).live("mouseout", function() {
			var _this = $(this);
			_this.removeClass("hover_tr_tdbg")
		})
	}
	
	obj.live("click",function(){

		if(_row){
			_row.css("background", "none");
		}
		var _this = $(this);
		_this.removeClass("hover_tr_tdbg")
		_this.css("background", "green");
		_row = _this;
		_iDataIndex = iDataIndex;
	})
}


function datatableObj(tableObj, parmObj) {
	if(tableObj && tableObj.url){
	    if($("#grid-table") && $("#grid-table thead").find("input:checkbox").length>0){
	        $("#grid-table thead").find("input:checkbox").removeAttr("checked");
	    }

		var hidepage = tableObj.nopage ? tableObj.nopage : "showpage"
		tableObj.aaSorting = tableObj.aaSorting != undefined
				? tableObj.aaSorting
				: [];
		var datatable = $('#grid-table').dataTable({
			"aLengthMenu" : tableObj.aLengthMenu ? tableObj.aLengthMenu : [
					[15, 25, 50, 100], [15, 25, 50, 100]],
			"iDisplayLength" : 15,
			"bDestroy" : true,
			"bServerSide" : true,
			"sPaginationType" : "lnPagination",
			"bProcessing" : true,
			"oLanguage" : {
				sLengthMenu : "_MENU_ ",
				sInfo : "显示 _START_ 条到 _END_ 条，共 _TOTAL_ 条记录",
				sInfoEmpty : "显示 0 条到 0 条，共 0 条记录",
				sInfoFiltered : "",
				sEmptyTable : "没有符合条件的数据！",
				sProcessing : "正在加载数据..."
			},
			"bFilter" : true,
			"sServerMethod" : "POST",
			"aaSorting" : tableObj.aaSorting ? tableObj.aaSorting : [],
			"sAjaxSource" : tableObj.url,
			"fnServerData" : function(sSource, aoData, fnCallback) {
				$.ajax({
					"dataType" : 'json',
					"type" : "POST",
					"url" : sSource,
					"data" : togetherParams(aoData, tableObj, parmObj),
					"success" : fnCallback
				});
			},
			"fnServerParams" : tableObj.fnServerParams
					? tableObj.fnServerParams
					: null,
			"aoColumns" : tableObj.aoColumns,
			"sDom" : 'zt<"bottom    ' + hidepage + ' clearfix"flpir>',
			"fnCreatedRow" : tableObj.fnCreatedRow
					? tableObj.fnCreatedRow
					: function(nRow, aData, iDataIndex) {
						createdRowFn(nRow, aData, iDataIndex,tableObj.jbm);
					},
			"fnHeaderCallback" : tableObj.fnHeaderCallback
					? tableObj.fnHeaderCallback
					: function(nHead, aData, iStart, iEnd, aiDisplay) {
						headCheck(nHead, aData, iStart, iEnd, aiDisplay);
					},
			"fnDrawCallback":tableObj.fnDrawCallback
					? tableObj.fnDrawCallback : null
		});
		refreshDatable(datatable);
		return datatable;
	}
}

function syncdatatableObj(tableObj, parmObj) {
	if(tableObj && tableObj.url){
	    if($("#grid-table") && $("#grid-table thead").find("input:checkbox").length>0){
	        $("#grid-table thead").find("input:checkbox").removeAttr("checked");
	    }

		var hidepage = tableObj.nopage ? tableObj.nopage : "showpage"
		tableObj.aaSorting = tableObj.aaSorting != undefined
				? tableObj.aaSorting
				: [];
		var datatable = $('#grid-table').dataTable({
			"aLengthMenu" : tableObj.aLengthMenu ? tableObj.aLengthMenu : [
					[15, 25, 50, 100], [15, 25, 50, 100]],
			"iDisplayLength" : 15,
			"bDestroy" : true,
			"bServerSide" : true,
			"sPaginationType" : "lnPagination",
			"bProcessing" : true,
			"oLanguage" : {
				sLengthMenu : "_MENU_ ",
				sInfo : "显示 _START_ 条到 _END_ 条，共 _TOTAL_ 条记录",
				sInfoEmpty : "显示 0 条到 0 条，共 0 条记录",
				sInfoFiltered : "",
				sEmptyTable : "没有符合条件的数据！",
				sProcessing : "正在加载数据..."
			},
			"bFilter" : true,
			"sServerMethod" : "POST",
			"aaSorting" : tableObj.aaSorting ? tableObj.aaSorting : [],
			"sAjaxSource" : tableObj.url,
			"fnServerData" : function(sSource, aoData, fnCallback) {
				$.ajax({
					"dataType" : 'json',
					"type" : "POST",
					async: false,
					"url" : sSource,
					"data" : togetherParams(aoData, tableObj, parmObj),
					"success" : fnCallback
				});
			},
			"fnServerParams" : tableObj.fnServerParams
					? tableObj.fnServerParams
					: null,
			"aoColumns" : tableObj.aoColumns,
			"sDom" : 'zt<"bottom    ' + hidepage + ' clearfix"flpir>',
			"fnCreatedRow" : tableObj.fnCreatedRow
					? tableObj.fnCreatedRow
					: function(nRow, aData, iDataIndex) {
						createdRowFn(nRow, aData, iDataIndex,tableObj.jbm);
					},
			"fnHeaderCallback" : tableObj.fnHeaderCallback
					? tableObj.fnHeaderCallback
					: function(nHead, aData, iStart, iEnd, aiDisplay) {
						headCheck(nHead, aData, iStart, iEnd, aiDisplay);
					},
			"fnDrawCallback":tableObj.fnDrawCallback
					? tableObj.fnDrawCallback : null
		});
		refreshDatable(datatable);
		return datatable;
	}
}

function createdRowFn(nRow, aData, iDataIndex,jbm){
	hoverChangeTdBg($(nRow),iDataIndex,jbm);

	rowContextMenu(nRow, aData, iDataIndex,jbm)

	setCheckRecord(nRow, aData, iDataIndex,jbm)
	
}


function rowClickEvent(nRow, url) {
	$(nRow).live("click", function() {
		if ($("#grid-table").dataTable().fnIsOpen(this)) {
			$("#grid-table").dataTable().fnClose(this);
		} else {
			$("#grid-table").dataTable().fnOpen(this, getHtml(url), "info_row");
		}
	});
}

function getHtml(url) {
	var rtStr = ""
	if (url != undefined && url != "") {

		if (url.indexOf("/") > 0 || url.indexOf(".action") > 0
				|| url.indexOf(".jsp") > 0) {
			$.ajax({
						"type" : "POST",
						"dataType" : "html",
						"url" : url,
						"async" : false,
						"success" : function(data) {
							rtStr = data;
						}
					})
			return rtStr;
		}

		else {
			rtStr = url;
		}
		return rtStr;
	} else
		return "内容为空！";
}

function getSortObjs(datatable){
	if($.fn.DataTable.fnIsDataTable( $(datatable)[0] ))
	{
		return $(datatable).data("sortObj");
	}
}

function refreshDatable(datatable) {
	$(".datatable_refresh_ln").bind("click", function() {
		$("#grid-table").find("input:checkbox").removeAttr("checked");
		datatable.fnDraw(false);
	})
}

function togetherParams(aoData, tableObj, parmObj) {
	var sortasc=[];
	var sortdesc=[];
	var retObj={};
	var sortColumnCount = 0;
	var sortField = [], sortDir = [], dataProp = [], sortProp = [], sortColumnIndex = [];
	var sortCollen=0;
	var sortStr = ""
	for (var a=0;a < aoData.length;a++) {
		if (aoData[a].name == "iSortingCols") {
			sortColumnCount = aoData[a].value
		}
		if (aoData[a].name.indexOf("mDataProp_") >= 0) {

			dataProp.push(aoData[a].value)
		}
		if (aoData[a].name.indexOf("sSortDir_") >= 0) {
			sortProp.push(aoData[a].value)
		}
		if (aoData[a].name.indexOf("iSortCol_") >= 0) {
			sortColumnIndex.push(aoData[a].value)
		}
		if (aoData[a].name.indexOf("default_param") >= 0) {
			sortColumnIndex.push({
				"default_param" : aoData[a].value
			})
		}
		if(aoData[a].name.indexOf("iSortingCols") >= 0){
			sortCollen=aoData[a].value;
		}
	}
	if (sortColumnCount >= 2) {
		for (var col = 0; col < sortColumnIndex.length; col++) {
			if (tableObj.aaSorting && tableObj.aaSorting.length == 0
					&& typeof(sortColumnIndex[col]) == "object") {
				sortStr = sortColumnIndex[col]["default_param"]
			} else {
				if (typeof(sortColumnIndex[col]) == "object")
					continue;
				sortField.push(dataProp[sortColumnIndex[col]])
				sortDir.push(sortProp[col])
				sortStr += dataProp[sortColumnIndex[col]] + " " + sortProp[col]
						+ " , "
			}
		}

		if (tableObj.aaSorting && tableObj.aaSorting.length == 0) {
		} else {
			sortStr = sortStr.slice(0, -2);
		}

		var trimStr = $.trim(sortStr);
		if (trimStr.charAt(trimStr.length - 1) == ",") {
			sortStr = sortStr.slice(0, -2);
		}

		aoData.push({
			"name" : "sort",
			"value" : sortStr
		})
		aoData.push({
			"name" : "order",
			"value" : ""
		})
	}
	else if(sortColumnCount==1){
		aoData.push({
			"name" : "sort",
			"value":dataProp[sortColumnIndex[0]]
		})
		aoData.push({
			"name" : "order",
			"value" : sortProp[0]
		})		
	}
	else {

		if (tableObj.aaSorting && tableObj.aaSorting.length == 0) {
			aoData.push({
				"name" : "sort",
				"value" : sortColumnIndex[0] != undefined
						? sortColumnIndex[0]["default_param"]
						: ""
			})
			aoData.push({
				"name" : "order",
				"value" : sortProp[0] != undefined ? sortProp[0] : ""
			})
		}
	}

	if (parmObj) {
		if(parmObj instanceof Array){
			aoData = aoData.concat(parmObj)
		}else{
			for (var a in parmObj) {
				aoData.push({
					"name" : a,
					"value" : parmObj[a]
				})
			}
		}
	}

	for(var t=0;t<sortProp.length;t++){
		var curColIndex=sortColumnIndex[t]
		var curSortFName=dataProp[curColIndex]
		if(sortProp[t]=="desc"){
			sortdesc.push(curSortFName)
		}
		if(sortProp[t]=="asc"){
			sortasc.push(curSortFName)
		}
	}
	
	if(sortColumnIndex.length>sortProp.length){
		var lastObj=sortColumnIndex[sortColumnIndex.length-1]
		var lastStr=lastObj.default_param.split(",")
		for(var sL=0;sL<lastStr.length;sL++)
		{
			
			if($.trim(lastStr[sL]).split(" ")[1]=="desc")
			{
				sortdesc.push($.trim(lastStr[sL]).split(" ")[0])
			}
			if($.trim(lastStr[sL]).split(" ")[1]=="asc")
			{
				sortasc.push($.trim(lastStr[sL]).split(" ")[0])
			}
		}
		
	}
	retObj.sortdesc=sortdesc.toString();
	retObj.sortasc=sortasc.toString();
	$("#grid-table").data("sortObj",retObj)
	return aoData;
}

function headCheck(nHead, aData, iStart, iEnd, aiDisplay) {
	if ($(nHead).parents("table").hasClass("Js_singleCheck")) {
		$("input:checkbox", nHead).remove();
	} else {
		$("input:checkbox", nHead).live("change", function() {
			var checked = $(this).is(":checked");
			if (checked) {
				$(this).parents("table").find("input:checkbox:visible").attr(
						"checked", checked)
				$(this).parents("table").find("input:checkbox:visible")
						.parents("tr").addClass("selectedtr")
			} else {
				$(this).parents("table").find("input:checkbox:visible")
						.removeAttr("checked")
				$(this).parents("table").find("input:checkbox:visible")
						.parents("tr").removeClass("selectedtr")
			}
		})
	}

}

function setCheckRecord(nRow, aData, iDataIndex,jbm) {
	$(nRow).live("click", function(e) {
		if ($(this).find("input:checkbox").length > 0) {
			if ($(this).find("input:checkbox").attr("checked") == "checked") {
				$(this).find("input:checkbox").removeAttr("checked")
				if(jbm!='jbm'){
					$(this).removeClass("selectedtr")
				}
			} else {
				if ($(this).parents("table").hasClass("Js_singleCheck")) {
					$(this).find("input:checkbox").attr("checked", "checked")
					if(jbm!='jbm'){
					$(this).addClass("selectedtr").siblings("tr")
							.removeClass("selectedtr")
					}
					$(this).siblings("tr").find("input:checkbox")
							.removeAttr("checked")
				} else {
					$(this).find("input:checkbox").attr("checked", "checked")
					if(jbm!='jbm'){
					$(this).addClass("selectedtr")
					}
				}
			}
		}
		var checked = $(this).parents("table").find("tbody")
				.find("input:checkbox:checked").length
		var all = $(this).parents("table").find("tbody").find("input:checkbox").length
		if (checked == all) {
			$(this).parents("table").find("th").find("input:checkbox").attr(
					"checked", "checked")
		} else {
			$(this).parents("table").find("th").find("input:checkbox")
					.removeAttr("checked")
		}
	})
	$("input:checkbox", nRow).live("click", function(e) {
		$(this).parents("tr").click();
	});
}

function beforeSendAjax(msg) {
	var clientW =Math.max(document.documentElement.clientWidth);
	var clientH = Math.max(document.documentElement.clientHeight,document.body.scrollHeight);
	var contentMt=parseInt(document.documentElement.scrollTop)-20;
	var div="";
	if($(top.document.body).find("iframe[id^='lhgfrm_']").length>0){
		var lhgWin=$(top.document.body).find("iframe[id^='lhgfrm_']")
		div="lhgdlg_"+lhgWin.attr("id").split("_")[1];
		clientW=$(top.document.body).find("#"+div).outerWidth(true)
		clientH=$(top.document.body).find("#"+div).outerHeight(true)
		contentMt=-20;
	}
	
	msg = msg ? msg : "数据处理中...";
	var loadMask = '<div class="loading-mask Js_waitMask" style="position:absolute;top:0px; left:0px;z-index:100000; background:#fff;width:100%;height:'
			+ clientH
			+ 'px;"></div><div class="loading-content Js_loadingMsg" style="position:absolute;top:50%;  left:50%;z-index:100001; background:#fff;border:3px solid #4588BA; padding:10px; margin-left:-60px;margin-top:'+contentMt+'px; font-size:14px; font-weight:blod;">'
			+ msg + '</div>'
	if($(top.document.body).find("iframe[id^='lhgfrm_']").length>0){
		$(top.document.body).find("#"+div).append(loadMask)
		$(top.document.body).find("#"+div).find(".loading-mask").css("opacity","0.5");		
	}
	else
	{
		$("body").append(loadMask)
		$("body").find(".loading-mask").css("opacity","0.5");
	}
}

function completeSendAjax() {
	if ($(".Js_waitMask").length > 0 || $(top.document.body).find(".Js_waitMask").length>0) {
		$(".Js_waitMask").remove();
		$(top.document.body).find(".Js_waitMask").remove();
	}
	if ($(".Js_loadingMsg").length > 0 || $(top.document.body).find(".Js_loadingMsg").length>0) {
		$(".Js_loadingMsg").remove();
		$(top.document.body).find(".Js_loadingMsg").remove();
	}
}

function getSeleteObjs(datatable) {
	var selectedObj = [];
	for (var chktr = 0; chktr < $("#grid-table").find("tbody")
			.find("input:checkbox:checked").length; chktr++) {
		var thisChkTr = $("#grid-table").find("tbody")
				.find("input:checkbox:checked").eq(chktr).parents("tr")
		var thisIndex = $("#grid-table").find("tbody").find("tr")
				.index(thisChkTr)
		selectedObj.push(datatable.fnGetData(thisChkTr[0]))
	}
	return selectedObj;
}

function getAllObjs(datatable) {
	var selectedObj = [];
	for (var alltr = 0; alltr < $("#grid-table").find("tbody")
			.find("tr").length; alltr++) {
		var thisTr = $("#grid-table").find("tbody")
				.find("tr").eq(alltr).parents("tr")
		var thisIndex = $("#grid-table").find("tbody").find("tr")
				.index(thisTr)
		selectedObj.push(datatable.fnGetData(thisTr[0]))
	}
	return selectedObj;
}

function rowContextMenu(nRow, aData, iDataIndex,jbm) {
	$(nRow).live("contextmenu", function(e) {
		if(jbm!='jbm'){
		$(nRow).addClass("contenttr").siblings("tr").removeClass("contenttr")
		}
		var scrollTop = Math.max(document.documentElement.scrollTop,document.body.scrollTop)
		var eX = e.clientX
		var eY = parseInt(e.clientY) + parseInt(scrollTop)
		if(document.documentElement.clientWidth<parseInt(eX)+250)
		{
			$(".Js_tdMenu").removeAttr("style");
			$(".Js_tdMenu").show().css({
				top : eY,
				right : document.documentElement.clientWidth - parseInt(eX)
			}).data("data", aData).data("dataIndex", iDataIndex).hover(function() {
			}, function() {
				$(this).hide();
			})
		}
		else
		{
			$(".Js_tdMenu").removeAttr("style");
			$(".Js_tdMenu").show().css({
				top : eY,
				left : eX
			}).data("data", aData).data("dataIndex", iDataIndex).hover(function() {
			}, function() {
				$(this).hide();
			})
		}
		e.preventDefault();
	})
}

$(document).ready(function() {
	$("#Js_reverSelect").click(function() {
		var checked = $(".Js_selectRange").find("input:checkbox:checked")
		var unchecked = $(".Js_selectRange").find("input:checkbox")
				.not(":checked")
		checked.removeAttr("checked")
		unchecked.attr("checked", "checked")
		return false;
	})

	$("#Js_selectAll").click(function() {
		$(".Js_selectRange").find("input:checkbox").attr("checked", "checked")
		return false;
	})

	$("#Js_unSelectAll").click(function() {
		var checked = $(".Js_selectRange").find("input:checkbox:checked")
		checked.removeAttr("checked")
		return false;
	})
})


function ChoiceCommon(_selecting, _selected, e) {
	var _selecting = $(_selecting)
	var _selected = $(_selected)
	var _sele = _selecting.html();
	_selecting.html("");
	_selected.append(_sele)
	e.preventDefault();
	e.stopImmediatePropagation();
	return false;
}

function choiceSelected(_selecting, _seleted, e) {
	var _selecting = $(_selecting)
	var _selected = $(_seleted);
	var _getSelect = _selecting.find("option:selected")
	_selected.append(_getSelect)
	e.preventDefault();
	e.stopImmediatePropagation();
	return false;

}


$.fn.createTabCon = function(defineValidate, options) {
	var defaultOptions = {

	}
	this.each(function() {
		var that = $(this)
		var tabHd = '<ul class="common-lntab-list clearfix">'
		for (var i = 0; i < $(this).find(".common-tab-item").length; i++) {
			var curBoxItem = $(this).find(".common-tab-item").eq(i)
			var urldes = curBoxItem.attr("src") ? curBoxItem.attr("src") : " "
			var tabItem = '<li class="common-lntab-item"><a class="lntab-item-link" href="'
					+ urldes
					+ '" title="">'
					+ curBoxItem.attr("title")
					+ '</a></li>'
			tabHd += tabItem;
		}
		tabHd += '</ul>'
		that.prepend(tabHd)
		that.find("div.common-tab-item").hide();
		that.find(".lntab-item-link").each(function(index) {
			var _this = $(this)
			_this.live("click", function(e) {
				var _thisSrc = _this.attr("href")
				_this.parent("li.common-lntab-item").addClass("curitem_tab")
						.siblings("li").removeClass("curitem_tab")
				if (_thisSrc != " ") {
					$.ajax({
						type : "POST",
						url : _thisSrc,
						dataType : "html",
						success : function(data) {
							that.find(".Js_tabConMain").html("")
							that.find(".Js_tabConMain").html(data);
						}
					})
				} else {
					that.find(".Js_tabConMain").html(" ")
					that.find("div.common-tab-item").eq(index).show()
							.siblings("div.common-tab-item").hide();
					that.find(".Js_tabConMain").hide();
				}
				e.stopImmediatePropagation()
				return false;
			})
		})
		that.find(".lntab-item-link:first").click();
	})
}

function close_spit(){
	$("#Js_spitBarMod").css("left", "0px");
	$("#Js_asideMod").hide();
	$("#Js_mainMod").css("marginLeft", "6px")
	$(".closebar").addClass("rightp")
}

function resetMainWidth(width) {

	$(".fixed-side").width(width);
	$(".fixed-main").css("margin-left", width + 6);
	$(".fixed-bar").css("left", width);

}

$(document).ready(function() {
	$(".inner-form-tb tr:last").find("td").css("border-bottom", "none")
	$(".inner-form-tb tr").each(function() {
		$(this).find("td:last").css("border-right", "none")
	})
})
