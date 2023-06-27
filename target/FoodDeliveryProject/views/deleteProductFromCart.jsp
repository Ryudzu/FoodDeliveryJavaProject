<%@ page import="model.crud.CRUDutils" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    int idProductInCart = Integer.parseInt(request.getParameter("id"));
    CRUDutils.deleteCartData(idProductInCart);

    String productTitle = request.getParameter("productTitle");
    request.getSession().setAttribute("deletedProduct", productTitle);
    response.sendRedirect("/cart");
%>