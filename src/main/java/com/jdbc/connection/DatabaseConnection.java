package com.jdbc.connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DatabaseConnection {

    private DatabaseConnection() {}

    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "rootroot";
    private static final String URL = "jdbc:postgresql://localhost:5432/food_delivery";

    private static Connection connection = null;

    public static Connection connect() {
        try {
            Driver sqlDriver = new org.postgresql.Driver();
            DriverManager.registerDriver(sqlDriver);
        } catch (SQLException e) {
            logger.log(Level.INFO, "Драйвер не зарегистрирован.");
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            logger.log(Level.INFO, "Ошибка подключения к базе данных.");
        }

        return connection;
    }

    public static void closeConnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка при закрытии подключения к базе данных.");
        }
    }
}
