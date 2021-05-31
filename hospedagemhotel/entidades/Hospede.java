package entidades;
 
public class Hospede extends Pessoa {
	
	private String sexo;
	private int codigoConta;
	private String hospedagem; // mudar o tipo para Hospedagem
	
	public Hospede(String nome, int cpf, int telefone, Date dataNasc, String sexo, int codigoConta, String hospedagem) {
		super(nome, cpf, telefone, dataNasc);
		this.sexo = sexo;
		this.codigoConta = codigoConta;
		this.hospedagem = hospedagem;
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

	// mudar tipo de retorno para Hospedagem
	public String getHospedagem() {
		return hospedagem;
	}
	
	// mudar tipo do parâmetro do construtor para Hospedagem
	public void setHospedagem(String hospedagem) {
		this.hospedagem = hospedagem;
	}
	
	
	
	
}
