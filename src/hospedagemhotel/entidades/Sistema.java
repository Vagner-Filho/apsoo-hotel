package hospedagemhotel.entidades;

import hospedagemhotel.bd.Conexao;

public class Sistema {
	
	//Alterei o retorno e o tipo do metodo
	public Reserva confirmarReserva(String cpf, Date dataInicial, Date dataFinal, Quarto quarto, Funcionario funcionario1) {
		String hos = Conexao.buscarHospede(cpf);
		Conexao.buscarQuarto(quarto.getCodigoQuarto());
		Reserva reserva = new Reserva();
		reserva.setDataInicial(dataInicial);
		reserva.setDataFinal(dataFinal);
		reserva.setQuarto(quarto);
		reserva.setHospede(hos); //Arrumar aqui e na classe Hospede para trazer um Hospede e não um String
		reserva.setFuncionario(funcionario1);
		System.out.print("Reserva efetuada com sucesso!");
		return reserva;
	}
	
	public String cancelarReserva() {
		return "Reserva não efetuada";
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
	
	//Retirei esse metodo da classe TipoDeQuarto e trouxe pra ca
	public void verTiposDeQuarto(TipoDeQuarto tipoDeQuarto1, TipoDeQuarto tipoDeQuarto2, TipoDeQuarto tipoDeQuarto3) {
		System.out.println("Valor: " + tipoDeQuarto1.getValor());
		System.out.println("Descrição: " +  tipoDeQuarto1.getDescricao());
		System.out.println("Quartos: " + tipoDeQuarto1.getQuarto());
		System.out.println("Valor: " + tipoDeQuarto2.getValor());
		System.out.println("Descrição: " +  tipoDeQuarto2.getDescricao());
		System.out.println("Quartos: " + tipoDeQuarto2.getQuarto());
		System.out.println("Valor: " + tipoDeQuarto3.getValor());
		System.out.println("Descrição: " +  tipoDeQuarto3.getDescricao());
		System.out.println("Quartos: " + tipoDeQuarto3.getQuarto());
	}

}