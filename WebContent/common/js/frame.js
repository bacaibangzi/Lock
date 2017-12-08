function loadMenuTree(path,menucount,array){
	for(var i=0;i<menucount;i++)
	{
		//array[i]:获取的array数组中第i个数组对象
		//array[i][0]：获取的第i个数组中第o个对象（单体对象{}）
		//alert(array[i][0].url)
		var o_1 = {
			cbiconpath: path+'/js/tree/images/tree/',
			title:'资源信息',	
			showcheckbox : false,
			showcheck : false,
			cascadecheck : true,
			oncheckboxclick : false,
			url:false,
			theme : "bbit-tree-lines",
			isShowBase:false,
			contextMenu:false,
			onnodeclick:function(item){
				var tabImg = "";
				if(item.imgPath == undefined){
					tabImg ="images/tablist.png";
				}else{
					tabImg = item.imgPath;
				}
				if(item.url != ""){
					addTabCon({id:item.id,url:path+item.url,title:item.text,tabImg:tabImg,tabClose:"true"});
				}
			},
			data: array[i]
		}; 
		init(o_1);
		$("#div_"+(i+1)).treeview(o_1);	
	}
}
$(document).ready(function(){
	$("#Js_uiMenu > li > a.ui-menu-title").each(function(){
		var _this=$(this)
		_this.live("click",function(){
			if(_this.is(".ui-menu-title-sel")){
			                _this.removeClass("ui-menu-title-sel").siblings("div.bbit-tree").slideUp(100);
			            }else{
			                _this.addClass("ui-menu-title-sel").siblings("div.bbit-tree").slideDown(100).parents("li").siblings("li").find("a.ui-menu-title").removeClass("ui-menu-title-sel").siblings("div.bbit-tree").slideUp(100)
			            }

		})
	})
})

