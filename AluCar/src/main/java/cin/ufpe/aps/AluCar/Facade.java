package cin.ufpe.aps.AluCar;

import cin.ufpe.aps.AluCar.collection.*;
import cin.ufpe.aps.AluCar.controllers.ControleHistorico;
import cin.ufpe.aps.AluCar.dados.abstractFactory.FabricaConcretaH2;
import cin.ufpe.aps.AluCar.dados.abstractFactory.FabricaConcretaSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAO;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import cin.ufpe.aps.AluCar.models.Car;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;

import java.util.List;

@Component
public class Facade {

    @Autowired
    private Locadoras locadoras;
    private ControleHistorico controleHistorico;
    private Reservas reservas;
    private Usuario usuario;

    public Facade(){
      
        FabricaConcretaSql fabrica = new FabricaConcretaSql(); 
        //FabricaConcretaH2 fabrica = new FabricaConcretaH2();

        Carros carros = new Carros(fabrica.CriaRepoCarros());
        Car carro = carros.PesquisaCarrosDisponiveis();
        System.out.println(carro);
        

        //Reservas reservas = new Reservas(fabrica.CriaRepoReservas());
        //Locadoras locadoras = new Locadoras(fabrica.CriarRepoLocadoras());
        //Usuarios usuarios = new Usuarios(fabrica.CriaRepoUsuario()); 

        this.controleHistorico = new ControleHistorico();

        this.reservas = new Reservas(fabrica.CriaRepoReservas()); 
        this.usuario = new Usuario("joao@email.com", "João da Silva", "joao@email.com", 1);
        visualizarHistorico();
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
        for (int i = 0; i < 20; i++){
             System.out.println("Carvalheira na Ladeira");
        }
       
        return ResponseEntity.ok(x);
        
    }
}
