
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head><title>Companies-Title</title></head>
<body>
<H1 align="center">COMPANY LIST</H1>
<hr>

<%------------------------------------<<    T A B L E    >>-------------------------------------------------%>
<table border="2" cellpadding="10" cellspacing="1" align="center">
    <thead><%--  head --%>
    <tr style="background-color: aquamarine">
        <th>Company Name</th>
        <th>Founder</th>

        <th>Specialization</th>
        <th>Creation date</th>

        <th>Team</th>
        <th>Parent</th>


    </tr>
    </thead>
    <%------------------------------------<<    R O W    >>-------------------------------------------------%>
    <c:forEach var="companies" items="${list}">
        <jsp:useBean id="companies" scope="page" type="entities.CompanyEntity"/>

        <tr align="center" style="background-color:${flight.directionType ? '#dcdcdc' : ''}">
            <td><p>${companies.companyName}</p></td>
            <td><p>${companies.companyFounder}</p></td>
            <td><p>${companies.companySpecialization}</p></td>
            <td><p>${companies.companyCreationDate}</p></td>
            <td><p>${companies.companyTeamNumber}</p></td>
            <td><p>${companies.companyParent}</p></td>



           <%-- <td><a href="update?action=update&id=${flight.id}">Update</a></td>
            <td><a href="info?action=delete&id=${flight.id}">Delete</a></td>--%>
        </tr>
    </c:forEach>
</table>
<%--  << TABLE  --%>


</body>
</html>