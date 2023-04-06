package CheckpointPOO.Classes;

import CheckpointPOO.Exceptions.CadastrosException;

public class AssistenteAdmin extends Profissional {

    public AssistenteAdmin(String nome, Integer matricula, String especialidade) {
        super(nome, matricula, especialidade);
    }

    // methods
    /*
     * Metodo cadastraPaciente cadastra o paciente na unidade e ja registra no sistema da propria unidade atraves da AsistenteAdministrativa
     * e caso a Enfermeira ou paciente não constar no sistema da unidade não realiza a consulta
     * */
    public void cadastraPaciente(Paciente paciente, UnidadeBasicaSaude UBS) throws CadastrosException {
        if (UBS.getPacientes().contains(paciente)) {
            throw new CadastrosException("O paciente " + paciente.getNome() + " Já está cadastrado na UBS " + UBS.getNome() + ".");
        }
        UBS.adicionaPaciente(paciente);
        System.out.println("Paciente: " + paciente.getNome() + " cadastrado, e registrado com sucesso na unidade: " + UBS.getNome());
    }

    public void marcarConsulta(Enfermeira enfermeira, Paciente paciente, UnidadeBasicaSaude UBS) {
        if (paciente.isCadastroAtivo() && enfermeira.isDisponivel() && UBS.getPacientes().contains(paciente) && UBS.getEnfermeiras().contains(enfermeira)) {
            enfermeira.realizarConsulta(paciente, UBS);
            enfermeira.setDisponivel(false);
        } else if (!UBS.getPacientes().contains(paciente)) {
            System.out.println("Paciente não encontrado na unidade: " + UBS.getNome() + ".");
        } else if (!UBS.getEnfermeiras().contains(enfermeira)) {
            System.out.println("Enfermeira não encontrado na unidade: " + UBS.getNome() + ".");
        } else {
            System.out.println("Não temos consultas agendadas no momento");
        }
    }

    public void atualizarEndereco(Paciente paciente, String novoEndereco) {
        if (paciente.isCadastroAtivo()) {
            paciente.atualizarEndereco(novoEndereco);
            System.out.println("Endereço do paciente: " + paciente.getNome() + " Atualizado para " + novoEndereco + ".");
        } else {
            System.out.println("Paciente " + paciente.getNome() + " Não cadastrado no sistema para atualização de endereço.");
        }
    }

    public void inativarCadastro(Paciente paciente) {
        if (paciente.isCadastroAtivo()) {
            paciente.setCadastroAtivo(false);
            System.out.println("Cadastro do paciente: " + paciente.getNome() + " Inativado com sucesso");
        } else {
            System.out.println("Paciente: " + paciente.getNome() + " Não encontrado.");
        }
    }


    @Override
    public void pagamento(double pagamento) {
        System.out.println("salario da assistente " + this.getNome() + " é R$" + pagamento + " Sem descontos");
    }

    //SobreCarga
    public void pagamento(double pagamento, double desconto) {
        desconto = pagamento * 0.2;
        System.out.println("salario da assistente " + this.getNome() + " é R$" + (pagamento - desconto) + " Incluindo descontos");
    }
}