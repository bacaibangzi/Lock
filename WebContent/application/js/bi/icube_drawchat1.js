


function drawPie(title,data){
   	  var chart;
       chart = new Highcharts.Chart({
           chart: {
               renderTo: 'chart_div',
               plotBackgroundColor: null,
               plotBorderWidth: null,
               plotShadow: false,
               style: {margin:'auto'}
           },
           title: {
         	  style:{
			   color: '#3E576F',
			   fontSize: '14px'
			   },
               text:title
           },
           tooltip: {
               formatter: function() {
                     return '<b>'+ this.point.name +'</b>: '+ Math.round(this.percentage) +' %';
               }
           },
           plotOptions: {
               pie: {
               	style: {
					fontSize: '12px'
				},
                   allowPointSelect: true,
                   cursor: 'pointer',
                   dataLabels: {
                       enabled: true
                   },
                   showInLegend: false
               }
           },
           series: [{
               type: 'pie',
               name: 'Browser share',
               data:data
           }]
   });
      if(navigator.appName == "Microsoft Internet Explorer") 
   		{ 
    		 chart.tooltip=false;
     	}
           
}