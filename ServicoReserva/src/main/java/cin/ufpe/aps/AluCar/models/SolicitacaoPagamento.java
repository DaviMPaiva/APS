package cin.ufpe.aps.AluCar.models;

public class SolicitacaoPagamento {
    private Reserva reserva;
    private Cartao cartao;

    public SolicitacaoPagamento(Reserva reserva, Cartao cartao) {
        this.reserva = reserva;
        this.cartao = cartao;
    }

    public Reserva getReserva() {
        return this.reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Cartao getCartao() {
        return this.cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
