package hospedagemhotel;

import java.util.Scanner;

import hospedagemhotel.bd.Conexao;
import hospedagemhotel.entidades.Date;
import hospedagemhotel.entidades.Endereco;
import hospedagemhotel.entidades.Funcionario;
import hospedagemhotel.entidades.Hospedagem;
import hospedagemhotel.entidades.Hospede;
import hospedagemhotel.entidades.Pessoa;
import hospedagemhotel.entidades.Quarto;
import hospedagemhotel.entidades.Reserva;
import hospedagemhotel.entidades.Sistema;
import hospedagemhotel.entidades.TipoDeQuarto;

public class Main {
	
    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		Sistema sistema = new Sistema();
    	
    	System.out.println("------TELA DE REALIZAR RESERVA-------");
    	System.out.println("Indique o cpf do cliente: ");
    	
    	String cpf = scanner.nextLine();
    	System.out.println();
    	
    	Boolean valido = sistema.autenticaCPF(cpf);
    	System.out.println();
    	
    	while (valido != true)
    	{
    		sistema.msgCpfInvalido();
    		System.out.println("Indique o cpf do cliente: ");
    		
    		cpf = scanner.nextLine();
        	System.out.println();
        	
        	valido = sistema.autenticaCPF(cpf);
        	System.out.println();
    	}
    	
    	Hospede hospede = Conexao.buscarHospede(cpf);
    	
    	if (hospede == null)
    	{
    		sistema.msgHospedeNaoCadastrado();
    		sistema.cadastrarHospede(cpf);
    	}
    	
    	Date dataInicial = new Date();
    	Date dataFinal = new Date();
    	
    	System.out.println("Qual a data de Entrada?");
    	dataInicial.setData();
    	
    	System.out.println("Qual a data de Saida?");
    	dataFinal.setData();
    	
    	System.out.println("Selecione um tipo de Quarto:");
    	sistema.verTiposDeQuarto();
    	
    	TipoDeQuarto tipoDeQuartoDesejado = new TipoDeQuarto();
    	tipoDeQuartoDesejado.setTipoDeQuarto(scanner.nextInt());
    	
    	sistema.verQuartosDisponiveis(dataInicial, dataFinal, tipoDeQuartoDesejado);
    	
    	System.out.println("Selecione um Quarto:");
    	
    	Quarto quartoEscolhido = new Quarto();
    	
    	

		// inicializa o banco de dados 
		Conexao.InitBD();

		// insere um endereço no bd
		Conexao.alterarBD("INSERT INTO endereco VALUES(1, 'Rua 123', 2200, 'Vilas Boas', 12345678, 'Campo Grande', 'MS', 'Casa 1')");

		//insere uma pessoa 
		Conexao.alterarBD("INSERT INTO pessoa VALUES('12345678910', 1, 'Maria', '2000-02-15', '55555-8888')");

		// insere uma pessoa 
		Conexao.alterarBD("INSERT INTO pessoa VALUES('23556987451', 1, 'João', '1950-03-30', '65489-2354')");
		
		// insere um funcionario
		Conexao.alterarBD("INSERT INTO funcionario VALUES('23556987451', 'joao123', '1234', 1200, 'Recepcionista')");

		// insere uma reserva
		Conexao.alterarBD("INSERT INTO reserva VALUES(1, '23556987451', '2021-02-03', '2021-02-05', 'Dinheiro')");

		// insere um hospede
		Conexao.alterarBD("INSERT INTO hospede VALUES( '12345678910', 1, 'F', 12)");

		// testando o método buscarHospede
		System.out.println("REALIZAR RESERVA");
		System.out.println("CPF do hóspede: ");
	
		String cpfHospede = scanner.nextLine();   // lê o cpf do terminal
		// método autenticaCpf

		String nomeHospede = Conexao.buscarHospede(cpfHospede);
		if(nomeHospede == null){
			System.out.println("Hóspede não cadastrado");
			// cadastrar hóspede
		}else{
			System.out.println(nomeHospede);

		}

		


    }
}
