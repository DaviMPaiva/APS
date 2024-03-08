package cin.ufpe.aps.AluCar.controllersMVC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import cin.ufpe.aps.AluCar.Facade;
import cin.ufpe.aps.AluCar.models.Reserva;

@RequestMapping("/historico")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class TelaHistoricoControllerMVC {

    @Autowired
    private Facade facade;

    @GetMapping("/visualizarHistorico")
    public ResponseEntity<List<Reserva>> visualizarHistorico() {
        return facade.visualizarHistorico();
    }
}