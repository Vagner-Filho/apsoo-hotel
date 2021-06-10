package hospedagemhotel.entidades;
 
public class Hospede extends Pessoa {
	
	private String sexo;
	private int codigoConta;
	private Hospedagem hospedagem;

	public Hospede(){
		super();
	}
	
	public Hospede(String nome, String cpf, String telefone, Date dataNasc, String sexo, int codigoConta, Hospedagem hospedagem) {
		super(nome, cpf, telefone, dataNasc);
		this.sexo = sexo;
		this.codigoConta = codigoConta;
		this.hospedagem = hospedagem;
	}

	public Hospede(String nome, String cpf, String telefone, Date dataNasc, String sexo, int codigoConta) {
		super(nome, cpf, telefone, dataNasc);
		this.sexo = sexo;
		this.codigoConta = codigoConta;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(int codigoConta) {
		this.codigoConta = codigoConta;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	
	//Arrumar
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	@Override
	public String toString() {
		return "Hospede [codigoConta=" + codigoConta + ", hospedagem=" + hospedagem + ", sexo=" + sexo + "]";
	}



	
}