<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rest.model.*"%>

<%
 // List<restVO> list = (List<restVO>)session.getAttribute("list"); //restServlet.java(Concroller), �s�Jsession��list����
%> 

<%-- �H�U���P��7��--%>
<jsp:useBean id="list" scope="session" type="java.util.List" />


<html>
<head>
<title>�Ҧ����u��� - listAllrest2_getFromSession.jsp</title>
</head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='700'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>�Ҧ����u��Ʀ@<font color=red><%=list.size()%></font>�� - listAllrest2_getFromSession.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a>
		</td>
	</tr>
</table>

<table border='1' bordercolor='#CCCCFF' width='700'>
	<tr>
		<th>�\�U�s��</th>
		<th>�|���s��</th>
		<th>�\�U�W��</th>
		<th>�a�}</th>
		<th>�q��</th>
		<th>��q��T</th>
		<th>�\�U����</th>
		<th>��~�ɶ�</th>
		<th>�Ҧb��H</th>
		<th>�Ҧb�Ӽh</th>
		<th>�Ҧb�g��</th>
		<th>�Ҧb�n��</th>
		<th>�Ҧb�X�J�Ҧ�m</th>
		<th>�\�U����</th>
		<th>�\�U�Q��������</th>
		<th>�����`��</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="restVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle'>
			<td>${RestVO.rest_id}</td>
			<td>${RestVO.rest_id}</td>
			<td>${RestVO.user_id}</td>
			<td>${RestVO.rest_name}</td>
			<td>${RestVO.rest_address}</td>
			<td>${RestVO.rest_phone}</td>
			<td>${RestVO.rest_trans}</td>
			<td>${RestVO.rest_detail}</td>
			<td>${RestVO.rest_hours}</td>
			<td>${RestVO.rest_ter}</td>
			<td>${RestVO.rest_floor}</td>
			<td>${RestVO.rest_lon}</td>
			<td>${RestVO.rest_lat}</td>
			<td>${RestVO.rest_inout}</td>
			<td>${RestVO.rest_type}</td>
			<td>${RestVO.rest_count}</td>
			<td>${RestVO.rest_type}</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>
