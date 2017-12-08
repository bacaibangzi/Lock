<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<script type="text/javascript" src="<%=basePath %>common/js/jqueryByImg.js"></script>
	<script type="text/javascript" src="<%=basePath %>common/js/ajaxupload.js"></script>
	<jsp:include page="/common/include/includeform.jsp" />
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
<html>
<head>
<title>类型编辑</title>
</head>
	<body style="background:transparent">
		<div  class="form-mod">
			<form:form commandName="form" id="form" action="../houseType/save.htm" method="post">
				<input type="hidden" name="sn" value="${form.sn}"/> 
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							类型编辑
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>	
						<td class="hd" >
							名称
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="name"  cssClass="input-text {required: true, maxlength: 32}"/>
						</td>
					</tr>
					
					<tr>
						<td class="hd" >
							值
						</td>
						<td >
							<form:input path="value" cssClass="input-text {maxlength: 32}"/> 
						</td>
					</tr>
					
					<tr>
						<td class="hd" >
							排序
						</td>
						<td >
							<form:input path="paix" cssClass="input-text {maxlength: 32}"/> 
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