package servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        System.out.println(firstname);
        System.out.println(lastname);

        PrintWriter out = resp.getWriter();
        out.println("<h2>Привет " + firstname + " " + lastname + "!</h2>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        System.out.println(firstname);
        System.out.println(lastname);

        PrintWriter out = resp.getWriter();
        out.println("<h2>Привет " + firstname + " " + lastname + "!</h2>");
        out.close();
    }
}