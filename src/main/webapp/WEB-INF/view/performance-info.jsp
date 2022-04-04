<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>New Performance</h2>
<br>


<form:form action="saveNewPerformance" modelAttribute="performance">

    <form:hidden path="id"/>


    Title <form:input path="title"/>
    <br><br>
    Date adn time <form:input path="dateAndTime"/>
    <br><br>
    Age category <form:input path="ageCategory"/>
    <br><br>
    Price group1 <form:input path="ticketPrice1"/>
    <br><br>
    Price group2 <form:input path="ticketPrice2"/>
    <br><br>
    Price group3 <form:input path="ticketPrice3"/>
    <br><br>
    <input type="submit" value="OK">


</form:form>

</body>
</html>