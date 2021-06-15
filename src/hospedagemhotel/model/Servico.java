package hospedagemhotel.model;

public class Servico {
    private int codigo;
    private ItemServico itemServico;
    
    public Servico(int codigo, String tipo, float valor, String descricao) {
		setCodigo(codigo);
		setItemServico(tipo, valor, descricao);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public ItemServico getItemServico() {
		return itemServico;
	}
	public void setItemServico(String tipo, float valor, String descricao) {
		itemServico = new ItemServico(tipo, valor, descricao);
	}
}
