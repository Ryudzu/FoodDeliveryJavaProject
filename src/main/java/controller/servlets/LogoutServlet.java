package controller.servlets;

import jakarta.servlet.http.*;

import java.io.*;

public class LogoutServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/main");
    }
}
