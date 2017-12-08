//currentRegion
var currentRegion;
//currentProvince
var currentProvince;
//currentCity
var currentCity;
//Map object
var map;
//infomation window
var infowindow;
var drawArr = new Array;
var drawID = new Array;
var provdrawArr = new Array;
var provdrawID = new Array;
var markerArr = new Array;
var markerClusterArr = new Array;
var myMarkOverLay = new Array;
var overlay;
/**
*Init method
**/
function _init() {
	window.main();
}
function initPagination(city) {
	var total = eval("(" + city.totalCount + ")");
	$("#totalRow").text(total);
	if (parseInt(total) <= 10) {
		$(".result_page").hide();
	} else {
		$(".result_page").show();
	}
	$("#pagination").pagination($("#totalRow").text(), {callback:pageselectCallback, current_page:$("#curPage").text() - 1});

}
function pageselectCallback(curPage, jq) {
	tmp_marks = new Array();
	load3Data(curPage);
}
// 清除地图上的覆盖物 --%>
	    window.clearMap = function(){
	        map.clearOverlays();
	    };

  //<%-- 创建Marker对象弹出气泡提示信息 --%>
	    window.getTipStr = function(tip, cfg, json, img){
	          //var type = cfg.type;
	        var obj = tip;
	        if(typeof tip == "string"){
	            obj =  eval('('+tip+')');
	        }
	        var table="<div style='width:450px;'><table class='form-table' >";
	         table += "<tr style='height:100px;'><td class='w_22per hd'>相片：</td>"
	        
	        table += "<td><div style='height:80px;overflow:hidden'><img onload=\"scaleImage(this,110,75)\" style=\"border:1px solid #999999;\" src=\"../photoupload/photoDownload.action?photoUploadId=" + img + "\"/></div></td></tr>"
	     
	        for(var key in obj){
	            table+="<tr><td class='w_22per hd'>";
	            table+=key;
	            table+="：";
	            table+="</td><td>";
	            table+=obj[key];
	            table+="</td></tr>";
	        }
	       
	        table+="</table></div>";
	        return table;
	    };

window.getZoomPixel = function (latlon1, latlon2) {
	var xy1 = window.maplet.toScreenCoordinate(latlon1);
	var xy2 = window.maplet.toScreenCoordinate(latlon2);
	return Math.sqrt((xy1[0] - xy2[0]) * (xy1[0] - xy2[0]) + (xy1[1] - xy2[1]) * (xy1[1] - xy2[1]));
};
window.main = function () {
	try {
		map = new FMap("map");
	}
	catch (e) {
		alert(e.message);
	}
	if (window.maplet) {
		var md = $("#map_container");
		map.resize(md.width(), md.height());
	}
				// 设置点击地图是不移动到中心点 
	map.setClickToCenter(false);
				//增加双击事件 
	map.addListener("dbclick", function () {
		window.maplet.setMode("pan");
	});
};
			
			//初始化地图大小
function resizeMap() {
	if (window.maplet) {
		var w = $("#map_container").width();
		var h = $("#map_container").height();
		map.resize(w, h);
	}
}	

			//清除地图上的覆盖物
window.clearMap = function () {
	if (map) {
		map.clearOverlays();
	}
};
//Callback 
function callback(city) {
	if (map == null || map == "undefined") {
		document.getElementById("map").innerHTML = "google \u5730\u56feAPI\u672a\u52a0\u8f7d\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u3002";
		return;
	}
	showCity(city);
}
	

//Process city info ,add marker and build marker list.
function proccessCityInfo(data) {
	initData(data);
}



//Click on city in the province map ,show the city map
function showCity(city) {
	map.clearOverlays();
	map.zoom(new FLatLng(getCityCoord(city)[0], getCityCoord(city)[1]), getCityZoom(city));
	proccessCityInfo(city.data);
}




