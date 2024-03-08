package cin.ufpe.aps.AluCar.proxy;

import cin.ufpe.aps.AluCar.Iterator.CarList;
import cin.ufpe.aps.AluCar.collection.Carros;
import cin.ufpe.aps.AluCar.models.*;

import java.sql.Date;
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

    // Pesquisa carros disponíveis e retorna um objeto Carro
    CarList pesquisaCarrosDisponiveis(Reserva reserva, Carros cars);

    List<Reserva> validaReserva(Reserva reserva);
}
