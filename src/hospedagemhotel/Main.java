package hospedagemhotel;

import java.awt.EventQueue;

import hospedagemhotel.model.Reserva;
import hospedagemhotel.persistencia.Conexao;
import hospedagemhotel.view.realizarCheckin;
import hospedagemhotel.view.realizarReserva;
import hospedagemhotel.view.telaMenu;

public class main {

	public static void main(String[] args) {

		Conexao.InitBD();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaMenu frame = new telaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// Conexao.buscarReservasPorCpf("6451237894");

		/*
		 * Scanner scanner = new Scanner(System.in);
		 * 
		 * Sistema sistema = new Sistema();
		 * 
		 * Conexao.InitBD();
		 * 
		 * System.out.println("------TELA DE REALIZAR RESERVA-------");
		 * System.out.println("Indique o cpf do cliente: ");
		 * 
		 * String cpf = scanner.nextLine();
		 * 
		 * 
		 * /*Boolean valido = sistema.autenticaCPF(cpf); System.out.println();
		 * 
		 * while (valido != true) { sistema.msgCpfInvalido();
		 * System.out.println("Indique o cpf do cliente: ");
		 * 
		 * cpf = scanner.nextLine(); System.out.println();
		 * 
		 * //valido = sistema.autenticaCPF(cpf); System.out.println(); }
		 * 
		 * 
		 * sistema.buscarHospede(cpf);
		 * 
		 * 
		 * 
		 * /* DEIXAR DESSA FORMA SE FOR DECIDIDO QUE AS DATAS SERÃO DO TIPO DATE Date
		 * dataInicial = new Date(); Date dataFinal = new Date();
		 * 
		 * 
		 * System.out.println("Qual a data de Entrada?"); dataInicial.setData();
		 * 
		 * System.out.println("Qual a data de Saida?"); dataFinal.setData();
		 * 
		 * 
		 * // DEIXAR DESSA FORMA SE FOR DECIDIDO QUE AS DATAS SERÃO DO TIPO STRING
		 * System.out.println("Qual a data de Entrada: "); String dataInicial =
		 * scanner.nextLine();
		 * 
		 * System.out.println("Qual a data de Saída: "); String dataFinal =
		 * scanner.nextLine();
		 * 
		 * System.out.println("Selecione um tipo de Quarto:"); TipoDeQuarto[] tipos =
		 * sistema.verTiposDeQuarto(); int idTipoDesejado = scanner.nextInt();
		 * scanner.nextLine();
		 * 
		 * TipoDeQuarto tipoDeQuartoDesejado = new TipoDeQuarto(); for (TipoDeQuarto
		 * tipoDeQuarto : tipos) { if(tipoDeQuarto.getId() == idTipoDesejado){
		 * tipoDeQuartoDesejado.setId(tipoDeQuarto.getId());
		 * tipoDeQuartoDesejado.setValor(tipoDeQuarto.getValor());
		 * tipoDeQuartoDesejado.setDescricao(tipoDeQuarto.getDescricao()); } }
		 * 
		 * System.out.println("Selecione um Quarto:"); Quarto[] quartos =
		 * sistema.verQuartosDisponiveis(tipoDeQuartoDesejado); int codQuartoDesejado =
		 * scanner.nextInt(); scanner.nextLine();
		 * 
		 * Quarto quartoDesejado = new Quarto(); for (Quarto quarto : quartos) {
		 * if(quarto.getCodigoQuarto() == codQuartoDesejado){
		 * quartoDesejado.setCodigoQuarto(quarto.getCodigoQuarto());
		 * quartoDesejado.setLocalizacao(quarto.getLocalizacao());
		 * quartoDesejado.setSituacao(quarto.getSituacao());
		 * quarto.setTipoDeQuarto(quarto.getTipoDeQuarto()); } }
		 * 
		 * 
		 * 
		 * sistema.confirmarReserva(cpf, dataInicial, dataFinal, quartoDesejado);
		 * 
		 * 
		 * 
		 * 
		 * scanner.close();
		 */
	}
}
