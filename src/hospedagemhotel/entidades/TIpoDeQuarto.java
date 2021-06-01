public class TipoDeQuarto {
    private float valor;
    private String descricao;

    public TIpoDeQuarto(float valor, String descricao) {
        setValor(valor);
        setDescricao(descricao);
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
}
