package cin.ufpe.aps.AluCar.controllersMVC;

import javax.mail.AuthenticationFailedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cin.ufpe.aps.AluCar.subsistemas.GoogleEmailService;
import cin.ufpe.aps.AluCar.Facade;
import cin.ufpe.aps.AluCar.models.Car;
import cin.ufpe.aps.AluCar.models.Cartao;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.SolicitacaoPagamento;
import java.util.List;


@RestController
@RequestMapping("/reserva")
@CrossOrigin(origins = "http://localhost:8081")
public class TelaReservaControllerMVC {

    @Autowired
    private GoogleEmailService gmailService;
    @Autowired
    private Facade facade;

    @GetMapping("/getCarroPorPlaca/{placa}")
    public ResponseEntity<Car> getCarroPorPlaca(@PathVariable String placa) {
        return facade.getCarroPorPlaca(placa);
    }

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