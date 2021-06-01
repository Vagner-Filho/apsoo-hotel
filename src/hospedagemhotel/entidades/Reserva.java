package hospedagemhotel.entidades;

// TODO Implementar m�todos 'confirmarReserva()' e 'cancelarReserva()'

public class Reserva {
	private int IdReserva;
	private Hospede hospede; 
	private Funcionario funcionario ;
	private Quarto quarto;
	private Hospedagem hospedagem; // mudar o tipo para Hospedagem
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

	public int getIdReserva() {
		return IdReserva;
	}

	public void setIdReserva(int idReserva) {
		IdReserva = idReserva;
	}
	
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

	public int getQuarto() {
		return quarto.getCodigoQuarto();
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

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
