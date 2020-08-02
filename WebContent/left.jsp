<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
   <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<script>


      
</script>
<body style="background-color:#4F4F4F;">
<font size="2" face="黑体" color="black" >当前累计确诊：</font><font id='f' size="3" face="黑体" color="red" ></font>
 <table  >


<thead>
    <tr>
      
      <th>国家</th>
      <th>当前确诊数量</th>
     
    </tr>
  </thead> 
  <tbody id='op'>


  </tbody>
</table>



</body>
<script>
$(document).ready(function(){
	go();
   
   });
function go(){
$.ajax({
    type : "POST",  //请求方式
    url : "deadnum",  //请求路径
    data : {  //请求参数
    
    },
    success : function(msg) {  //异步请求成功执行的回调函数
    	
    	y=msg.substring(1,msg.length-1).split(',');
    	da=JSON.parse(msg);
    	y=da.data;
    	for(i=0;i<y.length;i++)
    	{
    	    $('#op').append('<tr><td><font size="2" face="黑体" color="black" >'+y[i].country+'</font></td><td><font size="2" face="黑体" color="red" >'+y[i].num+'</font></td></tr>');
    	}
    	$('#f').append(da.num);
   
    },//ajax引擎一般用不到；状态信息；抛出的异常信息
    error : function(XMLHttpRequest, textStatus, errorThrown) {
      
    }
});
   }
</script>
</html>