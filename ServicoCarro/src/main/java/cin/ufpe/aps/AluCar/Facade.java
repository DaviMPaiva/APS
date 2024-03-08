package cin.ufpe.aps.AluCar;

import cin.ufpe.aps.AluCar.Iterator.CarList;
import cin.ufpe.aps.AluCar.collection.*;
import cin.ufpe.aps.AluCar.controllers.ControlePesquisa;
import cin.ufpe.aps.AluCar.dados.FabricaConcretaH2;
import cin.ufpe.aps.AluCar.dados.FabricaConcretaSql;
import cin.ufpe.aps.AluCar.dados.DatabaseDAO;

import java.sql.Date;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import cin.ufpe.aps.AluCar.models.Car;
import cin.ufpe.aps.AluCar.models.Cartao;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;

import java.util.List;

@Component
public class Facade {

    @Autowired
    private ControlePesquisa controlePesquisa;
    private Carros carros;
    private Reservas reservas;
    private ProxyReservaCarrosDisponiveis proxy;
    // private Usuario usuario;
    private Usuario usuarioH;
    private Usuario usuarioE;
    //private Reserva reservaProposta;
	private Usuario usuarios;

    //mock
	private Reserva reservaProposta;
    

    public Facade(){
      
        //FabricaConcretaSql fabrica = new FabricaConcretaSql();
        FabricaConcretaH2 fabrica = new FabricaConcretaH2();

        this.carros = new Carros(fabrica.CriaRepoCarros());
        this.reservas = new Reservas(fabrica.CriaRepoReservas());
        this.proxy = new ProxyReservaCarrosDisponiveis(fabrica.CriaRepoReservas(), reservas);
        
        this.controlePesquisa = new ControlePesquisa();

        //mocks
        Cartao cartao = new Cartao("1111222233334444", "João da Silva", "12/25", "123"); 
        this.usuarioE = new Usuario("Gustao", "senha123", "gcc2@cin.ufpe.br", cartao, 'f');
        this.usuarioH = new Usuario("Gustao", "senha123", "joao@email.com", cartao, 'm');

        // String placa = "JKL3456";
        // Date dataInicial = Date.valueOf("2023-03-26");
        // Date dataFinal = Date.valueOf("2023-03-29");

        // Instantiate the Reserva class with provided values
        // this.reservaProposta = new Reserva(null, placa, dataInicial, dataFinal, null, "joao@email.com");


        //visualizarHistorico();
    }

    public ResponseEntity<List<Car>> pesquisarCarroPorModelo(String modelo) {
        List<Car> carro = controlePesquisa.pesquisaModelo(carros, modelo);
        System.out.println(carro);
       
        return ResponseEntity.ok(carro);
        
    }

    public ResponseEntity<List<Car>> pesquisarCarroPorDisponibilidade(String dataInicio, String dataTermino) {
        List<Car> carro = carros.PesquisaCarrosModelo(dataInicio);
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
}
