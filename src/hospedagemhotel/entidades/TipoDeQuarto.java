package hospedagemhotel.entidades;

public class TipoDeQuarto {
    private float valor;
    private String descricao;
    private Quarto quarto; //Tem que ser uma lista de quartos

    public TipoDeQuarto(float valor, String descricao, Quarto quarto) {
        setValor(valor);
        setDescricao(descricao);
        setQuarto(quarto);
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

	public Quarto getQuarto() {
		return quarto;
	}
	
	//Arrumar
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
    
	//Arrumar
	public void verTiposDeQuarto() {
		System.out.print("Tipo 1: \n" + "Valor: 100\n" + "Descrição: Quarto nível Baixo" + 
		"Quarto 1234");
		System.out.print("Tipo 2: \n" + "Valor: 200\n" + "Descrição: Quarto nível Médio" + 
		"Quarto 3456");
		System.out.print("Tipo 3: \n" + "Valor: 300\n" + "Descrição: Quarto nível Alto" + 
		"Quarto 5678");
	}
	
	//Arrumar
	public Quarto verQuartosDisponiveis(int diaI, int mesI, int anoI, int diaF, int mesF, 
			int anoF, TipoDeQuarto tipoDeQuartoDesejado) {
		if (tipoDeQuartoDesejado.quarto.getSituacao() == 0) {
			return quarto;
		}
		return null;
	}
	
	
}
	
	
	
	
