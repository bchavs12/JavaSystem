package CheckpointPOO.Classes;

public class Paciente {
    private String nome;
    private String endereco;
    private String telefone;
    private boolean cadastroAtivo;

    public Paciente(String nome, String endereco, String telefone, boolean cadastroAtivo) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cadastroAtivo = cadastroAtivo;
    }

    //getters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean isCadastroAtivo() {
        return cadastroAtivo;
    }

    //Setters
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCadastroAtivo(boolean cadastroAtivo) {
        this.cadastroAtivo = cadastroAtivo;
    }

    // methods
    public void atualizarEndereco(String novoEndereco) {
        setEndereco(novoEndereco);
    }
}
