<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/common/include/includedlg.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	</head>
	<body>
		<%
			String imgid = request.getParameter("imgid");
		%>
		<img
			src="<%=path%>/photoupload/photoDownload.action?photoUploadId=<%=imgid%>" />
	</body>
</html>