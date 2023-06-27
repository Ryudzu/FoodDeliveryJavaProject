package model.menu;

import lombok.extern.slf4j.Slf4j;
import model.connection.DatabaseConnection;
import model.crud.CRUDutils;

import java.util.*;

@Slf4j
public final class Delete {

    private Delete() {}

    private static final Scanner input = new Scanner(System.in);

    public static void delete() {
        log.info("""
                
                Содержимое какой таблицы вы бы хотели удалить?
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

        log.info("\nВведите ID строки, которую необходимо удалить:");
        int columnId = input.nextInt();

        if (choice == 1)
            CRUDutils.deleteCartData(columnId);
        else if (choice == 2)
            CRUDutils.deleteCourierData(columnId);
        else if (choice == 3)
            CRUDutils.deleteCustomerCart(columnId);
        else if (choice == 4)
            CRUDutils.deleteCustomerData(columnId);
        else if (choice == 5)
            CRUDutils.deleteOrderData(columnId);
        else if (choice == 6)
            CRUDutils.deleteProductAndOrder(columnId);
        else if (choice == 7)
            CRUDutils.deleteProductCategoryData(columnId);
        else if (choice == 8)
            CRUDutils.deleteProductData(columnId);
        else if (choice == 9)
            CRUDutils.deleteReviewData(columnId);
        else {
            log.info("\nТакого выбора не существует в меню. Повторите попытку.\nЗакрываем подключение с базой данных...");
            System.exit(0);
        }

        log.info("\nУспешно!");
    }
}
