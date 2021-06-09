package hospedagemhotel;

import java.util.Scanner;

import hospedagemhotel.bd.Conexao;
import hospedagemhotel.entidades.Hospede;
import hospedagemhotel.entidades.Quarto;
import hospedagemhotel.entidades.TipoDeQuarto;

public class Main {
	
    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// inicializa o banco de dados 
		Conexao.InitBD();

		
		System.out.println("REALIZAR RESERVA");
		System.out.println("CPF do hóspede: ");
	
		String cpfHospede = scanner.nextLine();   // lê o cpf do terminal
		
		Hospede hospede = new Hospede();
		hospede = Conexao.buscarHospede(cpfHospede);


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
