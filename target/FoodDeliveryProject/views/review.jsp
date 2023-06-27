<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-header"><h2>Здесь вы можете оставить свой отзыв о нас!</h2></div>
                    <div class="card-body">
                        <c:choose>
                            <c:when test="${sessionScope.idCustomer == null}">
                                <div class="alert alert-danger">Для того, чтобы оставить отзыв необходимо войти в свой аккаунт!</div>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${requestScope.reviewSuccess != null}">
                                    <div class="alert alert-success">${requestScope.reviewSuccess}</div>
                                </c:if>
                                <form action="${pageContext.request.contextPath}/review" method="post" name="registerServ">
                                    <fieldset class="form-group">
                                        <legend style="font-size: 16px;">Оценка организации</legend>
                                        <label for="rating"></label>
                                        <select class="custom-select mr-sm-2" id="rating" name="rating">
                                            <option selected>Выбрать...</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </fieldset>
                                    <fieldset class="form-group">
                                        <legend style="font-size: 16px;">Оставьте комментарий</legend>
                                        <label for="comment"></label>
                                        <textarea class="form-control" id="comment" name="comment" rows="3" cols=""></textarea>
                                    </fieldset>
                                    <button type="submit" class="btn btn-success">Отправить</button>
                                </form>
                                <a href="<c:url value="/main" />" class="btn btn-secondary">На главную</a>
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
