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
<title>角色修改</title>
</head>
	<body>
		<div  class="form-mod">
			<form:form commandName="form" id="form" action="../user/save.htm" method="post">
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							用户信息
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>	
						<td class="hd" >
							登录名称
							<span class="field-tips"></span>
						</td>
						<td >
							${form.uiLoginName}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							用户名称
							<span class="field-tips"></span>
						</td>
						<td >
							${form.uiName}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							学号/工号
							<span class="field-tips"></span>
						</td>
						<td >
							${form.uiNum}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							性别
							<span class="field-tips"></span>
						</td>
						<td >
							${form.uiSexStr}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							手机号码
							<span class="field-tips"></span>
						</td>
						<td >
							${form.uiMobile}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							邮箱
							<span class="field-tips"></span>
						</td>
						<td >
							${form.uiEmail}
						</td>
					</tr>
				</tbody>
				</table>
			</form:form>
		</div>
		<script type="text/javascript">
			document.body.style.backgroundColor="white";
		</script>
</body>
</html>