<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter OTP</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link rel="stylesheet" href="login.css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<body>

	<div class="container-fluid">
		<form action="ValidateOtp" method="post"
			class="row g-3 needs-validation" novalidate>
			<section class="vh-100 gradient-custom">
				<div class="container py-5 h-100">
					<div
						class="row d-flex justify-content-center align-items-center h-100">
						<div class="col-12 col-md-8 col-lg-6 col-xl-5">
							<div class="card bg-dark text-white" style="border-radius: 1rem;">
								<div class="card-body p-5 text-center">
									<div class="mb-md-5 mt-md-4 pb-5">

										<h2 class="fw-bold mb-2 text-uppercase">Enter OTP</h2>
										<br>

										<%
										if (request.getAttribute("message") != null) {
											out.print("<p class='text-danger ml-1'>" + request.getAttribute("message") + "</p>");
										}
										%>

										<div class="form-outline form-white mb-4 position-relative ">
											<label class="form-label" for="typeEmailX"></label> <input
												type="text" id="typeEmailX" name="otp"
												placeholder="Enter the OTP"
												class="form-control form-control-lg" required />
											<div class="invalid-tooltip">Please enter valid OTP</div>
										</div>


										<br>
										<div>
											<button class="btn btn-outline-light btn-lg px-5"
												type="submit">Reset Password</button>
											<a class="btn btn-outline-light btn-lg px-5"
												href="forgotPassword.jsp" role="button">Back</a>
										</div>

									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>

	<script>
(() => {
	  'use strict'

	  
	  const forms = document.querySelectorAll('.needs-validation')

	  
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
</html>