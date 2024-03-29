package cin.ufpe.aps.AluCar.collection;

import cin.ufpe.aps.AluCar.proxy.*;
import cin.ufpe.aps.AluCar.utils.PropertiesReader;
import cin.ufpe.aps.AluCar.Iterator.CarList;
import cin.ufpe.aps.AluCar.models.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProxyReservaCarrosDisponiveis implements InterfaceReservas {

    private List<Reserva> cache_reservas;
    private Reservas reservas;
    //private Date currentDate;
    private Date futureDate;
    private Date yesterday;

    public ProxyReservaCarrosDisponiveis(Reservas reservas){
        this.reservas = reservas;
        this.MakeCache();
    }

    public void MakeCache(){
        // Get the current date
        LocalDate currentDateL = LocalDate.now();

        // Get the date 30 days from now
        LocalDate futureDateL = currentDateL.plusDays(31);

        // Get the date from yesterday
        LocalDate yesterdayL = currentDateL.minusDays(1);

        // Define the desired date format
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Convert dates to strings in the specified format
        //this.currentDate = Date.valueOf(dateFormat.format(currentDateL));
        this.futureDate = Date.valueOf(dateFormat.format(futureDateL));
        this.yesterday = Date.valueOf(dateFormat.format(yesterdayL));

    }
    
    @Override
    public CarList pesquisaCarrosDisponiveis(Reserva reserva, Carros cars, PropertiesReader propertiesReader) {
        if( reserva.getDataInicio().after(this.yesterday) && reserva.getDataInicio().before(this.futureDate)){
            //pega todas as reservas para aquela data
            List<Reserva> listaReserva = new ArrayList<Reserva>();
            System.out.println("Erro depois da cache");
            this.cache_reservas = cars.getCache();
            System.out.println("Entrou na cache");

            for (Reserva res : this.cache_reservas) {
                System.out.println(res.getCarro());
                
                if ((res.getDataInicio().after(Date.valueOf(reserva.getDataInicio().toLocalDate().minusDays(1))) && res.getDataInicio().before(Date.valueOf(reserva.getDataTermino().toLocalDate().plusDays(1))))
                    || (res.getDataTermino().after(Date.valueOf(reserva.getDataInicio().toLocalDate().minusDays(1))) && res.getDataTermino().before(Date.valueOf(reserva.getDataTermino().toLocalDate().plusDays(1))))
                    || (res.getDataInicio().before(Date.valueOf(reserva.getDataInicio().toLocalDate().plusDays(1))) && res.getDataTermino().after(Date.valueOf(reserva.getDataTermino().toLocalDate().minusDays(1))))){
                        listaReserva.add(res);
                    }
            }
            
            //pega todos os carros nessas reservas
            Set<String> carroSet = new HashSet<>();

            //pega os carros sem repeticao
            for (Reserva res : listaReserva) {
                carroSet.add(res.getCarro());
            }

            //passa os carros e o usario para a classe de carros fazer um interator
            CarList carros = cars.pesquisaCarrosDisponiveis(carroSet);

            return carros;
        }else{
            System.out.println("Não entrou na cache");
            return reservas.pesquisaCarrosDisponiveis(reserva, cars, propertiesReader);
        }
    }
}