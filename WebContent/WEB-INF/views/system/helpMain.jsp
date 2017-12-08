<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html style="overflow-y:hidden;" xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>我的账户总览-摇钱数</title>

<link href="<%=basePath%>common/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=basePath%>common/js/jquery-1.7.2.min.js"></script>

<!-- datable plugin -->
<script type="text/javascript"
	src="<%=basePath%>common/js/datatable/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>common/js/datatable/datatable.lnpagination.js"></script>
<script type="text/javascript"
	src="<%=basePath%>common/js/datatable/jquery.datatable.columresize.js"></script>

<!-- dialog 相关js -->
<script type="text/javascript"
	src="<%=basePath%>common/js/lhgdialog/lhgdialog.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/fh.dialog.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/common.js"></script>

<!-- 操作相关js -->
<script type="text/javascript"
	src="<%=basePath%>common/js/commonoperate.js"></script>

</head>
<body>
	<div class="left_shadow" style="height: 30px"></div>
	<div id="page">
		<!-- 左导航 -->
		<div id="left"
			style="overflow: auto; overflow-x: hidden; border: 0px solid #000000;">
			<div class="leftmenu2" id="leftmenu">
				<ul>

					<li id="menu_1"><a
						href='javascript:choosemenu(1 ,"help/helpBase.htm")'> <span
							class="forpng"
							style='background: url(<%=basePath%>common/images/dianc.png) no-repeat; background-position: 0px 5px;'>基本操作</span></a></li>

					<li id="menu_2"><a
						href='javascript:choosemenu(2 ,"help/helpEstablishChain.htm")'> <span
							class="forpng"
							style='background: url(<%=basePath%>common/images/mendyg.png) no-repeat; background-position: 0px 5px;'>建立连锁</span></a></li>

					<li id="menu_3"><a
						href='javascript:choosemenu(3 ,"help/helpSingleModel.htm")'> <span
							class="forpng"
							style='background: url(<%=basePath%>common/images/gerxxbj.png) no-repeat; background-position: 0px 5px;'>单店模式</span></a></li>

					<li id="menu_4"><a
						href='javascript:choosemenu(4 ,"help/helpCloudMember.htm")'>
							<span class="forpng"
							style='background: url(<%=basePath%>common/images/dianpxxgl.png) no-repeat; background-position: 0px 5px;'>连锁模式.云会员</span>
					</a></li>
					
					<li id="menu_5"><a
						href='javascript:choosemenu(5 ,"help/helpWeChatOrder.htm")'>
							<span class="forpng"
							style='background: url(<%=basePath%>common/images/dingz.png) no-repeat; background-position: 0px 5px;'>微信点餐</span>
					</a></li>
					
					<li id="menu_6"><a
						href='javascript:choosemenu(6 ,"help/helpChainDistribution.htm")'>
							<span class="forpng"
							style='background: url(<%=basePath%>common/images/denglmmxg.png) no-repeat; background-position: 0px 5px;'>连锁配送</span>
					</a></li>
				</ul>
			</div>
		</div>

		<div id="right">
			<iframe id='mainFrame' name="mainFrame"
				src="<%=basePath%>help/helpBase.htm" frameborder="0"
				style="overflow-x: hidden; overflow-y: auto">
			</iframe>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>common/js/page.js"></script>
	<script type="text/javascript">
		document.body.style.backgroundColor="white";
        window.onresize=function(){changSize();};
        changSize();
        
        //选择菜单
        var choosedLeftMenuId ;
        function choosemenu(index,url,mm/*菜单名称*/)
        {
            if(choosedLeftMenuId)
            {
            	document.getElementById("menu_"+choosedLeftMenuId).className="";
            }
            $("#mainFrame").attr("src","<%=basePath%>"+url); 
            var css = "active";
            document.getElementById("menu_"+index).className=css;
            choosedLeftMenuId = index;
        }
    </script>
    <div id="footer">
            <p>Copyright 2015 <a href="http://www.yqspos.com" target="_blank" style="cursor:hand; color:#999999">http://www.yqspos.com</a>  南京市摇钱数软件有限公司 版权所有 All Rights Reserved
               &nbsp&nbsp 公司地址：南京市玄武大道699-10号，福中集团5号楼306室
           	   &nbsp&nbsp Built By scpos 苏ICP备14032083号-1</p>
	</div>
</body>
</html>
