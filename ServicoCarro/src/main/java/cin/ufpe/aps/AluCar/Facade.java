package cin.ufpe.aps.AluCar;

import cin.ufpe.aps.AluCar.collection.*;
import cin.ufpe.aps.AluCar.controllers.ControlePesquisa;
import cin.ufpe.aps.AluCar.dados.FabricaConcreta;

import java.sql.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import cin.ufpe.aps.AluCar.models.Car;
import cin.ufpe.aps.AluCar.models.Cartao;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;

import java.util.List;

@Component
public class Facade {

    private ControlePesquisa controlePesquisa;
    private Carros carros;
    private Reservas reservas;
    private ProxyReservaCarrosDisponiveis proxy;
    private Usuario usuarioH;
    //private Usuario usuarioE;
    //private Reserva reservaProposta;

    //mock
	private Reserva reservaProposta;
    

    public Facade(){
      
        FabricaConcreta fabrica = new FabricaConcreta();

        this.carros = new Carros(fabrica.CriaRepoCarros());
        this.reservas = new Reservas();
        this.proxy = new ProxyReservaCarrosDisponiveis(this.reservas);
        
        this.controlePesquisa = new ControlePesquisa();

        //mocks
        Cartao cartao = new Cartao("1111222233334444", "João da Silva", "12/25", "123"); 
        //this.usuarioE = new Usuario("Gustao", "senha123", "gcc2@cin.ufpe.br", cartao, 'f');
        this.usuarioH = new Usuario("Gustao", "senha123", "joao@email.com", cartao, 'm');

        
    }

    public ResponseEntity<List<Car>> pesquisarCarroPorModelo(String modelo) {
        List<Car> carro = controlePesquisa.pesquisaModelo(carros, modelo);
        System.out.println(carro);
       
        return ResponseEntity.ok(carro);
        
    }
    
    public ResponseEntity<List<Car>> pesquisaCarrosDisponiveis(String dataInicio, String dataTermino) {
        
        //cria a class o mais cedo possivel
        Date dataInicial = Date.valueOf(dataInicio);
        Date dataFinal = Date.valueOf(dataTermino);
        reservaProposta = new Reserva(null, null, dataInicial, dataFinal, null, null);

        List<Car> x = this.controlePesquisa.pesquisaCarrosDisponiveis(this.proxy, reservaProposta, carros, this.usuarioH);
        return ResponseEntity.ok(x);
    }

    public ResponseEntity<Car> getCarroPorPlaca(String placa) {
        Car carro = this.controlePesquisa.getCarroPorPlaca(carros, placa);
        System.out.println(carro);
       
        return ResponseEntity.ok(carro);
    }
}
