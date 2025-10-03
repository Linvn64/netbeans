<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Nhanvien"%>
<%
    Nhanvien nv = (Nhanvien) request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Nhân Viên</title>
</head>
<body>
    <center>
        <h1>Sửa Thông Tin Nhân Viên</h1>
        <form action="update" method="post">
            <table>
                <tr>
                    <td>Mã NV:</td>
                    <td><input type="text" name="manv" value="<%= nv.getMaNV() %>" readonly /></td>
                </tr>
                <tr>
                    <td>Họ Tên:</td>
                    <td><input type="text" name="hoten" value="<%= nv.getHoTen() %>" /></td>
                </tr>
                <tr>
                    <td>Ngày Sinh:</td>
                    <td><input type="date" name="ngaysinh" value="<%= nv.getNgaySinh() %>" /></td>
                </tr>
                <tr>
                    <td>Giới Tính:</td>
                    <td>
                        <select name="gioitinh">
                            <option value="Nam" <%= nv.isGioiTinh() ? "selected" : "" %>>Nam</option>
                            <option value="Nu" <%= !nv.isGioiTinh() ? "selected" : "" %>>Nữ</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Điện Thoại:</td>
                    <td><input type="text" name="dienthoai" value="<%= nv.getDienThoai() %>" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Cập Nhật" /></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>