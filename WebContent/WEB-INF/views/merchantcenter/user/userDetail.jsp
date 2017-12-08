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
<title>区域信息</title>
 <style>
 	.btn {   
		BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 0px; BORDER-BOTTOM: #2C59AA 1px solid ;width:42px;height:22px; 
	} 
 </style>
</head>
<body>
		<div  class="form-mod">
			<form:form commandName="form" id="form" method="post">
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
							用户登录名称
							<span class="field-tips">*</span>
						</td>
						<td >
							${form.uiLoginName}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							用户姓名
							<span class="field-tips">*</span>
						</td>
						<td >
							${form.uiName}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							性别	
							<span class="field-tips">*</span>
						</td>
						<td >
							${form.uiSexStr}
						</td>
					</tr>
					<!-- 
					<tr>
						<td class="hd" >
							昵称
							<span class="field-tips"></span>
						</td>
						<td >
							${form.uiNickName}	
						</td>
					</tr>
					 -->
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
					<tr>
						<td class="hd" >
							角色
							<span class="field-tips"></span>
						</td>
						<td >
							${form.bm}	
						</td>
					</tr>
					<!-- 
					<tr>
						<td class="hd" >
							公司名称
							<span class="field-tips"></span>
						</td>
						<td >
							${form.uiCompany}	
						</td>
					</tr>
					<tr>
						<td class="hd" >
							公司地址
							<span class="field-tips"></span>
						</td>
						<td >
							${form.uiAddress}	
						</td>
					</tr>
					<tr>
						<td class="hd" >
							公司电话
							<span class="field-tips"></span>
						</td>
						<td >
							${form.uiTelphone}	
						</td>
					</tr>
					 -->
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" class="form-btn" value="修改" onclick="update();" id="saveNotesSub" />
						</td>
					</tr>
				</tfoot>
				</table>
			</form:form>
		</div>
		<script>
			document.body.style.backgroundColor="white";
			/** 修改方法 **/
			function update()
			{
				window.location = "<%=basePath%>merchantser/eidt.htm?orgCode=${vo.orgCode}&mark=userEdit&entityId="; 
			}
		</script>
</body>
</html>