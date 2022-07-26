<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ page errorPage="error.jsp" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="ISO-8859-1">
      <title>home page</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
      <link rel="stylesheet" href="homePage.css">
    </head>

    <body>
      <%@include file="NavBar.html" %>

        <% String userName=(String) session.getAttribute("name"); session.getMaxInactiveInterval(); if(userName==null){
          response.sendRedirect("login.html"); } %>
          <div class="vh-100 gradient-custom">

           

            <figure class="text-end">
              <h1 class="fw-bolder">Customer Services</h1>
            </figure>






            <div id="carouselExampleControlsNoTouching" class="carousel slide" data-bs-touch="false"
              data-bs-interval="false">
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img src="bg-img-3.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                  <img src="bg-img-2.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                  <img src="bg-img1.png" class="d-block w-100" alt="...">
                </div>
              </div>
              <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControlsNoTouching"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControlsNoTouching"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
          
          </div>

           <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
            crossorigin="anonymous"></script>

    </body>

    </html>