package controller.servlets;

import controller.services.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    private Authentication authService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext = servletContextEvent.getServletContext();

        authService = new AuthenticationService();
        servletContext.setAttribute("authService", authService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        authService = null;
    }
}
