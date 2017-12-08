//画表格
function drawGrid()
{
    var tableObj={};
	tableObj.bPanination = false;
	tableObj.aaSorting=[[2,'desc']];
	var item = document.getElementById("item").value;
	if(item=="store")
	{
		tableObj.url =  getStoreColums().url;
		tableObj.aoColumns = getStoreColums().columns;
	}
	if(item=="customer")
	{
		tableObj.url =  getCustomerColums().url;
		tableObj.aoColumns = getCustomerColums().columns;
	}
	
	 datatable=datatableObj(tableObj);
}

//获取门店的统计列
function getStoreColums()
{
	var url;  
	var storeColumns;
	var level;
	if(currentLevel==1)
	{
		level="level1"
	}else
	{
		level="level2"
	}

	//一级 全部城市
	if(level=="level1")
	{

		url="storeInProvince.action?"+$("form").serialize();
		storeColumns=
		 [
			{"mDataProp":"name","sDefaultContent":"","bSortable":false,"sTitle":"省份","sClass":"text-align-l","sWidth":"39%"},
			{"mDataProp":"total","sDefaultContent": "","bSortable":true,"sTitle":"门店总数" ,"sClass":"text-align-r"},
			{"mDataProp":"y","sDefaultContent": "","bSortable":true,"sTitle":"激活数量","sClass":"text-align-r" }
		];
	
	}
		//二级 
	if(level=="level2")
	{
		url="storeInCity.action?"+$("form").serialize()+"&provinceId="+currentAreaId
		storeColumns=
		 [
			{"mDataProp":"name","sDefaultContent":"","bSortable":false,"sTitle":"城市","sClass":"text-align-l","sWidth":"39%"},
			{"mDataProp":"total","sDefaultContent": "","bSortable":true,"sTitle":"门店总数","sClass":"text-align-r" },
			{"mDataProp":"y","sDefaultContent": "","bSortable":true,"sTitle":"激活数量","sClass":"text-align-r" }
		];
	}
	return {columns:storeColumns,url:url,level:level};
}



//获取客户的统计列
function getCustomerColums()
{
	var url;  
	var storeColumns;
	var level;
	if(currentLevel==1)
	{
		level="level1"
	}else
	{
		level="level2"
	}
	
	if(level=="level1")
	{
		url="customerInProvince.action?"+$("form").serialize()
		columns=
		 [
			{"mDataProp":"name","sDefaultContent":"","bSortable":false,"sTitle":"省份","sClass":"text-align-l","sWidth":"39%"},
			{"mDataProp":"total","sDefaultContent": "","bSortable":true,"sTitle":"客户总数" ,"sClass":"text-align-r"},
			{"mDataProp":"y","sDefaultContent": "","bSortable":true,"sTitle":"激活数量" ,"sClass":"text-align-r"}
		];
	}
	

	//获取客户省级的统计列
	if(level=="level2")
	{
		url="customerInCity.action?"+$("form").serialize()+"&provinceId="+currentAreaId
		columns=
		 [
			{"mDataProp":"name","sDefaultContent":"","bSortable":false,"sTitle":"省份","sClass":"text-align-l","sWidth":"39%"},
			{"mDataProp":"total","sDefaultContent": "","bSortable":true,"sTitle":"客户总数","sClass":"text-align-r" },
			{"mDataProp":"y","sDefaultContent": "","bSortable":true,"sTitle":"激活数量" ,"sClass":"text-align-r"}
		];
	}
	return {columns:columns,url:url,level:level};
}




