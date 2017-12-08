<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
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
    
    <div class="sprite_mod">
				<a class="Js_showSearch mod_opts" hidfocus="true" id="searchnav"><spring:message code="system.searchnav" /></a>
			</div>
    
    
    		<!-- 表格列表过滤条件设置 -->
			<div class="filter-mod">
				<ul class="filter-list">
					<li class="filter-item">
						<label class="filter-label">
							用户名称
						</label>
						<input type="text" class="filter-text" id="name1" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							用户工号
						</label>
						<input type="text" class="filter-text" id="name2" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							设备名称
						</label>
						<input type="text" class="filter-text" id="name3" />
					</li>
					<!--  
					<li class="filter-item">
						<label class="filter-label">
							命令开始时间
						</label>
						<input type="text" class="filter-text" id="name4" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							命令结束时间
						</label>
						<input type="text" class="filter-text" id="name5" />
					</li>
					-->
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
    	<div class="grid_summay_opts" id="btns">
				<div class="left_opts">
						<a hideFocus="true" href="javascript:plcf()" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							重发
						</a>
						<!--  
						<a hideFocus="true" href="javascript:plyq()" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							批量延期
						</a>
						-->
				</div>
    	
		</div>
			
    <br />
			<table cellpadding="0" cellspacing="0" border="0" id="grid-table" width="100%" class="common_table Js_contextMenuOpt">
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>用户名称</th>
						<th>用户工号</th>
						<th>卡号</th>
						<th>设备名称</th>
						<th>操作类型</th>
						<th>到期时间</th>
						<th>记录时间</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
    </div>
        <div class="rightMenu bodyMenu Js_tdMenu">
            <!--存储当前点击行的数据-->
            <input type="hidden" class="Js_curIndex" value="" />
            <ul> 
                
                <li><a hideFocus="true" href="javascript:detail()">查看</a></li>
            </ul>
        </div> 
	</body>
	    <!-- 日期控件 -->
	<script type="text/javascript" src="<%=path%>/common/js/datapicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var datatable ;
		$(document).ready(function(){
			var tableObj={}
			tableObj.url="<%=basePath%>fail/list1.htm?code=${vo.code}";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
			    {"mDataProp":"","sDefaultContent":"<input type='checkbox' />","bSortable":false,"sWidth":"20px",sClass:"checkbox"},
			    {"mDataProp":"uiName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"uiNum","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"cardNum","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"terminalname","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"type","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"sjStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"edittime","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"}
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
			var commonDialog = commonOpenDialog("readDetail",'详细',700,450, '<%=basePath%>terminalinfo/detail.htm?code=${vo.code}&entityId=' + selectId);
			commonDialog.addBtn("ok",'确定', commonDialog.cancel);
		}

		/** 按条件查询 **/
		function highQuery()
		{
			// 查询条件 区域名称
			var name1 = $.trim(document.getElementById('name1').value);
			var name2 = $.trim(document.getElementById('name2').value);
			var name3 = $.trim(document.getElementById('name3').value);
			//var name4 = $.trim(document.getElementById('name4').value);
			//var name5 = $.trim(document.getElementById('name5').value);
			var returnVal = '<%=basePath%>fail/list1.htm?orgCode=${vo.code}';
			
			//alert(name4);
			//alert(name5);
			if(name1!=''){
				returnVal += '&code=' + encodeURI(encodeURI(name1));
			}
			if(name2!=''){
				returnVal += '&code1=' + encodeURI(encodeURI(name2));
			}
			if(name3!=''){
				returnVal += '&code2=' + encodeURI(encodeURI(name3));
			}
			/*
			if(name4!=''){
				returnVal += '&code3=' + encodeURI(encodeURI(name4));
			}
			if(name5!=''){
				returnVal += '&code4=' + encodeURI(encodeURI(name5));
			}*/
			return returnVal;
		}
		 
 	function plcf(){
 		
 		var rows=getSeleteObjs(datatable);
		var idss = '';
		for(var i=0;i<rows.length;i++){
				idss += rows[i].idStr;
				if(i<rows.length-1){
					idss += ',';
				}
		}
		if(rows.length==0){
			fh.alert("请选择一条记录!");
			return;
		}
		$.ajax({ 
			type: "POST", 
			url: '<%=path %>/devcmdlist/chongxfak.htm', 
			data: "code1=1"+  
			  	  "&code=" + idss ,
			success: function(msg){
				if(msg){
					fh.alert('已成功发送指令', false, function(){  
						window.location.reload();
					});
				} else{
					fh.alert('失败');
				}
			}
		});
 	}
		
	</script>
		
</html>
<script type="text/javascript">
	document.body.style.backgroundColor="white";
</script>

