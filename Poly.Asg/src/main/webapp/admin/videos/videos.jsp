<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<div class="col mt-4">
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="videoEditing"
			aria-selected="true"><i class="float-left p-1 fas fa-play" aria-hidden="true"></i>Video Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false"><i class="float-left p-1 fas fa-list" aria-hidden="true"></i>Video List</a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="post" enctype="multipart/form-data">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<div class="border p3">
									<img
										src="${video.poster !=null?video.poster: 'images/5cm_1.jpg' }"
										alt="" class="img-fluid" />
									<div class="input-group mb-3 mt-3">
										<div class="input-group-prepend">
											<span class="input-group-text "><i class="float-left p-1 fas fa-folder-plus" aria-hidden="true"></i>Upload</span>
										</div>
										<div class="custom-file">
											<input type="file" class="custom-file-input" id="cover"
												name="cover" /> <label for="cover"><i class="float-left p-1 fas fa-file-image" aria-hidden="true"></i>Choose File</label>
										</div>
									</div>
								</div>
							</div>
							<div class="col-9">
								<div class="form-group">
									<label for="youtubeId"><i class="float-left p-1 fab fa-youtube" aria-hidden="true"></i>Youtube ID</label> <input type="text"
										class="form-control" name="videoId" id="youtubeId"
										value="${video.videoId }" aria-describedby="youtubeIdHI"
										placeholder=""> <small id="youtubeIdHI"
										class="form-text text-muted">Youtube ID is required</small>
								</div>
								<div class="form-group">
									<label for="videoTitle"><i class="float-left p-1 fas fa-bookmark" aria-hidden="true"></i>Video Title</label> <input type="text"
										class="form-control" name="title" id="videoTitle"
										value="${video.title }" aria-describedby="videoTitleHI"
										placeholder=""> <small id="videoTitleHI"
										class="form-text text-muted">Video Title is required</small>
								</div>
								<div class="form-group">
									<label for="viewCount"><i class="float-left p-1 fas fa-binoculars" aria-hidden="true"></i>View Count</label> <input type="text"
										class="form-control" name="views" id="viewCount"
										value="${video.views }" aria-describedby="viewCountHI"
										placeholder=""> <small id="viewCountHI"
										class="form-text text-muted">ViewCount is required</small>
								</div>
								<div class="form-check form-check-inline">
									<label style="padding: 3px;"><input type="radio"
										class="form-check-input" name="active" id="status"
										value="true" ${video.active? 'checked':'' }>Active</label> <label
										style="padding: 3px;"><input type="radio"
										class="form-check-input" name="active" id="status"
										value="false" ${! video.active? 'checked':'' }>Inactive</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<label for="description"><i class="float-left p-1 fas fa-atom" aria-hidden="true"></i>Description</label>
								<textarea name="description" id="description" cols="30" rows="4"
									class="form-control">${video.description }</textarea>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted text-center">
						<button class="btn btn-primary"
							formaction="Admin/VideosManagement/create">
							<i class="float-left p-1 fas fa-folder-plus" aria-hidden="true"></i>Create
						</button>
						<button class="btn btn-warning"
							formaction="Admin/VideosManagement/update">
							<i style="padding: 3px" class="float-left p-1 fa fa-wrench"></i>Update
						</button>
						<button class="btn btn-danger"
							formaction="Admin/VideosManagement/delete">
							<i style="padding: 3px" class="float-left p-1 fa fa-trash"></i>Delete
						</button>
						<button class="btn btn-info"
							formaction="Admin/VideosManagement/reset">
							<i class="float-left p-1 fas fa-redo" aria-hidden="true"></i>Reset
						</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<table class="table table-stripe">
				<tr>
					<td scope="col">Youtube ID</td>
					<td scope="col">Video Title</td>
					<td scope="col">View Count</td>
					<td scope="col">Status</td>
					<td scope="col">&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${videos }">
					<tr>
						<td scope="row">${item.videoId }</td>
						<td>${item.title }</td>
						<td>${item.views }</td>
						<td>${item.active? 'Active': 'Deactive' }</td>
						<td><a
							href="Admin/VideosManagement/edit?videoId=${item.videoId }"><i
								style="padding: 3px" class="float-left p-1 fa fa-edit"></i>Edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>