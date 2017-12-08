
var fh = {};
var isIE6 = navigator.userAgent.toLowerCase().indexOf("msie 6.0") != -1;
/*error、success、confirm、warning、alert*/
fh.showInfo = function (p,handler,cancelHandler) {
	var obj = {id:(p.id ? p.id : "fhdialog"),xButton:(!p.xButton ? p.xButton : true),parent:(p.parent ? p.parent : ""), title:(p.tit ? p.tit : "\u53cb\u60c5\u63d0\u793a\uff1a"), width:(p.w ? p.w : 300), height:(p.h ? p.h : 160), cover:(p.c ? p.c : true), rang:(p.r ? p.r : true), ischild:(p.ischild ? p.ischild : false), resize:(p.re ? p.re : false), html:("<div id='info_con'><table width='100%' height='100%' border='0' cellspacing='0' cellpadding='0'><tr><td align='center' width='75px'><div class='" + (p.type ? p.type : "alert") + "_info'>&nbsp;</div></td><td><div class='info_txt'>" + p.message + "</div></td></tr></table></div>"), dgOnLoad:function () {
	    if (p.type == "confirm") {
	       if(cancelHandler){
	           dlg.addBtn("cancel","取消",function(){
		            dlg.cancel();
					if (cancelHandler) {
					    if(p.param&&p.param!=''){
					       cancelHandler(p.param);
					    }else{
						   cancelHandler();
						}
					}
	           });
	       }else{
		       dlg.addBtn("cancel","取消",dlg.cancel);
	       }
	       dlg.addBtn("ok", "确定", function () {
				if (p.href) {
					this.href = p.href;
				}
				dlg.cancel();
				if (handler) {
				    if(p.param&&p.param!=''){
				       handler(p.param);
				    }else{
					   handler();
					}
				}
		   });  
	    }else{
	       if(handler){
	          dlg.SetXbtn(function(){
		          dlg.cancel();
		          if (handler) {
					 handler();
				  }
	          });
	          dlg.addBtn("ok", "确定",function(){
	              if (p.href) {
					 this.href = p.href;
				  }
				  dlg.cancel();
				  if (handler) {
					 handler();
				  }
	          });
	       }else{
	          dlg.addBtn("ok","确定", dlg.cancel);
	       }
	    }
	}};
	var dlg;
	if (p.ischild) {
		if(p.parent){
			dlg = new p.parent.curWin.$.dialog(obj);
		}else{
			if(frameElement){
				dlg = new frameElement.lhgDG.curWin.$.dialog(obj);
			}else{
				fh.alert("缺少参数，请检查！");
				return ;
			}
		}
	} else {
		dlg = new $.dialog(obj);
	}
	if(dlg){
		dlg.ShowDialog();
		//$('#lhgdlg_'+(p.id ? p.id : "fhdialog")+' .lhgdg_btn_div_default a:last',parent.document).focus();
		$('#lhgdlg_'+(p.id ? p.id : "fhdialog"),top.document).focus();
	}
};
fh.lookup = function(inputId, inputName, height, width, handle, type, title,url, ext) {
	 var dlg = new $.dialog({id:'lookuop_dlg',rang:true, cover:true, title:title, page:url, 'width':width, 'height':height });
	 dlg.ShowDialog();
	if(ext){
		if(ext.type == 'locmodel'){
			dlg.addBtn("btnOK", " 确定 ", gismodelSingleSelected);
		}else if(ext.type == 'pkglist'){
			dlg.addBtn("btnOK", " 确定 ", pkgMulSelected);
		}else if(ext.type == 'applist'){
			dlg.addBtn("btnOK", " 确定 ", appSingleSelected);
		}else if(ext.type == 'rolelist'){
			dlg.addBtn("btnOK", " 确定 ", multipleSelected);
		}else if(ext.type == 'deliverylist'){
			dlg.addBtn("btnOK", " 确定 ", deliverySingleSelected);
		}
		
	}else if (type == undefined || type == "0") {
		dlg.addBtn("btnOK", " 确定 ", singleSelected);
	} else if (type == "1") {
		dlg.addBtn("btnOK", " 确定 ", multipleSelected);
	}
	dlg.addBtn("btnCancel", " 关闭 ", dlg.cancel);
	if(ext){
		if(ext.type == "locmodel"){
			dlg.addBtn("btnClear", " 清空 ", clearGismodel);
		}
		else if(ext.type == "deliverylist"){
			dlg.addBtn("btnClear", " 清空 ", clearDelivery);
		}
		else if(ext.type == 'rolelist'){
			dlg.addBtn("btnClear", " 清空 ", clear);
		}
	}else{
			dlg.addBtn("btnClear", " 清空 ", clear);
	}
	
	
	function multipleSelected() {
		var idsTemp = $("#lhgfrm",$("#lookuop_dlg")).contents()
				.find(':checkbox[name="ids"]:checked');
		if (idsTemp.length == 0) {
			 dlg.cancel();
			return;
		}
		
		var retVals = new Array();			
		var retJsons = new Array();
		idsTemp.each(function(i) {
			if(!this.indeterminate)//过虑checkBox为半选
			{
				var id = $(this).val();
				var val = $("#lhgfrm",$("#lookuop_dlg")).contents().find('#__' + id).val();
				retVals.push(val);
				
				if (handle){
					var retJson = $("#lhgfrm",$("#lookuop_dlg")).contents().find('#json_' +id).val();
					retJsons.push(retJson);
				}
			
			}
			
		});
		
		//回调赋值
		$('#' + inputId).val(retVals.toString());				
		var textArray = new Array;
		for(var i = 0; i < retVals.length; i++){
			var item = retVals[i].split(":");
			textArray.push(item[1]);
		}
		$('#' + inputName).val(textArray.toString());			
			
		dlg.cancel();
		if (handle) {
			try {
				handle= handle.replace('(','(['+retJsons+'],');
				eval(handle);
			} catch (e) {
				// alert(e) //错误提示，在debug模式手动开启
			}
		}
	}
	
		//扩展的定位模板选择框 ext.type : 'locmodel'
		function gismodelSingleSelected(){		
			//全局返回数据_im_item
			_im_item = null ;
			var obj = $("#lhgfrm",$("#lookuop_dlg")).contents().find(':checkbox[name="ids"]:checked');
			if (obj.length == 0) {
				dlg.cancel();
				return;
			}
			var id = obj.val();
			var name = obj.attr("locationname") ;
			var _model_obj = {
				index : ext.index ,
				id : id ,
				name : name ,
				startdate : obj.attr("startdate") ,
				enddate  : obj.attr("enddate") ,
				starttime : obj.attr("starttime") ,
				endtime  : obj.attr("endtime") ,
				weekdayid : obj.attr("weekdayid") ,
				weekdayname : obj.attr("weekdayname") ,
				interval : obj.attr("interval") ,
				overtime :obj.attr("overtime") ,
			    locationType :obj.attr("locationType") 
			};
			$('#' + inputId).val(id);
			if (inputName && inputName != '') {
				$('#' + inputName).val(name);
				$('#' + inputName)[0].focus();
			}
			dlg.cancel();
			if (handle) {
				try {
					handle(_model_obj);
				} catch (e) {
					 alert(e) //错误提示，在debug模式手动开启
				}
			}
		}	
	
	//清空定位模板
	function clearGismodel(){
		var _model_obj = {
			index : ext.index ,
			id : "" ,
			name : "" ,
			startdate : "" ,
			enddate  : "" ,
			starttime : "",
			endtime  : "" ,
			weekdayid : "",
			weekdayname : "" ,
			interval : "" ,
			overtime : ""  ,
			locationType :""
		};
		dlg.cancel();
		if (handle) {
			try {
				handle(_model_obj);
			} catch (e) {
				// alert(e) //错误提示，在debug模式手动开启
			}
		}
	}	
	
		//扩展的定位模板选择框 ext.type : 'deliverylist'
		function deliverySingleSelected(){		
			//全局返回数据_im_item
			_im_item = null ;
			var obj = $("#lhgfrm",$("#lookuop_dlg")).contents().find(':checkbox[name="ids"]:checked');
			if (obj.length == 0) {
				dlg.cancel();
				return;
			}
			var id = obj.val();
			var name = obj.attr("empname") ;
			var _model_obj = {
				index : ext.index ,
				id : id ,
				name : name ,
				deptname : obj.attr("deptname") 
			};
			$('#' + inputId).val(id);
			if (inputName && inputName != '') {
				$('#' + inputName).val(name);
				$('#' + inputName)[0].focus();
			}
			dlg.cancel();
			if (handle) {
				try {
					handle(_model_obj);
				} catch (e) {
					 alert(e) //错误提示，在debug模式手动开启
				}
			}
		}	
	
	//清空定位模板
	function clearDelivery(){
		var _model_obj = {
			index : ext.index ,
			id : "" ,
			name : "" ,
			deptname : "" 
		};
		dlg.cancel();
		if (handle) {
			try {
				handle(_model_obj);
			} catch (e) {
				// alert(e) //错误提示，在debug模式手动开启
			}
		}
	}	
		
	//单选
	function singleSelected() {
		var obj = $("#lhgfrm",$("#lookuop_dlg")).contents().find(':checkbox[name="ids"]:checked');
		if (obj.length == 0) {
			 dlg.cancel();
			return;
		}
		var id = obj.val();
		var name = $("#lhgfrm",$("#lookuop_dlg")).contents().find('#_' + id).val();
		$('#' + inputId).val(id);
		if (inputName && inputName != '') {
			$('#' + inputName).val(name);
			$('#' + inputName)[0].focus();
		}
		var retJson =$("#lhgfrm",$("#lookuop_dlg")).contents().find('#json_' + id).val();
		dlg.cancel();
		if (handle) {
			try {					
				handle= handle.replace('(','(['+retJson+'],');
				eval(handle);
			} catch (e) {
				 //alert(e) //错误提示，在debug模式手动开启
			}
		}
	}
	
	// 清空
	function clear() {
		$('#' + inputId).val("");
		if (inputName != "" && $('#' + inputName).val()) {
			$('#' + inputName).val("");
		}
		if (inputName != "" && $('#' + inputName).text()) {
			$('#' + inputName).text("");
		}
		if (inputName != "") {
            $('#' + inputName).focus();
            $('#' + inputName).blur();
        }
		dlg.cancel();
		if (handle) {
			try {					
				handle= handle.replace('(','([],');
				eval(handle);
			} catch (e) {
				 //alert(e) //错误提示，在debug模式手动开启
			}
		}
	}

}


