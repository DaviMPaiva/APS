package cin.ufpe.aps.AluCar.dados.abstractFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    // Establish a connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    // Execute a SELECT query
    public ResultSet executeQuery(String sql) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            return statement.executeQuery();
        }
    }

    // Execute an INSERT, UPDATE, or DELETE query
    public int executeUpdate(String sql) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            return statement.executeUpdate();
        }
    }

    // Example: Insert data into a table
    public int insertData(String data) throws SQLException {
        String sql = "INSERT INTO your_table_name (column1, column2) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, data);
            // Set other parameters as needed
            return statement.executeUpdate();
        }
    }

    // Example: Update data in a table
    public int updateData(String newData, int id) throws SQLException {
        String sql = "UPDATE your_table_name SET column1 = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newData);
            statement.setInt(2, id);
            // Set other parameters as needed
            return statement.executeUpdate();
        }
    }

    // Example: Delete data from a table
    public int deleteData(int id) throws SQLException {
        String sql = "DELETE FROM your_table_name WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
    }
}
