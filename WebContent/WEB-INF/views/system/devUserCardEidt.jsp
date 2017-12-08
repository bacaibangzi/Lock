<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/include/includeform.jsp" />
<html>
<head>
<title>卡编号修改</title>
</head>
	<body>
		<div  class="form-mod">
			<div style="color:#F00;font-size:22px;">${vo.errMsg}</div><br>
			<form:form commandName="form" id="form" action="../devUserCard/save.htm" method="post"> 
				<input type="hidden" name="sn" value="${form.sn }" />
				<input type="hidden" name="userId" value="${form.userId }" /> 
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							卡编号信息
						</th>
						<tr>
					</tr>
				</thead>
				<tbody> 
					<tr>	
						<td class="hd" >
							卡编号
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="cardNum"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr> 
					<tr>	
						<td class="hd" >
							卡类型
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:select path="type" id="type" items="${typeMap}" cssClass="input-select {required: true}"></form:select>
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
				//判断当是编辑时orgType的值
				if("${vo.code1}"!=""){
					$("#orgType").val("${vo.code1}");
				} 
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
		    
		    //$("#dqDate").val(curentTime1());
		    
		    function curentTime(){ 
		        var now = new Date();
		        var year = now.getFullYear() + 1;       //年
		        var month = now.getMonth();     //月
		        var day = now.getDate();            //日
		        var hh = now.getHours();            //时
		        var mm = now.getMinutes();          //分
		        var ss = now.getSeconds();
		        var clock = year + "-";
		        if(month < 10)
		            clock += "0";
		        clock += month + "-";
		        if(day < 10)
		            clock += "0";
		        clock += day + " ";
		        if(hh < 10)
		            clock += "0";
		        clock += hh + ":";
		        if (mm < 10) clock += '0'; 
		        clock += mm+ ":"; 
		        if (ss < 10) ss += '0'; 
		        clock += ss; 
		        return(clock); 
	    } 
		</script>
</body>
</html>