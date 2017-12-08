<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/common/include/includejs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>
	<body>
		<div class="form-mod">
		<form id="commoditytrackfileupload" name="commoditytrackfileupload"
			action="" method="post" enctype="multipart/form-data">
			<table class="form-table">
				<colspan>
						<col class="w_30per" />
						<col class="w_60per" />
					</colspan>
				<tr>
					<td class="hd" >
						请选择文件：
					</td>
					<td>
						<input type="file" name="doc" />
					</td>
				</tr>
			</table>
		</form>
		</div>
	</body>
	<script type="text/javascript">
		// 等待DOM加载
		var dg = frameElement.lhgDG;
        $(document).ready(function() {
			dg.addBtn( 'no', '取 消', dg.cancel );
			dg.addBtn( 'ok', '上 传', ok );
			
        }); 
    	
    	function ok(){
    		beforeSendAjax();
    		var args = dg.getArgs();
    		if(null != args){
	    		var param = args.param;
	    		if(null != param){
	    			var url = param.url;
	    		}
    		}
            var options = {  
			     url:url,  
			     data: $("form").serialize(),
			     success: function(text) {
			     //IE上会给加这个嵌套的PRE，如果有的话，就去掉
				var reg = /<PRE>(.*)<\/PRE>/;
				//匹配，提取文本
				if(reg.test(text))
				{
					text = reg.exec(text)[1];  
					text = text.replace(/&gt;/g,">").replace(/&lt;/g,"<");
				}
				
				try
				{
					var json = eval("(" + text + ")");
				    completeSendAjax(); 
				    if(json.success){
				    	ajaxSuccess(args,json,true);
				        //fh.alert(json.desc,true,ajaxSuccess(args,json,true),dg);
				    }else{
				        fh.alert(json.desc,true,ajaxSuccess(args,json,false),dg);
				    }
				}
				catch(e)
				{
					//出错了
					console.log(e);
				}
			     }};  
            // 绑定"#myForm"，然后加入回调函数
            $('#commoditytrackfileupload').ajaxSubmit(options); 
    	}
    	
    	function ajaxSuccess(args,json,type){
    		if(null != args){
	    		var handle = (null != args.handle && "" != args.handle) ? args.handle:null;
	    		if(null != handle){
	    			getPwin().eval(handle(json));
	    		}
    		}
    		//if(type){
    		//	dg.cancel();
    		//}
    	}

    </script>
</html>
