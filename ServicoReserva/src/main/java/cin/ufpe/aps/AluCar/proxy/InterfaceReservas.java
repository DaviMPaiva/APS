package cin.ufpe.aps.AluCar.proxy;

import cin.ufpe.aps.AluCar.models.*;

import java.util.List;

public interface InterfaceReservas {
    
    // Retorna reservas do mês
    List<Reserva> getReservasMes();
    // Calcula taxas de atraso
    float calculaTaxasAtraso();

    // Registra pagamento
    void registraPagamento();

    // Registra taxas
    void registraTaxas();

    // Busca histórico
    List<Reserva> buscaHistorico(Usuario usuario);

    // Cria nova reserva
    void criaNovaReserva(Reserva reserva);

    List<Reserva> validaReserva(Reserva reserva);

    List<Reserva> validaAnyReserva(Reserva reserva);
}
