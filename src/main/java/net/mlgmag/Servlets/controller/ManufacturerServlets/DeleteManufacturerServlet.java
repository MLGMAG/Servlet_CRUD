package net.mlgmag.Servlets.controller.ManufacturerServlets;

import net.mlgmag.Servlets.EnumSingletonDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class DeleteManufacturerServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        try {
            UUID id = UUID.fromString(req.getParameter("id_of_manufacturer"));
            String Title = "Delete Manufacturer";

            EnumSingletonDAO.INSTANCE.getManufacturerDAO().delete(EnumSingletonDAO.INSTANCE.getManufacturerDAO().getByID(id));

            writer.print(
                    "<html>" +
                            "<head>" +
                            "    <title>" + Title + "</title>" +
                            "</head>" +
                            "<body>" +
                            "<p>Manufacturer was removed</p>" +

                            "<form action=\"/Manufacturers\">" +
                            "    <input type=\"submit\" value=\"Go back\">" +
                            "</form>" +

                            "</body>" +
                            "</head>");

        } catch (Exception e) {
            e.printStackTrace();
            writer.print("<p>Error in deleting Manufacturer</p><br>");
            writer.print("<form action=\"/Manufacturer\">" +
                    "<input type=\"submit\" value=\"Go Back\">" +
                    "</form>");
        }
    }
}
