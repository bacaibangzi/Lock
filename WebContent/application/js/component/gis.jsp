<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.google.gson.JsonObject"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="com.google.gson.JsonArray"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.fiberhome.sss.locating.util.Constants
         ,com.fiberhome.sss.locating.util.map.PositionInfo
         ,com.fiberhome.sss.locating.util.LocationUtil;" %>
         
<%!
public static final Logger LOG = LoggerFactory.getLogger("com.fiberhome.jsp.application.js.componet.gis");
%>         
<%
	String path = request.getContextPath();
%>
<%
	String[] lonlats = request.getParameterValues("flatlng");
	JsonArray jsArr  = new JsonArray();

	for(int i=0;i<lonlats.length;i++)
	{
		String lonlat = lonlats[i];
	    if(lonlat == null) 
	    {
	        lonlat = Constants.MAP_INIT_LOCATION_DEF;
	    }
	
	    String mapLonlat="",mapAddr="";
	    String lat="",lon="";
	    try 
	    {
	        PositionInfo info = LocationUtil.getMapPoi(lonlat);
	        if(info != null)
	        {
		        mapLonlat  = LocationUtil.formatPoiGps(info);
		        if(mapLonlat.indexOf(",") > -1) {
		            String[] ll = mapLonlat.split(",");
		            if(ll.length == 2)
		            {
		                mapLonlat = ll[1] +"," + ll[0];
		                lat = ll[1];
		                lon = ll[0];
		            }
		        }
		        mapAddr = LocationUtil.formatPoiAddr(info);
	    	}
	    } catch(Exception e)
	    {
	        mapLonlat = lonlat;
	        LOG.error("", e);
	    }
	    
	    JsonObject obj = new JsonObject();
	    obj.addProperty("lat", lat);
	    obj.addProperty("lon", lon);
		obj.addProperty("addr", mapAddr);	    

		jsArr.add(obj);
	}
%>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <link type="text/css" href="<%=path %>/common/css/all.css" rel="stylesheet" />
        
  	    <script type="text/javascript" src="<%=path %>/common/js/jquery-1.7.2.min.js"></script> 
  	    <jsp:include page="/common/js/gis/map_include.jsp"/>

        <script type="text/javascript">
        window.map    = null;
        window.maplet = null;
        var pointList = <%= jsArr.toString() %>;
        $(document).ready(function(){
            try {
            	if(pointList.length == 0)
           		{
            		alert("No data to display");
            		return;
           		}
           		
		        var firstPoint = pointList[0];
		        if(firstPoint.lat == null || firstPoint.lat == '' || firstPoint.lat == ' ' || firstPoint.lat == 'undefined')
		        {
		        	firstPoint = pointList[1];
		        }
              	winResize();
                window.map = new FMap("map_div");
                map.setClickToCenter(false);
                map.zoom(new FLatLng(firstPoint.lat, firstPoint.lon),12);
                for(var i=0;i<pointList.length;i++)
               	{
               		var point = pointList[i];
               		if(point.lat !=null && point.lat !='' && point.lat !=' ' && point.lat !='undefined')
	                {
	                	drawPoint(new FLatLng(point.lat, point.lon), point.addr, getImgIconByIdx(i));
	                }
               	}
            } catch(e) {
                alert(e);
            }
        });
        
        function drawPoint(latlng, addrMsg, imgPath) {
            var pointCfg = {};
            pointCfg.path    = imgPath || "<%=path %>/common/js/gis/selected.png";
            pointCfg.width   = 15;
            pointCfg.height  = 15;
            pointCfg.anchorX = 7;
            pointCfg.anchorY = 7;
            map.mark(latlng,null,pointCfg,null,null,addrMsg);
        }
        
        function getImgIconByIdx(idx)
        {
        	var imgArr = [
        	              "<%=path %>/common/js/gis/selected.png",
        	              "<%=path %>/common/js/gis/gps3.png"];
        	
        	return imgArr[idx%imgArr.length];
        }
        
        function winResize()
        {
       		var width = $(top.document.getElementById("lhgdg_content_lookuop_dlg")).width();
       		var height = $(top.document.getElementById("lhgdg_content_lookuop_dlg")).height();
       		if(document.all){
       			width = width + 2;
       		}
       		if(null == width || null == height)
       		{
       			width   = '${param.width}';
       			height  = '${param.height}';
       		}
            if(window.maplet)
               map.resize(width, height);
            $("#map_div").css({width:width,height:height});
        }
        //页面大小调整时调整地图界面
        window.onresize = winResize;
    </script>
    </head>
	<body >
	   <div id="map_div"></div>
	   <div id="error" style="display:none;">地图加载错误，请检查网络后重新登录！</div>
    </body>
</html>