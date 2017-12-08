<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=basePath %>common/js/jqueryByImg.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/ajaxupload.js"></script>
<jsp:include page="/common/include/includeform.jsp" />
<html>
<head>
<title>角色修改</title>
</head>
	<body>
		<div  class="form-mod">
			<form:form commandName="form" id="form" action="../apps/save.htm" method="post">
				<input type="hidden" name="sn" value="${form.sn }" />
				<input type="hidden" name="state" value="${form.state }" />
				<input type="hidden" name="appid" value="${form.appid }" />
				<input type="hidden" name="appkey" value="${form.appkey }" />
				<input type="hidden" name="userid" value="${sessionScope.accountInfo.userId}" />
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							APP信息
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>	
						<td class="hd" >
							APP ID
							<span class="field-tips">*</span>
						</td>
						<td >
							${form.appid}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							名称
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="name"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
					<tr>
						<td class="hd" >
							备注
							<span class="field-tips"></span>
						</td>
						<td >
							<form:textarea rows="3" cols="26" path="remark"  cssClass="input-area {required: true, maxlength: 20}" />
						</td>
					</tr>
					<tr>
						<td class="hd" >
							项目图标
							<span class="field-tips"></span>
						</td>
						<td >
							<input type="hidden" name="iconPath" id="iconPath" value="${form.iconPath}"/>
							<img id="vHeader" src=${form.iconPath eq '' ?'http://noi.qianzhi8.com/common/images/icon.png':form.iconPath}  width="80" height="80" />
							<button id="addLabProdPic">上传图片</button>
							
						</td>
					</tr>
					<tr>
						<td class="hd" >
							内容截图
							<span class="field-tips"></span>
						</td>
						<td >
							<input type="hidden" name="img1Path" id="img1Path" value="${form.img1Path}"/>
							<!-- <img id="vHeader" src=${form.iconPath eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.iconPath} width="110" height="185" /> -->
							<button id="vHeader1" style="background:url(${form.img1Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img1Path}) no-repeat; width:110px; height:185px; background-size:110px 185px;" width="110" height="80" ></button>
							&nbsp;
							<input type="hidden" name="img2Path" id="img2Path" value="${form.img2Path}"/>	
							<button id="vHeader2" style="background:url(${form.img2Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img2Path}) no-repeat; width:110px; height:185px; background-size:110px 185px;" ></button>
							&nbsp;
							<input type="hidden" name="img3Path" id="img3Path" value="${form.img3Path}"/>	
							<button id="vHeader3" style="background:url(${form.img3Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img3Path}) no-repeat; width:110px; height:185px; background-size:110px 185px;" ></button>
							&nbsp;
							<input type="hidden" name="img4Path" id="img4Path" value="${form.img4Path}"/>	
							<button id="vHeader4" style="background:url(${form.img4Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img4Path}) no-repeat; width:110px; height:185px; background-size:110px 185px;" ></button>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td class="hd" >
							项目文件
							<span class="field-tips"></span>
						</td>
						<td >
							<input type="hidden" name="filePath" id="filePath" value="${form.filePath}"/>
							<img id="fHeader" src=${form.filePath eq '' ?'http://noi.qianzhi8.com/common/images/unup.png':'http://noi.qianzhi8.com/common/images/up.png'} width="80" height="80" />
							<button id="wenjian" >上传文件</button>
							<input type="button" id="wenjianDown" onclick="downFile()" value="下载文件"></input>
							
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

			//	$("#fHeader").css({"background-image":"url(http://noi.qianzhi8.com/common/images/up.png)","background-size":"110px 185px"});

			function downFile(){
				var path =  $("#filePath").val();
				window.location.href = path;
			}
			
			var path =  $("#filePath").val();
			if(path&&path!=""){
				$("#wenjianDown").show();
			}else{
				$("#wenjianDown").hide();
			}
			
			// 返回
	        function returnUrl(){
	        	//history.go(-1); 
	        	window.location.href = "<%=basePath %>apps/main.htm";
			}
			<%-- 内容保存 --%>
		    function submitCheck(){
		    	var validate = $("#form").validate({meta:"validate"});
				if(validate.form()){
		    		$("#form").submit();  
		   		}
		   	}
		    
		  	//上传图片
 			new AjaxUpload('#addLabProdPic', {
 				action: '<%=basePath%>user/uploadFileByImg.htm?userName=${sessionScope.accountInfo.userName}', 
 				name: 'picFile',
 				responseType: 'json',
 				onSubmit : function(file , ext){
 					if (ext && /^(jpg|png|bmp)$/.test(ext.toLowerCase())){
 						this.setData({
 							'picName': file
 						});
 					} else {
 						alert("请上传格式为 jpg|png|bmp 的图片！");
 						return false;				
 					}
 				},
 				onComplete : function(file,response){
 					if(response.error) {
 						alert(response.error);
 						return;
 					}
 					$("#vHeader").attr("src",response.picUrl);
 					///window.parent.document.getElementById("img").value=response.picUrl;
 					$("#iconPath").val(response.picUrl);
 				}		
 			});		
		    
		  	//内容图片1
 			new AjaxUpload('#vHeader1', {
 				action: '<%=basePath%>user/uploadFileByImg.htm?userName=${sessionScope.accountInfo.userName}', 
 				name: 'picFile',
 				responseType: 'json',
 				onSubmit : function(file , ext){
 					if (ext && /^(jpg|png|bmp)$/.test(ext.toLowerCase())){
 						this.setData({
 							'picName': file
 						});
 					} else {
 						alert("请上传格式为 jpg|png|bmp 的图片！");
 						return false;				
 					}
 				},
 				onComplete : function(file,response){
 					if(response.error) {
 						//alert(response.error);
 						return;
 					}
 					$("#img1Path").val(response.picUrl);
 					///window.parent.document.getElementById("img").value=response.picUrl;
 					$("#vHeader1").css({"background-image":"url("+response.picUrl+")","background-size":"110px 185px"});
 				}		
 			});	   	
		    
		  	//内容图片2
 			new AjaxUpload('#vHeader2', {
 				action: '<%=basePath%>user/uploadFileByImg.htm?userName=${sessionScope.accountInfo.userName}', 
 				name: 'picFile',
 				responseType: 'json',
 				onSubmit : function(file , ext){
 					if (ext && /^(jpg|png|bmp)$/.test(ext.toLowerCase())){
 						this.setData({
 							'picName': file
 						});
 					} else {
 						alert("请上传格式为 jpg|png|bmp 的图片！");
 						return false;				
 					}
 				},
 				onComplete : function(file,response){
 					if(response.error) {
 						alert(response.error);
 						return;
 					}
 					$("#img2Path").val(response.picUrl);
 					///window.parent.document.getElementById("img").value=response.picUrl;
 					$("#vHeader2").css({"background-image":"url("+response.picUrl+")","background-size":"110px 185px"});
 				}		
 			});	    	
		    
		  	//内容图片3
 			new AjaxUpload('#vHeader3', {
 				action: '<%=basePath%>user/uploadFileByImg.htm?userName=${sessionScope.accountInfo.userName}', 
 				name: 'picFile',
 				responseType: 'json',
 				onSubmit : function(file , ext){
 					if (ext && /^(jpg|png|bmp)$/.test(ext.toLowerCase())){
 						this.setData({
 							'picName': file
 						});
 					} else {
 						alert("请上传格式为 jpg|png|bmp 的图片！");
 						return false;				
 					}
 				},
 				onComplete : function(file,response){
 					if(response.error) {
 						alert(response.error);
 						return;
 					}
 					$("#img3Path").val(response.picUrl);
 					///window.parent.document.getElementById("img").value=response.picUrl;
 					$("#vHeader3").css({"background-image":"url("+response.picUrl+")","background-size":"110px 185px"});
 				}		
 			});	
   	
		    
		  	//内容图片4
 			new AjaxUpload('#vHeader4', {
 				action: '<%=basePath%>user/uploadFileByImg.htm?userName=${sessionScope.accountInfo.userName}', 
 				name: 'picFile',
 				responseType: 'json',
 				onSubmit : function(file , ext){
 					if (ext && /^(jpg|png|bmp)$/.test(ext.toLowerCase())){
 						this.setData({
 							'picName': file
 						});
 					} else {
 						alert("请上传格式为 jpg|png|bmp 的图片！");
 						return false;				
 					}
 				},
 				onComplete : function(file,response){
 					if(response.error) {
 						alert(response.error);
 						return;
 					}
 					$("#img4Path").val(response.picUrl);
 					///window.parent.document.getElementById("img").value=response.picUrl;
 					$("#vHeader4").css({"background-image":"url("+response.picUrl+")","background-size":"110px 185px"});
 				}		
 			});	
		  	
 			//文件上传
 			new AjaxUpload('#wenjian', {
 				action: '<%=basePath%>user/uploadFileByImg.htm?userName=${sessionScope.accountInfo.userName}', 
 				name: 'picFile',
 				responseType: 'json',
 				onSubmit : function(file , ext){//alert("up");
 					$("#wenjianDown").hide();
 					if (ext && /^(apk)$/.test(ext.toLowerCase())){
 						this.setData({
 							'picName': file
 						});
 					} else {
 						alert("请上传格式为 apk 的文件！");
 						return false;				
 					}
 				},
 				onComplete : function(file,response){
 					if(response.error) {
 						alert(response.error);
 						return;
 					}
 					//alert("上传app："+response.picUrl);
 					$("#filePath").val(response.picUrl);
 					///window.parent.document.getElementById("img").value=response.picUrl;
 					$("#fHeader").attr("src","http://noi.qianzhi8.com/common/images/up.png");
 					$("#fHeader").attr("width","80");
 					$("#fHeader").attr("height","80");
 					$("#wenjianDown").show();
 				}
 			});	
		    
		</script>
</body>
</html>