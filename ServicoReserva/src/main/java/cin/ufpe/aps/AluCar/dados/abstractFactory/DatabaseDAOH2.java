package cin.ufpe.aps.AluCar.dados.abstractFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDAOH2 {
    private static final String JDBC_URL = "jdbc:h2:mem:alucar";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "guga";

    // Establish a connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    // Execute a SELECT query
    public ResultSet executeQuery(String sql, Object... params) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        setParameters(statement, params);
        return statement.executeQuery();
    }

    // Execute an INSERT, UPDATE, or DELETE query
    public int executeUpdate(String sql, Object... params) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            setParameters(statement, params);
            return statement.executeUpdate();
        }
    }

    private void setParameters(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }

    // Example: Insert data into a table
    public int insertData(String data) throws SQLException {
        String sql = "INSERT INTO your_table_name (column1, column2) VALUES (?, ?)";
        return executeUpdate(sql, data);
    }

    // Example: Update data in a table
    public int updateData(String newData, int id) throws SQLException {
        String sql = "UPDATE your_table_name SET column1 = ? WHERE id = ?";
        return executeUpdate(sql, newData, id);
    }

    // Example: Delete data from a table
    public int deleteData(int id) throws SQLException {
        String sql = "DELETE FROM your_table_name WHERE id = ?";
        return executeUpdate(sql, id);
    }

    public Statement createStatement() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            return connection.createStatement();
        } else {
            throw new SQLException("Connection is not established. Can't create statement.");
        }
    }
}
