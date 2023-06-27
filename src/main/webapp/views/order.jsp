<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <title>Management Application</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="background-color: tomato">
                <div><span class="navbar-brand">Product Management App</span></div>
            </nav>
        </header>
        <main>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-header"><h2>Оформление заказа</h2></div>
                    <div class="card-body">
                    <c:choose>
                        <c:when test="${requestScope.orderSuccess != null}">
                            <div class="alert alert-success">${requestScope.orderSuccess}</div>
                            <a href="<c:url value="/main" />" class="btn btn-secondary">Вернуться на главную</a>
                        </c:when>
                        <c:when test="${sessionScope.idCustomer == null}">
                            <div class="alert alert-danger">Для оформления заказов необходимо необходимо войти в аккаунт!</div>
                        </c:when>
                        <c:when test="${sessionScope.cartProducts == null}">
                            <div class="alert alert-danger">У вас нет ни одного добавленого продукта в корзину для оформления заказа!</div>
                        </c:when>
                        <c:otherwise>
                            <form action="${pageContext.request.contextPath}/order" method="post" name="orderServ">
                                <fieldset class="form-group">
                                    <legend style="font-size: 16px;">Город</legend>
                                    <label for="city"></label>
                                    <input type="text" class="form-control" id="city" name="city" required="required">
                                </fieldset>
                                <fieldset class="form-group">
                                    <legend style="font-size: 16px;">Адрес</legend>
                                    <label for="address"></label>
                                    <input type="text" class="form-control" id="address" name="address" required="required">
                                </fieldset>
                                <fieldset class="form-group">
                                    <legend style="font-size: 16px;">Этаж</legend>
                                    <label for="floor"></label>
                                    <input type="text" class="form-control" id="floor" name="floor" required="required">
                                </fieldset>
                                <fieldset class="form-group">
                                    <legend style="font-size: 16px;">Способ оплаты</legend>
                                    <label for="payment"></label>
                                    <select class="custom-select" id="payment" name="payment">
                                        <option selected>Выбрать...</option>
                                        <option value="Наличные">Наличные</option>
                                        <option value="Картой курьеру">Картой курьеру</option>
                                        <option value="Картой на сайте">Картой на сайте</option>
                                    </select>
                                </fieldset>
                                <fieldset class="form-group">
                                    <legend style="font-size: 16px;">Стоимость заказа (BYN): ${e:forHtml(param.total)}</legend>
                                    <label for="total"></label>
                                    <input type="hidden" style="outline:none; border: none;" id="total" name="total" value="${e:forHtml(param.total)}" readonly>
                                </fieldset>
                                <button type="submit" class="btn btn-success btn-block" style="margin-bottom: 5px">Заказать</button>
                            </form>
                            <a href="<c:url value="/cart" />" class="btn btn-secondary btn-block">Вернуться к корзине</a>
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>
            </div>
        </main>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous" type=""></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous" type=""></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous" type=""></script>
    </body>
</html>
