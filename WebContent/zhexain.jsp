<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>折线图</title>
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body style="background-color:#4F4F4F;">
<!--为echarts准备一个容器，画图就画在里面-->
<div id="main" style="width: 100%;height: 200%;"></div>
<script>
    //初始化ehcharts实例
    var myChart=echarts.init(document.getElementById("main"));
    $(document).ready(function(){
    	go();
        
       });
    //指定图表的配置项和数据
 
    //使用刚刚指定的配置项和数据项显示图表
    
      function go() {
        	
        	
            $.ajax({
                type : "POST",  //请求方式
                url : "zhelet",  //请求路径
                data : {  //请求参数
                
                },
                success : function(msg) {  //异步请求成功执行的回调函数
                   
                	da=JSON.parse(msg);
                	 
                	   var option={
                		        //标题
                		        title:{
                		          text:'趋势'
                		        },
                		        //工具箱
                		        //保存图片
                		        toolbox:{
                		            show:true,
                		            feature:{
                		                saveAsImage:{
                		                    show:true
                		                }
                		            }
                		        },
                		        tooltip: {
                			        trigger: 'item',
                			       },
                		        //图例-每一条数据的名字叫销量
                		        legend:{
                		            data:['确诊数量']
                		        },
                		        //x轴
                		        xAxis:{
                		            data:da.time
                		        },
                		        //y轴没有显式设置，根据值自动生成y轴
                		        yAxis:{},
                		        //数据-data是最终要显示的数据
                		        series:[{
                		            name:'销量',
                		            type:'line',
                		            data:da.num
                		        }]
                		    };
                    var myChart = echarts.init(document.getElementById('main'));
                    myChart.setOption(option);
               
                   
                },//ajax引擎一般用不到；状态信息；抛出的异常信息
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(textStatus);
                    alert("获取数据失败了"+errorThrown)
                }
            });
        }
    
    
    
    
    
    myChart.setOption(option);
</script>
</body>
</html>