<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/include/includejs.jsp" />

<html>
<head>
<title>测试</title>
</head>
<body>
	<div style="font-weight: bold; font-size: 15px; margin-top: 20px;margin-left: 15px" >连锁会员充值退卡/退现汇总报表</div>
    <div class="contenbox">
			<div class="sprite_mod">
				<a class="Js_showSearch mod_opts" hidfocus="true" id="searchnav">展开查询条件</a>
			</div>
    
    
    		<!-- 表格列表过滤条件设置 -->
			<div class="filter-mod">
				<ul class="filter-list">
				
				
					
					<li class="filter-item">
						<label class="filter-label">
							开始时间
						</label>
						<input type="text" class="input-text {required: true, maxlength: 20}" id="dateStr1" name="dateStr1"
								readonly="readonly"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
					</li>
					
					<li class="filter-item">
						<label class="filter-label">
							结束时间
						</label>
						<input type="text" class="input-text {required: true, maxlength: 20}" id="dateStr2" name="dateStr2"
								readonly="readonly"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
						
					</li>
					
					<li class="filter-item">
						<label class="filter-label">
							会员编号
						</label>
						<input type="text" class="input-text {required: true, maxlength: 20}" id="mno" name="mno"/>
						
					</li>
					
					<li class="filter-item">
						<label class="filter-label">
							电话号码
						</label>
						<input type="text" class="input-text {required: true, maxlength: 20}" id="mtel" name="mtel"/>
						
					</li>
					
					<li class="filter-item">
						<label class="filter-label">
							组织机构
						</label>
						<input type="text" class="filter-text" id="orgName" name="orgName" readonly="readonly"/>
						<button onclick="showOrgTree()">.</button>
						<input type="hidden" id="orgCode" name="orgCode" />
					</li>
					
					
					<li class="filter-item filter-btns">
						<a hideFocus="true" class="gray_radiu_btn Js_searchTable">
							 <em class="gray_l"></em> 
							 <em class="gray_r"></em> 
							  <spring:message code="system.query" />
						</a>
						<a hideFocus="true" href="javascript:clearForm('filter-mod');" id="add" class="gray_radiu_btn Js_reLoadTable"> 
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							  <spring:message code="system.clear" />
						 </a>
					</li>
				</ul> 
			</div>
			<div>
			
				<form name="paraForm" method="post" target="reportFrame"> 
				</form>
				<iframe id="reportFrame" name="reportFrame" frameborder="no" border="0" width="100%" height="600" ></iframe>  
			</div>
    </div>

</body>

	<!-- 日期控件 -->
	<script type="text/javascript" src="<%=path%>/common/js/datapicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(function(){
			//自动填上账号所属机构信息
			var orgCode="${sessionScope.accountInfo.orgCode}";
			var orgName="";
			$.ajax({
				url:"<%=basePath%>org/getOrgName.htm",
				type:"post",
				async:false,
				data:"orgCode="+orgCode,
				success:function(data){
					orgName=decodeURI(data);
				}
			});
			if(orgName!="false"){
				document.getElementById('orgCode').value = orgCode;
				document.getElementById('orgName').value = orgName;
			}
		});
		//  /CateSystem/ReportServer?reportlet=/Area.cpt
		$(".filter-mod").show();

		$(".Js_searchTable").live("click",function(){
			var dateStr1 = $.trim(document.getElementById('dateStr1').value);
			var dateStr2 = $.trim(document.getElementById('dateStr2').value);
			var orgCode = $.trim(document.getElementById('orgCode').value);
			var mno = $.trim(document.getElementById('mno').value);
			var mtel = $.trim(document.getElementById('mtel').value);
			if(orgCode==''){
				fh.alert('请选择需要查询的门店！');
				return false;
			}
			//var reportURL = "/CateSystem/ReportServer?reportlet=/ChongzTuik.cpt&dateStr1="+dateStr1 + "&dateStr2=" + dateStr2+ "&orgCode=" + orgCode+"&mno="+mno+"&mtel="+mtel;
			var reportURL = "/CateSystem/ReportServer?reportlet=/ChongzTuik.cpt&dateStr1="+dateStr1 + "&dateStr2=" + dateStr2+ "&orgCode=" + orgCode+ "&orgCode1=" + orgCode+"&mno="+mno+"&mtel="+mtel;
		    document.paraForm.action = reportURL; //通过form的name获取表单，并将报表访问路径赋给表单的action  
		    document.paraForm.submit(); //触发表单提交事件
			
		});

		var orgCode = "";
		var orgName = "";
		function showOrgTree()
		{

			var commonDialog = commonOpenDialog("readDetail",'选择组织',700,450, '<%=basePath%>caipxfmx/orgTree.htm?orgCode=${sessionScope.accountInfo.orgCode}');
			commonDialog.addBtn("cancel",'取消', commonDialog.cancel);
			commonDialog.addBtn("ok",'确定', function()
			{
				orgCode = $("#orgCode", commonDialog.dgDoc).val();
				orgName = $("#orgName", commonDialog.dgDoc).val();

				document.getElementById('orgCode').value = orgCode;
				document.getElementById('orgName').value = orgName;
				
				commonDialog.cancel();
			});
		}

		$("#dateStr1").val(curentTime1());
		$("#dateStr2").val(curentTime());

		function curentTime(){ 
	        var now = new Date();
	        var year = now.getFullYear();       //年
	        var month = now.getMonth() + 1;     //月
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

		function curentTime1(){ 
	        var now = new Date();
	        var year = now.getFullYear();       //年
	        var month = now.getMonth() + 1;     //月
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
	        
	        clock += "00";
	        clock +=  ":";
	        clock += '00'; 
	        clock += ":"; 
	        clock += '00'; 
	        return(clock);  
	    }





		
	</script>	
	
	
</html>