package model;

import lombok.extern.slf4j.Slf4j;
import model.connection.DatabaseConnection;
import model.exceptions.PersonalExceptions;
import model.menu.*;

import java.sql.SQLException;
import java.util.Scanner;

@Slf4j
public class App {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws PersonalExceptions, SQLException {
        databaseMenu();
    }

    public static void databaseMenu() throws PersonalExceptions, SQLException {
        boolean repeat = true;

        do {
            log.info("""
                    \nВыберите функцию для взаимодействия с базами данных:
                    1. Вывести содержимое таблицы на экран
                    2. Вывести конкретную строку таблицы на экран
                    3. Вставить новую строку в таблицу
                    4. Обновить строку таблицы
                    5. Удалить строку таблицы
                    6. Выход""");

            int choice = input.nextInt();

            if (choice == 1)
                Select.showAll();
            else if (choice == 2)
                Select.showConcrete();
            else if (choice == 3)
                Insert.insert();
            else if (choice == 4)
                Update.update();
            else if (choice == 5)
                Delete.delete();
            else if (choice == 6)
                repeat = false;
            else {
                log.info("\nТакого выбора не существует в меню. Повторите попытку.");
                repeat = false;
            }
        } while (repeat);

        log.info("\nЗакрываем подключение с базой данных...");
        if (!DatabaseConnection.connect().isClosed())
            DatabaseConnection.closeConnect();
    }
}