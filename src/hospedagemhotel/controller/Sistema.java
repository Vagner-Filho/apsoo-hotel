package hospedagemhotel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import hospedagemhotel.model.Endereco;
import hospedagemhotel.model.Hospedagem;
import hospedagemhotel.model.Hospede;
import hospedagemhotel.model.Pessoa;
import hospedagemhotel.model.Quarto;
import hospedagemhotel.model.Reserva;
import hospedagemhotel.model.TipoDeQuarto;
import hospedagemhotel.persistencia.Conexao;

// TODO Voltar o tipo dataNascimento de date para string caso a instanciação com date não der certo

public class Sistema {
	
	Scanner scanner = new Scanner(System.in);
	
	//Ja passei o cpf por parametro, pra nao precisar escrever ele mais uma vez a toa
	// não estamos usando esse método ainda
	public void cadastrarHospede(String cpf) {	
		String cpfParaParametroPessoa = cpf;

		System.out.println("------CADASTRO DE HOSPEDE------");
		System.out.println("Digite os dados do hospede:\n");

		System.out.println("Nome completo: ");
		String nome = scanner.nextLine();
		System.out.println();

		System.out.println("Telefone: ");
		int telefone = scanner.nextInt();

		/*//Metodo para obter data de nascimento
		System.out.println("Informe a data de nascimento: ");
		Date dataNascimento = new Date();
		dataNascimento.setData();*/

		System.out.println("Informe a data de nascimento: ");
		String dataNascimento = scanner.nextLine();
		
		//Metodo para obter o endereco
		System.out.println("Informe o Endereco: \n");
		Endereco endereco = new Endereco();
		endereco.setEndereco();
		
		System.out.println("Sexo: ");
		String sexo = scanner.nextLine();
		System.out.println();

		System.out.println("Codigo da conta:");
		int codigoConta = scanner.nextInt();

		Pessoa pessoa = new Pessoa(nome, cpf, telefone, dataNascimento, endereco);

		System.out.println(nome + telefone + dataNascimento + endereco + sexo + codigoConta);

		Hospede hospede = new Hospede(nome, cpf, telefone, dataNascimento, endereco, sexo, codigoConta);

		// primero tem que inserir um endereco, depois uma pessoa e depois um hospede no bd

		Conexao.alterarBD("INSERT INTO endereco VALUES(" + endereco.getId() + ", '" + endereco.getRua() + "', " + endereco.getNumero() + ", '" + endereco.getBairro() + "', " + endereco.getCep() + ", '" + endereco.getCidade() + "', '" + endereco.getEstado() + "', '" + endereco.getComplemento() + "')");

		Conexao.alterarBD("INSERT INTO pessoa VALUES('" + pessoa.getCpf() + "', " + endereco.getId() + ", '" + pessoa.getNome() + "', '" + pessoa.getDataNasc() + "', '" + pessoa.getTelefone() + "')");

		Conexao.alterarBD("INSERT INTO hospede VALUES('" + hospede.getCpf() + "', '" + hospede.getDataNasc() + "', '" + hospede.getSexo() + "', " + hospede.getCodigoConta() + ")");

	}


