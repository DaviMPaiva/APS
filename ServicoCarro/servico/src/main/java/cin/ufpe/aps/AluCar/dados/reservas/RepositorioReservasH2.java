package cin.ufpe.aps.AluCar.dados.reservas;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cin.ufpe.aps.AluCar.dados.DatabaseDAOH2;
import cin.ufpe.aps.AluCar.models.Reserva;

public class RepositorioReservasH2 implements IRepositorioReservas{

    private DatabaseDAOH2 databaseDAOH2;
    private List<Reserva> cacheReserva = new ArrayList<Reserva>();
    private String url = "http://localhost:8082";
    
    public RepositorioReservasH2(DatabaseDAOH2 databaseDAOH2){
        this.databaseDAOH2 = databaseDAOH2;
    }

    @Override
    public List<Reserva> getReserva(String email) {
        List<Reserva> listaReserva = new ArrayList<Reserva>();
        Reserva reserva = null;
        String sql = "SELECT * FROM reserva WHERE usuario = '" + email + "'";
        System.out.println(sql);
        
        try (ResultSet result = this.databaseDAOH2.executeQuery(sql)) {
    
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
    public List<Reserva> validaReserva(Reserva reserva) {
        List<Reserva> listaReserva = new ArrayList<Reserva>();
        Reserva reservaBuffer = null;
        
        String sql = "SELECT * FROM reserva WHERE placa = '" + reserva.getCarro() + 
                                "' AND dataInicio < '" + reserva.getDataInicio() +
                                "' AND dataTermino > '"+ reserva.getDataTermino() +"'";
        
        try (ResultSet result = this.databaseDAOH2.executeQuery(sql)) {
    
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
                reservaBuffer = new Reserva(valor, placa, dataInicio, dataTermino, taxa, usuario);
                listaReserva.add(reservaBuffer);

            }         

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return listaReserva;
    }

    @Override
    public List<Reserva> validaAnyReserva(Reserva reserva) {
        List<Reserva> listaReserva = new ArrayList<Reserva>();
        Reserva reservaBuffer = null;

        String sql = "SELECT * FROM reserva WHERE (datainicio < '" + reserva.getDataInicio() + "' AND datatermino > '" + reserva.getDataTermino() + "') " +
             "OR (datainicio > '" + reserva.getDataInicio() + "' AND datainicio < '" + reserva.getDataTermino() + "') " +
             "OR (datatermino > '" + reserva.getDataInicio() + "' AND datatermino < '" + reserva.getDataTermino() + "')";

        
        try (ResultSet result = this.databaseDAOH2.executeQuery(sql)) {
    
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
                reservaBuffer = new Reserva(valor, placa, dataInicio, dataTermino, taxa, usuario);
                listaReserva.add(reservaBuffer);

            }         

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return listaReserva;
    }

    @Override
    public void setReserva(Reserva reserva) {
        String sql = "INSERT INTO reserva (placa, valor, taxa, dataInicio, dataTermino, usuario) VALUES (" + 
            "'" + reserva.getCarro() + "'"       +","+
            reserva.getValor()       +","+ 
            reserva.getTaxa()        +","+
            "'" + reserva.getDataInicio() + "'"  +","+
            "'" + reserva.getDataTermino() + "'" +","+
            "'" + reserva.getUsuario() + "'"     +");";

        System.out.println(sql);

        try (ResultSet result = this.databaseDAOH2.executeQuery(sql)) {
            System.out.println("nice");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Reserva> GetReservaMes(Date dataAtual, Date dataProximoMes){ 
        if (cacheReserva.isEmpty()) {
            fillCache(dataAtual, dataProximoMes);
        }
        return cacheReserva;
    }

    public void fillCache(Date dataAtual, Date dataProximoMes) {
        List<Reserva> listaReserva = new ArrayList<Reserva>();

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<Reserva>> response = restTemplate.exchange(
                url + "/reserva/getCarros",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Reserva>>() {});
            listaReserva = response.getBody();
            System.out.println(listaReserva);
            cacheReserva =  listaReserva;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
}
