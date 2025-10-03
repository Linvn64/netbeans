<%@page import="java.util.List"%>
<%@page import="models.Nhanvien"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%
    List<Nhanvien> list = (List<Nhanvien>) request.getAttribute("data");
    String keyword = (String) request.getAttribute("keyword");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Tìm Kiếm</title>
</head>
<body>
<center>
    <h2>Tìm kiếm nhân viên</h2>

    <form action="search" method="get">
        <input type="text" name="keyword" value="<%= keyword != null ? keyword : "" %>" />
        <input type="submit" value="Tìm kiếm"/>
        <a href="home">Quay lại trang chủ</a>
    </form>

    <br>

    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Mã Nhân Viên</th>
            <th>Họ Tên</th>
            <th>Ngày Sinh</th>
            <th>Giới Tính</th>
            <th>Điện Thoại</th>
        </tr>

        <% if (list != null && !list.isEmpty()) {
            for (Nhanvien nv : list) { %>
                <tr>
                    <td><%= nv.getMaNV() %></td>
                    <td><%= nv.getHoTen() %></td>
                    <td><%= nv.getNgaySinh() %></td>
                    <td><%= nv.isGioiTinh() ? "Nam" : "Nữ" %></td>
                    <td><%= nv.getDienThoai() %></td>
                </tr>
        <%  } 
        } else { %>
            <tr><td colspan="5">Không tìm thấy nhân viên nào.</td></tr>
        <% } %>
    </table>

    <br>
    <a href="home">← Quay về trang chủ</a>
</center>
</body>
</html>
