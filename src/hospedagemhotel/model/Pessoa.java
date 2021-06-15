package hospedagemhotel.model;

import java.util.InputMismatchException;

//Arrumar metodo validarCpf()

public class Pessoa {
	private String nome;
	private String cpf;
	private int telefone;
	public String dataNasc;
	private Endereco endereco;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String cpf, int telefone, String dataNasc, Endereco endereco) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setDataNasc(dataNasc);
		setEndereco(endereco);
	}	

	public Pessoa(String nome, String cpf, int telefone, String dataNasc) {
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

	public String getCpf() {
		return cpf;
	}

	//Autentica a entrada do CPF mas por enquanto nenhuma autenticacao funciona
	public void setCpf(String cpf) {
		/*if(autenticaCPF(cpf)) {
			this.cpf = cpf;
		}
		else {
			System.out.println("O CPF informado não é válido.");
		}*/ 
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	//Por enquanto ta bugadoo
	public boolean autenticaCPF(String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
		|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
		|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
		|| cpf.equals("99999999999") || cpf.equals("00000000000") || (cpf.length() != 11)) 
	return (false);

	char numVer1, numVer2;
	int i, peso, numero, soma, valor;

	try {
		soma = 0;
		peso = 10;
		for (i = 0; i < 9; i++) {
			numero = (int) (cpf.charAt(i)-48);
			soma = soma + (numero * peso);
			peso--;
		}
		soma = soma * 10;

		if (soma % 11 == 10) {
			numVer1 = '0';

		} else {
			valor = soma % 11;
			numVer1 = (char) (valor + 48);
			

		}
		soma = 0;
		peso = 11;
		for(i=0;i<10;i++){
			numero = (int) (cpf.charAt(i)-48);
			soma = soma + (numero * peso);
			peso--;
		}
		valor = 11-(soma%11);
		if(valor == 10||valor ==11) {
			numVer2= '0';
		}
		else {
			numVer2 = (char) (valor + 48);
		}
		
		if(numVer1 == cpf.charAt(9) && numVer2 == cpf.charAt(10)) {
			return true;
		}else {
			return false;
		}
		

	} catch (InputMismatchException erro) {
		return (false);
	}
	}

	public boolean validaCPF(String cpf) {
		String validosCPF = "0123456789";
		
		if (cpf.length() != 11) {
			System.out.println("Quantidade de caracteres informada inválida.");
			return false;
		}
		else {
			for (int i = 0;  i < cpf.length(); i++) {

				String numero = cpf.substring(i, i++);

				if (!validosCPF.contains(numero)) {
					return false;
				}
			}
			// Retorna true se o cpf informado possuí 11 caracteres e todos são números e apenas números de 0 a 9
			System.out.println("CPF válido!");
			return true;
		}
	}
	
	public String toString() {
		return "Nome: " + nome + "\nCPF: " + cpf + "\nTelefone: " + telefone + "\nData de Nascimento: " + dataNasc + "\nEndere�o: \n" + endereco; 
	}
	
}