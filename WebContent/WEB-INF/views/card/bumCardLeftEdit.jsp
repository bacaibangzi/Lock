<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<div  class="form-mod">
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan> 
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							部门发卡
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="hd" >
							选择部门
							<span class="field-tips"></span>
						</td>
						<td >
							<input id="bm" class="input-text {required: true, maxlength: 120}">
							<input type="button" onclick="showOrgTree()">.</input>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							有效期至
							<span class="field-tips"></span>
						</td>
						<td > 
							<input name="youXq"  id="youXq"  class="input-text {maxlength: 20}" 
								readonly="readonly"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" value="${rqStr}"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" cssClass="input-text { maxlength: 20}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							是否开反锁
							<span class="field-tips"></span>
						</td>
						<td > 
							<input type="checkbox" id="shiFfk" />
						</td>
					</tr> 
				</tbody>
					
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" class="form-btn" value="发卡" onclick="fak()" />
						</td>
					</tr>
				</tfoot>
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
				
				var fs = document.getElementById("shiFfk").checked?"1":"0";
				
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
					  	  "&num=" + fs +
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