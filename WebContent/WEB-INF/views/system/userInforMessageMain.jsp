<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <div class="contenbox">
    	<div class="grid_summay_opts" id="btns">
				<div class="left_opts">
						</a>
						<a hideFocus="true" href="javascript:synBm();" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							同步部门
						</a>
						<a hideFocus="true" href="javascript:synRy();" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							同步人员
						</a>
				</div>
			</div> 
   <div class="sprite_mod">
		<a class="Js_showSearch mod_opts" hidfocus="true" id="searchnav">展开查询条件</a>
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
							卡号
						</label>
						<input type="text" class="filter-text" id="name3" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							旧卡号
						</label>
						<input type="text" class="filter-text" id="name4" />
					</li>
					<li class="filter-item filter-btns">
						<a hideFocus="true" class="gray_radiu_btn Js_searchTable">
							 <em class="gray_l"></em> 
							 <em class="gray_r"></em> 
							 查询
						</a>
						<a hideFocus="true" href="javascript:clearForm('filter-mod');" id="add" class="gray_radiu_btn Js_reLoadTable"> 
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							清空
						 </a>
					</li>
					
					
				</ul> 
			</div>
    
			<table cellpadding="0" cellspacing="0" border="0" id="grid-table" width="100%" class="common_table Js_contextMenuOpt">
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>记录编号2</th>
						<th>记录类型</th>
						<th>用户姓名</th>
						<th>工号</th>
						<th>证件类型</th>
						<th>卡编号</th>
						<th>旧卡编号</th>
						<th>执行状态</th>
						<th>执行时间</th>
						<th>错误日志</th>
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
                <li><a hideFocus="true" href="javascript:update()">修改</a></li>
                
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
			tableObj.url="<%=basePath%>userInforMessage/list.htm?orgCode=${sessionScope.accountInfo.orgCode}";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
				{"mDataProp":"","sDefaultContent":"<input type='checkbox' />","bSortable":false,"sWidth":"20px",sClass:"checkbox"},
				{"mDataProp":"idnumber","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"messageType","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100",
					fnRender: function(value,row,index) {
						if(row=='0'){
							return  "<font color='black'>新增</font> ";
						}else if(row=='1'){
							return  "<font color='black'>删除</font> ";
						}else if(row=='2'){
							return  "<font color='black'>修改</font> ";
						}else if(row=='3'){
							return  "<font color='black'>换卡 </font> ";
						}else if(row=='5'){
							return  "<font color='black'>挂失 </font> ";
						}else if(row=='6'){
							return  "<font color='black'>解挂</font> ";
						}
				}},
				{"mDataProp":"username","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"idserial","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"idtype","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"cardid","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"oldcardid","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"dealFlag","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100",
					fnRender: function(value,row,index) {
						if(row=='2'){
							return  "<font color='red'>执行失败</font> ";
						}else if(row=='1'){
							return  "<font color='green'>执行成功</font> ";
						}else{
							return  "<font color='black'>未执行</font> ";
						}
				}},
				{"mDataProp":"updatedate","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"remark","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"}
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

		/** 修改方法 **/
		function update()
		{
			var data=$(".Js_tdMenu").data("data");
			var selectId = data.idStr;
			window.location = "<%=basePath%>role/eidt.htm?entityId="+selectId; 
		}
		/** 查看详情 **/
		function detail()
		{
			var data=$(".Js_tdMenu").data("data")
			var selectId = data.idStr;
			// 明细弹出框
			var commonDialog = commonOpenDialog("readDetail",'详细',700,450, '<%=basePath%>role/detail.htm?entityId=' + selectId);
			commonDialog.addBtn("ok",'确定', commonDialog.cancel);
		}
		/** 按条件查询 **/
		function highQuery()
		{
			// 查询条件 区域名称
			var name1 = $.trim(document.getElementById('name1').value);
			var name2 = $.trim(document.getElementById('name2').value);
			var name3 = $.trim(document.getElementById('name3').value);
			var name4 = $.trim(document.getElementById('name4').value);
			var returnVal = '<%=basePath%>userInforMessage/list.htm?orgCode=${sessionScope.accountInfo.orgCode}';
			if(name1!=''){
				returnVal += '&code1=' + encodeURI(encodeURI(name1));
			}if(name2!=''){
				returnVal += '&code2=' + encodeURI(encodeURI(name2));
			}if(name3!=''){
				returnVal += '&code3=' + encodeURI(encodeURI(name3));
			}if(name4!=''){
				returnVal += '&code4=' + encodeURI(encodeURI(name4));
			}
			return returnVal;
		}
		/** 删除**/
		function deleteAll()
		{
			var rows=getSeleteObjs(datatable);
			var actionUrl = "<%=basePath%>role/delete.htm?code=${vo.code}&entityIds=";
			batchDelete( {rows:rows,idField:"idStr",actionUrl:actionUrl});
		}
		

		
		function synBm(){
			parent.parent.showLayer();
			$.ajax({
				url:'<%=basePath%>org/syn.htm',
				type:'post',
				async: false,
				data:'entityIds=0',
				success:function(data){
					if(data){
						fh.alert('同步成功', false, function(){
							parent.window.location = parent.window.location;
						});
					}else{
						fh.alert('同步成功');
					}
					parent.parent.hideLayer();
					
				}
			});
		}
		

		function synRy(){
			parent.parent.showLayer();
			$.ajax({
				url:'<%=basePath%>yonghu/syn.htm',
				type:'post',
				async: false,
				data:'entityIds=0',
				success:function(data){
					if(data){
						fh.alert('同步成功', false, function(){
							parent.window.location = parent.window.location;
						});
					}else{
						fh.alert('同步成功');
					}
					parent.parent.hideLayer();
					
				}
			});
		}
	</script>
		
</html>

<script language="javascript" type="text/javascript">
           
</script>

