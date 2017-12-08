<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/include/includejs.jsp" />
<script type="text/javascript" src="<%=basePath %>/common/js/idTabs.js"></script>
<%
	//新增按钮
	String addMenu = "7802783440559203414";
	//修改
	String updateMenu = "7291201182524030468";
	//删除
	String delMenu = "6610433833513736115";
	//查看
	
%>
<html>
<style type="text/css">
.tabsbox ul {
	border-bottom: 1px solid #dce6e7;
}

.tabsbox ul li {
	display: inline-block;
	border: 1px solid #dce6e7;
	border-bottom: none;
	line-height: 30px;
	height: 30px;
	width: 80px;
	text-align: center;
	margin-right: 10px;
}

.tabsbox ul li a.selected {
	background-color: #fff;
	display: block;
	margin: 0px;
	padding-bottom: 5px;
	font-weight: bold;
}

.tabsbox ul li a {
	text-decoration: none;
}

.tabscont {
	margin-top: 10px;
}
</style>
<body>
	 <div id="usual1" class="tabsbox"> 
			  <ul> 
			    <li><a href="#tab1" class="selected">未执行</a></li> 
			    <li><a href="#tab2">执行失败</a></li> 
			  </ul> 
		 <div id="tab1" class="tabscont">
		 	<iframe id="Js_commTree" name="group_tree1" id="group_tree1" width="100%" src="<%=basePath%>fail/main1.htm" frameborder="0" scrolling="no" height="800px;">
			</iframe>
		 </div>
	 
  		<div id="tab2" style="background-color:">
		 	<iframe id="Js_commTree" name="group_tree2" id="group_tree2" width="100%" src="<%=basePath%>fail/main2.htm" frameborder="0" scrolling="no" height="800px;">
			</iframe>
  		</div> 
			
    </div>
</body>	 
</html>
	<script type="text/javascript"> 
	  $("#usual1 ul").idTabs(); 
	</script>
<script type="text/javascript">
	document.body.style.backgroundColor="white";
	
	$(document).ready(function(){
		var resizeH = window.parent.document.body.clientHeight - 150 ;
		$("#group_tree1").height(resizeH);
		$("#group_tree2")height(resizeH);
		
		close_spit();
	})
</script>

