package cin.ufpe.aps.AluCar.dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDAO {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/AluCar";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Ronaldo09";

    // Establish a connection
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        return connection;  
    }

    // Execute a SELECT query
    public ResultSet executeQuery(String sql) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
        
    }

    // Execute an INSERT, UPDATE, or DELETE query
    public int executeUpdate(String sql) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeUpdate();
        
    }

    // Example: Insert data into Car table
    public void insertCarData(String modelo, String placa, double preco, int ano,
                              String combustivel, String transmissao, String linkFotos, int locadoraId) {
        String sql = "INSERT INTO Car (modelo, placa, preco, ano, combustivel, transmissao, linkFotos, locadora) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, modelo);
            statement.setString(2, placa);
            statement.setDouble(3, preco);
            statement.setInt(4, ano);
            statement.setString(5, combustivel);
            statement.setString(6, transmissao);
            statement.setString(7, linkFotos);
            statement.setInt(8, locadoraId);
            connection.close();
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Example: Update data in Car table
    public int updateCarData(double newPreco, String placa) throws SQLException {
        String sql = "UPDATE Car SET preco = ? WHERE placa = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, newPreco);
            statement.setString(2, placa);
            connection.close();
            return statement.executeUpdate();
        }
    }

    // Example: Delete data from Car table
    public int deleteCarData(String placa) throws SQLException {
        String sql = "DELETE FROM Car WHERE placa = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, placa);
            connection.close();
            return statement.executeUpdate();
        }
    }
}
