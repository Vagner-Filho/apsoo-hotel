package hospedagemhotel.entidades;

public class Endereco {
    private String rua, bairro, cidade, estado, complemento;
    private int numero, cep;

    public Endereco(String rua, String bairro, String cidade, String estado, String complemento, int numero, int cep) {
        setRua(rua);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
        setComplemento(complemento);
        setNumero(numero);
        setCep(cep);
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
}
