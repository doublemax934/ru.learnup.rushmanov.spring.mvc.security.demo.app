<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>

<h2>All performances:</h2>
<br>

<table>
    <tr>
        <th>Title</th>
        <th>Price</th>
        <th>Status</th>
        <th>Seat number</th>
        <th>Operations</th>

    </tr>
    <c:forEach var="ticket" items="${allTickets}">

        <c:url var="buyButton" value="/buyTicket">
            <c:param name="tickId" value="${ticket.id}"/>
            <c:param name="seatNumber" value="${ticket.seatNumber}"/>

        </c:url>

        <c:url var="returnButton" value="/refundTicket">
            <c:param name="tickId" value="${ticket.id}"/>
            <c:param name="seatNumber" value="${ticket.seatNumber}"/>
        </c:url>

        <tr>
            <td>${ticket.ticketTitle}</td>
            <td>${ticket.price}</td>
            <td>${ticket.status}</td>
            <td>${ticket.seatNumber}</td>
            <td>
                <security:authorize access="hasAnyRole('ADMIN', 'USER')">
                <input type="button" value="Buy ticket"
                       onClick="window.location.href='${buyButton}'"/>

                <input type="button" value="Return ticket"
                       onClick="window.location.href='${returnButton}'"/>
                </security:authorize>

            </td>

        </tr>

    </c:forEach>

</table>
<br>
<br>
<input type="button" value="On main page"
       onclick="window.open('http://localhost:8080/spring_course_security/')"/>
</body>
</html>