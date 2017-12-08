// / <reference path="../intellisense/jquery-1.2.6-vsdoc-cn.js" />
/*******************************************************************************
 * data:[{ id:1, //ID只能包含英文数字下划线中划线 text:"node 1", value:"1", showcheck:false,
 * checkstate:0, //0,1,2 hasChildren:true, isexpand:false, complete:false,
 * 是否已加载子节点 ChildNodes:[] // child nodes }, .......... ]
 * author:xuanye.wan@gmail.com
 ******************************************************************************/

/**
 * description：  按照指定规则寻找字符串是否存在(字符串规则,x,y,z,)
 * date：   		 2012年8月28日13:17:03
 * author：		 yuhz
 */
String.prototype.findStr = function(key)
{
	return this.indexOf(","+key+",");
}
 
/**
 * description：  按照指定规则移除相关cookie字符串中内容(字符串规则,x,y,z,)
 * date：   		 2012年8月28日13:17:03
 * author：		 yuhz
 */
String.prototype.removeStr = function(key)
{
	return this.replace(new RegExp(","+key+",","gm"),","); 
}

function checkContextMenu(e){
    var et = e.target || e.srcElement;
    if (et.tagName == "IMG") {
        return false;
    }
    return true;
}

function init(){}

(function($) {
    $.fn.swapClass = function(c1, c2) {
        return this.removeClass(c1).addClass(c2);
    };
    $.fn.switchClass = function(c1, c2) {
        if (this.hasClass(c1)) {
            return this.swapClass(c1, c2);
        }
        else {
            return this.swapClass(c2, c1);
        }
    };
    $.fn.treeview = function(settings) {
        var dfop =
            {
                method: "POST",
                datatype: "json",
                url: false,
                cbiconpath: "tree/images/icons/",// 图片路径
                icons: ["checkbox_0.gif", "checkbox_1.gif", "checkbox_2.gif"],// 多选图片
                radioIcons:["radio_0.gif", "radio_1.gif"],// 单选图片
                showcheck: false, // 是否显示多选
                showradio: false, // 是否显示单选
                oncheckboxclick: false, // 当checkstate状态变化时所触发的事件，但是不会触发因级联选择而引起的变化
                onaftercheckboxclick: false, // 当checkstate状态变化时所触发的事件，当触发因级联选择而引起的变化后执行
                onnodeclick: false,// 节点单击事件
                onnodedblclick: false,// 节点双击事件
                cascadecheck: true,// 节点选中时级联选中父节点和子节点
                parentCascadecheck: true,// 节点选中时向父节点回溯
                cancleNoCascade: true,
                cookieName:"",			//默认Cookie缓存名称，注意，在同一套系统中该名称不能重复（建议：模块名称+页面名称作为缓存名称），如果为空则不启用cookie
                data: null,// 待加载数据
                // clicktoggle: true, //点击节点展开和收缩子节点
                theme: "bbit-tree-arrows", // bbit-tree-lines
                                           // ,bbit-tree-no-lines,bbit-tree-arrows
                aHasSelected: "",// 已经选中的节点项id值
                aNeedLazy: false,// 该树是否延迟加载
                contextMenu: false,// 该树是否显示右键菜单
                title: '组织机构',// 树标题
                isShowBase:false,// 是否显示根节点
                displayDeep: false,// 要显示的级别,默认为false
                rootIcon:""
            };
        $.extend(dfop, settings);
        if(dfop.aHasSelected=="")
        {
        	var tempData = dfop.data;
        	var s = "";
        	for(var i=0;i<tempData.length;i++)
        	{
        		if(tempData[i].checkstate == 1 || tempData[i].checkstate == 2)
        		{
        			s = s+ tempData[i].id + ",";
        		}
        	}
       		if(s != "")
       		{
       			dfop.aHasSelected = "," + s;
       		}
        }
        dfop.data = initTreeData(dfop.data);// 初始化数据
        var treenodes = dfop.data;
        var me = $(this);
        var id = me.attr("id");
        if (id == null || id == "") {
            id = "bbtree" + new Date().getTime();
            me.attr("id", id);
        }

        // 预加载图片
        if (dfop.showcheck) {// 加载复选框图片
            for (var i = 0; i < 3; i++) {
                var im = new Image();
                im.src = dfop.cbiconpath + dfop.icons[i];
            }
        }
        if(dfop.showradio){// 加载单选框图片
            for(var i=0; i<2; i++){
                var im = new Image();
                im.src = dfop.cbiconpath + dfop.radioIcons[i];
            }
        }
        
        /**
         * 根据传入的数据进行父子节点的匹配（顶级节点的父节点默认为“-1”）
         * 
         * @param data
         *            树型数据
         * @return data 父子节点匹配好的树型数据
         */
        function initTreeData(data) {
            var orderedData = [];
            if(data && data.length > 0){
                var l = data.length;
                for(var i=0; i<l; i++){
                    orderedData['' + data[i].id] = i;
                }
                var pid;
                for(var i=0; i<l; i++){
                    pid = data[i].pid;
                    if(pid != '-1'){
                        data[i].parent = data[orderedData['' + pid]];// 设置父节点
                        try{
                            data[orderedData['' + pid]].ChildNodes.push(data[i]);
                            data[orderedData['' + pid]].hasChildren = true;
                        }catch(e){
                            
                        }
                    }
                }
                orderedData.length = 0;
                for(var i=0; i<l; i++){
                    pid = data[i].pid;
                    if(pid == '-1'){
                        orderedData.push(data[i]);
                    }
                }
            }
            return orderedData;
        }
        
        
        // region
        function buildtree(data, ht) {
            ht.push("<div class='bbit-tree-bwrap'>"); // Wrap ;
            ht.push("<div class='bbit-tree-body'>"); // body ;
            ht.push("<ul class='bbit-tree-root ", dfop.theme, "'>"); // root
            if(dfop.isShowBase){
                ht.push("<li class='bbit-tree-node-root'>");
                ht.push("<div unselectable='on'");
                ht.push("<span class='bbit-tree-node-indent'>");
                ht.push("</span>");
                ht.push("<img class='bbit-tree-ec-icon", "' src='" + dfop.cbiconpath);
                if(dfop.rootIcon){
                    ht.push(dfop.rootIcon+"'/>");
                }else{
                    ht.push("base.gif'/>");
                }
                ht.push("<a hideFocus class='bbit-tree-node-anchor' tabIndex=1  style='cursor: pointer' >");
                ht.push("<span unselectable='on' type='title'>", dfop.title, "</span>");
                ht.push("</a>");
                ht.push("</div>");
                ht.push("</li>");
            }
            if (data && data.length > 0) {
                var l = data.length;
                for (var i = 0; i < l; i++) {
                    buildnode(data[i], ht, 0, i, i == l - 1);
                }
            }
            else {
                asnyloadc(null, false, function(data) {
                    if (data && data.length > 0) {
                        treenodes = data;
                        dfop.data = data;
                        var l = data.length;
                        for (var i = 0; i < l; i++) {
                            buildnode(data[i], ht, 0, i, i == l - 1);
                        }
                    }
                });
            }
            ht.push("</ul>"); // root and;
            ht.push("</div>"); // body end;
            ht.push("</div>"); // Wrap end;
        }
        // endregion
        /**
        function buildnode(nd, ht, deep, path, isend) {
            if(dfop.displayDeep && deep >= dfop.displayDeep){// 如果设置了要显示到第几级并且deep已经超过该级别
                return false;
            }
            var nid = nd.id.replace(/[^\w]/gi, "_");
            ht.push("<li class='bbit-tree-node'>");
            ht.push("<div id='", id, "_", nid, "' tpath='", path, "' unselectable='on' title='", nd.text, "'");
            var cs = [];
            cs.push("bbit-tree-node-el");
            if (nd.hasChildren && (!dfop.displayDeep || deep < dfop.displayDeep - 1)) {// 增加显示级别限制
                cs.push(nd.isexpand ? "bbit-tree-node-expanded" : "bbit-tree-node-collapsed");
            }
            else {
                cs.push("bbit-tree-node-leaf");
            }
            if (nd.classes) { cs.push(nd.classes); }

            ht.push(" class='", cs.join(" "), "'>");
            // span indent
            ht.push("<span class='bbit-tree-node-indent'>");
            if(deep == 0){// 如果当前节点是最外层节点，则记录该节点子节点是否需要展现deepline
                if(isend){// 如果该节点是最后一个节点，则不需要使用deepline
                    nd.deepline = "0";
                }else{
                    nd.deepline = "1";
                }
            }else if(deep > 0){
                var parentDeepline = nd.parent.deepline;
                var deeplineLength = parentDeepline.length;
                var singleDeepline;
                for(var i=0; i<deeplineLength; i++){
                    singleDeepline = parentDeepline.substring(i, i+1);
                    if(singleDeepline == "0"){
                        ht.push("<img class='bbit-tree-icon' src='" + dfop.cbiconpath + "s.gif'/>");
                    }else if(singleDeepline == "1"){
                        ht.push("<img class='bbit-tree-elbow-line' src='" + dfop.cbiconpath + "s.gif'/>");
                    }
                }
                // 记录节点deepline信息
                if(isend){
                    nd.deepline = parentDeepline + "0";
                }else{
                    nd.deepline = parentDeepline + "1";
                }
            }

            ht.push("</span>");
            // img
            cs.length = 0;
            if (nd.hasChildren && (!dfop.displayDeep || deep < dfop.displayDeep - 1)) {// 增加显示级别限制
                if (nd.isexpand) {
                    cs.push(isend ? "bbit-tree-elbow-end-minus" : "bbit-tree-elbow-minus");
                }
                else {
                    cs.push(isend ? "bbit-tree-elbow-end-plus" : "bbit-tree-elbow-plus");
                }
            }
            else {
                cs.push(isend ? "bbit-tree-elbow-end" : "bbit-tree-elbow");
            }
            ht.push("<img class='bbit-tree-ec-icon ", cs.join(" "), "' src='" + dfop.cbiconpath + "s.gif'/>");
            
            if(nd.imgPath && nd.imgPath.length > 0){// 设置了节点自定义图片
                ht.push("<img class='bbit-tree-node-icon' style='background-image:url(", nd.imgPath, ");' src='" + dfop.cbiconpath + "s.gif'/>");
            }else{// 使用默认节点图片
                ht.push("<img class='bbit-tree-node-icon' src='" + dfop.cbiconpath + "s.gif'/>");
            }
            
            // radio
            if(dfop.showradio && nd.showcheck){
                if(nd.checkstate == null || nd.checkstate == undefined){
                    nd.checkstate = 0;
                }else if(nd.checkstate != 0){
                    nd.checkstate = 1;
                }
                ht.push("<img  id='", id, "_", nid, "_cb' class='bbit-tree-node-ra' src='", dfop.cbiconpath, dfop.radioIcons[nd.checkstate], "'/>");
            }
            // checkbox
            if (dfop.showcheck && nd.showcheck) {
                if (nd.checkstate == null || nd.checkstate == undefined) {
                    nd.checkstate = 0;
                }
                //else if(nd.checkstate!=0){
                //    nd.checkstate = 1 ;
                //}
                ht.push("<img  id='", id, "_", nid, "_cb' class='bbit-tree-node-cb' src='", dfop.cbiconpath, dfop.icons[nd.checkstate], "'/>");
            }
            // a
            ht.push("<a hideFocus class='bbit-tree-node-anchor' tabIndex=1 style='cursor: pointer'>");
            ht.push("<span type='node' unselectable='on' id='"+nd.id+"' spanType='"+nd.value+"' pid='"+nd.pid+"' code='"+nd.code+"'>");
            ht.push(nd.text);
            if( nd.icon){
            	for(var i = 0 ; i<nd.icon.length;i++){
            	   //title=''
            	   ht.push("&nbsp;<img style='vertical-align: bottom;'  src='" + nd.icon[i].icon + "' title='" + nd.icon[i].title + "'/>");
            	}
            }
            ht.push("</span>");
            ht.push("</a>");
            ht.push("</div>");
            // Child
            if (nd.hasChildren && (!dfop.displayDeep || deep < dfop.displayDeep - 1)) {// 增加显示级别限制
                if (nd.isexpand) {
                    ht.push("<ul  class='bbit-tree-node-ct'  style='z-index: 0; position: static; visibility: visible; top: auto; left: auto;'>");
                    if (nd.ChildNodes) {
                        var l = nd.ChildNodes.length;
                        for (var k = 0; k < l; k++) {
                            nd.ChildNodes[k].parent = nd;
                            buildnode(nd.ChildNodes[k], ht, deep + 1, path + "." + k, k == l - 1);
                        }
                    }
                    ht.push("</ul>");
                }
                else {
                    ht.push("<ul style='display:none;'></ul>");
                }
            }
            ht.push("</li>");
            nd.render = true;
        }*/
        
        function buildnode(nd, ht, deep, path, isend) {
        	var expand = false; //2012-8-28 yuhongzhou added
            if(dfop.displayDeep && deep >= dfop.displayDeep){// 如果设置了要显示到第几级并且deep已经超过该级别
                return false;
            }
            var nid = nd.id.replace(/[^\w]/gi, "_");
            ht.push("<li class='bbit-tree-node'>");
            ht.push("<div id='", id, "_", nid, "' tpath='", path, "' unselectable='on' title='", nd.text, "'");
            var cs = [];
            cs.push("bbit-tree-node-el");
            if (nd.hasChildren && (!dfop.displayDeep || deep < dfop.displayDeep - 1)) {// 增加显示级别限制
            	//---------------------------------------
            	//2012-8-28 yuhongzhou added
            	var expandSign = "bbit-tree-node-collapsed";
            	if(nd.isExpand)
            	{
            		expandSign = "bbit-tree-node-expanded";
            		expand = true;
            	}
            	else
            	{
            		if(dfop.cookieName != ""){
	            		try{
	            			var cookieStr = "";
	            			cookieStr = Cookie.read(dfop.cookieName);
	            			if(cookieStr.findStr(nd.id) != -1)
	            			{
	            				expandSign = "bbit-tree-node-expanded";
	            				expand = true;
	            			}
	            		}catch(e)
	            		{
	            			alert(e);
	            		}
	            	}
            	}
            	cs.push(expandSign);
            	//---------------------------------------
                //cs.push(nd.isexpand ? "bbit-tree-node-expanded" : "bbit-tree-node-collapsed");
            }
            else {
                cs.push("bbit-tree-node-leaf");
            }
            if (nd.classes) { cs.push(nd.classes); }

            ht.push(" class='", cs.join(" "), "'>");
            // span indent
            ht.push("<span class='bbit-tree-node-indent'>");
            if(deep == 0){// 如果当前节点是最外层节点，则记录该节点子节点是否需要展现deepline
                if(isend){// 如果该节点是最后一个节点，则不需要使用deepline
                    nd.deepline = "0";
                }else{
                    nd.deepline = "1";
                }
            }else if(deep > 0){
                var parentDeepline = nd.parent.deepline;
                var deeplineLength = parentDeepline.length;
                var singleDeepline;
                for(var i=0; i<deeplineLength; i++){
                    singleDeepline = parentDeepline.substring(i, i+1);
                    if(singleDeepline == "0"){
                        ht.push("<img class='bbit-tree-icon' src='" + dfop.cbiconpath + "s.gif'/>");
                    }else if(singleDeepline == "1"){
                        ht.push("<img class='bbit-tree-elbow-line' src='" + dfop.cbiconpath + "s.gif'/>");
                    }
                }
                // 记录节点deepline信息
                if(isend){
                    nd.deepline = parentDeepline + "0";
                }else{
                    nd.deepline = parentDeepline + "1";
                }
            }

            ht.push("</span>");
            // img
            cs.length = 0;
            if (nd.hasChildren && (!dfop.displayDeep || deep < dfop.displayDeep - 1)) {// 增加显示级别限制
                //if (nd.isexpand) { 
                if(expand){ //2012-8-28 yuhongzhou added
                    cs.push(isend ? "bbit-tree-elbow-end-minus" : "bbit-tree-elbow-minus");
                }
                else {
                    cs.push(isend ? "bbit-tree-elbow-end-plus" : "bbit-tree-elbow-plus");
                }
            }
            else {
                cs.push(isend ? "bbit-tree-elbow-end" : "bbit-tree-elbow");
            }
            ht.push("<img class='bbit-tree-ec-icon ", cs.join(" "), "' src='" + dfop.cbiconpath + "s.gif'/>");
            
            if(nd.imgPath && nd.imgPath.length > 0){// 设置了节点自定义图片
                ht.push("<img class='bbit-tree-node-icon' style='background-image:url(", nd.imgPath, ");' src='" + dfop.cbiconpath + "s.gif'/>");
            }else{// 使用默认节点图片
                ht.push("<img class='bbit-tree-node-icon' src='" + dfop.cbiconpath + "s.gif'/>");
            }
            
            // radio
            if(dfop.showradio && nd.showcheck){
                if(nd.checkstate == null || nd.checkstate == undefined){
                    nd.checkstate = 0;
                }else if(nd.checkstate != 0){
                    nd.checkstate = 1;
                }
                ht.push("<img  id='", id, "_", nid, "_cb' class='bbit-tree-node-ra' src='", dfop.cbiconpath, dfop.radioIcons[nd.checkstate], "'/>");
            }
            // checkbox
            if (dfop.showcheck && nd.showcheck) {
                if (nd.checkstate == null || nd.checkstate == undefined) {
                    nd.checkstate = 0;
                }
                /**else if(nd.checkstate!=0){
                    nd.checkstate = 1 ;
                }*/
                ht.push("<img  id='", id, "_", nid, "_cb' class='bbit-tree-node-cb' src='", dfop.cbiconpath, dfop.icons[nd.checkstate], "'/>");
            }
            // a
            ht.push("<a hideFocus class='bbit-tree-node-anchor' tabIndex=1 style='cursor: pointer'>");
            ht.push("<span type='node' unselectable='on' id='"+nd.id+"' spanType='"+nd.value+"' pid='"+nd.pid+"' code='"+nd.code+"' id2='"+nd.id2+"'>");
            ht.push(nd.text);
            if( nd.icon){
            	for(var i = 0 ; i<nd.icon.length;i++){
            	   //title=''
            	   ht.push("&nbsp;<img style='vertical-align: bottom;'  src='" + nd.icon[i].icon + "' title='" + nd.icon[i].title + "'/>");
            	}
            }
            ht.push("</span>");
            ht.push("</a>");
            ht.push("</div>");
            // Child
            if (nd.hasChildren && (!dfop.displayDeep || deep < dfop.displayDeep - 1)) {// 增加显示级别限制
                //if (nd.isexpand) {
                if(expand){ //2012-8-28 yuhongzhou added
                    ht.push("<ul  class='bbit-tree-node-ct'  style='z-index: 0; position: static; visibility: visible; top: auto; left: auto;'>");
                    if (nd.ChildNodes) {
                        var l = nd.ChildNodes.length;
                        for (var k = 0; k < l; k++) {
                            nd.ChildNodes[k].parent = nd;
                            buildnode(nd.ChildNodes[k], ht, deep + 1, path + "." + k, k == l - 1);
                        }
                    }
                    ht.push("</ul>");
                }
                else {
                    ht.push("<ul style='display:none;'></ul>");
                }
            }
            ht.push("</li>");
            nd.render = true;
        }
        
        function getItem(path) {
            var ap = path.split(".");
            var t = treenodes;
            for (var i = 0; i < ap.length; i++) {
                if (i == 0) {
                    t = t[ap[i]];
                }
                else {
                    t = t.ChildNodes[ap[i]];
                }
            }
            return t;
        }
        
        /**
         * 点击单选框时节点选中事件
         * 
         * @param item
         *            -树节点
         * @param state
         *            -树节点选中状态，在单选情况下一直是1
         */
        function checkRadio(item, state){
            var nid;
            var et;
            if(dfop.ritem){// 已经存在选择了的节点
                if(dfop.ritem.id != item.id){// 已经选择的节点不是本节点
                    dfop.ritem.checkstate = 0;
                    nid = dfop.ritem.id.replace(/[^\w]/gi, "_");
                    et = $("#" + id + "_" + nid + "_cb");
                    if (et.length == 1) {
                        et.attr("src", dfop.cbiconpath + dfop.radioIcons[dfop.ritem.checkstate]);
                    }
                }
            }
            dfop.ritem = item;// 更新最后一个选中节点为当前节点
            dfop.ritem.checkstate = state;
            nid = dfop.ritem.id.replace(/[^\w]/gi, "_");
            et = $("#" + id + "_" + nid + "_cb");
            if (et.length == 1) {
                et.attr("src", dfop.cbiconpath + dfop.radioIcons[dfop.ritem.checkstate]);
            }
        }
        
        /**
         * 区分当前选中节点的半选和全选状态，使用情况： 1.当树节点选中不需要进行回溯和遍历时，该节点视子节点是否全部选中来决定是否使用半选状态
         * 2.当树节点初始化时，该节点视子节点是否全部选中来决定是否使用半选状态
         * 3.当item为父级节点并且当前节点的选中状态为0时，则item为半选状态
         * 
         * @param item
         *            -树节点
         * @param state
         *            -选择状态
         * @param type
         *            -选择类型：1.item为当前选中节点 0.item为父级节点
         * @return
         */
        function check2(item, state, type) {
            var pstate = item.checkstate;
            var state2 = state;
            if (state == 1 && item.ChildNodes){// 若某个节点下面有子节点并展开，则根据子节点是否全部选中来确定是半选状态还是全选状态
                var cs = item.ChildNodes;
                var l = cs.length;
                var ch = true;
                for (var i = 0; i < l; i++) {
                    if (state == 1 && cs[i].checkstate != 1) {
                        ch = false;
                        break;
                    }
                }
                if(!ch){
                    state2 = 2;
                }
            }else if(state != 0 && item.hasChildren){// 若某个节点下面有子节点但又没有展开，则选中该节点时为半选状态
                state2 = 2;
            }
            if(type == 0 && pstate != 0 && state == 0){// 当item为父级节点并且当前节点的选择状态为0时，则item为半选状态
                state2 = 2;
            }
            
            item.checkstate = state2;
            if (item.render && pstate != item.checkstate) {
                var nid = item.id.replace(/[^\w]/gi, "_");
                var et = $("#" + id + "_" + nid + "_cb");
                if (et.length == 1) {
                    et.attr("src", dfop.cbiconpath + dfop.icons[item.checkstate]);
                }
            }
        }
        
        /**
         * 树节点向上回溯，直到父级节点未被选中且该树不允许向上回溯时取消回溯
         * 
         * @param fn
         *            -选中处理函数
         * @param item
         *            -树节点
         * @param args
         *            -选中状态
         * @return
         */
        function bubble2(fn, item, args) {
            var p = item.parent;
            while (p) {
                if((p.checkstate == 0 && !dfop.parentCascadecheck) || fn(p, args, 0) === false){
                    break;
                }
                p = p.parent;
            }
        }
        
        function check(item, state, type) {
            var pstate = item.checkstate;
            if (type == 1) {
                item.checkstate = state;
            }
            else {// 上溯
                var cs = item.ChildNodes;
                var l = cs.length;
                var ch = true;
                for (var i = 0; i < l; i++) {
                    if ((state == 1 && cs[i].checkstate != 1) || state == 0 && cs[i].checkstate != 0) {
                        ch = false;
                        break;
                    }
                }
                if (ch) {
                    item.checkstate = state;
                }
                else {
                    item.checkstate = 2;
                }
            }
            // change show
            if (item.render && pstate != item.checkstate) {
                var nid = item.id.replace(/[^\w]/gi, "_");
                var et = $("#" + id + "_" + nid + "_cb");
                if (et.length == 1) {
                    et.attr("src", dfop.cbiconpath + dfop.icons[item.checkstate]);
                }
            }
        }
        // 遍历子节点
        function cascade(fn, item, args) {
            if (fn(item, args, 1) != false) {
                item.isSelectedAll = true;// 若该节点选中则该节点的子节点应该全部选中
                if (item.ChildNodes != null && item.ChildNodes.length > 0) {
                    var cs = item.ChildNodes;
                    for (var i = 0, len = cs.length; i < len; i++) {
                        cascade(fn, cs[i], args);
                    }
                }
            }
        }
        
        // 冒泡的祖先
        function bubble(fn, item, args) {
            var p = item.parent;
            while (p) {
                if ((p.checkstate == 1 && !dfop.cancleNoCascade) || fn(p, args, 0) === false) {
                    break;
                }
                p = p.parent;
            }
        }
        function nodeclick(e) {
            var path = $(this).attr("tpath");
            var et = e.target || e.srcElement;
            var item = getItem(path);
            if (et.tagName == "IMG") {
                // +号需要展开
                if ($(et).hasClass("bbit-tree-elbow-plus") || $(et).hasClass("bbit-tree-elbow-end-plus")) {
                    //该处记录了哪些应该进行展开动作
                    //2012-8-28 yuhongzhou added
                    //---------------------------------------
                    if(dfop.cookieName != "")
                    {
                    	try{
                    		var cookieStr = "";
                    		if(Cookie.read(dfop.cookieName) != undefined){
                    			cookieStr = Cookie.read(dfop.cookieName);
                    			if(cookieStr.findStr(item.id) == -1)
                    			{
									if(cookieStr == ""){ //当前cookie中不存在任何东西，或者读取cookie失败情况
										cookieStr = "," + item.id + ",";
									}else{
										cookieStr = cookieStr + item.id + ",";
									}
			                    	Cookie.remove(dfop.cookieName);
			                    	Cookie.write(dfop.cookieName,cookieStr,30);
                    			}
                    		}
                    	}catch(e)
                    	{
                    		alert(e);
                    	}
                    }
                    //---------------------------------------
                    var ul = $(this).next(); // "bbit-tree-node-ct"
                    if (ul.hasClass("bbit-tree-node-ct")) {
                        ul.show();
                    }
                    else {
                        var deep = path.split(".").length;
                        if (item.complete) {
                            item.ChildNodes != null && asnybuild(item.ChildNodes, deep, path, ul, item);
                        }
                        else {
                            $(this).addClass("bbit-tree-node-loading");
                            asnyloadc(item, true, function(data) {
                                item.complete = true;
                                item.ChildNodes = data;
                                asnybuild(data, deep, path, ul, item);
                            });
                        }
                    }
                    if ($(et).hasClass("bbit-tree-elbow-plus")) {
                        $(et).swapClass("bbit-tree-elbow-plus", "bbit-tree-elbow-minus");
                    }
                    else {
                        $(et).swapClass("bbit-tree-elbow-end-plus", "bbit-tree-elbow-end-minus");
                    }
                    $(this).swapClass("bbit-tree-node-collapsed", "bbit-tree-node-expanded");
                    bindTree();             // ///2011年12月28日 修改
                }
                else if ($(et).hasClass("bbit-tree-elbow-minus") || $(et).hasClass("bbit-tree-elbow-end-minus")) {  // -  // 号需要收缩
                	//该处记录了哪些进行了收缩动作
                	if(dfop.cookieName != "")
                	{
                		var cookieStr = "";
                		try{
                			cookieStr = Cookie.read(dfop.cookieName);
                			cookieStr = cookieStr.removeStr(item.id);
	                    	Cookie.remove(dfop.cookieName);
	                    	Cookie.write(dfop.cookieName,cookieStr,30);
                		}catch(e)
                		{
                			alert(e);
                		}
                	}
                    $(this).next().hide();
                    if ($(et).hasClass("bbit-tree-elbow-minus")) {
                        $(et).swapClass("bbit-tree-elbow-minus", "bbit-tree-elbow-plus");
                    }
                    else {
                        $(et).swapClass("bbit-tree-elbow-end-minus", "bbit-tree-elbow-end-plus");
                    }
                    $(this).swapClass("bbit-tree-node-expanded", "bbit-tree-node-collapsed");
                }
                else if ($(et).hasClass("bbit-tree-node-ra")) // 点击了radio
                {
                    var s = 1;
                    var r = true;
                    if (dfop.oncheckboxclick) {
                        r = dfop.oncheckboxclick.call(et, item, s);
                    }
                    if (r != false) {
                        clearSeleted(me[0].t);  // 删除自己和子级节点在初始化选中节点Id中的值
                        checkRadio(item, s);    // 点击单选框
                    }
                    if (dfop.onaftercheckboxclick) {
                        r = dfop.onaftercheckboxclick.call(et, item, s);
                    }
                }
                else if ($(et).hasClass("bbit-tree-node-cb")) // 点击了Checkbox
                {
                    var s;
                    
                    if(dfop.cascadecheck){// 如果设置回溯遍历，则checkstate 2会转变为1
                        s = item.checkstate != 1 ? 1 : 0;
                    }else{// 如果没有设置回溯遍历，则checkstate 2会转变为0
                        s = item.checkstate != 0 ? 0 : 1;
                    }
                    
                    var r = true;
                    if (dfop.oncheckboxclick) {
                        r = dfop.oncheckboxclick.call(et, item, s);
                    }
                    if (r != false) {
                        if (dfop.cascadecheck) {
                            item.isSelectedAll = true;// 设置该节点的下级子节点应该全部选中
                            removeSelfOrChildrenSeleted(me[0].t, item.id);// 删除自己和子级节点在初始化选中节点Id中的值
                            // 遍历
                            cascade(check, item, s);
                            if(dfop.parentCascadecheck){
                                // 上溯
                                bubble(check, item, s);
                            }
                        }
                        else {
                            check2(item, s, 1);// 改变节点选中状态
                            bubble2(check2, item, s);// 向上回溯父节点
                        }
                    }
                    if (dfop.onaftercheckboxclick) {
                        r = dfop.onaftercheckboxclick.call(et, item, s);
                    }
                }
            }
            else {
                if (dfop.citem) {
                    var nid = dfop.citem.id.replace(/[^\w]/gi, "_");
                    $("#" + id + "_" + nid).removeClass("bbit-tree-selected");
                }
                $("div .bbit-tree-selected").removeClass("bbit-tree-selected");
                dfop.citem = item;
                $(this).addClass("bbit-tree-selected");
                if (dfop.onnodeclick) {
                    if (!item.expand) {
                        item.expand = function() { expandnode.call(item); };
                    }
                    dfop.onnodeclick.call(this, item);
                }
            }
        }
        function expandnode() {
            var item = this;
            var nid = item.id.replace(/[^\w]/gi, "_");
            var img = $("#" + id + "_" + nid + " img.bbit-tree-ec-icon");
            if (img.length > 0) {
                img.click();
            }
        }
        
        /**
         * 节点双击触发事件
         * 
         * @param e
         *            双击事件
         * @return
         */
        function nodeDblclick(e) {
            var path = $(this).attr("tpath");
            var et = e.target || e.srcElement;
            var item = getItem(path);
            if (et.tagName != "IMG") {// 点击图片时双击无效
                if (dfop.onnodedblclick) {
                    dfop.onnodedblclick.call(this, item);
                }
            }
        }
        
        function asnybuild(nodes, deep, path, ul, pnode) {
            var l = nodes.length;
            if (l > 0) {
                initSelectedNodes(nodes, pnode, 1);// 初始化树节点的选中状态
                var ht = [];
                for (var i = 0; i < l; i++) {
                    nodes[i].parent = pnode;
                    buildnode(nodes[i], ht, deep, path + "." + i, i == l - 1);
                }
                ul.html(ht.join(""));
                ht = null;
                InitEvent(ul);
            }
            ul.addClass("bbit-tree-node-ct").css({ "z-index": 0, position: "static", visibility: "visible", top: "auto", left: "auto", display: "" });
            ul.prev().removeClass("bbit-tree-node-loading");
        }
        
        function asnyloadc(pnode, isAsync, callback) {
            if (dfop.url) {
                if (pnode && pnode != null)
                    var param = builparam(pnode);
                $.ajax({
                    type: dfop.method,
                    url: dfop.url,
                    data: param,
                    async: isAsync,
                    dataType: dfop.datatype,
                    success: callback,
                    error: function(e) { alert("error occur!"); }
                });
            }
        }
        function builparam(node) {
            var p = [{ name: "id", value: encodeURIComponent(node.id) }
                    , { name: "text", value: encodeURIComponent(node.text) }
                    , { name: "value", value: encodeURIComponent(node.value) }
                    , { name: "checkstate", value: node.checkstate}];
            return p;
        }
        function bindevent() {
            $(this).hover(function() {
                $(this).addClass("bbit-tree-node-over");
            }, function() {
                $(this).removeClass("bbit-tree-node-over");
            }).click(nodeclick)
              .dblclick(nodeDblclick)// 双击事件
             .find("img.bbit-tree-ec-icon").each(function(e) {
                 if (!$(this).hasClass("bbit-tree-elbow")) {
                     $(this).hover(function() {
                         $(this).parent().addClass("bbit-tree-ec-over");
                     }, function() {
                         $(this).parent().removeClass("bbit-tree-ec-over");
                     });
                 }
             });
        }
        function InitEvent(parent) {
            var nodes = $("li.bbit-tree-node>div", parent);
            nodes.each(bindevent);
            nodes.bind("contextMenu", function(e){// 添加右键功能
                var et = e.target || e.srcElement;
                if (et.tagName != "IMG") {
                    if (dfop.citem) {
                        var nid = dfop.citem.id.replace(/[^\w]/gi, "_");
                        $("#" + id + "_" + nid).removeClass("bbit-tree-selected");
                    }
                    var path = $(this).attr("tpath");
                    var item = getItem(path);
                    dfop.citem = item;
                    $(this).addClass("bbit-tree-selected");
                }
                return false;
            });
            if(dfop.contextMenu){// 需要展示右键菜单
                nodes.contextMenu($.extend(eval(dfop.contextMenu), {onSysContextMenu: checkContextMenu}));
            }
        }
        function reflash(itemId) {
            var nid = itemId.replace(/[^\w-]/gi, "_");
            var node = $("#" + id + "_" + nid);
            if (node.length > 0) {
                node.addClass("bbit-tree-node-loading");
                var isend = node.hasClass("bbit-tree-elbow-end") || node.hasClass("bbit-tree-elbow-end-plus") || node.hasClass("bbit-tree-elbow-end-minus");
                var path = node.attr("tpath");
                var deep = path.split(".").length;
                var item = getItem(path);
                if (item) {
                    asnyloadc(item, true, function(data) {
                        item.complete = true;
                        item.ChildNodes = data;
                        item.isexpand = true;
                        if (data && data.length > 0) {
                            item.hasChildren = true;
                        }
                        else {
                            item.hasChildren = false;
                        }
                        var ht = [];
                        buildnode(item, ht, deep - 1, path, isend);
                        ht.shift();
                        ht.pop();
                        var li = node.parent();
                        li.html(ht.join(""));
                        ht = null;
                        InitEvent(li);
                        bindevent.call(li.find(">div"));
                    });
                }
            }
            else {
                alert("该节点还没有生成");
            }
        }
        function getck(items, c, fn, deep) {
            if(dfop.displayDeep && deep >= dfop.displayDeep){// 增加显示级别设置的节点过滤
                return false;
            }
            for (var i = 0, l = items.length; i < l; i++) {
                (items[i].showcheck == true && items[i].checkstate == 1) && c.push(fn(items[i]));
                if (items[i].ChildNodes != null && items[i].ChildNodes.length > 0) {
                    getck(items[i].ChildNodes, c, fn, deep + 1);
                }
            }
        }
        
        /**
         * 得到已经选中的节点的Id值集合
         * 
         * @param items
         *            -节点集合
         * @param c
         *            -返回结果集合
         * @param fn
         *            -返回处理函数
         * @param deep
         *            -目前树的层次深度，主要在处理级别设置时使用
         * @return
         */
        function getCkAndHalfCkIds(items, c, fn, deep){
            if(dfop.displayDeep && deep >= dfop.displayDeep){// 增加显示级别设置的节点过滤
                return false;
            }
            var item;
            for (var i = 0, l = items.length; i < l; i++) {
                item = items[i];
                if (item.showcheck == true && (item.checkstate == 1 || item.checkstate == 2)){
                    if(!dfop.cascadecheck || item.complete){
                        c.singleNode.push(fn(item));
                    }else{
                        if(checkSelfOrChildrenHasSelected(me[0].t, item.id)){
                            c.singleNode.push(fn(item));
                        }else{
                            c.multiNode.push(fn(item));
                        }
                    }
                    removeSelfSeleted(me[0].t, item.id);
                }
                if (items[i].ChildNodes != null && items[i].ChildNodes.length > 0) {
                    getCkAndHalfCkIds(items[i].ChildNodes, c, fn);
                }
            }
        }
        
        function getCkAndHalfCk(items, c, fn, deep) {
            if(dfop.displayDeep && deep >= dfop.displayDeep){// 增加显示级别设置的节点过滤
                return false;
            }
            for (var i = 0, l = items.length; i < l; i++) {
               (items[i].showcheck == true && (items[i].checkstate == 1 || items[i].checkstate == 2)) && c.push(fn(items[i]));
                if (items[i].ChildNodes != null && items[i].ChildNodes.length > 0) {
                    getCkAndHalfCk(items[i].ChildNodes, c, fn, deep + 1);
                }
            }
        }
        
        /**
         * 初始化选中的树节点
         * 
         * @param items
         *            -树节点集
         * @param parentNode
         *            -items的父节点
         * @param type
         *            -初始化类型；type=0 树初始化时的节点选中；type=1 树延迟加载时的节点选中
         * @return
         */
        function initSelectedNodes(items, parentNode, type){
            if(dfop.aNeedLazy){
                if(dfop.showradio){
                    initRadioSelectedNodes(items);
                }else if(dfop.showcheck){
                    initLazySelectedNodes(items, parentNode, type);
                }
            }else{
                if(type == 0){
                    if(dfop.showradio){
                        initRadioSelectedNodes(items);
                    }else if(dfop.showcheck){
                        initStaticSelectedNodes(items);
                    }
                }
            }
        }
        
        /**
         * 单选框时初始化选中的树节点
         * 
         * @param items
         *            -树节点集
         * @return
         */
        function initRadioSelectedNodes(items){
            var item;
            for (var i = 0, l = items.length; i < l; i++) {
                item = items[i];
                if(item.showcheck == true && checkSelfHasSelected(me[0].t, item.id)){
                    checkRadio(item, 1);
                    removeSelfSeleted(me[0].t, item.id);
                }
                if (item.ChildNodes && item.ChildNodes.length > 0) {
                    initRadioSelectedNodes(item.ChildNodes);
                }
            }
        }
        
        /**
         * 复选框时初始化选中的树节点
         * 
         * @param items
         *            -树节点集
         * @param parentNode
         *            -items的父节点
         * @param type
         *            -初始化类型；type=0 树初始化时的节点选中；type=1 树延迟加载时的节点选中
         * @return
         */
        function initLazySelectedNodes(items, parentNode, type){
            var item;
            var state = 0;
            if(type == 1){
                state = (parentNode.checkstate && parentNode.isSelectedAll && !checkSelectedNode(items)) ? 1 : 0; 
            }
            for (var i = 0, l = items.length; i < l; i++) {
                item = items[i];
                if(item.showcheck == true){
                    if(dfop.cascadecheck){// 节点选中时需要遍历选中子节点
                        if(checkSelfOrChildrenHasSelected(me[0].t, item.id)){// 如果是本节点的子节点被初始化选中
                            check2(item, 1, 1);
                            bubble2(check2, item, 1);
                        }else if(state){
                            cascade(check, item, 1);
                            bubble2(check, item, 1);
                        }
                    }else{
                        if(checkSelfHasSelected(me[0].t, item.id)){// 如果是本节点被初始化选中
                            check2(item, 1, 1);
                            bubble2(check2, item, 1);
                        }
                    }
                }
                if (items[i].ChildNodes && items[i].ChildNodes.length > 0) {
                    initLazySelectedNodes(items[i].ChildNodes, items[i], type);
                }
            }
        }
        
        /**
         * 判断节点集里的某个节点或者其子节点是否有被选中的
         * 
         * @param items
         *            -节点集
         * @return true/false 是否被选中
         */
        function checkSelectedNode(items){
            var item;
            var hasSelected = false;
            for (var i = 0, l = items.length; i < l; i++) {
                item = items[i];
                if(item.showcheck == true){
                    if(checkSelfOrChildrenHasSelected(me[0].t, item.id)){// 如果是本节点的子节点被初始化选中
                        hasSelected = true;
                        break;
                    }
                }
            }
            return hasSelected;
        }
        
        /**
         * 静态树情况下的初始化选中的树节点
         * 
         * @param items
         *            -树节点集
         * @return
         */
        function initStaticSelectedNodes(items){
            if(items && items.length > 0){
                var l = items.length;
                for(var i=0; i<l; i++){
                    initStaticSelectedNode(items[i]);
                }
            }
        }
        
        /**
         * 静态树情况下的初始化选中的树节点
         * 
         * @param item
         *            -树节点
         * @return
         */
        function initStaticSelectedNode(item){
            var state = checkSelfHasSelected(me[0].t, item.id)?1:0;
            removeSelfSeleted(me[0].t, item.id);
            if (item.ChildNodes && item.ChildNodes.length > 0) {
                var l = item.ChildNodes.length;
                var childState;
                var allChildSelected = 1;// 记录子节点是否全部被选中
                for(var i=0; i<l; i++){
                    childState = initStaticSelectedNode(item.ChildNodes[i]);
                    if((state == 1 && childState != 1) ||
                            (dfop.cascadecheck && dfop.parentCascadecheck && state == 0 && childState != 0)){
                        state = 2;
                    }
                    if(childState != 1){
                        allChildSelected = 0;
                    }
                }
                if(state == 2 && allChildSelected == 1){
                    state = 1;
                }
            }
            item.checkstate = state;
            return state;
        }
        
        me[0].t = {
            /**
             * 得到树的所有节点
             * 
             * @return 树的所有节点（需要递归遍历）
             */
            getAllTreeNodes: function() {
                return treenodes;
            },
            getSelectedNodes: function(gethalfchecknode) {
                var s = [];
                if (gethalfchecknode) {
                    getCkAndHalfCk(treenodes, s, function(item) { return item; }, 0);
                }
                else {
                    getck(treenodes, s, function(item) { return item; }, 0);
                }
                return s;
            },
            getSelectedIds: function() {
                var initSelectedNode = dfop.aHasSelected;
                var s = {singleNode:[], multiNode:[]};
                if(dfop.aNeedLazy){// 延迟加载数据
                    try{
                        getCkAndHalfCkIds(treenodes, s, function(item) { return item.id; }, 0);
                        if(dfop.aHasSelected && dfop.aHasSelected != "" && dfop.aHasSelected != ","){// 还有初始化选中的节点Id
                            var aHasSelected = dfop.aHasSelected;
                            aHasSelected = aHasSelected.substring(1, aHasSelected.length - 1);
                            var aHasSelectedIds = aHasSelected.split(",");
                            for(var j=0; j<aHasSelectedIds.length; j++){
                                s.singleNode.push(aHasSelectedIds[j]);
                            }
                        }
                    }catch(e){
                        alert(e);
                    }finally{
                        dfop.aHasSelected = initSelectedNode;
                    }
                }else{// 一次性加载数据
                    getCkAndHalfCk(treenodes, s.singleNode, function(item) { return item.id; }, 0);
                }
                return s;
            },
            getCurrentItem: function() {
                return dfop.citem;
            },
            reflash: function(itemOrItemId) {
                var id;
                if (typeof (itemOrItemId) == "string") {
                    id = itemOrItemId;
                }
                else {
                    id = itemOrItemId.id;
                }
                reflash(id);
            },
            
            /**
             * 得到初始化选中节点Id集
             * 
             * @return 初始化选中节点Id集
             */
            getHasSelected: function(){
                return dfop.aHasSelected;
            },
            
            /**
             * 设置初始化选中节点Id集
             * 
             * @param hasSelected
             *            -初始化选中节点Id集
             * @return
             */
            setHasSelected: function(hasSelected){
                dfop.aHasSelected = hasSelected;
            }
        };
        
        var html = [];
        initSelectedNodes(dfop.data, null, 0);// 初始化树节点的选中状态
        buildtree(dfop.data, html);
        me.addClass("bbit-tree").html(html.join(""));
        InitEvent(me);
        html = null;
        
        return me;
    };
    $.fn.getTSIds1 = function(){alert();alert(this[0].innerHTML);
    	if (this[0].t) {
            return this[0].t.getSelectedIds();
        }
        return null;
    }
    
    // 获取所有选中的节点的Ids数组
    $.fn.getTSIds = function() {
        if (this[0].t) {
            return this[0].t.getSelectedIds();
        }
        return null;
    };
    // 获取所有选中的节点的Item数组
    $.fn.getTSNs = function(gethalfchecknode) {
        if (this[0].t) {
            return this[0].t.getSelectedNodes(gethalfchecknode);
        }
        return null;
    };
    $.fn.getTCT = function() {
        if (this[0].t) {
            return this[0].t.getCurrentItem();
        }
        return null;
    };
    $.fn.reflash = function(ItemOrItemId) {
        if (this[0].t) {
            return this[0].t.reflash(ItemOrItemId);
        }
    };
    /**
     * 得到树的所有节点
     * 
     * @return 树的所有节点（需要递归遍历）
     */
    $.fn.getAllTreeNodes = function() {
        return this[0].t.getAllTreeNodes();
    }
})(jQuery);

