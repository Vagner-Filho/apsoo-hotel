package hospedagemhotel.entidades;

import java.util.Scanner;
import hospedagemhotel.entidades.Date;
import java.sql.Connection;

public class Sistema {

	private static Connection Conexao;

	Scanner scanner = new Scanner(System.in);

	public Date dataNascimento() {
		System.out.println("Data de nascimento: ");

		System.out.println("Dia: ");
		int dia = scanner.nextInt();

		System.out.println("Mês: ");
		int mes = scanner.nextInt();

		System.out.println("Ano: ");
		int ano = scanner.nextInt();

		Date dataNascimento = new Date(dia, mes, ano);

		return dataNascimento;
	}

	public void cadastrarHospede() {
		System.out.println("Digite os dados do hospede:\n");

		System.out.println("Nome completo: ");
		String nome = scanner.nextLine();

		System.out.println("CPF: ");
		String cpf = scanner.nextLine();

		System.out.println("Telefone: ");
		int telefone = scanner.nextInt();

		Date dataNascimento = dataNascimento();

		System.out.println("Sexo: ");
		String sexo = scanner.nextLine();

		System.out.println("Cóigo da conta:");
		int codigoConta = scanner.nextInt();

		Hospede hospede = new Hospede(nome, cpf, telefone, dataNascimento, sexo, codigoConta);

		Conexao.alterarBD("INSERT INTO hospede VALUES('"+hospede.getCpf()+"', "+hospede.getDataNasc()+", '"+hospede.getSexo()+"', "+hospede.getCodigoConta()+")");
	}

	public String confirmarReserva(String cpf, int diaI, int mesI, int anoI, int diaF, int mesF, int anoF, int codigoQuarto, Funcionario func) {
		String hos = Conexao.buscarHospede(cpf);
		Conexao.buscarQuarto(codigoQuarto);
		Reserva reserva = new Reserva();
		reserva.setDataInicial(diaI, mesI, anoI);
		reserva.setDataFinal(diaF, mesF, anoF);
		reserva.setQuarto(codigoQuarto);
		reserva.setHospede(hos);
		reserva.setFuncionario(func);
		return "Reserva efetuada com sucesso!";
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