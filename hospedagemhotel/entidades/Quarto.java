package entidades;

import java.util.Scanner;

public class Quarto {
    private int codigoQuarto, localizacao, situacao;

    Scanner leitor = new Scanner(System.in);

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
}
