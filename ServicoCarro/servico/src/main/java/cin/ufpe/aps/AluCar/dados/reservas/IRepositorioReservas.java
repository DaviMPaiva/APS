package cin.ufpe.aps.AluCar.dados.reservas;

import java.sql.Date;
import java.util.List;

import cin.ufpe.aps.AluCar.models.Reserva;

public interface IRepositorioReservas {
    List<Reserva> getReserva(String email);
    void setReserva(Reserva reserva);
    List<Reserva> validaReserva(Reserva reserva);
    List<Reserva> validaAnyReserva(Reserva reserva);
    List<Reserva> GetReservaMes(Date dataAtual, Date dataProximoMes);
}
