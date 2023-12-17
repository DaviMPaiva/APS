package cin.ufpe.aps.AluCar.proxy;

import cin.ufpe.aps.AluCar.models.*;

import java.sql.Date;

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
    void criaNovaReserva(Float valor, Car carro, Date dataInicio, Date dataTermino, Float taxa, Usuario usuario);

    // Pesquisa carros disponíveis e retorna um objeto Carro
    Car pesquisaCarrosDisponiveis();
}
