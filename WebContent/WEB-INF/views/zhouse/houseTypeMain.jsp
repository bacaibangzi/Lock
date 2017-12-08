<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
						<a hideFocus="true" href="javascript:add('<%=basePath%>houseType/eidt.htm?orgCode=${sessionScope.accountInfo.orgCode}')" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							新增
						</a> 
				</div>
				<div class="right_opts">
					<sec:authorize ifAnyGranted="<%=delMenu %>">
						<a hideFocus="true" href="javascript:deleteAll();" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							删除
						</a>
					</sec:authorize>
				</div>
			</div>
			<br> 
			<table cellpadding="0" cellspacing="0" border="0" id="grid-table" width="100%" class="common_table Js_contextMenuOpt">
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>序号</th>
						<th>名称</th>
						<th>值</th>
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
			tableObj.url="<%=basePath%>houseType/list.htm?orgCode=${sessionScope.accountInfo.userId}";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
				{"mDataProp":"","sDefaultContent":"<input type='checkbox' />","bSortable":false,"sWidth":"20px",sClass:"checkbox"},
				{"mDataProp":"sn","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"name","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"200"},
				{"mDataProp":"value","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"}
			];
			//添加额外的参数DateString
			tableObj.fnServerParams= function ( aoData ) {
    			aoData.push( { "name": "default_param", "value": "desc"} );
  			}
  			
  			datatable=datatableObj(tableObj);
  			//serach
  			$(".Js_searchTable").live("click",function() {
				var url = highQuery();
				tableObj.url  = url;
				datatable = datatableObj(tableObj);
			})

			reLoad = function(){
  				var url = highQuery();
				tableObj.url  = url;
				datatable = datatableObj(tableObj);
  			}
		});

		/** 修改方法 **/
		function update() {
			var data=$(".Js_tdMenu").data("data");
			var selectId = data.idStr;
			
			
			window.location = "<%=basePath%>houseType/eidt.htm?entityId="+selectId; 
			
		}
		/** 查看详情 **/
		function detail() {
			var data=$(".Js_tdMenu").data("data")
			var selectId = data.idStr;
			// 明细弹出框
			var commonDialog = commonOpenDialog("readDetail",'详细',700,450, '<%=basePath%>houseType/detail.htm?entityId=' + selectId);
			commonDialog.addBtn("ok",'确定', commonDialog.cancel);
		}
		/** 按条件查询 **/
		function highQuery() {
			// 查询条件 区域名称
			var areaName_filter = '';
			var returnVal = '<%=basePath%>houseType/list.htm?orgCode=${sessionScope.accountInfo.orgCode}';
			if(areaName_filter!=''){
				returnVal += '&nameFilter=' + encodeURI(encodeURI(areaName_filter));
			}
			return returnVal;
		}
		/** 删除**/
		function deleteAll() { 
			var rows=getSeleteObjs(datatable);
			if(rows.length!=1){
				fh.alert("请选择一条记录");
				return;
			}else{

				var rows=getSeleteObjs(datatable);
				var actionUrl = "<%=basePath%>houseType/delete.htm?code=${vo.code}&entityIds=";
				batchDelete( {rows:rows,idField:"idStr",actionUrl:actionUrl});
				
			} 	
		}
	</script>
		
</html>

<script language="javascript" type="text/javascript">
           
</script>

