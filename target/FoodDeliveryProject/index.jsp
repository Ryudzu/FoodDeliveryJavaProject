<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Food Delivery JSP</title>
    </head>
    <body>
        <form method="post" action="TestServlet" name="TestServletForm">
            <table>
                <tr>
                    <td>Имя</td>
                    <td>
                        <label>
                            <input type="text" name="firstname" style="margin: 5px;">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>Фамилия</td>
                    <td>
                        <label>
                            <input type="text" name="lastname" style="margin: 5px;">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Отправить"></td>
                </tr>
            </table>
        </form>
    </body>
</html>