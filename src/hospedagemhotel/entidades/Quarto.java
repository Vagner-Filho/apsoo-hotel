package hospedagemhotel.entidades;

import java.util.Scanner;

public class Quarto {
    private int codigoQuarto, localizacao, situacao;
    private TipoDeQuarto tipoDeQuarto;

    Scanner leitor = new Scanner(System.in);

    public Quarto(int codigoQuarto, int localizacao, int situacao, TipoDeQuarto tipoDeQuarto) {
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

    public void setTipoDeQuarto(TipoDeQuarto tipoDeQuarto) {
        this.tipoDeQuarto = tipoDeQuarto;
    }

    public TipoDeQuarto getTipoDeQuarto() {
        return tipoDeQuarto;
    }

    // Parâmetro da função setSituação pode mudar para atender diferentes situações de um quarto
    public void mudarSituacaoQuarto(Quarto quarto) {
        System.out.println("Informe a nova situação do quarto: ");
        int situacao = leitor.nextInt();
        quarto.setSituacao(situacao);
    }
}
