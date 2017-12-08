<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.fiberhome.sss.locating.util.Constants
         ,com.fiberhome.sss.locating.util.map.PositionInfo
         ,com.fiberhome.sss.locating.util.LocationUtil;" %>
<%
	String path = request.getContextPath();
%>
<%
    String location = null;
    try{
        location = Constants.MAP_INIT_LOCATION_DEF;
    }catch(Exception e){
        location = null;
    }
    
    location = (location == null? "31.99527,118.73444" : location); 

    String useProxy = null;
    try{
        useProxy = "1";
    }catch(Exception e){
        useProxy = null;
    }
    useProxy = (useProxy == null? "1" : useProxy); 
%> 
<script type="text/javascript">
    window.mapLocation = '<%=location %>';
    window.useProxy = <%=useProxy%>;
</script>
<jsp:include page="<%=path %>/common/js/gis/map_include.jsp"/>
<script type="text/javascript" src="<%=path %>/common/js/gis/search.js"></script>

