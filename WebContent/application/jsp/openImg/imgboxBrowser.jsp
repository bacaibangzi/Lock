<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include/includedlg.jsp"%>

  <head>
   	 <script type="text/javascript" src="<%=path %>/common/js/imageview/jquery.rotate.js"></script>

   	<style type="text/css">
		body,html,div,body,tr,td{ text-align:center; background:transparent;}
   	</style>
  </head>
  <body>
  	<div class="optbox">
  		<a href="javascript:void(0);" id="Js_previous" >上一张</a>
  		<a href="javascript:void(0);" id="Js_roatLeft">向左转</a>
  		<a href="" id="Js_roatRight">向右转</a>
  		<a href="" id="Js_zoomImg">放大</a>
  		<a href="" id="Js_reduceImg">缩小</a>
  		<a href="" id="Js_realImg">实际大小</a>
  		<a href="" id="Js_download">下载</a>
  		<a href="" id="Js_next" >下一张</a>
   </div>
   <div class="view_img">
      <img id="Js_optImg" src=""/>
   </div>
   <script type="text/javascript">
	var debugOutput = function()
	{
		if(
				(typeof console     == 'undefined') || 
				(typeof console.log != 'function'))
		{
			return;
		}
		if(true)
		{
			console.log.apply(console, arguments);		
		}
	};

	   //IE滤镜解决旋转问题
    var roate=0;
    var imgangle = null;
	
	var initPage = function(imgId, param)
	{
		var viewImg     = "<%=path %>/photoupload/photoDownload.action?photoUploadId="+imgId;
	   	var downloadImg = "<%=path %>/photoupload/downloadPhotoReally.action?photoUploadId="+imgId;
	   	$("#Js_optImg").attr("src",viewImg)
	   	$("#Js_download").attr("href",downloadImg)
	   	
	   	 var w=$(window.top).outerWidth(true);
         var h=$(window.top).outerHeight(true);
         var b = $("#lhgdg_drag_showimg",window.top.document).outerHeight(true);
		 var e = h - b;
		 var d = e - 36;
         $(".view_img").css({"height":d,"width":"100%"})
         $("#lhgdlg_showimg",window.top.document).css({"height":h,"width":w,"left":"0"})
	   	
	   		//向右转
	   	$("#Js_roatRight").click(function(){
	   		if(roate==3){
	   			roate=0;
	   		}else
	   		roate+=1;
		   	var curangle = null;
	   		if(imgangle != null){
	   			curangle =  0;
	   		}else{
	   			curangle = $("#Js_optImg").getRotateAngle()!="" ? parseInt($("#Js_optImg").getRotateAngle()) : 0;
	   		}
	   		imgangle = null;
	   		var newangle=parseInt(curangle)+90
	   		if(document.all){
	   		  $("#Js_optImg")[0].style.filter = 'progid:DXImageTransform.Microsoft.BasicImage(rotation='+ roate +')';
	   		}
	   		else
	   		{
	   		$("#Js_optImg").rotate({angle:newangle})
	   		}
	   		return false;
	   	})
	   	//向左转
	   	$("#Js_roatLeft").click(function(){
	   		if(roate==0){
	   			roate=3
	   		}
	   		else
	   		roate-=1;
	   		var curangle = null;
	   		if(imgangle != null){
	   			curangle =  0;
	   		}else{
	   			curangle = $("#Js_optImg").getRotateAngle()!="" ? parseInt($("#Js_optImg").getRotateAngle()) : 0;
	   		}
	   		imgangle = null;
	   		var newangle=parseInt(curangle)-90
	   		if(document.all){
	   		  $("#Js_optImg")[0].style.filter = 'progid:DXImageTransform.Microsoft.BasicImage(rotation='+ roate +')';
	   		}
	   		else
	   		{
	   		$("#Js_optImg").rotate({angle:newangle})
	   		}
	   		return false;
	   	})
	   	//放大
	   	$("#Js_zoomImg").unbind("click").click(function(){
	   		$("#Js_optImg").width($("#Js_optImg").width()*1.2)
	   		$("#Js_optImg").height($("#Js_optImg").height()*1.2)
	   		return false;
	   	})
	   	//缩小
	   	$("#Js_reduceImg").unbind("click").click(function(){
	   		$("#Js_optImg").width($("#Js_optImg").width()/1.2)
	   		$("#Js_optImg").height($("#Js_optImg").height()/1.2)
	   		return false;
	   	})
	   	//实际大小
	   	$("#Js_realImg").unbind("click").click(function(){
	  	 	roate = 0;
	   		imgangle = 0;
	   		$("#Js_optImg").removeAttr("style");
	   		return false;
	   	})
	   	//下载
	   	
	   	//上下页
	   	if(!param)
   		{
	   		$("#Js_previous").hide();
	   		$("#Js_next").hide();
   		}
         
        param.current = imgId;
        
        var idx = -1;
        
        $.each(param.arr, function(c, e){
        	if(param.current == e.idStr)
       		{
        		idx = c;
       			return false;
       		}
        });
        
        var pre  = idx - 1;
        var next = idx + 1;
        
        var visibility = "";
        if(pre >= 0)
       	{
        	visibility = "visible";
       		$("#Js_previous").unbind("click")
       						 .click(function(){
       							 initPage(param.arr[pre].idStr, param);
       							 return false;
       						 });
       	}
        else
       	{
        	visibility = "hidden";
       	}
        $("#Js_previous").css("visibility", visibility);
        
        if(next < param.arr.length)
       	{
        	visibility = "visible";
       		$("#Js_next").unbind("click")
       					 .click(function(){
       						 initPage(param.arr[next].idStr, param)
       						return false;
       					 });
       	}
        else
       	{
        	visibility = "hidden";
       	}
        $("#Js_next").css("visibility", visibility);
        
	};
	
	function loadParentParameter()
    {
		var dg = frameElement.lhgDG;
		var args = dg.getArgs();
		var param = args.param;

		debugOutput(param);
		return param;
    }
   
   
   	   $(document).ready(function(){
		   	var param = loadParentParameter();
		   	var imgId=location.href.split("=")[1]
		   	initPage(imgId, param);
	   });

   </script>
  </body>
</html>

