package cin.ufpe.aps.AluCar.models;

import java.sql.Date;

public class Reserva {

    // Atributos da Reserva
    private Integer id;
    private Float valor;
    private Car carro;
    private Date dataInicio;
    private Date dataTermino;
    private Float taxa;
    private Usuario usuario;

    // Construtor com todos os atributos
    public Reserva(Integer id, Float valor, Car carro, Date dataInicio, Date dataTermino, Float taxa, Usuario usuario) {
        this.id = id;
        this.valor = valor;
        this.carro = carro;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.taxa = taxa;
        this.usuario = usuario;
    }

    // Métodos Getter e Setter intercalados

    public Integer getID() {
        return this.id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

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

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return this.dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
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

