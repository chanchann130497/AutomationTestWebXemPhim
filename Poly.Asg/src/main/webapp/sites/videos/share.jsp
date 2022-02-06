<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<div class="offset-3 col-6 mt-3">
	<form action="ShareVideo" method="post">
		<input type="hidden" name="videoId" value="${videoId }" />
		<div class="card">
			<div class="card-header">Send Video To Your Friends</div>
			<div class="card-body">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="">Your Friend Email :</label> <input type="text"
								class="form-control" name="email" id="email"
								aria-describedby="EmailHelpId" placeholder="enter email">
							<small id="emailHelpId" class="form-text text-muted">Email
								is required</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer">
				<button class="btn btn-success">Send</button>
			</div>
		</div>
	</form>
</div>