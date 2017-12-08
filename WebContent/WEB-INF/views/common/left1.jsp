<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head><meta http-equiv="Content-Type" content="text/html;charset=UTF-8" /><title>
	我的账户总览-摇钱数
</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <!--[if IE 6]>
    <script type="text/javascript" src='/js/DD_belatedPNG_0.0.8a.js'></script>
	<script type="text/javascript">
		DD_belatedPNG.fix('.sprite, .logo, .left_shadow, .forpng');
	</script>
	<![endif]-->
	<!-- 引用资源文件 -->
	<jsp:include page="/source1.htm" />
<style type="text/css">

</style>

</head>
	<body>
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar" >
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>
					<!--
					<div class="sidebar-shortcuts" id="sidebar-shortcuts" >
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>

							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini" >
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div> #sidebar-shortcuts -->

					<!-- 菜单 -->
					<ul class="nav nav-list" id="menus">
						<c:forEach items="${sessionScope.topMenu}" var="menu" varStatus="i">
							<li title="${menu.value.miName}">
								<c:if test="${fn:length(menu.value.leftMenus)>0}">
									<a href="#" class="dropdown-toggle">
										<i><img src="<%=basePath%>${menu.value.miPic}" width="22px" height="22px"/> </i>
										<span class="menu-text"> ${menu.value.miName}</span>
										<b class="arrow icon-angle-down"></b>
									</a>
									<ul class="submenu" style="overflow:auto; OVERFLOW-X:hidden;">
										<c:forEach items="${menu.value.leftMenus}" var="leftMenu" varStatus="j">
											<!--  
											<i><img src="<%=basePath%>${leftMenu.miPic}" width="28px" height="28px"/> </i>
											<span class="menu-text"> ${leftMenu.miName}</span>
											-->
											<li id="menu_${i.count}_${j.count}" title="${leftMenu.miName}" >
											<!-- onclick="javascript:choosemenu('menu_${i.count}_${j.count}','${leftMenu.miUrl}');" -->
												<a href="#" style="white-space:nowrap" data-addtab="${leftMenu.miName}" data-url="${leftMenu.miUrl}">
													<i><img src="<%=basePath%>${leftMenu.miPic}" width="14px" height="14px"/> </i>
													<span class="menu-text" style="display:inline-block;">${leftMenu.miName}</span>
												</a>
											</li>
										</c:forEach>
									</ul>
								</c:if>
							</li> 
						</c:forEach>
					</ul>
					<!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
					
					
				</div>

				<div class="main-content">
					<!--  
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">首页</a>
							</li>
							<li class="active">控制台</li>
						</ul>

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
							</form>
						</div>
					</div>
					
						<iframe id='mainFrame'  name="mainFrame" src="<%=basePath%>center1.htm" frameborder="0"  style="overflow-x:hidden;overflow-y:auto"></iframe>
					-->

					<div class="page-content">
						
						 <div>
                                        <!-- Nav tabs -->
                                        <ul class="nav nav-tabs" id="tabs1" role="tablist" style="height:35px;">
                                            <li class="active" role="presentation">
                                                <a aria-controls="home" data-toggle="tab" href="#home" role="tab">
                                                    	首页
                                                </a>
                                            </li>
                                        </ul>
                                        <!-- Tab panes -->
                                        <div class="tab-content">
                                            <div class="tab-pane active" id="home" role="tabpanel">
                                            
            <image src="<%=basePath %>common/images/homeImage.jpg" style="width:100%;height:100%;margin-left:1%"></image>
                                            </div>
                                        </div>
                                    </div>
						
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

				<div class="ace-settings-container" id="ace-settings-container">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
						<i class="icon-cog bigger-150"></i>
					</div>

					<div class="ace-settings-box" id="ace-settings-box">
						<div>
							<div class="pull-left">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="default" value="#438EB9">#438EB9</option>
									<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
							<span>&nbsp; 选择皮肤</span>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
							<label class="lbl" for="ace-settings-navbar"> 固定导航条</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
							<label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
							<label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
							<label class="lbl" for="ace-settings-rtl">切换到左边</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
							<label class="lbl" for="ace-settings-add-container">
								切换窄屏
								<b></b>
							</label>
						</div>
					</div>
				</div><!-- /#ace-settings-container -->
				
				
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
			
		</div>
	</body>	