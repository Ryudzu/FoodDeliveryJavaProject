package controller.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.crud.CRUDutils;
import model.data.ProductsInCart;
import model.exceptions.PersonalExceptions;

import java.io.*;
import java.util.*;

public class CartServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("idCustomer") != null) {
            final int idCustomer = (int) req.getSession().getAttribute("idCustomer");
            final List<ProductsInCart> cartProducts = new ArrayList<>(CRUDutils.showAllProductsInCart(idCustomer));
            req.getSession().setAttribute("cartProducts", cartProducts);
        }

        req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int idProductInCart = Integer.parseInt(req.getParameter("idProductInCart"));
        final int amount = Integer.parseInt(req.getParameter("amount"));

        try {
            CRUDutils.updateCartDataAmount(amount, idProductInCart);
            doGet(req, resp);
        } catch (PersonalExceptions e) {
            throw new IllegalArgumentException(e);
        }
    }
}