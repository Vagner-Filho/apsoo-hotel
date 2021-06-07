package hospedagemhotel.entidades;
 
public class Hospede extends Pessoa {
	
	private String sexo;
	private int codigoConta;
	private Hospedagem hospedagem;
	
	public Hospede(String nome, String cpf, int telefone, int dia, int mes, int ano, 
			String rua, String bairro, String cidade, String estado, String complemento, 
			int numero, int cep, String sexo, int codigoConta, Hospedagem hospedagem) {
		super(nome, cpf, telefone, dia, mes, ano, rua, bairro, cidade, estado, complemento, numero, cep);
		setSexo(sexo);
		setCodigoConta(codigoConta);
		setHospedagem(hospedagem);
	}

	public Hospede(String nome, String cpf, int telefone, int dia, int mes, int ano, String rua, String bairro, String cidade, String estado, String complemento, int numero, int cep, String sexo, int codigoConta) {
		super(nome, cpf, telefone, dia, mes, ano, rua, bairro, cidade, estado, complemento, numero, cep);
		setSexo(sexo);
		setCodigoConta(codigoConta);
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