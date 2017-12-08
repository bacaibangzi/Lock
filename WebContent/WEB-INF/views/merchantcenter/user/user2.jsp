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
	<jsp:include page="/head.htm" flush="true" />
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
		<jsp:include page="/left.htm" flush="true" />


        <div id="right"   >
        	<iframe id='mainFrame'  name="mainFrame" src="<%=basePath%>center.htm" frameborder="0"  style="overflow-x:hidden;overflow-y:auto"></iframe>
        	<!-- 

            
            -->
        </div>
    </div>
    

	<jsp:include page="/footer.htm" flush="true" />

</body>
</html>

<script language="javascript" type="text/javascript">

</script>

