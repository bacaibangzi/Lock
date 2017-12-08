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
				<input type="hidden" name="code" value="${vo.code}"/>
				<input type="hidden" name="fiId" value="${vo.code}"/>
				<input type="hidden" name="miId" value="${form.miId }" />
				<input type="hidden" name="miLevel" value="${form.miLevel }" />
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
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="miName" cssClass="input-text {required: true, maxlength: 50}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							菜单链接
							<span class="field-tips"></span>
						</td>
						<td >
							<form:input path="miUrl"  cssClass="input-text {maxlength: 200}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							菜单图片
							<span class="field-tips"></span>
						</td>
						<td >
							<form:input path="miPic"  cssClass="input-text {maxlength: 50}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							菜单排序
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="miIndex"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
					<tr>
						<td class="hd" >
							备注
							<span class="field-tips"></span>
						</td>
						<td >
							<form:textarea rows="5" cols="26" path="miMemo"  cssClass="input-area { maxlength: 100}"/>
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