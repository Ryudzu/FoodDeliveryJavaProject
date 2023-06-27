package controller.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.crud.CRUDutils;
import model.exceptions.PersonalExceptions;

import java.io.*;

public class ReviewServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/review.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int rating = Integer.parseInt(req.getParameter("rating"));
        final String comment = req.getParameter("comment");

        try {
            CRUDutils.insertReviewData(comment, rating);
        } catch (PersonalExceptions e) {
            throw new IllegalArgumentException(e);
        }

        req.setAttribute("reviewSuccess", "Благодарим вас за отзыв!");
        doGet(req, resp);
    }
}
