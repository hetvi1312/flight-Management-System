<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<div class="pcoded-content">

    <!-- Page-header start -->
    <div class="page-header">
        <div class="page-block">
            <div class="row align-items-center">
                <div class="col-md-8">
                    <div class="page-header-title">
                        <h5 class="m-b-10">Flight Search Results</h5>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="dashboard.html"><i class="fa fa-home"></i></a>
                        </li>
                        <li class="breadcrumb-item"><a href="#">Flight</a></li>
                        <li class="breadcrumb-item"><a href="#">Flight Search Results</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- Page-header end -->

    <div class="pcoded-inner-content">
      <c:if test="${empty flightList}">
        <p>No flights available for the selected route.</p>
    </c:if>
            <div class="page-wrapper">
                <div class="page-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5>Flight Report</h5>
                                    <div class="card-header-right">
                                        <ul class="list-unstyled card-option">
                                            <li><i class="fa fa fa-wrench open-card-option"></i></li>
                                            <li><i class="fa fa-window-maximize full-card"></i></li>
                                            <li><i class="fa fa-minus minimize-card"></i></li>
                                            <li><i class="fa fa-refresh reload-card"></i></li>
                                            <li><i class="fa fa-trash close-card"></i></li>
                                        </ul>
                                    </div>
                                </div>

<div class="card-block">
 <h4>Flight Search Results</h4>
   <h3>The Flights in the Route: ${fromAirport} to ${toAirport}</h3>
    <h4>Air Fare: ${fair}</h4>
     <br/>
          <div class="card-block table-border-style">
                                    <div class="table-responsive">                          
    <c:if test="${not empty flightList}">
      
                                        <table class="table table-hover">
                                            <thead>
                <tr>
                    <th>Flight Number</th>
                    <th>Airlines Name</th>
                    <th>Route Id</th>
                      <th>Departure</th>
                     <th>Arrival</th>
                     <th>Book Flight</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="flight" items="${flightList}">
                    <tr>
                        <td>${flight.flightNumber}</td>
                        <td>${flight.carrierName}</td>
                        <td>${flight.routeId}</td>
                        <td>${flight.departure}</td>
                        <td>${flight.arrival}</td>
                         <td><a href="#" class="btn btn-secondary btn-sm" >Booking</a></td>
                      
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
   
                                    <a href="/flight-search" class="btn btn-secondary">Back</a>
                                </div>
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