<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>第一个 ECharts 实例</title>
    <!-- 引入 echarts.js -->
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
</head>
<style type="text/css">
			/*表格样式*/			
			table {
				width: 90%;
				background: #ccc;
				margin: 10px auto;
				border-collapse: collapse;/*border-collapse:collapse合并内外边距(去除表格单元格默认的2个像素内外边距*/	
			}				
			th,td {
				height: 25px;
				line-height: 25px;
				text-align: center;
				border: 1px solid #ccc; /*网格线颜色*/
			}		
			th {
				background: #eee; /*表头颜色*/
				font-weight: normal;
			}		
			tr {
				background: #fff; /*表格中背景*/
			}		
			tr:hover {
				background: #66FFFF ;/*鼠标指向时颜色*/
			}		
			td a {
				color: #06f;
				text-decoration: none;
			}		
			td a:hover {
				color: #06f;
				text-decoration: underline;
			}
		</style>
<body>

<table class="table table-striped">
  <thead>
    <tr>
      
      <th>日期</th>
      <th>省份</th>
      <th>当前确诊</th>
      <th>新增确诊</th>
    </tr>
  </thead> <tbody>

<c:forEach items="${list}" var="in">  
    <tr>
      
      <td>${in.data}</td>
       <td>${in.sheng}</td>
        <td>${in.now}名</td>
        <td>${in.ad}名</td>
         
    </tr>
    </c:forEach> 

  </tbody>
</table>


    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 2000px;height:400px;"></div>
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
				data:${json.guonei}   
            },
            yAxis: {},
            series: [{
                name: '患者数量',
                type: 'bar',
				data:${json.guonei}
            }]
        };
 
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>