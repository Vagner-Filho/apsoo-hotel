package hospedagemhotel.entidades;

// TODO Implementar m�todos 'confirmarReserva()' e 'cancelarReserva()'

public class Reserva {
	private int IdReserva;
	private Hospede hospede; 
	private Funcionario funcionario ;
	private Quarto quarto;
	private Hospedagem hospedagem;
	private Date dataInicial; 
	private Date dataFinal; 
	private String pagamento;
	
	public Reserva(Hospede hospede, Funcionario funcionario, Quarto quarto, Date dataInicial, Date dataFinal) {
		setHospede(hospede);
		setFuncionario(funcionario);
		setQuarto(quarto);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
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
