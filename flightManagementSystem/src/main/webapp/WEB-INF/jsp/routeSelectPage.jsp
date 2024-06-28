<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<div class="pcoded-content">
    <!-- Page-header start -->
    <div class="page-header">
        <div class="page-block">
            <div class="row align-items-center">
                <div class="col-md-8">
                    <div class="page-header-title">
                        <h5 class="m-b-10">Flight Search Page</h5>
                    </div>
                </div>
                <div class="col-md-4">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="dashboard.php"><i class="fa fa-home"></i></a>
                        </li>
                        <li class="breadcrumb-item"><a href="#!">Flight Booking</a></li>
                        <li class="breadcrumb-item"><a href="#!">Flight Search</a></li>
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
                                    <h5>Flight Search</h5>
                                </div>
                                                    <div class="card-block">
                                    <form:form action="/flight-search" method="post" class="form-material">
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label" for="fromCity">Select From City:</label>
                                            <div class="col-sm-10">
                                                <select name="flight_city" id="fromCity" class="form-control">
                                                     <option value="opt1">Select from City:</option>
                                                    <c:forEach var="city" items="${airportList}">
                                                        <option value="${city}">${city}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label" for="toCity">Select to City:</label>
                                            <div class="col-sm-10">
                                                <select name="to_city" id="toCity" class="form-control">
                                                     <option value="opt1">Select to City:</option>
                                                    <c:forEach var="city" items="${airportList}">
                                                        <option value="${city}">${city}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group form-default form-static-label">
                                            <button type="submit" class="btn btn-primary waves-effect waves-light">Show</button>
                                        </div>
                                    </form:form>
                                    <a href="/index" class="btn btn-secondary">Back</a>
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
