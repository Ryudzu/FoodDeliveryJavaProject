package controller.servlets;

import controller.services.Authentication;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.crud.CRUDutils;
import model.exceptions.PersonalExceptions;

import java.io.*;

public class RegisterServlet extends HttpServlet {

    private Authentication authService;

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        this.authService = (Authentication) getServletContext().getAttribute("authService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String login = req.getParameter("login");
        final String email = req.getParameter("email");
        final String phone = req.getParameter("phone");
        final String password = req.getParameter("password");
        final String passwordDuplicate = req.getParameter("passwordDuplicate");

        if (authService.isUserExists(login))
            req.setAttribute("loginExists", "Пользователь с таким именем уже существует!");
        else if (authService.isEmailExists(email))
            req.setAttribute("emailExists", "Эта почта уже зарегистрирована в системе!");
        else if (authService.isPhoneExists(phone))
            req.setAttribute("phoneExists", "Этот номер телефона уже зарегистрирован в системе!");
        else {
            if (authService.arePasswordsEqual(password, passwordDuplicate)) {
                try {
                    CRUDutils.insertCustomerData(phone, email, password, login);
                    final int idCustomer = authService.getIdCustomerCart(login);
                    CRUDutils.insertCustomerCart(idCustomer);
                } catch (PersonalExceptions e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("registerSuccess", "Регистрация прошла успешно, теперь вы можете войти в свой аккаунт!");
                resp.sendRedirect("/login?registerSuccess=true");
            } else
                req.setAttribute("passwordsAreNotEqual", "Пароли не совпадают!");
        }

        if (!resp.isCommitted())
            doGet(req, resp);
    }
}
