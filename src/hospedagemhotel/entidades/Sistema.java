package hospedagemhotel.entidades;

import java.util.Scanner;

import hospedagemhotel.bd.Conexao;

// TODO Voltar o tipo dataNascimento de date para string caso a instanciação com date não der certo

public class Sistema {


	Scanner scanner = new Scanner(System.in);

	public void cadastrarHospede() {
		System.out.println("Digite os dados do hospede:\n");

		System.out.println("Nome completo: ");
		String nome = scanner.nextLine();

		System.out.println("CPF: ");
		String cpf = scanner.nextLine();

		System.out.println("Telefone: ");
		String telefone = scanner.nextLine();

		//Método para obter data de nascimento
		System.out.println("Informe a data de nascimento: ");
		Date dataNascimento = new Date();

		dataNascimento.setData();

		System.out.println("Sexo: ");
		String sexo = scanner.nextLine();

		System.out.println("Cóigo da conta:");
		int codigoConta = scanner.nextInt();

		Hospede hospede = new Hospede(nome, cpf, telefone, dataNascimento, sexo, codigoConta);

		Conexao.alterarBD("INSERT INTO hospede VALUES(" + hospede.getCpf() + ", " + hospede.getDataNasc()+ ", " +hospede.getSexo()+", "+hospede.getCodigoConta()+")");
	}

	public Reserva confirmarReserva(int idReserva, String cpf, Date dataInicial, Date dataFinal, Quarto quarto, Funcionario funcionario) {
        
		Hospede hospede = Conexao.buscarHospede(cpf);
        Quarto quartoEscolhido = Conexao.buscarQuarto(quarto.getCodigoQuarto());

        Reserva reserva = new Reserva(idReserva, hospede, funcionario, quartoEscolhido, dataInicial, dataFinal);
        // reserva.setDataInicial(dataInicial);
        // reserva.setDataFinal(dataFinal);
        // reserva.setQuarto(quarto);
        // reserva.setHospede(hospede);
        // reserva.setFuncionario(funcionario);

        System.out.print("Reserva efetuada com sucesso!");

        return reserva;
    }

	public String cancelarReserva() {
		return "Reserva n�o efetuada";
	}

	public String msgCpfInvalido() {
		return "CPF Inv�lido";
	}

	public String msgHospedeNaoCadastrado() {
		return "Cliente n�o cadastrado";
	}

	public String msgQuartosIndisponiveis() {
		return "Nao ha quartos disponiveis";
	}
	}