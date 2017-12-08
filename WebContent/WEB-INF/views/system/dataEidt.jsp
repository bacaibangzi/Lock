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
<title>字典项编辑</title>
</head>
	<body>
		<div  class="form-mod">
			<form:form commandName="form" id="form" action="../area/save.htm" method="post">
				<input type="hidden" name="orgCode" value="${vo.orgCode}"/>
				<input type="hidden" name="sn" id="sn" value="${form.sn }" />
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							字典项编辑
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>	
						<td class="hd" >
							字典项KEY
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="keys"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
					<tr>
						<td class="hd" >
							字典项编码
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="code" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') " cssClass="input-text {required: true, maxlength: 12}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							字典项名称
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="name"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
				</tbody>
				</table>
			</form:form>
		</div>
		
		<!-- 弹出框控件 -->
		<script type="text/javascript" src="../common/js/tree/js/tree.js"></script>
		<!-- 日期控件 -->
		<script type="text/javascript" src="../common/js/datapicker/WdatePicker.js"></script>
		<script type="text/javascript">
			document.body.style.backgroundColor="white";
			$(function(){
				$("#form").validate();
			});

			// 返回
	        function returnUrl(){
	        	history.go(-1);
			}
			<%-- 内容保存 --%>
		    function submitCheck(){
		    	var validate = $("#form").validate({meta:"validate"});
				if(validate.form()){
		    		$("#form").submit();  
		   		}
		   	}
		</script>
</body>
</html>