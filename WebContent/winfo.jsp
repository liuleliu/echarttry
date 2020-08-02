<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
	<script src="http://gallery.echartsjs.com/dep/echarts/map/js/world.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
</head>
<body style="background-color:#4F4F4F;">
<br>
  <button type="button" onclick='go()'  class="btn btn-primary">刷新</button>
<div id="main" style="width: 600px;height:400px;"></div>
</body>
   <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        $(document).ready(function(){
	go();
    
   });
        var myChart = echarts.init(document.getElementById('main'));
 
     
        
        function go() {
        	
        	
            $.ajax({
                type : "POST",  //请求方式
                url : "winfo",  //请求路径
                data : {  //请求参数
                
                },
                success : function(msg) {  //异步请求成功执行的回调函数
                   
                	da=JSON.parse(msg);
                	 
                    var option = {
                    	    title: {
                    	        
                    	        
                    	        sublink: 'http://esa.un.org/wpp/Excel-Data/population.htm',
                    	        left: 'center',
                    	        top: 'top'
                    	    },
                    		   tooltip: {
                	        trigger: 'item',
                	        formatter: function (params) {
                	          
                	            return params.name + ' : ' +  params.value+"名";
                	        }
                	    },
                    	   /* tooltip: {
                    	        trigger: 'item',
                    	        formatter: function (params) {
                    	            var value = (params.value + '').split('.');
                    	            value = value[0].replace(/(\d{1,3})(?=(?:\d{3})+(?!\d))/g, '$1,')
                    	                    + '.' + value[1];
                    	            return params.seriesName + '<br/>' + params.name + ' : ' + value;
                    	        }
                    	    },*/
                    	   
                    	    visualMap: {
                    	        min: 0,
                    	        max: 300000,
                    	        text:['High','Low'],
                    	        realtime: false,
                    	        calculable: true,
                    	        color: ['red','orange','skyblue']
                    	    },
                    	   
                    	    	 toolbox: {
                    	    	        show : true,
                    	    	        orient : 'vertical',
                    	    	        x: 'right',
                    	    	        y: 'center',
                    	    	        feature : {
                    	    	            mark : {show: true},
                    	    	            dataView : {show: true, readOnly: false},
                    	    	            restore : {show: true},
                    	    	            saveAsImage : {show: true}
                    	    	        }
                    	    	    },
                    	    series: [
                    	        {
                    	            name: '世界疫情',
                    	            type: 'map',
                    	            mapType: 'world',
                    	            roam: true,
                    	            itemStyle:{
                    	                emphasis:{label:{show:true}}
                    	            },
                    	    
                    	            nameMap:{
                    	                'Singapore Rep.':'新加坡',
                    	                'Dominican Rep.':'多米尼加',
                    	                'Palestine':'巴勒斯坦',
                    	                'Bahamas':'巴哈马',
                    	                'Timor-Leste':'东帝汶',
                    	               'Afghanistan':'阿富汗',
                    	               'Guinea-Bissau':'几内亚比绍',
                    	               "Côte d'Ivoire":'科特迪瓦',
                    	               'Siachen Glacier':'锡亚琴冰川',
                    	               "Br. Indian Ocean Ter.":'英属印度洋领土',
                    	               'Angola':'安哥拉',
                    	               'Albania':'阿尔巴尼亚',
                    	               'United Arab Emirates':'阿联酋',
                    	               'Argentina':'阿根廷',
                    	               'Armenia':'亚美尼亚',
                    	               'French Southern and Antarctic Lands':'法属南半球和南极领地',
                    	               'Australia':'澳大利亚',
                    	               'Austria':'奥地利',
                    	               'Azerbaijan':'阿塞拜疆',
                    	               'Burundi':'布隆迪',
                    	               'Belgium':'比利时',
                    	               'Benin':'贝宁',
                    	               'Burkina Faso':'布基纳法索',
                    	               'Bangladesh':'孟加拉国',
                    	               'Bulgaria':'保加利亚',
                    	               'The Bahamas':'巴哈马',
                    	               'Bosnia and Herz.':'波斯尼亚和黑塞哥维那',
                    	               'Belarus':'白俄罗斯',
                    	               'Belize':'伯利兹',
                    	               'Bermuda':'百慕大',
                    	               'Bolivia':'玻利维亚',
                    	               'Brazil':'巴西',
                    	               'Brunei':'文莱',
                    	               'Bhutan':'不丹',
                    	               'Botswana':'博茨瓦纳',
                    	               'Central African Rep.':'中非',
                    	               'Canada':'加拿大',
                    	               'Switzerland':'瑞士',
                    	               'Chile':'智利',
                    	               'China':'中国',
                    	               'Ivory Coast':'象牙海岸',
                    	               'Cameroon':'喀麦隆',
                    	               'Dem. Rep. Congo':'刚果民主共和国',
                    	               'Congo':'刚果',
                    	               'Colombia':'哥伦比亚',
                    	               'Costa Rica':'哥斯达黎加',
                    	               'Cuba':'古巴',
                    	               'N. Cyprus':'北塞浦路斯',
                    	               'Cyprus':'塞浦路斯',
                    	               'Czech Rep.':'捷克',
                    	               'Germany':'德国',
                    	               'Djibouti':'吉布提',
                    	               'Denmark':'丹麦',
                    	               'Algeria':'阿尔及利亚',
                    	               'Ecuador':'厄瓜多尔',
                    	               'Egypt':'埃及',
                    	               'Eritrea':'厄立特里亚',
                    	               'Spain':'西班牙',
                    	               'Estonia':'爱沙尼亚',
                    	               'Ethiopia':'埃塞俄比亚',
                    	               'Finland':'芬兰',
                    	               'Fiji':'斐',
                    	               'Falkland Islands':'福克兰群岛',
                    	               'France':'法国',
                    	               'Gabon':'加蓬',
                    	               'United Kingdom':'英国',
                    	               'Georgia':'格鲁吉亚',
                    	               'Ghana':'加纳',
                    	               'Guinea':'几内亚',
                    	               'Gambia':'冈比亚',
                    	               'Guinea Bissau':'几内亚比绍',
                    	               'Eq. Guinea':'赤道几内亚',
                    	               'Greece':'希腊',
                    	               'Greenland':'格陵兰',
                    	               'Guatemala':'危地马拉',
                    	               'French Guiana':'法属圭亚那',
                    	               'Guyana':'圭亚那',
                    	               'Honduras':'洪都拉斯',
                    	               'Croatia':'克罗地亚',
                    	               'Haiti':'海地',
                    	               'Hungary':'匈牙利',
                    	               'Indonesia':'印度尼西亚',
                    	               'India':'印度',
                    	               'Ireland':'爱尔兰',
                    	               'Iran':'伊朗',
                    	               'Iraq':'伊拉克',
                    	               'Iceland':'冰岛',
                    	               'Israel':'以色列',
                    	               'Italy':'意大利',
                    	               'Jamaica':'牙买加',
                    	               'Jordan':'约旦',
                    	               'Japan':'日本',
                    	               'Kazakhstan':'哈萨克斯坦',
                    	               'Kenya':'肯尼亚',
                    	               'Kyrgyzstan':'吉尔吉斯斯坦',
                    	               'Cambodia':'柬埔寨',
                    	               'Korea':'韩国',
                    	               'Kosovo':'科索沃',
                    	               'Kuwait':'科威特',
                    	               'Lao PDR':'老挝',
                    	               'Lebanon':'黎巴嫩',
                    	               'Liberia':'利比里亚',
                    	               'Libya':'利比亚',
                    	               'Sri Lanka':'斯里兰卡',
                    	               'Lesotho':'莱索托',
                    	               'Lithuania':'立陶宛',
                    	               'Luxembourg':'卢森堡',
                    	               'Latvia':'拉脱维亚',
                    	               'Morocco':'摩洛哥',
                    	               'Moldova':'摩尔多瓦',
                    	               'Madagascar':'马达加斯加',
                    	               'Mexico':'墨西哥',
                    	               'Macedonia':'马其顿',
                    	               'Mali':'马里',
                    	               'Myanmar':'缅甸',
                    	               'Montenegro':'黑山',
                    	               'Mongolia':'蒙古',
                    	               'Mozambique':'莫桑比克',
                    	               'Mauritania':'毛里塔尼亚',
                    	               'Malawi':'马拉维',
                    	               'Malaysia':'马来西亚',
                    	               'Namibia':'纳米比亚',
                    	               'New Caledonia':'新喀里多尼亚',
                    	               'Niger':'尼日尔',
                    	               'Nigeria':'尼日利亚',
                    	               'Nicaragua':'尼加拉瓜',
                    	               'Netherlands':'荷兰',
                    	               'Norway':'挪威',
                    	               'Nepal':'尼泊尔',
                    	               'New Zealand':'新西兰',
                    	               'Oman':'阿曼',
                    	               'Pakistan':'巴基斯坦',
                    	               'Panama':'巴拿马',
                    	               'Peru':'秘鲁',
                    	               'Philippines':'菲律宾',
                    	               'Papua New Guinea':'巴布亚新几内亚',
                    	               'Poland':'波兰',
                    	               'Puerto Rico':'波多黎各',
                    	               'Dem. Rep. Korea':'朝鲜',
                    	               'Portugal':'葡萄牙',
                    	               'Paraguay':'巴拉圭',
                    	               'Qatar':'卡塔尔',
                    	               'Romania':'罗马尼亚',
                    	               'Russia':'俄罗斯',
                    	               'Rwanda':'卢旺达',
                    	               'W. Sahara':'西撒哈拉',
                    	               'Saudi Arabia':'沙特阿拉伯',
                    	               'Sudan':'苏丹',
                    	               'S. Sudan':'南苏丹',
                    	               'Senegal':'塞内加尔',
                    	               'Solomon Is.':'所罗门群岛',
                    	               'Sierra Leone':'塞拉利昂',
                    	               'El Salvador':'萨尔瓦多',
                    	               'Somaliland':'索马里兰',
                    	               'Somalia':'索马里',
                    	               'Serbia':'塞尔维亚',
                    	               'Suriname':'苏里南',
                    	               'Slovakia':'斯洛伐克',
                    	               'Slovenia':'斯洛文尼亚',
                    	               'Sweden':'瑞典',
                    	               'Swaziland':'斯威士兰',
                    	               'Syria':'叙利亚',
                    	               'Chad':'乍得',
                    	               'Togo':'多哥',
                    	               'Thailand':'泰国',
                    	               'Tajikistan':'塔吉克斯坦',
                    	               'Turkmenistan':'土库曼斯坦',
                    	               'East Timor':'东帝汶',
                    	               'Trinidad and Tobago':'特里尼达和多巴哥',
                    	               'Tunisia':'突尼斯',
                    	               'Turkey':'土耳其',
                    	               'Tanzania':'坦桑尼亚',
                    	               'Uganda':'乌干达',
                    	               'Ukraine':'乌克兰',
                    	               'Uruguay':'乌拉圭',
                    	               'United States':'美国',
                    	               'Uzbekistan':'乌兹别克斯坦',
                    	               'Venezuela':'委内瑞拉',
                    	               'Vietnam':'越南',
                    	               'Vanuatu':'瓦努阿图',
                    	               'West Bank':'西岸',
                    	               'Yemen':'也门',
                    	               'South Africa':'南非',
                    	               'Zambia':'赞比亚',
                    	               'Zimbabwe':'津巴布韦'
                    	            },

                    	            data:da.world
                    	               
                    	        }
                    	    ]
                    	};
                    var myChart = echarts.init(document.getElementById('main'));
                    myChart.setOption(option);
                
                   
                },//ajax引擎一般用不到；状态信息；抛出的异常信息
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(textStatus);
                    alert("数据加载失败了"+errorThrown)
                }
            });
        }
        
    </script>
</html>