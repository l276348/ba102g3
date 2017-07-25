<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rest.model.*"%>

<%
 // List<restVO> list = (List<restVO>)session.getAttribute("list"); //restServlet.java(Concroller), 存入session的list物件
%> 

<%-- 以下等同第7行--%>
<jsp:useBean id="list" scope="session" type="java.util.List" />


<html>
<head>
<title>所有員工資料 - listAllrest2_getFromSession.jsp</title>
</head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='700'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>所有員工資料共<font color=red><%=list.size()%></font>筆 - listAllrest2_getFromSession.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>

<table border='1' bordercolor='#CCCCFF' width='700'>
	<tr>
		<th>餐廳編號</th>
		<th>會員編號</th>
		<th>餐廳名稱</th>
		<th>地址</th>
		<th>電話</th>
		<th>交通資訊</th>
		<th>餐廳介紹</th>
		<th>營業時間</th>
		<th>所在航廈</th>
		<th>所在樓層</th>
		<th>所在經度</th>
		<th>所在緯度</th>
		<th>所在出入境位置</th>
		<th>餐廳種類</th>
		<th>餐廳被評分次數</th>
		<th>評分總分</th>
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
