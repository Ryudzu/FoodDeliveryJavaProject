# FoodDeliveryJavaProject

Ссылка на sonarcloud (ветка dev): https://sonarcloud.io/summary/new_code?id=Ryudzu_FoodDeliveryJavaProject&branch=dev.
Ссылка на sonarcloud (ветка dev_web): https://sonarcloud.io/summary/new_code?id=Ryudzu_FoodDeliveryJavaProject&branch=dev_web.

Дополнительные данные --> https://github.com/Ryudzu/FoodDeliveryJavaProject/tree/dev_web/src/main/resources, где databaseprops - текстовый документ, с необходимым минимумом информации для подключения к БД, sql-файл fooddeliveryDB - дамп спроектированной БД.

### Пошаговая работа:

1) Работа с CRUD-операциями находится тут --> https://github.com/Ryudzu/FoodDeliveryJavaProject/tree/dev_web/src/main/java/model, где пакет connection - подключение к БД, пакет crud - операции с БД, пакет data - сущности БД, пакет exceptions - собственное исключение, пакет menu - оформление меню для работы с БД, пакет validator - для проверки заносимых данных в БД, java-класс App - непосредственно само консольное приложение.

2) Работа с JSP находится тут --> https://github.com/Ryudzu/FoodDeliveryJavaProject/tree/dev_web/src/main/java/controller, где пакет services - аутентификация пользователя, пакет servlets - сервлеты, отвечающие за обработку запросов пользователя. Папка webapp, в которой находится все содержимое самого динамического сайта --> https://github.com/Ryudzu/FoodDeliveryJavaProject/tree/dev_web/src/main/webapp.
