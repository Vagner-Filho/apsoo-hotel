package hospedagemhotel.entidades;

import java.util.Scanner;

public class Date {
	private int dia;
	private int mes;
	private int ano;

	Scanner scanner = new Scanner(System.in);
	
	public Date() {}
	
	public Date(int dia, int mes, int ano) {
		setDia(dia);
		setMes(mes);
		setAno(ano);
	}

	public void setData() {

		System.out.println("Dia: ");
		int dia = scanner.nextInt();

		System.out.println("Mes: ");
		int mes = scanner.nextInt();

		System.out.println("Ano: ");
		int ano = scanner.nextInt();

		setDia(dia);
		setMes(mes);
		setAno(ano);
		
	}


	public String getData() {
		return this.toString();
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		if (dia > 0 && dia < 32) {
			this.dia = dia;
		}
		else {
			System.out.println("Dia invalido");
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
