package hospedagemhotel.entidades;

import java.util.Scanner;
import hospedagemhotel.entidades.Date;
import java.sql.Connection;

public class Sistema {

	private static Connection conexao;

	Scanner scanner = new Scanner(System.in);

	public Date dataNascimento() {
		System.out.println("Data de nascimento: ");

		System.out.println("Dia: ");
		int dia = scanner.nextInt();

		System.out.println("Mês: ");
		int mes = scanner.nextInt();

		System.out.println("Ano: ");
		int ano = scanner.nextInt();

		Date dataNascimento = new Date(dia, mes, ano);

		return dataNascimento;
	}

	public void cadastrarHospede() {
		System.out.println("Digite os dados do hospede:\n");

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

		stm.executeUpdate("INSERT INTO hospede VALUES( '"+hospede.getCpf()+"', "+hospede.getDataNasc()+", '"+hospede.getSexo()+"', "+hospede.getCodigoConta()+")");
		
	}
}
