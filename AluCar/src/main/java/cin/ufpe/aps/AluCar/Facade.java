package cin.ufpe.aps.AluCar;

import cin.ufpe.aps.AluCar.collection.Carros;
import cin.ufpe.aps.AluCar.collection.Locadoras;
import cin.ufpe.aps.AluCar.collection.Reservas;
import cin.ufpe.aps.AluCar.collection.Usuarios;
import cin.ufpe.aps.AluCar.controllers.ControleHistorico;
import cin.ufpe.aps.AluCar.dados.abstractFactory.FabricaConcretaSQl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import cin.ufpe.aps.AluCar.models.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Facade {

    @Autowired
    private Locadoras locadoras;
    private ControleHistorico controleHistorico;

    public Facade(){
        FabricaConcretaSQl fabrica = new FabricaConcretaSQl();

        Carros carros = new Carros(fabrica.CriaRepoCarros());
        Reservas reservas = new Reservas(fabrica.CriaRepoReservas());
        Locadoras locadoras = new Locadoras(fabrica.CriarRepoLocadoras());
        Usuarios usuarios = new Usuarios(fabrica.CriaRepoUsuario()); 



        this.controleHistorico = new ControleHistorico();


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

    public ResponseEntity<List<Car>> visualizarHistorico() {
        return ResponseEntity.ok(controleHistorico.obterHistorico());
    }
}
