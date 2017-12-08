//调整页面高度
function changSize() {
	var windowheight = $(window).height();
	var windowwidth = $(window).width();
	$("#mainbody").width(windowwidth);
    //$("#mainbodytop").width(windowwidth);
    //$("#mainbodyheader").width(windowwidth);
    var isIE=!!window.ActiveXObject; 
    var isIE6=isIE&&!window.XMLHttpRequest; 
    if(!isIE6)
    {
        //$("#mapnav").width(windowwidth-280);
    }
	$("#right").width(windowwidth-240);
	$("#left").height((windowheight-151)<680?680:(windowheight-151));
	$("#carchoose").height((windowheight-431)<400?400:(windowheight-431));
	$("#mainFrame").width(windowwidth-200);
	$("#mainFrame").height((windowheight-149)<680?680:(windowheight-149));
	$("#sidebar").height((windowheight-134)<680?680:(windowheight-134));
	var menulist = $(".leftmenu2 > ul > li").length;
}

//function mouseoverchangecolor()
//{
//    //table鼠标经过换色
//    $(".middle").hover(function() {
//	    var i = $(".middle").index($(this));
//	    $(".middle").eq(i).addClass("hover");
//    },function() {
//	    var i = $(".middle").index($(this));
//	    $(".middle").eq(i).removeClass("hover");
//    });
//}
//mouseoverchangecolor();

$(".checkall").toggle(function() {
	$("input[name='select']").each(function() { 
		this.checked=true;
	});
},function() {
	$("input[name='select']").each(function() { 
		this.checked=false;
	});
});
$(".checkall1").toggle(function() {
	$("input[name='select1']").each(function() { 
		this.checked=true;
	});
},function() {
	$("input[name='select1']").each(function() { 
		this.checked=false;
	});
});
//Tabs
$(".tabs1_list > ul > li").click(function(i) {
	var i = $(".tabs1_list > ul > li").index($(this));
	$(".tabs1_c > .show").removeClass("show");
	$(".tabs1_c > .tabs1_content").eq(i).addClass("show");
	$(".tabs1_list > ul > li").eq(i).addClass("active").siblings().removeClass("active");
});
$(".bj_tabs_tab > ul > li").click(function(i) {
	var i = $(".bj_tabs_tab > ul > li").index($(this));
	$(".bj_tabs_content > .show").removeClass("show");
	$(".bj_tabs_content > .tabs_content").eq(i).addClass("show");
	$(".bj_tabs_tab > ul > li").eq(i).addClass("active").siblings().removeClass("active");
});
//注册页面
$(".kx").toggle(function() {
	$("#option").show("fast");
},function() {
	$("#option").hide("fast");
});
/* 车辆详细信息页面打开关闭功能 */
$(".d_list > h3 > span").toggle(function() {
	$(this).closest("div").find("p").hide("fast");
},function() {
	$(this).closest("div").find("p").show("fast");
});
