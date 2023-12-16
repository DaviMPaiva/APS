package cin.ufpe.aps.AluCar.models;

public class Locadora {

    // Atributos da Locadora
    private String nome;
    private String descricao;
    private String local;

    // Construtor padrão
    public Locadora() {
        // Pode ser vazio ou conter inicializações padrão, se necessário
    }

    // Construtor com todos os atributos
    public Locadora(String nome, String descricao, String local) {
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
    }

    // Método Getter para nome
    public String getNome() {
        return this.nome;
    }

    // Método Setter para nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método Getter para descricao
    public String getDescricao() {
        return this.descricao;
    }

    // Método Setter para descricao
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método Getter para local
    public String getLocal() {
        return this.local;
    }

    // Método Setter para local
    public void setLocal(String local) {
        this.local = local;
    }
}

        