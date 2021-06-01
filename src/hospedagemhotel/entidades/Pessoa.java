package hospedagemhotel.entidades;

// TODO Implementar método validarCpf()

public class Pessoa {
	private String nome;
	private int cpf;
	private int telefone;
	private Date dataNasc;
	
	public Pessoa(String nome, int cpf, int telefone, Date dataNasc) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setDataNasc(dataNasc);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
}
