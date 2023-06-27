package model.menu;

import lombok.extern.slf4j.Slf4j;
import model.connection.DatabaseConnection;
import model.crud.CRUDutils;
import model.exceptions.PersonalExceptions;

import java.util.Scanner;

@Slf4j
public final class Insert {

    private Insert() {}

    private static final Scanner input = new Scanner(System.in);

    public static void insert() throws PersonalExceptions {
        log.info("""
                \nКакую таблицу вы бы хотели дополнить?
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
            log.info("\nВведите количество продуктов в корзине:");
            int amount = input.nextInt();
            log.info("\nВведите ID корзины пользователя:");
            int customerCartId = input.nextInt();
            log.info("\nВведите ID продукта корзины:");
            int productDataId = input.nextInt();

            CRUDutils.insertCartData(amount, customerCartId, productDataId);
        } else if (choice == 2) {
            log.info("\nВведите номер телефона курьера:");
            String courierPhone = input.next();
            log.info("\nВведите имя курьера:");
            String firstname = input.next();
            log.info("\nВведите фамилию курьера:");
            String lastname = input.next();
            log.info("\nВведите транспортное средство курьера:");
            String vehicle = input.next();

            CRUDutils.insertCourierData(courierPhone, firstname, lastname, vehicle);
        } else if (choice == 3) {
            log.info("\nВведите ID пользователя корзины:");
            int customerDataId = input.nextInt();

            CRUDutils.insertCustomerCart(customerDataId);
        } else if (choice == 4) {
            log.info("\nВведите номер телефона пользователя:");
            String customerPhone = input.next();
            log.info("\nВведите почту пользователя:");
            String email = input.next();
            log.info("\nВведите пароль пользователя:");
            String password = input.next();
            log.info("\nВведите имя пользователя:");
            String username = input.next();

            CRUDutils.insertCustomerData(customerPhone, email, password, username);
        } else if (choice == 5) {
            input.nextLine();
            log.info("\nВведите адрес доставки:");
            String address = input.nextLine();
            log.info("\nВведите город доставки:");
            String city = input.next();
            log.info("\nВведите ID курьера, осуществляющего доставку:");
            int courierDataId = input.nextInt();
            log.info("\nВведите ID получателя:");
            int customerDataId = input.nextInt();
            log.info("\nВведите этаж доставки:");
            int floor = input.nextInt();
            input.nextLine();
            log.info("\nВведите способ оплаты:");
            String payment = input.nextLine();
            log.info("\nВведите суммарную стоимость заказа:");
            double total = input.nextDouble();

            CRUDutils.insertOrderData(address, city, courierDataId, customerDataId, floor, payment, total);
        } else if (choice == 6) {
            log.info("\nВведите количество заказанных продуктов:");
            int amountOrdered = input.nextInt();
            log.info("\nВведите ID заказа:");
            int orderDataId = input.nextInt();
            log.info("\nВведите ID продукта:");
            int productDataId = input.nextInt();

            CRUDutils.insertProductAndOrder(amountOrdered, orderDataId, productDataId);
        } else if (choice == 7) {
            log.info("\nВведите название категории:");
            String categoryTitle = input.next();
            input.nextLine();
            log.info("\nВведите описание категории:");
            String description = input.nextLine();

            CRUDutils.insertProductCategoryData(categoryTitle, description);
        } else if (choice == 8) {
            log.info("\nВведите ссылку на изображение продукта:");
            String imageLink = input.next();
            log.info("\nВведите цену продукта");
            double price = input.nextDouble();
            log.info("\nВведите ID категории продукта:");
            int productCategoryId = input.nextInt();
            log.info("\nВведите рейтинг продукта:");
            int productRating = input.nextInt();
            log.info("\nВведите название продукта:");
            String productTitle = input.next();

            CRUDutils.insertProductData(imageLink, price, productCategoryId, productRating, productTitle);
        } else if (choice == 9) {
            input.nextLine();
            log.info("\nВведите комментарий:");
            String comment = input.nextLine();
            log.info("\nВведите оценку рейтинга:");
            int reviewRating = input.nextInt();

            CRUDutils.insertReviewData(comment, reviewRating);
        } else {
            log.info("\nТакого выбора не существует в меню. Повторите попытку.\nЗакрываем подключение с базой данных...");
            System.exit(0);
        }

        log.info("\nУспешно!");
    }
}
