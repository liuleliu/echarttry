<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<frameset cols="25%,50%,25%" noresize="noresize" frameborder="0"  >
    
     <frame src="left.jsp" name="leftframe">
  <frameset rows="75%,25%" noresize="noresize" frameborder="0" >
    <frame src="winfo.jsp" name="leftframe">      
    <frame src="bottom.jsp"    name="rightframe" >  
  </frameset>
  <frameset rows="70%,30%" noresize="noresize" frameborder="0"  >
  <frameset cols="50%,50%" noresize="noresize" frameborder="0" >
    <frame src="right1.jsp"    name="rightframe" >      
    <frame src="right2.jsp"    name="rightframe" > 
  </frameset>
   <frame src="zhexain.jsp"    name="rightframe" > 
  </frameset>
</frameset>
</html>