	// Esta sem o parametro Funcionario porque acho que seria melhor fazer uma autenticacao - Juliendy
	public void confirmarReserva(String cpf, String dataInicial, String dataFinal, ArrayList<Quarto> quartos) {
		Hospede hos = Conexao.buscarHospede(cpf);
	
		Reserva reserva = new Reserva();

		try {
			Date data = new Date();
			SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
			
			Date dataI = formatar.parse(dataInicial);
			Date dataF = formatar.parse(dataFinal);
			
			if (dataI.after(data) || dataI.equals(data)){
				reserva.setDataInicial(dataInicial);
			}
			else{
				System.out.println("Data invalida, tente novamente");
				return;
			}
			
			if(dataF.after(dataI) || dataF.equals(dataI)){
				reserva.setDataFinal(dataFinal);
			}else{
				System.out.println("Data invalida, tente novamente");
				return;
			}
						
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
		for (Quarto quarto : quartos){
			reserva.setQuarto(quarto);
		}
		
		reserva.setHospede(hos); 

		Conexao.salvarReserva(reserva);
	}
	
	public void confirmarCheckin(Reserva reserva) {
		
		reserva.setCheckin(true);
		
		Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = formatar.format(data);
        reserva.setDataCheckin(dataAtual);
        
        formatar = new SimpleDateFormat("HH:mm:ss");
        String horaAtual = formatar.format(data);
        reserva.setHoraCheckin(horaAtual);
        
        compararDias(reserva);
        
		Hospedagem hospedagem = new Hospedagem();
		hospedagem.setData(reserva.getDataCheckin());
		hospedagem.setHorario(reserva.getHoraCheckin());
		hospedagem.setFuncionario(reserva.getFuncionario());
		hospedagem.setReserva(reserva);
		
		for (int a = 0; a < reserva.getQuarto().size(); a++)
			reserva.getQuarto().get(a).setHospedagem(hospedagem);
		
		reserva.getHospede().setHospedagem(hospedagem);
		
		Conexao.salvarCheckin(hospedagem);
	}
	
	public String cancelarCheckin() {
		return "Check-in nao efetuado";
	}

	public String cancelarReserva() {
		return "Reserva nao efetuada";
	}

	public String msgCpfInvalido() {
		return "CPF Invalido";
	}

	public String msgHospedeNaoCadastrado() {
		return "Cliente nao cadastrado";
	}

	public String msgQuartosIndisponiveis() {
		return "Nao ha quartos disponiveis";
	}
	
	public String msgDiasIguais() {
		return "Esta reserva so pode ser efetuada a partir da sua data de inicio";
	}

	public String msgReservaNaoEncontrada(){
		return "Nenhuma reserva encontrada";
	}


	public TipoDeQuarto[] verTiposDeQuarto() {
		TipoDeQuarto[] tipos = Conexao.verTiposDeQuarto();
		
		return tipos;
	}
	
	public Quarto[] verQuartosDisponiveis(TipoDeQuarto tipoDeQuartoDesejado) {
		Quarto[] listaQuartos = Conexao.verQuartosDisponiveis(tipoDeQuartoDesejado);
		while (listaQuartos == null) {
			System.out.println("Nao ha quartos disponiveis");
			System.out.println("Selecione um tipo de Quarto: [ID]");
			verTiposDeQuarto();
			tipoDeQuartoDesejado.setTipoDeQuarto(scanner.nextInt());
			verQuartosDisponiveis(tipoDeQuartoDesejado);
		}

		return listaQuartos;
	}

	public Hospede buscarHospede(String cpf){
		Hospede hospede = new Hospede();
		hospede = Conexao.buscarHospede(cpf);
		if (hospede == null){
			msgHospedeNaoCadastrado();
			//cadastrarHospede(cpf);
		}else{
			System.out.println("nome" + hospede.getNome());
		}

		return hospede;	
	}
	
	public boolean compararDias(Reserva reserva) {
		try {
		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataInicial = formatar.parse(reserva.getDataInicial());
		Date dataFinal = formatar.parse(reserva.getDataFinal());
		
		if ((data.after(dataInicial) && data.before(dataFinal)) || data.equals(dataInicial))
			return true;
		else
			return false;
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static Reserva[] buscarReservasPorCpf(String cpf){
        Reserva[] reservas = Conexao.buscarReservasPorCpf(cpf);

        return reservas;
    }


	public Reserva buscarReserva(Reserva[] reservas, int idReservaEscolhida) {

		for(int i = 0; i < reservas.length; i++){
			if(reservas[i] != null){
				if(reservas[i].getIdReserva() == idReservaEscolhida){
					return reservas[i];
				}
			}
		}
		
		return null;
	}


	public int numeroAleatorio(){
		Random aleatorio = new Random();
		return aleatorio.nextInt(10);
	}
	
	public boolean validarCPF(String cpf) {
		String validosCPF = "0123456789";
		
		if (cpf.length() != 11) {
			System.out.println("Quantidade de caracteres informada invalida.");
			return false;
		}
		else {
			for (int i = 0;  i < cpf.length(); i++) {

				String numero = cpf.substring(i, i++);

				if (!validosCPF.contains(numero)) {
					return false;
				}
			}
			// Retorna true se o cpf informado possui� 11 caracteres e todos sao numeros e apenas numeros de 0 a 9
			System.out.println("CPF válido!");
			return true;
		}
	}

	
	
}
