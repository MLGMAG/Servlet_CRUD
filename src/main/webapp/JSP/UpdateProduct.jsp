<%@ page import="net.mlgmag.Servlets.EnumSingletonDAO" %>
<%@ page import="net.mlgmag.Servlets.model.Manufacturer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Magomed
  Date: 08.01.2018
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<%!
    private List<Manufacturer> manufacturers = EnumSingletonDAO.INSTANCE.getManufacturerDAO().getAll();
%>
<h2>Edit product</h2>
<form action="/Products/UpdateProduct" method="post">
    <input type="hidden" name="id_of_product" value="<%=request.getAttribute("id_of_product")%>">
    <p>Input new Name</p>
    <label>
        <input type="text" name="name" value="<%=request.getAttribute("name")%>">
    </label>
    <p>Input new Price</p>
    <label>
        <input type="text" name="price" value="<%=request.getAttribute("price")%>">
    </label>
    <label for="manufacturer">
        <p>Choice manufacturer</p>
        <select name="manufacturer" id="manufacturer">
            <%
                for (Manufacturer manufacturer : manufacturers) {
                    out.println("<option value=\"" + manufacturer.getName() + "\">"
                            + manufacturer.getName() + "</option>");
                }
            %>
        </select>
    </label>
    <br>
    <br>
    <input type="submit" value="update"/>
</form>
</body>
</html>
