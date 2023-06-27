package model.crud;

import model.connection.DatabaseConnection;
import model.data.*;
import model.validator.*;
import model.exceptions.PersonalExceptions;

import java.sql.*;
import java.util.*;

public final class CRUDutils {

    public CRUDutils() {}

    // Подключение к базе данных для осуществления запросов.

    private static final Connection CONNECTION = DatabaseConnection.connect();
    private static final String ERRORMESSAGE = "Ошибка доступа к базе данных или иная ошибка, связанная с работой с базами данных!";

    // Метод showAll позволяет просмотреть все содержимое в конкретной таблице (SELECT * FROM).

    public static List<CartData> showAllCartData() {
        List<CartData> carts = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM cart_data ORDER BY id")) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int amount = result.getInt("amount");
                int productDataId = result.getInt("product_data_id");
                int customerCartId = result.getInt("customer_cart_id");

                carts.add(new CartData(id, amount, productDataId, customerCartId));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return carts;
    }

    public static List<CourierData> showAllCourierData() {
        List<CourierData> couriers = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM courier_data ORDER BY id")) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String courierPhone = result.getString("courier_phone");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                String vehicle = result.getString("vehicle");

                couriers.add(new CourierData(id, courierPhone, firstname, lastname, vehicle));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return couriers;
    }

    public static List<CustomerCart> showAllCustomerCart() {
        List<CustomerCart> customerCarts = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM customer_cart ORDER BY id")) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int customerDataId = result.getInt("customer_data_id");

                customerCarts.add(new CustomerCart(id, customerDataId));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return customerCarts;
    }

    public static List<CustomerData> showAllCustomerData() {
        List<CustomerData> customers = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM customer_data ORDER BY id")) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String customerPhone = result.getString("customer_phone");
                String email = result.getString("email");
                String password = result.getString("password");
                String username = result.getString("username");
                Timestamp accountRegistered = result.getTimestamp("account_registered_time");

                customers.add(new CustomerData(id, customerPhone, email, password, username, accountRegistered));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return customers;
    }

    public static List<OrderData> showAllOrderData() {
        List<OrderData> orders = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM order_data ORDER BY id")) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String address = result.getString("address");
                String city = result.getString("city");
                int courierDataId = result.getInt("courier_data_id");
                int customerDataId = result.getInt("customer_data_id");
                int floor = result.getInt("floor");
                String payment = result.getString("payment");
                double total = result.getDouble("total");

                orders.add(new OrderData(id, address, city, courierDataId, customerDataId, floor, payment, total));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return orders;
    }

    public static List<ProductAndOrder> showAllProductAndOrder() {
        List<ProductAndOrder> productsAndOrders = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM product_and_order")) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int amountOrdered = result.getInt("amount_ordered");
                Timestamp timeOrdered = result.getTimestamp("product_ordered_time");
                int orderDataId = result.getInt("order_data_id");
                int productDataId = result.getInt("product_data_id");

                productsAndOrders.add(new ProductAndOrder(amountOrdered, timeOrdered, orderDataId, productDataId));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return productsAndOrders;
    }

    public static List<ProductCategoryData> showAllProductCategoryData() {
        List<ProductCategoryData> categories = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM product_category_data ORDER BY id")) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String categoryTitle = result.getString("category_title");
                String description = result.getString("description");

                categories.add(new ProductCategoryData(id, categoryTitle, description));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return categories;
    }

    public static List<ProductData> showAllProductData() {
        List<ProductData> products = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM product_data ORDER BY id")) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String imageLink = result.getString("image_link");
                double price = result.getDouble("price");
                int productCategoryId = result.getInt("product_category_id");
                int productRating = result.getInt("product_rating");
                String productTitle = result.getString("product_title");

                products.add(new ProductData(id, imageLink, price, productCategoryId, productRating, productTitle));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return products;
    }