//ln tab
$(document).ready(function(){
        $(".lnui-tabs > div").eq(0).show().siblings("div").hide()      
        var lnTabs=[]
        var tabsH=$(".lnui-tabs > div")
        var tabs=$(".lnui-tabs > div").length
        for(var t=0;t<tabs;t++)
        {
        	var tabId=tabsH.eq(t).attr('id')
            var jsonStr='{"tabID":"'+tabId+'","tabh":"'+tabsH.eq(t).attr('title')+'","tabi":"'+t+'","tabImg":"'+(tabsH.eq(t).attr('tabImg') ? tabsH.eq(t).attr('tabImg'):"images/tablist.png") +'","tabClose":"'+tabsH.eq(t).attr('closable')+'"}'
            tabsH.eq(t).attr("id",tabId+"iframe")
            tabsH.eq(t).html('<iframe width="100%" frameborder="0" style="height:'+(parseInt(document.documentElement.clientHeight)-168)+'px;"  scrolling="auto" src="'+(tabsH.eq(t).attr('href'))+'" id="iframe-'+tabId+'" name="iframe-'+tabId+'"></iframe>')
            jsonStr=$.parseJSON(jsonStr)
            lnTabs.push(jsonStr)
            }
        var ulModTag='<ul class="Js_lnTab ln_tablist clearfix">'
        for(var tt=0;tt<lnTabs.length;tt++)
        {
            ulModTag+='<li id="'+lnTabs[tt].tabID+'-head" class="ln_tabitem"><a href="javascript:void(0)" hidefocus="true" id="'+lnTabs[tt].tabID+'" class="'+(lnTabs[tt].tabClose=="true"? " ":"staylink")+'" ><span class="lntab-icon"><img src="'+lnTabs[tt].tabImg+'" /></span>'+lnTabs[tt].tabh+'</a><span class="close '+(lnTabs[tt].tabClose=="true"? " ":"hide")+'"></span><span class="tab_r"></span></li>'
        }
        ulModTag+='</ul>'   
        $(".lnui-tabs").prepend(ulModTag)
        tabControlW()
        bindFun();
        //tab页签的右击事件
        tabConetxtMenu()
    })
    
    //add tab
    //id:
    //title:
    //url:
    //tabimg:
    function addTabCon(attributes){
    	var tab=$(".Js_lnTab > li");
    	var tabL=tab.length
    	//标记是否已经存在这样的标签
    	var isIn=false;
    	var isInTab=""
    	attributes.tabImg ? attributes.tabImg=attributes.tabImg : attributes.tabImg="common/images/icon/tablist.png";
    	var curLiTotalW=0
    	for(var t=0;t<tabL;t++)
    	{
    		if(tab.eq(t).text()==attributes.title)
    		{
    			isIn=true
    			isInTab=tab.eq(t)
    		}
    		curLiTotalW+=tab.eq(t).outerWidth(true)	
    	}
    	if(isIn)
    	{
    		//如果已经存在就重新刷新加载
    		var commonIframeId=$(isInTab).attr("id").split("-head")[0]
    		var iframeName="iframe-"+commonIframeId;
    		isInTab.click();
    		var iframeUrl=$("#"+iframeName).attr("src");
    		$("#"+iframeName).attr("src",iframeUrl)
    		//top.frames[iframeName].location.href=iframeUrl;
    		//top.frames[iframeName].location.reload();
    		$("#"+iframeName).load(function(){
    			var _this=$(this)
    			var  resoucre=$(_this[0].contentWindow.document.body).find("#Js_mainMod").find("iframe")
    			resoucre.attr("src",resoucre.data("resource"))
    			resizeIframe();
    		})
    	}
    	else
    	{
	    	if(testTabLen(attributes)==false)
	    	{
				addTabNow(attributes)
	    	}
	    	else
	    	{
	    		
	    	}
    	}
    	tabControlW() 
    	//tab页签的右击事件
        tabConetxtMenu()	
    }  
    //测试页签数量
    function testTabLen(attributes){
    	if($("#Js_LnTabCon").attr("size")){
    	var maxSize=$("#Js_LnTabCon").attr("size")
    	var hasSize=$("#Js_LnTabCon").find(".ln_tabitem").length;
		if(maxSize<=hasSize)
		{
	    	var clientW=document.documentElement.clientWidth;
	    	var clientH=document.documentElement.clientHeight; 
			var mainMarginTop=-Math.floor((parseInt(30*(Math.ceil(hasSize/2)))+60)/2) 
			var maskLayout='<div class="choice-mask" style="position:absolute; z-index:999; top:0px;left:0px; width:'+clientW+'px; height:'+clientH+'px;opacity:0.5;filter:Alpha(Opacity=50);background:#fff;"></div>'
			var choiceMainBox='<div class="choice-main-box" style="position:absolute; top:50%; left:50%; background:#fff; z-index:1000;margin-top:'+mainMarginTop+'px;"><div class="choice-main-hd">请选择需要关闭的项</div><ul class="choice-list">'
			for(var i=0;i<hasSize;i++){
				var disabled=(i==0 ? "disabled" :"");
				var liItem='<li class="choice-item" index="'+i+'"><input class="checkbox" type="checkbox" '+disabled+'  /><span>'+$("#Js_LnTabCon").find(".ln_tabitem").eq(i).text()+'</span></li>'
				choiceMainBox+=liItem;
			}
			//choiceMainBox+='</ul><div class="choice-main-fd"><a href="javascript:void(0)" id="Js_confrmCancel">取消</a><a id="Js_confrmYes" href="javascript:void(0)">确定</a></div></div>'
			
			choiceMainBox+='</ul><div class="choice-main-fd"><a hideFocus="true" href="javascript:void(0)" class="gray_radiu_btn" id="Js_confrmCancel" ><em class="gray_l"></em> <em class="gray_r"></em>取消</a><a hideFocus="true" href="javascript:void(0)" class="gray_radiu_btn" id="Js_confrmYes" ><em class="gray_l"></em> <em class="gray_r"></em>确认</a></div></div>';
			$("body").append(maskLayout)
			$("body").append(choiceMainBox)
			//注意数据的传递中间载体
			$(".choice-main-fd").data("curObj",attributes)
			//点击事件  取消  确定 
			//确定
			//注意这里只绑定一次点击事件后执行的事件
			$("#Js_confrmYes").live("click",function(e){
				//根据选择的页签  删除
				var input=$(".choice-item input:checkbox")
				var inputTotal=input.length;
				var selectedInput=$(".choice-item input:checkbox:checked")
				var checkItem=selectedInput.parents(".choice-item")
				if(selectedInput.length<=0){
					fh.alert("请选择要关闭的页签！");
					e.stopImmediatePropagation();
					return;
				}
				for(var i=0; i<selectedInput.length;i++){
					var tabIndex=checkItem.eq(i).attr("index")
					$(".Js_lnTab > li").eq(tabIndex).find(".close").click();
				}
				addTabNow($(".choice-main-fd").data("curObj"));
				//删除遮罩以及页面选项列表
				$(".choice-main-box").remove();
				$(".choice-mask").remove();
				e.stopImmediatePropagation()
				e.preventDefault();
				e.stopPropagation();								
			})
			//取消
			$("#Js_confrmCancel").live("click",function(e){
				//删除遮罩以及页面选项列表
				$(".choice-main-box").remove();
				$(".choice-mask").remove();
				e.stopImmediatePropagation()
				e.preventDefault();
				e.stopPropagation();			
			})			
		}
		else
		{
			return false;
		}
		}
		else
		{
			return false;
		}
    }
    //窗口resize的时候弹出窗 以及阴影的款高度要跟着改变
    $(window).resize(function(){
    	if($(".choice-mask").length>0){
	    	var clientW=document.documentElement.clientWidth;
	    	var clientH=document.documentElement.clientHeight; 
	    	$(".choice-mask").css({"width":clientW+"px","height":clientH+"px"})
    	}
    })
    //新增tab页签
    function addTabNow(attributes){
	    	var iframeH=$(".ui-layout-center").outerHeight(true)-$(".Js_lnTab").outerHeight(true)
	    	var tabHd='<li id="'+attributes.id+'-head" class="ln_tabitem"><a href="javascript:void(0)" hidefocus="true" id="'+attributes.id+'"><span class="lntab-icon"><img src="'+attributes.tabImg+'" /></span>'+attributes.title+'</a><span class="close '+(attributes.tabClose=="true"? " ":"hide")+'"></span><span class="tab_r"></span></li>'
	    	var tabBd='<div class="" id="'+attributes.id+'iframe" href="'+attributes.url+'"><iframe frameborder="0" style="height:'+(iframeH)+'px;" scrolling="auto" name="iframe-'+attributes.id+'" id="iframe-'+attributes.id+'" width="100%" src="'+attributes.url+'"></iframe></div>'
	    	$(".Js_lnTab").append(tabHd)
	    	$("#Js_LnTabCon").append(tabBd)
	    	$("#iframe-"+attributes.id).load(function(){
	    		var iframeH=$(this).height();
	    		/* 点击菜单，收起菜单
	    		if($($(this)[0].contentWindow.document.body).find("#Js_asideMod").length>0)
	    		{
	    			if($(this).parents("body").find(".ui-layout-west").is(":visible"))
	    			$(this).parents("body").find(".ui-layout-toggler-west").click();
	    		}*/
	    		$($(this)[0].contentWindow.document.body).find("#Js_spitBarMod").height(iframeH+"px")
	    		$($(this)[0].contentWindow.document.body).find("#Js_mainMod").height(iframeH+"px")
	    		$($(this)[0].contentWindow.document.body).find("#Js_mainMod").find("iframe").height(iframeH+"px")
	    		$($(this)[0].contentWindow.document.body).find("#Js_asideMod").height(iframeH+"px")
	    		$($(this)[0].contentWindow.document.body).find("#Js_asideMod").find("iframe").height(iframeH+"px")
	    		
	    		
	    		/*var mainIframe=$($(this)[0].contentWindow.document.body).find("#Js_mainMod").find("iframe")
	    		var sideIframe=$($(this)[0].contentWindow.document.body).find("#Js_asideMod").find("iframe")
	    		mainIframe.data("resource",mainIframe.attr("src"))
	    		sideIframe.data("resource",sideIframe.attr("src"))*/
	    	})
	    	bindFun($(tabHd));
    }
    //绑定事件
    function bindFun()
    {
			var args=arguments
		    $(".Js_lnTab > li").each(function(index){
	        var _this=$(this)
	        if(args.length>0)
	        {
	        	$(".Js_lnTab > li:last").addClass("current").siblings("li").removeClass("current");
	        	$("#Js_LnTabCon > div:last").show().siblings("div").hide();
	        }
	        else
	        {
	        	$(".Js_lnTab > li").eq(0).addClass("current").siblings("li").removeClass("current");
	        	$("#Js_LnTabCon > div:first").show().siblings("div").hide();
	        }
	        _this.live("click",function(e){
	        _this.addClass("current").siblings("li").removeClass("current");
	        var _thisIndex=$(".Js_lnTab > li").index(_this)
	        $("#Js_LnTabCon > div").eq(_thisIndex).show().siblings("div").hide();
	        //alert($("#Js_LnTabCon > div").eq(_thisIndex).find("iframe").contents().find("#Js_asideMod").length)
	        
	        /* 点击带Tree的Tab自动关闭菜单menus
        	if($("#Js_LnTabCon > div").eq(_thisIndex).find("iframe").contents().find("#Js_asideMod").length>0)
    		{
    			if(_this.parents("body").find(".ui-layout-west").is(":visible"))
    			   _this.parents("body").find(".ui-layout-toggler-west").click();
    		}else{
    			if(_this.parents("body").find(".ui-layout-west").is(":hidden"))
    			   _this.parents("body").find(".ui-layout-toggler-west").click();
    		}*/
	        
	        e.stopImmediatePropagation();
	        })
	        _this.hover(function(){
	        _this.addClass("hover").siblings("li").removeClass("hover")
	        },function(){_this.removeClass("hover")})
	    })
      
      //close
		bindCloseClick();
    }
	function bindCloseClick(){
      $(".ln_tabitem").each(function(){
      //注意 关闭后要重新计算当前li的索引
      	$(this).find(".close").live("click",function(e){
       	var _this=$(this)
       	var _thisTab=_this.parent(".ln_tabitem").attr("id")
       	var isCur=_this.parent(".ln_tabitem").hasClass("current")
       	var _curIndex=$(".Js_lnTab > li").index(_this.parent(".ln_tabitem"))
   		//聚焦上一个    	
   		$("#"+_thisTab.split("-head")[0]+"iframe").remove();
   		$("#"+_thisTab).remove();
   		isCur ? $(".Js_lnTab > li").eq(_curIndex-1).click() : "";   
   		tabControlW();
   		e.stopImmediatePropagation();
      	})
      }) 
	}
    //resize Height
    function resizeIframe(){
    	var resizeH=$(".ui-layout-center").outerHeight(true)-$(".Js_lnTab").outerHeight(true)
    	$("iframe").not("iframe[id^='lhgfrm_']").each(function(){
    		var _this=$(this)
			_this.height(resizeH)
			var _thisConWin=$(_this[0].contentWindow.document.body)
			if(_thisConWin.find("#Js_spitBarMod").length>0 && _thisConWin.find("#Js_mainMod").length>0 && _thisConWin.find("#Js_asideMod").length>0 )
			{
				_thisConWin.find("#Js_spitBarMod").height(resizeH)
				_thisConWin.find("#Js_mainMod").height(resizeH)
				_thisConWin.find("#Js_mainMod").find("iframe").height(resizeH)
				_thisConWin.find("#Js_asideMod").height(resizeH)
				_thisConWin.find("#Js_asideMod").find("iframe").height(resizeH)
			}
    	})
        //改变窗口的大小高度值
           if($("#lhgdlg_showimg").length>0){
               var w=$(window.top).outerWidth(true);
               var h=$(window.top).outerHeight(true);
               var b = $("#lhgdg_drag_showimg")[0].offsetHeight;
               var c = $(".optbox",$("#lhgdlg_showimg").find("#lhgfrm_showimg")[0].contentWindow.document).outerHeight(true);
 			   var e = h - b;
 			   var d = e - c;
 			   $("#lhgdlg_showimg").css({"height":h,"width":w,"left":"0"})
               $("#lhgdlg_showimg").find("#lhgfrm_showimg").css({"height":e,"width":w})
               $("#lhgdg_content_showimg").css("height",e);
               $(".view_img",$("#lhgdlg_showimg").find("#lhgfrm_showimg")[0].contentWindow.document).css({"height":d,"width":w})
           }    	
    }
    //动态计算宽度 判断显示与隐藏控制按钮
    function tabControlW(){
    	var wrapW=($("#Js_LnTabCon").outerWidth(true))
        var tabLi=$(".Js_lnTab > li");
        var tabLiL=tabLi.length;
        var tabLiWrapW=0;
    	for(var li=0;li<tabLiL;li++)
    	{
    		tabLiWrapW+=tabLi.eq(li).outerWidth(true)+5
    	}
    	$(".Js_lnTab").data("totalW",tabLiWrapW);	
    	var tabWrapW=$("#Js_LnTabCon").outerWidth(true)
    	if($(".Js_lnTab").data("totalW")>=tabWrapW)
    	{
			$(".Js_lnTab").width($(".Js_lnTab").data("totalW"))
			$("#Js_Tabpre,#Js_Tabnext").show();
		}
		else
		{
			$(".Js_lnTab").css("width","auto");
			$("#Js_Tabpre,#Js_Tabnext").hide();
		} 
		//定位到tab标签显示的位置（点击左侧标签的时候）
    	setFixedMenu();   	
    }
   showHideTab();
   
   //tab控制左右滚动的两个标签的点击事件
    function showHideTab()
    {
    	//向前滑动展示
    	$("#Js_Tabpre").live("click",function(){
    		var marginL=$(".Js_lnTab").css("marginLeft").slice(0,-2)
    		if(marginL>=0)
    		{
    		 $(".Js_lnTab").animate({
    				"margin-left":"20px"
    			},500)
    		return;}
    		else
    		{
    			$(".Js_lnTab").animate({
    				"margin-left":parseInt(marginL)+100+"px"
    			},500)
    		}
    	})
    	//向后滑动展示
    	$("#Js_Tabnext").live("click",function(){
     		var marginL=$(".Js_lnTab").css("marginLeft").slice(0,-2)
     		var lastReg=$(".Js_lnTab > li:last").offset().left+$(".Js_lnTab > li:last > a").outerWidth(true)
     		var slideReg=$(this).offset().left
     		if(slideReg-lastReg<0)
     		{
    			$(".Js_lnTab").animate({
    				"margin-left":parseInt(marginL)-100+"px"
    			},500) 		
    		}
    		else
    		return;
    	})
    }
    //定位到tab标签显示的位置（点击左侧标签的时候）
    function setFixedMenu(){
    	var totalW=$(".Js_lnTab").data("totalW")
    	var boxW=$("#Js_LnTabCon").outerWidth(true)
    	var curLiPosition=$(".Js_lnTab > li.current").length>0 ?$(".Js_lnTab > li.current").offset().left : 0;
    	//点击添加tab对象不存在的时候动态添加tab后计算
    	if(totalW>boxW)
    	{
    		$(".Js_lnTab").css("marginLeft",(boxW-totalW)+"px")
    	}
    	//点击的对象以及存在时执行
    	if(curLiPosition<boxW)
    	{
    		if($(".Js_lnTab").css("marginLeft")=="0px")
    		{
				return;
            }
    		else{
		    	$(".Js_lnTab").animate({
		    	"margin-left":"0px"
		    	},0)
	    	}
    	}	
    }    
    //TAb页签的右击事件
    function tabConetxtMenu(){
    	$(".Js_lnTab > li").each(function(index){
    		var _this=$(this)
    		_this.live("contextmenu",function(e){
    			var curIndexTab=($(".Js_lnTab > li").index(_this))
    			$("#Js_tabContextMenu").css({
    				left:e.clientX,
    				top:e.clientY
    			}).show().hover(function(){},function(){$(this).hide()}).data("curIndex",curIndexTab);
    			e.stopImmediatePropagation();
    			return false;
    		})
    	})
    }
    //刷新当前页
    $("#Js_refreshCur").click(function(){
    	//获取当前页面容器索引
    	var conIndex=$("#Js_tabContextMenu").data("curIndex")
    	var name=$("#Js_LnTabCon > div").eq(conIndex).find("iframe").attr("name")
    	//$("#"+name).css("height","800px")
    	//刷新iframe内容页面
    	//var freshUrl=$("#"+name).attr("src")
    	//top.frames[name].location.href=freshUrl
    	top.frames[name].location.reload()
    	$("#"+name).load(function(){
    		var _this=$(this)
	    	resizeIframe();
	    	/*var  resoucre=$(_this[0].contentWindow.document.body).find("#Js_mainMod").find("iframe")
	    	console.log(resoucre.attr("src"))*/
    	})

    	return false;
    })
    //关闭当前页
    $("#Js_closeCur").click(function(){
       var tabIndx=$("#Js_tabContextMenu").data("curIndex")
      if(tabIndx==0)
      {
      	alert("首页不能关闭！");
      	return false;
      }
       if($(".Js_lnTab > li").eq(tabIndx).hasClass("current"))
      {
      	$(".Js_lnTab > li").eq(tabIndx-1).click();
      }       
      $(".Js_lnTab > li").eq(tabIndx).remove();
      $("#Js_LnTabCon > div").eq(tabIndx).remove();
      	tabControlW(); 
    	return false;
    })
    //关闭其他页
    $("#Js_closeOther").click(function(){
    	var tabIndx=$("#Js_tabContextMenu").data("curIndex")
    	$(".Js_lnTab > li").not($(".Js_lnTab > li").eq(tabIndx)).not($(".Js_lnTab > li:first")).remove();
    	$("#Js_LnTabCon > div").not($("#Js_LnTabCon > div").eq(tabIndx)).not($("#Js_LnTabCon > div:first")).remove();
    	tabControlW(); 
    	return false;
    })
    //关闭所有页
    $("#Js_closeAll").click(function(){
    	$(".Js_lnTab > li").not($(".Js_lnTab > li:first")).remove();
    	$("#Js_LnTabCon > div").not($("#Js_LnTabCon > div:first")).remove();
    	$(".Js_lnTab > li:first").click();
    	$("#Js_LnTabCon > div:first").show();
    	tabControlW(); 
    	return false;
    })
    

    //页面加载进度条
    function loadingWait(){
    	var clientW=document.documentElement.clientWidth;
    	var clientH=document.documentElement.clientHeight;    
    	var loadMask='<div class="loading-mask" style="position:absolute;top:0px; left:0px;z-index:100000; background:#fff;width:'+clientW+'px;height:'+clientH+'px;"></div><div class="loading-content" style="position:absolute;top:50%; left:50%;z-index:100001; background:#fff;border:3px solid #4588BA; padding:10px; margin-left:-60px;margin-top:-20px; font-size:14px; font-weight:blod;">页面正在加载中....</div>'
		$("body").append(loadMask)
		var loading=setInterval(function(){
			$(".loading-mask").css(
				{
					"width":$(".loading-mask").width()*0.9,
					"height":$(".loading-mask").height()*0.9,
					"top":"50%",
					"left":"50%",
					"marginLeft":Math.floor(-($(".loading-mask").width()*0.9)/2)+"px",
					"marginTop":Math.floor(-($(".loading-mask").height()*0.9)/2)+"px"
				})
			if($(".loading-mask").width()<=$(".loading-content").width())
			{
				clearInterval(loading)
				$(".loading-mask").remove();
				$(".loading-content").remove();
			}
		},30)
    }
    loadingWait();
    
    
     //上下结构的menu
    //Load mulit menu
