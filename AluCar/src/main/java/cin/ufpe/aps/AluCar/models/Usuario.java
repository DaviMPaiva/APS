package cin.ufpe.aps.AluCar.models;

public class Usuario {
    // Atributos
    private String nome;
    private String email;
    private String senha;
    private Cartao cartao;
    private char sexo;

    // Construtor
    public Usuario(String nome, String senha, String email, Cartao cartao, char sexo) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cartao = cartao;
        this.sexo = sexo;
    }

    // Métodos Getters e Setters
    public char getSexo() {
        return this.sexo;
    }

    public void setSexo( char sexo) {
        this.sexo = sexo;
    }

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

    public Cartao getCartao() {
        return this.cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
