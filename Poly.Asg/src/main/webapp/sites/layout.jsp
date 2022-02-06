<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>${page.title}</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Roboto;
}

body {
	display: flex;
	justify-content: flex-end;
	align-items: center;
	min-height: 100vh;
	flex-direction: column;
	background: url();
}

footer {
	position: relative;
	width: 100%;
	height: auto;
	padding: 50px 100px;
	background: #111;
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
}

footer .container {
	padding-top: 30px;
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
	flex-direction: row;
}

footer .container .noi-dung {
	margin-right: 30px;
}

footer  .container .noi-dung.about {
	width: 40%;
}

footer .container .noi-dung.about h2 {
	position: relative;
	color: #fff;
	font-weight: 500;
	margin-bottom: 15px;
}

footer .container .noi-dung.about h2:before {
	content: '';
	position: absolute;
	bottom: -5px;
	left: 0;
	width: 50px;
	height: 2px;
	background: #f00;
}

footer .container .noi-dung.about p {
	color: #999;
}
/*Thiết Lập Cho Thành Phần Icon Mạng Xã Hội*/
.social-icon {
	margin-top: 20px;
	display: flex;
}

.social-icon li {
	list-style: none;
}

.social-icon li a {
	display: inline-block;
	width: 45px;
	height: 45px;
	background: #222;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-right: 10px;
	text-decoration: none;
	border-radius: 4px;
}

.social-icon li a i {
	color: white;
}

.social-icon li a:hover {
	background: #f00;
}

.social-icon li a .fa {
	color: #fff;
	font-size: 20px;
}

.links h2 {
	position: relative;
	color: #fff;
	font-weight: 500;
	margin-bottom: 15px;
}

.links h2 {
	position: relative;
	color: #fff;
	font-weight: 500;
	margin-bottom: 15px;
}

.links h2::before {
	content: '';
	position: absolute;
	bottom: -5px;
	left: 0;
	width: 50px;
	height: 2px;
	background: #f00;
}

.links {
	position: relative;
	width: 25%;
}

.links ul li {
	list-style: none;
}

.links ul li a {
	color: #999;
	text-decoration: none;
	margin-bottom: 10px;
	display: inline-block;
}

.links ul li a:hover {
	color: #fff;
}

.contact h2 {
	position: relative;
	color: #fff;
	font-weight: 500;
	margin-bottom: 15px;
}

.contact h2::before {
	content: '';
	position: absolute;
	bottom: -5px;
	left: 0;
	width: 50px;
	height: 2px;
	background: #f00;
}

.contact {
	width: calc(35% - 60px);
	margin-right: 0 !important;
}

.contact .info {
	position: relative;
}

.contact .info li {
	display: flex;
	margin-bottom: 16px;
}

.contact .info li span:nth-child(1) {
	color: #fff;
	font-size: 20px;
	margin-right: 10px;
}

.contact .info li span {
	color: #999;
}

