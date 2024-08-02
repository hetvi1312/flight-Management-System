<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header1.jsp" %>

<section class="w3l-about-breadcrumb text-left">
    <div class="breadcrumb-bg breadcrumb-bg-about py-sm-5 py-4">
        <div class="container py-2">
            <h2 class="title">Feedback History</h2>
            <ul class="breadcrumbs-custom-path mt-2">
                <li><a href="#url">Home</a></li>
                <li class="active"><span class="fa fa-arrow-right mx-2" aria-hidden="true"></span> Feedback History </li>
            </ul>
        </div>
    </div>
</section>

<section class="w3l-contact" id="contact">
    <div class="contact-infubd py-5">
        <div class="container py-lg-3">
            <h3 class="title">Your Feedbacks</h3>
            <c:if test="${not empty feedbackList}">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Name</th>
                            <th>Content</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="feedback" items="${feedbackList}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>${feedback.name}</td>
                                <td>${feedback.content}</td>
                                <td>
                                    <a href="/deleteFeedback?id=${feedback.fId}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this Feedback?');">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
             <c:if test="${not empty message}">
            <script type="text/javascript">
                alert("${message}");
            </script>
        </c:if>
            <c:if test="${empty feedbackList}">
                <p>No feedbacks found.</p>
            </c:if>
        </div>
    </div>
</section>

<%@ include file="footer2.jsp" %>
