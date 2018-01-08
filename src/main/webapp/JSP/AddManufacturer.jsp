<%--
  Created by IntelliJ IDEA.
  User: Magomed
  Date: 08.01.2018
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Manufacturer</title>
</head>
<body>
<h2>Add Manufacturer</h2>
<form action="/Manufacturers/AddManufacturer" method="post">
    <label for="manufacturer_name">
        <input type="text" name="name_input" id="manufacturer_name">
    </label>
    <br>
    <br>
    <input type="submit" value="Submit in DataBase">
</form>
</body>
</html>
