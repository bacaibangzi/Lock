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
<title>菜单修改</title>
</head>
	<body>
		<div  class="form-mod">
			<form:form commandName="form" id="form" action="../menu/save.htm" method="post">
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							菜单信息
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="hd" >
							菜单名称
							<span class="field-tips"></span>
						</td>
						<td >
							${form.miName}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							菜单链接
							<span class="field-tips"></span>
						</td>
						<td >
							${form.miUrl}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							菜单图片
							<span class="field-tips"></span>
						</td>
						<td >
							${form.miPic}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							菜单排序
							<span class="field-tips"></span>
						</td>
						<td >
							${form.miIndex}
						</td>
					</tr>
					<tr>
						<td class="hd" >
							备注
							<span class="field-tips"></span>
						</td>
						<td >
							${form.miMemo}
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