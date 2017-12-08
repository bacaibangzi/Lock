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
<title></title>
</head>
	<body>
		<div  class="form-mod">
			<form:form commandName="form" id="form" action="../devDoorGroup/save.htm" method="post">
				${vo.code1 }<br>
			</form:form>
		</div>
		
		<!-- 弹出框控件 -->
		<script type="text/javascript">
			document.body.style.backgroundColor="white";
		    
			// getCmdResult
			
			function show(){
				$.ajax({ 
					type: "POST", 
					url: '<%=basePath %>devDoorTeminal/getCmdResult.htm', 
					data: "entityId=${vo.code }",
					success: function(msg){
						//alert(msg.msg); typeof(value)=="
						if(msg.msg!=''&& typeof(msg.msg)!='undefined'){
							$("#form").append(msg.msg+"<br>");
						}
					}
				});
			}
			
			setInterval(show,5000);
			
		</script>
</body>
</html>