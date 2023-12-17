package cin.ufpe.aps.AluCar.dados.abstractFactory.reservas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAO;
import cin.ufpe.aps.AluCar.models.Reserva;

public class RepositorioReservasSql implements IRepositorioReservas{

    private DatabaseDAO databaseDAO;
    
    public RepositorioReservasSql(DatabaseDAO databaseDAO){
        this.databaseDAO = databaseDAO;
    }
    @Override
    public List<Reserva> getReserva(String email) {
        List<Reserva> listaReserva = new ArrayList<Reserva>();
        Reserva reserva = null;
        String sql = "SELECT * FROM \"reserva\" WHERE usuario = '" + email + "'";
        System.out.println(sql);
        
        try (ResultSet result = this.databaseDAO.executeQuery(sql)) {
    
            // Check if the result set has a row
            while (result.next()) {
                // Retrieve values from the result set
                String placa = result.getString("placa");
                Float valor = result.getFloat("valor");
                Integer taxa = result.getInt("taxa");
                Date dataInicio = result.getDate("dataInicio");
                Date dataTermino = result.getDate("dataTermino");
                String usuario = result.getString("usuario");

                // Create a Reserva object using the retrieved values
                reserva = new Reserva(valor, placa, dataInicio, dataTermino, taxa, usuario);
                listaReserva.add(reserva);

            }

            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return listaReserva;
    }

    @Override
    public void setReserva(Reserva reserva) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setReserva'");
    }
    
}
