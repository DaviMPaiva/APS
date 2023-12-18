package cin.ufpe.aps.AluCar.proxy;

import cin.ufpe.aps.AluCar.models.*;

import java.sql.Date;
import java.util.List;

public interface InterfaceReservas {

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

    // Pesquisa carros disponíveis e retorna um objeto Carro
    Car pesquisaCarrosDisponiveis();

    boolean validaReserva(Reserva reserva);
}
