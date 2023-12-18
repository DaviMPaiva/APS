package cin.ufpe.aps.AluCar;

import cin.ufpe.aps.AluCar.collection.*;
import cin.ufpe.aps.AluCar.controllers.ControleHistorico;
import cin.ufpe.aps.AluCar.controllers.ControleReserva;
import cin.ufpe.aps.AluCar.dados.abstractFactory.FabricaConcretaH2;
import cin.ufpe.aps.AluCar.dados.abstractFactory.FabricaConcretaSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAO;

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
    private Locadoras locadoras;
    private ControleHistorico controleHistorico;
    private Carros carros;
    private Reservas reservas;
    private Usuario usuario;
	private ControleReserva controleReserva;
    private Reserva reservaProposta;

    public Facade(){
      
        FabricaConcretaSql fabrica = new FabricaConcretaSql(); 
        //FabricaConcretaH2 fabrica = new FabricaConcretaH2();

        carros = new Carros(fabrica.CriaRepoCarros());
        
        

        //Reservas reservas = new Reservas(fabrica.CriaRepoReservas());
        //Locadoras locadoras = new Locadoras(fabrica.CriarRepoLocadoras());
        //Usuarios usuarios = new Usuarios(fabrica.CriaRepoUsuario()); 

        this.controleHistorico = new ControleHistorico();
        this.controleReserva = new ControleReserva();

        this.reservas = new Reservas(fabrica.CriaRepoReservas());
        Cartao cartao = new Cartao("1111222233334444", "João da Silva", "12/25", "123"); 
        this.usuario = new Usuario("Joao da Silva", "senha123", "joao@email.com", cartao);

        // Provided values
        String placa = "JKL3456";
        Date dataInicial = Date.valueOf("2023-03-20");
        Date dataFinal = Date.valueOf("2023-04-02");

        // Instantiate the Reserva class with provided values
        this.reservaProposta = new Reserva(null, placa, dataInicial, dataFinal, null, null);


        //visualizarHistorico();
    }


    public ResponseEntity<String> adicionarCarro(Car car) {
        locadoras.addCarro(car);
        return ResponseEntity.ok("Carro adicionado com sucesso!");
    }

    public ResponseEntity<List<Car>> visualizarLocadoras() {
        List<Car> cars = locadoras.getCarros();
        locadoras.visualizarLocadoras();
        return ResponseEntity.ok(cars);
    }

    public ResponseEntity<String> modificarLocadoras(Car car) {
        locadoras.modificacoesLocadoras();
        return ResponseEntity.ok("Locadora modificada com sucesso!");
    }

    public ResponseEntity<List<Reserva>> visualizarHistorico() {
        List<Reserva> x = controleHistorico.obterHistorico(reservas, usuario);
        System.out.println(x);
       
        return ResponseEntity.ok(x);
        
    }

    public ResponseEntity<List<Car>> pesquisarCarroPorModelo(String modelo) {
        List<Car> carro = carros.PesquisaCarrosModelo(modelo);
        System.out.println(carro);
       
        return ResponseEntity.ok(carro);
        
    }

    public ResponseEntity<Boolean> validaReserva() {
        Boolean x = controleReserva.validaReserva(reservas, reservaProposta);
        return ResponseEntity.ok(x);
    }

    public ResponseEntity<Boolean> solicitaPagamento(Cartao cartao) {
        Boolean x = controleReserva.realizaPagamento(reservaProposta, reservas, cartao, usuario);
        System.out.println("boleano: ===================================");
        System.out.println(x);
        System.out.println("=============================================");
        return ResponseEntity.ok(x);
    }
}
