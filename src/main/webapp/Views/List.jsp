<%--
  Created by IntelliJ IDEA.
  User: hotan
  Date: 11/1/2024
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>

<body>
<form action="List" method="post">
    Ma Account : <input type="text" name="accountID" id="accountID"/><br></br>
    Ten Chu Tai Khoan : <input type="text" name="tenChu" id="tenChu"/><br></br>
    So tai khoan : <input type="text" name="sotai" id="sotai"/><br></br>
    Dia chi : <input type="text" name="dichi" id="dichi"/><br></br>
    So du : <input type="text" name="sosi" id="sosi"/><br></br>
    <input type="submit" name="action" value="Them"> </br>
</form>

<form action="List" method="get">
    Tim Kiem : <input type="text" name="ti" id="ti"/>
    <select id="filterSelect">
    </select>
    <input type="submit" name="action" value="Search"/>
</form>

<table border="1">
    <thead>
    <tr>
        <th>Ma Account</th>
        <th>Ten Chu Tai Khoan</th>
        <th>So Tai Khoan</th>
        <th>Dia Chi</th>
        <th>So Du</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${accounts}" var="item">
        <tr>
            <td>${item.account_ID}</td>
            <td>${item.account_name}</td>
            <td>${item.card_Number}</td>
            <td>${item.account_address}</td>
            <td>${item.amount}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<script>
    {/*DOMContentLoaded event: Đảm bảo rằng mã JavaScript chỉ chạy sau
     khi toàn bộ nội dung trang đã được tải.*/}
    document.addEventListener('DOMContentLoaded', () => {
        const danhSachChonLoc = ["", "MaAccount", "TenChuTaiKhoan", "SoTaiKhoan", "DiaChi", "SoDu"];
        const select = document.getElementById("filterSelect");
        danhSachChonLoc.forEach(item => {
            const option = document.createElement("option");
            option.value = item;
            option.textContent = item;
            select.appendChild(option);
        });
    });
</script>

</body>
</html>
