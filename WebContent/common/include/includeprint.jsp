<%
  String realpath=request.getContextPath();
%>
<div style="display:none">
	<object id="secmgr" style="DISPLAY: none" codeBase="<%=realpath%>/common/scriptx/smsx.cab#Version=6,4,438,06" classid="clsid:5445BE81-B796-11D2-B931-002018654E2E" viewastext>
	<param name="GUID" value="{816FDDC3-5863-4785-94D3-64EFFBE8D615}">  
	<param name="PATH" value="<%=realpath%>/common/scriptx/sxlic.mlf">
	<param name="REVISION" value="0" >
	<param name="PerUser" value="true" >
	</object>
	<object id="factory" classid="clsid:1663ED61-23EB-11D2-B92F-008048FDD814" viewastext>
	</object>
</div>
<OBJECT id=wb height=0 width=0 classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2 name=wb></OBJECT>