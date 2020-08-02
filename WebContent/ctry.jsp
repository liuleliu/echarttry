<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	
	
    
</head>
<body>
<br>
  <button type="button" onclick='go()'  class="btn btn-primary">显示</button>
<div id="main" style="width: 2000px;height:400px;"></div>
</body>
   <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
 
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '疫情'
            },
            tooltip: {},
            legend: {
                data:['患者数量']
            },
            xAxis: {
                data: [1,2]
   
            },
            yAxis: {},
            series: [{
                name: '患者数量',
                type: 'bar',
                data: [1,2]
            }]
        };
 
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        
        function go() {
        	
        	
            $.ajax({
                type : "POST",  //请求方式
                url : "ctry",  //请求路径
                data : {  //请求参数
                
                },
                success : function(msg) {  //异步请求成功执行的回调函数
                   
                	da=JSON.parse(msg);
                	 alert("成功了: " + da.c);
                    var option = {
                            title: {
                                text: '疫情'
                            },
                            tooltip: {},
                            legend: {
                                data:['患者数量']
                            },
                            xAxis: {
                                data: da.c
                   
                            },
                            yAxis: {},
                            series: [{
                                name: '患者数量',
                                type: 'bar',
                                data: da.n
                            }]
                        };
                    var myChart = echarts.init(document.getElementById('main'));
                    myChart.setOption(option);
                
                   
                },//ajax引擎一般用不到；状态信息；抛出的异常信息
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(textStatus);
                    alert("失败了"+errorThrown)
                }
            });
        }
        
    </script>
</html>