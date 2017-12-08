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
<title>注册商户</title>
</head>
	<body>
		<div  class="form-mod"><div style="color:#F00;font-size:22px;">${vo.errMsg}</div>
			<form:form commandName="form" id="form" action="../acountManage/save.htm" method="post">
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							修改密码
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>	
						<td class="hd" >
							原来密码
							<span class="field-tips">*</span>
						</td>
						<td >
							<input type="password" name="oldPassword" value=""  class="input-text {required: true, minlength: 6,maxlength: 20}"> 
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							新密码
							<span class="field-tips">*</span>
						</td>
						<td >
							<input id="password" type="password" name="uiPassword" value=""  class="input-text {required: true, minlength: 6,maxlength: 20}"> 
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							确认新密码
							<span class="field-tips">*</span>
						</td>
						<td >
							<input type="password" name="ruiPassword" value=""  class="input-text {required: true, minlength: 6,maxlength: 20,equalTo: '#password'}"> 
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" class="form-btn" value="保存" onclick="submitCheck()" id="saveNotesSub" />
							<input type="button" class="form-btn" value="返回" onclick="returnUrl();" />
						</td>
					</tr>
				</tfoot>
				</table>
			</form:form>
		</div>
		
		<!-- 弹出框控件 -->
		<script type="text/javascript" src="../common/js/tree/js/tree.js"></script>
		<!-- 日期控件 -->
		<script type="text/javascript" src="../common/js/datapicker/WdatePicker.js"></script>
		<script type="text/javascript">
			$(function()
			{
				$("#form").validate();
			});

			// 返回
	        function returnUrl()
	       	{
	        	parent.location.reload();
			}
			<%-- 内容保存 --%>
		    function submitCheck()
		    {
		    	var validate = $("#form").validate({meta:"validate"});
				if(validate.form())
				{
		    		$("#form").submit();  
		   		}
		   	}

		</script>
</body>
</html>