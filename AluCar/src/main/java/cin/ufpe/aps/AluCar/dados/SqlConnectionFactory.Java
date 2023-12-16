class SqlConnectionFactory implements DatabaseConnectionFactory {
    // Concrete Factorie
    @Override
    public DatabaseConnection createConnection() {
        return new SqlConnection();
    }
}