package CheckpointPOO.Classes;

public class Enfermeira extends Profissional {
    private boolean disponivel;

    public Enfermeira(String nome, Integer matricula, String especialidade, boolean disponivel) {
        super(nome, matricula, especialidade);
        this.disponivel = disponivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    //methods
    /*
     * Enfermeira realiza a consulta através da assistente admin que ao executar o metodo marcarConsulta, o atributo "disponivel" se torna false(Não disponivel), e ao terminar a consulta o atributo "Disponivel" se torna true através do metodo "marcarConsulta" e estara pronta para mais uma consulta.
     * */
    public void realizarConsulta(Paciente paciente, UnidadeBasicaSaude UBS) {
        this.disponivel = true;
        System.out.println("Enfermeira " + this.nome + " Realizando consulta com o paciente: " + paciente.getNome() + " na unidade de saude Basica: " + UBS.getNome());
    }

    // SobreEscrita
    @Override
    public void pagamento(double pagamento) {
        System.out.println("salario da Enfermeira " + this.getNome() + " é R$" + pagamento + " Sem descontos");
    }

    // SobreCarga
    public void pagamento(double pagamento, double desconto) {
        desconto = pagamento * 0.2;
        System.out.println("salario da Enfermeira " + this.getNome() + " é R$" + (pagamento - desconto) + " Incluindo descontos");
    }
}