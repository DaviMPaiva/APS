package cin.ufpe.aps.AluCar.models;

public class Usuario {
    // Atributos
    private String nome;
    private String email;
    private String senha;
    private Integer cartao;

    // Construtor
    public Usuario(String nome, String senha, String email, Integer cartao) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cartao = cartao;
    }

    // Métodos Getters e Setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCartao() {
        return this.cartao;
    }

    public void setCartao(Integer cartao) {
        this.cartao = cartao;
    }
}
