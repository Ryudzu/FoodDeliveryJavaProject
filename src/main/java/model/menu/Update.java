package model.menu;

import lombok.extern.slf4j.Slf4j;
import model.connection.DatabaseConnection;
import model.crud.CRUDutils;
import model.exceptions.PersonalExceptions;

import java.util.Scanner;

@Slf4j
public final class Update {

    private Update() {}
    
    private static final Scanner input = new Scanner(System.in);
    private static final String ERRORMESSAGE = "Такого выбора не существует в меню. Повторите попытку.";
    private static final String CLOSECONNECTIONMESSAGE = "Закрываем подключение с базой данных...";

    public static void update() throws PersonalExceptions {
        log.info("""
                \nСодержимое какой таблицы вы бы хотели обновить?
                1. cart_data
                2. courier_data
                3. customer_cart
                4. customer_data
                5. order_data
                6. product_category_data
                7. product_data
                8. review_data""");

        int choice = input.nextInt();

        log.info("\nВведите ID строки, в которую необходимо внести изменения:");
        int columnId = input.nextInt();

        if (choice == 1) {
            log.info("""
                    \nВыберите колонку, которую необходимо обновить.
                    1. amount
                    2. customer_cart_id
                    3. product_data_id""");

            updateCartDataColumns(columnId);
        } else if (choice == 2) {
            log.info("""
                    \nВыберите колонку, которую необходимо обновить.
                    1. courier_phone
                    2. firstname
                    3. lastname
                    4. vehicle""");

            updateCourierDataColumns(columnId);
        } else if (choice == 3) {
            log.info("""
                    Выберите колонку, которую необходимо обновить.
                    1. customer_data_id""");

            updateCustomerCartColumns(columnId);
        } else if (choice == 4) {
            log.info("""
                    \nВыберите колонку, которую необходимо обновить.
                    1. customer_phone
                    2. email
                    3. password
                    4. username""");

            updateCustomerDataColumns(columnId);
        } else if (choice == 5) {
            log.info("""
                    \nВыберите колонку, которую необходимо обновить.
                    1. address
                    2. city
                    3. courier_data_id
                    4. customer_data_id
                    5. floor
                    6. payment
                    7. total""");

            updateOrderDataColumns(columnId);
        } else if (choice == 6) {
            log.info("""
                    \nВыберите колонку, которую необходимо обновить.
                    1. category_title
                    2. description""");

            updateProductCategoryDataColumns(columnId);
        } else if (choice == 7) {
            log.info("""
                    \nВыберите колонку, которую необходимо обновить.
                    1. image_link
                    2. price
                    3. product_category_id
                    4. product_rating
                    5. product_title""");

            updateProductDataColumns(columnId);
        } else if (choice == 8) {
            log.info("""
                    \nВыберите колонку, которую необходимо обновить.
                    1. comment
                    2. review_rating""");

            updateReviewDataColumns(columnId);
        } else {
            log.info("\n{}\n{}", ERRORMESSAGE, CLOSECONNECTIONMESSAGE);
            System.exit(0);
        }

        log.info("\nУспешно!");
    }

