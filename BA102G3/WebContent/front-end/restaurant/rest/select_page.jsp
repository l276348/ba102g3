<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>IBM rest: Home</title></head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>IBM rest: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for IBM rest: Home</p>

<h3>��Ƭd��:</h3>
<%-- ���~��C --%>
<c:if test="${not restty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<ul>
  <li><a href='listAllrest1_byDAO.jsp'>List</a> all rests<font color=blue>(byDAO).</font> </li>
  <li><a href='rest.do?action=getAll'>List</a>  all rests<font color=blue>(getFromSession).</font> </li><br><br>
  
  <li>
    <FORM METHOD="post" ACTION="rest.do" >
        <b>��J���u�s�� (�p7001):</b>
        <input type="text" name="restno">
        <input type="submit" value="�e�X"><font color=blue>(��Ʈ榡����  by Controller ).</font> 
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  
  <li>
    <FORM METHOD="post" ACTION="rest.do" name="form1">
        <b>��J���u�s�� (�p7001):</b>
        <input type="text" name="restno">
        <input type="button" value="�e�X" onclick="fun1()"><font color=blue>(��Ʈ榡����  by Java Script).</font> 
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="dao" scope="page" class="com.rest.model.RestDAO" />
   
  <li>
     <FORM METHOD="post" ACTION="rest.do" >
       <b>��ܭ��u�s��:</b>
       <select size="1" name="restno">
         <c:forEach var="restVO" items="${dao.all}" > 
          <option value="${restVO.restno}">${restVO.restno}
         </c:forEach>   
       </select>
       <input type="submit" value="�e�X">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="rest.do" >
       <b>��ܭ��u�m�W:</b>
       <select size="1" name="restno">
         <c:forEach var="restVO" items="${dao.all}" > 
          <option value="${restVO.restno}">${restVO.ename}
         </c:forEach>   
       </select>
       <input type="submit" value="�e�X">
       <input type="hidden" name="action" value="getOne_For_Display">
     </FORM>
  </li>
</ul>

<script>    
   function fun1(){
      with(document.form1){
         if (restno.value=="") 
             alert("�п�J���u�s��!");
         else if (isNaN(restno.value)) 
             alert("���u�s���榡�����T!");
         else if (Restno.value < 7001 || restno.value > 7999) 
             alert("�ж�g����7001�M7999�������ƶq!");
         else
             submit();
      }
   }
</script>

</body>

</html>
