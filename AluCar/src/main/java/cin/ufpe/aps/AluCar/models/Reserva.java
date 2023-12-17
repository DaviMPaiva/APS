package cin.ufpe.aps.AluCar.models;

import java.sql.Date;

public class Reserva {

    // Atributos da Reserva
    private Float valor;
    private String carro;
    private Date dataInicio;
    private Date dataTermino;
    private Float taxa;
    private String usuario;

    // Construtor com todos os atributos
    public Reserva(Float valor, String carro, Date dataInicio, Date dataTermino, Float taxa, String usuario) {
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

    public String getCarro() {
        return this.carro;
    }

    public void setCarro(String carro) {
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

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}

