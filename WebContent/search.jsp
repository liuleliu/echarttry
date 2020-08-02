<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="search" name=form1 method="post" onsubmit="return check(form1)" target='down'>
	<div style="text-align:center; ">
	 <input type="text"  id='text1' name="nian" value="2020" /><font size="4" face="黑体">年 </font>
	  <input type="text"  id='text1' name="yue" value="3" /><font size="4" face="黑体"> 月 </font>
	<input type="text"  id='text1' name="ri" value="3" /><font size="4" face="黑体"> 日 </font>
	
	<br/>
	<input type="submit" value="查找"  style= "height:30px;width:150px;background:#0066FF " onclick="show()"/>
	
	</div>
	
	
</form>
</body>
</html>