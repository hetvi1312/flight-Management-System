<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header1.jsp" %>

<!-- about breadcrumb -->
<section class="w3l-about-breadcrumb text-left">
    <div class="breadcrumb-bg breadcrumb-bg-about py-sm-5 py-4">
        <div class="container py-2">
            <h2 class="title">Ticket History</h2>
            <ul class="breadcrumbs-custom-path mt-2">
                <li><a href="/index1">Home</a></li>
                <li class="active"><span class="fa fa-arrow-right mx-2" aria-hidden="true"></span> Ticket History</li>
            </ul>
        </div>
    </div>
</section>
<!-- //about breadcrumb -->

<!-- ticket history -->
<section class="w3l-grids-3 py-5">
    <div class="container py-md-3">
        <div class="title-content text-left mb-lg-5 mb-4">
            <h5>Ticket History</h5>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Ticket Number</th>
                        <th>Flight Number</th>
                        <th>Carrier Name</th>
                        <th>Route ID</th>
                        <th>Total Amount</th>
                        
                        <th>Actions</th> <!-- New column for actions -->
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ticket" items="${tickets}">
                        <tr>
                            <td>${ticket.ticketNumber}</td>
                            <td>${ticket.flightNumber}</td>
                            <td>${ticket.carrierName}</td>
                            <td>${ticket.routeId}</td>
                            <td>${ticket.totalAmount}</td>
                           
                            <td>
                                <!-- Link to view details of each ticket -->
                                <a href="/ticketDetails?ticketNumber=${ticket.ticketNumber}" class="btn btn-primary">View Details</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>
<!-- //ticket history -->

<%@ include file="footer2.jsp" %>
