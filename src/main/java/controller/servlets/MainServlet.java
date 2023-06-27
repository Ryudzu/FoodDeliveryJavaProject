package controller.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.crud.CRUDutils;
import model.data.*;

import java.io.*;
import java.util.*;

public class MainServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<ProductCategoryData> categories = new ArrayList<>(CRUDutils.showAllProductCategoryData());
        req.getServletContext().setAttribute("categories", categories);

        final List<ProductData> products = new ArrayList<>(CRUDutils.showAllProductData());
        req.getServletContext().setAttribute("products", products);

        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }
}