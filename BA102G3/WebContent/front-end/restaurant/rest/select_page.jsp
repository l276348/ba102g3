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

<h3>資料查詢:</h3>
<%-- 錯誤表列 --%>
<c:if test="${not restty errorMsgs}">
	<font color='red'>請修正以下錯誤:
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
        <b>輸入員工編號 (如7001):</b>
        <input type="text" name="restno">
        <input type="submit" value="送出"><font color=blue>(資料格式驗證  by Controller ).</font> 
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  
  <li>
    <FORM METHOD="post" ACTION="rest.do" name="form1">
        <b>輸入員工編號 (如7001):</b>
        <input type="text" name="restno">
        <input type="button" value="送出" onclick="fun1()"><font color=blue>(資料格式驗證  by Java Script).</font> 
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="dao" scope="page" class="com.rest.model.RestDAO" />
   
  <li>
     <FORM METHOD="post" ACTION="rest.do" >
       <b>選擇員工編號:</b>
       <select size="1" name="restno">
         <c:forEach var="restVO" items="${dao.all}" > 
          <option value="${restVO.restno}">${restVO.restno}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="rest.do" >
       <b>選擇員工姓名:</b>
       <select size="1" name="restno">
         <c:forEach var="restVO" items="${dao.all}" > 
          <option value="${restVO.restno}">${restVO.ename}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
     </FORM>
  </li>
</ul>

<script>    
   function fun1(){
      with(document.form1){
         if (restno.value=="") 
             alert("請輸入員工編號!");
         else if (isNaN(restno.value)) 
             alert("員工編號格式不正確!");
         else if (Restno.value < 7001 || restno.value > 7999) 
             alert("請填寫介於7001和7999之間的數量!");
         else
             submit();
      }
   }
</script>

</body>

</html>
