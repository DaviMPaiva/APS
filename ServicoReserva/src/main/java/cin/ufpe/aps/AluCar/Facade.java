package cin.ufpe.aps.AluCar;

import cin.ufpe.aps.AluCar.collection.*;
import cin.ufpe.aps.AluCar.controllers.ControleHistorico;
import cin.ufpe.aps.AluCar.controllers.ControleReserva;
import cin.ufpe.aps.AluCar.dados.abstractFactory.FabricaConcretaH2;
import cin.ufpe.aps.AluCar.dados.abstractFactory.FabricaConcretaSql;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import cin.ufpe.aps.AluCar.models.Car;
import cin.ufpe.aps.AluCar.models.Cartao;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;

import cin.ufpe.aps.AluCar.subsistemas.GoogleEmailService;

import java.util.List;

@Component
public class Facade {

    @Autowired
    private ControleHistorico controleHistorico;
    private Carros carros;
    private Reservas reservas;
    private ProxyReservaCarrosDisponiveis proxy;
    // private Usuario usuario;
    private Usuario usuarioH;
    private Usuario usuarioE;
	private ControleReserva controleReserva;
    private GoogleEmailService emailService;
    //private Reserva reservaProposta;
	//private Usuarios usuarios;

    //mock
	private Reserva reservaProposta;
    

    public Facade(){
      
        //FabricaConcretaSql fabrica = new FabricaConcretaSql();
        FabricaConcretaH2 fabrica = new FabricaConcretaH2();

        this.carros = new Carros(fabrica.CriaRepoCarros());
        this.reservas = new Reservas(fabrica.CriaRepoReservas());
        this.proxy = new ProxyReservaCarrosDisponiveis(fabrica.CriaRepoReservas());
        //this.usuarios = new Usuarios(fabrica.CriaRepoUsuario()); 

        this.controleHistorico = new ControleHistorico();
        this.controleReserva = new ControleReserva();
        this.emailService = new GoogleEmailService();

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

    public ResponseEntity<List<Reserva>> visualizarHistorico() {
        List<Reserva> x = controleHistorico.obterHistorico(reservas, usuarioH);
        System.out.println(x);
       
        return ResponseEntity.ok(x);
        
    }

    public ResponseEntity<List<Car>> getCarros() {
        List<Car> cars = this.controleReserva.getCarros(carros);
        return ResponseEntity.ok(cars);
    }

    public ResponseEntity<Boolean> solicitaPagamento(Reserva reserva, Cartao cartao) {
        // Cartao cartao = new Cartao("1111222233334444", "João da Silva", "12/25", "123");
        Boolean x = controleReserva.validaReserva(reserva, reservas, cartao, usuarioE, this.emailService);
        return ResponseEntity.ok(x);
    }

    public ResponseEntity<List<Reserva>> getReservasMes() {
        List<Reserva> x = this.controleReserva.getReservasMes(this.proxy);
        return ResponseEntity.ok(x);
    }

    public ResponseEntity<List<Reserva>> getReservasSolicitadas(String dataInicio, String dataTermino) {
        
        //cria a class o mais cedo possivel
        Date dataInicial = Date.valueOf(dataInicio);
        Date dataFinal = Date.valueOf(dataTermino);
        reservaProposta = new Reserva(null, null, dataInicial, dataFinal, null, null);

        List<Reserva> x = this.reservas.validaAnyReserva(reservaProposta);
        return ResponseEntity.ok(x);
    }
    
}
