<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head><meta http-equiv="Content-Type" content="text/html;charset=UTF-8" /><title>
	我的账户总览-摇钱数
</title>

    <!--[if IE 6]>
    <script type="text/javascript" src='/js/DD_belatedPNG_0.0.8a.js'></script>
	<script type="text/javascript">
		DD_belatedPNG.fix('.sprite, .logo, .left_shadow, .forpng');
	</script>
	<![endif]-->
	<!-- 引用资源文件 -->
	<jsp:include page="/source.htm" />
	<script type="text/javascript">
		var count = -1;
		var sum = ${fn:length(sessionScope.topMenu)};
		var menus = new Array();
	</script>
</head>
<body>

    <div class="left_shadow" style="height: 30px">
    </div>
    
<div id="mainbodyheader">
    <div id="header">
        <div class="userinfo">
            <div class="avatar ">
                <img id="head_headerImg" src="${sessionScope.accountInfo.userImg eq null ?'common/images/userNormal.png':sessionScope.accountInfo.userImg}" width="50" height="50" />
            </div>
            <div style="height:40%;">
                <p><marquee  id="ctl00_header1_lblUserName" direction="left" style="color:white;">欢迎您，${sessionScope.accountInfo.userName}！用户</marquee ></p>
            </div>
            <div class="usermanager">
                <div class="usernav sprite">
                    <span><a href="<%=basePath%>toLogin.htm">退出</a></span><a href="<%=basePath%>">我的账户</a></div>
            </div>
        </div>
        <ul style="white-space: nowrap;">
        	<!--  
	        <li id="header5" onclick="left()">
	        	<img style="padding-top:22px;" src="<%=basePath%>common/images/left.png">
	        </li>
	        -->
        	<!-- 去除第一个索引 -->
        	<c:forEach items="${sessionScope.topMenu}" var="menu">
        		<c:if test="${menu.key ne 1}">
	        		<div id="menu${menu.value.miId}" name="menu">
	        		<li id="header${menu.value.miId}" ><a href="javascript:changeTopMenu('${menu.value.miId}')"
	                	class="forpng"><span class="navi1 forpng" style="background: url(<%=basePath%>${menu.value.miPic}) no-repeat;"></span>${menu.value.miName}</a></li>
	                </div>
                </c:if>
        	</c:forEach> 
            <li id="header5" onclick="choose()"><a title="操作指引" class="forpng" btname="系统帮助按钮"
                href='javascript:openHelp()'><span class="navi5 forpng" style="background: url(<%=basePath%>common/images/help.png) no-repeat;">
                </span>帮助</a>
            </li>
            
            <!--  
	         <li id="header5" onclick="right()">
	        	<img style="padding-top:22px;" src="<%=basePath%>common/images/right.png">
	        </li>
	        -->
        </ul>

        <div style="float:right; width:280px;position:relative; ">
        <div  style="float:left">
            <ul>
                <li><div class="logo"></div></li>
            </ul>
        </div>
        </div>
    </div>
<div id="ctl00_header1_divMenuId" style="display: none">1</div>
</div>

