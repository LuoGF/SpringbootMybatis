var gjzb=echarts.init(document.getElementById("right-gjzbEchart"));

           
option = {
    color: [ '#0068b7', '#006699', '#4cabce', '#e5323e' ],//统计图颜色系列值
    tooltip : {
        trigger: 'axis'
    },
    grid: {
				borderWidth: 0,
				x: 70,
				y: 10,
				top: 65,
				left: 45,
				right: 30,
				bottom: 70,
				//barWidth:1,
				textStyle: {
				color: "#fff"
				}
			},
             legend: {
        data:['蒸发量','降水量','平均温度']
    },
    toolbox: {
        show : false,
        feature : {
            mark : {show: false},
            dataView : {show: true, readOnly: false},
            magicType: {show: true, type: ['line','bar']},
            restore : {show: false},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        }
    ],
    yAxis : [
        {
            type : 'value',
            name : '降水量',
            axisLabel : {
           formatter: '{value}\r\nkW·h'
            }
        },
        {
            type : 'value',
            name : '降水率',
            axisLabel : {
                formatter: '{value}\r\n%'
            }
        }
    ],
   series : [
       {
            name:'蒸发量',
            type:'bar',
            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]/*,
				barMaxWidth: 0,
				large: false,
				barMinHeight: 1,
				itemStyle: {color: "#e5323e",
				  normal :{ 
				  	label: {
                        		show: true,
                        		distance: 0,
                        		fontWeight: 'bolder',
                        		position: 'top',
                        		color: '#0068b7',
                        		fontSize: 20,
                        		formatter: function(value, index) {
                        		return value.value+"%";
                        		}
                        	}
                        	}
                    }*/	  
        },
        {
            name:'降水量',
            type:'bar',
			//barWidth:0,
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
        },
        {
            name:'平均温度',
            type:'line',
            yAxisIndex: 1,
            data:[-4.0, 6.2, -3.3, 4.5, -9.3, 10.2, 20.3, 23.4, -23.0, 16.5, -12.0, 6.2]
        } 
    ]

};
gjzb.setOption(option);
