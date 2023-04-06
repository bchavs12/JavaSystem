package CheckpointPOO;

import CheckpointPOO.Classes.AssistenteAdmin;
import CheckpointPOO.Classes.Enfermeira;
import CheckpointPOO.Classes.Paciente;
import CheckpointPOO.Classes.UnidadeBasicaSaude;
import CheckpointPOO.Exceptions.CadastrosException;
import CheckpointPOO.Exceptions.TelefoneInvalidoExeception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CadastrosException, TelefoneInvalidoExeception {
        Scanner scanner = new Scanner(System.in);

        // Instancia da Unidade Basica de Saude
        UnidadeBasicaSaude UBS_Centro = new UnidadeBasicaSaude("UBS_Centro", "Centro", "51-99827954");

        // Instância das enfermeiras
        Enfermeira enfermeira_Senior = new Enfermeira("regina teves", 123457896, "Medicina", true);
        Enfermeira enfermeira_Pleno = new Enfermeira("Medi sina ", 99361746, "Enfermagen", true);

        // Instância da AssistenteAdmin
        AssistenteAdmin assistenteAdmin = new AssistenteAdmin("Yasmin yara", 87654321, "Recursos Humanos");

        // Funcionamento do sistema
        UBS_Centro.adicionarEnfermeira(enfermeira_Senior);
        UBS_Centro.adicionarAssistentes(assistenteAdmin);

        // Cadastro de pacientes
        /*
         * Primeiro while é responsável pelo registro de pacientes. Ele é o loop principal do programa, onde o usuário é solicitado a inserir os dados do paciente (nome, endereço e telefone) e o registro é feito através do método cadastraPaciente() da classe AssistenteAdmin. Esse loop só termina quando o usuário digita "q" como nome do paciente, indicando que não há mais pacientes a serem cadastrados.
         * */
        while (true) {
            System.out.println("Digite o nome do Paciente (ou 'q' para sair): ");
            String nome = scanner.nextLine();

            if (nome.equals("q")) {
                break;
            }

            // Pegar endereço do paciente
            System.out.println("Digite o endereço do paciente (ou 'q' para sair): ");
            String endereco = scanner.nextLine();

            if (endereco.equals("q")) {
                break;
            }

            String telefone;
            while (true) {
                System.out.println("Digite o número de telefone do paciente (11 dígitos):");
                telefone = scanner.nextLine();

                // A expressão regular "\\d{11}" é usada para verificar se o valor digitado pelo usuário contém 11 dígitos. O \\d indica que qualquer dígito de 0 a 9 pode estar presente, e o {11} significa que a sequência deve ter exatamente 11 dígitos.
                if (telefone.matches("\\d{11}")) {
                    break;
                } else {
                    System.err.println("Número de telefone inválido. Por favor, digite um número com 11 dígitos.");
                }
                ;
            }
            try {
                Paciente paciente = new Paciente(nome, endereco, telefone, false);
                assistenteAdmin.cadastraPaciente(paciente, UBS_Centro);
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Tente novamente.");
                e.printStackTrace();
            } catch (CadastrosException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }

        // assistenteAdmin.marcarConsulta(enfermeira_Senior,paciente1,UBS_Centro);

        // TESTANDO HERANÇA E POLIMORFISMO
//        assistenteAdmin.pagamento(2.375);
//        assistenteAdmin.pagamento(2.375,500);
//
//        enfermeira_Senior.pagamento(4000);
//        enfermeira_Senior.pagamento(4000, 500);

        // Mostra quantos pacientes, Enfermeiras, e assistentes tem em cada UBS
        // UBS_Centro.mostrarPacientes();
        // UBS_Centro.mostrarEnfermeiras();
        // UBS_Centro.mostrarAssistentes();
    }
}
