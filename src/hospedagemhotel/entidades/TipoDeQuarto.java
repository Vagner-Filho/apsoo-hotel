package hospedagemhotel.entidades;

public class TipoDeQuarto {
	private int id;
    private float valor;
    private String descricao;

	public TipoDeQuarto(){

	}

    public TipoDeQuarto(float valor, String descricao, Quarto quarto) {
        setValor(valor);
        setDescricao(descricao);
    }

	public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

	@Override
	public String toString() {
		return "TipoDeQuarto [descricao=" + descricao + ", id=" + id + ", valor=" + valor + "]";
	}

    
	

}