/**
 * 检测初始化选中的节点中是否有给定节点的子节点，默认实现，可由用户重载
 * 
 * @param {}
 *            aThis -当前树对象
 * @param {}
 *            nodeId -节点Id
 * @return true或者false
 */
function checkChildrenHasSelected(aThis, nodeId){
    pattern = new RegExp("\\," + nodeId + "\\S+\\,");
    return aThis.getHasSelected() ? pattern.test(aThis.getHasSelected()) : false;
}

/**
 * 检测初始化选中的节点中是否有给定节点，默认实现，可由用户重载
 * 
 * @param {}
 *            aThis -当前树对象
 * @param {}
 *            nodeId -节点Id
 * @return true或者false
 */
function checkSelfHasSelected(aThis, nodeId){
    pattern = new RegExp("\\," + nodeId + "\\,");
    return aThis.getHasSelected() ? pattern.test(aThis.getHasSelected()) : false;
}

/**
 * 检测初始化选中的节点中是否有给定节点或者给定节点的子节点，默认实现，可由用户重载
 * 
 * @param {}
 *            aThis -当前树对象
 * @param {}
 *            nodeId -节点Id
 * @return true或者false
 */
function checkSelfOrChildrenHasSelected(aThis, nodeId){
    pattern = new RegExp("\\," + nodeId + "\\S*\\,");
    return aThis.getHasSelected() ? pattern.test(aThis.getHasSelected()) : false;
}

