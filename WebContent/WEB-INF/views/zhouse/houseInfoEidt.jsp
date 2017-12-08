<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=basePath %>common/js/jqueryByImg.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/ajaxupload.js"></script>
<jsp:include page="/common/include/includeform.jsp" />

<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.3"></script>
<script type="text/javascript" src="<%=basePath %>/common/js/datatable/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/common/js/datatable/datatable.lnpagination.js"></script>
<script type="text/javascript" src="<%=basePath %>/common/js/datatable/jquery.datatable.columresize.js"></script>
 	
<html>
<head>
<title>房屋信息</title>
</head>
	<body>
		<div  class="form-mod">
			<form:form commandName="form" id="form" action="../houseInfo/save.htm" method="post">
				<input type="hidden" name="sn" value="${form.sn }" />
				<input type="hidden" name="userId" value="${form.userId}" />
				<input type="hidden" name="shenHe" value="${form.shenHe }" />
				<input type="hidden" name="lianXiRen" value="${form.lianXiRen }" />
				<input type="hidden" name="lianXiDianHua" value="${form.lianXiDianHua }" />
				<input type="hidden" name="chaoXiang" value="${form.chaoXiang }" />
				<input type="hidden" name="zhuangXiu" value="${form.zhuangXiu }" />
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_15per" />
					<col class="w_35per" />
					<col class="w_15per" />
					<col class="w_35per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="4" class="form-hd">
							房屋信息
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>	
						<td class="hd" colspan="1">
							标题
							<span class="field-tips">*</span>
						</td>
						<td  colspan="3">
							<form:input path="biaoTi"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
					<tr>
						<td class="hd"  colspan="1">
							租房图片
							<span class="field-tips"></span>
						</td>
						<td  colspan="3">
							<input type="hidden" name="img1Path" id="img1Path" value="${form.img1Path}"/>
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
							方式
						</td>
						<td >
							<form:select path="fangShi" id="fangShi" cssClass="input-select {required: true}"> 
								<form:options items="${fangShiMap}" />
							</form:select>
						</td>
						<td class="hd" >
							建筑面积
						</td>
						<td >
							<form:input path="jianZhuMianJi"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							户型
						</td>
						<td >
							<form:input path="huXing1"  cssClass="input-text {required: true, maxlength: 20}"/>室
							<form:input path="huXing2"  cssClass="input-text {required: true, maxlength: 20}"/>厅
							<form:input path="huXing3"  cssClass="input-text {required: true, maxlength: 20}"/>卫
							
						</td>
						<td class="hd" >
							租金
						</td>
						<td >
							<form:input path="zuJin"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
						<!--  
						<td class="hd" >
							朝向
						</td>
						<td >
							<form:select path="chaoXiang" id="chaoXiang" cssClass="input-select {required: true}"> 
								<form:options items="${chaoXiangMap}" />
							</form:select>
						</td>
						-->
					</tr>
					<tr>	
						<td class="hd" >
							配套
						</td>
						<td colspan="3">
							<form:checkbox path="ptChuang" id="ptChuang" value="1"/>床&nbsp;&nbsp;
							<form:checkbox path="ptKuangDai" id="ptKuangDai" value="1"/>宽带&nbsp;&nbsp;
							<form:checkbox path="ptDianShi" id="ptDianShi" value="1"/>电视&nbsp;&nbsp;
							<form:checkbox path="ptXiYiJi" id="ptXiYiJi" value="1"/>洗衣机&nbsp;&nbsp;
							<form:checkbox path="ptNuanQi" id="ptNuanQi" value="1"/>暖气&nbsp;&nbsp;
							<form:checkbox path="ptKongTiao" id="ptKongTiao" value="1"/>空调&nbsp;&nbsp;
							<form:checkbox path="ptBinXiang" id="ptBinXiang" value="1"/>冰箱&nbsp;&nbsp;
							<form:checkbox path="ptReShuiQi" id="ptReShuiQi" value="1"/>热水器&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td class="hd" >
							房屋描述
							<span class="field-tips"></span>
						</td>
						<td colspan="3">
							<form:textarea rows="4" cols="88" path="fangWuMiaoShu"  cssClass="input-area {required: true, maxlength: 255}" />
						</td>
					</tr>
					<tr>
						<td class="hd" >
							小区描述
							<span class="field-tips"></span>
						</td>
						<td colspan="3">
							<form:textarea rows="4" cols="88" path="xiaoQuMiaoShu"  cssClass="input-area {required: true, maxlength: 255}" />
						</td>
					</tr>
					<tr>
						<td class="hd" >
							地址
							<span class="field-tips"></span>
						</td>
						<td >
							<form:input path="diZhi"  cssClass="input-text {required: true, maxlength: 255}"/>
						</td>
						<td class="hd" >
							房屋所属小区
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="xiaoQuMingCheng"  cssClass="input-text {required: true, maxlength: 255}"/>
							<!--  
							<form:hidden path="xiaoQu"/>
							<input type="button" class="form-btn" value="选择小区"  id="xzxq" />
							-->
						</td>
						
					</tr>
					<tr>
						<td class="hd" >
							经纬度
							<span class="field-tips"></span>
						</td>
						<td colspan="3">
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
						<td class="hd" >
							lat
						</td>
						<td >
							<form:input path="lat" cssClass="input-select {maxlength: 20}"/> 
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<!--  <input type="button" class="form-btn" value="保存" onclick="submitCheck()" id="saveNotesSub" />-->
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
	        	window.location.href = "<%=basePath %>houseInfo/main.htm";
			}
			<%-- 内容保存 --%>
		    function submitCheck(){
		    	var validate = $("#form").validate({meta:"validate"});
				if(validate.form()){
		    		$("#form").submit();  
		   		}
		   	}
		    
			$("#xzxq").click(function(){
				showXiaoQu();
			});  
		     
		    function showXiaoQu(){
				
				var mdDialog = commonOpenDialog("mdDialog",'选择小区',700,450, '<%=basePath%>houseInfo/orgTree.htm',null,null,null,null);

				/**/
				mdDialog.addBtn("cancel",'取消', mdDialog.cancel);
				mdDialog.addBtn("ok",'确定', function()
				{
					
					orgCode = $("#orgCode", mdDialog.dgDoc).val();
					orgName = $("#orgName", mdDialog.dgDoc).val();

					document.getElementById('xiaoQu').value = orgCode;
					document.getElementById('xiaoQuMingCheng').value = orgName;
					
					mdDialog.cancel();
				});
				
		    }
		    
		    	
		    /**/
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
		  	
 			
		    
		</script>
</body>
</html>