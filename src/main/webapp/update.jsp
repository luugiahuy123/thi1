<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 15/03/2024
  Time: 4:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>cập nhật</h1>
<form href="/student" method="post">

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
            <option value="${clazz.getId()}">${clazz.getName()}</option>
        </c:forEach>
    </select>
    <input type="submit" value="cập nhật">
</form>
</body>
</html>
