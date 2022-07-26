<%@ page errorPage="error.jsp" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="ISO-8859-1">
    <title>delete records</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="login.css">
  </head>

  <body>

    <% String userName=(String) session.getAttribute("name"); session.getMaxInactiveInterval(); if(userName==null){
      response.sendRedirect("login.html"); } %>
      <nav class="navbar navbar-expand-lg bg-dark">
        <div class="container-fluid">


          <a type="button" class="btn-close btn-close-white" aria-label="Close" href="homePage.jsp"></a>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
            <form class="d-flex" role="search" action="showRecords" method="post">

              <a class="btn btn-light" href="showRecords">Back</a>

            </form>
          </div>
        </div>
      </nav>

      <div class="container-fluid">
        <form action="delete" method="post" class="row g-3 needs-validation" novalidate>
          <section class="vh-100 gradient-custom p-0">
            <div class="container py-5 h-100">
              <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                  <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                      <div class="mb-md-5 mt-md-4 pb-5">

                        <h2 class="fw-bold mb-2 text-uppercase">Delete Record</h2><br>


                        <div class="form-outline form-white mb-4 position-relative">
                          <label class="form-label" for="typePasswordX">Enter the customer no. to delete the
                            records</label>
                          <input type="text" id="typePasswordX" name="id" placeholder="Customer Id No."
                            class="form-control form-control-lg" required />
                          <div class="invalid-tooltip">
                            Please enter customer no!
                          </div>
                        </div>



                        <button onclick="checker()" class="btn btn-outline-light btn-lg px-5"
                          type="submit">Delete</button>


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
        function checker() {
          var result = confirm('Do you really want to delete!');
          if (result == false) {
            event.preventDefault();
          }
        }

      </script>
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

  </html>