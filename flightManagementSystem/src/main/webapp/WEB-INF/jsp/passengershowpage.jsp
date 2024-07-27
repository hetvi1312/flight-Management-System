<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<html>
<head>
    <title>Passenger Details</title>
</head>
<body>
    <div class="pcoded-content">
        <div class="page-header">
            <div class="page-block">
                <div class="row align-items-center">
                    <div class="col-md-8">
                        <div class="page-header-title">
                            <h5 class="m-b-10">Passenger Details</h5>
                        </div>
                    </div>
                    
                    <div class="col-md-4">
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/index"><i class="fa fa-home"></i></a></li>
                            <li class="breadcrumb-item"><a href="#">Passenger</a></li>
                            <li class="breadcrumb-item"><a href="#">Passenger Details</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="pcoded-inner-content">
            <div class="main-body">
                <div class="page-wrapper">
                    <div class="page-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h5>Passenger Details</h5>
                                    </div>
                                    <div class="card-block">
                                            <h6>Passenger Information</h6>
                                            <p>Ticket Number: <span>${passenger.embeddedId.ticketNumber}</span></p>
                                            <p>Serial Number: <span>${passenger.embeddedId.serialNumber}</span></p>
                                            <p>Name: <span>${passenger.passenegerName}</span></p>
                                            <p>Date of Birth: <span>${passenger.passengerDOB}</span></p>
                                            <p>Fare: <span>${passenger.fare}</span></p>
                                       
                                        <c:if test="${errorMessage != null}">
                                            <p>${errorMessage}</p>
                                        </c:if>

                                        <a href="/passenger-report" class="btn btn-secondary">Back</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
