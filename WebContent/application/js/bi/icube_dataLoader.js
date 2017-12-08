function count3Data(curPage) {
	
	if(!curPage){
		curPage=0;
	}
	topArray.length = 0;
	var date = new Date();
	var sec = date.getMilliseconds();
	var item = document.getElementById("item").value;
	var url;
	if (item == "store") {
		url = "bi/storeInfoInCity.action";
	} else {
		if (item == "customer") {
			url = "bi/customerInfoInCity.action";
		}
	}
	$.post(url, $("form").serialize() + "&cityId=" + currentCityId + "&stamp=" + sec+"page.pageSize=10&page.pageNo="+curPage + 1, initPagination, "json");
}

function load3Data(curPage) {
	
	 topArray.length = 0;
	var date = new Date();
	var sec = date.getMilliseconds();
	var item = document.getElementById("item").value;
	var url;
	if (item == "store") {
		url = "bi/storeInfoInCity.action";
	} else {
		if (item == "customer") {
			url = "bi/customerInfoInCity.action";
		}
	}
	$.post(url, $("form").serialize() + "&cityId=" + currentCityId + "&stamp=" + sec+"page.pageSize=10&page.pageNo="+(curPage + 1), callback, "json");
}
function load1Data() {
	var date = new Date();
	var sec = date.getMilliseconds();
	var item = document.getElementById("item").value;
	var url;//查询区域维度数据
	if (item == "store") {
		url = "storeInProvinceAll.action";
	} else {
		if (item == "customer") {
			url = "customerInProvinceAll.action";
		}
	}
	//查询区域维度数据
	$.post(url, $("form").serialize() + "&stamp=" + sec, callbackLoader1, "json");
}
function load2Data() {
	var date = new Date();
	var sec = date.getMilliseconds();
	var item = document.getElementById("item").value;
	var url;//查询区域维度数据
	if (item == "store") {
		url = "storeInCityAll.action";
	}
	if (item == "customer") {
		url = "customerInCityAll.action";
	}
	//查询区域维度数据
	$.post(url, $("form").serialize() + "&provinceId=" + currentAreaId + "&stamp=" + sec, callbackLoader1, "json");
}
function callbackLoader1(data) {
	window.level1_json_data = data;
	drawChart();
}
function loadData() {
	if (currentLevel == 1) {
		resetMainWidth(setWinHW());
		load1Data();
	}
	if (currentLevel == 2) {
		resetMainWidth(setWinHW());
		load2Data();
	
	}
	if (currentLevel == 3) {
		resetMainWidth(setWinHW());
		count3Data();
		resizeMap();
	}
}
function getFlvDataUri(level) {
	var uri = "";
	var item = document.getElementById("item").value;
	var date = new Date();
	var sec = date.getMilliseconds();
	if (level == 1) {
		if (item == "store") {
			uri = "storeInProvinceForFlv.action?" + $("form").serialize() + "&stamp=" + sec;
		}
		if (item == "customer") {
			uri = "customerInProvinceForFlv.action?" + $("form").serialize() + "&stamp=" + sec;
		}
	}
	if (level == 2) {
		if (item == "store") {
			uri = "storeInCityForFlv.action?" + $("form").serialize() + "&provinceId=" + currentAreaId + "&stamp=" + sec;
		}
		if (item == "customer") {
			uri = "customerInCityForFlv.action?" + $("form").serialize() + "&provinceId=" + currentAreaId + "&stamp=" + sec;
		}
	}
	return uri;
}

