<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header1.jsp" %>

<!-- about breadcrumb -->
<section class="w3l-about-breadcrumb text-left">
    <div class="breadcrumb-bg breadcrumb-bg-about py-sm-5 py-4">
        <div class="container py-2">
            <h2 class="title">Ticket Details</h2>
            <ul class="breadcrumbs-custom-path mt-2">
                <li><a href="/index1">Home</a></li>
                <li class="active"><span class="fa fa-arrow-right mx-2" aria-hidden="true"></span> Ticket Details</li>
            </ul>
        </div>
    </div>
</section>
<!-- //about breadcrumb -->

<!-- ticket details -->
<section class="w3l-grids-3 py-5">
    <div class="container py-md-3">
        <div class="title-content text-left mb-lg-5 mb-4">
            <h5>Ticket Details</h5>
            <div class="row">
                <div class="col-md-4">
                    <div class="dst-btm">
                        <h6>Ticket Number:</h6>
                        <span>${ticket.ticketNumber}</span>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="dst-btm">
                        <h6>Flight Number:</h6>
                        <span>${ticket.flightNumber}</span>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="dst-btm">
                        <h6>Carrier Name:</h6>
                        <span>${ticket.carrierName}</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="dst-btm">
                        <h6>From City:</h6>
                        <span>${fromCity}</span>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="dst-btm">
                        <h6>To City:</h6>
                        <span>${toCity}</span>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="dst-btm">
                        <h6>Booking Date:</h6>
                        <span>${bookingDate}</span>
                    </div>
                </div>
            </div>

            <h3>Passenger Details</h3>
            <c:forEach var="passenger" items="${passengerList}">
                <div class="row">
                    <div class="col-md-4">
                        <div class="dst-btm">
                            <h6>Serial Number:</h6>
                            <span>${passenger.embeddedId.serialNumber}</span>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="dst-btm">
                            <h6>Passenger Name:</h6>
                            <p>${passenger.passenegerName}</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="dst-btm">
                            <h6>Date of Birth:</h6>
                            <p>${passenger.passengerDOB}</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="dst-btm">
                            <h6>Fare:</h6>
                            <p>${passenger.fare}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <div class="row">
                <div class="col-md-4">
                    <div class="dst-btm">
                        <h6>Total Amount:</h6>
                        <span>${ticket.totalAmount}</span>
                    </div>
                </div>
            </div>
            <a href="/flight-search" class="btn btn-secondary">Return to Home</a>
             <a href="/cancelTicket?ticketNumber=${ticket.ticketNumber}" class="btn btn-secondary" onclick="return confirm('Are you sure you want to cancel the booking?');">Cancel Ticket</a>
        </div>
    </div>
</section>



<%@ include file="footer2.jsp" %>
