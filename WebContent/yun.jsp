<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
<div id = "main" style="width: 1200px;height: 800px;"></div>
<script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
<script type="text/javascript" src = "js/echarts-wordcloud.min.js"></script>
	<script type="text/javascript">
	
			var data = [];
			
			var maskImage = new Image();
			maskImage.src = 'c.png';
			
			option = {
				    title: {
				        text: '词云',//标题
				        x: 'center',
				        textStyle: {
				            fontSize: 23
				        }
				 
				    },
				    backgroundColor: '#F7F7F7',
				    tooltip: {
				        show: true
				    },
				    series: [{
				        name: '热点分析',//数据提示窗标题
				        type: 'wordCloud',
				        drawOutOfBound:true,
				        sizeRange: [6, 66],//画布范围，如果设置太大会出现少词（溢出屏幕）
				        rotationRange: [-45, 90],//数据翻转范围
				        //shape: 'circle',
				        textPadding: 0,
				        autoSize: {
				            enable: true,
				            minSize: 6
				        },
				        textStyle: {
				            normal: {
				                color: function() {
				                    return 'rgb(' + [
				                        Math.round(Math.random() * 160),
				                        Math.round(Math.random() * 160),
				                        Math.round(Math.random() * 160)
				                    ].join(',') + ')';
				                }
				            },
				            emphasis: {
				                shadowBlur: 10,
				                shadowColor: '#333'
				            }
				        },
				        data: [{
				            name: "数据一",
				            value: 1000
				        }, {
				            name: "数据二",
				            value: 520
				        }]//name和value建议用小写，大写有时会出现兼容问题
				    }]
				};
					
			
			var myChart = echarts.init(document.getElementById('main'));
			maskImage.onload = function() {
			    myChart.setOption(option);
			};
			window.onresize = function() {
			    myChart.resize();
			}
			myChart.on('click',function(params){
			    alert(params.name)
			});
	</script>
</body>
</html>