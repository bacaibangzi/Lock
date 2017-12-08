<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String webfilesPath = path+"/webfiles";
%>
/**
 * 定位模板选择
 * 
 * @param id
 *            (对象的id域)
 * @param name
 *            (对象的name域)
 * @param handle
 *            (选择业务后执行的回调函数,可以不写)
 * @param selType
 *            (是否多选,0-单选，1-多选类型1,2-多选类型2)
 */
function locationModelShow(id,name,handle,index) {
	var width = 800;
	var flatlng = flatlng || "";
	var handle = handle || "";
	flatlng = $('#' + id).val();
/**
	var url = '../../../app/location/locationmodel/locationmodel_modellist.action';
	fh.lookup(id, name, "400", width, handle, 0, "定位模板选择",url,{type:'locmodel',index:index});
*/
}

/**
 * GIS定位择框
 * 
 * @param id
 *            (权限对象的id域)
 * @param flatlng
 *            (经纬度用逗号分割)
 * @param handle
 *            (选择业务后执行的回调函数,可以不写)
 * 
 */
function gisShow(id, flatlng, handle) {
	var width = 600;
	var height = 400;
	var flatlng = flatlng || "";
	var handle = handle || "";
	if(!flatlng&&!id){
	   flatlng = $('#' + id).val();
	}
	var url = '<%=path %>/application/js/component/gis.jsp?' + 'flatlng=' + flatlng;
	fh.lookup(id, "", height, width, handle, 0, "地图定位", url, {type:'gismodel'});
}
	