<%@ page import="net.mlgmag.Servlets.model.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page import="net.mlgmag.Servlets.EnumSingletonDAO" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Magomed
  Date: 06.01.2018
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Product</title>
</head>
<body>

<h2>Add Product</h2>

<form action="/Products/AddProduct" method="POST">

    <label for="name">
        <p>Enter name:</p>
    </label>
    <input type="text" name="name_input" id="name"><br>

    <label for="price">
        <p>Enter price:</p>
    </label>
    <input type="text" name="price_input" id="price"><br>

    <label for="manufacturer">
        <p>Choose manufacturer:</p>
    </label>
    <%!private List<Manufacturer> manufacturerList = EnumSingletonDAO.INSTANCE.getManufacturerDAO().getAll();%>
    <select name="manufacturer" id="manufacturer">
        <%
            for (Manufacturer manufacturer : manufacturerList) {
                out.println("<option value=\"" + manufacturer.getName() + "\">"
                        + manufacturer.getName() + "</option>");
            }
        %>
    </select>
    <br>
    <br>
    <input type="submit" value="Submit in DataBase">
</form>
</body>
</html>