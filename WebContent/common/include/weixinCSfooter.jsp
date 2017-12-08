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
		<link href="<%=basePath%>weixin/css/nav_green.css" rel="stylesheet">
		<script type="text/javascript" src="<%=basePath%>weixin/js/dialog.js"></script>
		<script type="text/javascript" src="<%=basePath%>weixin/js/nav.js"></script>			
		<nav class="nav">
			<ul class="box">
				<li <% if("1".equals(menu)){out.println("class='on'");} %> >
				<a href="<%=basePath%>weiXinCS/index-weixin/orgCode"  onclick="javascript:checkSession();">
					<span class="list">&nbsp;</span>
					<label>在线购物</label>				
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
				</ul>
			</li>
						
			</ul>
		</nav>	
</footer>