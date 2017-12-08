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
    
	<div class="sprite_mod">
		<a class="Js_showSearch mod_opts" hidfocus="true" id="searchnav">展开查询条件</a>
	</div>
    <div class="filter-mod">
				<ul class="filter-list">
					<li class="filter-item">
						<label class="filter-label">
							用户名称
						</label>
						<input type="text" class="filter-text" id="mc" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							工号/学号
						</label>
						<input type="text" class="filter-text" id="gh" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							卡号
						</label>
						<input type="text" class="filter-text" id="kh" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							用户状态
						</label>
						
						<select name="sh_filter" id="flag"  class="filter-select"   >
							<c:forEach items="${flagMap}" var="item">
								 <option value="${item.key}">${item.value}</option>
							</c:forEach>
						</select>
					</li>
					
					
					
					<li class="filter-item filter-btns">
						<a hideFocus="true" class="gray_radiu_btn Js_searchTable">
							 <em class="gray_l"></em> 
							 <em class="gray_r"></em> 
							 查询
						</a>
					</li>
				</ul> 
			</div>
    
    		<div>	
    	</div>
    
    		<br /><br />
			<table cellpadding="0" cellspacing="0" border="0" id="grid-table" width="100%" class="common_table Js_contextMenuOpt">
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>编号</th>
						<th>部门</th>
						<th>工号</th>
						<th>用户名称</th>
						<th>卡号</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
    </div>
	</body>
	    <!-- 日期控件 -->
	<script type="text/javascript" src="<%=path%>/common/js/datapicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var datatable ;
		var reLoad ;
		$(document).ready(function(){
			var tableObj={}
			tableObj.url="<%=basePath%>startCard/list1.htm";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
			    	{"mDataProp":"","sDefaultContent":"<input type='checkbox' />","bSortable":false,"sWidth":"20px",sClass:"checkbox"},
			    	{"mDataProp":"sn","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"50"},
			    	{"mDataProp":"bm","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
					{"mDataProp":"gh","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    	{"mDataProp":"mc","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    	{"mDataProp":"kh","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    	{"mDataProp":"flagStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
					{"mDataProp":"snStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"200" ,
						fnRender: function(value,row,index) {
							return "<input type='button' onClick='gs(\""+row+"\")'  value='挂失'> <input type='button'  value='换卡' onClick='hk(\""+row+"\")'>  <input type='button'  value='解挂' onClick='jg(\""+row+"\")'> ";
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

			
			datatable.find("td").live("click",function(obj)
			{
				var tdSeq = $(this).parent().find("td").index($(this));
		        var trSeq = $(this).parent().parent().find("tr").index($(this).parent());
		       	//alert("第" + (trSeq) + "行，第" + (tdSeq+1) + "列");
		       	var id =  $(this).parent().children().eq(0).text();
				if(isNaN(id))
				{
					fh.alert("请显示用户编号!");
					return;
				}
				//window.parent["group_info"].location="<%=basePath %>startCard/rightCenter.htm?orgCode=${orgCode}&code="+id;
			})
			
			reLoad = function(url){ 
				tableObj.url  = url;
				datatable = datatableObj(tableObj);
  			}
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
			//alert(1);
			var mc =  encodeURI(encodeURI($.trim(document.getElementById('mc').value)));
			var gc = $.trim(document.getElementById('gh').value);
			var kh = $.trim(document.getElementById('kh').value);
			var flag = $.trim(document.getElementById('flag').value);

			var returnVal = '<%=basePath%>startCard/list1.htm?orgCode=${sessionScope.accountInfo.orgCode}&code='+mc+"&code1="+gc+"&code2="+flag+"&code3="+kh; 
			if(flag=='-1'){
				returnVal = '<%=basePath%>startCard/list1.htm?orgCode=${sessionScope.accountInfo.orgCode}&code='+mc+"&code1="+gc+"&code3="+kh;
			}
			//returnVal += '&nameFilter=' + areaName_filter;
			return returnVal;
		}
		/** 删除**/
		function deleteAll()
		{
			var rows=getSeleteObjs(datatable);
			var actionUrl = "<%=basePath%>org/delete.htm?code=${vo.code}&entityIds=";
			batchDelete( {rows:rows,idField:"idStr",actionUrl:actionUrl});
		}
		
		var orgCode = "";
		var orgName = "";
		function showOrgTree()
		{
			var mdDialog = commonOpenDialog("mdDialog",'选择组织',700,450, '<%=basePath%>caipxfmx/orgTree.htm?orgCode=0000');

			/**/
			mdDialog.addBtn("cancel",'取消', mdDialog.cancel);
			mdDialog.addBtn("ok",'确定', function()
			{
				orgCode = $("#orgCode", mdDialog.dgDoc).val();
				orgName = $("#orgName", mdDialog.dgDoc).val();

				//document.getElementById('examineOrgCode').value = orgCode;
				//document.getElementById('examineOrgName').value = orgName;
				
				var returnVal = '<%=basePath%>yonghu/list.htm?orgCode='+orgCode;
				reLoad(returnVal);
				mdDialog.cancel();
			});
		}
		
		// 发卡
		function fak(){
			var rows=getSeleteObjs(datatable);
			var idss = '';
			for(var i=0;i<rows.length;i++){
 				idss += rows[i].kh;
 				if(i<rows.length-1){
 					idss += ',';
 				}
			}
			
			/*
			if(rows.length!=1){
				fh.alert("请选择一条记录!");
				return;
			}*/
			
			
			var youXq = $("#youXq").val();
			if(youXq==''){
				fh.alert("请选择有效期!");
				return;
			}
			
			
			var ids = window.parent["group_info"].frames["srccontent3"].test();
			if(ids==''){
				fh.alert("请选择终端!");
				return;
			}
			 
			$.ajax({ 
				type: "POST", 
				url: '<%=path %>/devcmdlist/fak.htm', 
				data: "code1=1"+  
				  	  "&dateStr2=" + youXq +
				  	  "&code=" + idss +
					  "&code2=" + ids ,
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
		
		
		function gs(id){ 
			$.ajax({ 
				type: "POST", 
				url: '<%=path %>/devcmdlist/guas.htm', 
				data: "code1=1"+  
				  	  "&entityId=" + id ,
				success: function(msg){
					if(msg=="true"){
						fh.alert('已成功发送指令', false, function(){  
							window.location.reload();
						});
					} else if(msg=="false"){
						fh.alert('此卡未授权到门锁');
					}else if(msg=="00"){
						fh.alert('此卡已挂失');
					}
				}
			}); 
		}
		
		

		function hk(id){ 
			var commonDialog = commonOpenDialog("readDetail",'新卡号',400,220, '<%=basePath%>lossCard/num.htm');
			commonDialog.addBtn("cancel",'取消', commonDialog.cancel);
			commonDialog.addBtn("ok",'确定', function()
			{ 
				var code = $("#code", commonDialog.dgDoc).val();
				if(code==''){
					alert("请输入卡号");
					return;
				}
				
				
				$.ajax({ 
					type: "POST", 
					url: '<%=path %>/devcmdlist/huank.htm', 
					data: "code="+code+
					  	  "&entityId=" + id ,
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
				
				commonDialog.cancel();
			});
			
		}
		

		
		function jg(id){ 
			$.ajax({ 
				type: "POST", 
				url: '<%=path %>/devcmdlist/jieg.htm', 
				data: "code1=1"+  
				  	  "&entityId=" + id ,
				success: function(msg){
					if(msg=="true"){
						fh.alert('已成功发送指令', false, function(){  
							window.location.reload();
						});
					} else if(msg=="false"){
						fh.alert('失败');
					} else if(msg=="00"){
						fh.alert('当前卡未挂失');
					}
				}
			});
			
		}
		
	</script>
		
</html>

<script language="javascript" type="text/javascript">
           
</script>