fh.dlg = function(obj){
  //{id: 'dlg', title: title, html: '_content/01.html' ,btns:false}
  if(obj){
    obj.id = obj.id || 'dlg';
    obj.cover = obj.cover || true;
    obj.rang = obj.rang || true;
  }
  var dlg = new J.ui.dialog(obj);
  dlg.ShowDialog();
  return dlg;
};
fh.alert = function (info,ischild,handler,parentDlg,dlgparam) {
	var p = {id:'fhdialog-alert',message:info,type:'alert'};
	if(ischild){
	    p = {id:'fhdialog-alert',message:info,type:'alert',ischild:true,parent:parentDlg};
	}
	if(dlgparam){
		p.xButton = (dlgparam.xButton != null &&  !dlgparam.xButton) ? dlgparam.xButton : true;
	}
	if(handler){
	   fh.showInfo(p,handler);
	}else{
	   fh.showInfo(p);
	}
};
fh.error = function (info,ischild,parentDlg,dlgparam) {
	var p = {id:'fhdialog-error',message:info,type:'error'};
	if(ischild){
	    p = {id:'fhdialog-error',message:info,type:'error',ischild:true,parent:parentDlg};
	}
	if(dlgparam){
		p.xButton = (dlgparam.xButton != null &&  !dlgparam.xButton) ? dlgparam.xButton : true;
	}
	fh.showInfo(p);
};
fh.success = function (info,ischild,handler,parentDlg,dlgparam) {
	var p = {id:'fhdialog-success',message:info,type:'success'};
	if(ischild){
	    p = {id:'fhdialog-success',message:info,type:'success',ischild:true,parent:parentDlg};
	}
	if(dlgparam){
		p.xButton = (dlgparam.xButton != null &&  !dlgparam.xButton) ? dlgparam.xButton : true;
	}
	if(handler){
	   fh.showInfo(p,handler);
	}else{
	   fh.showInfo(p);
	}
};
fh.warning = function (info,ischild,parentDlg,dlgparam) {
	var p = {id:'fhdialog-warning',message:info,type:'warning'};
	if(ischild){
	    p = {id:'fhdialog-warning',message:info,type:'warning',ischild:true,parent:parentDlg};
	}
	if(dlgparam){
		p.xButton = (dlgparam.xButton != null &&  !dlgparam.xButton) ? dlgparam.xButton : true;
	}
	fh.showInfo(p);
};
fh.confirm = function(info,handler,ischild,param,parentDlg,cancelHandler,dlgparam) {
    var p = {id:'fhdialog-confirm',message:info,type:'confirm',param:(param==''?'':param)};
	if(ischild){
	    p = {id:'fhdialog-confirm',message:info,type:'confirm',ischild:true,parent:parentDlg,param:(param==''?'':param)};
	}
    if(dlgparam){
    	//alert((dlgparam.xButton != null) +"---------"+(dlgparam.xButton != ""))
		p.xButton = (dlgparam.xButton != null &&  !dlgparam.xButton) ? dlgparam.xButton : true;
	}
	fh.showInfo(p,handler,cancelHandler);
};
fh.forbid = function(param){
	var dlg = new J.ui.dialog({ id: 'forbid',title: '提示',cover:true,message:param,width:700,height:400,rang:true,page: 'jsp/forbid.jsp' });
    dlg.ShowDialog();
};
