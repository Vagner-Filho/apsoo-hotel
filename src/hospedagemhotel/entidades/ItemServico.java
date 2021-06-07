package hospedagemhotel.entidades;

public class ItemServico {
    private String tipo, descricao;
    private float valor;
    
    public ItemServico(String tipo,  float valor, String descricao) {
		setTipo(tipo);
		setValor(valor);
		setDescricao(descricao);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
