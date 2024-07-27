<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header1.jsp" %>
  <section class="w3l-main-slider" id="home">
    <div class="banner-content">
      <div id="demo-1"
        data-zs-src='["assets2/images/banner1.jpg", "assets2/images/banner2.jpg","assets2/images/banner3.jpg", "assets2/images/banner4.jpg"]'
        data-zs-overlay="dots">
        <div class="demo-inner-content">
          <div class="container">
            <div class="banner-infhny">
              <h3>You don't need to go far to find what matters.</h3>
              <h6 class="mb-3">Discover your next adventure</h6>
              <div class="flex-wrap search-wthree-field mt-md-5 mt-4">
              
              <form:form action="/flight-search" method="post" class="booking-form">
                  <div class="row book-form">
                    <div class="form-input col-md-4 mt-md-0 mt-3">
                        <select name="flight_city" id="fromCity"  class="selectpicker">
                            
                            <option value="opt1">Source:</option>
                                                    <c:forEach var="city" items="${airportList}">
                                                        <option value="${city}">${city}</option>
                                                    </c:forEach>
                                                </select></div>
                          <div class="form-input col-md-4 mt-md-0 mt-3"> 
                      <select name="to_city" id="toCity"  class="selectpicker">
                       <option value="opt1">Destinaion:</option>
                                                    <c:forEach var="city" items="${airportList}">
                                                        <option value="${city}">${city}</option>
                                                    </c:forEach>
                                                </select>

                    </div>
                   
                    <div class="bottom-btn col-md-4 mt-md-0 mt-3">
                      <button type="submit" class="btn btn-style btn-secondary"><span class="fa fa-search mr-3"
                          aria-hidden="true"></span> Search</button>
                    </div>
                  </div>
                 </form:form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
<%@ include file="footer2.jsp" %>