//获取人员的统计列
function getASRColums()
{
	var url;  
	var storeColumns;
	var cityLevel=document.getElementById("cityLevel").value;	
	var level;
	if(currentLevel==1)
	{
		if(cityLevel==0)
		{
			level="level1"
		}else
		{
			level="level1.5"
		}
	}else
	{
			level="level2"
	}
	if(level=="level1")
	{
		url="asrInRegion.action?"+$("form").serialize()
		columns=
		[
			[  
			   	{field:"name",title:"大区",width:60,sortable:true,styler:columnFloatCenter,align:"center"},
		   		{field:"regionSonName",title:"BO",width:60,sortable:true,styler:columnFloatCenter,align:"center"},
				{field:"total",title:"注册人数",width:60,sortable:true,styler:columnFloatRight,align:"center"},
				{field:"y",title:"在线人数",width:60,sortable:true,styler:columnFloatRight,align:"center"}
			]
		] ; 
	}
	
	//获取客户一级分级别城市的统计列
	if(level=="level1.5")
	{
		url="asrInRegion.action?"+$("form").serialize()
		columns=
		[
			[  
			 	{field:"name",title:"大区",width:60,sortable:true,styler:columnFloatCenter,align:"center"},
		   		{field:"regionSonName",title:"BO",width:60,sortable:true,styler:columnFloatCenter,align:"center"},
				{field:"total",title:"注册人数",width:60,sortable:true,styler:columnFloatRight,align:"center"},
				{field:"y",title:"在线人数",width:60,sortable:true,styler:columnFloatRight,align:"center"}
			]
		] ; 
	}
	
	//获取客户省级的统计列
	if(level=="level2")
	{
		url="asrInCity.action?"+$("form").serialize()+"&provinceId="+currentAreaId
		var columns=
		[
			[  
			
			   	{field:"name",title:"城市",width:60,sortable:true,styler:columnFloatCenter,align:"center"},
				{field:"total",title:"注册人数",width:60,sortable:true,styler:columnFloatRight,align:"center"},
				{field:"y",title:"在线人数",width:60,sortable:true,styler:columnFloatRight,align:"center"}
			]
		] ; 
	}
	return {columns:columns,url:url,level:level};
}



//获取城市的统计列
function getCityColums()
{
	var url;  
	var storeColumns;
	var cityLevel=document.getElementById("cityLevel").value;	
	var level;
	if(currentLevel==1)
	{
		if(cityLevel==0)
		{
			level="level1"
		}else
		{
			level="level1.5"
		}
	}else
	{
			level="level2"
	}
	if(level=="level1")
	{
		url="cityInRegion.action?"+$("form").serialize()
		columns=
		[
			[  
			   	{field:"name",title:"大区",width:60,sortable:true,styler:columnFloatCenter,align:"center"},
		   		{field:"regionSonName",title:"BO",width:60,sortable:true,styler:columnFloatCenter,align:"center"},
				{field:"total",title:"目标城市",width:60,sortable:true,styler:columnFloatRight,align:"center"},
				{field:"y",title:"激活城市",width:60,sortable:true,styler:columnFloatRight,align:"center"}
			]
		] ; 
	}
	
	//获取客户一级分级别城市的统计列
	if(level=="level1.5")
	{
		url="cityInRegion.action?"+$("form").serialize()
		columns=
		[
			[  
			  {field:"name",title:"大区",width:60,sortable:true,styler:columnFloatCenter,align:"center"},
		   		{field:"regionSonName",title:"BO",width:60,sortable:true,styler:columnFloatCenter,align:"center"},
				{field:"total",title:"目标城市",width:60,sortable:true,styler:columnFloatRight,align:"center"},
				{field:"y",title:"激活城市",width:60,sortable:true,styler:columnFloatRight,align:"center"}
			]
		] ; 
	}
	
	//获取客户省级的统计列
	if(level=="level2")
	{
	
		url="cityInCity.action?"+$("form").serialize()+"&provinceId="+currentAreaId
		var columns=
		[
			[  
			
			   	{field:"name",title:"城市",width:60,sortable:true,styler:columnFloatCenter,align:"center"},
				{field:"y",title:"是否激活",width:60,sortable:true,styler:columnFloatRight,align:"center",styler:
						function(value,row,index){     //value：列值，row:行对象 index:行下标
						if(value == '1'){
						row.y = "<img src='../application/images/icon/number_bg2.png'/>";
						}else
						{
						row.y = "<img src='../application/images/icon/number_bg1.png'/>";
						}

	                    return columnFloatRight(value,row,index);
                }}
			]
		] ; 
	}

	return {columns:columns,url:url,level:level};
}


