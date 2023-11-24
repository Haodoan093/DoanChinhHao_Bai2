<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-md-4">
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">
				Them GV</a>
					<a href="<%=request.getContextPath()%>/showall" class="btn btn-success">
				Tat ca</a>
		</div>
		<div class="col-md-8">
			<form action="search" class="form-inline" method="get">

				<div class="form-group mx-sm-3 mb-2">
					<label for="inputPassword2" class="sr-only">Ten</label> 
					<input name="searchName" type="text" class="form-control"
						id="inputPassword2" placeholder="search by ho ten"> 
						<input name="searchMa" type="number" class="form-control"
						id="inputPassword2" placeholder="search by ma">
				</div>
				<button type="submit" class="btn btn-primary mb-2">Search</button>
			</form>
			
		
		   
		</div>
		
	</div>
	<table class="table">
		<thead class="thead-dark">
			<tr>

				<th scope="col">MaGV</th>
				<th scope="col">Ho ten</th>
				<th scope="col">Ngay sinh</th>
				<th scope="col">Ten bo mon</th>
				<th scope="col">He so luong</th>
				<th scope="col">Action</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="tempGV" items="${lsGV}">
				<tr>

					<td><c:out value="${tempGV.maGV }" /></td>
					<td><c:out value="${tempGV.hoten }" /></td>
					<td><c:out value="${tempGV.ngaysinh }" /></td>
					<td><c:out value="${tempGV.tenbomon }" /></td>
					<td><c:out value="${tempGV.hesoluong }" /></td>
					<td><a href="edit?id=<c:out value='${tempGV.maGV }' />">Edit</a>
						/ <a href="delete?id=<c:out value='${tempGV.maGV }' />">Xoa</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>


	</table>




	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>

</body>
</html>