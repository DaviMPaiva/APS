package cin.ufpe.aps.AluCar.dados.carros;

import java.util.ArrayList;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;
import java.util.List;

import cin.ufpe.aps.AluCar.collection.Reservas;
import cin.ufpe.aps.AluCar.dados.DatabaseDAOH2;
import cin.ufpe.aps.AluCar.models.*;

public class RepositorioCarrosH2 implements IRepositorioCarros {
    private List<Car> listaCarros = new ArrayList<Car>();
    private List<Reserva> cache = new ArrayList<Reserva>();
    private String url = "http://localhost:8082";

    public RepositorioCarrosH2 (DatabaseDAOH2 databaseDAOH2){
        //this.databaseDAOH2 = databaseDAOH2;
        listaCarros = this.fillCarros();
        System.out.println(listaCarros);
        cache = this.fillCache();
        System.out.println(cache);

    }

    public List<Reserva> getCache() {
        return this.cache;
    }

    public List<Car> getAllCars() {
        return this.listaCarros;
    }

    public List<Car> fillCarros() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<Car>> response = restTemplate.exchange(
                url + "/reserva/getCarros",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Car>>() {});
            List<Car> carList = response.getBody();
            System.out.println(carList);
            return carList;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Reserva> fillCache() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<Reserva>> response = restTemplate.exchange(
                url + "/reserva/getReservasMes",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Reserva>>() {});
            List<Reserva> cache = response.getBody();
            System.out.println(cache);
            return cache;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Car getCarro(String placaRecebe) {
        Car car = null;
        
        if (this.listaCarros.isEmpty()) {
            this.fillCarros();
        }
        for (Car carro : this.listaCarros) {
            if (carro.getPlaca().equals(placaRecebe)) {
                car = carro;
            }
        }
        return car;
    }

    @Override
    public List<Car> getAllCarro() {
        
        if (this.listaCarros.isEmpty()) {
            this.fillCarros();
        }
        return this.listaCarros;
    }

    @Override
    public List<Car> getCarrosModelo(String modeloPesquisa) {
        List<Car> subListaCarros = new ArrayList<Car>();
              
        if (this.listaCarros.isEmpty()) {
            this.fillCarros();
        }
        for (Car carro : this.listaCarros) {
            if (carro.getModelo().equals(modeloPesquisa)) {
                subListaCarros.add(carro);
            }
        }

        return subListaCarros;
    }

    @Override
    public void setCarro(Car car) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");
    }
}
