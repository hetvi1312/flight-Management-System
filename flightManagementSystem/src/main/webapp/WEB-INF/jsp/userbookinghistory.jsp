<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Booking History</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/styles.css'/>">
</head>
<body>
    <h1>User Booking History</h1>
    
    <c:if test="${not empty tickets}">
        <table border="1">
            <thead>
                <tr>
                    <th>Ticket Number</th>
                    <th>Flight Number</th>
                    <th>Carrier Name</th>
                    <th>Booking Date</th>
                    <th>Total Amount</th>
                    <th>Details</th>
                    <th>Cancel</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ticket" items="${tickets}">
                    <tr>
                        <td><c:out value="${ticket.ticketNumber}"/></td>
                        <td><c:out value="${ticket.flightNumber}"/></td>
                        <td><c:out value="${ticket.carrierName}"/></td>
                        <td><c:out value="${ticket.bookingDate}"/></td>
                        <td><c:out value="${ticket.totalAmount}"/></td>
                        <td><a href="<c:url value='/ticket-details/${ticket.ticketNumber}'/>">View Details</a></td>
                        <td><a href="<c:url value='/cancel-ticket?ticketNumber=${ticket.ticketNumber}'/>" onclick="return confirm('Are you sure you want to cancel this ticket?')">Cancel</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty tickets}">
        <p>No booking history found.</p>
    </c:if>
    
</body>
</html>
