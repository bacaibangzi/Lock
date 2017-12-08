<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<form:form commandName="form" id="form" action="../merchantser/save.htm" method="post">
				<input type="hidden" name="uiOrgCode" value="${form.uiOrgCode}"/>
				<input type="hidden" name="uiId" value="${form.uiId }" />
				<input type="hidden" name="uiSh" value="${form.uiSh }" />
				<input type="hidden" name="uiType" value="${form.uiType }" />
				<input type="hidden" name="orgCode" value="${vo.orgCode }" />
				<input type="hidden" name="mark" value="${param.mark}" />
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
							<c:if test="${form.uiId==null}">
								<form:input path="uiLoginName"  cssClass="input-text {required: true, maxlength: 20}"/>
							</c:if>
							<c:if test="${form.uiId!=''}">
								${form.uiLoginName}
							</c:if>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							用户姓名
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="uiName"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							性别
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:select path="uiSex" items="${sexMap}"  cssClass="input-select {required: true}"/> 
						</td>
					</tr>
					<!-- 
					<tr>	
						<td class="hd" >
							昵称
							<span class="field-tips"></span>
						</td>
						<td >
							<form:input path="uiNickName"  cssClass="input-text {maxlength: 20}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							省份
							<span class="field-tips"></span>
						</td>
						<td >
							<form:select path="uiProvince" id="uiProvince" cssClass="input-select {required: true}"> 
								<form:option value="0">---请选择省份---</form:option>
								<form:options items="${provinceMap}" />
							</form:select>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							城市
							<span class="field-tips"></span>
						</td>
						<td >
							<form:select path="uiCity" id="uiCity" cssClass="input-select {required: true}"> 
								<form:option value="0">---请选择城市---</form:option>
								<form:options items="${cityMap}" />
							</form:select>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							区域
							<span class="field-tips"></span>
						</td>
						<td >
							<form:select path="uiArea" id="uiArea" cssClass="input-select {required: true}"> 
								<form:option value="0">---请选择区域---</form:option>
								<form:options items="${areaMap}" />
							</form:select>
						</td>
					</tr>
					 -->
					<tr>	
						<td class="hd" >
							手机号码
							<span class="field-tips"></span>
						</td>
						<td >
							<form:input path="uiMobile"  cssClass="input-text {maxlength: 20}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							邮箱
							<span class="field-tips"></span>
						</td>
						<td >
							<form:input path="uiEmail"  cssClass="input-text {maxlength: 60}"/>
						</td>
					</tr>
					<!-- 
					<tr>	
						<td class="hd" >
							公司名称
							<span class="field-tips"></span>
						</td>
						<td >
							<form:input path="uiCompany"  cssClass="input-text {maxlength: 20}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							公司地址
							<span class="field-tips"></span>
						</td>
						<td >
							<form:input path="uiAddress"  cssClass="input-text {maxlength: 20}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							公司电话
							<span class="field-tips"></span>
						</td>
						<td >
							<form:input path="uiTelphone"  cssClass="input-text {maxlength: 20}"/>
						</td>
					</tr>
					 -->
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
	        	history.go(-1);
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

		    // 省联动
		    $("#uiProvince").change(function()
			{
		    	var pro=$("#uiProvince").val();

				$.ajax({
					type: "POST",
					url: "../merchantser/ajaxArea.htm",
					data: 
					{ 
						code:pro
			        },
					dataType: 'json',
					success: function(data) 
					{
			             $("#uiCity option").remove();//清空原来的选项

			             $("#uiCity").append("<option value='0'>---请选择城市---</option>") ;
					     $.each(data,function(key,value)
						 { 
					    	 $("#uiCity").append("<option value='"+key+"'> "+value+"</option>") ;
						 }); 
			        }
			  })
		    })
		    
		    
		    // 市联动
		    $("#uiCity").change(function()
			{
		    	var city=$("#uiCity").val();

				$.ajax({
					type: "POST",
					url: "../merchantser/ajaxArea.htm",
					data: 
					{ 
						code:city
			        },
					dataType: 'json',
					success: function(data) 
					{
			             $("#uiArea option").remove();//清空原来的选项
			             $("#uiArea").append("<option value='0'>---请选择区域---</option>") ;
					     $.each(data,function(key,value)
						 { 
					    	 $("#uiArea").append("<option value='"+key+"'> "+value+"</option>")  
						 }); 
			        }
			  })
		    })
		</script>
</body>
</html>