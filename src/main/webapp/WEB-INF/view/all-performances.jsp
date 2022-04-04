<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<body>

<h2>All performances:</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Date and time</th>
        <th>Age category</th>
        <th>Price group1</th>
        <th>Price group2</th>
        <th>Price group3</th>
        <th>Number of seats</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="perf" items="${allPerformance}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="perfId" value="${perf.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deletePerformance">
            <c:param name="perfId" value="${perf.id}"/>
        </c:url>

        <c:url var="viewAllTickets" value="/viewAllTickets">
            <c:param name="perfId" value="${perf.id}"/>
        </c:url>

        <tr>
            <td>${perf.title}</td>
            <td>${perf.dateAndTime}</td>
            <td>${perf.ageCategory}</td>
            <td>${perf.ticketPrice1}</td>
            <td>${perf.ticketPrice2}</td>
            <td>${perf.ticketPrice3}</td>
            <td>${perf.numberOfSeats}</td>

            <td>
                <security:authorize access="hasRole('ADMIN')">
                <input type="button" value="Update"
                       onClick="window.location.href='${updateButton}'"/>

                <input type="button" value="Delete"
                       onClick="window.location.href='${deleteButton}'"/>
                </security:authorize>

                <input type="button" value="View all tickets"
                       onClick="window.location.href='${viewAllTickets}'"/>
            </td>
        </tr>

    </c:forEach>

</table>
<br>
<br>
<security:authorize access="hasRole('ADMIN')">
<input type="button" value="Add"
       onclick="window.location.href = 'addNewPerformance'"/>
</security:authorize>
<br>
<br>
<input type="button" value="Registration"
       onclick="window.open('http://localhost:8080/spring_course_security/login')"/>

<%--<a href="http://localhost:8080/spring_course_security/registration" >Registration</a>--%>
</body>
</html>