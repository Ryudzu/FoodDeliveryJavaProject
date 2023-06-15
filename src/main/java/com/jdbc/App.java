package com.jdbc;

import com.jdbc.connection.DatabaseConnection;
import com.jdbc.exceptions.PersonalExceptions;
import com.jdbc.menu.Delete;
import com.jdbc.menu.Insert;
import com.jdbc.menu.Select;
import com.jdbc.menu.Update;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws PersonalExceptions {
        databaseMenu();
    }

    public static void databaseMenu() throws PersonalExceptions {
        DatabaseConnection.connect();
        boolean repeat = true;

        do {
            logger.log(Level.INFO, """
                    Выберите функцию для взаимодействия с базами данных:
                    1. Вывести содержимое таблицы на экран
                    2. Вставить новую строку в таблицу
                    3. Обновить строку таблицы
                    4. Удалить строку таблицы
                    5. Выход""");

            int choice = input.nextInt();

            if (choice == 1)
                Select.showAll();
            else if (choice == 2)
                Insert.insert();
            else if (choice == 3)
                Update.update();
            else if (choice == 4)
                Delete.delete();
            else if (choice == 5)
                repeat = false;
            else {
                logger.log(Level.INFO, "Такого выбора не существует в меню. Повторите попытку.");
                repeat = false;
            }
        } while (repeat);

        logger.log(Level.INFO, "Закрываем подключение с базой данных...");
        DatabaseConnection.closeConnect();
    }
}