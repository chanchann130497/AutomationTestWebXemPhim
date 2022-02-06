<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<div class="col mt-4">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="userEditing-tab" data-toggle="tab"
			href="#userEditing" role="tab" aria-controls="userEditing"
			aria-selected="true"><i class="float-left p-1 far fa-edit" aria-hidden="true"></i>User Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="userList-tab" data-toggle="tab" href="#userList" role="tab"
			aria-controls="userList" aria-selected="false"><i class="float-left p-1 fas fa-users" aria-hidden="true"></i>User List</a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="userEditing"
			role="tabpanel" aria-labelledby="userEditing-tab">
			<form action="" method="post">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col">
								<div class="form-group">
									<label for="username"><i class="float-left p-1 fas fa-id-card" aria-hidden="true"></i>Username</label> <input type="text"
										class="form-control" name="username" id="username"
										value="${form.username }">
								</div>
								<div class="form-group">
									<label for="fullname"><i class="float-left p-1 fas fa-address-card" aria-hidden="true"></i>Fullname</label> <input type="text"
										class="form-control" name="fullname" id="fullname"
										value="${form.fullname }">
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label for="password"><i class="float-left p-1 fas fa-key" aria-hidden="true"></i>Password</label> <input type="password"
										class="form-control" name="password" id="password"
										value="${form.password }">
								</div>
								<div class="form-group">
									<label for="email"><i class="float-left p-1 fas fa-at" aria-hidden="true"></i>Email</label> <input type="text"
										class="form-control" name="email" id="email"
										value="${form.email }">
								</div>
								<div class="form-check form-check-inline">
									<label>Role : </label> <label class="ml-2"> <input
										type="radio" class="form-check-input" name="admin"
										value="true" ${form.admin? 'checked':'' } />Admin
									</label> <label class="ml-2"> <input type="radio"
										class="form-check-input" name="admin" value="flase"
										${ !form.admin? 'checked':'' } />User
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted text-center">
						<button class="btn btn-primary"
							formaction="Admin/UsersManagement/create">
							<i class="float-left p-1 fas fa-folder-plus" aria-hidden="true"></i>Create
						</button>
						<button class="btn btn-warning"
							formaction="Admin/UsersManagement/update">
							<i style="padding: 3px" class="float-left p-1 fa fa-wrench"></i>Update
						</button>
						<button class="btn btn-danger"
							formaction="Admin/UsersManagement/delete">
							<i style="padding: 3px" class="float-left p-1 fa fa-trash"></i>Delete
						</button>
						<button class="btn btn-info"
							formaction="Admin/UsersManagement/reset">
							<i class="float-left p-1 fas fa-redo" aria-hidden="true"></i>Reset
						</button>

					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="userList" role="tabpanel"
			aria-labelledby="userList-tab">
			<table class="table table-stripe">
				<tr>
					<td scope="col">Username</td>
					<td scope="col">Fullname</td>
					<td scope="col">Email</td>
					<td scope="col">Role</td>
					<td scope="col">&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${listUser }">
					<tr>
						<td scope="row">${item.username }</td>
						<td>${item.fullname }</td>
						<td>${item.email }</td>
						<td>${item.admin ? 'admin' : 'user' }</td>
						<td><a
							href="Admin/UsersManagement/edit?username=${item.username }"><i
								style="padding: 3px" class="fa fa-edit"></i>Edit</a> <a
							href="Admin/UsersManagement/delete?username=${item.username }"><i
								style="padding: 3px" class="fa fa-edit"></i>Delete</a>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>