function LoadMuliMenu(path,menucount,array){
		for(var menu=0;menu<menucount;menu++)
		{
			$("#div_"+(menu+1)).createMuliMenu(array[menu])
			
		}
	}
	
	
//创建连级菜单
$.fn.createMuliMenu=function(arrayobj){
		var urlDom=[]	
		var topDom='<span class="help_p"></span><ul>'
		for(var d=0;d<arrayobj.length;d++)
		{
			if(arrayobj[d].pid==-1)
			{
				urlDom.push(arrayobj[d])
				topDom+='<li><a href="'+arrayobj[d].url+'" id="'+arrayobj[d].id+'">'+arrayobj[d].text+'</a>'
				topDom=getChildObj(arrayobj[d],arrayobj,topDom)
			}
		}
			topDom+='</ul>'
			$(this.selector).append(topDom)
	}
function getChildObj(parentidobj,obj,topDom){
			var childDom=[]
			for(var gc=0;gc<obj.length;gc++)
			{
				if(obj[gc].pid==parentidobj.id)
				childDom.push(obj[gc])
			}
			if(childDom.length>0)
			{
				topDom+='<div><span class="help_p"></span>'
				topDom+='<ul>'
				for(var cd=0;cd<childDom.length;cd++)
				{
					topDom+='<li><a href="'+childDom[cd].url+'">'+childDom[cd].text+'</a>'
					topDom=getChildObj(childDom[cd],obj,topDom)
				}
				topDom+='</ul></div></li>'
				return topDom
			}
			
			else{
					topDom+='</li>'
					return topDom;
				}
		}
    
    