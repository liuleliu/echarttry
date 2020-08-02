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
      <!-- 包含头部信息用于适应不同设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
</head>

<body>

 <table class="table table-striped table-bordered">
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
                data: ["山东","广东","浙江","江苏","河南","四川","湖北","湖南","河北","福建","上海","北京","安徽","辽宁","陕西","江西","重庆","广西","天津","云南","内蒙古","黑龙江","山西","吉林","贵州","新疆","甘肃","海南","宁夏","青海","西藏"]
   
            },
            yAxis: {},
            series: [{
                name: '患者数量',
                type: 'bar',
                data: [${info.shandong}, ${info.guangdong}, ${info.zhejinag}, ${info.jiangsu},${info.henan},${info.sichuan},${info.hubei},${info.hunan},${info.hebei},${info.fujian},${info.shanghai},${info.beijing},${info.anhui},${info.shanxi},${info.jiangxi},${info.chongqing},${info.guangxi},${info.tianjin},${info.yunnan},${info.neimenggu},${info.heilongjiang},${info.xishan},${info.jilin},${info.guizhou},${info.xinjiang},${info.ganxu},${info.hainan},${info.ningxia},${info.qinghai},${info.xizang}]
            }]
        };
 
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>