package cin.ufpe.aps.AluCar.controllersMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cin.ufpe.aps.AluCar.Facade;
import cin.ufpe.aps.AluCar.models.Car;
import cin.ufpe.aps.AluCar.models.Cartao;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.SolicitacaoPagamento;
import java.util.List;


@RestController
@RequestMapping("/reserva")
//@CrossOrigin(origins = "${carro_url}")
public class TelaReservaControllerMVC {

    @Autowired
    private Facade facade;

    @GetMapping("/getCarros")
    public ResponseEntity<List<Car>> getCarros() {
        return facade.getCarros();
    }

    @PostMapping("/solicitaPagamento")
    public ResponseEntity<Boolean> solicitaPagamento(@RequestBody SolicitacaoPagamento pagamento) {
        Reserva reserva = pagamento.getReserva();
        Cartao cartao = pagamento.getCartao();
        return facade.solicitaPagamento(reserva, cartao);
    }

    @GetMapping("/getReservasMes")
    public ResponseEntity<List<Reserva>> getReservasMes() {
        return facade.getReservasMes();
    }

    @GetMapping("/getReservasSolicitadas/{dataInicio}/{dataTermino}")
    public ResponseEntity<List<Reserva>> getReservasSolicitadas(@PathVariable String dataInicio, @PathVariable String dataTermino) {
        return facade.getReservasSolicitadas(dataInicio, dataTermino);
    }
}