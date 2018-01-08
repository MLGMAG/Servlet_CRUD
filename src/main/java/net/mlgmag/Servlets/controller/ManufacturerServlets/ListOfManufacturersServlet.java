package net.mlgmag.Servlets.controller.ManufacturerServlets;

import net.mlgmag.Servlets.EnumSingletonDAO;
import net.mlgmag.Servlets.model.Manufacturer;
import net.mlgmag.Servlets.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListOfManufacturersServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        writer.print("<html>" +
                "<head>" +
                "<title>Manufacturers</title>" +
                "</head>" +
                "<body>" +
                "<h2>Manufacturers</h2>");

        List<Manufacturer> manufacturersList = EnumSingletonDAO.INSTANCE.getManufacturerDAO().getAll();
        if (manufacturersList.size() != 0) {
            for (Manufacturer manufacturer : manufacturersList) {
                String productName = manufacturer.getName();
                String infoLink = ("<a href=\"/Manufacturers/ManufacturerInfo?id_of_manufacturer=" + manufacturer.getId() + " \">" + "INFO" + "</a>");
                String editLink = ("<a href=\"/Manufacturers/UpdateManufacturer?id_of_manufacturer=" + manufacturer.getId() + "\">" + "EDIT" + "</a>");
                String deleteLink = ("<a href=\"/Manufacturers/DeleteManufacturer?id_of_manufacturer=" + manufacturer.getId() + "\">" + "DELETE" + "</a>");
                String finalString = ("<p>" + productName + " " + infoLink + " " + editLink + " " + deleteLink + "</p>");
                writer.print(finalString);
            }
            writer.print("<br>");
        } else {
            writer.print("<p>Manufacturers database is empty</p><br>");
        }

        writer.print("<form action=\"/JSP/AddManufacturer.jsp\">\n" +
                "    <input type=\"submit\" value=\"Add Manufacturer\">\n" +
                "</form>");

        writer.print("<form action=\"/HTML/MainPage.html\">" +
                "<input type=\"submit\" value=\"Go to main page\">" +
                "</form>");

        writer.print("</body>" +
                "</html>");

    }
}
