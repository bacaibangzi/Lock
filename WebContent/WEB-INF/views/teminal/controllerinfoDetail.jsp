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
			<form:form commandName="form" id="form" action="../area/save.htm" method="post">
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							控制器信息
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="hd" >
							ID
							<span class="field-tips"></span>
						</td>
						<td >
							${form.controllerId}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							站点 ID
							<span class="field-tips"></span>
						</td>
						<td >
							${form.stationId}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							信道
							<span class="field-tips"></span>
						</td>
						<td >
							${form.channel}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							控制器名
							<span class="field-tips"></span>
						</td>
						<td >
							${form.controllerName}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							控制器IP
							<span class="field-tips"></span>
						</td>
						<td >
							${form.ip}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							端口
							<span class="field-tips"></span>
						</td>
						<td >
							${form.port}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							位置
							<span class="field-tips"></span>
						</td>
						<td >
							${form.position}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							是否启用
							<span class="field-tips"></span>
						</td>
						<td >
							${form.isUse}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							备注
							<span class="field-tips"></span>
						</td>
						<td >
							${form.remark}
						</td>
					</tr>
				</tbody>
				</table>
			</form:form>
		</div>
		<script>
			document.body.style.backgroundColor="white";
		</script>
</body>
</html>