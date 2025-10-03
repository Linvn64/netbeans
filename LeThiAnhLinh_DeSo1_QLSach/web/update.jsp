<%-- 
    Document   : update
    Created on : Jun 2, 2025, 6:00:51 PM
    Author     : anhlinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Sach" %> 
<!DOCTYPE html>
<html>
    
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>QUẢN LÝ SÁCH</title>
    <style>
        form {
            display: flex;
            align-items: center;
            margin-top: 50px;
            flex-direction: column;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.15);
            width: fit-content;
            padding: 15px;
            border-radius: 15px;
            justify-content: center;
            gap: 15px;
        }
        input {
            border: none;
            color: black;
            box-shadow: 0 8px 16px grey;
            border-radius: 5px;
            padding: 10px;
            margin: 5px;
        }
    </style>
</head>

<body>
<%
    Sach data = (Sach) request.getAttribute("data");
%>

<center>
    <h1>QUẢN LÝ SÁCH - SỬA THÔNG TIN SÁCH</h1>

    <form action="update" method="post">
        <table border="0" align="center">
            <tr>
                <td>Mã sách:</td>
                <td><input type="text" name="ma" value="<%= data.getMa() %>" readonly/></td>
            </tr>
            <tr>
                <td>Tên sách:</td>
                <td><input type="text" name="ten" value="<%= data.getTen() %>" required/></td>
            </tr>
            <tr>
                <td>Nhà xuất bản:</td>
                <td><input type="text" name="nhaxb" value="<%= data.getNhaxb() %>" required/></td>
            </tr>
            <tr>
                <td>Tác giả:</td>
                <td><input type="text" name="tacgia" value="<%= data.getTacgia() %>" required/></td>
            </tr>
            <tr>
                <td>Giá:</td>
                <td><input type="number" name="gia" value="<%= data.getGia() %>" required/></td>
            </tr>
            <tr>
                <td>Ảnh:</td>
                <td><input type="text" name="anh" value="<%= data.getAnh() %>" required/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Lưu"/>
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