/**
 * 删除初始化选中的节点中包含的给定节点或者给定节点的子节点，默认实现，可由用户重载
 * 
 * @param {}
 *            aThis -当前树对象
 * @param {}
 *            nodeId -节点Id
 * @return
 */
function removeSelfOrChildrenSeleted(aThis, nodeId){
    pattern = new RegExp("\\," + nodeId + "\\S*\\,");
    if(aThis.getHasSelected()){
        aThis.setHasSelected(aThis.getHasSelected().replace(pattern, ","));
    }
}

/**
 * 删除初始化选中的节点中包含的给定节点，默认实现，可由用户重载
 * 
 * @param {}
 *            aThis -当前树对象
 * @param {}
 *            nodeId -节点Id
 * @return
 */
function removeSelfSeleted(aThis, nodeId){
    pattern = new RegExp("\\," + nodeId + "\\,");
    if(aThis.getHasSelected()){
        aThis.setHasSelected(aThis.getHasSelected().replace(pattern, ","));
    }
}

/**
 * 清空初始化选中的节点数据
 * 
 * @param {}
 *            aThis -当前树对象
 * @return
 */
function clearSeleted(aThis){
    if(aThis.getHasSelected()){
        aThis.setHasSelected(null);
    }
}

/**
 *  获取树所有选中的节点ID
 *  return 逗号分隔字符串
 */
function getTreeSeletedNodeIds(dialogObj, treeDivId)
{
	
    // 获取树所有选中的节点ID
    var selectedIdArray = $("#" + treeDivId, dialogObj.dgDoc).getTSIds();
    var selectedIds ="";
    $.each(selectedIdArray,function(i,item){
        if(item != ''){
            selectedIds += item;
        }
    });
    return selectedIds;
}
/**
 * 获取树形选中的节点信息不论全选办选
 * return item数组
 */
function getTSNs(dialogObj,treeDivId)
{
    return selectedIdArray = $("#" + treeDivId, dialogObj.dgDoc).getTSNs(true);
}

function bindTree(){} 