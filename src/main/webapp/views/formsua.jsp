<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container col-md-5 ">
		<div class="card" style="width: 32rem; margin-top: 100px;">

			<div class="card-body">
				<h5 class="card-title">Thêm giảng viên</h5>
				<form action="update" method="GET">
					<div class="form-group">
						
					<c:if test="${gv !=null }">
					<input type="hidden" name="id" value="<c:out value='${gv.maGV }'/>" />
				</c:if>
				<c:if test="${gv !=null }">
						<label for="name">Họ tên</label> <input type="text"
							class="form-control" value="<c:out value='${gv.hoten }'/>"
							id="name" name="hoten" placeholder="Name" required>

						<div class="form-group">
							<label for="Age">Ngày sinh</label> <input type="text"
								name="ngaysinh" value="<c:out value='${gv.ngaysinh }'/>" class="
								form-control" id="Age" placeholder="Ngay sinh" required>
						</div>
						<div class="form-group">
							<label for="Age">Tên bộ môn</label> <input type="text"
								name="tenbomon" value="<c:out value='${gv.tenbomon }'/> "class="
								form-control" id="Age" placeholder="Ten bo mon" required>
						</div>
						<div class="form-group">
							<label for="Age">Hệ số lương</label> <input type="text"
								name="hesoluong"
								value="<c:out value='${gv.hesoluong }'/> "class="
								form-control" id="Age" placeholder="He so luong" required>
						</div>

						<button type="submit" class="btn btn-primary">Sửa</button>
						</c:if>
				</form>

			</div>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>
</html>