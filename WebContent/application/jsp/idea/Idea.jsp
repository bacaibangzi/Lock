<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include/includedlg.jsp"%>
<html>
	<head>
		<script type="text/javascript">
			
			function getIdea(){
		        return $("#open_idea").val();
			}
			function setIdea(str){
				$("#open_idea").val(unescape(str));
			}
			function init(){
				// 等待DOM加载
				var dg = frameElement.lhgDG;
				var args = dg.getArgs();
				var param = args.param;
				if(null != param){
	    			var str = param.memo;
	    		}
	    		if(null!=str&&""!=str&&"undefined"!=str){
	    			setIdea(str);
	    		}
			}
			
			

		</script>
	</head>
	<body onload="init();">
	<div class="form-mod">
		<form id="commoditytrackfileupload" name="commoditytrackfileupload"
			action="<%=path%>/commoditytrack/commoditytrackFileUpload.action"
			method="post" enctype="multipart/form-data">
			<table class="form-table" width="100%" border="0"
					cellspacing="0" cellpadding="0">
				<tr>
					<td class="hd" style="width: 25%;">
						填写描述：
					</td>
					<td class="hd" style="width: 75%;">
						<textarea id="open_idea" style="width: 100%;" rows="" cols=""></textarea>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</body>
</html>
