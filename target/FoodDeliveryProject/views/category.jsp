<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <title>Management Application</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <main>
            <div class="row">
                <div class="container">
                    <h3 class="text-center" style="margin: 20px">Продукты категории "${e:forHtml(param.categoryTitle)}"</h3>
                    <hr>
                    <br>
                    <c:if test="${requestScope.alreadyInCart != null}">
                        <div class="alert alert-danger">${requestScope.alreadyInCart}</div>
                    </c:if>
                    <c:if test="${sessionScope.idCustomer == null}">
                        <div class="alert alert-danger">Для добавления товара в корзину необходимо войти в аккаунт!</div>
                    </c:if>
                    <table class="table table-bordered">
                        <caption>Продукты лучшего качества!</caption>
                        <thead>
                        <tr>
                            <th>Название</th>
                            <th>Цена</th>
                            <th>Рейтинг</th>
                            <th>Ссылка на изображение</th>
                            <c:if test="${sessionScope.idCustomer != null}">
                                <th>Параметры</th>
                            </c:if>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="product" items="${products}">
                                <c:if test="${product.productCategoryId eq param.id}">
                                <tr>
                                    <td><c:out value="${product.productTitle}" /></td>
                                    <td><c:out value="${product.price}" /> BYN</td>
                                    <td><c:out value="${product.productRating}" /></td>
                                    <td><c:out value="${product.imageLink}" /></td>
                                    <form action="${pageContext.request.contextPath}/category" method="post" name="categoryServlet">
                                        <td>
                                            <input type="hidden" name="idProduct" value="${product.id}">
                                            <input type="hidden" name="idCategory" value="${product.productCategoryId}">
                                            <input type="hidden" name="categoryTitle" value="${e:forHtml(param.categoryTitle)}">
                                            <c:if test="${sessionScope.idCustomer != null}">
                                                <button type="submit" class="btn btn-success">В корзину</button>
                                            </c:if>
                                        </td>
                                    </form>
                                </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous" type=""></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous" type=""></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous" type=""></script>
    </body>
</html>
