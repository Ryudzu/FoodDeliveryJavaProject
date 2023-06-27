package model.connection;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public final class DatabaseConnection {

    private DatabaseConnection() {}

    private static Connection connection = null;

    public static Connection connect() {
        String username;
        String password;
        String url;

        try (InputStream iStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("databaseprops.txt")) {
            Properties props = new Properties();
            props.load(iStream);

            username = props.getProperty("username");
            password = props.getProperty("password");
            url = props.getProperty("url");
        } catch (Exception e) {
            throw new IllegalArgumentException("Системе не удалось найти указанное расположение файла или записать данные из файла!");
        }

        try {
            Driver sqlDriver = new org.postgresql.Driver();
            DriverManager.registerDriver(sqlDriver);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Драйвер не удалось зарегистрировать!");
        }

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка подключения к базе данных!");
        }

        return connection;
    }

    public static void closeConnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка при закрытии подключения к базе данных!");
        }
    }
}
