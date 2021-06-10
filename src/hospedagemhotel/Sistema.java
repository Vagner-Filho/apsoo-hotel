package hospedagemhotel;

import java.util.Random;
import java.util.Scanner;

import hospedagemhotel.bd.Conexao;
import hospedagemhotel.entidades.Endereco;
import hospedagemhotel.entidades.Hospede;
import hospedagemhotel.entidades.Quarto;
import hospedagemhotel.entidades.Reserva;
import hospedagemhotel.entidades.TipoDeQuarto;

// TODO Voltar o tipo dataNascimento de date para string caso a instanciação com date não der certo

public class Sistema {
	
	Scanner scanner = new Scanner(System.in);
	
	//Ja passei o cpf por parametro, pra nao precisar escrever ele mais uma vez a toa
	public void cadastrarHospede(String cpf) {	
		System.out.println("------CADASTRO DE HÓSPEDE------");
		System.out.println("Digite os dados do hospede:\n");

		System.out.println("Nome completo: ");
		String nome = scanner.nextLine();
		System.out.println();

		System.out.println("Telefone: ");
		int telefone = scanner.nextInt();

		/*//Metodo para obter data de nascimento
		System.out.println("Informe a data de nascimento: ");
		Date dataNascimento = new Date();
		dataNascimento.setData();*/

		System.out.println("Informe a data de nascimento: ");
		String dataNascimento = scanner.nextLine();
		
		//Metodo para obter o endereco
		System.out.println("Informe o Endereco: \n");
		Endereco endereco = new Endereco();
		endereco.setEndereco();
		
		System.out.println("Sexo: ");
		String sexo = scanner.nextLine();
		System.out.println();

		System.out.println("Cóigo da conta:");
		int codigoConta = scanner.nextInt();

		System.out.println(nome + telefone + dataNascimento + endereco + sexo + codigoConta);

		//Hospede hospede = new Hospede(nome, cpf, telefone, dataNascimento, endereco, sexo, codigoConta);

		//primero tem que inserir um endereco, depois uma pessoa e depois um hospede no bd

		//Conexao.alterarBD("INSERT INTO hospede VALUES('" + hospede.getCpf() + "', '" + hospede.getDataNasc()+ "', '" +hospede.getSexo()+"', "+hospede.getCodigoConta()+")");

	}

	
	//Alterei o retorno e o tipo do metodo - Henrique
	// Está sem o parametro Funcionario porque acho que seria melhor fazer uma autenticação - Juliendy
	public Reserva confirmarReserva(String cpf, String dataInicial, String dataFinal, Quarto quarto) {
		Hospede hos = Conexao.buscarHospede(cpf);
		Conexao.buscarQuarto(quarto.getCodigoQuarto());
		Reserva reserva = new Reserva();
		reserva.setDataInicial(dataInicial);
		reserva.setDataFinal(dataFinal);
		reserva.setQuarto(quarto);
		reserva.setHospede(hos); 
	
		//salvar a reserva no bd
		String query = "insert into reserva values(" + reserva.getIdReserva() + ", '23556987451', '" + reserva.dataInicial + "', '" + reserva.dataFinal + "', null)";
		try{
			// insere a reserva no bd
			Conexao.alterarBD(query);

			query = "update hospede set hos_res = " + reserva.getIdReserva() + " where '" + cpf + "' = hcpf";

			//relaciona a reserva ao hospede
			Conexao.alterarBD(query);

			System.out.print("Reserva efetuada com sucesso!");
		}catch (Error e){
			System.out.println("Não foi possível cadastrar a reserva.");
		}		
		
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


	public TipoDeQuarto[] verTiposDeQuarto() {
		TipoDeQuarto[] tipos = Conexao.verTiposDeQuarto();
		for (TipoDeQuarto tipoDeQuarto : tipos) {
			System.out.println(tipoDeQuarto);
		}

		return tipos;
	}
	
	
	public Quarto[] verQuartosDisponiveis(TipoDeQuarto tipoDeQuartoDesejado) {
		Quarto[] listaQuartos = Conexao.verQuartosDisponiveis(tipoDeQuartoDesejado);
		while (listaQuartos == null) {
			System.out.println("N�o h� quartos dispon�veis");
			System.out.println("Selecione um tipo de Quarto: [ID]");
			verTiposDeQuarto();
			tipoDeQuartoDesejado.setTipoDeQuarto(scanner.nextInt());
			verQuartosDisponiveis(tipoDeQuartoDesejado);
		}
		
		for (Quarto quarto : listaQuartos) {
			System.out.println(quarto);
		}

		return listaQuartos;
	}

	public void buscarHospede(String cpf){
		Hospede hospede = Conexao.buscarHospede(cpf);
		if (hospede == null)
    	{
    		msgHospedeNaoCadastrado();
    		//cadastrarHospede(cpf);
    	}else{
			System.out.println(hospede.getNome());
		}
		
	}

	//O metodo autenticaCpf pode ser aqui tambem


	public int numeroAleatorio(){
		Random aleatorio = new Random();
		return aleatorio.nextInt(100);
	}
	
}
