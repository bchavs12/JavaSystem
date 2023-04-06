package CheckpointPOO.Classes;

public abstract class Profissional {
    protected String nome;
    protected Integer matricula;
    protected String especialidade;

    public Profissional(String nome, Integer matricula, String especialidade) {
        this.nome = nome;
        this.matricula = matricula;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public abstract void pagamento(double pagamento);

}
