<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="/Poly.Asg/" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="/Poly.Asg/fontawesome-free-5.15.4-web/css/all.css">
<title></title>
</head>
<body>
	<main class="container">
		<section class="row">
			<div class="col">
				<div class="row p-2">
					<div class="col-3 mt-2">
						<div class="card">
							<div class="card-header">Header</div>
							<div class="card-body">
								<img src="images/dragon_ball.jpg" alt="" class="img-fluid" />
								<div class="row">
									<b>Video Title</b>
								</div>
							</div>
							<div class="card-footer text-muted">
								<a href="" class="btn btn-primary">Unlike</a> <a href=""
									class="btn btn-info">Share</a>
							</div>
						</div>
					</div>
					<div class="col-3 mt-2">
						<div class="card">
							<div class="card-header">Header</div>
							<div class="card-body">
								<img src="images/dragon_ball.jpg" alt="" class="img-fluid" />
								<div class="row">
									<b>Video Title</b>
								</div>
							</div>
							<div class="card-footer text-muted">
								<a href="" class="btn btn-primary">Unlike</a> <a href=""
									class="btn btn-info">Share</a>
							</div>
						</div>
					</div>
					<div class="col-3 mt-2">
						<div class="card">
							<div class="card-header">Header</div>
							<div class="card-body">
								<img src="images/dragon_ball.jpg" alt="" class="img-fluid" />
								<div class="row">
									<b>Video Title</b>
								</div>
							</div>
							<div class="card-footer text-muted">
								<a href="" class="btn btn-primary">Unlike</a> <a href=""
									class="btn btn-info">Share</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<nav aria-label="Page navigation">
							<ul class="pagination justify-content-center">
								<li class="page-item disabled"><a class="page-link"
									href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
								<li class="page-item active"><a class="page-link" href="#">&lt;</a></li>
								<li class="page-item"><a class="page-link" href="#">&gt;</a></li>
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>
	</main>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<c:if test="${not empty page.scriptUrl}">
		<jsp:include page="${page.scriptUrl}"></jsp:include>
	</c:if>
</body>
</html>