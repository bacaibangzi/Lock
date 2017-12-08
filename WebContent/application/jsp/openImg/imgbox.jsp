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
  		<a href="" id="Js_roatLeft">向左转</a>
  		<a href="" id="Js_roatRight">向右转</a>
  		<a href="" id="Js_zoomImg">放大</a>
  		<a href="" id="Js_reduceImg">缩小</a>
  		<a href="" id="Js_realImg">实际大小</a>
  		<a href="" id="Js_download">下载</a>
   </div>
   <div class="view_img">
      <img id="Js_optImg" src=""/>
   </div>
   <script type="text/javascript">
   	   //IE滤镜解决旋转问题
       var roate=0;
       var imgangle = null;
       var dlg = frameElement.lhgDG;
	   $(document).ready(function(){
	   	var imgId = dlg.getArgs().param;
	   	var img = "<%=path %>/photoupload/photoDownload.action?photoUploadId="+imgId;
	   	var downloadImg = "<%=path %>/photoupload/downloadPhotoReally.action?photoUploadId="+imgId;
	   	$("#Js_optImg").attr("src",img);
	   	//$("#Js_download").attr("href",img);
	   	$("#Js_download").attr("href",downloadImg);
	   	
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
	   	$("#Js_zoomImg").click(function(){
	   		$("#Js_optImg").width($("#Js_optImg").width()*1.2)
	   		$("#Js_optImg").height($("#Js_optImg").height()*1.2)
	   		return false;
	   	})
	   	//缩小
	   	$("#Js_reduceImg").click(function(){
	   		$("#Js_optImg").width($("#Js_optImg").width()/1.2)
	   		$("#Js_optImg").height($("#Js_optImg").height()/1.2)
	   		return false;
	   	})
	   	//实际大小
	   	$("#Js_realImg").click(function(){
	  	 	roate = 0;
	   		imgangle = 0;
	   		$("#Js_optImg").removeAttr("style");
	   		return false;
	   	})
	   	//下载
	   })

   </script>
  </body>
</html>

