<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/include/includejs.jsp" />
<%
	//新增按钮
	String addMenu = "7802783440559203414";
	//修改
	String updateMenu = "7291201182524030468";
	//删除
	String delMenu = "6610433833513736115";
	//查看
	
%>
<html>

<body>
	<input type="hidden" id="entityIds" name="entityIds" />
	<input type="hidden" id="code" value="${code}" />
	<input type="hidden" id="materialStockSelect" value="" />
	<input type="hidden" id="materialStockNums" value="" />
    <div class="contenbox">
    
    <div class="sprite_mod">
				<a class="Js_showSearch mod_opts" hidfocus="true" id="searchnav"><spring:message code="system.searchnav" /></a>
			</div>
    
    
    		<!-- 表格列表过滤条件设置 -->
			<div class="filter-mod">
				<ul class="filter-list">
					<li class="filter-item">
						<label class="filter-label">
							用户名称
						</label>
						<input type="text" class="filter-text" id="name1" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							用户工号
						</label>
						<input type="text" class="filter-text" id="name2" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							设备名称
						</label>
						<input type="text" class="filter-text" id="name3" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							卡号
						</label>
						<input type="text" class="filter-text" id="name4" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							到期时间从
						</label>
						<input type="text" class="input-text {required: true, maxlength: 20}" id="dateStr1" name="dateStr1"
								readonly="readonly"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
					</li>
					
					<li class="filter-item">
						<label class="filter-label">
							到
						</label>
						<input type="text" class="input-text {required: true, maxlength: 20}" id="dateStr2" name="dateStr2"
								readonly="readonly"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
						
					</li>
					
					<li class="filter-item filter-btns">
						<a hideFocus="true" class="gray_radiu_btn Js_searchTable">
							 <em class="gray_l"></em> 
							 <em class="gray_r"></em> 
							 <spring:message code="system.query" />
						</a>
						<a hideFocus="true" href="javascript:clearForm('filter-mod');" id="add" class="gray_radiu_btn Js_reLoadTable"> 
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							<spring:message code="system.clear" />
						 </a>
					</li>
				</ul> 
			</div>
    	<div class="grid_summay_opts" id="btns">
				<div class="left_opts">
						<a hideFocus="true" href="javascript:plhc()" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							批量回收
						</a>
						<a hideFocus="true" href="javascript:plyq()" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							批量延期
						</a>
				</div>
    	
				<div class="right_opts">
					<label class="filter-label">
							有效期至
					</label>
					<input name="youXq"  id="youXq"  class="input-text {maxlength: 20}" 
						readonly="readonly"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" value="${rqStr}"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" cssClass="input-text { maxlength: 20}"/>
				</div>
		</div>
			
    <br />
			<table cellpadding="0" cellspacing="0" border="0" id="grid-table" width="100%" class="common_table Js_contextMenuOpt">
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>用户名称</th>
						<th>用户工号</th>
						<th>卡号</th>
						<th>设备名称</th>
						<th>到期时间</th>
						<th>发卡时间</th>
						<th>状态</th>
						<th>类型</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
    </div>
        <div class="rightMenu bodyMenu Js_tdMenu">
            <!--存储当前点击行的数据-->
            <input type="hidden" class="Js_curIndex" value="" />
            <ul> 
                
                <li><a hideFocus="true" href="javascript:detail()">查看</a></li>
            </ul>
        </div> 
	</body>
	    <!-- 日期控件 -->
	<script type="text/javascript" src="<%=path%>/common/js/datapicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var datatable ;
		var reLoad ;
		$(document).ready(function(){
			var tableObj={}
			tableObj.url="<%=basePath%>vhuisYanc/list.htm?code=${vo.code}";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
			    {"mDataProp":"","sDefaultContent":"<input type='checkbox' />","bSortable":false,"sWidth":"20px",sClass:"checkbox"},
			    {"mDataProp":"uiName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"uiNum","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"cardNum","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"terminalname","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"sjStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"edittime","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
					{"mDataProp":"syncstateStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"} ,
					{"mDataProp":"updatetypeStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"} ,
				{"mDataProp":"namelistid","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100" ,
					fnRender: function(value,row,index) {
						return "<input type='button' onClick='hc(\""+row+"\")'  value='回收'> <input type='button'  value='延期' onClick='yq(\""+row+"\")'> ";
				}}
			];
			//添加额外的参数
			tableObj.fnServerParams= function ( aoData ) 
			{
    			aoData.push( { "name": "default_param", "value": "desc"} );
  			}
  			
  			datatable=datatableObj(tableObj);
  			//serach
  			$(".Js_searchTable").live("click",function()
  		  	{
				var url = highQuery();
				tableObj.url  = url;
				datatable = datatableObj(tableObj);
			})

			reLoad = function(){
  				var url = highQuery();
				tableObj.url  = url;
				datatable = datatableObj(tableObj);
  			}
			 
			
		});

		/** 查看详情 **/
		function detail()
		{
			var data=$(".Js_tdMenu").data("data")
			var selectId = data.idStr;
			// 明细弹出框
			var commonDialog = commonOpenDialog("readDetail",'详细',700,450, '<%=basePath%>terminalinfo/detail.htm?code=${vo.code}&entityId=' + selectId);
			commonDialog.addBtn("ok",'确定', commonDialog.cancel);
		}

		/** 按条件查询 **/
		function highQuery()
		{
			// 查询条件 区域名称
			var name1 = $.trim(document.getElementById('name1').value);
			var name2 = $.trim(document.getElementById('name2').value);
			var name3 = $.trim(document.getElementById('name3').value);
			var name4 = $.trim(document.getElementById('name4').value);
			var dateStr1 = $.trim(document.getElementById('dateStr1').value);
			var dateStr2 = $.trim(document.getElementById('dateStr2').value);
			
			var returnVal = '<%=basePath%>vhuisYanc/list.htm?orgCode=${vo.code}';
			if(name1!=''){
				returnVal += '&code=' + encodeURI(encodeURI(name1));
			}
			if(name2!=''){
				returnVal += '&code1=' + encodeURI(encodeURI(name2));
			}
			if(name3!=''){
				returnVal += '&code2=' + encodeURI(encodeURI(name3));
			}
			if(dateStr1!=''){
				returnVal += '&code3=' + encodeURI(encodeURI(dateStr1));
			}
			if(dateStr2!=''){
				returnVal += '&code4=' + encodeURI(encodeURI(dateStr2));
			}
			if(name4!=''){
				returnVal += '&code5=' + encodeURI(encodeURI(name4));
			}
			return returnVal;
		}
		 
		function plhc(){	
			var rows=getSeleteObjs(datatable);
			var idss = '';
			for(var i=0;i<rows.length;i++){
 				idss += rows[i].idStr;
 				if(i<rows.length-1){
 					idss += ',';
 				}
			}
			if(rows.length==0){
				fh.alert("请选择一条记录!");
				return;
			}
			var youXq = $("#youXq").val();
			if(youXq==''){
				fh.alert("请选择有效期!");
				return;
			}
			
			$.ajax({ 
				type: "POST", 
				url: '<%=path %>/devcmdlist/hs.htm', 
				data: "code1=1"+  
				  	  "&dateStr2=" + youXq +
				  	  "&code=" + idss ,
				success: function(msg){
					if(msg){
						fh.alert('已成功发送指令', false, function(){  
							reLoad();
						});
					} else{
						fh.alert('失败');
					}
				}
			});
			
		}
		
		function plyq(){
			var rows=getSeleteObjs(datatable);
			var idss = '';
			for(var i=0;i<rows.length;i++){
 				idss += rows[i].idStr;
 				if(i<rows.length-1){
 					idss += ',';
 				}
			}
			if(rows.length==0){
				fh.alert("请选择一条记录!");
				return;
			}

			var youXq = $("#youXq").val();
			if(youXq==''){
				fh.alert("请选择有效期!");
				return;
			}
			
			$.ajax({ 
				type: "POST", 
				url: '<%=path %>/devcmdlist/yq.htm', 
				data: "code1=1"+  
				  	  "&dateStr2=" + youXq +
				  	  "&code=" + idss ,
				success: function(msg){
					if(msg){
						fh.alert('已成功发送指令', false, function(){  reLoad();
						});
					} else{
						fh.alert('失败');
					}
				}
			});	
		}
		
		/////////////////////////////////////////////////////
		
		function hc(idss){	 
			
			
			$.ajax({ 
				type: "POST", 
				url: '<%=path %>/devcmdlist/hs.htm', 
				data: "code1=1"+  
				  	  "&dateStr2=" + youXq +
				  	  "&code=" + idss ,
				success: function(msg){
					if(msg){
						fh.alert('已成功发送指令', false, function(){  reLoad();
						});
					} else{
						fh.alert('失败');
					}
				}
			});
			
		}
		
		function yq(idss){ 
			var youXq = $("#youXq").val();
			if(youXq==''){
				fh.alert("请选择有效期!");
				return;
			}
			
			$.ajax({ 
				type: "POST", 
				url: '<%=path %>/devcmdlist/yq.htm', 
				data: "code1=1"+  
				  	  "&dateStr2=" + youXq +
				  	  "&code=" + idss ,
				success: function(msg){
					if(msg){
						fh.alert('已成功发送指令', false, function(){ reLoad(); 
						});
					} else{
						fh.alert('失败');
					}
				}
			});
			
		}
		
		
		
		
		
		// 远程开门
		function yuanckm(id){
			
			//alert(id);
			$.ajax({ 
				type: "POST", 
				url: '<%=path %>/devcmdlist/yuanCkm.htm', 
				data: "code1=1"+  
					  "&entityId=" + id ,
				success: function(msg){
					if(msg){
						fh.alert('已成功发送指令', false, function(){  reLoad();
						});
					} else{
						fh.alert('失败');
					}
				}
			});
		}
		
	</script>
		
</html>
<script type="text/javascript">
	document.body.style.backgroundColor="white";
</script>

