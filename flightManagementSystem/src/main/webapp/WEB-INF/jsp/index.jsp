<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<div class="pcoded-content">
    <!-- Page-header start -->
    <div class="page-header">
        <div class="page-block">
            <div class="row align-items-center">
                <div class="col-md-8">
                    <div class="page-header-title">
                        <h5 class="m-b-10">Dashboard</h5>
                        <p class="m-b-0">Welcome ${username}</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="dashboard.php"> <i class="fa fa-home"></i> </a>
                        </li>
                        <li class="breadcrumb-item"><a href="#!">Dashboard</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    
      <div class="pcoded-inner-content">
                            <!-- Main-body start -->
                            <div class="main-body">
                                <div class="page-wrapper">
                                    <!-- Page-body start -->
                                    <div class="page-body">
                                        

                                            <!--  sale analytics start -->
                                            
                                            <div class="col-md-12">
                                                <div class="row">
                                                   
                                                    <div class="col-md-4">
                                                        <div class="card bg-c-red total-card">
                                                            <div class="card-block">
                                                                <div class="text-left">
                                                                    <h4>${userCount}</h4>
                                                                    <p class="m-0">Total User</p>
                                                                </div>
                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="card bg-c-green total-card">
                                                            <div class="card-block">
                                                                <div class="text-left">
                                                                   <h4>${totalAirports}</h4>
                                                                    <p class="m-0">Total Airport</p>
                                                                </div>
                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="card bg-c-blue total-card">
                                                            <div class="card-block">
                                                                <div class="text-left">
                                                                     <h4>${routeCount}</h4>
                                                                    <p class="m-0">Total route</p>
                                                                </div>
                                                               
                                                            </div>
                                                        </div>
                                                    </div>
                                                   
                                                   
                                            </div>

                                            
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                                <div class="row">
                                                   
                                                    <div class="col-md-4">
                                                        <div class="card bg-c-purple total-card">
                                                            <div class="card-block">
                                                                <div class="text-left">
                                                                    <h4>${ticketCount}</h4>
                                        							<p class="m-0">Total ticket Booking</p>
                                                                </div>
                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="card bg-c-yellow total-card">
                                                            <div class="card-block">
                                                                <div class="text-left">
                                                                    <h4>${feedbackCount}</h4>
                                        <p class="m-0">Total feedback</p>
                                                                </div>
                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                     <div class="col-md-4">
                                                        <div class="card bg-c-red total-card">
                                                            <div class="card-block">
                                                                <div class="text-left">
                                                                    <h4>${flightCount}</h4>
                                        							<p class="m-0">Total flight</p>
                                                                   
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
