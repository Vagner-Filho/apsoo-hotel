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
	
	public Reserva(String hospede, Funcionario funcionario, int codigoQuarto, int diaI, 
			int mesI, int anoI, int diaF, int mesF, int anoF) {
		setHospede(hospede);
		setFuncionario(funcionario);
		setQuarto(codigoQuarto);
		setDataInicial(diaI, mesI, anoI);
		setDataFinal(diaF, mesF, anoF);
	}

	public Reserva() {
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

	public void setHospede(String hospede) {
		this.hospede.setNome(hospede);
	}

	public String getFuncionario() {
		return funcionario.getNome();
	}

	//Arrumar
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	//Métodos de quarto
	public int getQuarto() {
		return quarto.getCodigoQuarto();
	}

	//Arrumar
	public void setQuarto(int codigoQuarto) {
		this.quarto.setCodigoQuarto(codigoQuarto);
	}

	//Métodos de hospedagem
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	
	//Arrumar
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	//Métodos de datas
	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(int diaI, int mesI, int anoI) {
		dataInicial = new Date(diaI, mesI, anoI);
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(int diaF, int mesF, int anoF) {
		dataFinal = new Date(diaF, mesF, anoF);
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
