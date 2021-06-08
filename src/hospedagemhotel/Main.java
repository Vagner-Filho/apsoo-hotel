package hospedagemhotel;

import java.util.Scanner;

import hospedagemhotel.bd.Conexao;

public class Main {
	
    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// inicializa o banco de dados 
		Conexao.InitBD();

		// testando o método buscarHospede
		System.out.println("REALIZAR RESERVA");
		System.out.println("CPF do hóspede: ");
	
		String cpfHospede = scanner.nextLine();   // lê o cpf do terminal

		String nomeHospede = Conexao.buscarHospede(cpfHospede);
		if(nomeHospede == null){
			System.out.println("Hóspede não cadastrado");
			// cadastrar hóspede
		}else{
			System.out.println(nomeHospede);

		}
		scanner.close();

    }
}
