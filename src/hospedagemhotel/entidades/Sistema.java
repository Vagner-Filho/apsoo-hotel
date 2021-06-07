package hospedagemhotel.entidades;

import hospedagemhotel.bd.Conexao;

public class Sistema {

	public String confirmarReserva(String cpf, int diaI, int mesI, int anoI, int diaF, 
			int mesF, int anoF, int codigoQuarto, Funcionario func) {
		String hos = Conexao.buscarHospede(cpf);
		Conexao.buscarQuarto(codigoQuarto);
		Reserva reserva = new Reserva();
		reserva.setDataInicial(diaI, mesI, anoI);
		reserva.setDataFinal(diaF, mesF, anoF);
		reserva.setQuarto(codigoQuarto);
		reserva.setHospede(hos);
		reserva.setFuncionario(func);
		return "Reserva efetuada com sucesso!";
	}
	
	public String msgCpfInvalido() {
		return "CPF Inválido";
	}
	
	public String msgHospedeNaoCadastrado() {
		return "Cliente não cadastrado";
	}
	
	public String msgQuartosIndisponiveis() {
		return "Nao ha quartos disponiveis";
	}

}
