<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<div class="pcoded-content">
    <div class="page-header">
        <div class="page-block">
            <div class="row align-items-center">
                <div class="col-md-8">
                    <div class="page-header-title">
                        <h5 class="m-b-10">Ticket Details</h5>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="/index"><i class="fa fa-home"></i></a>
                        </li>
                        <li class="breadcrumb-item"><a href="#">Ticket</a></li>
                        <li class="breadcrumb-item"><a href="#">Ticket Details</a></li>
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
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5>Ticket Details</h5>
                                </div>
                                <div class="card-block">
                                    <h6>Ticket Information</h6>
                                    <p>Ticket Number: ${ticket.ticketNumber}</p>
                                    <p>Flight Number: ${ticket.flightNumber}</p>
                                    <p>Carrier Name: ${ticket.carrierName}</p>
                                    <p>Username: ${ticket.username}</p>
                                  
                                    <p>Total Amount: ${ticket.totalAmount}</p>

                                    
                                    
                                    <a href="/ticket-report" class="btn btn-secondary">Back</a>
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
