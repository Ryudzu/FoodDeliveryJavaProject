package controller.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.crud.CRUDutils;
import model.data.*;
import model.exceptions.PersonalExceptions;

import java.io.*;
import java.util.*;

public class OrderServlet extends HttpServlet {

    private final Random rand = new Random();

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int idCustomer = (int) req.getSession().getAttribute("idCustomer");

        final List<ProductsInCart> productsInCart = new ArrayList<>(CRUDutils.showAllProductsInCart(idCustomer));
        final List<CourierData> couriers = new ArrayList<>(CRUDutils.showAllCourierData());

        final String city = req.getParameter("city");
        final String address = req.getParameter("address");
        final int floor = Integer.parseInt(req.getParameter("floor"));
        final String payment = req.getParameter("payment");
        final double total = Double.parseDouble(req.getParameter("total"));

        try {
            CRUDutils.insertOrderData(address, city, rand.nextInt(1, couriers.size()), idCustomer, floor, payment, total);
            final int idOrder = CRUDutils.showOrderId(idCustomer);

            for (ProductsInCart productInCart : productsInCart)
                CRUDutils.insertProductAndOrder(productInCart.getAmount(), idOrder, productInCart.getProductDataId());
        } catch (PersonalExceptions e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("orderSuccess", "Спасибо за покупку! Ваш заказ уже в пути!");
        CRUDutils.deleteAllFromCart(idCustomer);
        doGet(req, resp);
    }
}
