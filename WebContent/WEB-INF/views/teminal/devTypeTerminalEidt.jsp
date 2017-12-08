<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/include/includeform.jsp" />
<html>
<head>
<title>控制器信息</title>
 <style>
 	.btn {   
		BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 0px; BORDER-BOTTOM: #2C59AA 1px solid ;width:42px;height:22px; 
	} 
 </style>
</head>
<body>
		<input type="hidden" id="ids">
		<div  class="form-mod">
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan> 
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							人员类型
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="hd" >
							人员类型
							<span class="field-tips"></span>
						</td>
						<td >
							<select name="type"  class="filter-select"  id="type"  >
							<c:forEach items="${typeMap}" var="item">
								 <option value="${item.key}">${item.value}</option>
							</c:forEach>
						</select>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							人员类型含义
							<span class="field-tips"></span>
						</td>
						<td > 
							<input name="hany"  id="hany"  class="input-text {maxlength: 120}" />
						</td>
					</tr> 
					<tr>	
						<td class="hd" >
							有效期
							<span class="field-tips"></span>
						</td>
						<td > 
							<input name="youXq"  id="youXq"  class="input-text {maxlength: 20}" />&nbsp;年
						</td>
					</tr> 
					<tr>
						<th colspan="2" class="form-hd">
							门组结构
						</th>
						<tr>
					</tr>
					<tr>
						<td colspan="2" style="height:40%;">
						<div >
							<div class="box"  id="srccontent1">
								<iframe id="Js_commTree" name="group_tree" width="100%" height="220"
										src="<%=basePath%>startCard/rightCenterTop.htm?orgCode=${vo.orgCode}&code1=${vo.code1}&orgType=${vo.orgType}" frameborder="0"
										bordercolor="blue" scrolling="auto">
								</iframe>	
							</div>
							<div class="box1"  id="srccontent33">
								<iframe id="srccontent3" name="srccontent3" width="100%" height="220" 
										src="<%=basePath%>startCard/rightCenterDown.htm?orgCode=${vo.orgCode}" frameborder="0"
										bordercolor="blue" scrolling="auto">
								</iframe>	
							</div>
						</div>
						</td>
					</tr>
				</tbody>
				</table>
		</div>
		<script type="text/javascript" src="<%=path%>/common/js/datapicker/WdatePicker.js"></script>
		<script>
			document.body.style.backgroundColor="white";
			
			var orgCode = "";
			var orgName = "";
			function showOrgTree()
			{
				var mdDialog = commonOpenDialog("mdDialog",'选择部门',700,450, '<%=basePath%>caipxfmx/orgTree1.htm?orgCode=0000');

				/**/
				mdDialog.addBtn("cancel",'取消', mdDialog.cancel);
				mdDialog.addBtn("ok",'确定', function()
				{
					orgCode = $("#orgCode", mdDialog.dgDoc).val();
					orgName = $("#orgName", mdDialog.dgDoc).val();

					//document.getElementById('examineOrgCode').value = orgCode;
					//document.getElementById('examineOrgName').value = orgName;
					$("#bm").val(orgName);
					mdDialog.cancel();
				});
			}
			
			
			function fak(){
				if(orgCode==''){
					fh.alert("请选择部门!");
					return;
				}
				
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
					url: '<%=path %>/devcmdlist/bumfak.htm', 
					data: "code1=1"+  
					  	  "&dateStr2=" + youXq +
					  	  "&code=" + orgCode +
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
			
		</script>
</body>
</html>