    private static void updateCartDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            log.info("\nВведите новое значение для колонки amount:");
            int updatedAmount = input.nextInt();
            CRUDutils.updateCartDataAmount(updatedAmount, columnId);
        } else if (choice == 2) {
            log.info("\nВведите новое значение для колонки customer_cart_id:");
            int updatedCustomerCartId = input.nextInt();
            CRUDutils.updateCartDataCustomerCartId(updatedCustomerCartId, columnId);
        } else if (choice == 3) {
            log.info("\nВведите новое значение для колонки product_data_id:");
            int updatedProductDataId = input.nextInt();
            CRUDutils.updateCartDataProductDataId(updatedProductDataId, columnId);
        } else {
            log.info("\n{}\n{}", ERRORMESSAGE, CLOSECONNECTIONMESSAGE);
            System.exit(0);
        }
    }

    private static void updateCourierDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            log.info("\nВведите новое значение для колонки courier_phone:");
            String updatedCourierPhone = input.next();
            CRUDutils.updateCourierDataCourierPhone(updatedCourierPhone, columnId);
        } else if (choice == 2) {
            log.info("\nВведите новое значение для колонки firstname:");
            String updatedCourierFirstname = input.next();
            CRUDutils.updateCourierDataFirstname(updatedCourierFirstname, columnId);
        } else if (choice == 3) {
            log.info("\nВведите новое значение для колонки lastname:");
            String updatedCourierLastname = input.next();
            CRUDutils.updateCourierDataLastname(updatedCourierLastname, columnId);
        } else if (choice == 4) {
            log.info("\nВведите новое значение для колонки vehicle:");
            String updatedCourierVehicle = input.next();
            CRUDutils.updateCourierDataVehicle(updatedCourierVehicle, columnId);
        } else {
            log.info("\n{}\n{}", ERRORMESSAGE, CLOSECONNECTIONMESSAGE);
            System.exit(0);
        }
    }

    private static void updateCustomerCartColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            log.info("\nВведите новое значение для колонки customer_data_id:");
            int updatedCustomerDataId = input.nextInt();
            CRUDutils.updateCustomerCartCustomerDataId(updatedCustomerDataId, columnId);
        } else {
            log.info("\n{}\n{}", ERRORMESSAGE, CLOSECONNECTIONMESSAGE);
            System.exit(0);
        }
    }

    private static void updateCustomerDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            log.info("\nВведите новое значение для колонки customer_phone:");
            String updatedCustomerPhone = input.next();
            CRUDutils.updateCustomerDataCustomerPhone(updatedCustomerPhone, columnId);
        } else if (choice == 2) {
            log.info("\nВведите новое значение для колонки email:");
            String updatedCustomerEmail = input.next();
            CRUDutils.updateCustomerDataEmail(updatedCustomerEmail, columnId);
        } else if (choice == 3) {
            log.info("\nВведите новое значение для колонки password:");
            String updatedCustomerPassword = input.next();
            CRUDutils.updateCustomerDataPassword(updatedCustomerPassword, columnId);
        } else if (choice == 4) {
            log.info("\nВведите новое значение для колонки username:");
            String updatedCustomerUsername = input.next();
            CRUDutils.updateCustomerDataUsername(updatedCustomerUsername, columnId);
        } else {
            log.info("\n{}\n{}", ERRORMESSAGE, CLOSECONNECTIONMESSAGE);
            System.exit(0);
        }
    }

    private static void updateOrderDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            input.nextLine();
            log.info("\nВведите новое значение для колонки address:");
            String updatedOrderAddress = input.nextLine();
            CRUDutils.updateOrderDataAddress(updatedOrderAddress, columnId);
        } else if (choice == 2) {
            log.info("\nВведите новое значение для колонки city:");
            String updatedOrderCity = input.next();
            CRUDutils.updateOrderDataCity(updatedOrderCity, columnId);
        } else if (choice == 3) {
            log.info("\nВведите новое значение для колонки courier_data_id:");
            int updatedOrderCourierId = input.nextInt();
            CRUDutils.updateOrderDataCourierDataId(updatedOrderCourierId, columnId);
        } else if (choice == 4) {
            log.info("\nВведите новое значение для колонки customer_data_id:");
            int updatedOrderCustomerId = input.nextInt();
            CRUDutils.updateOrderDataCustomerDataId(updatedOrderCustomerId, columnId);
        } else if (choice == 5) {
            log.info("\nВведите новое значение для колонки floor:");
            int updatedOrderFloor = input.nextInt();
            CRUDutils.updateOrderDataFloor(updatedOrderFloor, columnId);
        } else if (choice == 6) {
            input.nextLine();
            log.info("\nВведите новое значение для колонки payment:");
            String updatedOrderPayment = input.nextLine();
            CRUDutils.updateOrderDataPayment(updatedOrderPayment, columnId);
        } else if (choice == 7) {
            log.info("\nВведите новое значение для колонки total:");
            double updatedOrderTotal = input.nextDouble();
            CRUDutils.updateOrderDataTotal(updatedOrderTotal, columnId);
        } else {
            log.info("\n{}\n{}", ERRORMESSAGE, CLOSECONNECTIONMESSAGE);
            System.exit(0);
        }
    }

    private static void updateProductCategoryDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            log.info("\nВведите новое значение для колонки category_title:");
            String updatedProductCategoryTitle = input.next();
            CRUDutils.updateProductCategoryDataCategoryTitle(updatedProductCategoryTitle, columnId);
        } else if (choice == 2) {
            input.nextLine();
            log.info("\nВведите новое значение для колонки description:");
            String updatedProductCategoryDescription = input.nextLine();
            CRUDutils.updateProductCategoryDataDescription(updatedProductCategoryDescription, columnId);
        } else {
            log.info("\n{}\n{}", ERRORMESSAGE, CLOSECONNECTIONMESSAGE);
            System.exit(0);
        }
    }

    private static void updateProductDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            log.info("\nВведите новое значение для колонки image_link:");
            String updatedProductImageLink = input.next();
            CRUDutils.updateProductDataImageLink(updatedProductImageLink, columnId);
        } else if (choice == 2) {
            log.info("\nВведите новое значение для колонки price:");
            double updatedProductPrice = input.nextDouble();
            CRUDutils.updateProductDataPrice(updatedProductPrice, columnId);
        } else if (choice == 3) {
            log.info("\nВведите новое значение для колонки product_category_id:");
            int updatedProductCategoryId = input.nextInt();
            CRUDutils.updateProductDataProductCategoryId(updatedProductCategoryId, columnId);
        } else if (choice == 4) {
            log.info("\nВведите новое значение для колонки product_rating:");
            int updatedProductRating = input.nextInt();
            CRUDutils.updateProductDataProductRating(updatedProductRating, columnId);
        } else if (choice == 5) {
            log.info("\nВведите новое значение для колонки product_title:");
            String updatedProductTitle = input.next();
            CRUDutils.updateProductDataProductTitle(updatedProductTitle, columnId);
        } else {
            log.info("\n{}\n{}", ERRORMESSAGE, CLOSECONNECTIONMESSAGE);
            System.exit(0);
        }
    }

    private static void updateReviewDataColumns(int columnId) throws PersonalExceptions {
        int choice = input.nextInt();

        if (choice == 1) {
            input.nextLine();
            log.info("\nВведите новое значение для колонки comment:");
            String updatedReviewComment = input.nextLine();
            CRUDutils.updateReviewDataComment(updatedReviewComment, columnId);
        } else if (choice == 2) {
            log.info("\nВведите новое значение для колонки review_rating:");
            int updatedReviewRating = input.nextInt();
            CRUDutils.updateReviewDataReviewRating(updatedReviewRating, columnId);
        } else {
            log.info("\n{}\n{}", ERRORMESSAGE, CLOSECONNECTIONMESSAGE);
            System.exit(0);
        }
    }
}