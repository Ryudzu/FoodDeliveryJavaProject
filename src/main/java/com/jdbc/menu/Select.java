package com.jdbc.menu;

import com.jdbc.crud.CRUDutils;
import com.jdbc.data.*;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Select {

    private static final Logger logger = Logger.getLogger(Select.class.getName());
    private static final Scanner input = new Scanner(System.in);

    public static void showAll() {
        logger.log(Level.INFO, """
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
            logger.log(Level.INFO, "Список содержимого таблицы cart_data: {0}", cartData);
        } else if (choice == 2) {
            List<CourierData> courierData = CRUDutils.showAllCourierData();
            logger.log(Level.INFO, "Список содержимого таблицы courier_data: {0}", courierData);
        } else if (choice == 3) {
            List<CustomerCart> customerCart = CRUDutils.showAllCustomerCart();
            logger.log(Level.INFO, "Список содержимого таблицы customer_cart: {0}", customerCart);
        } else if (choice == 4) {
            List<CustomerData> customerData = CRUDutils.showAllCustomerData();
            logger.log(Level.INFO, "Список содержимого таблицы customer_data: {0}", customerData);
        } else if (choice == 5) {
            List<OrderData> orderData = CRUDutils.showAllOrderData();
            logger.log(Level.INFO, "Список содержимого таблицы order_data: {0}", orderData);
        } else if (choice == 6) {
            List<ProductAndOrder> productAndOrder = CRUDutils.showAllProductAndOrder();
            logger.log(Level.INFO, "Список содержимого таблицы product_and_order: {0}", productAndOrder);
        } else if (choice == 7) {
            List<ProductCategoryData> categoryData = CRUDutils.showAllProductCategoryData();
            logger.log(Level.INFO, "Список содержимого таблицы product_category_data: {0}", categoryData);
        } else if (choice == 8) {
            List<ProductData> productData = CRUDutils.showAllProductData();
            logger.log(Level.INFO, "Список содержимого таблицы product_data: {0}", productData);
        } else if (choice == 9) {
            List<ReviewData> reviewData = CRUDutils.showAllReviewData();
            logger.log(Level.INFO, "Список содержимого таблицы review_data: {0}", reviewData);
        } else {
            logger.log(Level.INFO, "Такого выбора не существует в меню. Повторите попытку.");
            System.exit(0);
        }

        logger.log(Level.INFO, "Успешно!");
    }
}
