package model.menu;

import lombok.extern.slf4j.Slf4j;
import model.connection.DatabaseConnection;
import model.crud.CRUDutils;
import model.data.*;

import java.util.*;

@Slf4j
public final class Select {

    private Select() {}
    
    private static final Scanner input = new Scanner(System.in);

    public static void showAll() {
        log.info("""
                
                Содержимое какой таблицы вы хотите вывести на экран?
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
            List<CartData> cartData = CRUDutils.showAllCartData();
            log.info("\nСписок содержимого таблицы cart_data: {}", cartData);
        } else if (choice == 2) {
            List<CourierData> courierData = CRUDutils.showAllCourierData();
            log.info("\nСписок содержимого таблицы courier_data: {}", courierData);
        } else if (choice == 3) {
            List<CustomerCart> customerCart = CRUDutils.showAllCustomerCart();
            log.info("\nСписок содержимого таблицы customer_cart: {}", customerCart);
        } else if (choice == 4) {
            List<CustomerData> customerData = CRUDutils.showAllCustomerData();
            log.info("\nСписок содержимого таблицы customer_data: {}", customerData);
        } else if (choice == 5) {
            List<OrderData> orderData = CRUDutils.showAllOrderData();
            log.info("\nСписок содержимого таблицы order_data: {}", orderData);
        } else if (choice == 6) {
            List<ProductAndOrder> productAndOrder = CRUDutils.showAllProductAndOrder();
            log.info("\nСписок содержимого таблицы product_and_order: {}", productAndOrder);
        } else if (choice == 7) {
            List<ProductCategoryData> categoryData = CRUDutils.showAllProductCategoryData();
            log.info("\nСписок содержимого таблицы product_category_data: {}", categoryData);
        } else if (choice == 8) {
            List<ProductData> productData = CRUDutils.showAllProductData();
            log.info("\nСписок содержимого таблицы product_data: {}", productData);
        } else if (choice == 9) {
            List<ReviewData> reviewData = CRUDutils.showAllReviewData();
            log.info("\nСписок содержимого таблицы review_data: {}", reviewData);
        } else {
            log.info("\nТакого выбора не существует в меню. Повторите попытку.\nЗакрываем подключение с базой данных...");
            System.exit(0);
        }

        log.info("\nУспешно!");
    }

    public static void showConcrete() {
        log.info("""
                
                Содержимое строки какой таблицы вы хотите вывести на экран?
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

        log.info("\nВведите ID строки, которую необходимо вывести:");
        int columnId = input.nextInt();

        if (choice == 1) {
            List<CartData> cartColumnInfo = CRUDutils.showConcreteCartData(columnId);
            log.info("\nИнформация о строке в таблице cart_data: {}", cartColumnInfo);
        } else if (choice == 2) {
            List<CourierData> courierColumnInfo = CRUDutils.showConcreteCourierData(columnId);
            log.info("\nИнформация о строке в таблице courier_data: {}", courierColumnInfo);
        } else if (choice == 3) {
            List<CustomerCart> customerCartColumnInfo = CRUDutils.showConcreteCustomerCart(columnId);
            log.info("\nИнформация о строке в таблице customer_cart: {}", customerCartColumnInfo);
        } else if (choice == 4) {
            List<CustomerData> customerColumnInfo = CRUDutils.showConcreteCustomerData(columnId);
            log.info("\nИнформация о строке в таблице customer_data: {}", customerColumnInfo);
        } else if (choice == 5) {
            List<OrderData> orderColumnInfo = CRUDutils.showConcreteOrderData(columnId);
            log.info("\nИнформация о строке в таблице order_data: {}", orderColumnInfo);
        } else if (choice == 6) {
            List<ProductAndOrder> productAndOrderColumnInfo = CRUDutils.showConcreteProductAndOrder(columnId);
            log.info("\nИнформация о строке в таблице product_and_order: {}", productAndOrderColumnInfo);
        } else if (choice == 7) {
            List<ProductCategoryData> productCategoryColumnInfo = CRUDutils.showConcreteProductCategoryData(columnId);
            log.info("\nИнформация о строке в таблице product_category_data: {}", productCategoryColumnInfo);
        } else if (choice == 8) {
            List<ProductData> productColumnInfo = CRUDutils.showConcreteProductData(columnId);
            log.info("\nИнформация о строке в таблице product_data: {}", productColumnInfo);
        } else if (choice == 9) {
            List<ReviewData> reviewColumnInfo = CRUDutils.showConcreteReviewData(columnId);
            log.info("\nИнформация о строке в таблице review_data: {}", reviewColumnInfo);
        } else {
            log.info("\nТакого выбора не существует в меню. Повторите попытку.\nЗакрываем подключение с базой данных...");
            System.exit(0);
        }

        log.info("\nУспешно!");
    }
}
