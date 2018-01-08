package net.mlgmag.Servlets.controller.ProductServlets;

import net.mlgmag.Servlets.EnumSingletonDAO;
import net.mlgmag.Servlets.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class DeleteProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        try {


            UUID id = UUID.fromString(req.getParameter("id_of_product"));
            String Title = "DeleteProduct";

            EnumSingletonDAO.INSTANCE.getProductDAO().delete(EnumSingletonDAO.INSTANCE.getProductDAO().getByID(id));

            writer.print(
                    "<html>" +
                            "<head>" +
                            "    <title>" + Title + "</title>" +
                            "</head>" +
                            "<body>" +
                            "<p>Product was removed</p>" +

                            "<form action=\"/Products\">" +
                            "    <input type=\"submit\" value=\"Go back\">" +
                            "</form>" +

                            "</body>" +
                            "</head>");

        } catch (Exception e) {
            e.printStackTrace();
            writer.print("<p>Error in deleting Product</p><br>");
            writer.print("<form action=\"/Products\">" +
                    "<input type=\"submit\" value=\"Go Back\">" +
                    "</form>");
        }
    }
}
