package hospedagemhotel.entidades;

import java.util.Scanner;

import hospedagemhotel.bd.Conexao;
<<<<<<< HEAD
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

=======

// TODO Voltar o tipo dataNascimento de date para string caso a instanciação com date não der certo

public class Sistema {


	Scanner scanner = new Scanner(System.in);

>>>>>>> 1d77a0c049b10a253894a15a2151bc2bae5e627a
	public void cadastrarHospede() {
		System.out.println("Digite os dados do hospede:\n");

		System.out.println("Nome completo: ");
		String nome = scanner.nextLine();

		System.out.println("CPF: ");
		String cpf = scanner.nextLine();

		System.out.println("Telefone: ");
		String telefone = scanner.nextLine();
<<<<<<< HEAD
=======

		//Método para obter data de nascimento
		System.out.println("Informe a data de nascimento: ");
		Date dataNascimento = new Date();

		dataNascimento.setData();
>>>>>>> 1d77a0c049b10a253894a15a2151bc2bae5e627a

		String dataNascimento = dataNascimento();
		System.out.println(dataNascimento);
		
		System.out.println("Sexo: ");
		String sexo = scanner.nextLine();

		System.out.println("Cóigo da conta:");
		int codigoConta = scanner.nextInt();

		Hospede hospede = new Hospede(nome, cpf, telefone, dataNascimento, sexo, codigoConta);

<<<<<<< HEAD
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
=======
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

>>>>>>> 1d77a0c049b10a253894a15a2151bc2bae5e627a
        System.out.print("Reserva efetuada com sucesso!");

        return reserva;
    }

	public String cancelarReserva() {
		return "Reserva n�o efetuada";
	}
<<<<<<< HEAD

	public String msgCpfInvalido() {
		return "CPF Inv�lido";
	}

	public String msgHospedeNaoCadastrado() {
		return "Cliente n�o cadastrado";
	}

	public String msgQuartosIndisponiveis() {
		return "Nao ha quartos disponiveis";
	}
	
=======

	public String msgCpfInvalido() {
		return "CPF Inv�lido";
	}
>>>>>>> 1d77a0c049b10a253894a15a2151bc2bae5e627a

	public String msgHospedeNaoCadastrado() {
		return "Cliente n�o cadastrado";
	}

	public String msgQuartosIndisponiveis() {
		return "Nao ha quartos disponiveis";
	}
	}