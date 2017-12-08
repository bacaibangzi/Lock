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
    <div class="contenbox">
			<!--
    	<div class="grid_summay_opts" id="btns">
				<div class="left_opts">
						<a hideFocus="true" href="javascript:add1()" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							<spring:message code="system.add" />
						</a>
						
						<a hideFocus="true" href="javascript:deleteAll();" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							<spring:message code="system.delete" />
						</a>
				</div>
				<div class="right_opts">
					<sec:authorize ifAnyGranted="<%=delMenu %>">
					</sec:authorize>
				</div>
			</div>
			<br />
			<div class="sprite_mod">
				<a class="Js_showSearch mod_opts" hidfocus="true" id="searchnav"><spring:message code="system.searchnav" /></a>
			</div>
    
    
    		 表格列表过滤条件设置 
			<div class="filter-mod">
				<ul class="filter-list">
					<li class="filter-item">
						<label class="filter-label">
							终端名称
						</label>
						<input type="text" class="filter-text" id="areaName_filter" />
					</li>
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
			-->
			<table cellpadding="0" cellspacing="0" border="0" id="grid-table" width="100%" class="common_table Js_contextMenuOpt">
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>流水号</th>
						<th>控制器名称</th>
						<th>终端编号</th>
						<th>终端名称</th>
						<th>终端类型</th>
						<th>备注</th>
						<th>状态</th>
						<th>状态更新时间</th>
						<th>终端操作</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
    </div>
        <div class="rightMenu bodyMenu Js_tdMenu">
            <!--存储当前点击行的数据-
            <input type="hidden" class="Js_curIndex" value="" />
            <ul>
                
                <li><a hideFocus="true" href="javascript:detail()">查看</a></li>
            </ul>
            ->
        </div> 
	</body>
	    <!-- 日期控件 -->
	<script type="text/javascript" src="<%=path%>/common/js/datapicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var datatable ;
		var reLoad ;
		$(document).ready(function(){
			var tableObj={}
			tableObj.url="<%=basePath%>chongFa/list.htm?code=${vo.code}";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
				{"mDataProp":"","sDefaultContent":"<input type='checkbox' />","bSortable":false,"sWidth":"20px",sClass:"checkbox"},
				{"mDataProp":"sn","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"50"},
				{"mDataProp":"controllerName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"terminalId","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"terminalName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"devModelStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"remark","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"devStateStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"stateTime","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"code","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"200" ,
						fnRender: function(value,row,index) {
					  	return "<input type='button' onClick='cf(\""+row+"\")'  value='重新授权'>";
				}}
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
			reLoad = function(){
  				var url ="<%=basePath%>devDoorTeminal/list.htm?code=${vo.code}";
				tableObj.url  = url;
				datatable = datatableObj(tableObj);
  			}
		});

		/** 修改方法 **/
		function update()
		{
			var data=$(".Js_tdMenu").data("data");
			var selectId = data.idStr;
			window.location = "<%=basePath%>devDoorTeminal/eidt.htm?code=${vo.code}&entityId="+selectId; 
		}
		/** 查看详情 **/
		function detail()
		{
			var data=$(".Js_tdMenu").data("data")
			var selectId = data.idStr;
			// 明细弹出框
			var commonDialog = commonOpenDialog("readDetail",'详细',700,450, '<%=basePath%>devDoorTeminal/detail.htm?code=${vo.code}&entityId=' + selectId);
			commonDialog.addBtn("ok",'确定', commonDialog.cancel);
		}
		/** 按条件查询 **/
		function highQuery()
		{
			// 查询条件 区域名称
			var areaName_filter = $.trim(document.getElementById('areaName_filter').value);
			var returnVal = '<%=basePath%>devDoorTeminal/list.htm?code=${vo.code}';
			if(areaName_filter!=''){
				returnVal += '&nameFilter=' + encodeURI(encodeURI(areaName_filter));
			}
			return returnVal;
		}
		/** 删除**/
		function deleteAll()
		{
			var rows=getSeleteObjs(datatable);
			var actionUrl = "<%=basePath%>devDoorTeminal/delete.htm?code=${vo.code}&entityIds=";
			batchDelete( {rows:rows,idField:"idStr",actionUrl:actionUrl});
		}
		 
		
		function add1(){
			if("${vo.code}"==""){
				fh.alert("请选择门组");
				return;
			}
			
			var commonDialog = commonOpenDialog("readDetail13",'选取终端',800,550, '<%=basePath%>devDoorTeminal/eidt.htm?code=${vo.code}');
			commonDialog.addBtn("cancel",'取消', commonDialog.cancel);
			commonDialog.addBtn("ok",'确定', function()
			{
				var materialStockSelect = $("#materialStockSelect", commonDialog.dgDoc).val();//获取选中对象
				
				//alert(materialStockSelect);	 
				$.ajax({ 
					type: "POST", 
					url: '<%=path %>/devDoorTeminal/save.htm', 
					data: "entityIds=" + materialStockSelect + 
				 	  	  "&code=${vo.code}"+ 
					 	  "&orgCode=${vo.orgCode}",
					success: function(msg){
						if(msg == "true"){
							commonDialog.cancel();
							reLoad();
						}else{
							fh.alert('<spring:message code="system.oper.failture" />');
						}
					}
				});
				
			}); 
		}
		 
	    
	    function cf(id){

			//alert(id);
			$.ajax({ 
				type: "POST", 
				url: '<%=path %>/devcmdlist/cf.htm', 
				data: "code="+  id ,
					 // "&entityId=" + id ,
				success: function(msg){
					if(msg){
						fh.alert('已成功发送指令', false, function(){  
						});
					} else{
						fh.alert('失败');
					}
				}
			});
	    }
	</script>
		
</html>

<script language="javascript" type="text/javascript">
           
</script>