<script language="javascript" type="text/javascript">
//走马灯样式
	$(document).ready(function(){
		if(navigator.userAgent.indexOf("Firefox")!=-1){
			$("#ctl00_header1_lblUserName").attr({"width":"60%","height":"20%"});
		}else{
			$("#ctl00_header1_lblUserName").attr({"width":"90%","height":"20%"});
		}
	});
	function left()
	{
		count++;
		if(count>sum)
		{
			count--;
			return;
		}
		var mu = $("div[name='menu']:eq("+count+")");
		mu.hide();
	}

	function right()
	{
		count--;
		if(count<0)
		{
			count++;
			return;
		}
		var mu = $("div[name='menu']:eq("+count+")");
		mu.show();
	}
	
	var choosedMenuId ;
    function choose(menuId)
    {  
        if(choosedMenuId)
	    {
	        document.getElementById("header"+choosedMenuId).className = "";
	        
	    }
        var css = "active";
        if(menuId!="-1")
        {
            document.getElementById("header"+menuId).className = css;
            choosedMenuId = menuId;
        }
        
    }

    function openHelp(url) 
    {        
        var ss = window.location.href;
        url = ss.split('/')[0] + "/" + ss.split('/')[1] + "/" + ss.split('/')[2] + url;

        art.dialog.open(url, { title: '操作指引', width: 800, height: 600, lock: true });
    }
    function openGuide(url) 
    {        
        var ss = window.location.href;
        url = ss.split('/')[0] + "/" + ss.split('/')[1] + "/" + ss.split('/')[2] + url;

        art.dialog.open(url, { title: '用户指引', width: 800, height: 410, lock: true });
    }

    function changeTopMenu(menuId)
    {
        choose(menuId);
    	$.ajax({
            type: "GET",
            url: "<%=basePath%>loadLeftMenu.htm",
            data: {menuId: menuId,userId:'${sessionScope.accountInfo.userId}'},
            async: false,
            success: function(data) 
            {
                // 更新左菜单 leftmenu1_icon_m1
                var html="";
                for(var i=0; i<data.length; i++)
                {
					html +="<li id='menu_"+(i+1)+"' ><a href='javascript:choosemenu("+(i+1)+",\""+data[i].miUrl+"\",\""+data[i].miName+"\")'>  <span class='forpng' style='background:url(<%=basePath%>"+data[i].miPic+") no-repeat; background-position:0px 5px;'>"+data[i].miName+"</span></a></li>";
                }
                $("#leftmenu").children("ul").html(html);
                // 默认选中第一个菜单
                if(data.length>0)
                {	
                	choosedLeftMenuId = null;
                	choosemenu(1,''+data[0].miUrl,''+data[0].miName);
                }
                //alert(document.getElementById("ctl00_top1_navigation".innerText));
                //alert($("#ctl00_top1_navigation").html());
                
            }
        }); 
    }

    /*帮助文档功能*/
    function openHelp()
    {
    	var commonDialog = commonOpenDialog("readDetail",'帮助',1000,800, '<%=basePath%>help/main.htm');
		commonDialog.addBtn("cancel",'关闭', commonDialog.cancel);
    }
</script>

<!--  -->
<div id="mainbodytop">
    <div id="ctl00_top1_navigation" class="position">当前位置：我的账户 </div>
    <div id="mapnav">
    </div>
</div>
    
<div id="ctl00_top1_divxx" style="display:none"><div id='divDistribution' style='display: none'><div id='divDistributionCountAll' >3</div><div id='divDistributionCountZY' >0</div><div id='divDistributionCountGZ' >3</div><div id='divDistributionCountXS' >0</div><div id='divDistributionCountTZ' >0</div><div id='divDistributionCountLX' >3</div><div id='divDistributionCountBJ' >0</div></div></div>
<span id="divMusic" style="height:0px">
</span>

<script language="javascript" type="text/javascript">
    //获取当前时间
    function Gettime()
    {
        var now=new Date;
        var vYear = now.getFullYear();
        var vMon = now.getMonth() + 1;
        var vDay = now.getDate();
        var vHour = now.getHours();
        var vMinute = now.getMinutes();
        var vSecond = now.getSeconds();
        vMon = vMon<10 ? "0" + vMon : vMon;
        vDay = vDay<10 ? "0" + vDay : vDay;
        vHour = vHour<10 ? "0" + vHour : vHour;
        vMinute = vMinute<10 ? "0" + vMinute : vMinute;
        vSecond = vSecond<10 ? "0" + vSecond : vSecond;
        return vYear + "-" + vMon + "-" + vDay + " " + vHour + ":" + vMinute + ":" + vSecond;
    }

</script>


</body>
</html>