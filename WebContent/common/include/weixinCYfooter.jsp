<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
   String path=request.getContextPath();
   String basePath=request.getScheme()+"://"+ request.getServerName()+":"+ request.getServerPort()+path+"/";
   String menu = request.getParameter("menu");
   
   boolean sess = false;
   // 判断是否存在session
   if(request.getSession().getAttribute("openid")==null){
	   sess = true;
   }
   		//sess = true;
   %>
   <script>

	function checkSession(){
		if(<%=sess%>){
			alert('请重新登录！');
			WeixinJSBridge.call('closeWindow');
		}
	}
	
	</script>
<%	
   
 // out.println("<script>  window.onload=function(){alert('test3'); WeixinJSBridge.call('closeWindow');}  </script>");
%>
 <!--<input type="button" value="关闭本窗口" onclick="WeixinJSBridge.call('closeWindow');" />
	--><footer data-role="footer">
		<link href="<%=basePath%>weixin/css/nav.css" rel="stylesheet">
		<script type="text/javascript" src="<%=basePath%>weixin/js/dialog.js"></script>
		<script type="text/javascript" src="<%=basePath%>weixin/js/nav.js"></script>			
		<nav class="nav">
			<ul class="box">
				<li <% if("1".equals(menu)){out.println("class='on'");} %> >
				<a href="<%=basePath%>weiXinCY/weixinDZ-weixin/orgCode"  onclick="javascript:checkSession();">
					<span class="book">&nbsp;</span>
					<label>在线点菜</label>				
				</a>
			</li>
				<li <% if("2".equals(menu)){out.println("class='on'");} %>>
				<a href="<%=basePath%>weiXinCY/weixinWM-weixin?openid=${openid}" onclick="javascript:checkSession();"	>
					<span class="order">&nbsp;</span>
					<label>外卖订餐</label>				
				</a>
			</li>
				<li <% if("3".equals(menu)){out.println("class='on'");} %>>
				<a href="<%=basePath%>weiXinCY/weixinQueue-weixin" onclick="javascript:checkSession();">
					<span class="queue">&nbsp;</span>
					<label>排队取号</label>				
				</a>
			</li>
				<li   <% if("4".equals(menu)){out.println("class='more on'");}else{ out.println("class='more '");} %>>
				<a href="javascript:;">
					<span class="my">&nbsp;</span>
					<label>我的</label>
				</a>
				<span class="adron"></span>			
				<ul>
					<li><a href="<%=basePath%>weiXinCY/weixinOrderList-weixin?openid=${openid}" onclick="javascript:checkSession();">我的订单</a></li>
					<li><a href="<%=basePath%>weiXinCY/weixinCard-weixin/${orgCode}?openid=${openid}" onclick="javascript:checkSession();">我的会员卡</a></li>
				</ul>
			</li>
						
			</ul>
		</nav>	
</footer>