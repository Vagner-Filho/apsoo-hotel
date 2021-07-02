package hospedagemhotel.model;

import java.util.Scanner;

public class Quarto {
    private int codigoQuarto, situacao; //Situa��o 0 n�o est�o usando / Situa��o 1 est�o usando
    private Hospedagem hospedagem;
	private String localizacao; 
	private TipoDeQuarto tipoDeQuarto;

	public Quarto(){}

    public Quarto(int codigoQuarto, String localizacao, int situacao) {
        setCodigoQuarto(codigoQuarto);
        setLocalizacao(localizacao);
        setSituacao(situacao);
    }

    public void setCodigoQuarto(int codigoQuarto) {
        this.codigoQuarto = codigoQuarto;
    }

    public int getCodigoQuarto() {
        return codigoQuarto;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    
    public Hospedagem getHospedagem() {
		return hospedagem;
	}
	
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

    public int getSituacao() {
        return situacao;
    }
    
    public TipoDeQuarto getTipoDeQuarto() {
		return tipoDeQuarto;
	}

	public void setTipoDeQuarto(TipoDeQuarto tipoDeQuarto) {
		this.tipoDeQuarto = tipoDeQuarto;
	}

    // Parametro da funcao setSituacao pode mudar para atender diferentes situacoes de um quarto
    public void mudarSituacaoQuarto(Quarto quarto) {
    	Scanner leitor = new Scanner(System.in);
    	
        System.out.println("Informe a nova situacao do quarto: ");
        int situacao = leitor.nextInt();
        quarto.setSituacao(situacao);
        
        leitor.close();
    }
    
	public String toString() {
		String sit = "";
		if(getSituacao() == 0){
			sit = "Disponivel";
		}else if(getSituacao() == 1){
			sit = "Indisponivel";
		}

		return "CodQuarto: " + codigoQuarto +  " Localização: " + getLocalizacao() + "-Situação: " + sit + "Tipo de quarto: " + tipoDeQuarto;


	}
    
}
