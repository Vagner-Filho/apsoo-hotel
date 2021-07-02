package hospedagemhotel.model;

import java.util.ArrayList;
import java.util.Scanner;

import hospedagemhotel.controller.Sistema;

public class Reserva {
	private int idReserva;
	private Hospede hospede; 
	private Funcionario funcionario ;
	private ArrayList<Quarto> quartos = new ArrayList<Quarto>();
	public String dataInicial; 
	public String dataFinal; 
	private String pagamento;
	private boolean checkin;
	private String dataCheckin;
	private String horaCheckin;


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

	public ArrayList<Quarto> getQuarto() {
		return quartos;
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
	
	//Metodos de checking
	public boolean getCheckin() {
		return checkin;
	}

	public void setCheckin(boolean checkin) {
		this.checkin = checkin;
	}

	//Metodos de dataCheckin
	public String getDataCheckin() {
		return dataCheckin;
	}

	public void setDataCheckin(String dataCheckin) {
		this.dataCheckin = dataCheckin;
	}
	
	//Metodos de horaCheckin
	public String horaCheckin() {
		return horaCheckin;
	}

	public void setHoraCheckin(String horaCheckin) {
		this.horaCheckin = horaCheckin;
	}

	@Override
	public String toString() {
		return "Reserva " + idReserva + "  Data Inicial = " + dataInicial + "  DataFinal = " + dataFinal;
	}
	
}
