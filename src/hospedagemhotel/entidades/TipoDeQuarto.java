package hospedagemhotel.entidades;

import java.util.ArrayList;

public class TipoDeQuarto {
    private int valor;
    private String descricao;
    private ArrayList<Quarto> quartos = new ArrayList();

    public TipoDeQuarto(int valor, String descricao) {
        setValor(valor);
        setDescricao(descricao);
    }
    
    public TipoDeQuarto(int valor, String descricao, Quarto quarto1, Quarto quarto2) {
        setValor(valor);
        setDescricao(descricao);
        setQuarto(quarto1, quarto2);
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

	public String getQuarto() {
		return quartos.toString();
	}

	public void setQuarto(Quarto quarto1, Quarto quarto2) {
		quartos.add(quarto1);
		quartos.add(quarto2);
	}
    
	//FALTA FAZER ESSE METODO
	public String verQuartosDisponiveis(Date Inicial, Date Final, TipoDeQuarto tipoDeQuartoDesejado) {
		if (tipoDeQuartoDesejado.quartos.get(0).getHospedagem().getReserva().dataInicial != Inicial || 
			tipoDeQuartoDesejado.quartos.get(0).getHospedagem().getReserva().dataFinal != Final	) {
			return quartos.toString();
		}
		else 
			return "Não há quartos disponíveis";
	}
}
