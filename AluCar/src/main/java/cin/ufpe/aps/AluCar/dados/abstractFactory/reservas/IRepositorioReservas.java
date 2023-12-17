package cin.ufpe.aps.AluCar.dados.abstractFactory.reservas;

import cin.ufpe.aps.AluCar.models.Reserva;

public interface IRepositorioReservas {
    Reserva getReserva();
    void setReserva(Reserva reserva);
}
