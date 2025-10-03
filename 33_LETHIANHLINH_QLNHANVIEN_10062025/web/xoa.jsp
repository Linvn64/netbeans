<%-- 
    Document   : xoa
    Created on : Jun 10, 2025, 8:37:39 AM
    Author     : anhlinh
--%>

<%@page import="models.Nhanvien"%>
<% 
    Nhanvien nv = (Nhanvien) request.getAttribute("data");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XOA NHAN VIEN</title>
    </head>
    <body>
    <center>
        <form action="delete" method="post">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="maNV" value="<%=nv.getMaNV()%>" />
            Mã NV: <%= nv.getMaNV()%><br>
            Họ tên: <%= nv.getHoTen()%><br>
            Ngày sinh: <%= nv.getNgaySinh()%><br>
            Giới tính: <%= nv.isGioiTinh() ? "Nam" : "Nữ"%><br>
            Điện thoại: <%= nv.getDienThoai()%><br><br>

            <button type="submit" onclick="return confirm('Xác nhận xoá?')">Xoá</button>
            <a href="home">Huỷ</a>
        </form>
    </center>
    </body>
</html>
