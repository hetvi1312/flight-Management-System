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
                        <h5 class="m-b-10">Flight Report</h5>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="/index"><i class="fa fa-home"></i></a>
                        </li>
                        <li class="breadcrumb-item"><a href="#">Flight</a></li>
                        <li class="breadcrumb-item"><a href="#">Flight Report</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
     <div class="pcoded-inner-content">
                <c:if test="${not empty message}">
             <script type="text/javascript">
                alert("${message}");
            </script>
                    </c:if>
                    <div class="main-body">
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
                                <div class="card-block table-border-style">
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <thead>
                                        <thead>
                                            <tr>
                                                <th>No</th>
                                                <th>Flight Number</th>
                                                <th>Airlines Name</th>
                    							<th>Route Id</th>
                    							<th>Seat Capacity</th>
                     							<th>Departure</th>
                     							
                    							<th>Arrival</th>
                                                <th>Image</th>
                                                <th>Actions</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="flight" items="${flightList}" varStatus="status">
                                                <tr>
                                                							<td>${status.index + 1}</td>
                                                                           <td>${flight.flightNumber}</td>
                        													<td>${flight.carrierName}</td>
                        													<td>${flight.routeId}</td>
                        													<td>${flight.seatCapacity}</td>
                        													<td>${flight.departure}</td>
                        													<td>${flight.arrival}</td>
                                                    <td>
                                                        <c:if test="${not empty flight.imageUrl}">
                                                            <img src="${flight.imageUrl}" alt="Airline Image"
                                                                 style="width:150px; height:auto;" />
                                                        </c:if>
                                                    </td>
                                                    
                                                    <td>
                                                        <a href="deleteFlight?id=${flight.flightNumber}"
                                                           class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this airport?');">Delete</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
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
