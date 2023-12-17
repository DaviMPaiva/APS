package cin.ufpe.aps.AluCar.models;

public class Car {

    // Atributos do Cartão
    private String modelo;
    private String placa;
    private Float preco;
    private Integer ano;
    private String combustivel;
    private String transmissao;
    private String link_fotos;
    private Integer locadora;

    // Construtor com todos os atributos
    public Car(String modelo, String placa, Float preco, Integer ano, String combustivel, String transmissao, String link_fotos, Integer locadora) {
        this.modelo = modelo;
        this.placa = placa;
        this.preco = preco;
        this.ano = ano;
        this.combustivel = combustivel;
        this.transmissao = transmissao;
        this.link_fotos = link_fotos;
        this.locadora = locadora;
    }

    // Métodos Getter e Setter com encadeamento
    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Float getPreco() {
        return this.preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getAno() {
        return this.ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return this.combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getTransmissao() {
        return this.transmissao;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public String getLinkFotos() {
        return this.link_fotos;
    }

    public void setLinkFotos(String link_fotos) {
        this.link_fotos = link_fotos;
    }

    public Integer getLocadora() {
        return this.locadora;
    }

    public void setLocadora(Integer locadora) {
        this.locadora = locadora;
    }
}
