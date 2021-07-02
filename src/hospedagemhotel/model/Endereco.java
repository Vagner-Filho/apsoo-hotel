package hospedagemhotel.model;


public class Endereco {
	private int id;
    private String rua, bairro, cidade, estado, complemento, cep;
    private int numero;
    

    public Endereco(int id, String rua, String bairro, String cidade, String estado, String complemento, int numero, String cep) {
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

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }
    
    public String toString() {
		return "Rua: " + rua + "\nBairro: " + bairro + "\nCidade: " + cidade + "\nEstado: " + estado + "\nComplemento: " + complemento + "\nNumero: " + numero + "\nCEP: " + cep; 
    }
}
