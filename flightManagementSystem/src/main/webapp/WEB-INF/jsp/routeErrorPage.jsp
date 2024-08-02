
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!doctype html>
<html lang="zxx">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Airline</title>
  <!-- google fonts -->
  <link href="//fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap" rel="stylesheet">
  <link href="//fonts.googleapis.com/css2?family=Lato:ital,wght@0,300;0,400;0,700;1,400&display=swap" rel="stylesheet">
  <!-- google fonts -->
  <!-- Template CSS -->
  <link rel="stylesheet" href="assets2/css/style-starter.css">
  <!-- Template CSS -->
  <style>
    .flight-container {
      display: flex;
      align-items: center;
      justify-content: space-between;
      padding: 15px;
      border: 1px solid #ddd;
      border-radius: 10px;
      margin-bottom: 10px;
      opacity: 0;
      animation: fadeInUp 1s ease-in-out forwards;
    }

    .flight-detail {
      display: flex;
      align-items: center;
      gap: 20px;
    }

    .flight-detail img {
      width: 50px;
      height: 50px;
    }

    .flight-info {
      text-align: left;
    }

    .flight-time {
      font-size: 1.5em;
      font-weight: bold;
    }

    .flight-route {
      color: #555;
    }

    .flight-duration {
      color: #777;
    }

    .flight-price {
      font-size: 1.2em;
      font-weight: bold;
      color: #28a745;
    }

    .book-btn {
      padding: 10px 20px;
      font-size: 1em;
      color: #fff;
      background-color: #007bff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    @keyframes fadeInUp {
      0% {
        transform: translateY(20px);
        opacity: 0;
      }
      100% {
        transform: translateY(0);
        opacity: 1;
      }
    }
  </style>
</head>

