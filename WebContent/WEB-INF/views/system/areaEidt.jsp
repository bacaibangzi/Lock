<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<jsp:include page="/common/include/includeform.jsp" />
 	<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.3"></script>
<html>
<head>
<title>区域修改</title>
</head>
	<body>
		<div  class="form-mod">
			<form:form commandName="form" id="form" action="../area/save.htm" method="post">
				<input type="hidden" name="code" value="${vo.code}"/>
				<input type="hidden" name="areaParentCode" value="${vo.code}"/>
				<input type="hidden" name="areaId" value="${form.areaId }" />
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							区域信息
						</th>
						<tr>
						</tr>
				</thead>
				<tbody>
					<tr>
						<td class="hd" >
							区域编号
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="areaCode" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') " cssClass="input-text {required: true, maxlength: 16}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							区域名称
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="areaName"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
					<tr>
						<td class="hd" >
							经纬度
							<span class="field-tips"></span>
						</td>
						<td >
							<div style="width:520px;height:340px;border:1px solid gray" id="container"></div>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							lon
						</td>
						<td >
							<form:input path="lon" cssClass="input-select {maxlength: 20}"/> 
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							lat
						</td>
						<td >
							<form:input path="lat" cssClass="input-select {maxlength: 20}"/> 
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							是否是小区
						</td>
						<td >
							<form:checkbox path="qy" value="1" onclick="this.value=(this.value==0)?0:1"/>
						</td>
					</tr>
					<tr>
						<td class="hd" >
							备注
							<span class="field-tips"></span>
						</td>
						<td >
							<form:textarea rows="2" cols="26" path="areaMemo"  cssClass="input-area { maxlength: 100}"/>
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
				$("#form").validate();
			});

			// 百度地图API功能
			var map = new BMap.Map("container"); 
			map.centerAndZoom(new BMap.Point(118.78333, 32.05000), 11);  
			map.addControl(new BMap.MapTypeControl()); 
			map.setCurrentCity("南京"); 
			map.enableScrollWheelZoom(true); 
			map.addControl(new BMap.NavigationControl());
		    map.addControl(new BMap.OverviewMapControl()); 
		    map.addControl(new BMap.OverviewMapControl({ isOpen: true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT }));

		    map.addEventListener("click", function (e) {
		        document.getElementById("lon").value = e.point.lng;
		        document.getElementById("lat").value = e.point.lat;

		        map.clearOverlays();
		        var marker = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat));
		        map.addOverlay(marker);   
		    });
			
		    var lon = '${form.lon}';
		    var lat = '${form.lat}';
		    
		    if(lon!=''){
		    	map.clearOverlays();
		        var marker = new BMap.Marker(new BMap.Point(lon, lat));
		        map.addOverlay(marker); 
		    }
		    
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
		</script>
</body>
</html>