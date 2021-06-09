package hospedagemhotel.entidades;

import java.util.Scanner;

// TODO Implementar m�todos 'confirmarReserva()' e 'cancelarReserva()'

public class Reserva {
	private int IdReserva;
	private Hospede hospede; 
	private Funcionario funcionario ;
	private Quarto quarto;
	private Hospedagem hospedagem;
	private String dataInicial; 
	private String dataFinal; 
	private String pagamento;

	Scanner leitor = new Scanner(System.in);

	public Reserva(){}
	
	public Reserva(int idReserva, Hospede hospede, Funcionario funcionario, Quarto quarto, String dataInicial, String dataFinal) {
		setHospede(hospede);
		setFuncionario(funcionario);
		setQuarto(quarto);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
		setIdReserva(idReserva);
	}

	//Métodos de reserva
	public int getIdReserva() {
		return IdReserva;
	}

	public void setIdReserva(int idReserva) {
		IdReserva = idReserva;
	}
	
	//Métodos de pessoas
	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public String getFuncionario() {
		return funcionario.getNome();
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	//Métodos de quarto
	public int getQuarto() {
		return quarto.getCodigoQuarto();
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	//Métodos de hospedagem
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	//Métodos de datas
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

	//Métodos de pagamento
	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	
	@Override
	public String toString() {
		return "Reserva [hospede=" + hospede + ", funcionario=" + funcionario + ", quarto=" + quarto + ", dataInicial="
				+ dataInicial + ", dataFinal=" + dataFinal + "]";
	}
	
}
