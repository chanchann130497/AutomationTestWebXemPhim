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
		<div class="row">
			<div class="col-7">
				<div class="card text-center mt-3">
					<div class="card-body">
						<div class="row">
							<img src="images/dragon_ball.jpg" alt="" class="img-fluid" />
						</div>
						<div class="row p-2">
							<b>Video Title</b>
						</div>
						<div class="row p-2">
							<b>Video Title</b>
						</div>
					</div>
					<div class="card-footer text-center">
						<a href="" class="btn btn-success">Like</a> <a href=""
							class="btn btn-info">Share</a>
					</div>
				</div>
			</div>
			<div class="col-5">
				<div class="row border mt-3 mb-3">
					<div class="col-2">
						<img class="img-fluid" alt="" src="images/dragon_ball.jpg">
					</div>
					<div class="col-10 border-left">Video title</div>
				</div>
				<div class="row border mt-3 mb-3">
					<div class="col-2">
						<img class="img-fluid" alt="" src="images/dragon_ball.jpg">
					</div>
					<div class="col-10 border-left">Video title</div>
				</div>
				<div class="row border mt-3 mb-3">
					<div class="col-2">
						<img class="img-fluid" alt="" src="images/dragon_ball.jpg">
					</div>
					<div class="col-10 border-left">Video title</div>
				</div>
			</div>
		</div>
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