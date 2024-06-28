<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<div class="pcoded-content">
    <!-- Page-header start -->
    <div class="page-header">
        <div class="page-block">
            <div class="row align-items-center">
                <div class="col-md-8">
                    <div class="page-header-title">
                        <h5 class="m-b-10">Edit Airport</h5>
                    </div>
                </div>
                <div class="col-md-4">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="dashboard.php"> <i class="fa fa-home"></i> </a>
                        </li>
                        <li class="breadcrumb-item"><a href="#!">Airport</a>
                        </li>
                        <li class="breadcrumb-item"><a href="#!">Edit Airport</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>'
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
                                    <h5>Edit Airport</h5>
                                </div>
                                <div class="card-block">
                                    <form:form action="/updateAirport" class="form-material" method="post" modelAttribute="airportRecord">
                                        <div class="form-group form-default form-static-label">
                                            <form:input type="text" id="airportCode" path="airportCode" class="form-control" placeholder="Enter Airport Code" readonly="true"/>
                                            <span class="form-bar"></span>
                                            <label class="float-label">Airport Code:</label>
                                        </div>
                                        <div class="form-group form-default form-static-label">
                                            <form:input type="text" id="airportLocation" path="airportLocation" class="form-control" placeholder="Enter Airport Location" required="true"/>
                                            <span class="form-bar"></span>
                                            <label class="float-label">Enter Airport Location:</label>
                                        </div>
                                        <div class="form-group form-default form-static-label">
                                            <button type="submit" class="btn btn-primary waves-effect waves-light">Update</button>
                                        </div>
                                    </form:form>
                                    <a href="/index" class="back-link">Back</a>
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
