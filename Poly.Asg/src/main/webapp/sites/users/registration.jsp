<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-8 offset-2 mt-3">
	<form action="" method="post">
		${Routes.SITE_REGISTRATION_SHOW }
		<div class="card">
			<div class="card-header text-center">
				<b style="font-size: 25px">Registration</b>
			</div>
			<div class="card-body">
				<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								value="${user.username }" class="form-control" name="username"
								id="username" aria-describedby="usernameHI"
								placeholder="Username"> <small id="usernameHI"
								class="form-text text-muted">Username is required</small>
						</div>
						<div class="form-group">
							<label for="fullname">Fullname</label> <input type="text"
								value="${user.fullname }" class="form-control" name="fullname"
								id="fullname" aria-describedby="fullnameHI"
								placeholder="Fullname"> <small id="fullnameHI"
								class="form-text text-muted">Fullname is required</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" name="password" id="password"
								aria-describedby="passwordHI" placeholder="Password"> <small
								id="passwordHI" class="form-text text-muted">Password is
								required </small>
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="text"
								value="${user.email }" class="form-control" name="email"
								id="email" aria-describedby="emailHI" placeholder="Email">
							<small id="emailHI" class="form-text text-muted">Email is
								required</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted text-center">
				<button class="btn btn-success">Sign Up</button>
			</div>
		</div>
	</form>
</div>