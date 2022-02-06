<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col-8">
	<div class="row">
		<c:forEach var="item" items="${videos }">
			<div class="col-3 mt-4">

				<div class="card text-center">
					<div class="card-header">
						<img
							src="${empty item.poster ? 'images/Sword-Art.jpg' : item.poster }"
							class="img-fluid" style="height: 150px" width="100%" alt="">
					</div>
					<div class="card-body">
						<h5>${item.title}</h5>
					</div>
					<div class="card-footer">
						<a href="LikeVideo?videoId=${item.videoId }"
							class="btn btn-danger"> <i
							class="p-1 float-left fas fa-thumbs-up"></i>Like
						</a> <a href="ShareVideo?videoId=${item.videoId }"
							class="btn btn-warning"> <i
							class="p-1 float-left fas fa-share"></i>Share
						</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="row mt-4" style="margin-left: 300px">
		<div class="col">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<div class="col-4 mt-4" id="accordion">
	<div class="card">
		<div class="card-header p-0" id="headingOne">
			<h5 class="mb-0">
				<button class="btn btn-primary container-fluid text-left"
					data-toggle="collapse" data-target="#collapseOne"
					aria-expanded="true" aria-controls="collapseOne">
					<i class="fas fa-list"></i> Xem nhiều nhất
				</button>
			</h5>
		</div>

		<div id="collapseOne" class="collapse show"
			aria-labelledby="headingOne" data-parent="#accordion">
			<div class="card-body p-0">
				<ul class="list-group" style="list-style: none">
					<li class="list-group-item">
						<div class="row">
							<div class="col-8">
								<iframe width="280" height="180"
									src="https://www.youtube.com/embed/bY2B_oC9g-k"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
							</div>
							<div class="col-4">
								<strong style="float: left;">Japanese Music</strong>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-8">
								<iframe width="280" height="180"
									src="https://www.youtube.com/embed/GvKAZ0NJu8Q"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
							</div>
							<div class="col-4">
								<strong style="float: left;">China Music</strong>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-8">
								<iframe width="280" height="180"
									src="https://www.youtube.com/embed/QMpDF4opxyQ"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
							</div>
							<div class="col-4">
								<strong style="float: left;">Là ai mang nắng</strong>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-8">
								<iframe width="280" height="180"
									src="https://www.youtube.com/embed/pse2JFM0rno"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
							</div>
							<div class="col-4">
								<strong style="float: left;">Mãi chẳng thuộc về</strong>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="card">
		<div class="card-header p-0" id="headingTwo">
			<h5 class="mb-0">
				<button class="btn btn-warning container-fluid text-left"
					data-toggle="collapse" data-target="#collapseTwo"
					aria-expanded="false" aria-controls="collapseTwo">
					<div class="font-weight-bold">
						<i class="fas fa-receipt"></i> Yêu thích
					</div>
				</button>
			</h5>
		</div>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordion">
			<div class="card-body">
				<ul class="list-group" style="list-style: none">
					
					<li class="list-group-item">
						<div class="row">
							<div class="col-8">
								<iframe width="280" height="180"
									src="https://www.youtube.com/embed/e2Xx7WcvEns"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
							</div>
							<div class="col-4">
								<strong style="float: left;">Name</strong>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-8">
								<iframe width="280" height="180"
									src="https://www.youtube.com/embed/iM-7kXsZNW4"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
							</div>
							<div class="col-4">
								<strong style="float: left;">Bông hoa đẹp nhất</strong>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-8">
								<iframe width="280" height="180"
									src="https://www.youtube.com/embed/DXHgBUMnlvY"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
							</div>
							<div class="col-4">
								<strong style="float: left;">张远 - 嘉宾</strong>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="card">
		<div class="card-header p-0" id="headingThree">
			<h5 class="mb-0">
				<button class="btn btn-danger container-fluid text-left"
					data-toggle="collapse" data-target="#collapseThree"
					aria-expanded="false" aria-controls="collapseThree">
					<div class="font-weight-bold">
						<i class="far fa-star"></i> Tổng hợp
					</div>
				</button>
			</h5>
		</div>
		<div id="collapseThree" class="collapse"
			aria-labelledby="headingThree" data-parent="#accordion">
			<div class="card-body">
				<ul class="list-group" style="list-style: none">
					<li class="list-group-item">
						<div class="row">
							<div class="col-8">
								<iframe width="280" height="180"
									src="https://www.youtube.com/embed/IdJhBmqYlIc"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
							</div>
							<div class="col-4">
								<strong style="float: left;">Name</strong>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-8">
								<iframe width="280" height="180"
									src="https://www.youtube.com/embed/fd_ekhiuB6w"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
							</div>
							<div class="col-4">
								<strong style="float: left;">Name</strong>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-8">
								<iframe width="280" height="180"
									src="https://www.youtube.com/embed/xypzmu5mMPY"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
							</div>
							<div class="col-4">
								<strong style="float: left;">Name</strong>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-8">
								<iframe width="280" height="180"
									src="https://www.youtube.com/embed/6t-MjBazs3o"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
							</div>
							<div class="col-4">
								<strong style="float: left;">Name</strong>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>