    public static List<ReviewData> showAllReviewData() {
        List<ReviewData> reviews = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM review_data ORDER BY id")) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String comment = result.getString("comment");
                int reviewData = result.getInt("review_rating");

                reviews.add(new ReviewData(id, comment, reviewData));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return reviews;
    }

    public static List<CartData> showConcreteCartData(int idCartData) {
        List<CartData> cart = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM cart_data WHERE id = ?")) {
            statement.setInt(1, idCartData);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                int amount = result.getInt("amount");
                int productDataId = result.getInt("product_data_id");
                int customerCartId = result.getInt("customer_cart_id");

                cart.add(new CartData(id, amount, productDataId, customerCartId));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return cart;
    }

    public static List<CourierData> showConcreteCourierData(int idCourierData) {
        List<CourierData> courier = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM courier_data WHERE id = ?")) {
            statement.setInt(1, idCourierData);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                String courierPhone = result.getString("courier_phone");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                String vehicle = result.getString("vehicle");

                courier.add(new CourierData(id, courierPhone, firstname, lastname, vehicle));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return courier;
    }

    public static List<CustomerCart> showConcreteCustomerCart(int idCustomerCart) {
        List<CustomerCart> customerCart = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM customer_cart WHERE id = ?")) {
            statement.setInt(1, idCustomerCart);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                int customerDataId = result.getInt("customer_data_id");

                customerCart.add(new CustomerCart(id, customerDataId));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return customerCart;
    }

    public static List<CustomerData> showConcreteCustomerData(int idCustomerData) {
        List<CustomerData> customer = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM customer_data WHERE id = ?")) {
            statement.setInt(1, idCustomerData);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                String customerPhone = result.getString("customer_phone");
                String email = result.getString("email");
                String password = result.getString("password");
                String username = result.getString("username");
                Timestamp accountRegistered = result.getTimestamp("account_registered_time");

                customer.add(new CustomerData(id, customerPhone, email, password, username, accountRegistered));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return customer;
    }

    public static List<OrderData> showConcreteOrderData(int idOrderData) {
        List<OrderData> order = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM order_data WHERE id = ?")) {
            statement.setInt(1, idOrderData);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                String address = result.getString("address");
                String city = result.getString("city");
                int courierDataId = result.getInt("courier_data_id");
                int customerDataId = result.getInt("customer_data_id");
                int floor = result.getInt("floor");
                String payment = result.getString("payment");
                double total = result.getDouble("total");

                order.add(new OrderData(id, address, city, courierDataId, customerDataId, floor, payment, total));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return order;
    }

    public static List<ProductAndOrder> showConcreteProductAndOrder(int idProductAndOrder) {
        List<ProductAndOrder> productAndOrder = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM product_and_order WHERE order_data_id = ?")) {
            statement.setInt(1, idProductAndOrder);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int amountOrdered = result.getInt("amount_ordered");
                Timestamp timeOrdered = result.getTimestamp("product_ordered_time");
                int orderDataId = result.getInt("order_data_id");
                int productDataId = result.getInt("product_data_id");

                productAndOrder.add(new ProductAndOrder(amountOrdered, timeOrdered, orderDataId, productDataId));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return productAndOrder;
    }

    public static List<ProductCategoryData> showConcreteProductCategoryData(int idProductCategory) {
        List<ProductCategoryData> category = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM product_category_data WHERE id = ?")) {
            statement.setInt(1, idProductCategory);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                String categoryTitle = result.getString("category_title");
                String description = result.getString("description");

                category.add(new ProductCategoryData(id, categoryTitle, description));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return category;
    }

    public static List<ProductData> showConcreteProductData(int idProductData) {
        List<ProductData> product = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM product_data WHERE id = ?")) {
            statement.setInt(1, idProductData);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                String imageLink = result.getString("image_link");
                double price = result.getDouble("price");
                int productCategoryId = result.getInt("product_category_id");
                int productRating = result.getInt("product_rating");
                String productTitle = result.getString("product_title");

                product.add(new ProductData(id, imageLink, price, productCategoryId, productRating, productTitle));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return product;
    }

