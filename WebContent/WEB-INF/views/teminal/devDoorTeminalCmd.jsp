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
<title>门组修改</title>
</head>
	<body>
		<div  class="form-mod">
			<form:form commandName="form" id="form" action="../devDoorGroup/save.htm" method="post">
				<input type="hidden" name="sn" value="${form.sn }" />
				<input type="hidden" name="fisn" value="${form.fisn }" />
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							恢复出厂设置
						</th>
						<tr>
					</tr>
				</thead> 
					<tr>
						<td colspan="4">
							<input type="button" class="form-btn1" value="清空全部数据" onclick="qc1()" />
							<input type="button" class="form-btn1" value="清空全部名单存储" onclick="qc2();" />
							<input type="button" class="form-btn1" value="恢复所有默认配置" onclick="qc3();" />
							<input type="button" class="form-btn1" value="清空全部数据及名单" onclick="qc4();" />
							<input type="button" class="form-btn1" value="清空全部数据及名单并恢复所有默认配置" onclick="qc5();" />
						</td>
					</tr>
				</table>
			</form:form>
		</div>
		
		<!-- 弹出框控件 -->
		<script type="text/javascript" src="../common/js/tree/js/tree.js"></script>
		<!-- 日期控件 -->
		<script type="text/javascript" src="../common/js/datapicker/WdatePicker.js"></script>
		<script type="text/javascript">

			document.body.style.backgroundColor="white";
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
		    // 清空全部数据
		    function qc1(){
		    	$.ajax({ 
					type: "POST", 
					url: '<%=path %>/devcmdlist/qc1.htm', 
					data: "code1=1"+  
						  "&entityId=${vo.code }" ,
					success: function(msg){
						if(msg){
							alert('已成功发送指令');
						} else{
							alert('失败');
						}
					}
				});
		    }
		    // 清空全部名单存储
		    function qc2(){

		    	$.ajax({ 
					type: "POST", 
					url: '<%=path %>/devcmdlist/qc2.htm', 
					data: "code1=1"+  
						  "&entityId=${vo.code }" ,
					success: function(msg){
						if(msg){
							alert('已成功发送指令');
						} else{
							alert('失败');
						}
					}
				});
		    }
		    // 恢复所有默认配置
		    function qc3(){

		    	$.ajax({ 
					type: "POST", 
					url: '<%=path %>/devcmdlist/qc3.htm', 
					data: "code1=1"+  
						  "&entityId=${vo.code }" ,
					success: function(msg){
						if(msg){
							alert('已成功发送指令');
						} else{
							alert('失败');
						}
					}
				});
		    }
		    // 清空全部数据及名单
		    function qc4(){

		    	$.ajax({ 
					type: "POST", 
					url: '<%=path %>/devcmdlist/qc4.htm', 
					data: "code1=1"+  
						  "&entityId=${vo.code }" ,
					success: function(msg){
						if(msg){
							alert('已成功发送指令');
						} else{
							alert('失败');
						}
					}
				});
		    }
		    // 清空全部数据及名单并恢复所有默认配置
		    function qc5(){

		    	$.ajax({ 
					type: "POST", 
					url: '<%=path %>/devcmdlist/qc5.htm', 
					data: "code1=1"+  
						  "&entityId=${vo.code }" ,
					success: function(msg){
						if(msg){
							alert('已成功发送指令');
						} else{
							alert('失败');
						}
					}
				});
		    }
		    
		</script>
</body>
</html>