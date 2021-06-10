package hospedagemhotel;

import java.util.Scanner;

import hospedagemhotel.bd.Conexao;
<<<<<<< HEAD
import hospedagemhotel.entidades.Hospede;
import hospedagemhotel.entidades.Quarto;
=======
import hospedagemhotel.entidades.Date;
import hospedagemhotel.entidades.Endereco;
import hospedagemhotel.entidades.Funcionario;
import hospedagemhotel.entidades.Hospedagem;
import hospedagemhotel.entidades.Hospede;
import hospedagemhotel.entidades.Pessoa;
import hospedagemhotel.entidades.Quarto;
import hospedagemhotel.entidades.Reserva;
import hospedagemhotel.entidades.Sistema;
>>>>>>> branch-Henrique
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
		
		System.out.println("REALIZAR RESERVA");
		System.out.println("CPF do hóspede: ");
	
		String cpfHospede = scanner.nextLine();   // lê o cpf do terminal
		
		Hospede hospede = new Hospede();
		hospede = Conexao.buscarHospede(cpfHospede);
		
		//System.out.println(hospede.getNome());
		

		if(hospede == null){
			System.out.println("Hóspede não cadastrado");
			// cadastrar hóspede
		}else{
			System.out.println(hospede.getNome()); // tem um erro aqui 

		}

		System.out.println("Data inicial da estadia:");
		String dataInicial = scanner.nextLine();

		System.out.println("Data final da estadia:");
		String dataFinal = scanner.nextLine();

		// percorre e imprime os items do array com os tipos de quarto 
		for (TipoDeQuarto tipo : Conexao.verTiposDeQuarto()) {
			System.out.println(tipo.getDescricao());
		}

		String tipoDeQuartoEscolhido = scanner.nextLine();
	
		TipoDeQuarto tipQua = new TipoDeQuarto();

		// percorre o array com os tipos de quarto e guarda na variável tipQua o objeto que representa o tipo de quarto escolhido pelo usuario	
		for (TipoDeQuarto tipo : Conexao.verTiposDeQuarto()) {
			//System.out.println(tipo.getDescricao());
			if(tipoDeQuartoEscolhido.equals(tipo.getDescricao())){
				tipQua = tipo;
			}else{
				System.out.println("Tipo de quarto não existe");
				
			}
		}


		// percorre o array de quartos de disponiveis de acordo com o tipo de quarto escolhido anteriormente e imprime sua localizacao (por enquanto)
		for (Quarto quarto : Conexao.verQuartosDisponiveis(tipQua)) {
			System.out.println(quarto.getLocalizacao());
		}
		


		scanner.close();
		
    }
}