var currentChartStyle='clumn';
function drawChart()
{
	var data= window.level1_json_data;
	
	if(currentChartStyle=='clumn')
	{
		drawClumn("区域数据统计",data);
	}
	if(currentChartStyle=='pie')
	{
		drawPie("区域数据统计",data);
	}

}

function switchChartType()
{

}


function drawClumn(title,data){
	var names=new Array();
	var values=new Array();
	var valuesa=new Array();
	var items={};
	var itemsa={};
	var length=data.length;
	for(var i=0 ;i<length;i++)
	{
		names[i]=data[i].name;
		values[i]=data[i].total;
		valuesa[i]=data[i].y;
	}
	
  			var lablestyle= {
                    enabled: true,
                    rotation: -90,
                    color: '#000000',
                    align: 'center',
                    x: -3,
                    y: -15,
                    formatter: function() {
                        return this.y;
                    },
                    style: {
                        fontSize: '12px',
                        fontFamily: '细黑,Verdana, sans-serif'
                    }
                }	;
                
	itemsa.name="激活";
	items.name="全部";
	items.data=values;
	itemsa.data=valuesa;
	items.dataLabels=lablestyle;
	itemsa.dataLabels=lablestyle;
    var chart;

    chart = new Highcharts.Chart({
            chart: {
                renderTo: 'chart_div',
                type: 'column'
             
            },
            title: {
                text: title
            },
            xAxis: {
                categories: names,
                labels: {
                    rotation: -45,
                    style: {
                        fontSize: '12px',
                        fontFamily: '细黑,Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '数量(个)'
                }
            },
           legend: {
                layout: 'vertical',
                backgroundColor: '#FFFFFF',
                align: 'right',
                verticalAlign: 'top',
                x: -100,
                y: 20,
                floating: true,
                shadow: false
            },
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.x +'</b>'+ Highcharts.numberFormat(this.y, 0) ;
                }
            },
                series: [items,itemsa]
        });
        if(navigator.appName == "Microsoft Internet Explorer") 
   		{ 
    		 chart.tooltip=false;
     	}
           
}
