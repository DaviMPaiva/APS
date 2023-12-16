package cin.ufpe.aps.AluCar.models;

public class Cartao {
    // Atributos do Cartão
    private String numero;
    private String titular;
    private String dataValidade;

    // Construtor do Cartão
    public Cartao(String numero, String titular, String dataValidade) {
        this.numero = numero;
        this.titular = titular;
        this.dataValidade = dataValidade;
    }

    // Métodos Getters e Setters do Cartão
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
}
