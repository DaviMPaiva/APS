package cin.ufpe.aps.AluCar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cin.ufpe.aps.AluCar.Facade;
import cin.ufpe.aps.AluCar.models.Car;

@RestController
@RequestMapping("/admin")
public class ControlePainelAdmistrativo {

    @Autowired
    private Facade facade;

    @PostMapping("/adicionarCarro")
    public ResponseEntity<String> adicionarCarro(@RequestBody Car car) {
        return facade.adicionarCarro(car);
    }

    @GetMapping("/visualizarLocadoras")
    public ResponseEntity<List<Car>> visualizarLocadoras() {
        return facade.visualizarLocadoras();
    }

    @PutMapping("/modificarLocadoras")
    public ResponseEntity<String> modificarLocadoras(@RequestBody Car car) {
        return facade.modificarLocadoras(car);
    }
}
