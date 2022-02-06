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
<title>Home</title>
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
	<div class="container">
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
							style="color: red; text-decoration: none; font-size: 18px; font-family: monospace; font-weight: bold;"
							href="#"><i class="fab fa-youtube"></i> Anime.net</a>
					</div>
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link" href="#"><i
								class="fas fa-home"></i> Anime <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fas fa-film"></i> Video</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fas fa-info-circle"></i> Tin tức</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fas fa-book"></i>Truyện</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fas fa-list-ol"></i>BXH</a></li>

					</ul>
					<form class="col form-inline my-2 my-md-0">
						<input class="form-control mr-md-2" type="search"
							placeholder="Tìm kiếm Anime" aria-label="Search">
						<button class="btn btn-outline-success my-2 my-md-0" type="submit">
							<i class="fas fa-search"></i>Tìm
						</button>
					</form>
				</div>
				<ul class="navbar-nav">
					<li class="nav-item"><a href="#" class="nav-link"><i
							class="fas fa-language"></i>Tiếng Việt</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdownId"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
							class="fas fa-user"></i> Tài khoản</a>
						<div class="dropdown-menu" aria-labelledby="dropdownId">
							<a class="dropdown-item" href="#">Đăng nhập</a><a
								class="dropdown-item" href="#">Quên mật khẩu</a> <a
								class="dropdown-item" href="#">Đăng kí thành viên</a>
							<hr class="dropdown-deliver" />
							<a class="dropdown-item" href="#">Đăng xuất</a> <a
								class="dropdown-item" href="#">Đổi mật khẩu</a> <a
								class="dropdown-item" href="#">Cập nhật hồ sơ</a>
							<hr class="dropdown-deliver" />
							<a class="dropdown-item" href="#">Đơn hàng</a> <a
								class="dropdown-item" href="#">Hàng đã mua</a>
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
							style="height: 380px">
						<div class="carousel-caption d-none d-md-block">
							<h5>First slide label</h5>
							<p>Some representative placeholder content for the first
								slide.</p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="images/kmt.jpg" class="d-block w-100"
							alt="..." style="height: 380px">
						<div class="carousel-caption d-none d-md-block">
							<h5>Second slide label</h5>
							<p>Some representative placeholder content for the second
								slide.</p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="images/1One-Piece.jpg" class="d-block w-100" alt="..."
							style="height: 380px">
						<div class="carousel-caption d-none d-md-block">
							<h5>Third slide label</h5>
							<p>Some representative placeholder content for the third
								slide.</p>
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
		<article class="row mt-2 p-0">
			<section class="col-md-9">
				<div class="pt-2">
					<div class="card float-left mr-4 mb-2"
						style="width: 250px; text-align: center;">
						<img src="images/Naruto.jpg" class="card-img-top" height="150px"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">Naruto</h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<div class="card-footer">
								<button type="button" class="btn btn-danger">
									<i class="fas fa-thumbs-up"></i>Thích
								</button>
								<button type="button" class="btn btn-warning">
									<i class="fas fa-share"></i>Share
								</button>
							</div>
						</div>
					</div>
					<div class="card float-left mr-4 mb-2"
						style="width: 250px; text-align: center;">
						<img src="images/Pokemon.jpg" class="card-img-top" height="150px"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">Pokemon</h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<div class="card-footer">
								<button type="button" class="btn btn-danger">
									<i class="fas fa-thumbs-up"></i>Thích
								</button>
								<button type="button" class="btn btn-warning">
									<i class="fas fa-share"></i>Share
								</button>
							</div>
						</div>
					</div>
					<div class="card float-left mr-4 mb-2"
						style="width: 250px; text-align: center;">
						<img src="images/Sword-Art.jpg" class="card-img-top"
							height="150px" alt="...">
						<div class="card-body">
							<h5 class="card-title">Sword-Art</h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<div class="card-footer">
								<button type="button" class="btn btn-danger">
									<i class="fas fa-thumbs-up"></i>Thích
								</button>
								<button type="button" class="btn btn-warning">
									<i class="fas fa-share"></i>Share
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="">
					<div class="card float-left mr-4"
						style="width: 250px; text-align: center;">
						<img src="images/Sailor-Moon.jpg" class="card-img-top"
							height="150px" alt="...">
						<div class="card-body">
							<h5 class="card-title">Sailor-Moon</h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<div class="card-footer">
								<button type="button" class="btn btn-danger">
									<i class="fas fa-thumbs-up"></i>Thích
								</button>
								<button type="button" class="btn btn-warning">
									<i class="fas fa-share"></i>Share
								</button>
							</div>
						</div>
					</div>
					<div class="card float-left mr-4"
						style="width: 250px; text-align: center;">
						<img src="images/Death-Note.jpg" class="card-img-top"
							height="150px" alt="...">
						<div class="card-body">
							<h5 class="card-title">Death-Note</h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<div class="card-footer">
								<button type="button" class="btn btn-danger">
									<i class="fas fa-thumbs-up"></i>Thích
								</button>
								<button type="button" class="btn btn-warning">
									<i class="fas fa-share"></i>Share
								</button>
							</div>
						</div>
					</div>
					<div class="card float-left mr-4"
						style="width: 250px; text-align: center;">
						<img src="images/Detective-conan.jpg" class="card-img-top"
							height="150px" alt="...">
						<div class="card-body">
							<h5 class="card-title">Detective-Conan</h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<div class="card-footer">
								<button type="button" class="btn btn-danger">
									<i class="fas fa-thumbs-up"></i>Thích
								</button>
								<button type="button" class="btn btn-warning">
									<i class="fas fa-share"></i>Share
								</button>
							</div>
						</div>
					</div>
				</div>
			</section>
			<aside class="col-md-3 mt-2">
				<div class="card-poly">
					<div class="card">
						<div class="card-body row">
							<div class="col-5">
								<img src="images/shoppingcart.gif" alt="" class="img-fluid" />
							</div>
							<div class="col-7" style="list-style: none">
								<li>100 items</li>
								<li>100$</li>
								<li><a href="#">View Cart</a></li>
							</div>
						</div>
					</div>
					<div id="accordion">
						<div class="card">
							<div class="card-header p-0" id="headingOne">
								<h5 class="mb-0">
									<button class="btn btn-primary container-fluid text-left"
										data-toggle="collapse" data-target="#collapseOne"
										aria-expanded="true" aria-controls="collapseOne">
										<i class="fas fa-list"></i> THỂ LOẠI
									</button>
								</h5>
							</div>

							<div id="collapseOne" class="collapse show"
								aria-labelledby="headingOne" data-parent="#accordion">
								<div class="card-body p-0">
									<ul class="list-group" style="list-style: none">
										<li class="list-group-item"><a href="#" class="text-dark">Điện
												thoại di động <span
												class="badge badge-secondary float-right">20</span>
										</a></li>
										<li class="list-group-item"><a href="#" class="text-dark">Máy
												tính sách tay <span
												class="badge badge-secondary float-right">3</span>
										</a></li>
										<li class="list-group-item"><a href="#" class="text-dark">Máy
												tính để bàn <span class="badge badge-secondary float-right">7</span>
										</a></li>
										<li class="list-group-item"><a href="#" class="text-dark">Quạt
												máy <span class="badge badge-secondary float-right">9</span>
										</a></li>
										<li class="list-group-item"><a href="#" class="text-dark">Tiv
												<span class="badge badge-secondary float-right">11</span>
										</a></li>
										<li class="list-group-item"><a href="#" class="text-dark">Tủ
												lạnh<span class="badge badge-secondary float-right">15</span>
										</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header p-0" id="headingTwo">
								<h5 class="mb-0">
									<button class="btn btn-info container-fluid text-left"
										data-toggle="collapse" data-target="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo">
										<div class="font-weight-bold">
											<i class="fas fa-receipt"></i> TOP ANIME
										</div>
									</button>
								</h5>
							</div>
							<div id="collapseTwo" class="collapse"
								aria-labelledby="headingTwo" data-parent="#accordion">
								<div class="card-body">
									<ul class="list-group" style="list-style: none">
										<li class="list-group-item"><a href="#" class="text-dark">Apple</a>
										</li>
										<li class="list-group-item"><a href="#" class="text-dark">Samsung</a>
										</li>
										<li class="list-group-item"><a href="#" class="text-dark">Nokia</a>
										</li>
										<li class="list-group-item"><a href="#" class="text-dark">GL</a>
										</li>
										<li class="list-group-item"><a href="#" class="text-dark">Sony
												Ericson</a></li>
										<li class="list-group-item"><a href="#" class="text-dark">Dell</a>
										</li>
										<li class="list-group-item"><a href="#" class="text-dark">Acer</a>
										</li>
										<li class="list-group-item"><a href="#" class="text-dark">HP</a>
										</li>
										<li class="list-group-item"><a href="#" class="text-dark">Toshiba</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header p-0" id="headingThree">
								<h5 class="mb-0">
									<button class="btn btn-success container-fluid text-left"
										data-toggle="collapse" data-target="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree">
										<div class="font-weight-bold">
											<i class="far fa-star"></i> LỊCH CHIẾU PHIM
										</div>
									</button>
								</h5>
							</div>
							<div id="collapseThree" class="collapse"
								aria-labelledby="headingThree" data-parent="#accordion">
								<div class="card-body">
									<ul class="list-group" style="list-style: none">
										<li class="list-group-item"><a href="#" class="text-dark">Hàng
												bán chạy</a></li>
										<li class="list-group-item"><a href="#" class="text-dark">Hàng
												mới</a></li>
										<li class="list-group-item"><a href="#" class="text-dark">Hàng
												giảm giá</a></li>
										<li class="list-group-item"><a href="#" class="text-dark">Hàng
												đặc biệt</a></li>
										<li class="list-group-item"><a href="#" class="text-dark">Hàng
												xem nhiều</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</aside>
		</article>

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