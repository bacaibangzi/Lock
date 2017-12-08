<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include/includeform.jsp"%>
<html>
	<head>
		
	</head>
	<body>
		<div class="form-mod">
			<form id="subForm" action="" method="post">
				<input type="hidden" name="accountVo.accountId" id="accountId"
					value="5075567913689610725">
				<table class="form-table">
					<colspan>
						<col class="w_30per" />
						<col class="w_60per" />
					</colspan>
					
					<tbody>
					<tr>
						<td class="hd">
							发布选项：
							<font style="color: red">*</font>
						</td>
						<td >
							<input type="radio" name="items" value="0" maxlength=20
								id="name" onclick="javascript:changeTimeOption(this)" checked />
							立即发布 &nbsp;&nbsp;&nbsp;
							<input type="radio" name="items" value="1" maxlength=20
								id="name" onclick="javascript:changeTimeOption(this)" />
							定时发布
						</td>
					</tr>
					<tr id="dtime" style="display: none">
						<td class="hd">
							定时时间：
							<font style="color: red">*</font>
						</td>
						<td >
							<input type="text" class="input_text_middle" id="releaseTime" name="releaseTime"
								readonly="readonly" onkeydown="setSelectedDate(event);"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-{%d+1} {%H+1}:%m:%s'})"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-{%d+1} {%H+1}:%m:%s'})" />
							<font id="releasets" color="red" style="display:none">必选项</font>
						</td>
					</tr>
					</tbody>
					<tfoot>
					<tr>
						<td colspan="2">
								<font style="color: #15428B"> &nbsp;&nbsp;&nbsp;&nbsp;若使用定时发布，则发布一分钟后生效！</font>
						</td>
					</tr>
					</tfoot>
				</table>
			</form>
		</div>
	</body>
	<script type="text/javascript" src="<%=path %>/common/js/datapicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function isNow() {
			var item = $("input[name='items']:checked").val();
			return item;
		}
		
		function getTime() {
			var rs =isNow();
			if(rs=="0"){
				return "0";
			}else{
				if($("#releaseTime").val() == "" ){
					$("#releasets").css('display','');
				}else{
					$("#releasets").css('display','none');
				}
				return $("#releaseTime").val();
			}
		}
		
		function changeTimeOption(elem) {
			$("#releasets").css('display','none');
			var value = elem.value;
			var time = $("#dtime");
			if (value == "0") {
				time.hide();
			} else {
				time.show();
			}
		}
		</script>
</html>
