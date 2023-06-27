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
        <header>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="background-color: tomato">
                <div><span class="navbar-brand">Product Management App</span></div>
            </nav>
        </header>
        <main>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-header"><h2>Регистрация аккаунта</h2></div>
                    <div class="card-body">
                        <c:if test="${requestScope.loginExists != null}">
                            <div class="alert alert-danger">${requestScope.loginExists}</div>
                        </c:if>
                        <c:if test="${requestScope.emailExists != null}">
                            <div class="alert alert-danger">${requestScope.emailExists}</div>
                        </c:if>
                        <c:if test="${requestScope.phoneExists != null}">
                            <div class="alert alert-danger">${requestScope.phoneExists}</div>
                        </c:if>
                        <c:if test="${requestScope.passwordsAreNotEqual != null}">
                            <div class="alert alert-danger">${requestScope.passwordsAreNotEqual}</div>
                        </c:if>
                        <form action="${pageContext.request.contextPath}/register" method="post" name="registerServ">
                            <fieldset class="form-group">
                                <legend style="font-size: 16px;">Логин</legend>
                                <label for="login"></label>
                                <input type="text" class="form-control" id="login" name="login" value="${e:forHtml(param.login)}" required="required">
                            </fieldset>
                            <fieldset class="form-group">
                                <legend style="font-size: 16px;">Электронная почта</legend>
                                <label for="email"></label>
                                <input type="text" class="form-control" id="email" name="email" value="${e:forHtml(param.email)}" required="required">
                            </fieldset>
                            <fieldset class="form-group">
                                <legend style="font-size: 16px;">Номер телефона</legend>
                                <label for="phone"></label>
                                <input type="text" class="form-control" id="phone" name="phone" value="${e:forHtml(param.phone)}" required="required">
                            </fieldset>
                            <fieldset class="form-group">
                                <legend style="font-size: 16px;">Пароль</legend>
                                <label for="password"></label>
                                <input type="text" class="form-control" id="password" name="password" required="required">
                            </fieldset>
                            <fieldset class="form-group">
                                <legend style="font-size: 16px;">Повторите пароль</legend>
                                <label for="passwordDuplicate"></label>
                                <input type="text" class="form-control" id="passwordDuplicate" name="passwordDuplicate" required="required">
                            </fieldset>
                            <button type="submit" class="btn btn-success btn-block" style="margin-bottom: 5px">Зарегистрироваться</button>
                        </form>
                        <a href="<c:url value="/login" />" class="btn btn-secondary btn-block">Уже есть аккаунт?</a>
                    </div>
                </div>
            </div>
        </main>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous" type=""></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous" type=""></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous" type=""></script>
    </body>
</html>
