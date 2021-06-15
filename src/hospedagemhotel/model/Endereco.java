package hospedagemhotel.model;

import java.util.Random;
import java.util.Scanner;

public class Endereco {
	private int id;
    private String rua, bairro, cidade, estado, complemento;
    private int numero, cep;
    
    Scanner scanner = new Scanner(System.in);

    public Endereco(int id, String rua, String bairro, String cidade, String estado, String complemento, int numero, int cep) {
		setId(id);
        setRua(rua);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
        setComplemento(complemento);
        setNumero(numero);
        setCep(cep);
    }
    
    public Endereco() {}


	public void setEndereco() {
	    System.out.println("Rua: ");
		String rua = scanner.nextLine();
		System.out.println();
	
		System.out.println("Bairro: ");
		String bairro = scanner.nextLine();
		System.out.println();
	
		System.out.println("Cidade: ");
		String cidade = scanner.nextLine();
		System.out.println();
	
		System.out.println("Estado: ");
		String estado = scanner.nextLine();
		System.out.println();
	
		System.out.println("Complemento: ");
		String complemento = scanner.nextLine();
		System.out.println();
	
		System.out.println("Numero: ");
		int numero = scanner.nextInt();
		System.out.println();
		
		System.out.println("Cep: ");
		int cep = scanner.nextInt();
		System.out.println();
		
		Random aleatorio = new Random();
		setId(aleatorio.nextInt(100));
		
		setRua(rua);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		setComplemento(complemento);
		setNumero(numero);
		setCep(cep);
    }
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getCep() {
        return cep;
    }
    
    public String toString() {
		return "Rua: " + rua + "\nBairro: " + bairro + "\nCidade: " + cidade + "\nEstado: " + estado + "\nComplemento: " + complemento + "\nNumero: " + numero + "\nCEP: " + cep; 
    }
}
