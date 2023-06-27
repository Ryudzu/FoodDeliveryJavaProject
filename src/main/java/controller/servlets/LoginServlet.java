package controller.servlets;

import controller.services.Authentication;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.crud.CRUDutils;

import java.io.*;

public class LoginServlet extends HttpServlet {

    private transient Authentication authService;

    @Override
    public void init() {
        this.authService = (Authentication) getServletContext().getAttribute("authService");
    }

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        if (authService.isUserAuthorized(login, password)) {
            req.getSession().setAttribute("idCustomer", CRUDutils.showCustomerId(login));
            req.getSession().setAttribute("username", login);
            resp.sendRedirect("/main");
        } else {
            req.setAttribute("loginFailed", "Неправильный логин или пароль!");
            doGet(req, resp);
        }
    }
}
