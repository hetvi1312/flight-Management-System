<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header1.jsp" %>
  <!-- about breadcrumb -->
  <section class="w3l-about-breadcrumb text-left">
    <div class="breadcrumb-bg breadcrumb-bg-about py-sm-5 py-4">
      <div class="container py-2">
        <h2 class="title">Ticket Booking</h2>
        <ul class="breadcrumbs-custom-path mt-2">
          <li><a href="#url">Home</a></li>
          <li class="active"><span class="fa fa-arrow-right mx-2" aria-hidden="true"></span>Ticket Booking </li>
        </ul>
      </div>
    </div>
  </section>
  <!-- //about breadcrumb -->
<!-- contact-form -->
<!-- contact-form -->
<section class="w3l-contact" id="contact">
    <div class="contact-infubd py-5">
      <div class="container py-lg-3">
        <div class="contact-grids row">
          <div class="col-lg-12 contact-left">
            <div class="partners">
              <div class="cont-details">
  
                <form:form action="/ticket" method="post" modelAttribute="ticketRecord" class="signin-form">
                  <div class="input-grids">
                    <form:hidden path="ticketNumber"/>
                    <form:hidden path="flightNumber"/>
                    <form:hidden path="carrierName"/>
                    <form:hidden path="routeId"/> 
                    <form:hidden path="username"/> 
                    <!-- Add this hidden field -->
                    <input type="hidden" name="fromLocation" value="${route.sourceAirportCode}"/>
                    <input type="hidden" name="toLocation" value="${route.destinationAirportCode}"/>
                    <input type="hidden" name="fare" value="${route.fair}"/>
                         
                    <div class="form-row">
                      <div class="form-group col-md-6">
                        <label for="w3lName">Ticket Number:</label>
                        <form:input type="text" id="ticketNumber" path="ticketNumber" class="contact-input" disabled="true"/>
                      </div>
                      <div class="form-group col-md-6">
                        <label for="w3lSender">Flight Number:</label>
                        <form:input type="text" id="flightNumber" path="flightNumber" class="contact-input" disabled="true"/>
                      </div>
                    </div>
                    <div class="form-row">
                      <div class="form-group col-md-6">
                        <label for="w3lSender">Airlines Name:</label>
                        <form:input type="text" id="carrierName" path="carrierName" class="contact-input" disabled="true"/>
                      </div>
                      <div class="form-group col-md-6">
                        <label for="w3lSender">From Location:</label>
                        <input type="text" value="${route.sourceAirportCode}" class="contact-input" disabled="true"/>
                      </div>
                    </div>
                    <div class="form-row">
                      <div class="form-group col-md-6">
                        <label for="w3lSender">To Location:</label>
                        <input type="text" value="${route.destinationAirportCode}" class="contact-input" disabled/>
                      </div>
                        <div class="form-group col-md-6">
                            <label for="w3lSender">Fare:</label>
                            <input type="text" value="${route.fair}" class="contact-input" disabled/>
                          </div>
                        </div>
                        <div class="form-group">
                            <label for="w3lSender">Booking Date:</label>
                            <input type="date" class="contact-input" name="bookingDate" required/>
                          </div>

                          <h4>Enter passenger details</h4><br/>
                          <div class="form-row">
                            <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Name:</label>
                            <input type="text" name="name1" id="w3lName" value="--" placeholder="Enter Your Name" class="contact-input" required/>
                          </div>
                          <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Date Of Birth:</label>
                            <input type="text" name="dob1"   pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY"  class="contact-input" required/>
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Name:</label>
                            <input type="text" name="name2" id="w3lName" value="--" placeholder="Enter Your Name" class="contact-input" />
                          </div>
                          <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Date Of Birth:</label>
                            <input type="text" name="dob2"   pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY"  class="contact-input" />
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Name:</label>
                            <input type="text" name="name3" id="w3lName" value="--" placeholder="Enter Your Name" class="contact-input" />
                          </div>
                          <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Date Of Birth:</label>
                            <input type="text" name="dob3"   pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY"  class="contact-input" />
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Name:</label>
                            <input type="text" name="name4" id="w3lName" value="--" placeholder="Enter Your Name" class="contact-input" />
                          </div>
                          <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Date Of Birth:</label>
                            <input type="text" name="dob4"   pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY"  class="contact-input" />
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Name:</label>
                            <input type="text" name="name5" id="w3lName" value="--" placeholder="Enter Your Name" class="contact-input" />
                          </div>
                          <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Date Of Birth:</label>
                            <input type="text" name="dob5"   pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY"  class="contact-input" />
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Name:</label>
                            <input type="text" name="name6" id="w3lName" value="--" placeholder="Enter Your Name" class="contact-input" />
                          </div>
                          <div class="form-group col-md-6">
                            <label for="w3lSender">Enter Date Of Birth:</label>
                            <input type="text" name="dob6"   pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="DD-MM-YYYY"  class="contact-input" />
                          </div>
                        </div>

                  
                  <div class="text-right">
                    <button  type="submit" class="btn btn-success">Booking</button>
                    <button type="reset" class="btn btn-secondary">Reset</button>
                     <a href="/index1" class="btn btn-primary">Return</a>
                                            
                  </div>
                </form:form>
              </div>
  
            </div>
           
          </div>
  </section>
  
  <style>
    .form-row {
      display: flex;
      flex-wrap: wrap;
      gap: 20px;
    }
    .form-group {
      flex: 1;
      min-width: 200px; /* Adjust this value as needed */
    }
  </style>
  
 
  <%@ include file="footer2.jsp" %>

  