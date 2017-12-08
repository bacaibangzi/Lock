<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include/includeform.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<style type="text/css">
		body{
			padding:0;margin:0;overflow:hidden;
		}
		a:link{color: #2e5a79;}
		a:visited{color: #813603;}
		a:hover{color: #61a8db;}
		a:active{color: #2e5a79;}
	</style>
	</head>
	<body>
		<div class="export">
		<span class="float_left">导出字段选择：</span><a class="float_right" onclick="" href="javascript:void(0)">全选</a>
		</div>
		<div class="export-select">
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		    	<tr>
		    		<td width="8%" align="right">
						<div class="checkbox_td">
						<input type="checkbox"  checked="checked" value="name" name="exportCodeList">
						</div>
		    		</td>
		    		<td width="42%">
						<div class="checkbox_text">
						：客户名称
						</div>
		    		</td>    	
		    		<td width="8%" align="right">
						<div class="checkbox_td">
						<input type="checkbox"  value="name" name="exportCodeList">
						</div>
		    		</td>
		    		<td width="42%">
						<div class="checkbox_text">
						：类别
						</div>
		    		</td>   
		    	</tr>
		    	<tr>
		    		<td width="8%" align="right">
						<div class="checkbox_td">
						<input type="checkbox" value="name" name="exportCodeList">
						</div>
		    		</td>
		    		<td width="42%">
						<div class="checkbox_text">
						：地址
						</div>
		    		</td>    	
		    		<td width="8%" align="right">
						<div class="checkbox_td">
						<input type="checkbox" value="name" name="exportCodeList">
						</div>
		    		</td>
		    		<td width="42%">
						<div class="checkbox_text">
						：联系人
						</div>
		    		</td>   
		    	</tr>
		    </table>
	    </div>
	</body>
	<script type="text/javascript">
	 	PageCss.initCtrl(document.body);
	 	var dg = frameElement.lhgDG;
		dg.addBtn( 'no', '取 消', dg.cancel );
	    dg.addBtn( 'ok', '导 出', dg.cancel );
	    
        <%-- 全选 --%>
        function selectAll(name){
            var    ids    = $(name);
            for(var i = 0;i<ids.length;i++){
                   ids[i].checked=true;
            }
        }
    </script>
</html>
