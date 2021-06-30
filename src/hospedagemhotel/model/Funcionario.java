package hospedagemhotel.model;

public class Funcionario extends Pessoa{
	private String login;
	private String senha;
	private float salario;
	private String cargo;

	public Funcionario(){}
	
	public Funcionario(String nome, String cpf, int telefone, String dataNasc, Endereco endereco, String login, String senha, float salario, String cargo) {
		super(nome, cpf, telefone, dataNasc, endereco);
		setLogin(login);
		setSenha(senha);
		setSalario(salario);
		setCargo(cargo);
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "nome="+ getNome()+ "cpf=" + getCpf() + "telefone=" + getTelefone() + "dataNasc=" + getDataNasc() + "endereco=" + getEndereco() + "cargo=" + cargo + ", login=" + login + ", salario=" + salario + ", senha=" + senha ;
	}	

	
	
}