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
<title>mp</title>
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
							设置主控器自动上传IP和端口
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="hd" >
							服务器IP
							<span class="field-tips">*</span>
						</td>
						<td >
							<input type="input">
						</td>
					</tr>
					<tr>
						<td class="hd" >
							服务器端口
							<span class="field-tips"></span>
						</td>
						<td >
							<input type="input">
						</td>
					</tr>
					<tr>
						<td class="hd" >
							连接命令间隔时间
							<span class="field-tips"></span>
						</td>
						<td >
							<input type="input">
						</td>
					</tr> 
				</tbody>
				</table>
		</div>
		
		<!-- 弹出框控件 -->
		<script type="text/javascript" src="../common/js/tree/js/tree.js"></script>
		<!-- 日期控件 -->
		<script type="text/javascript" src="../common/js/datapicker/WdatePicker.js"></script>
		<script type="text/javascript">
			document.body.style.backgroundColor="white";
		</script>
</body>
</html>