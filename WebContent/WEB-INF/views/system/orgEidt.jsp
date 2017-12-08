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
			<form:form commandName="form" id="form" action="../org/save.htm?orgType=${vo.orgType}" method="post">
				<input type="hidden" name="code" value="${vo.code}"/>
				<input type="hidden" name="oiId" value="${form.oiId }" />
				<input type="hidden" name="oiCode" value="${form.oiCode }" />
				<input type="hidden" name="areaCode" value="${vo.code }" />
				<table class="form-table" width="100%" border="0" cellspa3cing="0" cellpadding="0">
				<colspan>
					<col class="w_30per" />
					<col class="w_60per" />
				</colspan>
				<thead>
					<tr>
						<th colspan="2" class="form-hd">
							部门信息
						</th>
						<tr>
					</tr>
				</thead>
				<tbody>
					 
					<tr>
						<td class="hd" >
							上级部门
							<span class="field-tips"></span>
						</td>
						<td >
							${vo.code2}
						</td>
					</tr>
					
					<tr>	
						<td class="hd" >
							部门名称
							<span class="field-tips">*</span>
						</td>
						<td >
							<form:input path="oiName"  cssClass="input-text {required: true, maxlength: 20}"/>
						</td>
					</tr>
					
					<tr>
						<td class="hd" >
							备注
							<span class="field-tips"></span>
						</td>
						<td >
							<form:textarea  path="oiMemo" rows="5" cols="26" cssClass="input-area { maxlength: 20}" />
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
			    if("${vo.code2}"!=""){
			    	orgType = "${vo.code2}";
			    }
			    var oiType = $("#oiType").val();
			    if("${vo.orgType}"==""){
				    fh.alert("请先选择上级组织机构！");
				    return false;
			    }
			    var entityId = "${vo.entityId}";
			    if(entityId!=""&&oiType==4&&orgType!=4){
			    	var flag=null;
			    	var orgCode="${vo.orgCode}";
			    	if(orgType!=2){
			    		orgCode=orgCode.substring(0,orgCode.length-4);
			    	}
				    $.ajax({
					    url:"<%=basePath%>org/checkOiType.htm",
					    type:"post",
					    async: false,
					    data:"orgCode="+orgCode+"&orgType="+oiType,
					    success:function(data){
						    flag = data;
					    }
				    });
				    if(flag==false){
					    fh.alert("连锁机构下只能有一个总店！");
					    return false;
				    }
			    }else {
				    //判断总店数量是否正确
				    if((orgType==2&&oiType==4)||(orgType==3&&oiType==4)){
					    var flag=null;
					    $.ajax({
						    url:"<%=basePath%>org/checkOiType.htm",
						    type:"post",
						    async: false,
						    data:"orgCode=${vo.code}&orgType="+oiType,
						    success:function(data){
							    flag = data;
						    }
					    });
					    if(flag==false){
						    fh.alert("连锁机构下只能有一个总店！");
						    return false;
					    }
				    }
			    }
		    	var validate = $("#form").validate({meta:"validate"});
				if(validate.form()){
		    		$("#form").submit();  
		   		}
		   	}

			function selectAreaTree()
			{
				var commonDialog = commonOpenDialog("readDetail",'选择区域',700,450, '<%=basePath%>area/selectAreaTree.htm?orgCode=${sessionScope.accountInfo.orgCode}');
				commonDialog.addBtn("cancel",'取消', commonDialog.cancel);
				commonDialog.addBtn("ok",'确定', function()
				{
					var areaCode = $("#areaCode", commonDialog.dgDoc).val();
					var areaName = $("#areaName", commonDialog.dgDoc).val();

					document.getElementById('areaCode').value = areaCode;
					document.getElementById('areaName').value = areaName;

					
					commonDialog.cancel();
				});
	 
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
		</script>
</body>
</html>