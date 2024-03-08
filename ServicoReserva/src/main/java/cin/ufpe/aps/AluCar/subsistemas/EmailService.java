package cin.ufpe.aps.AluCar.subsistemas;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void enviarEmail(String destinatario);
}
