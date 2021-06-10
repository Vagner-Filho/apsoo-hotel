package hospedagemhotel.entidades;

import java.util.Scanner;

public class Quarto {
    private int codigoQuarto, localizacao, situacao; //Situação 0 não estão usando / Situação 1 estão usando
    private Hospedagem hospedagem;
    private TipoDeQuarto tipoDeQuarto;

    public Quarto() {
		
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

    // Parametro da funcao setSituacao pode mudar para atender diferentes situacoes de um quarto
    public void mudarSituacaoQuarto(Quarto quarto) {
    	Scanner leitor = new Scanner(System.in);
    	
        System.out.println("Informe a nova situacao do quarto: ");
        int situacao = leitor.nextInt();
        quarto.setSituacao(situacao);
        
        leitor.close();
    }

	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	
	public void setHospedagem() {
		hospedagem = null;
	}
    
	public String toString() {
		return "Codigo: " + codigoQuarto + "\nLocalizacao: " + localizacao + 
				"\nSituacao: " + situacao + "\nHospedagem: " + hospedagem; 
	}
    
}
