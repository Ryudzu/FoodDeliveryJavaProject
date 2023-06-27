package controller.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.crud.CRUDutils;
import model.data.ProductData;
import model.exceptions.PersonalExceptions;

import java.io.*;
import java.util.*;

public class CategoryServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<ProductData> products = new ArrayList<>(CRUDutils.showAllProductData());
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int idProduct = Integer.parseInt(req.getParameter("idProduct"));
        final int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        final String categoryTitle = req.getParameter("categoryTitle");

        final int idCustomer = (int) req.getSession().getAttribute("idCustomer");

        try {
            if (CRUDutils.isProductAlreadyInCart(idProduct))
                req.setAttribute("alreadyInCart", "Этот продукт уже находится в вашей корзине! Его количество можно поменять непосредственно в самой корзине.");
            else
                CRUDutils.insertCartData(1, idProduct, idCustomer);
        } catch (PersonalExceptions e) {
            throw new IllegalArgumentException(e);
        }

        req.getRequestDispatcher("/views/category.jsp?id=" + idCategory + "&categoryTitle=" + categoryTitle).forward(req, resp);
    }
}
