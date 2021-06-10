package hospedagemhotel.entidades;


public class TipoDeQuarto {
	private int id;
    private float valor;
    private String descricao;


    public TipoDeQuarto() {}
    
    public TipoDeQuarto(int id, int valor, String descricao) {
		setId(id);
        setValor(valor);
        setDescricao(descricao);
    }


    //Metodo pra testar na main a gambiarra
    public void setTipoDeQuarto(int tipo) {
    	if(tipo == 1) {
    		setValor(100);
    		setDescricao("Quarto nivel Baixo");
    	} else if(tipo == 1) {
    		setValor(200);
    		setDescricao("Quarto nivel Intermediario");
    	} else {
    		setValor(300);
    		setDescricao("Quarto nivel Alto");
    	}
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
		return "ID: " + getId() + "\nDescrição: " + getDescricao() + "\nValor: R$" + getValor();
	}
   
}
