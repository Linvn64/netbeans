<%-- 
    Document   : hienthi
    Created on : Jun 10, 2025, 8:20:57 AM
    Author     : anhlinh
--%>

<%@page import="java.util.List"%>
<%@page import="models.Nhanvien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME Page</title>
        <style>
            table,th,  td, tr {
                border: 1px solid black;
                border-collapse: collapse;
                text-align: center; 
            }

        </style>
    </head>
    <body>
    <center>
        <a href="them.jsp">Them Nhan Vien</a>
        <a href="timkiem.jsp">Tim Kiem</a>
        <table >
            <tr>
                <th>Ma Nhan Vien</th>
                <th>Ho Ten</th>
                <th>Ngay Sinh</th>
                <th>Gioi Tinh</th>
                <th>Dien Thoai</th>
                <th>Hanh Doong</th>
            </tr>

            <%
                List<Nhanvien> list = (List<Nhanvien>) request.getAttribute("data");
                for (Nhanvien nv : list) {
            %>
            <tr>
                <td><%= nv.getMaNV()%></td>
                <td><%= nv.getHoTen()%></td>
                <td><%= nv.getNgaySinh()%></td>
                <td>
                    <%= nv.isGioiTinh() ? "Nam" : "Nu"%>     
                </td>
                <td><%= nv.getDienThoai()%></td>
                <td>
                    <a href="update?manv=<%=nv.getMaNV()%>">sua</a>
                    <a href="delete?maNV=<%=nv.getMaNV()%>">Xoa</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </center>
</body>
</html>
