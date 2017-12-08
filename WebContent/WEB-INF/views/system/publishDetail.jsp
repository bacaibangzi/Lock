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
							${form.name }
						</td>
					</tr>
					<tr>
						<td class="hd" >
							备注
							<span class="field-tips"></span>
						</td>
						<td >
							${form.remark }
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
							<img id="vHeader1" src="${form.img1Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img1Path}" width="110" height="185" ></img>
							&nbsp;
							<input type="hidden" name="img2Path" id="img2Path" value="${form.img2Path}"/>	
							<img id="vHeader2" src="${form.img2Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img2Path}" width="110" height="185" ></img>
							&nbsp;
							<input type="hidden" name="img3Path" id="img3Path" value="${form.img3Path}"/>	
							<img id="vHeader3" src="${form.img3Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img3Path}" width="110" height="185" ></img>
							&nbsp;
							<input type="hidden" name="img4Path" id="img4Path" value="${form.img4Path}"/>	
							<img id="vHeader4" src="${form.img4Path eq '' ?'http://noi.qianzhi8.com/common/images/nr.png':form.img4Path}" width="110" height="185" ></img>
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
							
							<input type="button" id="wenjianDown" onclick="downFile()" value="下载文件"></input>
						</td>
					</tr>
				</tbody>
				</table>
			</form:form>
		</div>
		
		<!-- 弹出框控件 -->
		<script type="text/javascript" src="../common/js/tree/js/tree.js"></script>
		<!-- 日期控件 -->
		<script type="text/javascript" src="../common/js/datapicker/WdatePicker.js"></script>
		<script type="text/javascript">
			document.body.style.backgroundColor="white";
			$(function(){
				$("#form").validate();
			});

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