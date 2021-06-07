package hospedagemhotel.entidades;

import java.util.Scanner;

public class Date {
	private int dia;
	private int mes;
	private int ano;

	Scanner scanner = new Scanner(System.in);
	
	public Date(int dia, int mes, int ano) {
		setDia(dia);
		setMes(mes);
		setAno(ano);
	}

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

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		if (dia > 0 && dia < 31) {
			this.dia = dia;
		}
		else {
			System.out.println("Dia inválido");
		}
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		if (mes > 0 && mes < 13) {
			this.mes = mes;
		}
		else {
			System.out.println("Mês inválido");
		}
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String toString(){
		
		return getDia() + "/" + getMes() + "/" + getAno();
	}
	
}
