<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

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
	

		<!-- 右部面板 -->
		<div id="right">
		
			
		
		
		</div>
    </div>
    

	<jsp:include page="/footer.htm" flush="true" />

</body>
</html>

<script language="javascript" type="text/javascript">
           
</script>

