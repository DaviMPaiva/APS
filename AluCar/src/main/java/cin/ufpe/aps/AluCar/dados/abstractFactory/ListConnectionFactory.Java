class ListConnectionFactory implements DatabaseConnectionFactory {
    // Concrete Factorie
    @Override
    public DatabaseConnection createConnection() {
        return new ListConnection();
    }
}
