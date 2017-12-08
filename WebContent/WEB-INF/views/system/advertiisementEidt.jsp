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
			<form:form commandName="form" id="form" action="../advertiisement/save.htm" method="post">
				<input type="hidden" name="orgCode" value="${vo.orgCode}"/>
				<input type="hidden" name="sn" value="${form.sn}"/>
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							广告信息
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>	
						<td class="hd" >
							图片
							<span class="field-tips">*</span>
						</td>
						<td >
							<input type="hidden" name="img" id="img" value="${form.img}"/>
							<img id="vHeader" src=${form.img eq '' ?'http://localhost/CateSystem/common/images/userNormal.png':form.img} width="80" height="80" />
							<button id="addLabProdPic">上传图片</button>
							
						</td>
					</tr>
					<tr>
						<td class="hd" >
							说明
							<span class="field-tips"></span>
						</td>
						<td >
							<form:input path="remark"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
					<tr>
						<td class="hd" >
							排序
							<span class="field-tips"></span>
						</td>
						<td >
							<form:input path="indexS"  cssClass="input-text {required: true, maxlength: 20}"/>
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
		    
			//上传图片
 			new AjaxUpload('#addLabProdPic', {
 				action: '<%=basePath%>common/uploadFileByImg.htm?userName=${sessionScope.accountInfo.userName}', 
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
 					$("#img").val(response.picUrl);
 				}
 			});	
		    
		</script>
</body>
</html>