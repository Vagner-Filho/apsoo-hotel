package hospedagemhotel.entidades;

import java.util.Scanner;

import hospedagemhotel.bd.Conexao;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Sistema {

	Scanner scanner = new Scanner(System.in);

	public String dataNascimento() {
		System.out.println("Data de nascimento: ");

		System.out.println("Dia: ");
		int dia = scanner.nextInt();

		System.out.println("Mês: ");
		int mes = scanner.nextInt();

		System.out.println("Ano: ");
		int ano = scanner.nextInt();
		scanner.nextLine();

		String dataNascimento = dia + "/" + mes + "/" + ano;

		return dataNascimento;
	}

	public void cadastrarHospede() {
		System.out.println("Digite os dados do hospede:\n");

		System.out.println("Nome completo: ");
		String nome = scanner.nextLine();

		System.out.println("CPF: ");
		String cpf = scanner.nextLine();

		System.out.println("Telefone: ");
		String telefone = scanner.nextLine();

		String dataNascimento = dataNascimento();
		System.out.println(dataNascimento);
		
		System.out.println("Sexo: ");
		String sexo = scanner.nextLine();

		System.out.println("Cóigo da conta:");
		int codigoConta = scanner.nextInt();

		Hospede hospede = new Hospede(nome, cpf, telefone, dataNascimento, sexo, codigoConta);

		// primero tem que inserir uma pessoa e depois um hospede
		
		//Conexao.alterarBD("INSERT INTO hospede VALUES('" + hospede.getCpf() + "', '" + hospede.getDataNasc()+ "', '" +hospede.getSexo()+"', "+hospede.getCodigoConta()+")");
	}

	public Reserva confirmarReserva(String cpf, String dataInicial, String dataFinal, Quarto quarto, Funcionario funcionario1) {
        Hospede hos = Conexao.buscarHospede(cpf);
        Conexao.buscarQuarto(quarto.getCodigoQuarto());
        Reserva reserva = new Reserva();
        reserva.setDataInicial(dataInicial);
        reserva.setDataFinal(dataFinal);
        reserva.setQuarto(quarto);
        reserva.setHospede(hos); 
        reserva.setFuncionario(funcionario1);
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