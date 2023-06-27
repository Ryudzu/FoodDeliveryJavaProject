<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:set var="totalPrice" value="${0}" />

<html>
    <head>
        <title>Management Application</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <main>
            <div class="container px-3 my-5 clearfix">
            <div class="card">
                <div class="card-header">
                    <h2>Корзина</h2>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <c:choose>
                            <c:when test="${sessionScope.idCustomer == null}">
                                <div class="alert alert-danger">Для просмотра и взаимодействием с корзиной необходимо войти в аккаунт!</div>
                            </c:when>
                            <c:when test="${cartProducts.size() == 0}">
                                <div class="alert alert-dark">Ваша корзина пуста!</div>
                                <%
                                    request.getSession().removeAttribute("deletedProduct");
                                    request.getSession().removeAttribute("cartProducts");
                                %>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${sessionScope.deletedProduct != null}">
                                    <div class="alert alert-success">Успешно убран из корзины продукт "${sessionScope.deletedProduct}"</div>
                                    <% request.getSession().removeAttribute("deletedProduct"); %>
                                </c:if><table class="table table-bordered m-0">
                            <thead>
                                <tr>
                                    <th class="text-center py-3 px-4" style="min-width: 400px;">Название продукта</th>
                                    <th class="text-center py-3 px-4" style="width: 100px;">Цена</th>
                                    <th class="text-center py-3 px-4" style="width: 120px;">Количество</th>
                                    <th class="text-center py-3 px-4" style="width: 100px;">Итого</th>
                                    <th class="text-center align-middle py-3 px-0" style="width: 40px;"><a href="#" class="shop-tooltip float-none text-light" title="" data-original-title="Clear cart"><i class="ino ion-md-trash"></i></a></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cartProduct" items="${cartProducts}">
                                <tr>
                                    <td class="text-center font-weight-semibold align-middle p-4"><c:out value="${cartProduct.productTitle}" /></td>
                                    <td class="text-center font-weight-semibold align-middle p-4"><c:out value="${cartProduct.price}" /> BYN</td>
                                    <form action="${pageContext.request.contextPath}/cart" method="post" name="cartServ">
                                        <td class="align-middle p-4">
                                            <input type="hidden" name="idProductInCart" value="${cartProduct.id}">
                                            <input type="text" class="form-control text-center" value="${cartProduct.amount}" name="amount">
                                        </td>
                                    </form>
                                    <td class="text-center font-weight-semibold align-middle p-4">${cartProduct.amount * cartProduct.price} BYN</td>
                                    <td class="text-center align-middle px-0"><a href="<%=request.getContextPath()%>/views/deleteProductFromCart.jsp?id=<c:out value="${cartProduct.id}" />&productTitle=<c:out value="${cartProduct.productTitle}" />" class="shop-tooltip close float-none text-danger" title="" data-original-title="Remove">×</a></td>
                                    <c:set var="totalPrice" value="${totalPrice + cartProduct.amount * cartProduct.price}" />
                                </tr>
                                </c:forEach>
                                <form action="${pageContext.request.contextPath}/order" method="get" name="orderServ" id="orderServ">
                                    <input type="hidden" name="total" value="${totalPrice}">
                                </form>
                            </tbody>
                        </table>
                    </div>
                    <div class="d-flex flex-wrap justify-content-between align-items-center pb-4">
                        <div class="mt-4"></div>
                        <div class="d-flex">
                            <div class="text-right mt-4">
                                <label class="text-muted font-weight-normal m-0">Итоговая цена</label>
                                <div class="text-large"><strong>${totalPrice} BYN</strong></div>
                            </div>
                        </div>
                    </div>
                    <div class="float-right">
                        <button type="submit" form="orderServ" class="btn btn-lg btn-primary mt-2">Оформить заказ</button>
                    </div>
                </div>
            </div>
            </div>
            </c:otherwise>
            </c:choose>
        </main>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>