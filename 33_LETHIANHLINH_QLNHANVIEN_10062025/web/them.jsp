<%-- 
    Document   : them
    Created on : Jun 10, 2025, 9:33:13 AM
    Author     : anhlinh
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>THEM Page</title>
        <style>
            input {
                display: block;
            }
            .error {
                color: red;
            }
        </style>
    </head>
    <%
        String manv = request.getParameter("manv") != null ? (String) request.getParameter("manv") : "";
        String hoten = request.getParameter("hoten") != null ? request.getParameter("hoten") : "";
        String ngaysinh = request.getParameter("ngaysinh") != null ? request.getParameter("ngaysinh") : "";
        String gioitinh = request.getParameter("gioitinh") != null ? request.getParameter("gioitinh") : "";

        String dienthoai = request.getParameter("dienthoai") != null ? request.getParameter("dienthoai") : "";

        String error = (String) request.getAttribute("error");
    %>
    <center>
        <h1>THEM</h1>
        <form action="add" method="post">
            <table border="0" align="center">
                <tr>
                    <td>MA NV</td>
                    <td><input type="text" name="manv" value="<%= manv%>"/></td>
                </tr>
                <tr>
                    <td>HO TEN</td>
                    <td><input type="text" name="hoten" value="<%= hoten%>"/></td>
                </tr>
                <tr>
                    <td>NGAY SINH</td>
                    <td><input type="date" name="ngaysinh" value="<%= ngaysinh%>"/></td>
                </tr>
                <tr>
                    <td>GIOI TINH</td>
                    <td><input type="text" name="gioitinh" value="<%= gioitinh%>"/></td>
                </tr>
                <tr>
                    <td>DIEN THOAI</td>
                    <td><input type="text" name="dienthoai" value="<%= dienthoai%>"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Lưu"/>
                    </td>
                </tr>
            </table>
            <a href="nv"><--</a>
        </form>
        <% if (error != null && !error.isEmpty()) {%>
        <div class="error-message" style="color: red;" onclick="return confirm('Trùng mã, vui lòng nhập mã khác!')">
            <%= error%>
        </div>
        <% }%>
    </center>

</body>
</html>