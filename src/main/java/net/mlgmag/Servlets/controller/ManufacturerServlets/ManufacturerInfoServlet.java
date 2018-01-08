package net.mlgmag.Servlets.controller.ManufacturerServlets;

import net.mlgmag.Servlets.EnumSingletonDAO;
import net.mlgmag.Servlets.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class ManufacturerInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        UUID id = UUID.fromString(req.getParameter("id_of_manufacturer"));
        String Title = "Manufacturer Info";

        Manufacturer manufacturer = EnumSingletonDAO.INSTANCE.getManufacturerDAO().getByID(id);

        writer.print(
                "<html>" +
                        "<head>" +
                        "    <title>" + Title + "</title>" +
                        "</head>" +
                        "<body>" +
                        "<h2>Product Info</h2>" +

                        "<p>ID:" + manufacturer.getId() + "</p>" +
                        "<p>Name:" + manufacturer.getName() + "</p>" +
                        "<br>" +
                        "<form action=\"/Manufacturers\">" +
                        "    <input type=\"submit\" value=\"Go back\">" +
                        "</form>" +

                        "</body>" +
                        "</head>");
    }
}

