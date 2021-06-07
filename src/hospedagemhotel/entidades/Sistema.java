package hospedagemhotel.entidades;

import java.util.Scanner;
import hospedagemhotel.entidades.Date;

public class Sistema{

	Scanner scanner = new Scanner(System.in);

	public void cadastrarHospede() {
		System.out.println("Digite os dados do hospede:\n")

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
	}
}
