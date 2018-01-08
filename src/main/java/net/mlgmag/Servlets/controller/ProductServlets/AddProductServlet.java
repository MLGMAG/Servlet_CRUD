package net.mlgmag.Servlets.controller.ProductServlets;

import net.mlgmag.Servlets.EnumSingletonDAO;
import net.mlgmag.Servlets.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;


public class AddProductServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html; charset=utf-8");
            PrintWriter writer = resp.getWriter();
            String name = req.getParameter("name_input");
            BigDecimal price = new BigDecimal(String.valueOf(req.getParameter("price_input")));
            String manufacturerName = req.getParameter("manufacturer");

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setManufacturer(EnumSingletonDAO.INSTANCE.getManufacturerDAO().getByName(manufacturerName));


            EnumSingletonDAO.INSTANCE.getProductDAO().save(product);

            writer.print("<p>Product added in DataBase</p>");
            writer.print("<form action=\"/Products\">" +
                    "<input type=\"submit\" value=\"Go Back\">" +
                    "</form>");
        } catch (Exception e) {
            PrintWriter writer = resp.getWriter();
            writer.print("<p>Error in adding Product</p><br>");
            writer.print("<form action=\"/JSP/AddProduct.jsp\">" +
                    "<input type=\"submit\" value=\"Go Back\">" +
                    "</form>");

            writer.print("<form action=\"/HTML/MainPage.html\">" +
                    "<input type=\"submit\" value=\"Go to Main Page\">" +
                    "</form>");
            e.printStackTrace();
        }
    }
}
