package hospedagemhotel;

import java.util.Scanner;

import hospedagemhotel.bd.Conexao;

public class Main {
	
    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

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