<body>
  <!--header-->
  <header id="site-header" class="fixed-top">
    <div class="container">
      <nav class="navbar navbar-expand-lg stroke">
        <h1><a class="navbar-brand mr-lg-5" href="index.html">
            Airline
          </a></h1>
        <!-- if logo is image enable this   
      <a class="navbar-brand" href="#index.html">
          <img src="image-path" alt="Your logo" title="Your logo" style="height:35px;" />
      </a> -->
        <button class="navbar-toggler  collapsed bg-gradient" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon fa icon-expand fa-bars"></span>
          <span class="navbar-toggler-icon fa icon-close fa-times"></span>
          </span>
        </button>

        
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="/flight-search">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/about">About</a>
            </li>
           
            <li class="nav-item">
              <a class="nav-link" href="/feedback">Feedback</a>
            </li>

		<!--<li class="nav-item">
              <a class="nav-link" href="/user-booking-history">Booking Detalis</a>
            </li>-->
		
		<li class="nav-item">
              <a class="nav-link" href="/ticketHistory">Booking detalis</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="feedback-history">Feedback detalis</a>
            </li>
		
		
          </ul>
        </div>
        <div class="d-lg-block d-none">
          <a href="/logout" class="btn btn-style btn-secondary">Logout</a>
        </div>
        <div class="mobile-position">
          <nav class="navigation">
            <div class="theme-switch-wrapper">
              <label class="theme-switch" for="checkbox">
                <input type="checkbox" id="checkbox">
                <div class="mode-container">
                  <i class="gg-sun"></i>
                  <i class="gg-moon"></i>
                </div>
              </label>
            </div>
          </nav>
        </div>
        <!-- //toggle switch for light and dark theme -->
      </nav>
    </div>
  </header>
  <!-- //header -->
  <!-- about breadcrumb -->
  <section class="w3l-about-breadcrumb text-left">
    <div class="breadcrumb-bg breadcrumb-bg-about py-sm-5 py-4">
      <div class="container py-2">
        <h2 class="title">Avaliable Flights</h2>
        <ul class="breadcrumbs-custom-path mt-2">
          <li><a href="#url">Home</a></li>
          <li class="active"><span class="fa fa-arrow-right mx-2" aria-hidden="true"></span>Avaliable Flights</li>
        </ul>
      </div>
    </div>
  </section>
  <!-- //about breadcrumb -->
  <!-- contact-form -->
  <!-- contact-form -->

  <!-- /contact-form -->
   <section class="w3l-grids-3 py-5" align="center">
    <div class="container py-md-3">
      <div class="container py-md-6">
      </div>
      <img src="assets2/images/404.png" alt="Error">
      <p style="font-size:20px;">${errorMessage}</p>
      <br/>
      <a href="/flight-search" class="btn btn-primary">Return</a>
    </div>
  </section>

  <!-- /contact-form -->

  <footer>
    <!-- footer -->
    <section class="w3l-footer">
      <div class="w3l-footer-16-main py-5">
        <div class="container">
          <div class="row">
            <div class="col-lg-12 column">
              <div class="row">
                <p>&copy; 2024 . All rights reserved.</p>
              </div>
            </div>

          </div>




          <!-- move top -->
          <button onclick="topFunction()" id="movetop" title="Go to top">
            <span class="fa fa-angle-up"></span>
          </button>
          <script>
            // When the user scrolls down 20px from the top of the document, show the button
            window.onscroll = function () {
              scrollFunction()
            };

            function scrollFunction() {
              if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                document.getElementById("movetop").style.display = "block";
              } else {
                document.getElementById("movetop").style.display = "none";
              }
            }

            // When the user clicks on the button, scroll to the top of the document
            function topFunction() {
              document.body.scrollTop = 0;
              document.documentElement.scrollTop = 0;
            }
          </script>
          <!-- //move top -->
          <script>
            $(function () {
              $('.navbar-toggler').click(function () {
                $('body').toggleClass('noscroll');
              })
            });
          </script>
    </section>
    <!-- //footer -->
  </footer>
  <!-- Template JavaScript -->
  <script src="assets2/js/jquery-3.3.1.min.js"></script>
  <script src="assets2/js/theme-change.js"></script>
  <!--/slider-js-->
  <script src="assets2/js/jquery.min.js"></script>
  <script src="assets2/js/modernizr-2.6.2.min.js"></script>
  <script src="assets2/js/jquery.zoomslider.min.js"></script>
  <!--//slider-js-->
  <script src="assets2/js/owl.carousel.js"></script>
  <!-- script for tesimonials carousel slider -->
  <script>
    $(document).ready(function () {
      $("#owl-demo1").owlCarousel({
        loop: true,
        margin: 20,
        nav: false,
        responsiveClass: true,
        responsive: {
          0: {
            items: 1,
            nav: false
          },
          736: {
            items: 1,
            nav: false
          },
          1000: {
            items: 1,
            nav: false,
            loop: true
          }
        }
      })
    })
  </script>
  <!-- //script for tesimonials carousel slider -->
  <!-- stats number counter-->
  <script src="assets2/js/jquery.waypoints.min.js"></script>
  <script src="assets2/js/jquery.countup.js"></script>
  <script>
    $('.counter').countUp();
  </script>
  <!-- //stats number counter -->

  <!--/MENU-JS-->
  <script>
    $(window).on("scroll", function () {
      var scroll = $(window).scrollTop();

      if (scroll >= 80) {
        $("#site-header").addClass("nav-fixed");
      } else {
        $("#site-header").removeClass("nav-fixed");
      }
    });

    //Main navigation Active Class Add Remove
    $(".navbar-toggler").on("click", function () {
      $("header").toggleClass("active");
    });
    $(document).on("ready", function () {
      if ($(window).width() > 991) {
        $("header").removeClass("active");
      }
      $(window).on("resize", function () {
        if ($(window).width() > 991) {
          $("header").removeClass("active");
        }
      });
    });
  </script>
  <!--//MENU-JS-->

  <script src="assets2/js/bootstrap.min.js"></script>

</body>

</html>
