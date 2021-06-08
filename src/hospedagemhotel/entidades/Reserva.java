package hospedagemhotel.entidades;

import java.util.ArrayList;
import java.util.Random;

// TODO Implementar m�todos 'confirmarReserva()' e 'cancelarReserva()'

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



	//Métodos de reserva
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
	//Métodos de pessoas
	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = new Hospede(hospede.getSexo(), hospede.getCodigoConta());
	}
	
	public void setHospede(String hospede) {
		this.hospede.setNome(hospede);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = new Funcionario(funcionario.getNome(), funcionario.getCpf(), funcionario.getTelefone(),
				funcionario.getDataNasc(), funcionario.getEndereco(), funcionario.getLogin(), 
				funcionario.getSenha(), funcionario.getSalario(), funcionario.getCargo());
		Random aleatorio = new Random();
		setIdReserva(aleatorio.nextInt(20));
	}

	//Arrumar esse metodo, s� mostra 1 quarto
	public Quarto getQuarto() {
		return quartos.get(0);	
	}
	
	public void setQuarto(Quarto quarto) {
		quartos.add(quarto);
	}

	//Métodos de datas
	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = new Date(dataInicial.getDia(), dataInicial.getMes(), dataInicial.getAno());
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = new Date(dataFinal.getDia(), dataFinal.getMes(), dataFinal.getAno());
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
		return "Reserva [hospede=" + hospede + ", funcionario=" + funcionario + ", quartos=" + quartos.toString() + ", dataInicial="
				+ dataInicial + ", dataFinal=" + dataFinal + "]";
	}
	
}
