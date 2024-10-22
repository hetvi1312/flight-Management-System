<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
  body, html {
    height: 100%;
    margin: 0;
  }
  .vh-100 {
    height: 100vh;
    background-color: #ADD8E6;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .login-bg {
    background: url('/assets/images/login.jpg') no-repeat center center;
    background-size: cover;
    border-radius: 1rem 0 0 1rem;
    animation: fadeIn 2s ease-in-out;
  }
  .card {
    border-radius: 1rem;
    max-width: 900px;
    margin: auto;
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
<script type="text/javascript">
function passwordCheck(){
    var pass1 = document.getElementById("pass1").value;
    var pass2 = document.getElementById("pass2").value;
    var passwordPattern = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*\W).{6,13}$/;

    if (pass1 !== pass2) {
        alert("Passwords do not match");
        return false;
    } else if (!passwordPattern.test(pass1)) {
        alert("Password must be 6-13 characters long, containing at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        return false;
    }
    return true;
}

document.addEventListener('DOMContentLoaded', function() {
    const togglePassword1 = document.querySelector('#togglePassword1');
    const togglePassword2 = document.querySelector('#togglePassword2');
    const password1 = document.querySelector('#pass1');
    const password2 = document.querySelector('#pass2');

    togglePassword1.addEventListener('click', function() {
        const type = password1.getAttribute('type') === 'password' ? 'text' : 'password';
        password1.setAttribute('type', type);
        this.querySelector('i').classList.toggle('fa-eye-slash');
    });

    togglePassword2.addEventListener('click', function() {
        const type = password2.getAttribute('type') === 'password' ? 'text' : 'password';
        password2.setAttribute('type', type);
        this.querySelector('i').classList.toggle('fa-eye-slash');
    });

    document.getElementById('registrationForm').addEventListener('submit', function(event) {
        if (!passwordCheck()) {
            event.preventDefault();
        }
    });
});
</script>
</head>
<body>
<section class="vh-100">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12">
        <div class="card">
          <div class="row g-0">
            <div class="col-md-6 col-lg-5 d-none d-md-block login-bg"></div>
            <div class="col-md-6 col-lg-7 d-flex align-items-center">
              <div class="card-body p-4 p-lg-5 text-black login-form">
                <form:form id="registrationForm" action="/register" method="post" modelAttribute="userRecord">
                  <div class="d-flex align-items-center mb-3 pb-1">
                    <i class="fas fa-plane-departure fa-2x me-3" style="color: #ff6219;"></i>
                    <span class="h1 fw-bold mb-0">Register</span>
                  </div>
                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Create your account</h5>
                  <div class="form-group">
                    <form:input path="username" id="username" class="form-control form-control-lg" placeholder="Enter your name" required="true"/>
                  </div>
                  <div class="form-group">
                    <form:select path="type" id="type" class="form-control form-control-lg" required="true">
                      <form:option value="" label="Select type" disabled="true" selected="true"/>
                      <form:option value="admin" label="Admin"/>
                      <form:option value="customer" label="Customer"/>
                    </form:select>
                  </div>
                  <div class="form-group">
                    <div class="input-group">
                      <form:password path="password" id="pass1" class="form-control form-control-lg" placeholder="Enter your password" required="true"/>
                      <div class="input-group-append">
                        <span class="input-group-text" id="togglePassword1">
                          <i class="fas fa-eye"></i>
                        </span>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="input-group">
                      <input type="password" id="pass2" class="form-control form-control-lg" placeholder="Confirm your password" required/>
                      <div class="input-group-append">
                        <span class="input-group-text" id="togglePassword2">
                          <i class="fas fa-eye"></i>
                        </span>
                      </div>
                    </div>
                  </div>
                  <div class="pt-1 mb-4">
                    <button class="btn btn-dark btn-lg btn-block" type="submit">Register</button>
                    <button class="btn btn-dark btn-lg btn-block" type="reset">Reset</button>
                  </div>
                  <p class="mb-5 pb-lg-2" style="color: #393f81;">Already have an account? <a href="/loginpage" style="color: #393f81;">Login here</a></p>
                </form:form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
