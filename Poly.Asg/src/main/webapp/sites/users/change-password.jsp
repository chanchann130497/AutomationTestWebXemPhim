<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-4 col-4 mt-3">
	<form action="ChangePassword" method="post">
		<div class="card">
			<div class="card-header text-center">
				<b style="font-size: 25px">Change Password</b>
			</div>
			<div class="card-body">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="form-group">
					<label for="username">Username</label> 
					<input type="text"
						class="form-control" name="username" id="username" value="${username }"
						aria-describedby="usernameHI" placeholder="Username"> <small
						id="usernameHI" class="form-text text-muted">Username is
						required</small>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="text"
						class="form-control" name="password" id="password"
						aria-describedby="passwordHI" placeholder="Password"> <small
						id="passwordHI" class="form-text text-muted">Password is
						required text</small>
				</div>
				<div class="form-group">
					<label for="currentPassword">Current Password</label> <input
						type="text" class="form-control" name="currentPassword"
						id="currentPassword" aria-describedby="currentPasswordHI"
						placeholder="CurrentPassword"> <small
						id="currentPasswordHI" class="form-text text-muted">Current
						Password is required text</small>
				</div>
				<div class="form-group">
					<label for="confirmPassword">Confirm Password</label> <input
						type="text" class="form-control" name="confirmPassword"
						id="confirmPassword" aria-describedby="confirmPasswordHI"
						placeholder="Confirm Password"><small
						id="confirmPasswordHI" class="form-text text-muted">Confirm
						Password is required text</small>
				</div>
			</div>
			<div class="card-footer text-muted text-center">
				<button class="btn btn-success">Change Password</button>
			</div>
		</div>
	</form>
</div>