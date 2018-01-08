<%--
  Created by IntelliJ IDEA.
  User: Magomed
  Date: 08.01.2018
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Manufacturer</title>
</head>
<body>
<h2>Edit Manufacturer</h2>
<form action="/Manufacturers/UpdateManufacturer" method="post">
    <input type="hidden" name="id_of_manufacturer" value="<%=request.getAttribute("id_of_manufacturer")%>">
    <label>
        <p>Input new Name</p>
        <input type="text" name="name" value="<%=request.getAttribute("name")%>">
    </label>
    <br>
    <br>
    <input type="submit" value="Update Manufacturer">
</form>
</body>
</html>
