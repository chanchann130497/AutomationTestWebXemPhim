<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-4 col-4 mt-3">
	<form action="" method="post">
	
		<div class="card">
			<div class="card-header text-center">
				<b style="font-size: 25px">Login to System</b>
			</div>
			<div class="card-body">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="form-group">
					<label for="username">Username</label><input type="text"
						class="form-control" name="username" id="username"
						aria-describedby="usernameHI" placeholder="Username"><small
						id="usernameHI" class="form-text text-muted">Username is
						required text</small>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password" id="password"
						aria-describedby="passwordHI" placeholder="Password"> <small
						id="passwordHI" class="form-text text-muted">Password is
						required text</small>
				</div>
				<div class="form-check form-check-inline">
					<label> <input type="checkbox" class="form-check-input"
						name="remember">Remember me
					</label>
				</div>
			</div>
			<div class="card-footer text-muted text-center">
				<button style="font-weight: bold; font-size: 15px"
					class="btn btn-secondary btn-md btn-block">Login</button>
				<hr>
				<button type="button" class="btn btn-primary btn-md btn-block">
					<a href=""
						style="font-size: 15px; color: white; text-decoration: none; font-weight: bold"><i
						style="font-size: 20px" class="fab fa-facebook-f float-left"></i>Đăng
						nhập với Facebook</a>
				</button>
				<button type="button" class="btn btn-danger btn-md btn-block">
					<a href=""
						style="font-size: 15px; color: white; text-decoration: none; font-weight: bold"><i
						style="font-size: 20px" class="fab fa-google-plus-g float-left"></i>Đăng
						nhập với Google</a>
				</button>
			</div>
		</div>
	</form>
</div>