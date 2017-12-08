<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/include/includejs.jsp" />
<%
	//新增按钮
	String addMenu = "7802783440559203414";
	//修改
	String updateMenu = "7291201182524030468";
	//删除
	String delMenu = "6610433833513736115";
	//查看
	
%>
<html>

<body>
	<input type="hidden" id="entityIds" name="entityIds" />
	<input type="hidden" id="code" value="${code}" />
	<input type="hidden" id="materialStockSelect" value="" />
	<input type="hidden" id="materialStockNums" value="" />
    <div class="contenbox">
    	<div class="grid_summay_opts" id="btns">
    		<div class="left_opts">
						<a hideFocus="true" href="javascript:exp()" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							导出日志
						</a>
						
				</div>
    	
			</div>
			<div class="sprite_mod">
				<a class="Js_showSearch mod_opts" hidfocus="true" id="searchnav"><spring:message code="system.searchnav" /></a>
			</div>
    
    
    		<!-- 表格列表过滤条件设置 -->
			<div class="filter-mod">
				<ul class="filter-list">
					<li class="filter-item"><label class="filter-label"> 事件开始时间 </label> <input type="text" class="input-text {required: true, maxlength: 20}" id="dateStr11" name="dateStr11" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></li>
					<li class="filter-item"><label class="filter-label"> 事件结束时间 </label> <input type="text" class="input-text {required: true, maxlength: 20}" id="dateStr22" name="dateStr22" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></li>
					
					<li class="filter-item">
						<label class="filter-label">
							设备名称
						</label>
						<input type="text" class="filter-text" id="sbmc" />
					</li>
					
					<li class="filter-item">
						<label class="filter-label">
							事件类型
						</label>
						<select name="sh_filter"  class="filter-select"  id="sjlx"  >
						 	<option value="-1">全部</option>
							<c:forEach items="${typeMap}" var="item">
								 <option value="${item.key}">${item.value}</option>
							</c:forEach>
						</select>
					</li>
				
					<li class="filter-item">
						<label class="filter-label">
							卡号
						</label>
						<input type="text" class="filter-text" id="kh" />
					</li>
				
					<li class="filter-item">
						<label class="filter-label">
							学号/工号
						</label>
						<input type="text" class="filter-text" id="xh" />
					</li>
					
					<li class="filter-item">
						<label class="filter-label">
							用户名称
						</label>
						<input type="text" class="filter-text" id="yhxm" />
					</li>
					
					<li class="filter-item"><label class="filter-label"> 采集开始时间 </label> <input type="text" class="input-text {required: true, maxlength: 20}" id="dateStr1" name="dateStr1" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></li>
					<li class="filter-item"><label class="filter-label"> 采集结束时间 </label> <input type="text" class="input-text {required: true, maxlength: 20}" id="dateStr2" name="dateStr2" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></li>
					
					<li class="filter-item filter-btns">
						<a hideFocus="true" class="gray_radiu_btn Js_searchTable">
							 <em class="gray_l"></em> 
							 <em class="gray_r"></em> 
							 <spring:message code="system.query" />
						</a>
						<a hideFocus="true" href="javascript:clearForm('filter-mod');" id="add" class="gray_radiu_btn Js_reLoadTable"> 
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							<spring:message code="system.clear" />
						 </a>
					</li>
				</ul> 
			</div>
			<table cellpadding="0" cellspacing="0" border="0" id="grid-table" width="100%" class="common_table Js_contextMenuOpt">
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>流水号</th>
						<th>用户名</th>
						<th>工号/学号</th>
						<th>卡号</th>
						<th>设备名称</th>
						<th>刷卡时间</th>
						<th>事件类型</th>
						<th>采集时间</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
    </div>
        <div class="rightMenu bodyMenu Js_tdMenu">
        </div> 
	</body>
	    <!-- 日期控件 -->
	<script type="text/javascript" src="<%=path%>/common/js/datapicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var datatable ;
		$(document).ready(function(){
			var tableObj={}
			tableObj.url="<%=basePath%>doorswipedata/list.htm?code=${vo.code}";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
				{"mDataProp":"","sDefaultContent":"<input type='checkbox' />","bSortable":false,"sWidth":"20px",sClass:"checkbox"},
				{"mDataProp":"id","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"uiName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"uiNum","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"cardNo","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"doorname","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"swipeTime","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"swipeTypeStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"gatherTime","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"}
			];
			//添加额外的参数
			tableObj.fnServerParams= function ( aoData ) 
			{
    			aoData.push( { "name": "default_param", "value": "desc"} );
  			}
  			
  			datatable=datatableObj(tableObj);
  			//serach
  			$(".Js_searchTable").live("click",function()
  		  	{
				var url = highQuery();
				tableObj.url  = url;
				datatable = datatableObj(tableObj);
			})
			 
			
		});

		/** 查看详情 **/
		function detail()
		{
			var data=$(".Js_tdMenu").data("data")
			var selectId = data.idStr;
			// 明细弹出框
			var commonDialog = commonOpenDialog("readDetail",'详细',700,450, '<%=basePath%>controllerinfo/detail.htm?code=${vo.code}&entityId=' + selectId);
			commonDialog.addBtn("ok",'确定', commonDialog.cancel);
		}
		
		$(".filter-mod").show();
		
		function exp(){
			location = "<%=basePath %>doorswipedata/download.htm";
		}
		
		/** 按条件查询 **/
		function highQuery(){
			// 查询条件 区域名称
			var dateStr11 = $.trim(document.getElementById('dateStr11').value);
			var dateStr22 = $.trim(document.getElementById('dateStr22').value);
			var sbmc = $.trim(document.getElementById('sbmc').value);
			var sjlx = $.trim(document.getElementById('sjlx').value);
			var kh = $.trim(document.getElementById('kh').value);
			var xh = $.trim(document.getElementById('xh').value);
			var yhxm = $.trim(document.getElementById('yhxm').value);
			var dateStr1 = $.trim(document.getElementById('dateStr1').value);
			var dateStr2 = $.trim(document.getElementById('dateStr2').value);
			
			
			
			var returnVal = '<%=basePath%>doorswipedata/list.htm?dateStr11='+dateStr11+'&dateStr22='+dateStr22+'&sbmc='+encodeURI(encodeURI(sbmc))+'&sjlx='+sjlx+'&kh='+kh+'&xh='+xh+'&yhxm='+encodeURI(encodeURI(yhxm))+'&dateStr1='+dateStr1+'&dateStr2='+dateStr2;
			//returnVal += '&nameFilter=' + encodeURI(encodeURI(areaName_filter));
			return returnVal;
		}
		
		
		//$("#dateStr1").val(curentTime1());
		//$("#dateStr2").val(curentTime2());

		function curentTime2(){ 
	        var now = new Date();
	        var year = now.getFullYear();       //年
	        var month = now.getMonth() + 1;     //月
	        var day = now.getDate();            //日
	        var hh = now.getHours();            //时
	        var mm = now.getMinutes();          //分
	        var ss = now.getSeconds();
	        var clock = year + "-";
	        if(month < 10)
	            clock += "0";
	        clock += month + "-";
	        if(day < 10)
	            clock += "0";
	        clock += day + " ";
	        if(hh < 10)
	            clock += "0";
	        clock += hh + ":";
	        if (mm < 10) clock += '0'; 
	        clock += mm+ ":"; 
	        if (ss < 10) ss += '0'; 
	        clock += ss; 
	        return(clock); 
	    } 

		function curentTime1(){ 
	        var now = new Date();
	        var year = now.getFullYear();       //年
	        var month = now.getMonth() - 2;     //月
	        var day = now.getDate();            //日
	        var hh = now.getHours();            //时
	        var mm = now.getMinutes();          //分
	        var ss = now.getSeconds();
	        var clock = year + "-";
	        if(month < 10)
	            clock += "0";
	        clock += month + "-";
	        if(day < 10)
	            clock += "0";
	        clock += day + " ";
	        
	        clock += "00";
	        clock +=  ":";
	        clock += '00'; 
	        clock += ":"; 
	        clock += '00'; 
	        return(clock);  
	    }
		

		
		
		$("#dateStr11").val(curentTime11());
		$("#dateStr22").val(curentTime22());

		function curentTime22(){ 
	        var now = new Date();
	        var year = now.getFullYear();       //年
	        var month = now.getMonth() + 1;     //月
	        var day = now.getDate();            //日
	        var hh = now.getHours();            //时
	        var mm = now.getMinutes();          //分
	        var ss = now.getSeconds();
	        var clock = year + "-";
	        if(month < 10)
	            clock += "0";
	        clock += month + "-";
	        if(day < 10)
	            clock += "0";
	        clock += day + " ";
	        if(hh < 10)
	            clock += "0";
	        clock += hh + ":";
	        if (mm < 10) clock += '0'; 
	        clock += mm+ ":"; 
	        if (ss < 10) ss += '0'; 
	        clock += ss; 
	        return(clock); 
	    } 

		function curentTime11(){ 
	        var now = new Date();
	        var year = now.getFullYear();       //年
	        var month = now.getMonth() - 2;     //月
	        var day = now.getDate();            //日
	        var hh = now.getHours();            //时
	        var mm = now.getMinutes();          //分
	        var ss = now.getSeconds();
	        var clock = year + "-";
	        if(month < 10)
	            clock += "0";
	        clock += month + "-";
	        if(day < 10)
	            clock += "0";
	        clock += day + " ";
	        
	        clock += "00";
	        clock +=  ":";
	        clock += '00'; 
	        clock += ":"; 
	        clock += '00'; 
	        return(clock);  
	    }
		
		
	</script>
		
</html>
<script type="text/javascript">
	document.body.style.backgroundColor="white";
</script>

