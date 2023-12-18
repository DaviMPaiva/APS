package cin.ufpe.aps.AluCar.controllersMVC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import cin.ufpe.aps.AluCar.Facade;
import cin.ufpe.aps.AluCar.Iterator.CarList;
import cin.ufpe.aps.AluCar.models.Car;

@RequestMapping("/pesquisar")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TelaPesquisaControllerMVC {

    @Autowired
    private Facade facade;

    @GetMapping("/pesquisarModelo/{modelo}")
    public ResponseEntity<List<Car>> pesquisarCarroPorModelo(@PathVariable String modelo) {
        return facade.pesquisarCarroPorModelo(modelo);
    }

    @GetMapping("/pesquisaCarrosDisponiveis/{dataInicio}/{dataTermino}")
    public ResponseEntity<CarList> pesquisaCarrosDisponiveis(@PathVariable String dataInicio, @PathVariable String dataTermino) {
        return facade.pesquisaCarrosDisponiveis(dataInicio, dataTermino);
    }
}