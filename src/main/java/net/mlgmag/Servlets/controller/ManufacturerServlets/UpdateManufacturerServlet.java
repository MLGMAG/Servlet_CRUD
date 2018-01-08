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

public class UpdateManufacturerServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        try {
            UUID manufacturerId = UUID.fromString(req.getParameter("id_of_manufacturer"));
            String name = req.getParameter("name");

            Manufacturer manufacturer = EnumSingletonDAO.INSTANCE.getManufacturerDAO().getByID(manufacturerId);
            manufacturer.setName(name);

            EnumSingletonDAO.INSTANCE.getManufacturerDAO().update(manufacturer);

            writer.println("Product updated");
            writer.println("<br><br>");

            writer.println("<form action=\"/Manufacturers\">" +
                    "<p><input type=\"submit\" value=\"Go Back\"></p>" +
                    "</form>");

        } catch (Exception e) {
            e.printStackTrace();
            writer.print("<p>Error in Updating Manufacturer</p> <br>");
            writer.println("<form action=\"/JSP/UpdateManufacturer\">" +
                    "<p><input type=\"submit\" value=\"Go Back\"></p>" +
                    "</form>");
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID manufacturerId = UUID.fromString(req.getParameter("id_of_manufacturer"));

        Manufacturer manufacturer = EnumSingletonDAO.INSTANCE.getManufacturerDAO().getByID(manufacturerId);
        String name = manufacturer.getName();

        req.setAttribute("id_of_manufacturer", manufacturerId);
        req.setAttribute("name", name);

        req.getRequestDispatcher("/JSP/UpdateManufacturer.jsp").forward(req, resp);
    }
}
