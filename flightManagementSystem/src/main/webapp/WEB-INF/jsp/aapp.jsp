<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<div class="pcoded-content">
    <!-- Page-header start -->
    <div class="page-header">
        <div class="page-block">
            <div class="row align-items-center">
                <div class="col-md-8">
                    <div class="page-header-title">
                        <h5 class="m-b-10">Ticket Details</h5>
                        <p class="m-b-0"></p>
                    </div>
                </div>
                <div class="col-md-4">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="index.html"><i class="fa fa-home">Ticket</i></a>
                        </li>
                        <li class="breadcrumb-item"><a href="#!">Ticket Details</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- Page-header end -->
    <div class="pcoded-inner-content">
        <div class="main-body">
            <div class="page-wrapper">
                <div class="page-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5>Ticket Details</h5>
                                    <div class="card-header-right">
                                        <ul class="list-unstyled card-option">
                                            <li><i class="fa fa-wrench open-card-option"></i></li>
                                            <li><i class="fa fa-window-maximize full-card"></i></li>
                                            <li><i class="fa fa-minus minimize-card"></i></li>
                                            <li><i class="fa fa-refresh reload-card"></i></li>
                                            <li><i class="fa fa-trash close-card"></i></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-block table-border-style">
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>Ticket Number</th>
                                                <th>Flight Number</th>
                                         	    <th>Carrier Name</th>
                                                <th>From City</th>
                                                <th>To City</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>${ticket.ticketNumber}</td>
                                                <td>${ticket.flightNumber}</td>
                                           		 <td>${ticket.carrierName}</td>
                                                <td>${fromCity}</td>
                                                <td>${toCity}</td>
                                                </tr>
                                        </tbody>
                                    </table>
                                </div>
							 <div class="card-block">
                                <h3>Passenger Details</h3>
                                             
                                            <c:forEach var="passenger" items="${passengerList}">
                                                
                                                  <br/><p>  Serial Number:-${passenger.embeddedId.serialNumber}</p>
                                                   <p> Passenger Name:-${passenger.passenegerName}</p>
                                                   <p>Date of Birth:-${passenger.passengerDOB}</p>
                                                   <p> Fare:-${passenger.fare}</p>
                                                
                                            </c:forEach>
                               					 <h3>Payment Details</h3>
                               					  <br/><p> Total Amount:-${ticket.totalAmount}</p>
                                
                               
                                    <a href="/index" class="btn btn-secondary">Return</a><br/>
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
