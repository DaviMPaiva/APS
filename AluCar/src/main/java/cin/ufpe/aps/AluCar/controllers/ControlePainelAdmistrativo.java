package cin.ufpe.aps.AluCar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cin.ufpe.aps.AluCar.Facade;
import cin.ufpe.aps.AluCar.dtos.CarDTO;

@RestController
@RequestMapping("/admin")
public class ControlePainelAdmistrativo {

    @Autowired
    private Facade facade;

    @PostMapping("/adicionarCarro")
    public ResponseEntity<String> adicionarCarro(@RequestBody CarDTO carDTO) {
        return facade.adicionarCarro(carDTO);
    }

    @GetMapping("/visualizarLocadoras")
    public ResponseEntity<List<CarDTO>> visualizarLocadoras() {
        return facade.visualizarLocadoras();
    }

    @PutMapping("/modificarLocadoras")
    public ResponseEntity<String> modificarLocadoras(@RequestBody CarModel carDTO) {
        return facade.modificarLocadoras(carDTO);
    }
}
