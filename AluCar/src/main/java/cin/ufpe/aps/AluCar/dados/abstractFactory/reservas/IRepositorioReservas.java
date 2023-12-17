package cin.ufpe.aps.AluCar.dados.abstractFactory.reservas;

import java.util.List;

import cin.ufpe.aps.AluCar.models.Reserva;

public interface IRepositorioReservas {
    List<Reserva> getReserva(String email);
    void setReserva(Reserva reserva);
}
