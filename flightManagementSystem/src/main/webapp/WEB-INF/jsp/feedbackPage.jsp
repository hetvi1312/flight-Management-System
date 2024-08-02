<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header1.jsp" %>

<!-- about breadcrumb -->
<section class="w3l-about-breadcrumb text-left">
    <div class="breadcrumb-bg breadcrumb-bg-about py-sm-5 py-4">
        <div class="container py-2">
            <h2 class="title">Feedback</h2>
            <ul class="breadcrumbs-custom-path mt-2">
                <li><a href="#url">Home</a></li>
                <li class="active"><span class="fa fa-arrow-right mx-2" aria-hidden="true"></span> Feedback </li>
            </ul>
        </div>
    </div>
</section>
<!-- //about breadcrumb -->

<!-- contact-form -->
<section class="w3l-contact" id="contact">
    <div class="contact-infubd py-5">
        <div class="container py-lg-3">
            <div class="contact-grids row">
                <div class="col-lg-6 contact-left">
                    <div class="partners">
                        <div class="cont-details">
                            <!-- Optional content here -->
                        </div>
                        <div class="hours">
                            <img src="assets2/images/12.jpg" class="img-fluid" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mt-lg-0 mt-5 contact-right">
                    <form:form action="/feedback" method="post" modelAttribute="feedbackRecord" class="signin-form">
                        <div class="input-grids">
                            <form:hidden path="username"/>
                            <div class="form-group">
                                <form:input type="text" path="name" placeholder="Your Name*" class="contact-input" />
                            </div>
                        </div>
                        <div class="form-group">
                            <form:textarea path="content" placeholder="Type your message here*" required="true" class="contact-input"/>
                        </div>
                        <div class="text-right">
                            <button type="submit" class="btn btn-style btn-primary">Send Message</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <c:if test="${not empty message}">
            <script type="text/javascript">
                alert("${message}");
            </script>
        </c:if>
    </div>
</section>
<!-- /contact-form -->

<%@ include file="footer2.jsp" %>
