package cin.ufpe.aps.AluCar.controllersMVC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import cin.ufpe.aps.AluCar.Facade;
import cin.ufpe.aps.AluCar.models.Car;

@RequestMapping("/historico")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TelaHistoricoControllerMVC {

    @Autowired
    private Facade facade;

    @GetMapping("/visualizarHistorico")
    public ResponseEntity<List<Car>> visualizarHistorico() {
        return facade.visualizarHistorico();
    }
}
