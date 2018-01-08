package net.mlgmag.Servlets.controller.ProductServlets;

import net.mlgmag.Servlets.EnumSingletonDAO;
import net.mlgmag.Servlets.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListOfProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        writer.print("<html>" +
                "<head>" +
                "<title>Products</title>" +
                "</head>" +
                "<body>" +
                "<h2>Products</h2>");

        List<Product> productList = EnumSingletonDAO.INSTANCE.getProductDAO().getAll();
        if (productList.size() != 0) {
            for (Product product : productList) {
                String productName = product.getName();
                String infoLink = ("<a href=\"/Products/ProductInfo?id_of_product=" + product.getId() + " \">" + "INFO" + "</a>");
                String editLink = ("<a href=\"/Products/UpdateProduct?id_of_product=" + product.getId() + "\">" + "EDIT" + "</a>");
                String deleteLink = ("<a href=\"/Products/DeleteProduct?id_of_product=" + product.getId() + "\">" + "DELETE" + "</a>");
                String finalString = ("<p>" + productName + " " + infoLink + " " + editLink + " " + deleteLink + "</p>");
                writer.print(finalString);
            }
            writer.print("<br>");

        }else {
            writer.print("<p>Product database is empty</p><br>");
        }

        writer.print("<form action=\"/JSP/AddProduct.jsp\">\n" +
                "    <input type=\"submit\" value=\"Add Product\">\n" +
                "</form>");

        writer.print("<form action=\"/HTML/MainPage.html\">" +
                "<input type=\"submit\" value=\"Go to main page\">" +
                "</form>");

        writer.print("</body>" +
                "</html>");
    }
}
