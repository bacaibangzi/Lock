
function getCity(prov)
{
return prov.city;
}
function getCityCoord(city)
{
return city.geocode;
}

function getCityZoom(city)
{
var zoom=city.zoom;
if (isNaN(zoom) || zoom == null)
{
	zoom=9;
}
return zoom;
}

function getProvZoom(province)
{
var zoom;
if(province.zoom)
{
zoom=province.zoom;
}
else
{
zoom=getProvinceDetail(province).zoom
}
if (isNaN(zoom) || zoom == null)
{
	zoom=7;
}
return zoom
}
function getRegProvinces(regnum)
{
return regnum.province;
}
function getMarkerIcon(isPlace)
{
var kind=document.getElementById("item").value;
var srcImage;
if(kind=="customer"||kind=="")
{
srcImage='../../common/skin/bi/image/customer-icon.png';
}
if(kind=="shop")
{
srcImage='../../common/skin/bi/image/shop-icon.png';
}
if(kind=="ASR")
{
srcImage='../../common/skin/bi/image/employee-icon.png';
}
if(kind=="active City")
{
srcImage='../../common/skin/bi/image/activeCity.png';
}
if(isPlace)
{
srcImage='../../common/skin/bi/image/place_marker.png';
}
return srcImage;
}


function getRegColor(regnum)
{
var color=regnum.fillcolor;
return color;
}
function getCityColor(city)
{
var color=city.fillcolor;
return color;
}


function getProvinceColor(province)
{
var color;
color=getRegionDetailByProvince(province).fillcolor;
return color;
}
function getProvCenter(province)
{
var geoCode;
if(province.geocode)
{
geoCode=province.geocode;
}
else
{
geoCode=getProvinceDetail(province).geocode
}
return geoCode
}
function getProvinceDetail(province)
{
var detailPro;
var regions=data_region_province.regions
for(var reg in regions)
{
var pros=regions[reg].province;
for(var pro in pros)
{
if(pros[pro].id==province.id)
{
detailPro=pros[pro];
}
}
}
return detailPro;
}
function getRegionDetailByProvince(province)
{
var detailReg;
var regions=data_region_province.regions
for(var reg in regions)
{
var pros=regions[reg].province;
for(var pro in pros)
{
if(pros[pro].id==province.id)
{
detailReg=regions[reg];
}
}
}
return detailReg;
}
function getProvince(province)
{
var record;
if(province.enccoord)
{
record=province.enccoord;
}
else
{
record=getProvinceDetail(province).enccoord;
}
return record;
}
function getCityLocation(cityName)
{
return cityName.enccoord;
}
