$(document).ready(function() {
	barControlSplit();
	var winH = $("#page", window.parent.parent.document).height();
	$("#Js_spitBarMod").height(winH);
	$("#Js_mainMod").height(winH);
	$("#Js_mainMod").find("iframe").height(winH);
	$("#Js_asideMod").height(winH);
	$("#Js_asideMod").find("iframe").height(winH);
	});
	
$(window.parent.parent.parent).resize(function() {
	var winH = $("#page", window.parent.parent.document).height();
	$("#Js_spitBarMod").height(winH);
	$("#Js_mainMod").height(winH);
	$("#Js_mainMod").find("iframe").height(winH);
	$("#Js_asideMod").height(winH);
	$("#Js_asideMod").find("iframe").height(winH);
	});
