<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.fiberhome.sss.locating.util.LocationUtil;" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String mapType =LocationUtil.getMapType();
%>

<html>
  <head>
  	<script type="text/javascript" src="<%=path %>/common/js/gis/<%=mapType%>.js"></script>
  </head>
  <body>
  </body>
</html>
