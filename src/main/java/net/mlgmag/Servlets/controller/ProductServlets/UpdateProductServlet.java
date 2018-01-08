package net.mlgmag.Servlets.controller.ProductServlets;

import net.mlgmag.Servlets.EnumSingletonDAO;
import net.mlgmag.Servlets.model.Manufacturer;
import net.mlgmag.Servlets.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.UUID;

public class UpdateProductServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        try {

            String productIdStr = req.getParameter("id_of_product");
            UUID productId = UUID.fromString(productIdStr);

            String name = req.getParameter("name");
            BigDecimal price = new BigDecimal(req.getParameter("price"));
            Manufacturer manufacturer = EnumSingletonDAO.INSTANCE.getManufacturerDAO().getByName(req.getParameter("manufacturer"));

            Product product = EnumSingletonDAO.INSTANCE.getProductDAO().getByID(productId);
            product.setName(name);
            product.setPrice(price);
            product.setManufacturer(manufacturer);

            EnumSingletonDAO.INSTANCE.getProductDAO().update(product);

            writer.println("Product updated");
            writer.println("<br><br>");

            writer.println("<form action=\"/Products\">" +
                    "<p><input type=\"submit\" value=\"Go Back\"></p>" +
                    "</form>");

        } catch (Exception e) {
            e.printStackTrace();
            writer.print("<p>Error in Updating Product</p> <br>");
            writer.println("<form action=\"/JSP/UpdateProduct\">" +
                    "<p><input type=\"submit\" value=\"Go Back\"></p>" +
                    "</form>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdStr = req.getParameter("id_of_product");
        UUID productId = UUID.fromString(productIdStr);

        Product product = EnumSingletonDAO.INSTANCE.getProductDAO().getByID(productId);
        String name = product.getName();
        BigDecimal price = product.getPrice();
        String mName = product.getManufacturer().getName();

        req.setAttribute("id_of_product", productId);
        req.setAttribute("name", name);
        req.setAttribute("price", price);
        req.setAttribute("manufacturerName", mName);

        req.getRequestDispatcher("/JSP/UpdateProduct.jsp").forward(req, resp);

    }
}
