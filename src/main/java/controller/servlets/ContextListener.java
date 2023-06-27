package controller.servlets;

import controller.services.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext = servletContextEvent.getServletContext();

        Authentication authService = new AuthenticationService();
        servletContext.setAttribute("authService", authService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
