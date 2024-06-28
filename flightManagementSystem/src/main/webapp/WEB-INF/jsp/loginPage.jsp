<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page </title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
  body, html {
    height: 100%;
    margin: 0;
  }
  .vh-100 {
    height: 100vh;
    background-color: #ADD8E6; /* Light blue background color */
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .login-bg {
    background: url('https://i.pinimg.com/564x/40/cf/29/40cf29baf3cb3a5386404831e0bab32b.jpg') no-repeat center center;
    background-size: cover;
    border-radius: 1rem 0 0 1rem;
    animation: fadeIn 2s ease-in-out;
  }
  .card {
    border-radius: 1rem;
    max-width: 800px; /* Adjusted maximum width of the form container */
    margin: auto; /* Center the form horizontally */
  }
  .login-form {
    animation: slideIn 1.5s ease-in-out;
  }
  .input-group-text {
    cursor: pointer;
  }
  @keyframes fadeIn {
    from {
      opacity: 0;
    }
    to {
      opacity: 1;
    }
  }
  @keyframes slideIn {
    from {
      transform: translateX(100%);
      opacity: 0;
    }
    to {
      transform: translateX(0);
      opacity: 1;
    }
  }
</style>
</head>
<body>
<section id="loginSection" class="vh-100">
  <div class="container py-5">
    <div class="card">
      <div class="row g-0">
        <div class="col-md-6 col-lg-5 d-none d-md-block login-bg"></div>
        <div class="col-md-6 col-lg-7 d-flex align-items-center">
          <div class="card-body p-4 p-lg-5 text-black login-form">
            <c:url value="/login" var="login"/>

            <form:form action="${login}" method="post">
              <div class="d-flex align-items-center mb-3 pb-1">
                <i class="fas fa-plane-departure fa-2x me-3" style="color: #ff6219;"></i>
                <span class="h1 fw-bold mb-0">Login</span>
              </div>
              <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into your account</h5>
              <div class="form-group">
                <input type="text" id="username" name="username" class="form-control form-control-lg" placeholder="Enter your Name" required>
              </div>
              <div class="form-group">
                <div class="input-group">
                  <input type="password" id="password" name="password" class="form-control form-control-lg" placeholder="Enter your password" required>
                  <div class="input-group-append">
                    <span class="input-group-text" id="togglePassword">
                      <i class="fas fa-eye"></i>
                    </span>
                  </div>
                </div>
              </div>
              <div class="pt-1 mb-4">
                <button class="btn btn-dark btn-lg btn-block" type="submit">Login</button>
              </div>
              <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account? <a href="/register" style="color: #393f81;">Register here</a></p>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
  document.addEventListener('DOMContentLoaded', (event) => {
    const togglePassword = document.querySelector('#togglePassword');
    const password = document.querySelector('#password');
    
    togglePassword.addEventListener('click', function (e) {
      // toggle the type attribute
      const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
      password.setAttribute('type', type);
      
      // toggle the eye slash icon
      this.querySelector('i').classList.toggle('fa-eye-slash');
    });
  });
</script>
</body>
</html>