//get date and create cluster
function setMarkerClusterer(dat, i) {
	var id = dat.id;
	map.removeMark(id + "");
	var lat = dat.gps[0];
	var lon = dat.gps[1];
	var flatlng = new FLatLng(lat, lon);
	var pointCfg = {};
	pointCfg.id = id;
	pointCfg.path = "../application/images/map/marker" + (i + 1) + ".png";
	pointCfg.width = 22;
	pointCfg.height = 31;
	pointCfg.anchorX = 10;
	pointCfg.anchorY = 25;
	var bb = dat.infoMap;
	var img = "";
	       if(dat.picId){
	      	img = dat.picId;
	       };
	var vTip = getTipStr(bb, null, null, img);
	map.mark(flatlng, vTip, pointCfg, dat.id + "", dat.name, dat.name);
	map.setLabelVisiable(id + "", false);
	map.addMarkMouseoverListener(id + "", function (mark, id, pointobj) {
		if (pointobj) {
			var name = pointobj.option.tipOption.title;
			lon = pointobj.lnglat.lngX;
			lat = pointobj.lnglat.latY;
		}
		var path = map.getPath(id + "");
		if (path.indexOf("_hover.png") == -1) {
			path = path.replace(".png", "_hover.png");
		}	
	          // console.log(id + "-----" + path)
		map.updateImage(id, path);
		$("#item-td-" + id).addClass("focus-over");
		map.setLabelVisiable(id + "", true, {"content":name, "lon":lon, "lat":lat});
	  		//console.log(json[i].customerName+" large point is over! "+path + "图片:"+id)
	});
	map.addMarkMouseoutListener(id + "", function (mark, id, pointobj) {
		var path = map.getPath(id + "");
		if (path.indexOf("_hover.png") != -1) {
			path = path.replace("_hover.png", ".png");
		}
		map.updateImage(id, path);
		$("#item-td-" + id).removeClass("focus-over");
		map.setLabelVisiable(id + "", false);
	  		//console.log(json[i].customerName+" large point is out! "+path + "图片:"+id)
	});
	map.setAutoZoom();
	
}
var tmp_marks = new Array();
var topArray = new Array();
function initData(data) {
	topArray.length = 0;
	if (data.length == 0) {
		$("#oTbody").empty().html("<tr><td style=\"color:red;text-align:center\">\u6682\u65e0\u6570\u636e\uff01</td></tr>");
		$("#contentWrap").jScrollPane();
		return;
	}
	var array = new Array();
	$(data).each(function (i, n) {
		array.push("<tr id=\"item-td-" + n.id + "\" item=\"" + n.id + "\" class=\"\" onclick=\"clickPoint('" + n.id + "','" + n.gps[0] + "','" + n.gps[1] + "')\">");
		if (n.gps == "") {
			array.push("<th><div title=\"\u5728\u56fe\u4e0a\u663e\u793a\u8be5\u70b9\" class=\"icon disabled\" id=\"no" + (i + 1) + "\"></div></th>");
		} else {
			array.push("<th><div title=\"\u5728\u56fe\u4e0a\u663e\u793a\u8be5\u70b9\" class=\"icon\" id=\"no" + (i + 1) + "\"></div></th>");
		}
		array.push("<td>");
		array.push("<div style=\"overflow:hidden;clear:both;*overflow:visible;\"><a href=\"javascript:void(0);\">" + n.name + "</a></div>");
		if(n.address){
			array.push("<p class=\"n_p_lineheight\">\u5730\u5740\uff1a" + n.address + "</p>");
		}
		if(n.tel){
			array.push("<p class=\"n_p_lineheight\">\u7535\u8bdd\uff1a" + n.tel + "</p>");
		}
		array.push("</td>");
		array.push("</tr>");
		array.push("<tr style=\"height:5px\"><th></th><td style=\"font-size:0\"></td></tr>");
		n.index = i;
		if (n.customerLatlon != "") {
			tmp_marks.push(n);
		}
		topArray.push(n.id);
		setMarkerClusterer(n, i);
	});
	$("#oTbody").empty().html(array.join(""));
	contentHover();
	$("#contentWrap").jScrollPane();
	resizePage();
}
function resizePage() {
	var h = $(".ui-layout-center", window.top.document).outerHeight(true) - $(".Js_lnTab", window.top.document).outerHeight(true);
	var w = $(".Js_lnTab", window.top.document).outerWidth(true);
	$("#wrapper").height(h - $("#tools").height() + "px");
	$("#MapInfo").height(h - 67 + "px");
	$("#contentWrap").height(h - 73 + "px");
	$("#MapInfoTab").css("top", parseInt(((h - $("#tools").height()) - 55) / 2) + "px");
	if ($("#MapInfoTab").hasClass("mapinfo_but_open") || $("#MapInfoTab").hasClass("mapinfo_but_open_on")) {
		$("#MapHolder").css({"width":w + "px", "height":h - $("#tools").height() + "px"});
		$("#toast").width(w + "px");
	} else {
		$("#MapHolder").css({"width":w - 310 + "px", "height":h - $("#tools").height() + "px"});
		$("#toast").width(w - 310 + "px");
	}
	$("#contentWrap").jScrollPane();
}
function clickPoint(customerId, lat, lon) {
	if (lat != "" && lon != "") {
		var flatlng = new FLatLng(lat, lon);
		map.zoom(flatlng, 14);
		map.setLabelVisiable(customerId + "", true);
	}
}
function contentHover() {
	$("#result tr:even").hover(function () {
		$(this).addClass("focus-over");
		var id = $(this).attr("item");
		var name = $(this).attr("itemname");
		var lat = $(this).attr("lat");
		var lon = $(this).attr("lon");
		var path = map.getPath(id + "");
		if (path && path.indexOf("_hover.png") == -1) {
			path = path.replace(".png", "_hover.png");
		}
		map.updateImage(id, path);
		map.setLabelVisiable(id + "", true, {"content":name, "lon":lon, "lat":lat});
		    		//console.log(path + " is over! " + "图片:"+id)
	}, function () {
		$(this).removeClass("focus-over");
		var id = $(this).attr("item");
		var path = map.getPath(id + "");
		if (path && path.indexOf("_hover.png") != -1) {
			path = path.replace("_hover.png", ".png");
		}
		map.updateImage(id, path);
		map.setLabelVisiable(id + "", false);
		    		//console.log(path + " is out!" + "图片:"+id)
	});
}

