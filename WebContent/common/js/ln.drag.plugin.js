
/*
*Author:LN(Allison Lee)
*Date:2012-07-05 - 2012-07-
*Time：13：21
*Descript：portal Plugin
*Update: 正在时刻更新.....有问题联系李宁（UED）
*Update1:2012-07-14  13:56 
*Update1-Descript:解决循环ajax时出现的只执行最后一个循环的问题（异步导致时间间隔，在ajax返回成功后再进行下一个ajax请求）

*Update2:Ln(Allison Lee)
*Update:2012-07-19 15:34
*Update2-Descript:整理页面接口问题 整理插件结构
*Update3:2012-07-20 09:03  添加各个回调函数

*Update4:2012-07-30 11:37
*Update4-Descript:添加动态改变列宽度的问题
*/
	
var LnDragMove=function(options){
	this.oSettings="";
	//drag mod
	var dragobj={}
	var _this=$(this)
	var defalutOptions={
		colcount:3,
		serverMethod:"POST",
		serverSideAjax:null,
		colWArray:["30%","30%","40%"],
		mergeOrNot:true,//是否合并（  列数发生变化后是否列进行合并 否则直接删除）
		dragEnd:null,
		dragStart:null,
		//设置已经存在的模块的默认位置（可以为空）
		dragObjPos:null,
		//刷新回调函数
		refreshCallback:null,
		//设置回调
		configCallback:null,
		//更多设置回调 
		moreConfig:null,
		//删除操作 回调
		deleteCallback:null
	}
	//合并配置参数以及默认参数
	var oSettings=$.extend({},defalutOptions,options)
	this.oSettings=oSettings;
	
	//动态设置列的宽度问题
	if(oSettings.colcount!=oSettings.colWArray.length){
		//列数小于宽度设置的个数
		if(oSettings.colcount>oSettings.colWArray.length){
			alert("设置的列的个数大于所设置的对象数组的个数，无法完成你的请求！请确保设置的列的个数小于等于所设置的对象数组的个数！")
		}
		//列数大于宽度设置的个数
		if(oSettings.colcount<oSettings.colWArray.length){
			//如果进行合并
			if(oSettings.mergeOrNot){
				var minus=oSettings.colWArray.length-oSettings.colcount
				//进行合并
				for(var merg=oSettings.colcount;merg<oSettings.colWArray.length;merg++)
				{
					oSettings.colWArray[oSettings.colWArray.length-2]=parseInt(oSettings.colWArray[oSettings.colWArray.length-1].slice(0,-1))+parseInt(oSettings.colWArray[oSettings.colWArray.length-2].slice(0,-1))+"%"
				}
				for(var icol=0;icol<oSettings.colcount;icol++)
				{	
					$("#col"+icol).css("width",oSettings.colWArray[icol])
				}	
			}
			//否者直接删除
			else
			{
				
			}
		}
	}
	else
	{
		for(var icol=0;icol<oSettings.colWArray.length;icol++)
		{	
			$("#col"+icol).css("width",oSettings.colWArray[icol])
			$("#col"+icol).data("preW",oSettings.colWArray[icol])
		}	
	}
	//初始化通用方法
	 _init()
	 //初始化页面中的内容
	 function ajaxGetContext(i,totalCurL){
	 		var curID=_this.find(".ln-mod").eq(i).attr("id")
	 		var curUrl=$("#"+curID).find(".mod_con").attr("title") ? $("#"+curID).find(".mod_con").attr("title") : "common/include/commonopt.jsp";
	 		$.ajax({
			type:"POST",
			dataType:"html",
			url:curUrl,
			beforeSend:function(XMLHttpRequest){
			$("#"+curID).find(".mod_con").html("<div>正在加载数据。。。</div>")	
			},
			success:function(data){
				$("#"+curID).find(".mod_con").html(data)
				i=i+1;
				if(i>=totalCurL)
				{
					return false;
				}
				else
				{
					ajaxGetContext(i,totalCurL)
				}
			}
	 		})
	 }
	 
	 //位置存储
	 function _getPositionState(param){
			if(param.length==colDom.length)
			{
				var deleteDom=[];
			 	for(var colL=0;colL<colDom.length;colL++)
			 	{
			 		var curCol=$(colDom[colL]).attr("id")
			 		var curColChild=param[colL][curCol].split(",")
					for(var childMod=0;childMod<curColChild.length;childMod++)
					{	
						//拼接默认的模块的属性
						var data={}
						data.ID=curColChild[childMod]
						data.title=$("#"+curColChild[childMod]).find(".title").text();
						data.editUrl=""
						data.pboxId=curCol
						data.headImg=""
						data.modUrl=$("#"+curColChild[childMod]).find(".mod_con").attr("title")
						data.moreShowStyle=""
						data.editUrl=$("#"+curColChild[childMod]).find(".Js_config").attr("href")
						$("#"+curColChild[childMod]).data("data",data)
						_this.find("#"+curColChild[childMod]).appendTo(colDom.eq(colL).find(".inner-mod"))	
					}
			 	}
		 	}
		 	else
		 	{
		 		alert("请确保列的个数与列对应的参数dragobjPos的个数相等！")
		 	}
	 }
	//根据参数配置 初始化页面dom结构 （页面中默认存在的  对排序后的再次加载时进行位置重置）
	var colDom=_this.find("div[id^='col']")
		if(typeof(oSettings.dragObjPos)=="object")
		{
			_getPositionState(oSettings.dragObjPos)
	 	}
	 	else
	 	{
	 		$.ajax({
	 			type:"POST",
	 			dataType:"json",
	 			url:oSettings.dragObjPos,
	 			success:function(data){
	 				_getPositionState(data)
	 			}
	 		})
	 	}	
	//获取json文件中的内容 并动态插入到页面DOM结构中去
	if(oSettings.serverSideAjax){
		$.ajax({
			type:oSettings.serverMethod,
			url:oSettings.serverSideAjax,
			dataType:"json",
			success:function(data){
				//判断位置存储是array 还是 服务器端进行读取的
				if(typeof(oSettings.dragObjPos)=="object"){
				$.each(data,function(i,item){
					var itemMod=_getJoinMod(item)
					_setInitPosition(oSettings.dragObjPos,item,itemMod)
					})
					//ajax加载内容
					ajaxGetContext(0,_this.find(".ln-mod").length)
					//绑定hover事件
					_hoverModFn()					
				}
				if(typeof(oSettings.dragObjPos)=="string"){
					$.ajax({
						type:"POST",
						dataType:"json",
						url:oSettings.dragObjPos,
						success:function(posdata){
							$.each(data,function(i,item){
								var curItem=item;
								var itemMod=_getJoinMod(item)
								_setInitPosition(posdata,item,itemMod)
							})	
							//ajax加载内容
							ajaxGetContext(0,_this.find(".ln-mod").length)
							//绑定hover事件
							_hoverModFn();
						}
					})
				}
			}
		})
	}
	//组合模块
	function _getJoinMod(item){
		//通过判断当前body中是否有borderRadius 判断
		console.log(document.body.style)
		var borderClass=(document.body.style.boxShadow!="undefined") ? " " : "noborder-mod" 
		var closeBle=item.closeAble? '<li class="bar_item"><a href="javascript:void(0)" title="删除" class="Js_deleteMod"><img src="common/images/portal/deletemod.png" title=""></a></li>' :""
		var titleImg=item.headImg ? item.headImg : "common/images/portal/normal.png"
		var itemMod='<div class="ln-mod  '+borderClass+' " id="'+item.ID+'"><div class="draghd"><a href="#"  class="img"><img src="'+titleImg+'" title="" /></a><span class="title">'+item.title+'</span><span class="titlebar"><ul class="bar_list"><li class="bar_item"><a href="javascript:void(0)" title="刷新" class="Js_refresh"><img src="common/images/portal/refresh.png" alt="刷新"/></a></li><li class="bar_item"><a href="javascript:void(0)" title="设置" class="Js_config"><img src="common/images/portal/config.png" alt="设置"/></a></li><li class="bar_item"><a href="" title="更多" class="Js_more"><img src="common/images/portal/more.png" alt="更多" title="更多"></a></li>'+closeBle+'</ul></span></div><div class="mod_con" title="'+item.modUrl+'"></div></div>'
		return itemMod
	}
	//ln-mod hover属性
	function _hoverModFn(){
		$(".ln-mod").hover(function(){
			var _this=$(this)
			_this.addClass("ln-mod-hover")
		},function(){
			var _this=$(this)
			_this.removeClass("ln-mod-hover")
		})
	}
	//设置位置(服务器端或是自定义 json数据格式)
	function _setInitPosition(params,item,itemMod){
					var inornot=false;
					for(var p=0; p<params.length;p++){
						var eleBox=[]
						for(var ele in params[p])
						{
							eleBox=(params[p][ele]).split(",")
							if($.inArray(item.ID,eleBox)!=-1)
							{
								inornot=true;
								//当前对象mod在col中的索引
								var curItemId=$.inArray(item.ID,eleBox)
								//console.log(eleBox)
								//console.log(item.ID+"的索引是"+curItemId)
								if(curItemId==0)
								{
									$(itemMod).prependTo($("#"+ele).find(".inner-mod"))
								}
								else
								{
									var curBoxChildL=$("#"+ele).find(".ln-mod").length
									if(curBoxChildL-1>=curItemId)
									{
										//console.log(item.ID+"应该在"+$("#"+ele).find(".ln-mod").eq(curItemId-1)+"的后面")
										//使用原生态的js中splice方法在指定的索引处插入当前的dom结构
										$(itemMod).insertAfter($("#"+ele).find(".ln-mod").eq(curItemId-1))
									}
									else{
										$("#"+ele).find(".inner-mod").append($(itemMod))
									}
									/*var insertAfterEle=_getIndexPos(ele,curItemId,eleBox,item.ID)
									insertAfterEle=="undefined" ?
									$(itemMod).insertBefore($("#"+insertAfterEle))
									 :
									$("#"+ele).find(".inner-mod").append(itemMod)
									*/
								}
								$("#"+item.ID).data("data",item)
							}
							else
							{
								continue;
							}
					}
					if(inornot==false)
					continue;
				}
					//判断是否在返回的osettings.dragObjPos里面
					if(inornot==false)
					{
						//合并是否
						if($("div[id^=col]").length>oSettings.colcount)
						{
							if(oSettings.mergeOrNot){
								for(var curCol=oSettings.colcount;curCol<$("div[id^=col]").length;curCol++){
									if($("#col"+curCol).length>0)
									{
										$("#col"+curCol).remove();
									}
									if(item.pboxId=="col"+curCol){
										$("#col"+(parseInt(curCol)-1)).find(".inner-mod").append($(itemMod))
									}
									else
									{
										$("#"+item.pboxId).find(".inner-mod").append($(itemMod))
									}
								}
							}
							else
							{
								for(var curCol=oSettings.colcount;curCol<$("div[id^=col]").length;curCol++){
									if(item.pboxId=="col"+curCol){
										$("#"+item.ID).data("data",item)
										continue;
									}
									else{
									$("#"+item.pboxId).find(".inner-mod").append($(itemMod))	
									}
								}
							}
							$("#"+item.ID).data("data",item)
						}
						else
						{
							$("#"+item.pboxId).find(".inner-mod").append($(itemMod))
							$("#"+item.ID).data("data",item)
						}
					}
					
					_dragStart();
	}
	//获取 插入位置
	//如果遍历的jquery对象不存在 就继续递归遍历 直到找到最靠近的并且存在的dom结构 并将当前对象插入的这个位置的后面
	function _getIndexPos(pBox,curIndex,eleBox,itemid)
	{
		if(curIndex<=0)
		{
			return 0;
		}
		else
		{
			if($("#"+pBox).find("#"+eleBox[curIndex-1]).length>0)
			{
				//console.log("#"+eleBox[curIndex-1])
				return eleBox[curIndex-1];
			}
			else
			{	
				_getIndexPos(pBox,curIndex-1,eleBox,itemid)
			}
		}
	}
	function _dragStart(){
	 //开始拖拽操作
	 var o=$(".draghd")
	 //遍历可拖拽的mod对象
	 for(var i=0;i<o.length;i++){
	 //在draghd上 鼠标点击down后执行如下  鼠标点击后 产生虚拟位置跟踪
	  $(o[i])[0].onmousedown=function(e){
	  //判断当前点击的对象
	  var e=e || window.event;
	  var target=e.target ? e.target : e.srcElement;
	  var targetClass=$(target).attr("class")
	  if(targetClass!="draghd" && targetClass !="title")
	  	{
	  		var thisParentID=$(target).parents(".ln-mod").attr("id")
	  		var aClass=$(target).attr("class") ? $(target).attr("class") : $(target).parent("a").attr("class");
	  		//刷新，设置，更多，删除
	  		switch(aClass){
	  			case "Js_refresh" : refresh(thisParentID,oSettings); break;
	  			case "Js_config" : config(thisParentID,oSettings); break;
	  			case "Js_more" : more(thisParentID,oSettings); break;
	  			case "Js_deleteMod" : deleteMod(thisParentID,oSettings); break;
	  			case "img" : closeContent(thisParentID,oSettings); break;
	  			default: "";
	  		}
	  		return;
	  	}
	  //drag 
	  //如果当前对象已经存在 就退出
	   if(dragobj.o!=null)
	    return false
	   e=e||event
	   //当前拖动对象的父亲容器  即表示待被拖动的整个容器对象
	   dragobj.o=this.parentNode
	   dragobj.xy=_getxy(dragobj.o)
	   //鼠标点击的位置
	   dragobj.xx=new Array((e.x-dragobj.xy[1]),(e.y-dragobj.xy[0]))
	   dragobj.o.style.width=dragobj.xy[2]+"px"
	   dragobj.o.style.height=dragobj.xy[3]+"px"
	   dragobj.o.style.left=(e.x-dragobj.xx[0])+"px"
	   dragobj.o.style.top=(e.y-dragobj.xx[1])+"px"   
	   dragobj.o.style.position="absolute"
	   var om=document.createElement("div")
	   dragobj.otemp=om
	   om.style.width=dragobj.xy[2]+"px"
	   om.style.height=dragobj.xy[3]+"px"
	   om.style.border="3px"
	   om.style.borderStyle="dotted"
	   om.style.borderColor="#ccc"
	   dragobj.o.parentNode.insertBefore(om,dragobj.o)
	   dragobj.parentBox=$(this.parentNode).parents("div[id^='col']")
	   //调用dragStart函数
	   oSettings.dragStart();
	   return false
	  }
	 }
	 }
	window.onerror=function(){return false}
	function _init(){
	//判断浏览器的类型（通过扩展String的原型对象，利用继承原理）
	 String.prototype.inc=function(s){return this.indexOf(s)>-1?true:false}
	 var agent=navigator.userAgent
	 //直接定义在window对象上   全局变量
	 //Opera浏览器
	 window.isOpr=agent.inc("Opera")
	 //IE浏览器
	 window.isIE=agent.inc("IE")&&!isOpr
	 //火狐浏览器
	 window.isMoz=agent.inc("Mozilla")&&!isOpr&&!isIE
	 if(isMoz){
	 //给event对象添加
	  Event.prototype.__defineGetter__("x",function(){return this.clientX+document.documentElement.scrollLeft+2})
	  Event.prototype.__defineGetter__("y",function(){return this.clientY+document.documentElement.scrollTop+2})
	 }
	 //初始化页面通用函数
	 window.Q=function(obj){return typeof(obj)=="string"?document.getElementById(obj):obj}	 
	}
	//取消页面选中状态
	document.onselectstart=function(){return false}
	//窗体聚焦时执行
	window.onfocus=function(){document.onmouseup()}
	//窗体失去焦点的时候执行
	window.onblur=function(){document.onmouseup()}
	
	//定义文档的松开鼠标后执行的函数内容
	document.onmouseup=function(){
	 if(dragobj.o!=null){
	  dragobj.o.style.width="auto"
	  dragobj.o.style.height="auto"
	  dragobj.otemp.parentNode.insertBefore(dragobj.o,dragobj.otemp)
	  dragobj.o.style.position=""
	  //存入cookies
	  var oldParentId=$(dragobj.parentBox).attr("id")
	  var oldChildArray=[]
	  var oldChilds=$("#"+oldParentId).find(".ln-mod")
	  var oldChildsL=oldChilds.length;
	  var targetParentId=$(dragobj.otemp).parents("div[id^='col']").attr("id")
	  var childs=$("#"+targetParentId).find(".ln-mod");
	  var childL=childs.length
	  var childArray=[]
	  var backJson=""
	  for(var c=0;c<childL;c++)
	  {
	  	childArray.push(childs.eq(c).attr("id"))
	  }
	  for(var d=0;d<oldChildsL;d++)
	  {
	  	oldChildArray.push(oldChilds.eq(d).attr("id"))
	  }
	  //拼接json格式
	  if(targetParentId==oldParentId)
	  backJson='{"'+targetParentId+'":"'+childArray+'"}';
	  else
	  backJson='{"'+targetParentId+'":"'+childArray+'","'+oldParentId+'" :"'+oldChildArray+'"}'
	  //调用回调函数
	  oSettings.dragEnd(backJson);	  
	  
	  //还原空对象
	  $(dragobj.otemp).remove();
	  dragobj={}

	 }
	}
	//移动鼠标执行的函数
	document.onmousemove=function(e){
	 e=e||window.event
	 if(dragobj.o!=null){
	 if(document.all){
	 	//计算页面模块移动的位置  鼠标拖拽时候的位置
		dragobj.o.style.left=e.clientX-dragobj.xx[0];
		dragobj.o.style.top=e.clientY-dragobj.xx[1];
	 }
	 else
	 {
	 	dragobj.o.style.left=(parseInt(e.x)-parseInt(dragobj.xx[0]))+"px"
	 	dragobj.o.style.top=(parseInt(e.y)-parseInt(dragobj.xx[1]))+"px"
	 }
	  _createtmpl(e)
	 }
	}
	
	//param: 待拖动的整个对象容器
	var _getxy=function(e){
	 var a=new Array()
	 //对象距离顶的高度
	 var t=e.offsetTop;
	 //距离左侧的距离
	 var l=e.offsetLeft;
	 //宽度
	 var w=e.offsetWidth;
	 //高度
	 var h=e.offsetHeight;
	 
	 while(e=e.offsetParent){
	  t+=e.offsetTop;
	  l+=e.offsetLeft;
	 }
	 //返回一个数据 分别存储：top,left,width,height
	 a[0]=t;a[1]=l;a[2]=w;a[3]=h
	  return a;
	}
	//o表示当前的拖拽对象
	//e表示的当前的时间对象
	//判断是很行拖拽 还是垂直拖拽
	var _inner=function(o,e){
	//获取当前对象的 距离左侧 右侧 宽度 以及高度
	 var a=_getxy(o)
	 if(e.x>a[1]&&e.x<(a[1]+a[2])&&e.y>a[0]&&e.y<(a[0]+a[3])){
	  if(e.y<(a[0]+a[3]/2))
	   return 1;
	  else
	   return 2;
	 }else
	  return 0;
	}
	//设置 虚拟位置 div的位置  以及实时变换temp对象div的宽度
	var _createtmpl=function(e){
	//12表示的是一共多少个可拖动对象,这个值可以从后台读取
	 for(var i=0;i<_this.find(".ln-mod").length;i++){
	 //判断当前的移动对象
	 var curID=_this.find(".ln-mod").eq(i).attr("id")
	  if(Q(curID)==dragobj.o)
	  //如果当前的id指向的对象不是正在移动的对象 就继续遍历
	   continue;
	   //判断当前对象所处的位置
	  var b=_inner(Q(curID),e)
	  if(b==0)
	  {
		 for(var j=0;j<oSettings.colcount;j++){
		 //获取当前列对象的 left,top,width,height
		  var op=_getxy(Q("col"+j))
		 if(e.x>(op[1]+10)&&e.x<(op[1]+op[2]-10) && $("#col"+j).find(".inner-mod").find(".ln-mod").length<=0){
		   $("#col"+j).find(".inner-mod")[0].appendChild(dragobj.otemp)
		   dragobj.otemp.style.width=(op[2]-10)+"px"
		  }
		 }
	 	  
	   continue
	   }
	   //自动宽度设置
	  dragobj.otemp.style.width="auto"
	  if(b==1){
	  //直接插入到当前模块的前面
	   Q(curID).parentNode.insertBefore(dragobj.otemp,Q(curID))
	  }else{
	  //如果是最后一个对象 就直接插入父亲容器的最后
	   if(Q(curID).nextSibling==null){
	    Q(curID).parentNode.appendChild(dragobj.otemp)
	   }else{
	   //否则插入当前拖拽对象的下一个兄弟节点的前面
	    Q(curID).parentNode.insertBefore(dragobj.otemp,Q(curID).nextSibling)
	   }
	  }
	  dragobj.targetParent=$(dragobj.otemp).parents("div[id^='col']")
	  return
	 }
	 for(var j=0;j<oSettings.colcount;j++){
	 //遍历列数
	
	 if($("#col"+j).find(".inner-mod").html().inc("div")||$("#col"+j).html().inc("DIV"))
	 continue;
	 //获取当前列对象的 left,top,width,height
	  var op=_getxy(Q("col"+j))
	 if(e.x>(op[1]+10)&&e.x<(op[1]+op[2]-10)){
	   $("#col"+j).find(".inner-mod")[0].appendChild(dragobj.otemp)
	   dragobj.otemp.style.width=(op[2]-10)+"px"
	  }
	 }
	}	
	//开始操作 可以拖拽的对象
	_dragStart()	
//获取当前对象的配置值
function _fnSettings(){
	return oSettings;
}
//获取服务器端返回的数据
function _fnGetServerJson(){
	var settings=_fnSettings();
	if(settings.serverSideAjax){
		$.ajax({
			type:settings.serverMethod,
			url:settings.serverSideAjax,
			dataType:"json",
			success:function(data){
				return data;
			}
		})
	}
}

//获取当前布局方式接口
this.getCurrentLayout=function(){
	return _fnSettings();
}

//获取当前布局模块的所有信息
this.getModelSettings=function(callback){
	var settings=_fnSettings();
	var modSettings;
	if(settings.serverSideAjax){
		$.ajax({
			type:settings.serverMethod,
			url:settings.serverSideAjax,
			dataType:"json",
			success:function(data){
				if(typeof(callback)=="function")
				callback(data)
				else
				return;
			}
		})
	}
}

//获取当前信息快对象
this.getModuleById=function(param){
	if(typeof(param)=="string")
	{
		if($("#"+param).length>0)
		{
			return $("#"+param).data("data")
		}
	}
}


//根据模块id,或是name 刷新信息块
this.refreshModuleById=function(param,callback){
	if(param!="" && typeof(param)=="string")
	{
		if(typeOf(callback)=="function")
		{
			callback(param)
		}
	}
}


//根据模块id、name删除信息块
this.delModule=function(param,callback){
	if(confirm("你确定要删除这个模块吗"))
	{
		try{
			if(typeof(callback)=="function")
			callback(param)
			}
		catch(e){
			alert(e)
		}
	}
	else
	{}
}


//添加数据块信息
/*
	"ID":"m26",
	"title":"col2-m26",
	"closeAble":false,
	"pboxId":"col2",
	"headImg":null,
	"modUrl":"",
	"moreShowStyle":"",
	"editUrl":""

*/

this.addModule=function(param,callback){
	var defaultAttributes={
		"ID":"m26",
		"title":"col2-m26",
		"closeAble":false,
		"pboxId":"col2",
		"headImg":null,
		"modUrl":"",
		"moreShowStyle":"",
		"editUrl":""
	}
	if(typeof(param)=="object")
	{
		var paramObj=$.extend({},param,defaultAttributes)
		var itemStr=_getJoinMod(paramObj)
		//拼接模块 并返回这个凭借的字符串  以参数的形式返回给回调函数
		if(typeof(callback)=="function"){
			callback(itemStr)
		}
	}

}


//支持调用加载数据函数,并将Ajax请求到的数据插入到指定的区域
this.loadModuleData=function(param,callback){
	if(typeof(callback)=="function")
	{
		if(typeof(param)=="string")
		callback(param)
	}
}


//调用接口 在页面不更新的情况下 修改页面列的宽度
this.setColW=function(colWAryParm,callback){
	//判断colWAry 是否为数组 以及传入的值对现有列的影响的问题
	//首先判断是否是数组
	if(colWAryParm instanceof Array)
	{
		var colWAryParmCount=colWAryParm.length
		var domEle=$(this).find("div[id^='col']")
		var domCount=domEle.length
		var totalW=0
			for(var w=0;w<domCount;w++){
				colWAryParm[w] ? domEle.eq(w).css("width",colWAryParm[w]) : ""
			}		
		/*if(colWAryParmCount==domCount)
		{
			for(var cc=0;cc<colWAryParmCount;cc++)
			{
				totalW+=parseInt(colWAryParm[cc].slice(0,-1))
			}
			if(totalW!=100){
				alert("输入的参数值总和要是100%！")
				return;
			}
			else
			{
				for(var w=0;w<domCount;w++){
					colWAryParm[w] ? domEle.eq(w).css("width",colWAryParm[w]) : ""
				}
			}
		}
		else{
			for(var w=0;w<domCount;w++){
				colWAryParm[w] ? domEle.eq(w).css("width",colWAryParm[w]) : ""
			}
		}
		*/
		if(callback && typeof(callback)=="function")	
		{
			callback();
		}
	}
	else
	{
		alert("请输入数组格式的参数!")
	}
}

//动态计算 已存在列的宽度 
function _calColTotalW(domEle){
	//var totalW
	//for()
}
//返回对象
return this;
}
	$.fn.LnDragMove=LnDragMove;
	$.fn.lnDragMove=LnDragMove;
	//mod操作
	//refrash
	function refresh(modID,oSettings){
				var curMod=$("#"+modID).data("data")
		 		$.ajax({
				type:"POST",
				dataType:"html",
				url:curMod.modUrl ? curMod.modUrl : "common/include/commonopt.jsp",
				beforeSend:function(XMLHttpRequest){
				$("#"+modID).find(".mod_con").html("<div>正在加载数据。。。</div>")	
				},
				success:function(data){
					$("#"+modID).find(".mod_con").html(data)
					if(typeof(oSettings.refreshCallback)=="function"){
						oSettings.refreshCallback(modID);
					}
				}
		 		})
		
	}
	//config 加载设置页面
	function config(modID,oSettings){
		var curMod=$("#"+modID).data("data");
		if($("#"+modID).data("editOpen")=="true")
		return;
		var url=curMod.editUrl ? curMod.editUrl : "";
		if(url=="")
		{	
			alert("编译页面地址不存在,请到服务器端配置页面的编辑页面地址！")
			return;
		}
		//加载设置页面
		$.ajax({
			type:"POST",
			dataType:"html",
			url:url,
			success:function(data){
				$("#"+modID).data("editOpen","true");
				$("#"+modID).find(".mod_con").prepend(data)
				if(typeof(oSettings.configCallback)=="function"){
					oSettings.configCallback(modID)
				}
			}
		})
	}
	//more
	function more(modID,oSettings){
		if(typeof(oSettings.moreConfig)=="function"){
			oSettings.moreConfig(modID)
		}
		alert(modID)
	}
	
	//delete mod
	function deleteMod(modID,oSettings){
		if(typeof(oSettings.deleteCallback)=="function"){
			oSettings.deleteCallback(modID)
		}
		alert(modID)
	}
	
	//content close
	function closeContent(modID){
		var _thisBox=$("#"+modID)
		var _thisBoxCon=_thisBox.find(".mod_con")
		if(_thisBoxCon.is(":visible"))
		_thisBoxCon.hide();
		else
		_thisBoxCon.show();
		
		
	}

