<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="left" style="overflow:auto; overflow-x:hidden; border:0px solid #000000;">
    <div class="leftmenu2" id="leftmenu">
        <ul>
        	<c:forEach items="${requestScope.leftMenu}" var="menu" varStatus="i">
        		<li id="menu_${i.count}"><a href='javascript:choosemenu(${i.count} ,"${menu.miUrl}" ,"${menu.miName}")'>
                <span class="forpng" style='background:url(<%=basePath%>${menu.miPic}) no-repeat; background-position:0px 5px;'>${menu.miName}</span></a>
                </li> 
        	</c:forEach>
        </ul>
    </div>
</div>
<script language="javascript" type="text/javascript">
    //选择定制菜单
    var choosedLeftMenuId ;
    function choosemenu(index,url,mm)
    {
        if(choosedLeftMenuId)
        {
        	document.getElementById("menu_"+choosedLeftMenuId).className="";
        }
        $(window.parent.document).find("#mainFrame").attr("src",url); 
        //var css = "leftmenu1_icon_m" + index + "active";
        var css = "active";
        document.getElementById("menu_"+index).className=css;
        choosedLeftMenuId = index;
		//alert(document.getElementById("menu"+index).className);
        /*
		var iframe = document.getElementById("mainFrame");  
		if (iframe.attachEvent) {  
			iframe.attachEvent("onload", function() {

				var resizeH = 800;
				$(window.parent.document).find("#mainFrame").contents().find("#Js_spitBarMod").height(resizeH);
				$(window.parent.document).find("#mainFrame").contents().find("#Js_mainMod").height(resizeH);
				$(window.parent.document).find("#mainFrame").contents().find("#Js_mainMod").find("iframe").height(resizeH);
				$(window.parent.document).find("#mainFrame").contents().find("#Js_asideMod").height(resizeH);
				$(window.parent.document).find("#mainFrame").contents().find("#Js_asideMod").find("iframe").height(resizeH);
				
			});  
		} else {  
			iframe.onload = function() {
				var resizeH = 800;
				$(window.parent.document).find("#mainFrame").contents().find("#Js_spitBarMod").height(resizeH);
				$(window.parent.document).find("#mainFrame").contents().find("#Js_mainMod").height(resizeH);
				$(window.parent.document).find("#mainFrame").contents().find("#Js_mainMod").find("iframe").height(resizeH);
				$(window.parent.document).find("#mainFrame").contents().find("#Js_asideMod").height(resizeH);
				$(window.parent.document).find("#mainFrame").contents().find("#Js_asideMod").find("iframe").height(resizeH);
			};  
		} 
        */
        $("#ctl00_top1_navigation").html("当前位置："+mm);

		//alert($(window.parent.document).find("#mainFrame").contents().getElementById("ctl00_top1_navigation"));
        
    }

 

	
</script>
