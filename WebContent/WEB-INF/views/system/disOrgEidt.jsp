<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/include/includeform.jsp" />
<html>
<head>
<title>组织机构修改</title>
</head>
	<body>
		<div  class="form-mod">
			<form:form commandName="form" id="form" action="../disOrg/save.htm" method="post">
				<input type="hidden" name="code" value="${vo.code}"/>
				<input type="hidden" name="oiId" value="${form.oiId }" />
				<input type="hidden" name="oiCode" value="${form.oiCode }" />
				<input type="hidden" id="orgType" name="orgType" value="${vo.orgType}" />
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							门店信息
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="hd" >
							门店编码
							<span class="field-tips"></span>
						</td>
						<td >
							${form.oiCode}
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							门店名称
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="oiName"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							机构类型
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:select path="oiType" items="${orgTypeMap}"  cssClass="input-select {required: true}" onchange="explain();"/> 
							<label id="explain" style="color:red;"></label>
						</td>
					</tr>
					<tr>	
						<td class="hd" >
							到期日期
							<span class="field-tips">*</span>
						</td>
						<td >
							<input name="dqDate" id="dqDate"  class="input-text {maxlength: 20}"  value="${form.dqDateString}"
								readonly="readonly"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
						</td>
					</tr>
					<tr>
						<td class="hd" >
							备注
							<span class="field-tips"></span>
						</td>
						<td >
							<form:textarea  path="oiMemo" rows="5" cols="26" cssClass="input-area {required: true, maxlength: 20}" />
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
				//判断当是编辑时orgType的值
				if("${vo.code1}"!=""){
					$("#orgType").val("${vo.code1}");
				}
				//机构类型说明
				var oiType = $("#oiType").val();
				if(oiType==0){
					$("#explain").html("公司,顶层管理机构,其下可管理维护经销商机构,不直接管理基础资料等");
				}else if(oiType==1){
					$("#explain").html("经销商,其下可管理维护餐饮连锁、超市连锁、餐饮单店和超市单店机构,不直接管理基础资料等");
				}else if(oiType==2){
					$("#explain").html("餐饮连锁机构,其下可管理维护连锁、加盟和分部机构,不直接管理餐饮基础资料等");
				}else if(oiType==3){
					$("#explain").html("超市连锁机构,其下可管理维护连锁、加盟和分部机构,不直接管理超市基础资料等");
				}else if(oiType==4){
					$("#explain").html("总店,直接管理基础资料等,连锁店的一种,餐饮连锁会员信息存放于总店机构下");
				}else if(oiType==5){
					$("#explain").html("连锁,直接管理基础资料等,连锁店的一种");
				}else if(oiType==6){
					$("#explain").html("加盟,直接管理基础资料等,连锁店的一种");
				}else if(oiType==7){
					$("#explain").html("餐饮单店,直接管理餐饮基础资料等");
				}else if(oiType==8){
					$("#explain").html("超市单店,直接管理超市基础资料等");
				}else if(oiType==9){
					$("#explain").html("分部,其下可管理维护连锁、加盟机构,不直接管理基础资料等");
				}
				$("#form").validate();
			});

			// 返回
	        function returnUrl(){
	        	history.go(-1);
			}
			<%-- 内容保存 --%>
		    function submitCheck(){
		    	var orgType = "${vo.orgType}";
			    if(orgType==""){
				    fh.alert("请先选择上级组织机构！");
				    return false;
			    }
		    	var validate = $("#form").validate({meta:"validate"});
				if(validate.form()){
		    		$("#form").submit();  
		   		}
		   	}
		    
		    //机构类型说明
		    function explain(){
		    	var oiType = $("#oiType").val();
		    	if(oiType==0){
					$("#explain").html("公司,顶层管理机构,其下可管理维护经销商机构,不直接管理基础资料等");
				}else if(oiType==1){
					$("#explain").html("经销商,其下可管理维护餐饮连锁、超市连锁、餐饮单店和超市单店机构,不直接管理基础资料等");
				}else if(oiType==2){
					$("#explain").html("餐饮连锁机构,其下可管理维护连锁、加盟和分部机构,不直接管理餐饮基础资料等");
				}else if(oiType==3){
					$("#explain").html("超市连锁机构,其下可管理维护连锁、加盟和分部机构,不直接管理超市基础资料等");
				}else if(oiType==4){
					$("#explain").html("总店,直接管理基础资料等,连锁店的一种,餐饮连锁会员信息存放于总店机构下");
				}else if(oiType==5){
					$("#explain").html("连锁,直接管理基础资料等,连锁店的一种");
				}else if(oiType==6){
					$("#explain").html("加盟,直接管理基础资料等,连锁店的一种");
				}else if(oiType==7){
					$("#explain").html("餐饮单店,直接管理餐饮基础资料等");
				}else if(oiType==8){
					$("#explain").html("超市单店,直接管理超市基础资料等");
				}else if(oiType==9){
					$("#explain").html("分部,其下可管理维护连锁、加盟机构,不直接管理基础资料等");
				}
		    }
		    
		    if($("#dqDate").val()==''){
		    	var now = new Date();
			    now.setFullYear(now.getFullYear()+1);
			    $("#dqDate").val(curentTime());
		    }
		    
		    //$("#dqDate").val(curentTime1());
		    
		    function curentTime(){ 
		        var now = new Date();
		        var year = now.getFullYear() + 1;       //年
		        var month = now.getMonth();     //月
		        var day = now.getDate();            //日
		        var hh = now.getHours();            //时
		        var mm = now.getMinutes();          //分
		        var ss = now.getSeconds();
		        var clock = year + "-";
		        if(month < 10)
		            clock += "0";
		        clock += month + "-";
		        if(day < 10)
		            clock += "0";
		        clock += day + " ";
		        if(hh < 10)
		            clock += "0";
		        clock += hh + ":";
		        if (mm < 10) clock += '0'; 
		        clock += mm+ ":"; 
		        if (ss < 10) ss += '0'; 
		        clock += ss; 
		        return(clock); 
	    } 
		</script>
</body>
</html>