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
	<main class="container-fluid">
		<nav class="row">
			<nav class="navbar navbar-expand-md navbar-light bg-light col">
				<a class="navbar-brand" href="#">Admin</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-toggle="collapse" data-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link" href="#">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="VideosManagement"> <i
								class="fas fa-film"></i> Videos
						</a></li>
						<div class="nav-item">
							<a href="" class="nav-link"><i class="fa fa-id-card"></i>
								Users</a>
						</div>
						<div class="nav-item">
							<a href="" class="nav-link"><i class="fa fa-comments"></i>
								Reports</a>
						</div>
					</ul>
				</div>
			</nav>
		</nav>
		<section class="row">
			<div class="col mt-4">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="videoEditing-tab" data-toggle="tab"
						href="#videoEditing" role="tab" aria-controls="videoEditing"
						aria-selected="true">Video Editing</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
						aria-controls="videoList" aria-selected="false">Video List</a></li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="videoEditing"
						role="tabpanel" aria-labelledby="videoEditing-tab">
						<form action="" method="post">
							<div class="card">
								<div class="card-body">
									<div class="row">
										<div class="col-3">
											<div class="border p3">
												<img src="images/dragon_ball.jpg" style="height: 300px"
													alt="" class="img-fluid" />
											</div>
										</div>
										<div class="col-9">
											<div class="form-group">
												<label for="youtubeId">Youtube ID</label> <input type="text"
													class="form-control" name="youtubeId" id="youtubeId"
													aria-describedby="youtubeIdHI" placeholder=""> <small
													id="youtubeIdHI" class="form-text text-muted">Youtube
													ID is required</small>
											</div>
											<div class="form-group">
												<label for="videoTitle">Video Title</label> <input
													type="text" class="form-control" name="videoTitle"
													id="videoTitle" aria-describedby="videoTitleHI"
													placeholder=""> <small id="videoTitleHI"
													class="form-text text-muted">Video Title is
													required</small>
											</div>
											<div class="form-group">
												<label for="viewCount">View Count</label> <input type="text"
													class="form-control" name="viewCount" id="viewCount"
													aria-describedby="viewCountHI" placeholder=""> <small
													id="viewCountHI" class="form-text text-muted">ViewCount
													is required</small>
											</div>
											<div class="form-check form-check-inline">
												<label style="padding: 3px;"><input type="radio"
													class="form-check-input" name="status" id="status"
													value="true" />Active</label> <label style="padding: 3px;"><input
													type="radio" class="form-check-input" name="status"
													id="status" value="false" />Inactive</label>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<label for="description">Description</label>
											<textarea name="description" id="description" cols="30"
												rows="4" class="form-control"></textarea>
										</div>
									</div>
								</div>
								<div class="card-footer text-muted text-center">
									<button class="btn btn-primary">
										<i style="padding: 3px" class="fas fa-folder-plus"></i>Create
									</button>
									<button class="btn btn-warning">
										<i style="padding: 3px" class="fas fa-wrench"></i>Update
									</button>
									<button class="btn btn-danger">
										<i style="padding: 3px" class="fas fa-trash"></i>Delete
									</button>
									<button class="btn btn-info">
										<i style="padding: 3px" class="fas fa-redo"></i>Reset
									</button>
								</div>
							</div>
						</form>
					</div>
					<div class="tab-pane fade" id="videoList" role="tabpanel"
						aria-labelledby="videoList-tab">
						<table class="table table-stripe">
							<tr>
								<td scope="col">#</td>
								<td scope="col">Youtube ID</td>
								<td scope="col">Video Title</td>
								<td scope="col">View Count</td>
								<td scope="col">Status</td>
								<td scope="col">&nbsp;</td>
							</tr>
							<tr>
								<td scope="row">1</td>
								<td>YTT</td>
								<td>Dragon Ball</td>
								<td>105</td>
								<td>Active</td>
								<td><a href=""><i style="padding: 3px"
										class="fas fa-edit"></i>Edit</a> <a href=""><i
										style="padding: 3px" class="fas fa-trash"></i>Delete</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</section>
		<footer class="row"></footer>
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


	<script>
		$('#myTab a').on('click', function(event) {
			event.preventDefault()
			$(this).tab('show')
		})
	</script>
</body>
</html>