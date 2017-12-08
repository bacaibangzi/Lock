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
				<input type="hidden" name="userid" value="${form.userId}" />
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
							APP Key
							<span class="field-tips">*</span>
						</td>
						<td >
							${form.appkey}
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
							<img id="vHeader" src=${form.iconPath eq '' ?'http://noi.qianzhi8.com/common/images/icon.png':form.iconPath} width="80" height="80" />
							
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
							<button id="vHeader1" style="background:url(${form.img1Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img1Path}) no-repeat; width:110px; height:185px;" ></button>
							&nbsp;
							<input type="hidden" name="img2Path" id="img2Path" value="${form.img2Path}"/>	
							<button id="vHeader2" style="background:url(${form.img2Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img2Path}) no-repeat; width:110px; height:185px;" ></button>
							&nbsp;
							<input type="hidden" name="img3Path" id="img3Path" value="${form.img3Path}"/>	
							<button id="vHeader3" style="background:url(${form.img3Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img3Path}) no-repeat; width:110px; height:185px;" ></button>
							&nbsp;
							<input type="hidden" name="img4Path" id="img4Path" value="${form.img4Path}"/>	
							<button id="vHeader4" style="background:url(${form.img4Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img4Path}) no-repeat; width:110px; height:185px;" ></button>
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
							<img id="vHeader" src=${form.filePath eq '' ?'http://noi.qianzhi8.com/common/images/unup.png':'http://noi.qianzhi8.com/common/images/up.png'} width="80" height="80" />
							<button id="addLabProdPic">下载文件</button>
							
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
		    
		</script>
</body>
</html>