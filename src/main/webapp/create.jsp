<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới</title>
</head>
<body>
<h1>Thêm mới</h1>
<form method="post" href="/student">

    <label for="name">Tên:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="date">Ngày:</label>
    <input type="date" id="date" name="date_of_birth" required><br>

    <label for="address">Địa chỉ:</label>
    <input type="text" id="address" name="address"><br>

    <label for="phone">Số điện thoại:</label>
    <input type="text" id="phone" name="phone_number"><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br>

    <label for="className">Tên lớp:</label>
    <select type="text" id="className" name="lop_hoc_id">
        <c:forEach var="clazz" items="${clazz}">
            <option value="${clazz.id}">${clazz.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Thêm mới">
</form>
</body>
</html>
