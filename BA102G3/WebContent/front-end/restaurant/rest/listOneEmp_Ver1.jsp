<%@ page contentType="text/html; charset=Big5"%>
<%@ page import="com.rest.model.*"%>
<%
RestVO restVO = (RestVO) request.getAttribute("restVO"); //restServlet.java(Concroller), 存入req的restVO物件
%>
<html>
<head>
<title>員工資料 - listOnerest.jsp</title>
</head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='600'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>員工資料 - ListOnerest.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>

<table border='1' bordercolor='#CCCCFF' width='600'>
	<tr>
		<th>員工編號</th>
		<th>員工姓名</th>
		<th>職位</th>
		<th>雇用日期</th>
		<th>薪水</th>
		<th>獎金</th>
		<th>部門</th>
	</tr>
	<tr align='center' valign='middle'>
		<td>${restVO.restno}</td>
		<td>${restVO.ename}</td>
		<td>${restVO.job}</td>
		<td>${restVO.hiredate}</td>
		<td>${restVO.sal}</td>
		<td>${restVO.comm}</td>
		<td>${restVO.deptno}</td>
	</tr>
	
	<tr align='center' valign='middle'>
		<td>${restVO.getrestno()}</td>
		<td>${restVO.getEname()}</td>
		<td>${restVO.getJob()}</td>
		<td>${restVO.getHiredate()}</td>
		<td>${restVO.getSal()}</td>
		<td>${restVO.getComm()}</td>
		<td>${restVO.getDeptno()}</td>
	</tr>
	
</table>

</body>
</html>
