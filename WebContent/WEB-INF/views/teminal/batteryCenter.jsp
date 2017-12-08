<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.sc.teminal.pojo.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/include/includejs.jsp" />

<html>

	<body>
	 
	 <div style="width:100%;">
		<%
		List<Map<String,Object>> list = (List<Map<String,Object>>) request.getAttribute("list");
		
		for(Map<String,Object> map : list){
			Terminalinfo terminalinfo = (Terminalinfo) map.get("one");
			
		
			String bgc = "#66FF66;";
			
			if("1".equals(terminalinfo.getSfbj())){
				bgc = "#FF0000;";
			}

			String dl = map.get("two").toString().trim();
			String dlStr = "<span>电量:"+dl+"</span>";
			
			/*
			if(!"-1".equals(dl)){
				int _dl = Integer.parseInt(dl);
				if(_dl<20){
					dlStr = "<span style='color:red;'>电量:"+dl+"</span>";
				}
			}else{
				dlStr = "<span style='color:blue;'>电量无数据</span>";
			}
			*/
			
		%>
			<div style="width:120px;height:100px; margin: 2px;  border:1px solid blue; background: <%=bgc %> vertical-align:middle; float:left;">
			
				<table width="100%" style="" >
					<!-- <tr><td width="100%"><center><%=terminalinfo.getDevCode() %></center></td></tr> -->
					<tr><td width="100%"><center><%=terminalinfo.getTerminalName() %></center></td></tr>
					<tr><td width="100%"><center><%=terminalinfo.getSwipetime() %></center></td></tr>
					<tr><td width="100%"><center><%=dlStr %></center></td></tr>
				</table>
			</div>
		
		<%	
			
		}
		%> 
	</div>
	
	
	</body>
	 
		
</html>

<script language="javascript" type="text/javascript">

parent.parent.hideLayer();
</script>

