package hospedagemhotel.entidades;

import java.util.ArrayList;
import java.util.Scanner;

import hospedagemhotel.Sistema;

public class Reserva {
	private int idReserva;
	private Hospede hospede; 
	private Funcionario funcionario ;
	private ArrayList<Quarto> quartos = new ArrayList<Quarto>();
	public String dataInicial; 
	public String dataFinal; 
	private String pagamento;

	Scanner leitor = new Scanner(System.in);

	public Reserva(){
		Sistema sis = new Sistema();
		setIdReserva(sis.numeroAleatorio());
	}
	

	public Reserva(int idReserva, Hospede hospede, Funcionario funcionario, 
			Quarto quarto, String dataInicial, String dataFinal) {
			setIdReserva(idReserva);
			setHospede(hospede);
			setFuncionario(funcionario);
			setQuarto(quarto);
			setDataInicial(dataInicial);
			setDataFinal(dataFinal);

			Sistema sis = new Sistema();
			setIdReserva(sis.numeroAleatorio());
	}


	//Metodos de reserva
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
	//Metodos de pessoas
	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	//Coloquei aqui uma opcao para criar o id da reserva, 
	//com um numero aleatorio de 0 at� 20
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		
	}

	//Arrumar esse metodo, so mostra 1 quarto
	public Quarto getQuarto() {
		return quartos.get(0);	
	}
	
	public void setQuarto(Quarto quarto) {
		quartos.add(quarto);
	}

	//Metodos de datas
	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	//Metodos de pagamento
	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	
	@Override
	public String toString() {
		return "Reserva [hospede=" + hospede + ", funcionario=" + funcionario + ", quartos=" + quartos.toString() + ", dataInicial="
				+ dataInicial + ", dataFinal=" + dataFinal + "]";
	}
	
}
