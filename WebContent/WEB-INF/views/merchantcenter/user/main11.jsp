<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println(basePath);
%>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
</head>
<script type="text/javascript" src="<%=basePath%>common/js/jqueryByImg.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/ajaxupload.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/chars/jscharts.js?v=3.0"></script>
<script type="text/javascript" src="<%=basePath%>common/js/jquery-1.7.2.min.js"></script>

<html>
<!-- 引用资源文件 -->
<jsp:include page="/source.htm" flush="true" />
<body>
	<div class="accountinfo">
		<div class="ainfo_left">
			<div id="panelViewPic" class="gavatar">
				<img id="vHeader" src=${sessionScope.accountInfo.userImg eq null ?'common/images/userNormal.png':sessionScope.accountInfo.userImg} width="80" height="80" />
			</div>
		</div>
		<div class="ainfo_right">
			<h3>
				<span id="ctl00_ContentPlaceHolder1_lblUserName" style="color: Black;">摇钱数</span> <a href="javascript:tips()"><span style="color: Green">点击进入摇钱数网上营业厅</span></a>
			</h3>

			<ul>
				<li>我的店铺：<span id="ctl00_ContentPlaceHolder1_lblVehZy" style="color: Black;">0家</span></li>
				<li>我的可用短信：<span id="ctl00_ContentPlaceHolder1_lblSms" style="color: Black;">0条</span></li>
			</ul>
			<ul>

				<li>我要续费：<a href="javascript:tips()"><span style="color: Green">点击进入续费页面</span></a></li>
				<li>我要购买店铺管理服务：<a href="javascript:tips()"><span style="color: Green">点击进入购买页面</span></a></li>
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
				<iframe src="../../inc/z.aspx?type=1" id="ifUpload" frameborder="no" scrolling="no" style="width: 100%; height: 20px; float: left"></iframe>
			</div>
		</div>
	</div>
	<div class="accountlist">

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
		<table>
			<tr>
				<td>
					<table>
						<tr>
							<td>
								<ul>
									<li><a href="#"><img src="<%=basePath%>common/images/coffee.png" /></a>
										<p>
											<a href="#" style="color: Black"><strong>店铺信息管理</strong></a> 餐饮商家用户管理维护自有店铺相关信息。
										</p></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td id="graph1"></td>
						</tr>
					</table>
				</td>

				<td>
					<table>
						<tr>
							<td>
								<ul>
									<li><a href="#"><img src="<%=basePath%>common/images/sw.png" /></a>
										<p>
											<a href="#" style="color: Black"><strong>菜品信息管理</strong></a> 餐饮商家在云端维护相应的菜品<br>信息，可以实现线上线下共享菜品信息。
										</p></li>
								</ul>
								<ul>
									<li class="filter-item"><label class="filter-label">选择店铺:</label> <input type="text" class="filter-text" id="orgName" name="orgName" value="商朝" readonly="readonly" />
										<button id='orgBtn'>选择</button> <input type="hidden" id="orgCode" name="orgCode" /></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td id="graph2"></td>
						</tr>
					</table>
				</td>

			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td>
								<ul>
									<li><a href="#"><img src="<%=basePath%>common/images/gk.png" /></a>
										<p>
											<a href="#" style="color: Black"><strong>会员信息管理</strong></a> 餐饮商家在云端维护客户信息，可以在线给客户充值。
										</p></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td id="graph4"></td>
						</tr>
					</table>
				</td>

				<td>
					<table>
						<tr>
							<td>
								<ul>
									<li><a href="#"><img src="<%=basePath%>common/images/fx.png" /></a>
										<p>
											<a href="#" style="color: Black"><strong>运营分析统计</strong></a> 餐饮商家在云端实时账户店铺的运营情况。
										</p></li>
								</ul>
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
 	 	};
 		$(function(){
 		
 			var urlTOP10 = '<%=basePath%>SupermarketView/top10.htm?orgCode=${ sessionScope.accountInfo.orgCode }';
 			var urlByMonth = '<%=basePath%>SupermarketView/saleByMonth.htm?orgCode=${ sessionScope.accountInfo.orgCode }';
 			var urlContrast = '<%=basePath%>SupermarketView/saleByMonthContrast.htm?orgCode=${ sessionScope.accountInfo.orgCode }';
 			var urlPie = '<%=basePath%>SupermarketView/saleByUserType.htm?orgCode=${ sessionScope.accountInfo.orgCode }';
 			viewSupermarket(urlTOP10,urlByMonth,urlContrast,urlPie);
 			
 			$("#orgBtn").click(function(){
 				showOrgTree();
 			});
 			
 			var orgCode = "";
 			var orgName = "";
 			function showOrgTree(){
 				var commonDialog = commonOpenDialog("readDetail",'选择组织',700,450, '<%=basePath%>caipxfmx/orgTree.htm?orgCode=${sessionScope.accountInfo.orgCode}');
 				commonDialog.addBtn("cancel",'取消', commonDialog.cancel);
 				commonDialog.addBtn("ok",'确定', function(){
 					orgCode = $("#orgCode", commonDialog.dgDoc).val();
 					orgName = $("#orgName", commonDialog.dgDoc).val();
 					document.getElementById('orgCode').value = orgCode;
 					document.getElementById('orgName').value = orgName;
 					commonDialog.cancel();
 					if(orgCode==""){
 						orgCode=${ sessionScope.accountInfo.orgCode };
 					}
 					var urlTOP10 = '<%=basePath%>SupermarketView/top10.htm?orgCode='+orgCode;
 		 			var urlByMonth = '<%=basePath%>SupermarketView/saleByMonth.htm?orgCode='+orgCode;
 		 			var urlContrast = '<%=basePath%>SupermarketView/saleByMonthContrast.htm?orgCode='+orgCode;
 		 			var urlPie = '<%=basePath%>SupermarketView/saleByUserType.htm?orgCode='+orgCode;
 		 			viewSupermarket(urlTOP10,urlByMonth,urlContrast,urlPie);
 				});
 			};
 			
 			//上传图片
 			new AjaxUpload('#addLabProdPic', {
 				action: '<%=basePath%>user/uploadFileByImg.htm?userName=${sessionScope.accountInfo.userName}',
					name : 'picFile',
					responseType : 'json',
					onSubmit : function(file, ext) {
						if (ext && /^(jpg|png|bmp)$/.test(ext.toLowerCase())) {
							this.setData({
								'picName' : file
							});
						} else {
							alert("请上传格式为 jpg|png|bmp 的图片！");
							return false;
						}
					},
					onComplete : function(file, response) {
						if (response.error) {
							alert(response.error);
							return;
						}
						$("#vHeader").attr("src", response.picUrl);
						window.parent.document.getElementById("head_headerImg").src = response.picUrl;
					}
				});

		function viewSupermarket(urlTOP10, urlByMonth, urlContrastm, urlPie) {
					$.ajax({
						type : "Post",
						url : urlTOP10,
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						dataType : 'json',
						async : true,
						success : function(data) {
							//第一步,需要把JSON格式转换为如下格式,数据长度和颜色长度必须相同
							//var myData = new Array(['招牌菜', 437], ['汤羹', 322], ['酒水', 233], ['生鲜', 110], ['甜品', 34], ['饮品', 20], ['开胃小菜', 19], ['融合菜', 119],['爱爱爱', 119],['帮不帮', 119]);
							var myData = formatData(data, 'name', 'num');
							//var colors = [ '#2D6B96', '#327AAD', '#3E90C9','#55A7E3', '#60B6F0', '#81C4F0', '#9CCEF0','#CCCEF0','#60B6F0', '#81C4F0'];
							var colors = arrayColors(data);
							var myChart = new JSChart('graph1', 'bar');
							//alert("柱状图1----------->>"+myData);
							myChart.setDataArray(myData);
							myChart.colorizeBars(colors);
							myChart.setTitle('本月超市类别销量排行榜');
							myChart.setTitleColor('#8E8E8E');
							myChart.setAxisNameX('类型');
							myChart.setAxisNameY('数量');
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
							myChart.setSize(616, 288);
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
								myChart.setTooltip(myData[i]);
							}//坐标提示数据
							myChart.setSize(616, 280);
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
							myChart.setSize(600, 260);
							myChart.setTitle('上月本月销售对比');
							myChart.setTitleColor('#206183');
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
							myChart.setAxisPaddingLeft(70);
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
							myChart.setSize(600, 260);
							myChart.setTitle('会员消费汇总');
							myChart.setTitleFontSize(14);
							myChart.setTitleColor('#0F0F0F');
							myChart.setPieRadius(95);
							myChart.setPieValuesColor('#FFFFFF');
							myChart.setPieValuesFontSize(9);
							myChart.setPiePosition(180, 165);
							myChart.setShowXValues(false);
							/* myChart.setLegend('#99CDFB', '黄金会员');
							myChart.setLegend('#3366FB', '白金会员');
							myChart.setLegend('#0000FA', '钻石会员');
							myChart.setLegend('#F8CC00', '普通会员'); */
							myChart.setLegendShow(false);
							myChart.setLegendFontSize(10);
							myChart.setLegendPosition(350, 120);
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
	})
</script>
</html>
