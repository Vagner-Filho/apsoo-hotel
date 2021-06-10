package hospedagemhotel.entidades;

import java.util.Scanner;

import hospedagemhotel.bd.Conexao;

// TODO Voltar o tipo dataNascimento de date para string caso a instanciaÃ§Ã£o com date nÃ£o der certo

public class Sistema {
	
	Scanner scanner = new Scanner(System.in);
	
	//Ja passei o cpf por parametro, pra nao precisar escrever ele mais uma vez a toa
	public void cadastrarHospede(String cpf) {
		
		
		System.out.println("Digite os dados do hospede:\n");

		System.out.println("Nome completo: ");
		String nome = scanner.nextLine();
		System.out.println();

		System.out.println("Telefone: ");
		int telefone = scanner.nextInt();

		//Metodo para obter data de nascimento
		System.out.println("Informe a data de nascimento: ");
		Date dataNascimento = new Date();
		dataNascimento.setData();
		
		//Metodo para obter o endereco
		System.out.println("Informe o Endereco: \n");
		Endereco endereco = new Endereco();
		endereco.setEndereco();
		
		System.out.println("Sexo: ");
		String sexo = scanner.nextLine();
		System.out.println();

<<<<<<< HEAD

	Scanner scanner = new Scanner(System.in);

	public void cadastrarHospede() {
		System.out.println("Digite os dados do hospede:\n");

		System.out.println("Nome completo: ");
		String nome = scanner.nextLine();

		System.out.println("CPF: ");
		String cpf = scanner.nextLine();

		System.out.println("Telefone: ");
		String telefone = scanner.nextLine();

		//MÃ©todo para obter data de nascimento
		System.out.println("Informe a data de nascimento: ");
		Date dataNascimento = new Date();

		dataNascimento.setData();
		
		System.out.println("Sexo: ");
		String sexo = scanner.nextLine();

		System.out.println("CÃ³igo da conta:");
		int codigoConta = scanner.nextInt();

		Hospede hospede = new Hospede(nome, cpf, telefone, dataNascimento, sexo, codigoConta);
=======
		System.out.println("Codigo da conta:");
		int codigoConta = scanner.nextInt();

		Hospede hospede = new Hospede(nome, cpf, telefone, dataNascimento, endereco, sexo, codigoConta);
>>>>>>> branch-Henrique

		// primero tem que inserir uma pessoa e depois um hospede
		
		//Conexao.alterarBD("INSERT INTO hospede VALUES('" + hospede.getCpf() + "', '" + hospede.getDataNasc()+ "', '" +hospede.getSexo()+"', "+hospede.getCodigoConta()+")");
<<<<<<< HEAD
=======
	}
	
	//Alterei o retorno e o tipo do metodo
	public Reserva confirmarReserva(String cpf, Date dataInicial, Date dataFinal, Quarto quarto, Funcionario funcionario) {
		Hospede hos = Conexao.buscarHospede(cpf);
		Conexao.buscarQuarto(quarto.getCodigoQuarto());
		Reserva reserva = new Reserva();
		reserva.setDataInicial(dataInicial);
		reserva.setDataFinal(dataFinal);
		reserva.setQuarto(quarto);
		reserva.setHospede(hos); 
		reserva.setFuncionario(funcionario);
		System.out.print("Reserva efetuada com sucesso!");
		return reserva;
>>>>>>> branch-Henrique
	}

	public Reserva confirmarReserva(int idReserva, String cpf, String dataInicial, String dataFinal, Quarto quarto, Funcionario funcionario) {
        
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
		return "Reserva nï¿½o efetuada";
	}

	public String msgCpfInvalido() {
		return "CPF Invï¿½lido";
	}

	public String msgHospedeNaoCadastrado() {
		return "Cliente nï¿½o cadastrado";
	}

	public String msgQuartosIndisponiveis() {
		return "Nao ha quartos disponiveis";
	}
<<<<<<< HEAD
	}
=======
	
	//METODO DA GAMBIARRA sem o bd
	public TipoDeQuarto[] verTiposDeQuarto() {
		/*System.out.println("---Tipos de Quarto---");
		System.out.println("1 - Valor: 100 / Descrição: Nivel Baixo");
		System.out.println("2 - Valor: 200 / Descrição: Nivel Intermediario");
		System.out.println("3 - Valor: 300 / Descrição: Nivel Alto");*/
		return Conexao.verTiposDeQuarto();
	}
	
	/* METODO MAIS CORRETO 
	public void verTiposDeQuarto() {
		Conexao.verTiposDeQuarto();
	}*/
	
	
	//Terminar esse metodo
	public Quarto[] verQuartosDisponiveis(Date dataInicial, Date dataFinal, TipoDeQuarto tipoDeQuartoDesejado) {
		Quarto[] lista = Conexao.verQuartosDisponiveis(dataInicial, dataFinal, tipoDeQuartoDesejado);
		while (lista == null) {
			System.out.println("Não há quartos disponíveis");
			System.out.println("Selecione um tipo de Quarto:");
			verTiposDeQuarto();
			tipoDeQuartoDesejado.setTipoDeQuarto(scanner.nextInt());
			verQuartosDisponiveis(dataInicial, dataFinal, tipoDeQuartoDesejado);
		}
		return lista;	
	}
	
	//Esse metodo pode ser aqui tambem
	/*
	public boolean autenticaCPF(String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
		|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
		|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
		|| cpf.equals("99999999999") || cpf.equals("00000000000") || (cpf.length() != 11)) 
	return (false);

	char numVer1, numVer2;
	int i, peso, numero, soma, valor;

	try {
		soma = 0;
		peso = 10;
		for (i = 0; i < 9; i++) {
			numero = (int) (cpf.charAt(i)-48);
			soma = soma + (numero * peso);
			peso--;
		}
		soma = soma * 10;

		if (soma % 11 == 10) {
			numVer1 = '0';

		} else {
			valor = soma % 11;
			numVer1 = (char) (valor + 48);
			

		}
		soma = 0;
		peso = 11;
		for(i=0;i<10;i++){
			numero = (int) (cpf.charAt(i)-48);
			soma = soma + (numero * peso);
			peso--;
		}
		valor = 11-(soma%11);
		if(valor == 10||valor ==11) {
			numVer2= '0';
		}
		else {
			numVer2 = (char) (valor + 48);
		}
		
		if(numVer1 == cpf.charAt(9) && numVer2 == cpf.charAt(10)) {
			return true;
		}else {
			return false;
		}
		

	} catch (InputMismatchException erro) {
		return (false);
	}
	}
	*/
}
>>>>>>> branch-Henrique
