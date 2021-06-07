package hospedagemhotel.entidades;

import hospedagemhotel.bd.Conexao;

public class Sistema {

	public String confirmarReserva(String cpf, int diaI, int mesI, int anoI, int diaF, int mesF, int anoF, Quarto quartoEscolhido, Funcionario func) {
		Conexao.buscarHospede(cpf);
		return "Reserva efetuada com sucesso!";
	}
	
	public String msgCpfInvalido() {
		return "CPF Inv�lido";
	}
	
	public String msgHospedeNaoCadastrado() {
		return "Cliente n�o cadastrado";
	}
	
	public String msgQuartosIndisponiveis() {
		return "Nao ha quartos disponiveis";
	}

}
