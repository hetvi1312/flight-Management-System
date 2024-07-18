<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<div class="pcoded-content">
    <!-- Page-header start -->
    <div class="page-header">
        <div class="page-block">
            <div class="row align-items-center">
                <div class="col-md-8">
                    <div class="page-header-title">
                        <h5 class="m-b-10">Flight Booking</h5>
                    </div>
                </div>
                <div class="col-md-4">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="/index"> <i class="fa fa-home"></i> </a>
                        </li>
                        <li class="breadcrumb-item"><a href="#!">Flight</a></li>
                        <li class="breadcrumb-item"><a href="#!">Booking Flight</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- Page-header end -->
    <div class="pcoded-inner-content">
        <!-- Main-body start -->
        <div class="main-body">
            <div class="page-wrapper">
                <div class="page-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5>Booking Flight</h5>
                                </div>
                                <div class="card-block">
                                    <form:form action="/ticket" method="post" modelAttribute="ticketRecord">
                                          
                                        <form:hidden path="ticketNumber"/>
                                        <form:hidden path="flightNumber"/>
                                        <form:hidden path="carrierName"/>
                                        <form:hidden path="routeId"/> <!-- Add this hidden field -->
                                        <input type="hidden" name="fromLocation" value="${route.sourceAirportCode}"/>
                                        <input type="hidden" name="toLocation" value="${route.destinationAirportCode}"/>
                                        <input type="hidden" name="fare" value="${route.fair}"/>
                                        
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">Ticket Number:</label>
                                            <div class="col-sm-4">
                                                <form:input type="text" id="ticketNumber" path="ticketNumber" class="form-control" disabled="true"/>
                                            </div>
                                            <label class="col-sm-2 col-form-label">Flight Number:</label>
                                            <div class="col-sm-4">
                                                <form:input type="text" id="flightNumber" path="flightNumber" class="form-control" disabled="true"/>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">Airlines Name:</label>
                                            <div class="col-sm-4">
                                                <form:input type="text" id="carrierName" path="carrierName" class="form-control" disabled="true"/>
                                            </div>
                                            <label class="col-sm-2 col-form-label">From Location:</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" value="${route.sourceAirportCode}" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">To Location:</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" value="${route.destinationAirportCode}" disabled>
                                            </div>
                                            <label class="col-sm-2 col-form-label">Fare:</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" value="${route.fair}" disabled>
                                            </div>
                                        </div>
                                        <h4>Enter passenger details</h4><br/>
                                       
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Enter Name:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="name1" value="--" required/>
                                                </div>
                                                <label class="col-sm-2 col-form-label">Enter Date Of Birth:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY" name="dob1" required/>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Enter Name:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="name2" value="--" />
                                                </div>
                                                <label class="col-sm-2 col-form-label">Enter Date Of Birth:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY"  name="dob2" />
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Enter Name:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="name3" value="--" />
                                                </div>
                                                <label class="col-sm-2 col-form-label">Enter Date Of Birth:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY"  name="dob3" />
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Enter Name:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="name4" value="--" />
                                                </div>
                                                <label class="col-sm-2 col-form-label">Enter Date Of Birth:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY"  name="dob4" />
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Enter Name:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="name5" value="--" />
                                                </div>
                                                <label class="col-sm-2 col-form-label">Enter Date Of Birth:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY"  name="dob5" />
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Enter Name:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="name6" value="--" />
                                                </div>
                                                <label class="col-sm-2 col-form-label">Enter Date Of Birth:</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY"  name="dob6" />
                                                </div>
                                            </div>
                                        
                                        <div class="form-group row">
                                            <div class="col-sm-2"></div>
                                            <div class="col-sm-10">
                                                <button type="submit" class="btn btn-primary waves-effect waves-light">Add</button>
                                                <button type="reset" class="btn btn-inverse waves-effect waves-light">Reset</button>
                                                <a href="/index" class="btn btn-secondary">Return</a>
                                            </div>
                                        </div>
                                    </form:form>
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
