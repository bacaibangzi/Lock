<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include/includejs.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>test</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" /> 
		<meta http-equiv="description" content="This is my page" />
		<style type="text/css">
			ul{
				list-style-type: none;
				margin:0;
				padding:0;
			}
		</style>
		
		<script type="text/javascript">
			function showMsg(){alert();
				var allLi = document.getElementsByTagName("LI");
				var message = "";
				for(var i = 0; i < allLi.length; i++){
					message = message + allLi[i].innerHTML;
				}
				var isChild =  document.getElementById("isChild").value;
				if(isChild == null || isChild == "" ){
					fh.alert(message, false, handleError);
				}else{
					fh.alert(message, true, null,frameElement.lhgDG);
				}
			}
			
			function handleError()
			{
				document.getElementById("return").submit();
			}
		</script>
	</head>

	<body onload="showMsg()">
        <div style="display:none"><s:actionerror/></div>
        <s:form id="return" action="return">
        	<s:hidden name="menuId"></s:hidden>
        	<s:hidden name="isChild" id="isChild"></s:hidden>
        </s:form>
	</body>
	
	
</html>
