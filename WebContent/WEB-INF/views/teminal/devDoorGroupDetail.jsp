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
							门组信息
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="hd" >
							门组名称
							<span class="field-tips"></span>
						</td>
						<td >
							${form.name}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							门组地址
							<span class="field-tips"></span>
						</td>
						<td >
							${form.memo}
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