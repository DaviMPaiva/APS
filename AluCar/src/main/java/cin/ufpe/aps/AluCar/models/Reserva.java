package cin.ufpe.aps.AluCar.models;

public class Reserva {

    // Atributos da Reserva
    private Float valor;
    private Car carro;
    private Integer dataInicio;
    private Integer dataTermino;
    private Float taxa;
    private Usuario usuario;

    // Construtor com todos os atributos
    public Reserva(Float valor, Car carro, Integer dataInicio,
                   Integer dataTermino, Float taxa, Usuario usuario) {
        this.valor = valor;
        this.carro = carro;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.taxa = taxa;
        this.usuario = usuario;
    }

    // Métodos Getter e Setter intercalados
    public Float getValor() {
        return this.valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Car getCarro() {
        return this.carro;
    }

    public void setCarro(Car carro) {
        this.carro = carro;
    }

    public Integer getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Integer dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getDataTermino() {
        return this.dataTermino;
    }

    public void setDataTermino(Integer dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Float getTaxa() {
        return this.taxa;
    }

    public void setTaxa(Float taxa) {
        this.taxa = taxa;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

