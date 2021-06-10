package hospedagemhotel.entidades;

public class Funcionario extends Pessoa{
	private String login;
	private String senha;
	private float salario;
	private String cargo;
	
<<<<<<< HEAD
	public Funcionario(String nome, String cpf, String telefone, Date dataNasc, String login, String senha, float salario, String cargo) {
		super(nome, cpf, telefone, dataNasc);
=======
	public Funcionario(String nome, String cpf, int telefone, Date dataNasc, Endereco endereco, String login, String senha, float salario, String cargo) {
		super(nome, cpf, telefone, dataNasc, endereco);
>>>>>>> branch-Henrique
		setLogin(login);
		setSenha(senha);
		setSalario(salario);
		setCargo(cargo);
	}

	public Funcionario(String nome) {
		super(nome);
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
	
}