    public static List<ReviewData> showConcreteReviewData(int idReviewData) {
        List<ReviewData> review = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM review_data WHERE id = ?")) {
            statement.setInt(1, idReviewData);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String comment = result.getString("comment");
                int reviewData = result.getInt("review_rating");

                review.add(new ReviewData(id, comment, reviewData));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return review;
    }

    // Метод insert позволяет вставить в таблицу новые данные (INSERT INTO таблица).

    public static void insertCartData(int amount, int productDataId, int customerCartId) throws PersonalExceptions {
        new CartDataValidator(amount, productDataId, customerCartId);
        CartData cart = CartDataValidator.cart;

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO cart_data (amount, product_data_id, customer_cart_id) VALUES (?, ?, ?)")) {
            statement.setInt(1, cart.getAmount());
            statement.setInt(2, cart.getProductDataId());
            statement.setInt(3, cart.getCustomerCartId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void insertCourierData(String courierPhone, String firstname, String lastname, String vehicle) throws PersonalExceptions {
        new CourierDataValidator(courierPhone, firstname, lastname, vehicle);
        CourierData courier = CourierDataValidator.courier;

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO courier_data (courier_phone, firstname, lastname, vehicle) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, courier.getCourierPhone());
            statement.setString(2, courier.getFirstname());
            statement.setString(3, courier.getLastname());
            statement.setString(4, courier.getVehicle());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void insertCustomerCart(int customerDataId) throws PersonalExceptions {
        new CustomerCartValidator(customerDataId);
        CustomerCart customerCart = CustomerCartValidator.customerCart;

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO customer_cart (customer_data_id) VALUES (?)")) {
            statement.setInt(1, customerCart.getCustomerDataId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void insertCustomerData(String customerPhone, String email, String password, String username) throws PersonalExceptions {
        new CustomerDataValidator(customerPhone, email, password, username);
        CustomerData customer = CustomerDataValidator.customer;

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO customer_data (customer_phone, email, password, username) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, customer.getCustomerPhone());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPassword());
            statement.setString(4, customer.getUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void insertOrderData(String address, String city, int courierDataId, int customerDataId, int floor, String payment, double total) throws PersonalExceptions {
        new OrderDataValidator(address, city, courierDataId, customerDataId, floor, payment, total);
        OrderData order = OrderDataValidator.order;

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO order_data (address, city, courier_data_id, customer_data_id, floor, payment, total) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, order.getAddress());
            statement.setString(2, order.getCity());
            statement.setInt(3, order.getCourierDataId());
            statement.setInt(4, order.getCustomerDataId());
            statement.setInt(5, order.getFloor());
            statement.setString(6, order.getPayment());
            statement.setDouble(7, order.getTotal());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void insertProductAndOrder(int amountOrdered, int orderDataId, int productDataId) throws PersonalExceptions {
        new ProductAndOrderValidator(amountOrdered, orderDataId, productDataId);
        ProductAndOrder productAndOrder = ProductAndOrderValidator.productAndOrder;

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO product_and_order (amount_ordered, order_data_id, product_data_id) VALUES (?, ?, ?)")) {
            statement.setInt(1, productAndOrder.getAmountOrdered());
            statement.setInt(2, productAndOrder.getOrderDataId());
            statement.setInt(3, productAndOrder.getProductDataId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void insertProductCategoryData(String categoryTitle, String description) throws PersonalExceptions {
        new ProductCategoryDataValidator(categoryTitle, description);
        ProductCategoryData category = ProductCategoryDataValidator.category;

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO product_category_data (category_title, description) VALUES (?, ?)")) {
            statement.setString(1, category.getCategoryTitle());
            statement.setString(2, category.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void insertProductData(String imageLink, double price, int productCategoryId, int productRating, String productTitle) throws PersonalExceptions {
        new ProductDataValidator(imageLink, price, productCategoryId, productRating, productTitle);
        ProductData product = ProductDataValidator.product;

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO product_data (image_link, price, product_category_id, product_rating, product_title) VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, product.getImageLink());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getProductCategoryId());
            statement.setInt(4, product.getProductRating());
            statement.setString(5, product.getProductTitle());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void insertReviewData(String comment, int reviewRating) throws PersonalExceptions {
        new ReviewDataValidator(comment, reviewRating);
        ReviewData review = ReviewDataValidator.review;

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO review_data (comment, review_rating) VALUES (?, ?)")) {
            statement.setString(1, review.getComment());
            statement.setInt(2, review.getReviewRating());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    // Метод update позволяет обновить определенный столбец таблицы (UPDATE таблица SET).

    public static void updateCartDataAmount(int amount, int id) throws PersonalExceptions {
        CartDataValidator validAmount = new CartDataValidator();
        validAmount.validateAmount(amount);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE cart_data SET amount = ? WHERE id = ?")) {
            statement.setInt(1, amount);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateCartDataCustomerCartId(int customerCartId, int id) throws PersonalExceptions {
        CartDataValidator validCustomerCartId = new CartDataValidator();
        validCustomerCartId.validateCustomerCartId(customerCartId);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE cart_data SET customer_cart_id = ? WHERE id = ?")) {
            statement.setInt(1, customerCartId);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateCartDataProductDataId(int productDataId, int id) throws PersonalExceptions {
        CartDataValidator validProductDataId = new CartDataValidator();
        validProductDataId.validateProductDataId(productDataId);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE cart_data SET product_data_id = ? WHERE id = ?")) {
            statement.setInt(1, productDataId);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateCourierDataCourierPhone(String courierPhone, int id) throws PersonalExceptions {
        CourierDataValidator validCourierPhone = new CourierDataValidator();
        validCourierPhone.validateCourierPhone(courierPhone);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE courier_data SET courier_phone = ? WHERE id = ?")) {
            statement.setString(1, courierPhone);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateCourierDataFirstname(String firstname, int id) throws PersonalExceptions {
        CourierDataValidator validFirstname= new CourierDataValidator();
        validFirstname.validateFirstname(firstname);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE courier_data SET firstname = ? WHERE id = ?")) {
            statement.setString(1, firstname);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateCourierDataLastname(String lastname, int id) throws PersonalExceptions {
        CourierDataValidator validLastname = new CourierDataValidator();
        validLastname.validateLastname(lastname);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE courier_data SET lastname = ? WHERE id = ?")) {
            statement.setString(1, lastname);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateCourierDataVehicle(String vehicle, int id) throws PersonalExceptions {
        CourierDataValidator validVehicle = new CourierDataValidator();
        validVehicle.validateVehicle(vehicle);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE courier_data SET vehicle = ? WHERE id = ?")) {
            statement.setString(1, vehicle);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateCustomerCartCustomerDataId(int customerDataId, int id) throws PersonalExceptions {
        CustomerCartValidator validCustomerDataId = new CustomerCartValidator();
        validCustomerDataId.validateCustomerDataId(customerDataId);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE customer_cart SET customer_data_id = ? WHERE id = ?")) {
            statement.setInt(1, customerDataId);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateCustomerDataCustomerPhone(String customerPhone, int id) throws PersonalExceptions {
        CustomerDataValidator validCustomerPhone = new CustomerDataValidator();
        validCustomerPhone.validateCustomerPhone(customerPhone);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE customer_data SET customer_phone = ? WHERE id = ?")) {
            statement.setString(1, customerPhone);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateCustomerDataEmail(String email, int id) throws PersonalExceptions {
        CustomerDataValidator validEmail = new CustomerDataValidator();
        validEmail.validateEmail(email);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE customer_data SET email = ? WHERE id = ?")) {
            statement.setString(1, email);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateCustomerDataPassword(String password, int id) throws PersonalExceptions {
        CustomerDataValidator validPassword = new CustomerDataValidator();
        validPassword.validatePassword(password);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE customer_data SET password = ? WHERE id = ?")) {
            statement.setString(1, password);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateCustomerDataUsername(String username, int id) throws PersonalExceptions {
        CustomerDataValidator validUsername = new CustomerDataValidator();
        validUsername.validateUsername(username);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE customer_data SET username = ? WHERE id = ?")) {
            statement.setString(1, username);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateOrderDataAddress(String address, int id) throws PersonalExceptions {
        OrderDataValidator validAddress = new OrderDataValidator();
        validAddress.validateAddress(address);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE order_data SET address = ? WHERE id = ?")) {
            statement.setString(1, address);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateOrderDataCity(String city, int id) throws PersonalExceptions {
        OrderDataValidator validCity = new OrderDataValidator();
        validCity.validateCity(city);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE order_data SET city = ? WHERE id = ?")) {
            statement.setString(1, city);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateOrderDataCourierDataId(int courierDataId, int id) throws PersonalExceptions {
        OrderDataValidator validCourierDataId = new OrderDataValidator();
        validCourierDataId.validateCourierDataId(courierDataId);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE order_data SET courier_data_id = ? WHERE id = ?")) {
            statement.setInt(1, courierDataId);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateOrderDataCustomerDataId(int customerDataId, int id) throws PersonalExceptions {
        OrderDataValidator validCustomerDataId = new OrderDataValidator();
        validCustomerDataId.validateCustomerDataId(customerDataId);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE order_data SET customer_data_id = ? WHERE id = ?")) {
            statement.setInt(1, customerDataId);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateOrderDataFloor(int floor, int id) throws PersonalExceptions {
        OrderDataValidator validFloor = new OrderDataValidator();
        validFloor.validateFloor(floor);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE order_data SET floor = ? WHERE id = ?")) {
            statement.setInt(1, floor);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateOrderDataPayment(String payment, int id) throws PersonalExceptions {
        OrderDataValidator validPayment = new OrderDataValidator();
        validPayment.validatePayment(payment);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE order_data SET payment = ? WHERE id = ?")) {
            statement.setString(1, payment);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateOrderDataTotal(double total, int id) throws PersonalExceptions {
        OrderDataValidator validTotal = new OrderDataValidator();
        validTotal.validateTotal(total);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE order_data SET total = ? WHERE id = ?")) {
            statement.setDouble(1, total);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateProductCategoryDataCategoryTitle(String categoryTitle, int id) throws PersonalExceptions {
        ProductCategoryDataValidator validCategoryTitle = new ProductCategoryDataValidator();
        validCategoryTitle.validateCategoryTitle(categoryTitle);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE product_category_data SET category_title = ? WHERE id = ?")) {
            statement.setString(1, categoryTitle);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateProductCategoryDataDescription(String description, int id) throws PersonalExceptions {
        ProductCategoryDataValidator validDescription = new ProductCategoryDataValidator();
        validDescription.validateDescription(description);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE product_category_data SET description = ? WHERE id = ?")) {
            statement.setString(1, description);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateProductDataImageLink(String imageLink, int id) {
        ProductDataValidator validImageLink = new ProductDataValidator();
        validImageLink.validateImageLink(imageLink);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE product_data SET image_link = ? WHERE id = ?")) {
            statement.setString(1, imageLink);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateProductDataPrice(double price, int id) throws PersonalExceptions {
        ProductDataValidator validPrice = new ProductDataValidator();
        validPrice.validatePrice(price);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE product_data SET price = ? WHERE id = ?")) {
            statement.setDouble(1, price);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateProductDataProductCategoryId(int productCategoryId, int id) throws PersonalExceptions {
        ProductDataValidator validProductCategoryId = new ProductDataValidator();
        validProductCategoryId.validateProductCategoryId(productCategoryId);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE product_data SET product_category_id = ? WHERE id = ?")) {
            statement.setInt(1, productCategoryId);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateProductDataProductRating(int productRating, int id) throws PersonalExceptions {
        ProductDataValidator validProductRating = new ProductDataValidator();
        validProductRating.validateProductRating(productRating);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE product_data SET product_rating = ? WHERE id = ?")) {
            statement.setInt(1, productRating);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateProductDataProductTitle(String productTitle, int id) throws PersonalExceptions {
        ProductDataValidator validProductTitle = new ProductDataValidator();
        validProductTitle.validateProductTitle(productTitle);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE product_data SET product_title = ? WHERE id = ?")) {
            statement.setString(1, productTitle);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateReviewDataComment(String comment, int id) {
        ReviewDataValidator validComment = new ReviewDataValidator();
        validComment.validateComment(comment);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE review_data SET comment = ? WHERE id = ?")) {
            statement.setString(1, comment);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void updateReviewDataReviewRating(int reviewRating, int id) throws PersonalExceptions {
        ReviewDataValidator validReviewRating = new ReviewDataValidator();
        validReviewRating.validateReviewRating(reviewRating);

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE review_data SET review_rating = ? WHERE id = ?")) {
            statement.setInt(1, reviewRating);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    // Метод delete позволяет удалить конкретную строку в конкретной таблице (DELETE FROM таблица).

    public static void deleteCartData(int id) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM cart_data WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void deleteCourierData(int id) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM courier_data WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void deleteCustomerCart(int id) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM customer_cart WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void deleteCustomerData(int id) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM customer_data WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void deleteOrderData(int id) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM order_data WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void deleteProductAndOrder(int id) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM product_and_order WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void deleteProductCategoryData(int id) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM product_category_data WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void deleteProductData(int id) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM product_data WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static void deleteReviewData(int id) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM review_data WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    // EXTRA CRUDs

    public static boolean isCustomerExists(String loginProvided, String passwordProvided) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM customer_data WHERE username = ? AND password = ?")) {
            statement.setString(1, loginProvided);
            statement.setString(2, passwordProvided);

            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static boolean isProductAlreadyInCart(int idProduct) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT product_data_id FROM cart_data WHERE product_data_id = ?")) {
            statement.setInt(1, idProduct);
            ResultSet result = statement.executeQuery();

            return result.next();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static int showCustomerId(String providedLogin) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT id FROM customer_data WHERE username = ?")) {
            statement.setString(1, providedLogin);
            ResultSet result = statement.executeQuery();

            if (result.next())
                return result.getInt("id");
            else
                return 0;
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static int showOrderId(int idCustomer) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT id FROM order_data WHERE customer_data_id = ?")) {
            statement.setInt(1, idCustomer);
            ResultSet result = statement.executeQuery();

            if (result.next())
                return result.getInt("id");
            else
                return 0;
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    public static List<ProductsInCart> showAllProductsInCart(int idCustomer) {
        List<ProductsInCart> cartProducts = new ArrayList<>();

        try (PreparedStatement statement = CONNECTION.prepareStatement("SELECT cart_data.id, product_data.product_title, cart_data.product_data_id, product_data.price, cart_data.amount FROM product_data INNER JOIN cart_data ON product_data.id = cart_data.product_data_id WHERE customer_cart_id = ?")) {
            statement.setInt(1, idCustomer);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String productTitle = result.getString("product_title");
                int productDataId = result.getInt("product_data_id");
                double price = result.getDouble("price");
                int amount = result.getInt("amount");

                cartProducts.add(new ProductsInCart(id, productTitle, productDataId, price, amount));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        return cartProducts;
    }

    public static void deleteAllFromCart(int idCustomer) {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM cart_data WHERE customer_cart_id = ?")) {
            statement.setInt(1, idCustomer);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }
}