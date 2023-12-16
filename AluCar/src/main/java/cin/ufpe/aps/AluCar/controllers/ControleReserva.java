package cin.ufpe.aps.AluCar.controllers;

import javax.mail.AuthenticationFailedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cin.ufpe.aps.AluCar.subsistemas.GoogleEmailService;



@RestController
@RequestMapping("/reserva")
public class ControleReserva {

    @Autowired
    private GoogleEmailService gmailService;

    @PostMapping("/confirmarReserva")
    public ResponseEntity<String> adicionarCarro(@RequestBody String email) throws AuthenticationFailedException {
        try {
            gmailService.enviarEmail(email);
            return ResponseEntity.ok("E-mail enviado com sucesso!");
        } catch (Exception e) {
            // Tratamento genérico para outras exceções
            return ResponseEntity.badRequest().body("Erro ao enviar e-mail.");
        }
    }
}