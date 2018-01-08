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

public class ProductInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        UUID id = UUID.fromString(req.getParameter("id_of_product"));
        String Title = "ProductInfo";

        Product product = EnumSingletonDAO.INSTANCE.getProductDAO().getByID(id);

        writer.print(
                "<html>" +
                        "<head>" +
                        "    <title>" + Title + "</title>" +
                        "</head>" +
                        "<body>" +
                        "<h2>Product Info</h2>" +

                        "<p>ID:" + product.getId() + "</p>" +
                        "<p>Name:" + product.getName() + "</p>" +
                        "<p>Price:" + product.getPrice() + "$" + "</p>" +
                        "<p>Manufacturer:" + product.getManufacturer().getName() + "</p>" +
                        "<br>" +
                        "<form action=\"/Products\">" +
                        "    <input type=\"submit\" value=\"Go back\">" +
                        "</form>" +

                        "</body>" +
                        "</head>");
    }
}
