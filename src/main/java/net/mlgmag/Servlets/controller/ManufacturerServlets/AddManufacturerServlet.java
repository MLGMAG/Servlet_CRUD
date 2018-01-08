package net.mlgmag.Servlets.controller.ManufacturerServlets;

import net.mlgmag.Servlets.EnumSingletonDAO;
import net.mlgmag.Servlets.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddManufacturerServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        try {


            String name = req.getParameter("name_input");
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setName(name);

            EnumSingletonDAO.INSTANCE.getManufacturerDAO().save(manufacturer);

            writer.print("<p>Manufacturer added in DataBase</p>");
            writer.print("<form action=\"/Manufacturers\">" +
                    "<input type=\"submit\" value=\"Go Back\">" +
                    "</form>");

        } catch (Exception e) {
            e.printStackTrace();
            writer.print("<p>Error in adding Manufacturer</p><br>");
            writer.print("<form action=\"/JSP/AddManufacturer.jsp\">" +
                    "<input type=\"submit\" value=\"Go Back\">" +
                    "</form>");
        }
    }
}
