package hospedagemhotel.entidades;
 
public class Hospede extends Pessoa {
	
	private String sexo;
	private int codigoConta;
	private Hospedagem hospedagem;
	
	
	public Hospede(String nome, String cpf, int telefone, Date dataNasc, 
			Endereco endereco, String sexo, int codigoConta) {
		super(nome, cpf, telefone, dataNasc, endereco);
		setSexo(sexo);
		setCodigoConta(codigoConta);
	}
	

	public Hospede() {
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
	
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}	

}