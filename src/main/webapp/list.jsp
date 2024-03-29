<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Quản lý học viên</h1>
    <form action="/student" method="post">
        <input type="hidden" value="search" name="action">
        <table>
            <tr>
                <td>
                    <div class="container">
                        <div class="form-group">
                            <input type="text" name="name" value="${name}" class="form-control" id="exampleInput"
                                   placeholder="Name search...">
                        </div>
                    </div>
                </td>
                <td>
                    <button class="btn btn-primary">Search</button>
                </td>
            </tr>
        </table>
    </form>
    <div class="mb-3">
        <a class="btn btn-primary" href="/student?action=create">Thêm</a>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Class</th>
            <th>Chỉnh sửa</th>
            <th>Xóa</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.date}</td>
                <td>${student.address}</td>
                <td>${student.phone}</td>
                <td>${student.email}</td>
                <td>${student.className}</td>
                <td>
                    <a class="btn btn-info" href="/student?action=update&id=${student.id}">Chỉnh sửa</a>
                </td>
                <td>
                    <a class="btn btn-danger" href="/student?action=remove&id=${student.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS (Tùy chọn nếu bạn muốn sử dụng các tính năng JavaScript của Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
