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
<title>组织机构修改</title>
</head>
	<body>
		<div  class="form-mod">
			<form:form commandName="form" id="form" action="../agOrg/save.htm" method="post">
				<input type="hidden" name="code" value="${vo.code}"/>
				<input type="hidden" name="oiId" value="${form.oiId }" />
				<input type="hidden" name="oiCode" value="${form.oiCode }" />
				<input type="hidden" name="orgType" value="${vo.orgType}" />
				<input type="hidden" name="oiType" value="1" />
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							经销商信息
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="hd" >
							经销商编码
							<span class="field-tips"></span>
						</td>
						<td >
							${form.oiCode}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							经销商名称
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="oiName"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
					<!--  
					<tr>	
						<td class="hd" >
							机构类型
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:select path="oiType" items="${orgTypeMap}"  cssClass="input-select {required: true}"/> 
						</td>
					</tr>
					-->
					<tr>
						<td class="hd" >
							备注
							<span class="field-tips"></span>
						</td>
						<td >
							<form:textarea  path="oiMemo" rows="5" cols="26" cssClass="input-area {required: true, maxlength: 20}" />
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
		    	var orgType = "${vo.orgType}";
			    if(orgType==""){
				    fh.alert("请先选择上级组织机构！");
				    return false;
			    }
		    	var validate = $("#form").validate({meta:"validate"});
				if(validate.form()){
		    		$("#form").submit();  
		   		}
		   	}
		</script>
</body>
</html>