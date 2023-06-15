package com.jdbc.menu;

import com.jdbc.connection.DatabaseConnection;
import com.jdbc.crud.CRUDutils;
import com.jdbc.exceptions.PersonalExceptions;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Update {

    private Update() {}

    private static final Logger logger = Logger.getLogger(Update.class.getName());
    private static final Scanner input = new Scanner(System.in);
    private static final String ERRORMESSAGE = "Такого выбора не существует в меню. Повторите попытку.";
    private static final String CLOSECONNECTIONMESSAGE = "Закрываем подключение с базой данных...";

    public static void update() throws PersonalExceptions {
        logger.log(Level.INFO, """
                Содержимое какой таблицы вы бы хотели обновить?
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

        logger.log(Level.INFO, "Введите ID строки, в которую необходимо внести изменения:");
        int columnId = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, """
                    Выберите колонку, которую необходимо обновить.
                    1. amount
                    2. customer_cart_id
                    3. product_data_id""");

            updateCartDataColumns(columnId);
        } else if (choice == 2) {
            logger.log(Level.INFO, """
                    Выберите колонку, которую необходимо обновить.
                    1. courier_phone
                    2. firstname
                    3. lastname
                    4. vehicle""");

            updateCourierDataColumns(columnId);
        } else if (choice == 3) {
            logger.log(Level.INFO, "Выберите колонку, которую необходимо обновить.\n" +
                    "1. customer_data_id");

            updateCustomerCartColumns(columnId);
        } else if (choice == 4) {
            logger.log(Level.INFO, """
                    Выберите колонку, которую необходимо обновить.
                    1. customer_phone
                    2. email
                    3. password
                    4. username""");

            updateCustomerDataColumns(columnId);
        } else if (choice == 5) {
            logger.log(Level.INFO, """
                    Выберите колонку, которую необходимо обновить.
                    1. address
                    2. city
                    3. courier_data_id
                    4. customer_data_id
                    5. floor
                    6. payment
                    7. total""");

            updateOrderDataColumns(columnId);
        } else if (choice == 6) {
            logger.log(Level.INFO, """
                    Выберите колонку, которую необходимо обновить.
                    1. amount_ordered
                    2. order_data_id
                    3. product_data_id""");

            updateProductAndOrderColumns(columnId);
        } else if (choice == 7) {
            logger.log(Level.INFO, """
                    Выберите колонку, которую необходимо обновить.
                    1. category_title
                    2. description""");

            updateProductCategoryDataColumns(columnId);
        } else if (choice == 8) {
            logger.log(Level.INFO, """
                    Выберите колонку, которую необходимо обновить.
                    1. image_link
                    2. price
                    3. product_category_id
                    4. product_rating
                    5. product_title""");

            updateProductDataColumns(columnId);
        } else if (choice == 9) {
            logger.log(Level.INFO, """
                    Выберите колонку, которую необходимо обновить.
                    1. comment
                    2. review_rating""");

            updateReviewDataColumns(columnId);
        } else {
            logger.log(Level.INFO, "{0}", ERRORMESSAGE);
            logger.log(Level.INFO, "{0}", CLOSECONNECTIONMESSAGE);
            DatabaseConnection.closeConnect();
            System.exit(0);
        }

        logger.log(Level.INFO, "Успешно!");
    }

    private static void updateCartDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, "Введите новое значение для колонки amount:");
            int updatedAmount = input.nextInt();
            CRUDutils.updateCartDataAmount(updatedAmount, columnId);
        } else if (choice == 2) {
            logger.log(Level.INFO, "Введите новое значение для колонки customer_cart_id:");
            int updatedCustomerCartId = input.nextInt();
            CRUDutils.updateCartDataCustomerCartId(updatedCustomerCartId, columnId);
        } else if (choice == 3) {
            logger.log(Level.INFO, "Введите новое значение для колонки product_data_id:");
            int updatedProductDataId = input.nextInt();
            CRUDutils.updateCartDataProductDataId(updatedProductDataId, columnId);
        } else {
            logger.log(Level.INFO, "{0}", ERRORMESSAGE);
            logger.log(Level.INFO, "{0}", CLOSECONNECTIONMESSAGE);
            DatabaseConnection.closeConnect();
            System.exit(0);
        }
    }

    private static void updateCourierDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, "Введите новое значение для колонки courier_phone:");
            String updatedCourierPhone = input.next();
            CRUDutils.updateCourierDataCourierPhone(updatedCourierPhone, columnId);
        } else if (choice == 2) {
            logger.log(Level.INFO, "Введите новое значение для колонки firstname:");
            String updatedCourierFirstname = input.next();
            CRUDutils.updateCourierDataFirstname(updatedCourierFirstname, columnId);
        } else if (choice == 3) {
            logger.log(Level.INFO, "Введите новое значение для колонки lastname:");
            String updatedCourierLastname = input.next();
            CRUDutils.updateCourierDataLastname(updatedCourierLastname, columnId);
        } else if (choice == 4) {
            logger.log(Level.INFO, "Введите новое значение для колонки vehicle:");
            String updatedCourierVehicle = input.next();
            CRUDutils.updateCourierDataVehicle(updatedCourierVehicle, columnId);
        } else {
            logger.log(Level.INFO, "{0}", ERRORMESSAGE);
            logger.log(Level.INFO, "{0}", CLOSECONNECTIONMESSAGE);
            DatabaseConnection.closeConnect();
            System.exit(0);
        }
    }

    private static void updateCustomerCartColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, "Введите новое значение для колонки customer_data_id:");
            int updatedCustomerDataId = input.nextInt();
            CRUDutils.updateCustomerCartCustomerDataId(updatedCustomerDataId, columnId);
        } else {
            logger.log(Level.INFO, "{0}", ERRORMESSAGE);
            logger.log(Level.INFO, "{0}", CLOSECONNECTIONMESSAGE);
            DatabaseConnection.closeConnect();
            System.exit(0);
        }
    }

    private static void updateCustomerDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, "Введите новое значение для колонки customer_phone:");
            String updatedCustomerPhone = input.next();
            CRUDutils.updateCustomerDataCustomerPhone(updatedCustomerPhone, columnId);
        } else if (choice == 2) {
            logger.log(Level.INFO, "Введите новое значение для колонки email:");
            String updatedCustomerEmail = input.next();
            CRUDutils.updateCustomerDataEmail(updatedCustomerEmail, columnId);
        } else if (choice == 3) {
            logger.log(Level.INFO, "Введите новое значение для колонки password:");
            String updatedCustomerPassword = input.next();
            CRUDutils.updateCustomerDataPassword(updatedCustomerPassword, columnId);
        } else if (choice == 4) {
            logger.log(Level.INFO, "Введите новое значение для колонки username:");
            String updatedCustomerUsername = input.next();
            CRUDutils.updateCustomerDataUsername(updatedCustomerUsername, columnId);
        } else {
            logger.log(Level.INFO, "{0}", ERRORMESSAGE);
            logger.log(Level.INFO, "{0}", CLOSECONNECTIONMESSAGE);
            DatabaseConnection.closeConnect();
            System.exit(0);
        }
    }

    private static void updateOrderDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, "Введите новое значение для колонки address:");
            String updatedOrderAddress = input.next();
            CRUDutils.updateOrderDataAddress(updatedOrderAddress, columnId);
        } else if (choice == 2) {
            logger.log(Level.INFO, "Введите новое значение для колонки city:");
            String updatedOrderCity = input.next();
            CRUDutils.updateOrderDataCity(updatedOrderCity, columnId);
        } else if (choice == 3) {
            logger.log(Level.INFO, "Введите новое значение для колонки courier_data_id:");
            int updatedOrderCourierId = input.nextInt();
            CRUDutils.updateOrderDataCourierDataId(updatedOrderCourierId, columnId);
        } else if (choice == 4) {
            logger.log(Level.INFO, "Введите новое значение для колонки customer_data_id:");
            int updatedOrderCustomerId = input.nextInt();
            CRUDutils.updateOrderDataCustomerDataId(updatedOrderCustomerId, columnId);
        } else if (choice == 5) {
            logger.log(Level.INFO, "Введите новое значение для колонки floor:");
            int updatedOrderFloor = input.nextInt();
            CRUDutils.updateOrderDataFloor(updatedOrderFloor, columnId);
        } else if (choice == 6) {
            logger.log(Level.INFO, "Введите новое значение для колонки payment:");
            String updatedOrderPayment = input.next();
            CRUDutils.updateOrderDataPayment(updatedOrderPayment, columnId);
        } else if (choice == 7) {
            logger.log(Level.INFO, "Введите новое значение для колонки total:");
            double updatedOrderTotal = input.nextDouble();
            CRUDutils.updateOrderDataTotal(updatedOrderTotal, columnId);
        } else {
            logger.log(Level.INFO, "{0}", ERRORMESSAGE);
            logger.log(Level.INFO, "{0}", CLOSECONNECTIONMESSAGE);
            DatabaseConnection.closeConnect();
            System.exit(0);
        }
    }

    private static void updateProductAndOrderColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, "Введите новое значение для колонки amount_ordered:");
            int updatedProductAndOrderAmountOrdered = input.nextInt();
            CRUDutils.updateProductAndOrderAmountOrdered(updatedProductAndOrderAmountOrdered, columnId);
        } else if (choice == 2) {
            logger.log(Level.INFO, "Введите новое значение для колонки order_data_id:");
            int updatedProductAndOrderOrderId = input.nextInt();
            CRUDutils.updateProductAndOrderOrderDataId(updatedProductAndOrderOrderId, columnId);
        } else if (choice == 3) {
            logger.log(Level.INFO, "Введите новое значение для колонки product_data_id:");
            int updatedProductAndOrderProductId = input.nextInt();
            CRUDutils.updateProductAndOrderProductDataId(updatedProductAndOrderProductId, columnId);
        } else {
            logger.log(Level.INFO, "{0}", ERRORMESSAGE);
            logger.log(Level.INFO, "{0}", CLOSECONNECTIONMESSAGE);
            DatabaseConnection.closeConnect();
            System.exit(0);
        }
    }

    private static void updateProductCategoryDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, "Введите новое значение для колонки category_title:");
            String updatedProductCategoryTitle = input.next();
            CRUDutils.updateProductCategoryDataCategoryTitle(updatedProductCategoryTitle, columnId);
        } else if (choice == 2) {
            logger.log(Level.INFO, "Введите новое значение для колонки description:");
            String updatedProductCategoryDescription = input.next();
            CRUDutils.updateProductCategoryDataDescription(updatedProductCategoryDescription, columnId);
        } else {
            logger.log(Level.INFO, "{0}", ERRORMESSAGE);
            logger.log(Level.INFO, "{0}", CLOSECONNECTIONMESSAGE);
            DatabaseConnection.closeConnect();
            System.exit(0);
        }
    }

    private static void updateProductDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, "Введите новое значение для колонки image_link:");
            String updatedProductImageLink = input.next();
            CRUDutils.updateProductDataImageLink(updatedProductImageLink, columnId);
        } else if (choice == 2) {
            logger.log(Level.INFO, "Введите новое значение для колонки price:");
            double updatedProductPrice = input.nextDouble();
            CRUDutils.updateProductDataPrice(updatedProductPrice, columnId);
        } else if (choice == 3) {
            logger.log(Level.INFO, "Введите новое значение для колонки product_category_id:");
            int updatedProductCategoryId = input.nextInt();
            CRUDutils.updateProductDataProductCategoryId(updatedProductCategoryId, columnId);
        } else if (choice == 4) {
            logger.log(Level.INFO, "Введите новое значение для колонки product_rating:");
            int updatedProductRating = input.nextInt();
            CRUDutils.updateProductDataProductRating(updatedProductRating, columnId);
        } else if (choice == 5) {
            logger.log(Level.INFO, "Введите новое значение для колонки product_title:");
            String updatedProductTitle = input.next();
            CRUDutils.updateProductDataProductTitle(updatedProductTitle, columnId);
        } else {
            logger.log(Level.INFO, "{0}", ERRORMESSAGE);
            logger.log(Level.INFO, "{0}", CLOSECONNECTIONMESSAGE);
            DatabaseConnection.closeConnect();
            System.exit(0);
        }
    }

    private static void updateReviewDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, "Введите новое значение для колонки comment:");
            String updatedReviewComment = input.next();
            CRUDutils.updateReviewDataComment(updatedReviewComment, columnId);
        } else if (choice == 2) {
            logger.log(Level.INFO, "Введите новое значение для колонки review_rating:");
            int updatedReviewRating = input.nextInt();
            CRUDutils.updateReviewDataReviewRating(updatedReviewRating, columnId);
        } else {
            logger.log(Level.INFO, "{0}", ERRORMESSAGE);
            logger.log(Level.INFO, "{0}", CLOSECONNECTIONMESSAGE);
            DatabaseConnection.closeConnect();
            System.exit(0);
        }
    }
}
