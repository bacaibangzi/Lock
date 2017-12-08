<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(basePath);
%>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>
</head>
<script type="text/javascript" src="<%=basePath %>common/js/jqueryByImg.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/ajaxupload.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/chars/jscharts.js?v=3.0"></script>

<html>	
	<!-- 引用资源文件 -->
	<jsp:include page="/source.htm" flush="true" />
	<body id="body" style="overflow:hidden">
			<div id="mask" style="height:100%;width:100%;text-align:center;"><img style="margin-top:16%" src="<%=basePath%>common/images/mask.jpg"><strong>正在加载数据。。</strong></div>
			<div id="orgDiv" style="position:fixed; top:27%; right:2%; border:1px solid #E9ECEF;;cursor:pointer;">
			<div id="chooseTitle" style="background-color:#B6D3EF;font-size: 1em;font-weight:bold;height: 30px;border-bottom: 1px solid #E9ECEF;"><p style="margin-left:5px;padding-top:6px">选择组织机构<a id="backParentOrg" style="float:right;margin-right:10px;">返回上级</a></p></div>
			<ul id="orgUl"></ul>
			</div>
            <div id="accountinfo" class="accountinfo">
                <div class="ainfo_left">
                    <div id="panelViewPic" class="gavatar">
                        <img id="vHeader" src=${sessionScope.accountInfo.userImg eq null ?'common/images/userNormal.png':sessionScope.accountInfo.userImg} width="80" height="80" />
                    </div>
                </div>
                <div class="ainfo_right">
                    <h3>
                        <span id="ctl00_ContentPlaceHolder1_lblUserName" style="color:Black;">摇钱数</span>
                        <a href="javascript:tips()"><span style="color:Green">点击进入摇钱数网上营业厅</span></a>
                    </h3>
                    
                    <ul>
                        <li>我的店铺：<span id="ctl00_ContentPlaceHolder1_lblVehZy" style="color:Black;">0家</span></li>
                        <li>我的可用短信：<span id="ctl00_ContentPlaceHolder1_lblSms" style="color:Black;">0条</span></li>
                    </ul>
                    <ul>
                       
                        <li>我要续费：<a href="javascript:tips()"><span style="color:Green">点击进入续费页面</span></a></li>
                        <li>我要购买店铺管理服务：<a href="javascript:tips()"><span style="color:Green">点击进入购买页面</span></a></li>
                    </ul>
                    <a href="javascript:void(0)">
                        <ul>
                            
                        </ul>
                        <ul>
                            
                        </ul>
                        <ul>
                            <span id="ctl00_ContentPlaceHolder1_infoConcern" title="到期提醒" btname="服务到期" rel="gb_page_center[750, 350]" class="btncss alert" href="serviceAlert.aspx" style="color: Red"></span>
                        </ul>
                    </a>
                    
                    
                </div>
                <div style="width: 100%; height: 20px; float: left; margin-left: 5px; display: inline;">
                    <!-- <a href='javascript:void(0);' onclick='uploadinit(1);' id="reload">[更改图片]</a> -->
                    <button id="addLabProdPic">更换图片</button>
                    <div style="display: none; float: left; width: 50%; height: 20px;" id="uploaddiv">
                        <a href='javascript:void(0);' style="float: left" onclick='uploadinit(0);'>[取消更改]</a>
                        <iframe src="../../inc/z.aspx?type=1" id="ifUpload" frameborder="no" scrolling="no"
                            style="width: 100%; height: 20px; float: left"></iframe>
                    </div>
                </div>
            </div>
            <div id="accountlist" class="accountlist">
            
            <!--  
                <ul>
                    <li>
                    	<a href="#"><img src="<%=basePath%>common/images/coffee.png" /></a>
                        <p>
                        <a href="#" style="color: Black"><strong>店铺信息管理</strong></a>
                        	餐饮商家用户管理维护自有店铺相关信息。
                        </p>
                    </li>
                    <li>
                    	<a href="#"><img src="<%=basePath%>common/images/sw.png" /></a>
                        <p>
                        <a href="#" style="color: Black"><strong>菜品信息管理</strong></a>
                        	餐饮商家在云端维护相应的菜品<br>信息，可以实现线上线下共享菜品信息。
                        </p>
                    </li>
                    
                    <li>
                    	<a href="#"><img src="<%=basePath%>common/images/gk.png" /></a>
                        <p>
                        <a href="#" style="color: Black"><strong>会员信息管理</strong></a>
                        	餐饮商家在云端维护客户信息，可以在线给客户充值。
                        </p>
                    </li>
                    
                    <li>
                    	<a href="#"><img src="<%=basePath%>common/images/fx.png" /></a>
                        <p>
                        <a href="#" style="color: Black"><strong>运营分析统计</strong></a>
                        	餐饮商家在云端实时账户店铺的运营情况。
                        </p>
                    </li>
                </ul>
                <div style="display: none">
                </div>
               --> 
  <table id="table">
  	<tr>
  		<td >
  			<table>
  				<tr>
  					<td>
                    	<a href="#" style="float:left"><img src="<%=basePath%>common/images/coffee.png" /></a>
                        <p id="shopInfo">
                        <a href="#" style="color: Black"><strong>店铺信息管理</strong></a>
                        	餐饮商家用户管理维护自有店铺相关信息。
                        </p>
  					</td>
  				</tr>
  				<tr>
  					<td id="graph1"></td>
  				</tr>
  			</table>
  		</td>
  		<td >
			<!-- <table>
				<tr><td cosplan="2">各个菜品类别</td></tr>
				<tr><td>招牌菜</td><td>汤羹</td></tr>
				<tr><td>437</td>   <td>322</td></tr>
				<tr><td>酒水</td>  <td>生鲜</td></tr>
				<tr><td>233</td>   <td>110</td></tr>
				<tr><td>甜品</td>  <td>饮品</td></tr>
				<tr><td>34</td>   <td>20</td></tr>
				<tr><td>开胃小菜</td>  <td>融合菜</td></tr>
				<tr><td>19</td>   <td>119</td></tr>
			</table> -->
		</td>
		<td>
			<table>
  				<tr>
  					<td>
                    	<a href="#" style="float:left"><img src="<%=basePath%>common/images/sw.png" /></a>
                        <p id="dishInfo">
                        <a href="#" style="color: Black"><strong>菜品信息管理</strong></a>
                        	餐饮商家在云端维护相应的菜品<br>信息，可以实现线上线下共享菜品信息。
                        </p>
  					</td>
  				</tr>
  				<tr>
  					<td id="graph2"></td>
  				</tr>
  			</table>
		</td>
  	</tr>
  	<tr>
		<td >
			<table>
  				<tr>
  					<td>
                    	<a href="#" style="float:left"><img src="<%=basePath%>common/images/gk.png" /></a>
                        <p id="memberInfo">
                        <a href="#" style="color: Black"><strong>会员信息管理</strong></a>
                        	餐饮商家在云端维护客户信息，可以在线给客户充值。
                        </p>
  					</td>
  				</tr>
  				<tr>
  					<td id="graph4"></td>
  				</tr>
  			</table>
		</td>
		<td ></td>
		<td>
			<table>
  				<tr>
  					<td>
                    	<a href="#" style="float:left"><img src="<%=basePath%>common/images/fx.png" /></a>
                        <p id="operationAnalysis">
                        <a href="#" style="color: Black"><strong>运营分析统计</strong></a>
                        	餐饮商家在云端实时账户店铺的运营情况。
                        </p>
  					</td>
  				</tr>
  				<tr>
  					<td id="graph3"></td>
  				</tr>
  			</table>
		</td>
  	</tr>
  </table>


            </div>
 	</body>
 	<script type="text/javascript">
 		function tips(){
 	 		fh.alert('正在紧张的开发当中喔~');
 	 	}
 		//浏览器大小变化监控
 		window.onresize = function(){
 			if(!(navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion .split(";")[1].replace(/[ ]/g,"")=="MSIE8.0")){//不为ie8时
 				location=location; 
 			} 
		}
 		
 		//计算浏览器窗口高度和宽度
		var clientWidth = document.body.clientWidth;
		var clientHeight = document.body.clientHeight;
		
		/* var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		if (userAgent.indexOf("Firefox") > -1) {
			var height = (clientHeight-122)/3.5;
		}else{
			var height = (clientHeight-122)/3.5;
		} */
			
		//计算网页宽和电脑屏幕宽比
		var cWidth = window.screen.width;
		var percent = clientWidth/cWidth*100
		if(percent>75){
			percent = 75;
		}
		
		//隐藏蒙版
		$("#mask").hide();
 		$(function(){
 			//上传图片
 			new AjaxUpload('#addLabProdPic', {
 				action: '<%=basePath%>user/uploadFileByImg.htm?userName=${sessionScope.accountInfo.userName}', 
 				name: 'picFile',
 				responseType: 'json',
 				onSubmit : function(file , ext){
 					if (ext && /^(jpg|png|bmp)$/.test(ext.toLowerCase())){
 						this.setData({
 							'picName': file
 						});
 					} else {
 						alert("请上传格式为 jpg|png|bmp 的图片！");
 						return false;				
 					}
 				},
 				onComplete : function(file,response){
 					if(response.error) {
 						alert(response.error);
 						return;
 					}
 					$("#vHeader").attr("src",response.picUrl);
 					window.parent.document.getElementById("head_headerImg").src=response.picUrl;
 				}		
 			});
 			
 			//组织机构树
 			var html = "";
 			$.ajax({
				url:"<%=basePath%>restautant/getOrgSubTree.htm",
				type:"get",
				data:"orgCode=${sessionScope.accountInfo.orgCode}",
				dataType: "json",
				success:function(data){
					for(var i=0;i<data.length;i++){
						if(data[i].oiMemo.substr(0,1)=='+'){
							html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
									   + "<span orgCode='"+data[i].oiCode+"' class='sub' style='float:left;'>&nbsp;&nbsp;&nbsp;<a>+</a></span><p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>&nbsp;&nbsp;"+data[i].oiName+"</p></li>";
						}else if(data[i].oiMemo.substr(0,1)=='-'){
							html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
							   + "<span orgCode='"+data[i].oiCode+"' class='sub' style='float:left;'>&nbsp;<a>-</a></span><p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>"+data[i].oiName+"</p></li>";
						}else{
							html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
							   + "<p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].oiName+"</p></li>";
						}		   
					}
					$("#orgUl").html(html);
					
					//设置图形宽高和半径
					var orgDivWidth = $("#orgDiv").width();
					var height = (clientHeight-122)/2.8;
					var width = (clientWidth-orgDivWidth-75)/2;
					var r = (clientWidth-219)/18.5;
					
					//设置滚动轴
					if(data.length*29>400){
						$("#orgDiv").css({"overflow-y":"scroll", "height":"400px"});
					}
					
					//设置字体大小
					if(percent<62){
						$("#chooseTitle,.right-org").css("font-size",percent+20+"%");
					}
					
					//点击选择组织并查询
					orgSlect();
					
					//扩展或收缩组织机构
					orgOpenClose();
						
					//扩展组织机构
					function orgOpenClose(){
						$(".sub").click(function(){
							var orgCode = $(this).attr("orgCode");
							var html="";
							if($(this).html().indexOf("+")>0){
								$.ajax({
									url:"<%=basePath%>restautant/getOrgSubTree.htm",
									type:"get",
									data:"orgCode="+orgCode,
									dataType: "json",
									success:function(data){
										for(var i=0;i<data.length;i++){
											if(data[i].oiMemo.substr(0,1)=='+'){
												html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
														   + "<span orgCode='"+data[i].oiCode+"' class='sub' style='float:left;'>&nbsp;&nbsp;&nbsp;<a>+</a></span><p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>&nbsp;&nbsp;"+data[i].oiName+"</p></li>";
											}else if(data[i].oiMemo.substr(0,1)=='-'){
												html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
												   + "<span orgCode='"+data[i].oiCode+"' class='sub' style='float:left;'>&nbsp;<a>-</a></span><p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>"+data[i].oiName+"</p></li>";
											}else{
												html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
												   + "<p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].oiName+"</p></li>";
											}	
										}
										$("#orgUl").html(html);
										//设置滚动轴
										if(data.length*29>400){
											$("#orgDiv").css({"overflow-y":"scroll", "height":"400px"});
										}else{
											$("#orgDiv").css({"overflow-y":"", "height":""});
										}
										//点击选择组织并查询
										orgSlect();
										//扩展或收缩组织机构
										orgOpenClose();
										//默认选中第一个
										$("#orgUl li:first-child p").parent().css({"background-color":"#E0EDF9"});
									}
								});
							}else{
								$.ajax({
									url:"<%=basePath%>restautant/getOrgTree.htm",
									type:"get",
									data:"orgCode="+orgCode,
									dataType: "json",
									success:function(data){
										for(var i=0;i<data.length;i++){
											if(data[i].oiMemo.substr(0,1)=='+'){
												html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
														   + "<span orgCode='"+data[i].oiCode+"' class='sub' style='float:left;'>&nbsp;&nbsp;&nbsp;<a>+</a></span><p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>&nbsp;&nbsp;"+data[i].oiName+"</p></li>";
											}else if(data[i].oiMemo.substr(0,1)=='-'){
												html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
												   + "<span orgCode='"+data[i].oiCode+"' class='sub' style='float:left;'>&nbsp;<a>-</a></span><p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>"+data[i].oiName+"</p></li>";
											}else{
												html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
												   + "<p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].oiName+"</p></li>";
											}	
										}
										$("#orgUl").html(html);
										//设置滚动轴
										if(data.length*29>400){
											$("#orgDiv").css({"overflow-y":"scroll", "height":"400px"});
										}else{
											$("#orgDiv").css({"overflow-y":"", "height":""});
										}
										//点击选择组织并查询
										orgSlect();
										//扩展或收缩组织机构
										orgOpenClose();
										//默认选中第一个
										$("#orgUl li:first-child p").parent().css({"background-color":"#E0EDF9"});
									}
								});
							}
						});
					}
					//收缩组织机构
					$("#backParentOrg").click(function(){
							var orgCode = $("#orgUl li:first-child p").attr("orgCode");
							if(orgCode=="${sessionScope.accountInfo.orgCode}"){
								fh.alert("已是最高级!");
								return;
							}
							orgCode = orgCode.substr(0,orgCode.length-4);
							var html="";
							$.ajax({
								url:"<%=basePath%>restautant/getOrgSubTree.htm",
								type:"get",
								data:"orgCode="+orgCode,
								dataType: "json",
								success:function(data){
									for(var i=0;i<data.length;i++){
										if(data[i].oiMemo.substr(0,1)=='+'){
											html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
													   + "<span orgCode='"+data[i].oiCode+"' class='sub' style='float:left;'>&nbsp;&nbsp;&nbsp;<a>+</a></span><p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>&nbsp;&nbsp;"+data[i].oiName+"</p></li>";
										}else if(data[i].oiMemo.substr(0,1)=='-'){
											html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
											   + "<span orgCode='"+data[i].oiCode+"' class='sub' style='float:left;'>&nbsp;<a>-</a></span><p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>"+data[i].oiName+"</p></li>";
										}else{
											html= html + "<li class='right-org' style='height: 19px;width:230px; background-color: white;color: #000;font-size: 90%;font-weight: bold;border-bottom: 1px solid #E9ECEF;'>"
											   + "<p orgCode='"+data[i].oiCode+"' orgType='"+data[i].oiType+"' class='rightOrg' style='margin-left:25px;padding-top:3px'>&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].oiName+"</p></li>";
										}	
									}
									$("#orgUl").html(html);
									//设置滚动轴
									if(data.length*29>400){
										$("#orgDiv").css({"overflow-y":"scroll", "height":"400px"});
									}else{
										$("#orgDiv").css({"overflow-y":"", "height":""});
									}
									//点击选择组织并查询
									orgSlect();
									//扩展或收缩组织机构
									orgOpenClose();
									//默认选中第一个
									$("#orgUl li:first-child p").parent().css({"background-color":"#E0EDF9"});
								}
							});
						});
						
					//点击选择组织并查询
					function orgSlect(){
						$(".rightOrg").click(function(){
							//选择元素时颜色变化
							$(".right-org").css({"background-color":"white", "color":"#000"});
							$(this).parent().css({"background-color":"#E0EDF9"});
							var orgCode = $(this).attr("orgCode");
							var orgType = $(this).attr("orgType");;
							if(orgType==4||orgType==5||orgType==6||orgType==9){//是总店、加盟、连锁和分部时检查上级机构类型
								$.ajax({
									url:"<%=basePath%>org/getSuperiorType.htm",
									type:"post",
									async:false,
									data:"orgCode="+orgCode,
									success:function(data){
										if(data!=null){
											orgType = data.oiType;
										}
									}
								});
							}
							if(orgType!=3){//组织机构不为超市连锁时
								getRestaurantStatistics(orgCode,orgDivWidth,height,width,r);
							}else{
								var urlTOP10 = '<%=basePath%>SupermarketView/top10.htm?orgCode='+orgCode;
					 			var urlByMonth = '<%=basePath%>SupermarketView/saleByMonth.htm?orgCode='+orgCode;
					 			var urlContrast = '<%=basePath%>SupermarketView/saleByMonthContrast.htm?orgCode='+orgCode;
					 			var urlPie = '<%=basePath%>SupermarketView/saleByUserType.htm?orgCode='+orgCode;
					 			viewSupermarket(urlTOP10,urlByMonth,urlContrast,urlPie,orgDivWidth,height,width,r);
							}
							//设置蒙版
							$("#mask").show();
							$("#accountinfo").hide();
							$("#table").hide();
							$("#orgDiv").hide();
							});
					}
						
					//默认选中第一个
					$("#orgUl li:first-child p").click();
				}
				
 			});
				//设置字体大小
				if(percent<62){
					$("#shopInfo,#dishInfo,#memberInfo,#operationAnalysis").css("font-size",percent+20+"%");
				}
				//设置p标签宽度
				$("#shopInfo,#dishInfo,#memberInfo,#operationAnalysis").css("width",percent+"%");
 		})
		
		//获取餐饮机构统计信息
		function getRestaurantStatistics(orgCode,orgDivWidth,height,width,r){
 			
			$.ajax({
				url:"<%=basePath%>restautant/getStatistics.htm",
				type:"get",
				data:"orgCode="+orgCode,
				dataType: "json",
				success:function(data){
					//去除蒙版
					$("#mask").hide();
					$("#accountinfo").show();
					$("#table").show();
					$("#orgDiv").show();
					//1、获取菜品类别销量
					var dishTypeSalesData = data.dishTypeSalesMapList;
					if(dishTypeSalesData!=null){
						var myData = dataFormat(dishTypeSalesData,'DT_VCH_DISH_TYPE_NAME','num');/*new Array(['招牌菜', 437], ['汤羹', 322], ['酒水', 233], ['生鲜', 110], ['甜品', 34], ['饮品', 20], ['开胃小菜', 19], ['融合菜', 119]);*/
						/* var colors = ['#2D6B96', '#327AAD', '#3E90C9', '#55A7E3', '#60B6F0', '#81C4F0', '#9CCEF0', '#CCCEF0']; */
						var array = new Array();
						var color = null;
						for(var i=0;i<myData.length;i++){
							color = '#'+('00000'+(Math.random()*0x1000000<<0).toString(16)).slice(-6);
							array.push(color);
				        }
						var colors = array;
						var myChart = new JSChart('graph1', 'bar');
						myChart.setDataArray(myData);
						myChart.colorizeBars(colors);
						myChart.setTitle('菜品类别销量情况');
						myChart.setTitleColor('#8E8E8E');
						myChart.setAxisNameX('类型');
						myChart.setAxisNameY('数量');
						myChart.setAxisNameFontSize(9);
						myChart.setAxisColor('#C4C4C4');
						myChart.setAxisNameColor('#999');
						myChart.setAxisValuesColor('#777');
						myChart.setAxisColor('#B5B5B5');
						myChart.setAxisWidth(1);
						myChart.setBarValuesColor('#2F6D99');
						myChart.setBarOpacity(0.5);
						myChart.setAxisPaddingTop(60);
						myChart.setAxisPaddingBottom(40);
						myChart.setAxisPaddingLeft(45);
						myChart.setTitleFontSize(11);
						myChart.setBarBorderWidth(0);
						myChart.setBarSpacingRatio(50);
						myChart.setBarOpacity(0.9);
						myChart.setFlagRadius(6);
						myChart.setTooltip(['North America', 'U.S.A and Canada']);
						myChart.setTooltipPosition('nw');
						myChart.setLegend('#B5B5B5', '2005');
						myChart.setLegend('#B5B5B5', '2010');
						myChart.setLegend('#B5B5B5', '2010');
						myChart.setLegend('#B5B5B5', '2010');
						myChart.setLegend('#B5B5B5', '2010');
						myChart.setLegend('#B5B5B5', '2010');
						myChart.setLegend('#B5B5B5', '2010');
						myChart.setTooltipOffset(3);
						myChart.setSize(width,height/* 616, 280 */);
						myChart.setBackgroundImage('chart_bg.jpg');
						myChart.draw();
					}else{
						fh.alert("获取菜品类别销量情况出错!");
					}
					
					//2、菜品销售总情况
					var dishSalesTotalDate = data.dishSalesTotalMapList;
					if(dishSalesTotalDate!=null){
						var myData = dataFormat(dishSalesTotalDate,'mt','amount')/*new Array([1, 7.80], [2, 4.80], [3, 6.50], [4, 6.10], [5, 4.40], [6, 5.80], [7, 4.00], [8, 8.50], [9, 8.90], [10, 9.20], [11, 8.20], [12, 21.20]);*/
						var myChart = new JSChart('graph2', 'line');
						myChart.setDataArray(myData);
						myChart.setTitle('菜品销售总情况');
						myChart.setTitleColor('#8E8E8E');
						myChart.setTitleFontSize(11);
						myChart.setAxisNameX('月份');
						myChart.setAxisNameY('金额');
						myChart.setAxisNameFontSize(9);
						myChart.setAxisColor('#8420CA');
						myChart.setAxisValuesColor('#949494');
						myChart.setAxisPaddingLeft(100);
						myChart.setAxisPaddingRight(120);
						myChart.setAxisPaddingTop(50);
						myChart.setAxisPaddingBottom(40);
						myChart.setAxisValuesDecimals(3);
						myChart.setAxisValuesNumberX(10);
						myChart.setShowXValues(false);
						myChart.setGridColor('#C5A2DE');
						myChart.setLineColor('#BBBBBB');
						myChart.setLineWidth(2);
						myChart.setFlagColor('#9D12FD');
						myChart.setFlagRadius(4);
						for(var i=0;i<myData.length;i++){
							myChart.setTooltip([i, 'amount '+myData[i][1]] );
				        }
						myChart.setSize(width,height);
						myChart.setBackgroundImage('chart_bg.jpg');
						myChart.draw();
					}else{
						fh.alert("获取菜品销售情况出错!");
					}
					
					//3、上月本月销售同比
					var lastMonthThisMonthSalesMapList = data.lastMonthThisMonthSalesMapList;
					if(lastMonthThisMonthSalesMapList!=null){
						var myData = dataFormat(lastMonthThisMonthSalesMapList,'mt','amount')
						var myChart = new JSChart('graph4', 'bar');
						myChart.setDataArray(myData/*[['上月', 25],['本月', 49]]*/);
						myChart.colorize(['#66ACD1','#3489B6']);
						myChart.setSize(width,height-40);
						//myChart.setIntervalEndY(100000);
						myChart.setTitle('上月本月销售同比');
						myChart.setTitleColor('#8E8E8E');
						myChart.setTitleFontSize(11);
						myChart.setGrid(false);
						myChart.setBarSpacingRatio(50);
						myChart.setBarValuesColor('#208a02');
						myChart.setBarOpacity(.5);
						myChart.setBarBorderColor('#FFFFFF');
						myChart.setBarSpeed(100);
						myChart.setAxisReversed(true);
						myChart.setAxisWidth(1);
						myChart.setAxisColor('#66ACD1');
						myChart.setAxisWidth(1);
						myChart.setAxisValuesColor('#206183');
						myChart.setAxisNameColor('#206183');
						myChart.setAxisNameX('月份');
						myChart.setAxisNameY('金额');
						myChart.setAxisNameFontSize(9);
						myChart.setAxisPaddingLeft(48/* 100 */);
						myChart.set3D(false);
						myChart.draw();
					}else{
						fh.alert("获取上月本月销售同比数据出错!");
					}
					
					//4、会员消费汇总
					var memberConsumptionSummary = data.memberConsumptionSummary;
					if(memberConsumptionSummary!=null){
						var myData = dataFormat(memberConsumptionSummary,'typename','percentage')
						var myChart = new JSChart('graph3', 'pie');
						myChart.setDataArray(myData/* [['A', 40],['B', 16],['C', 20],['C', 22]] */);
						/* myChart.colorize(['#99CDFB','#3366FB','#0000FA','#F8CC00']); */
						var array = new Array();
						var color = null;
						for(var i=0;i<myData.length;i++){
							color = '#'+('00000'+(Math.random()*0x1000000<<0).toString(16)).slice(-6);
							array.push(color);
							myChart.setLegend(color, myData[i][0]);
				        }
						myChart.colorize(array);
						myChart.setSize(width,height);
						myChart.setTitle('会员消费汇总');
						myChart.setTitleColor('#8E8E8E');
						myChart.setTitleFontSize(11);
						myChart.setPieRadius(r);
						myChart.setPieValuesColor('#FFFFFF');
						myChart.setPieValuesFontSize(9);
						myChart.setPiePosition(180, 130/* 180, 165 */);
						myChart.setShowXValues(false);
						/* myChart.setLegend('#99CDFB', '黄金会员');
						myChart.setLegend('#3366FB', '白金会员');
						myChart.setLegend('#0000FA', '钻石会员');
						myChart.setLegend('#F8CC00', '普通会员'); */
						myChart.setLegendShow(true);
						myChart.setLegendFontFamily('Times New Roman');
						myChart.setLegendFontSize(10);
						myChart.setLegendPosition(300, 90/* 350, 120 */);
						myChart.setPieAngle(30);
						myChart.set3D(true);
						myChart.draw();
					}else{
						fh.alert("获取会员消费汇总数据出错!");
					}
				}
			});
			
			//JS格式转换为JsCharts格式
 			function dataFormat(data, key1, key2){
			     var array = new Array();
			     try{
			        for(var i=0; i<data.length; i++){
		            	 array.push([data[i][key1], data[i][key2]]);
			         }
			       }catch(e){
			         return new Array();
			      }
			     return array;
			  }
		}
 		
 		//获取超市数据
 		function viewSupermarket(urlTOP10, urlByMonth, urlContrast, urlPie, orgDivWidth, height, width, r) {
		 			
					$.ajax({
						type : "Post",
						url : urlTOP10,
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						dataType : 'json',
						async : true,
						success : function(data) {
							//替换标题
							$("#shopInfo").html("<a href='#' style='color: Black'><strong>店铺信息管理</strong></a>超市商家用户管理维护自有店铺相关信息。");
							$("#dishInfo").html("<a href='#' style='color: Black'><strong>商品信息管理</strong></a>超市商家在云端维护相应的商品<br>信息，可以实现线上线下共享商品信息。");
							$("#memberInfo").html(" <a href='#' style='color: Black'><strong>会员信息管理</strong></a>超市商家在云端维护客户信息，可以在线给客户充值。");
							$("#operationAnalysis").html(" <a href='#' style='color: Black'><strong>运营分析统计</strong></a>超市商家在云端实时账户店铺的运营情况。");
							//去除蒙版
							$("#mask").hide();
							$("#accountinfo").show();
							$("#table").show();
							$("#orgDiv").show();
							//第一步,需要把JSON格式转换为如下格式,数据长度和颜色长度必须相同
							//var myData = new Array(['招牌菜', 437], ['汤羹', 322], ['酒水', 233], ['生鲜', 110], ['甜品', 34], ['饮品', 20], ['开胃小菜', 19], ['融合菜', 119],['爱爱爱', 119],['帮不帮', 119]);
							var myData = formatData(data, 'name', 'num');
							//var colors = [ '#2D6B96', '#327AAD', '#3E90C9','#55A7E3', '#60B6F0', '#81C4F0', '#9CCEF0','#CCCEF0','#60B6F0', '#81C4F0'];
							//var colors = arrayColors(data);
							var arrayColors = new Array();
							var color = null;
							for(var i=0;i<myData.length;i++){
								color = '#'+('00000'+(Math.random()*0x1000000<<0).toString(16)).slice(-6);
								arrayColors.push(color);
							}
							var myChart = new JSChart('graph1', 'bar');
							//alert("柱状图1----------->>"+myData);
							myChart.setDataArray(myData);
							myChart.colorizeBars(arrayColors);
							myChart.setTitle('本月超市类别销量排行榜');
							myChart.setTitleColor('#8E8E8E');
							myChart.setAxisNameX('类型');
							myChart.setAxisNameY('数量');
							myChart.setAxisNameFontSize(9);
							myChart.setAxisColor('#C4C4C4');
							myChart.setAxisNameFontSize(9);
							myChart.setAxisNameColor('#999');
							myChart.setAxisValuesColor('#777');
							myChart.setAxisColor('#B5B5B5');
							myChart.setAxisWidth(1);
							myChart.setBarValuesColor('#2F6D99');
							myChart.setBarOpacity(0.5);
							myChart.setAxisPaddingTop(60);
							myChart.setAxisPaddingBottom(40);
							myChart.setAxisPaddingLeft(70);
							myChart.setTitleFontSize(11);
							myChart.setBarBorderWidth(0);
							myChart.setBarSpacingRatio(50);
							myChart.setBarOpacity(0.9);
							myChart.setFlagRadius(6);
							myChart.setTooltipOffset(3);
							myChart.setSize(width,height/* 616, 288 */);
							myChart.setBackgroundImage('chart_bg.jpg');
							myChart.draw();
						},
						error : function() {
							alert("TOP10数据异常！");
						}
					});

			
					$.ajax({
						type : "Post",
						url : urlByMonth,
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						dataType : 'json',
						async : true,
						success : function(data) {
							//第一步,需要把JSON格式转换为如下格式
							//var myData = new Array([ 1, 7.80 ], [ 2, 4.80 ], [ 3, 6.50 ], [ 4, 6.10 ],[ 5, 4.40 ], [ 6, 5.80 ], [ 7, 4.00 ], [ 8, 8.50 ], [ 9, 8.90 ], [10, 9.20 ], [ 11, 8.20 ], [ 12, 21.20 ]);
							var myData = formatData(data, 'month',
									'saleCountByMonth');
							var myChart = new JSChart('graph2', 'line');
							//alert("折线图----------->>"+myData);
							myChart.setDataArray(myData);
							myChart.setTitle('超市销售总情况');
							myChart.setTitleColor('#8E8E8E');
							myChart.setTitleFontSize(11);
							myChart.setAxisNameX('月份');
							myChart.setAxisNameY('数量');
							myChart.setAxisNameFontSize(9);
							myChart.setAxisColor('#8420CA');
							myChart.setAxisValuesColor('#949494');
							myChart.setAxisPaddingLeft(70);
							/* myChart.setAxisPaddingRight(120);
							myChart.setAxisPaddingTop(50);
							myChart.setAxisPaddingBottom(40);
							myChart.setAxisValuesDecimals(1);*/
							myChart.setAxisValuesNumberX(12);
							myChart.setShowXValues(false);
							myChart.setGridColor('#C5A2DE');
							myChart.setLineColor('#BBBBBB');
							myChart.setLineWidth(2);
							myChart.setFlagColor('#9D12FD');
							myChart.setFlagRadius(4);
							for (var i = 0; i < myData.length; i++) {
								myChart.setTooltip([i, 'num '+myData[i][1]]);
							}//坐标提示数据
							myChart.setSize(width,height/* 616, 280 */);
							myChart.setBackgroundImage('chart_bg.jpg');
							myChart.draw();
						},
						error : function() {
							alert("每月销量异常！");
						}
					});

			
					$.ajax({
						type : "Post",
						url : urlContrast,
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						dataType : 'json',
						async : true,
						success : function(data) {
							//第一步,需要把JSON格式转换为如下格式
							//myChart.setDataArray([ [ '上月', 25 ], [ '本月', 49 ] ]);
							var myData = formatData(data, 'month', 'num');
							var myChart = new JSChart('graph4', 'bar');
							//alert("柱状图2----------->>"+myData);
							myChart.setDataArray(myData);
							myChart.colorize([ '#66ACD1', '#3489B6' ]);
							myChart.setSize(width,height-40/* 600, 260 */);
							myChart.setTitle('上月本月销售对比');
							myChart.setTitleColor('#8E8E8E');
							myChart.setTitleFontSize(11);
							myChart.setGrid(false);
							myChart.setBarSpacingRatio(50);
							myChart.setBarValuesColor('#208a02');
							myChart.setBarOpacity(.5);
							myChart.setBarBorderColor('#FFFFFF');
							myChart.setBarSpeed(100);
							myChart.setAxisReversed(true);
							myChart.setAxisWidth(1);
							myChart.setAxisColor('#66ACD1');
							myChart.setAxisWidth(1);
							myChart.setAxisValuesColor('#206183');
							myChart.setAxisNameColor('#206183');
							myChart.setAxisNameX('月份');
							myChart.setAxisNameY('数量'); 
							myChart.setAxisNameFontSize(9);
							myChart.setAxisPaddingLeft(48/* 70 */);
							myChart.set3D(false);
							myChart.draw();
						},
						error : function() {
							alert("上月本月销量对比异常！");
						}
					});

			
					$.ajax({
						type : "Post",
						url : urlPie,
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						dataType : 'json',
						async : true,
						success : function(data) {
							var myData = formatData(data, 'name', 'consumer');
							var myChart = new JSChart('graph3', 'pie');
							myChart.setDataArray(myData);
							var arrayColors = new Array();
							var color = null;
							for(var i=0;i<myData.length;i++){
								color = '#'+('00000'+(Math.random()*0x1000000<<0).toString(16)).slice(-6);
								arrayColors.push(color);
								myChart.setLegend(color, myData[i][0]);
					        }
							myChart.colorize(arrayColors);
							myChart.setSize(width,height/* 600, 260 */);
							myChart.setTitle('会员消费汇总');
							myChart.setTitleColor('#8E8E8E');
							myChart.setTitleFontSize(11);
							myChart.setPieRadius(r/* 95 */);
							myChart.setPieValuesColor('#FFFFFF');
							myChart.setPieValuesFontSize(9);
							myChart.setPiePosition(180, 130/* 180, 165 */);
							myChart.setShowXValues(false);
							/* myChart.setLegend('#99CDFB', '黄金会员');
							myChart.setLegend('#3366FB', '白金会员');
							myChart.setLegend('#0000FA', '钻石会员');
							myChart.setLegend('#F8CC00', '普通会员'); */
							myChart.setLegendShow(true);
							myChart.setLegendFontSize(10);
							myChart.setLegendPosition(300, 90/* 350, 120 */);
							myChart.setPieAngle(30); 
							myChart.set3D(true);
							myChart.draw();
						},
						error : function() {
							alert("会员类型数据错误！");
						}
					});
		}
		;

		//JS格式转换为JsCharts格式
		var formatData = function(str, key, value) {
			var array = new Array();
			try {
				var data = eval(str);
				for (var i = 0; i < data.length; i++) {
					var d = data[i];
					var v1 = d[key];
					var v2 = d[value];
					array.push([ v1, v2 ]);
				}
			} catch (e) {
				return new Array();
			}
			return array;
		};

		//按照数据长度随机颜色
		var arrayColors = function(str) {
			var array = new Array();
			try {
				var data = eval(str);
				for (var i = 0; i < data.length; i++) {
					var d = getRandomColor();
					array.push(d);
				}
			} catch (e) {
				return new Array();
			}
			return array;
		}

		//随机颜色
		var getRandomColor = function() {
			return '#'
					+ ('00000' + (Math.random() * 0x1000000 << 0).toString(16))
							.substr(-6);
		};
 	</script>
</html>            
            