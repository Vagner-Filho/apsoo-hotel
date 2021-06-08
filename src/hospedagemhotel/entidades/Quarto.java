package hospedagemhotel.entidades;

import java.util.Scanner;

public class Quarto {
    private int codigoQuarto, localizacao, situacao; //SituaÁ„o 0 n„o est„o usando / SituaÁ„o 1 est„o usando
    private Hospedagem hospedagem;

    Scanner leitor = new Scanner(System.in);
    
    public Quarto(int codigoQuarto) {
    	setCodigoQuarto(codigoQuarto);
    }

    public Quarto(int codigoQuarto, int localizacao, int situacao) {
        setCodigoQuarto(codigoQuarto);
        setLocalizacao(localizacao);
        setSituacao(situacao);
        setHospedagem();
    }

    public void setCodigoQuarto(int codigoQuarto) {
        this.codigoQuarto = codigoQuarto;
    }

    public int getCodigoQuarto() {
        return codigoQuarto;
    }

    public void setLocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }

    public int getLocalizacao() {
        return localizacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public int getSituacao() {
        return situacao;
    }

    // Par√¢metro da fun√ß√£o setSitua√ß√£o pode mudar para atender diferentes situa√ß√µes de um quarto
    public void mudarSituacaoQuarto(Quarto quarto) {
        System.out.println("Informe a nova situa√ß√£o do quarto: ");
        int situacao = leitor.nextInt();
        quarto.setSituacao(situacao);
    }

	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	
	public void setHospedagem() {
		hospedagem = null;
	}
    
	public String toString() {
		return "CÛdigo: " + codigoQuarto + "\nLocalizacao: " + localizacao + 
				"\nSituacao: " + situacao + "\nHospedagem: " + hospedagem; 
	}
    
}
