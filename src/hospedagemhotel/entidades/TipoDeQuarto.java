package hospedagemhotel.entidades;

import java.util.ArrayList;

public class TipoDeQuarto {
	private int id;
<<<<<<< HEAD
    private float valor;
    private String descricao;

	public TipoDeQuarto(){

	}
=======
    private int valor;
    private String descricao;
>>>>>>> branch-Henrique

    public TipoDeQuarto() {}
    
    public TipoDeQuarto(int valor, String descricao) {
        setValor(valor);
        setDescricao(descricao);
<<<<<<< HEAD
    }

	public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
=======
>>>>>>> branch-Henrique
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
    
    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
<<<<<<< HEAD

	@Override
	public String toString() {
		return "TipoDeQuarto [descricao=" + descricao + ", id=" + id + ", valor=" + valor + "]";
	}

    
	

}
=======
   
}
>>>>>>> branch-Henrique
