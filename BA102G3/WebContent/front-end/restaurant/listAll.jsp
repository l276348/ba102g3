<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rest.model.*"%>
<%
    RestDAO dao = new RestDAO();
    List<RestVO> list = dao.getAll();
    pageContext.setAttribute("list",list);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<table border='1' bordercolor='#CCCCFF' >
	<tr>
		<th>�\�U�s��</th>
		<th>�ϥΪ̩m�W</th>
		<th width='70'>�\�U�W�r</th>
		<th>�a�}</th>
		<th>�q��</th>
		<th>����</th>
	</tr>
	
	<c:forEach var="restVO" items="${list}">
		<tr align='center' valign='middle'}>
			<td>${restVO.rest_id}</td>
			<td>${restVO.user_id}</td>
			<td>${restVO.rest_name}</td>
			<td>${restVO.rest_address}</td>
			<td>${restVO.rest_phone}</td>
			<td>${restVO.rest_detail}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>