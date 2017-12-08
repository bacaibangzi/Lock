//到一级界面
function changeTo1level() {
    //隐藏flv 隐藏 chat 隐藏 table
    icubeShow("coverBox");
    icubeShow("chart_div");
    icubeShow("table_div");
    icubeHide("map");
    icubeHide("marker_div");
    icubeHide("icon_button_div");
	//cityLv菜单
    clearMap();
}
//到2级别界面
function changeTo2level() {
    //隐藏flv 隐藏 chat 隐藏 table
    icubeShow("coverBox");
    icubeBackSize("coverBox");
    icubeShow("chart_div");
    icubeShow("table_div");
    icubeHide("map");
    icubeHide("marker_div");
	//cityLv菜单
	icubeShow("icon_button_div");
   clearMap();
	
}
//到3级别界面
function changeTo3level()
{	icubeShow("map");
	//隐藏flv 隐藏 chat 隐藏 table
	icubeZeroSize("coverBox");
	icubeHide("chart_div");
	icubeHide("table_div");
	icubeShow("marker_div");
	icubeShow("icon_button_div");
	//cityLv菜单
}
//到4级别界面
function changeTo4level(id) {
    var select = document.getElementById("item");
    var selectValue = select.value;
    window.top.addTabCon({
        title: '详细',
        id: 'detail',
        url: 'bi/portal.action?item=' + selectValue + '&itemId=' + id,
        tabImg: 'application/images/bi/Google_Maps_Marker.png',tabClose:"true"
    });
}

function changeLevel(level) {
    switch (level) {
    case 1:
        {
            //到二级
            changeTo2level();
            break;
        }
    case 2:
        { //到三级
            //thisMovie("Main").loadXml(xmlfile);
            var item = document.getElementById("item").value;
            if (item != "store" && item != "customer") {
                return;
            }
            changeTo3level();
            break;
        }
    default:
        {}
    }
    //重新加载新等级的数据
}

//点击右上的返回按钮
function onbackButtonClick(casea) {
    switch (currentLevel) {
    case 3:
        {
            changeTo2level();
            //为了变形
           	 drawChart();
            currentLevel = 2;
			chnageParam();
            break;
        }

    case 2:
        {
            changeTo1level();
            //为了变形
			backtoNation();
            break;
        }
    default:
        {}
    }
}
String.prototype.trim = function() {
	return this.replace(/(^\s+)|(\s+$)/g, "");
};


function getQueryString()
{

	var itemValue=getSelectOptionValue("item").trim();
	var itemString="选项："+itemValue;
	var filterValue=getSelectOptionValue("filter").trim();
	var filterString="筛选：";
	if(filterValue=='自定义')
	{
		var startDate=document.getElementById("startDate").value;
		var endDate=document.getElementById("endDate").value;
		if(endDate==''||null==endDate)
		{
			endDate="今";
		}
		
		filterString+=startDate+"至"+endDate;
		if(endDate=='今')
		{
			if(startDate==''||null==startDate)
			{
				filterString="筛选：无限制";
			}
			
		}
	}else
	{
		filterString+=filterValue;
	}
	var queryString="查询条件\n"+itemString+"\n"+filterString;
	return queryString;
}


function getSelectOptionValue(id)
{
	var select=document.getElementById(id);
	var options = select.options;
	var length=options.length;
	for(var index=0;index<length;index++)
	{
		var option=options[index];
		if(option.selected){return option.innerHTML}
	}
}


function icubeHide(id) {
    document.getElementById(id).style.display = "none";
}
function icubeZeroSize(id) {
    document.getElementById(id).style.width = "0%";
    document.getElementById(id).style.height = "0%";
}
function icubeBackSize(id) {
    document.getElementById(id).style.width = "100%";
    document.getElementById(id).style.height = "100%";
}
function icubeShow(id) {
    document.getElementById(id).style.display = "block";
}