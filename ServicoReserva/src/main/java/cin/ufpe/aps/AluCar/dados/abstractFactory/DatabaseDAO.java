package cin.ufpe.aps.AluCar.dados.abstractFactory;

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

    public void insertCartaoData(String cvc, String nome, String numero, String dataValidade) {
        String sql = "INSERT INTO Cartao (cvc, nome, numero, dataValidade) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cvc);
            statement.setString(2, nome);
            statement.setString(3, numero);
            statement.setString(4, dataValidade);
            connection.close();
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Example: Update data in Cartao table
    public int updateCartaoData(String newCvc, String numero) throws SQLException {
        String sql = "UPDATE Cartao SET cvc = ? WHERE numero = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newCvc);
            statement.setString(2, numero);
            connection.close();
            return statement.executeUpdate();
        }
    }

    // Example: Delete data from Cartao table
    public int deleteCartaoData(String numero) throws SQLException {
        String sql = "DELETE FROM Cartao WHERE numero = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, numero);
            connection.close();
            return statement.executeUpdate();
        }
    }

    public void insertUsuarioData(String email, String nome, String senha, int cartaoId) {
        String sql = "INSERT INTO Usuario (email, nome, senha, cartao) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, nome);
            statement.setString(3, senha);
            statement.setInt(4, cartaoId);
            connection.close();
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Example: Update data in Usuario table
    public int updateUsuarioData(String newSenha, String email) throws SQLException {
        String sql = "UPDATE Usuario SET senha = ? WHERE email = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newSenha);
            statement.setString(2, email);
            connection.close();
            return statement.executeUpdate();
        }
    }

    // Example: Delete data from Usuario table
    public int deleteUsuarioData(String email) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE email = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            connection.close();
            return statement.executeUpdate();
        }
    }

    // Example: Insert data into Locadora table
    public void insertLocadoraData(String descricao, String localizacao) {
        String sql = "INSERT INTO Locadora (descricao, localizacao) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, descricao);
            statement.setString(2, localizacao);
            connection.close();
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Example: Update data in Locadora table
    public int updateLocadoraData(String newDescricao, int id) throws SQLException {
        String sql = "UPDATE Locadora SET descricao = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newDescricao);
            statement.setInt(2, id);
            connection.close();
            return statement.executeUpdate();
        }
    }

    // Example: Delete data from Locadora table
    public int deleteLocadoraData(int id) throws SQLException {
        String sql = "DELETE FROM Locadora WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            connection.close();
            return statement.executeUpdate();
        }
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

    public void insertReservaData(String placa, float valor, int taxa, Date dataInicio, Date dataTermino, String usuario) {
        String sql = "INSERT INTO Reserva (placa, valor, taxa, dataInicio, dataTermino, usuario) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, placa);
            statement.setDouble(2, valor);
            statement.setInt(3, taxa);
            statement.setDate(4, dataInicio);
            statement.setDate(5, dataTermino);
            statement.setString(6, usuario);
            connection.close();
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Example: Update data in Reserva table
    public int updateReservaData(double newValor, int id) throws SQLException {
        String sql = "UPDATE Reserva SET valor = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, newValor);
            statement.setInt(2, id);
            connection.close();
            return statement.executeUpdate();
        }
    }

    // Example: Delete data from Reserva table
    public int deleteReservaData(int id) throws SQLException {
        String sql = "DELETE FROM Reserva WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            connection.close();
            return statement.executeUpdate();
        }
    }

    // Example: Insert data into a table
    public void insertData() throws SQLException {
        String sql = "INSERT INTO locadora (nome, descricao, localizacao) VALUES ('aaaa', 'bbbb', 'cccc')";
        System.out.println("Entrei insert");
        try  {
            Connection connection = getConnection();
            System.out.println("Conectou banco");
            Statement statement = connection.createStatement();
            // Set other parameters as needed
            statement.executeUpdate(sql);
            System.out.println("Fez update");
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
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
