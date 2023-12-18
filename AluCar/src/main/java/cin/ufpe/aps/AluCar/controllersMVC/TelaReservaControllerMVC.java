package cin.ufpe.aps.AluCar.controllersMVC;

import javax.mail.AuthenticationFailedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cin.ufpe.aps.AluCar.subsistemas.GoogleEmailService;
import cin.ufpe.aps.AluCar.Facade;
import cin.ufpe.aps.AluCar.models.Cartao;
import cin.ufpe.aps.AluCar.models.Reserva;


@RestController
@RequestMapping("/reserva")
public class TelaReservaControllerMVC {

    @Autowired
    private GoogleEmailService gmailService;
    @Autowired
    private Facade facade;

    /*
    @PostMapping("/testEmail")
    public ResponseEntity<String> adicionarCarro(@RequestBody String email) throws AuthenticationFailedException {
        try {
            gmailService.enviarEmail(email);
            return ResponseEntity.ok("E-mail enviado com sucesso!");
        } catch (Exception e) {
            // Tratamento genérico para outras exceções
            return ResponseEntity.badRequest().body("Erro ao enviar e-mail.");
        }
    }*/

    @PostMapping("/solicitaPagamento")
    public ResponseEntity<Boolean> solicitaPagamento(@RequestBody Reserva reserva, Cartao cartao) {
        return facade.solicitaPagamento(reserva, cartao);
    }
}