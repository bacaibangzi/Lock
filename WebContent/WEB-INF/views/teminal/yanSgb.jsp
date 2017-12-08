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
<title>角色修改</title>
</head>
	<body>
		<div  class="form-mod"><div style="color:#F00;font-size:22px;">${vo.errMsg}</div>
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							延时关闭
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					
					
					<tr>	
						<td class="hd" >
							关闭日期
						</td>
						<td >
							<input name="dateStr1"  id="dateStr1"  class="input-text {maxlength: 20}"  
								readonly="readonly"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" cssClass="input-text { maxlength: 20}"/>
						</td>
					</tr>
					
				</tbody>
				</table>
		</div>
		
		<!-- 弹出框控件 -->
		<script type="text/javascript" src="../common/js/tree/js/tree.js"></script>
		<!-- 日期控件 -->
		<script type="text/javascript" src="../common/js/datapicker/WdatePicker.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#form").validate();
			});

			document.body.style.backgroundColor="white";

			// 返回
	        function returnUrl(){
	        	history.go(-1);
			}
		</script>
</body>
</html>