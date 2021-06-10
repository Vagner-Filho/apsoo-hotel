package hospedagemhotel.entidades;

import java.util.ArrayList;
import java.util.Random;


public class Reserva {
	private int idReserva;
	private Hospede hospede; 
	private Funcionario funcionario ;
	private ArrayList<Quarto> quartos = new ArrayList();
	public Date dataInicial; 
	public Date dataFinal; 
	private String pagamento;
	
	public Reserva() {
		
	}

	public Reserva(int idReserva, Hospede hospede, Funcionario funcionario, 
			Quarto quarto, Date dataInicial, Date dataFinal) {
			setIdReserva(idReserva);
			setHospede(hospede);
			setFuncionario(funcionario);
			setQuarto(quarto);
			setDataInicial(dataInicial);
			setDataFinal(dataFinal);
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
	
	public void setHospede(String hospede) {
		this.hospede.setNome(hospede);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	//Coloquei aqui uma opcao para criar o id da reserva, 
	//com um numero aleatorio de 0 até 20
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		Random aleatorio = new Random();
		setIdReserva(aleatorio.nextInt(20));
	}

	//Arrumar esse metodo, so mostra 1 quarto
	public Quarto getQuarto() {
		return quartos.get(0);	
	}
	
	public void setQuarto(Quarto quarto) {
		quartos.add(quarto);
	}

	//Metodos de datas
	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
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
