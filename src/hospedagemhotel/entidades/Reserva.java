package hospedagemhotel.entidades;

<<<<<<< HEAD
import java.util.Scanner;

// TODO Implementar m�todos 'confirmarReserva()' e 'cancelarReserva()'
=======
import java.util.ArrayList;
import java.util.Random;

>>>>>>> branch-Henrique

public class Reserva {
	private int idReserva;
	private Hospede hospede; 
	private Funcionario funcionario ;
<<<<<<< HEAD
	private Quarto quarto;
	private Hospedagem hospedagem;
	private String dataInicial; 
	private String dataFinal; 
=======
	private ArrayList<Quarto> quartos = new ArrayList();
	public Date dataInicial; 
	public Date dataFinal; 
>>>>>>> branch-Henrique
	private String pagamento;

	Scanner leitor = new Scanner(System.in);

	public Reserva(){}
	
<<<<<<< HEAD
	public Reserva(int idReserva, Hospede hospede, Funcionario funcionario, Quarto quarto, String dataInicial, String dataFinal) {
		setHospede(hospede);
		setFuncionario(funcionario);
		setQuarto(quarto);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
		setIdReserva(idReserva);
=======
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
>>>>>>> branch-Henrique
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
<<<<<<< HEAD
=======
	}
	
	public void setHospede(String hospede) {
		this.hospede.setNome(hospede);
>>>>>>> branch-Henrique
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

<<<<<<< HEAD
=======
	//Coloquei aqui uma opcao para criar o id da reserva, 
	//com um numero aleatorio de 0 at� 20
>>>>>>> branch-Henrique
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		Random aleatorio = new Random();
		setIdReserva(aleatorio.nextInt(20));
	}

<<<<<<< HEAD
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
=======
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
>>>>>>> branch-Henrique
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

<<<<<<< HEAD
	public void setDataFinal(String dataFinal) {
=======
	public void setDataFinal(Date dataFinal) {
>>>>>>> branch-Henrique
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
