<%@ page contentType="text/html; charset=Big5"%>
<%@ page import="com.rest.model.*"%>
<%
RestVO restVO = (RestVO) request.getAttribute("restVO"); //restServlet.java(Concroller), �s�Jreq��restVO����
%>
<html>
<head>
<title>���u��� - listOnerest.jsp</title>
</head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='600'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>���u��� - ListOnerest.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a>
		</td>
	</tr>
</table>

<table border='1' bordercolor='#CCCCFF' width='600'>
	<tr>
		<th>���u�s��</th>
		<th>���u�m�W</th>
		<th>¾��</th>
		<th>���Τ��</th>
		<th>�~��</th>
		<th>����</th>
		<th>����</th>
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