//Store info window message content builder.Invoke : ajax callback.
function storeInfoWindowCallback(marker, data) {
	var content;
	var tel = "\u6682\u65e0";
	var address = "\u6682\u65e0";
	var photoId = 0;
   	//This data maybe need get from server.
	if (data.tel) {
		if (data.tel != "") {
			tel = data.tel;
		}
	}
	if (data.address) {
		if (data.address != "") {
			address = data.address;
		}
	}
	if (data.picId) {
		if (data.picId != "") {
			photoId = data.picId;
		}
	}
	content = "<div style=\"margin:0px\">" + "<div style=\"height:100%;width:142px;float:left\">" + "<span><a href=\"javascript:changeTo4level('" + data.id + "')\" ><b>" + data.name + "</b></a></span></br>" + "<span><b>\u7535\u8bdd: </b>" + tel + "</span></br>" + "<span><b>\u5730\u5740: </b>" + address + "</span>" + "</div>" + "<div style=\"background-color:#ffffff;height:100%;width:5px;float:left\">" + " </div>" + "<div style=\"height:100%;width:100px;float:left\">" + "<img onload=\"scaleImage(this,110,75)\" style=\"border:1px solid #999999;\" src=\"../photoupload/photoDownload.action?photoUploadId=" + photoId + "\"/>" + "</div>" + "</div>";
	showInfoWindow(marker, content);
}






//Login timeOut
function anewLonin() {
	window.top.alert("\u4f1a\u8bdd\u8d85\u65f6\u8bf7\u91cd\u65b0\u767b\u5f55\uff01");
	if (top) {
		top.location.href = "/index.jsp";
	} else {
		location.href = "/index.jsp";
	}
}
var scaleImage = function (o, w, h) {
	var img = new Image();
	img.src = o.src;
	if (img.width > 0 && img.height > 0) {
		if (img.width / img.height >= w / h) {
			if (img.width > w) {
				o.width = w;
				o.height = (img.height * w) / img.width;
			} else {
				o.width = img.width;
				o.height = img.height;
			}
			o.alt = img.width + "x" + img.height;
		} else {
			if (img.height > h) {
				o.height = h;
				o.width = (img.width * h) / img.height;
			} else {
				o.width = img.width;
				o.height = img.height;
			}
			o.alt = img.width + "x" + img.height;
		}
	}
};

