package cin.ufpe.aps.AluCar;

import cin.ufpe.aps.AluCar.collection.Locadoras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Facade {

    @Autowired
    private Locadoras locadoras;

    public ResponseEntity<String> adicionarCarro(CarDTO carDTO) {
        locadoras.addCarro(carDTO);
        return ResponseEntity.ok("Carro adicionado com sucesso!");
    }

    public ResponseEntity<List<CarDTO>> visualizarLocadoras() {
        List<CarDTO> cars = locadoras.getCarros();
        locadoras.visualizarLocadoras();
        return ResponseEntity.ok(cars);
    }

    public ResponseEntity<String> modificarLocadoras(CarDTO carDTO) {
        locadoras.modificacoesLocadoras();
        return ResponseEntity.ok("Locadora modificada com sucesso!");
    }
}
