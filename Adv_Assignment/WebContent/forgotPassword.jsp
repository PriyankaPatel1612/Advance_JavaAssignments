<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ page errorPage="error.jsp" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="ISO-8859-1">
      <title>forgot Password</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
      <link rel="stylesheet" href="login.css">
    </head>

    <body>

      <div class="container-fluid">
        <form action="forgotPassword" method="post" class="row g-3 needs-validation" novalidate>
          <section class="vh-100 gradient-custom">
            <div class="container py-5 h-100">
              <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                  <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                      <div class="mb-md-5 mt-md-4 pb-5">

                        <h2 class="fw-bold mb-2 text-uppercase">Forgot Password</h2><br>


                        <div class="form-outline form-white mb-4 position-relative ">
                          <label class="form-label" for="typeEmailX"></label>
                          <input type="email" id="typeEmailX" name="email" placeholder="Username or email id"
                            class="form-control form-control-lg" required />
                          <div class="invalid-tooltip">
                            Please enter registered email!
                          </div>
                        </div>




                        <br><button class="btn btn-outline-light btn-lg px-5" type="submit">Get OTP</button>
                        <a class="btn btn-outline-light btn-lg px-5" href="login.html" role="button">Back to Login</a>


                      </div>

                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>

        </form>
      </div>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>

      <script>
        (() => {
          'use strict'

          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          const forms = document.querySelectorAll('.needs-validation')

          // Loop over them and prevent submission
          Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
              if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
              }

              form.classList.add('was-validated')
            }, false)
          })
        })()
      </script>

    </body>


    <!--  <body>
<h1>Forgot Password?</h1>

  <form action="forgotPassword" method="post">  

      <div>
      Enter your registered email<input type="email" name="email" />  
     </div>
     
        
        <input type="submit" value="Get OTP"/>
        <br><a href="login.html" >Back to login</a>
         
</form>  
</body>-->

    </html>
