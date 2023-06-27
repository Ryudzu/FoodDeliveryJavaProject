<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<header>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="background-color: tomato">
        <div>
            <a href="<c:url value="/main" />" class="navbar-brand">Food Delivery Management</a>
        </div>
        <ul class="navbar-nav mx-sm-auto justify-content-between">
            <li><a href="#" class="nav-link px-5">Курьеры</a></li>
            <li><a href="#" class="nav-link px-5">Заказ</a></li>
            <li class="nav-item dropdown">
                <a href="#" class="nav-link px-5 dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Категории
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:forEach var="category" items="${categories}">
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/category?id=<c:out value="${category.id}"/>&categoryTitle=<c:out value="${category.categoryTitle}"/>"><c:out value="${category.categoryTitle}"/></a>
                    </c:forEach>
                </div>
            </li>
            <li><a href="<c:url value="/review" />" class="nav-link px-5">Оставить отзыв</a></li>
            <li><a href="<c:url value="/cart" />" class="nav-link px-5">Корзина</a></li>
        </ul>
        <c:if test="${sessionScope.username != null}">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="<c:url value="/logout" />" class="btn btn-danger" role="button">Выйти</a>
                </li>
            </ul>
        </c:if>
        <c:if test="${sessionScope.username == null}">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="<c:url value="/login" />" class="btn btn-primary" role="button">Войти</a>
                </li>
            </ul>
        </c:if>
    </nav>
</header>