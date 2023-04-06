package CheckpointPOO.Classes;

import java.util.ArrayList;
import java.util.List;

public class UnidadeBasicaSaude {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Enfermeira> enfermeiras = new ArrayList<>();
    private List<AssistenteAdmin> assistente = new ArrayList<>();

    public UnidadeBasicaSaude(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Enfermeira> getEnfermeiras() {
        return enfermeiras;
    }

    public List<AssistenteAdmin> getAssistente() {
        return assistente;
    }

    // methods
    public void adicionaPaciente(Paciente paciente) {
        // Criado para ser usado pela AssistenteAdmin registrar Pacientes no sistema
        this.pacientes.add(paciente);
        paciente.setCadastroAtivo(true);
    }

    public void adicionarEnfermeira(Enfermeira enfermeiras) {
        this.enfermeiras.add(enfermeiras);
    }

    public void adicionarAssistentes(AssistenteAdmin assistentes) {
        this.assistente.add(assistentes);
    }

    public void mostrarPacientes() {
        System.out.println("Lista de Pacientes: ");
        pacientes.forEach(paciente -> System.out.println(paciente.getNome()));
    }

    public void mostrarEnfermeiras() {
        System.out.println("Lista de Enfermeiras:");
        enfermeiras.forEach(enfermeira -> System.out.println(enfermeira.getNome()));
    }

    public void mostrarAssistentes() {
        System.out.println("Lista de Assistentes:");
        assistente.forEach(assistente -> System.out.println(assistente.getNome()));
    }

}