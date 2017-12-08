<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=7,8,9,10,11"/>
<style type="text/css">
<!--
*{ margin:0; padding:0;}
.box{ border:1px solid #999999; width:100%; height:300px; margin-bottom:2px; margin-top:1px; overflow:hidden;}
.box1{ position:absolute!important;
 position:relative;
 top:110px!important;
 top:110;
 bottom:32px;
 width:100%;
 overflow:hidden;
 height:100%;
 left: 280px;
}
-->

		
</style>
</head>
<body>
	<!-- 动态引用页面头文件 -->
	<jsp:include page="/head1.htm" flush="true" />
    <script language="javascript" type="text/javascript">
        $().ready(function() {
            var url = this.location.href + "?tspan=" + (new Date());
            $.post(url, { load: 1 }, function(data) {
                //alert(data);
                if (data == 1) {
                    $("#vadd").hide();
                    $("#dvSync").show();
                } else {
                    $("#dvSync").hide();
                    $("#vadd").show();
                }
            });
        });

  	//载入中的GIF动画
    var loadingUrl = "../App_Themes/normal/images/ajax-loader.gif";
 
    
    </script>

    <script type="text/javascript" language="javascript">
        $("html").attr("style","overflow-x:hidden;overflow-y:auto");   
    </script>

    <div id="page">
        


        <!-- 左导航 -->
		<jsp:include page="/left1.htm" flush="true" />


    
		
		<jsp:include page="/footer1.htm" flush="true" />
				        	
    </div>
    
    <script type="text/javascript">
		window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
	</script>
	<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/typeahead-bs2.min.js"></script>	
	
	<script src="<%=basePath%>assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="<%=basePath%>assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="<%=basePath%>assets/js/jquery.slimscroll.min.js"></script>
	<script src="<%=basePath%>assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="<%=basePath%>assets/js/jquery.sparkline.min.js"></script>
	<script src="<%=basePath%>assets/js/flot/jquery.flot.min.js"></script>
	<script src="<%=basePath%>assets/js/flot/jquery.flot.pie.min.js"></script>
	<script src="<%=basePath%>assets/js/flot/jquery.flot.resize.min.js"></script>

	<!-- ace scripts -->
	<script src="<%=basePath%>assets/js/ace-elements.min.js"></script>
	<script src="<%=basePath%>assets/js/ace.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>common/layer/layer.js"></script>

	<script type="text/javascript">
	
	</script>
	

</body>
</html>

<script language="javascript" type="text/javascript">
	var choosedLeftMenuId ;
	function choosemenu(index,url){
		$(window.parent.document).find("#mainFrame").attr("src",url);
		//alert($(window.parent.document).find("#mainFrame").attr("src")); tab-content
		if(choosedLeftMenuId){
			document.getElementById(choosedLeftMenuId).className="";
		}
		document.getElementById(index).className="active";
		choosedLeftMenuId = index;
		

		$(window.parent.document).find(".tab-content").height(550);
		$(window.parent.document).find(".tab-pane").height(550);
		$(window.parent.document).find(".iframeClass").height(550);
	}
	
	function showLayer(){
		layer.load();
	}
	
	function hideLayer(){
		layer.closeAll('loading');
	}
	
	function showMessage(msg){
		layer.msg(msg, {icon: 6});
	}

</script>

