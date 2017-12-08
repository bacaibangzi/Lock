$(window.parent.parent.parent).resize(function(){
	var winH =$("#page",window.parent.parent.document).height(); 
	var b = window.parent.document; //获取右侧iFrame
	b.body.style.height=winH+'px';
	b.getElementById("Js_asideMod").style.height=winH+'px';
	b.getElementById("group_info").style.height=winH+'px';
	b.getElementById("Js_commTree").style.height=winH+'px';
	b.getElementById("Js_mainMod").style.height=winH+'px';
	b.getElementById("Js_spitBarMod").style.height=winH+'px';
	});