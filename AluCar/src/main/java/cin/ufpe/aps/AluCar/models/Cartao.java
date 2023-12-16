package cin.ufpe.aps.AluCar.models;

public class Cartao {
    // Atributos do Cartão
    private String numero;
    private String titular;
    private String dataValidade;
    private Integer cvc;

    // Construtor do Cartão
    public Cartao(String numero, String titular, String dataValidade, Integer cvc) {
        this.numero = numero;
        this.titular = titular;
        this.dataValidade = dataValidade;
        this.cvc = cvc;
    }

    // Métodos Getters e Setters do Cartão
    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getDataValidade() {
        return this.dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Integer getCvc() {
        return this.cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }
}
