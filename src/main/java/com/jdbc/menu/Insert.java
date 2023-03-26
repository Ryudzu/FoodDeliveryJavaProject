package com.jdbc.menu;

import com.jdbc.crud.CRUDutils;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Insert {

    private static final Logger logger = Logger.getLogger(Insert.class.getName());
    private static final Scanner input = new Scanner(System.in);

    public static void insert() {
        logger.log(Level.INFO, """
                Какую таблицу вы бы хотели дополнить?
                1. cart_data
                2. courier_data
                3. customer_cart
                4. customer_data
                5. order_data
                6. product_and_order
                7. product_category_data
                8. product_data
                9. review_data""");

        int choice = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, "Введите количество продуктов в корзине:");
            int amount = input.nextInt();
            logger.log(Level.INFO, "Введите ID корзины пользователя:");
            int customerCartId = input.nextInt();
            logger.log(Level.INFO, "Введите ID продукта корзины:");
            int productDataId = input.nextInt();

            CRUDutils.insertCartData(amount, customerCartId, productDataId);
        } else if (choice == 2) {
            logger.log(Level.INFO, "Введите номер телефона курьера:");
            String courierPhone = input.next();
            logger.log(Level.INFO, "Введите имя курьера:");
            String firstname = input.next();
            logger.log(Level.INFO, "Введите фамилию курьера:");
            String lastname = input.next();
            logger.log(Level.INFO, "Введите транспортное средство курьера:");
            String vehicle = input.next();

            CRUDutils.insertCourierData(courierPhone, firstname, lastname, vehicle);
        } else if (choice == 3) {
            logger.log(Level.INFO, "Введите ID пользователя корзины:");
            int customerDataId = input.nextInt();

            CRUDutils.insertCustomerCart(customerDataId);
        } else if (choice == 4) {
            logger.log(Level.INFO, "Введите номер телефона пользователя:");
            String customerPhone = input.next();
            logger.log(Level.INFO, "Введите почту пользователя:");
            String email = input.next();
            logger.log(Level.INFO, "Введите пароль пользователя:");
            String password = input.next();
            logger.log(Level.INFO, "Введите имя пользователя:");
            String username = input.next();

            CRUDutils.insertCustomerData(customerPhone, email, password, username);
        } else if (choice == 5) {
            logger.log(Level.INFO, "Введите адрес доставки:");
            String address = input.next();
            logger.log(Level.INFO, "Введите город доставки:");
            String city = input.next();
            logger.log(Level.INFO, "Введите ID курьера, осуществляющего доставку:");
            int courierDataId = input.nextInt();
            logger.log(Level.INFO, "Введите ID получателя:");
            int customerDataId = input.nextInt();
            logger.log(Level.INFO, "Введите этаж доставки:");
            int floor = input.nextInt();
            logger.log(Level.INFO, "Введите способ оплаты:");
            String payment = input.next();
            logger.log(Level.INFO, "Введите суммарную стоимость заказа:");
            double total = input.nextInt();

            CRUDutils.insertOrderData(address, city, courierDataId, customerDataId, floor, payment, total);
        } else if (choice == 6) {
            logger.log(Level.INFO, "Введите количество заказанных продуктов:");
            int amountOrdered = input.nextInt();
            logger.log(Level.INFO, "Введите ID заказа:");
            int orderDataId = input.nextInt();
            logger.log(Level.INFO, "Введите ID продукта:");
            int productDataId = input.nextInt();

            CRUDutils.insertProductAndOrder(amountOrdered, orderDataId, productDataId);
        } else if (choice == 7) {
            logger.log(Level.INFO, "Введите название категории:");
            String categoryTitle = input.next();
            logger.log(Level.INFO, "Введите описание категории:");
            String description = input.next();

            CRUDutils.insertProductCategoryData(categoryTitle, description);
        } else if (choice == 8) {
            logger.log(Level.INFO, "Введите ссылку на изображение продукта:");
            String imageLink = input.next();
            logger.log(Level.INFO, "Введите цену продукта");
            double price = input.nextDouble();
            logger.log(Level.INFO, "Введите ID категории продукта:");
            int productCategoryId = input.nextInt();
            logger.log(Level.INFO, "Введите рейтинг продукта:");
            int productRating = input.nextInt();
            logger.log(Level.INFO, "Введите название продукта:");
            String productTitle = input.next();

            CRUDutils.insertProductData(imageLink, price, productCategoryId, productRating, productTitle);
        } else if (choice == 9) {
            logger.log(Level.INFO, "Введите комментарий:");
            String comment = input.next();
            logger.log(Level.INFO, "Введите оценку рейтинга:");
            int reviewRating = input.nextInt();

            CRUDutils.insertReviewData(comment, reviewRating);
        } else {
            logger.log(Level.INFO, "Такого выбора не существует в меню. Повторите попытку.");
            System.exit(0);
        }

        logger.log(Level.INFO, "Успешно!");
    }
}