.contact .info li a {
	color: #999;
	text-decoration: none;
}
</style>
<body>
	<div class="container-fluid">
		<!--Menu  -->
		<nav>
			<nav
				class="col text-warning navbar navbar-expand-sm navbar-dark bg-dark">
				<button class="navbar-toggler d-lg-none" type="button"
					data-toggle="collapse" data-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					<div class="p-2">
						<a
							style="color: red; text-decoration: none; font-size: 20px; font-family: monospace; font-weight: bold;"
							href="Homepage"><i class="fab fa-youtube"></i> Anime.net</a>
					</div>
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link"
							href="Homepage"><i class="fas fa-home"></i> Anime <span
								class="sr-only">(current)</span></a></li>
						<li class="nav-item"><a class="nav-link" href="Admin/VideosManagement"><i
								class="p-1 float-left fas fa-film"></i> Video</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fas fa-info-circle"></i> Tin tức</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="p-1 float-left fas fa-book"></i>Truyện</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="p-1 float-left fas fa-list-ol"></i>BXH</a></li>

					</ul>
					<form class="col form-inline my-2 my-md-0">
						<input class="form-control mr-md-2" type="search"
							placeholder="Tìm kiếm Anime" aria-label="Search">
						<button class="btn btn-outline-success my-2 my-md-0" type="submit">
							<i class="p-1 float-left fas fa-search"></i>Tìm
						</button>
					</form>
				</div>
				<ul class="navbar-nav">
					<li class="nav-item"><a href="#" class="nav-link"><i
							class="p-1 float-left fas fa-language"></i>Tiếng Việt</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdownId"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
							class="fas fa-user"></i> Tài khoản</a>
						<div class="dropdown-menu" aria-labelledby="dropdownId">
							<c:if test="${ ! isLogin }">
								<a class="dropdown-item" href="Login">Login</a>
								<a class="dropdown-item" href="ForgotPassword">Forgot
									Password</a>
								<a class="dropdown-item" href="Registration">Registration</a>
							</c:if>
							
							<c:if test="${isLogin }">
								<a class="dropdown-item" href="Logoff">Logoff</a>
								<a class="dropdown-item" href="ChangePassword">Change
									Password</a>
								<a class="dropdown-item" href="EditProfile">Edit Profile</a>
							</c:if>
						</div></li>
				</ul>
			</nav>
			<div id="carouselExampleCaptions" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleCaptions" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
					<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="images/image.png" class="d-block w-100" alt="..."
							style="height: 450px">
						<div class="carousel-caption d-none d-md-block">
							<h5></h5>
							<p></p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="images/kmt.jpg" class="d-block w-100" alt="..."
							style="height: 450px">
						<div class="carousel-caption d-none d-md-block">
							<h5></h5>
							<p></p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="images/1One-Piece.jpg" class="d-block w-100" alt="..."
							style="height: 450px">
						<div class="carousel-caption d-none d-md-block">
							<h5></h5>
							<p></p>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleCaptions"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</nav>

		<!-- main -->
		<section class="row">
			<jsp:include page="${page.contentUrl}"></jsp:include>
		</section>

		<!-- footer -->
		<footer class="container-fluid mt-4">
			<div class="container">
				<!--Bắt Đầu Nội Dung Giới Thiệu-->
				<div class="noi-dung about">
					<h2>Về Chúng Tôi</h2>
					<p>Lorem ipsumdolor sit...</p>
					<ul class="social-icon">
						<li><a href=""><i class="fab fa-facebook-square"></i></a></li>
						<li><a href=""><i class="fab fa-twitter"></i></a></li>
						<li><a href=""><i class="fab fa-instagram"></i></a></li>
						<li><a href=""><i class="fab fa-youtube"></i></a></li>
					</ul>
				</div>
				<!--Kết Thúc Nội Dung Giới Thiệu-->
				<!--Bắt Đầu Nội Dung Đường Dẫn-->
				<div class="noi-dung links">
					<h2>Đường Dẫn</h2>
					<ul>
						<li><a href="#">Trang Chủ</a></li>
						<li><a href="#">Về Chúng Tôi</a></li>
						<li><a href="#">Thông Tin Liên Lạc</a></li>
						<li><a href="#">Dịch Vụ</a></li>
						<li><a href="#">Điều Kiện Chính Sách</a></li>
					</ul>
				</div>
				<!--Kết Thúc Nội Dung Đường Dẫn-->
				<!--Bắt Đâu Nội Dung Liên Hệ-->
				<div class="noi-dung contact">
					<h2>Thông Tin Liên Hệ</h2>
					<ul class="info">
						<li><span><i class="fa fa-map-marker"></i></span> <span>Đường
								Số 1<br /> Quận 1, Thành Phố Hồ Chí Minh<br /> Việt Nam
						</span></li>
						<li><span><i class="fa fa-phone"></i></span>
							<p>
								<a href="#">+84 123 456 789</a> <br /> <a href="#">+84 987
									654 321</a>
							</p></li>
						<li><span><i class="fa fa-envelope"></i></span>
							<p>
								<a href="#">diachiemail@gmail.com</a>
							</p></li>
					</ul>
				</div>
				<!--Kết Thúc Nội Dung Liên Hệ-->
			</div>
		</footer>
	</div>

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