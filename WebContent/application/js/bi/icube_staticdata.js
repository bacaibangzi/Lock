var ASR=[
{
value:'week',
title:'本周内在线'
},
{
value:'24hour',
title:'24小时内在线'
},{
value:'12hour',
title:'12小时内在线'
},{
value:'1hour',
title:'1小时内在线'
},{
value:'0',
title:'自定义'
}];


function getStoreMenu()
{
	var STORE=[
	{
	value:'30',
	title:'30天之内反馈'
	},{
	value:'month',
	title:'本月之内反馈'
	},{
	value:'7',
	title:'7天之内反馈'
	},{
	value:'week',
	title:'本周之内反馈'
	},{
	value:'1',
	title:'今天反馈'
	},{
value:'0',
title:'自定义'
}];

return STORE;
}


function getCustomerMenu()
{
var CUSTOMER=[
{
value:'30',
title:'30天之内拜访'
},{
value:'month',
title:'本月之内拜访'
},{
value:'7',
title:'7天之内拜访'
},{
value:'week',
title:'本周之内拜访'
},{
value:'1',
title:'今天拜访'
},{
value:'0',
title:'自定义'
}];
return CUSTOMER;

}
function getCityMenu(){
var CITY=[
{
	
value:'30',
title:'30天之内走访'
},{
value:'month',
title:'本月之内走访'
},{
value:'7',
title:'7天之内走访'
},{
value:'week',
title:'本周之内走访'
},{
value:'1',
title:'今天走访'
},{
value:'0',
title:'自定义'
}];
return CITY;
}