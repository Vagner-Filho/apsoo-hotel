package hospedagemhotel.entidades;

import java.util.ArrayList;

public class TipoDeQuarto {
	private int id;
    private int valor;
    private String descricao;

    public TipoDeQuarto() {}
    
    public TipoDeQuarto(int valor, String descricao) {
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
   
}
