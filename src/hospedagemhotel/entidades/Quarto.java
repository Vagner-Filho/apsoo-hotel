package hospedagemhotel.entidades;

import java.util.Scanner;

public class Quarto {
    private int codigoQuarto, localizacao, situacao; //Situa��o 0 n�o est�o usando / Situa��o 1 est�o usando
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

    // Parâmetro da função setSituação pode mudar para atender diferentes situações de um quarto
    public void mudarSituacaoQuarto(Quarto quarto) {
        System.out.println("Informe a nova situação do quarto: ");
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
		return "C�digo: " + codigoQuarto + "\nLocalizacao: " + localizacao + 
				"\nSituacao: " + situacao + "\nHospedagem: " + hospedagem; 
	}
    
}
