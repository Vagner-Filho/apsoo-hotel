package hospedagemhotel.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import hospedagemhotel.model.Endereco;
import hospedagemhotel.model.Funcionario;
import hospedagemhotel.model.Hospede;
import hospedagemhotel.model.Quarto;
import hospedagemhotel.model.Reserva;
import hospedagemhotel.model.TipoDeQuarto;

// TODO add not null no atributo funcionario na criacao da tabela reserva

public class Conexao{

	private static Connection conexao;

	public static boolean conectar(){
		try{
			String url = "jdbc:sqlite:database.db";
			conexao = DriverManager.getConnection(url);
			return true;
		}catch(SQLException e){
			System.err.println("conectar: " + e.getMessage());
			return false;
		}
		
	}

	public static boolean desconectar(){
		try {
			if(conexao.isClosed() == false){
				conexao.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}

		return true;
	}

	public static Connection getConexao(){
		try{
			if(conexao == null){
				conectar();
			}
			if(conexao.isClosed()){
				conectar();
			}
		}catch(SQLException e){
			System.err.println("getConexao" + " " + e.getMessage());
		}
		
		return conexao;
		
	}

	/**
	 * Esse método Inicializa o Banco de dados
	 * A primeira vez que a main for executada, ela vai chamar esse método e um arquivo 'database.db'
	 * será criado e, consequentemente, as tabelas vão ser criadas e eu coloquei alguns dados fixos para serem inseridos.
	 * 
	 */
	public static void InitBD(){
		try {

			// recupera a conxão com o bd
			conexao = getConexao();
			// cria um statement (não sei o que é, mas precisa dele para executar as querys kkkkkk)
			Statement stm = conexao.createStatement();

			//stm.executeUpdate("DROP TABLE IF EXISTS pessoa");
			stm.executeUpdate("CREATE TABLE pessoa (" + 
				"cpf varchar (11) NOT NULL PRIMARY KEY," +
				"pes_end integer NOT NULL," +
				"nome varchar (255) NOT NULL," +
				"dataNasc varchar (10)," +
				"foreign key (pes_end) references endereco(idEnd));");

			//stm.executeUpdate("DROP TABLE IF EXISTS funcionario");
			stm.executeUpdate("CREATE TABLE funcionario (" + 		
				"fcpf varchar (11) NOT NULL primary key," +
				"login varchar (255) NOT NULL," +
				"senha varchar (15) NOT NULL," +
				"salario decimal (10) NOT NULL," +
				"cargo varchar (255) NOT NULL," +
				"FOREIGN KEY (fcpf) REFERENCES pessoa(cpf))");

			//stm.executeUpdate("DROP TABLE IF EXISTS hospede");
			stm.executeUpdate("CREATE TABLE hospede (" + 			
				"hcpf varchar (11) NOT NULL primary key," +
				"sexo char (1)," +
				"codigoConta integer NOT NULL," +
				"FOREIGN KEY (hcpf) REFERENCES pessoa(cpf))");

			//stm.executeUpdate("DROP TABLE IF EXISTS p_telefone");
			stm.executeUpdate("CREATE TABLE p_telefone (" + 		
				"pcpf varchar (255) NOT NULL primary key," +
				"num_telefone varchar (11)," +
				"FOREIGN KEY (pcpf) REFERENCES pessoa(cpf))");

			//stm.executeUpdate("DROP TABLE IF EXISTS reserva");
			stm.executeUpdate("CREATE TABLE reserva (" + 			
				"idRes integer NOT NULL primary key," +
				"fcpf varchar (255)," +
				"res_hos integer NOT NULL," +
				"dataInicial varchar(10)," +
				"dataFinal varchar(10)," +
				"pagamento varchar (255)," +
				"checkin boolean," +
				"dataCheckin varchar(10)," +
				"horaCheckin varchar(10)," + 
				"FOREIGN KEY (fcpf) REFERENCES funcionario (fcpf)," +
				"FOREIGN KEY (res_hos) REFERENCES hospede(hcpf))");

			//stm.executeUpdate("DROP TABLE IF EXISTS reservaQuarto");
			stm.executeUpdate("CREATE TABLE reservaQuarto (" + 		
				"idRes integer NOT NULL," +
				"codigoQuarto integer NOT NULL primary key," +
				"FOREIGN KEY (idRes) REFERENCES reserva(idRes)," +
				"FOREIGN KEY (codigoQuarto) REFERENCES quarto(codigoQuarto))" 
				);

			//stm.executeUpdate("DROP TABLE IF EXISTS quarto");
			stm.executeUpdate("CREATE TABLE quarto (" + 			
				"codigoQuarto integer NOT NULL primary key," +
				"qua_tip_quarto qua_tip_quarto integer NOT NULL," +
				"qua_hospedagem integer NOT NULL," +
				"localizacao varchar(5)," +
				"situacao integer," +
				"FOREIGN KEY (qua_hospedagem) REFERENCES hospedagem(idHospedagem)," + 
				"FOREIGN KEY (qua_tip_quarto) REFERENCES tipoDeQuarto(idTipQuarto))"
				);
			
			//stm.executeUpdate("DROP TABLE IF EXISTS hospedagem");
			stm.executeUpdate("CREATE TABLE hospedagem (" + 		
				"idHospedagem integer NOT NULL primary key," +
				"idRes integer NOT NULL," +
				"fcpf varchar (11) NOT NULL," +
				"hcpf varchar (11) NOT NULL," + 
				"hdata date," + 
				"horario time," + 
				"FOREIGN KEY (fcpf) REFERENCES funcionario(fcpf)," + 
				"FOREIGN KEY (hos_res) REFERENCES reserva(idRes)," +
				"FOREIGN KEY (hcpf) REFERENCES hospede(hcpf))"
				);

			//stm.executeUpdate("DROP TABLE IF EXISTS endereco");
			stm.executeUpdate("CREATE TABLE endereco (" + 			
				"idEnd integer NOT NULL primary key," +
				"rua varchar (255)," +
				"numero integer (4)," +
				"bairro varchar (255)," +
				"cep varchar (8) NOT NULL," + 
				"cidade varchar (255)," +
				"estado char (2)," +
				"complemento varchar (500))"
				);
			
			//stm.executeUpdate("DROP TABLE IF EXISTS tipoDeQuarto");
			stm.executeUpdate("CREATE TABLE tipoDeQuarto (" + 		
				"idTipQuarto integer NOT NULL primary key," +
				"valor integer," +
				"descricao varchar (500))" 
				);

			//stm.executeUpdate("DROP TABLE IF EXISTS itemServico");
			stm.executeUpdate("CREATE TABLE itemServico (" + 		
				"item_ser_hospedagem integer NOT NULL," +
				"idTipSer integer NOT NULL primary key," +
				"tipo varchar (255)," + 
				"valor integer," +
				"descricao varchar (255)," +
				"FOREIGN KEY (item_ser_hospedagem) REFERENCES hospedagem(idHospedagem))"
				);
			
			//stm.executeUpdate("DROP TABLE IF EXISTS servico");
			stm.executeUpdate("CREATE TABLE servico (" + 			
				"codigo integer NOT NULL primary key," +
				"ser_tip_ser integer NOT NULL," +
				"FOREIGN KEY (ser_tip_ser) REFERENCES itemServico(idTipSer))"
				);
				
			// insere um endereço no bd
			stm.executeUpdate("INSERT INTO endereco VALUES(1, 'Rua 123', 2200, 'Vilas Boas', 12345678, 'Campo Grande', 'MS', 'Casa 1')");

			//insere uma pessoa 
			stm.executeUpdate("INSERT INTO pessoa VALUES('06451237894', 1, 'Maria', '2000-02-15')");
			stm.executeUpdate("INSERT INTO pessoa VALUES('45865201424', 1, 'Marta', '2000-10-20')");

			// insere uma pessoa 
			stm.executeUpdate("INSERT INTO pessoa VALUES('23556987451', 1, 'João', '1950-03-30')");
			
			// insere um funcionario
			stm.executeUpdate("INSERT INTO funcionario VALUES('23556987451', 'joao123', '1234', 1200, 'Recepcionista')");

			// insere uma reserva
			stm.executeUpdate("INSERT INTO reserva VALUES(1, '23556987451', '06451237894', '2021-02-03', '2021-02-05', 'Dinheiro', null, null, null)");

			stm.executeUpdate("INSERT INTO reserva VALUES(2, '23556987451', '06451237894', '2021-02-14', '2021-02-30', 'Dinheiro', null, null, null)");

			// insere um hospede
			stm.executeUpdate("INSERT INTO hospede VALUES( '06451237894', 'F', 12)");
			stm.executeUpdate("INSERT INTO hospede VALUES( '45865201424', 'F', 15)");


			//insere um tipoDeQuarto
			stm.executeUpdate("insert into tipoDeQuarto values(1, 500, 'Suite')");
			stm.executeUpdate("insert into tipoDeQuarto values(2, 100, 'Comum')");
			stm.executeUpdate("insert into tipoDeQuarto values(3, 150, 'Intermediária')");

			// insere uma hospedagem
			stm.executeUpdate("insert into hospedagem values(1, 1, '23556987451', '06451237894', '2021-02-17', '15:00:02')");

			//insere um quarto
			stm.executeUpdate("insert into quarto values(1, 1, 1, 12, 0)");
			stm.executeUpdate("insert into quarto values(2, 1, 1, 15, 0)");
			stm.executeUpdate("insert into quarto values(3, 1, 1, 20, 0)");

			//associa um quarto a uma reserva
			stm.executeUpdate("INSERT INTO reservaQuarto VALUES(1, 1)");

			stm.executeUpdate("INSERT INTO reservaQuarto VALUES(2, 2)");
			stm.executeUpdate("INSERT INTO reservaQuarto VALUES(2, 3)");

			
		} catch (SQLException e) {
			System.err.println("initBD" + " " + e.getMessage());
		}
	}

	/**
	 * Esse método faz qualquer alteração no BD, basta passar uma string (query) com as instruções em SQL
	 * Retorna um objeto do tipo ResultSet, por ele é possível acessar os valores retornados caso seja uma query de consulta
	 */
	public static void alterarBD(String query){
		try {
			conexao = getConexao();
			Statement stm = conexao.createStatement();

			stm.executeUpdate(query);
			

		} catch (SQLException e) {
			System.err.println(e.getMessage());	
		}
		
	}

	/**
	 * Busca um hóspede no BD pelo cpf e, se o hóspede existir, retorna um objeto do tipo Hospede. Se ele nao existir no bd ele retorna null
	 * Retorna um hospede sem o atributo 'hospedagem'
	 */
	public static Hospede buscarHospede(String cpf){
		
		Hospede hospede = new Hospede();
		try{
			String query = "select * from hospede join pessoa on '" + cpf + "' = pessoa.cpf";
			String query2 = "select * from endereco where idEnd in (select pes_end from pessoa where '" + cpf + "' = pessoa.cpf)";
			
			conexao = getConexao();
			Statement stm = conexao.createStatement();
			Statement atm = conexao.createStatement();

			ResultSet rs = stm.executeQuery(query);
			ResultSet ru = atm.executeQuery(query2);
			
			while(rs.next()) {
			
				hospede.setNome(rs.getString("nome"));
				hospede.setCpf(rs.getString("cpf"));
				//hospede.setTelefone(rs.getInt("telefone"));
				hospede.setDataNasc(rs.getString("dataNasc"));
				hospede.setSexo(rs.getString("sexo"));
				hospede.setCodigoConta(rs.getInt("codigoConta"));
				Endereco endereco = new Endereco(ru.getInt("idEnd"), ru.getString("rua"), ru.getString("bairro"), ru.getString("cidade"), 
						ru.getString("estado"), ru.getString("complemento"), ru.getInt("numero"), ru.getInt("cep"));
				hospede.setEndereco(endereco);

			}
			//System.out.println(stm.executeQuery(query).getString("nome"));
			return hospede;
			
			
			
		}catch(SQLException e){
			System.out.println("buscarHospede " + e.getMessage());
			return null;
		}
		
		
	}
	
	/**
	 * Busca um quarto no BD pelo codigo do quarto e, se o quarto existir, retorna um objeto do tipo Quarto. Se ele nao existir no bd ele retorna null
	 * Retorna um quarto sem o atributo 'hospedagem'
	 */
	public static Quarto buscarQuarto(int codigoQuarto){
		Quarto quarto = new Quarto();
		try{

			String query = "select * from quarto where " + codigoQuarto + " = quarto.codigoQuarto";
			conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while(rs.next()) {
				quarto.setCodigoQuarto(rs.getInt("codigoQuarto"));
				quarto.setLocalizacao(rs.getString("localizacao"));
				quarto.setSituacao(rs.getInt("situacao"));
			}
			return quarto;
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return null;
		}
	
		
	}

	/**
	 * Retorna um array de objetos do tipo tipoDeQuarto que são os tipos de quartos que existem 
	 */
	public static TipoDeQuarto[] verTiposDeQuarto(){
		
		TipoDeQuarto tipos[] = new TipoDeQuarto[100];
		int qtdDeTipQuartos = 0;
		try{

			String query = "select * from tipoDeQuarto";
			
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			
			while(rs.next()) {
				TipoDeQuarto tipoDeQuarto = new TipoDeQuarto();
				
				tipoDeQuarto.setId(rs.getInt("idTipQuarto"));
				tipoDeQuarto.setValor(rs.getInt("valor"));
				tipoDeQuarto.setDescricao(rs.getString("descricao"));

				tipos[qtdDeTipQuartos] = tipoDeQuarto;
				qtdDeTipQuartos++;
			}
			
			return tipos;
			
		}catch(SQLException e){
			System.out.println("con_verTipos " + e.getMessage());
			return null;
		}
	}

	/**
	 * Retorna um array de objetos do tipo Quarto que são os quartos disponiveis de acordo com o TIPO DE QUARTO	passado como parametro
	 */
	public static Quarto[] verQuartosDisponiveis(TipoDeQuarto tipoDeQuartoDesejado) {
		
		Quarto[] quartos = new Quarto[100];
		int qtdDeQuartos = 0;
		try{

			String query = "select * from quarto join tipoDeQuarto on qua_tip_quarto = " + tipoDeQuartoDesejado.getId() + " and situacao = 0";
			
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while(rs.next()) {
				Quarto quarto = new Quarto();
				
				quarto.setCodigoQuarto(rs.getInt("codigoQuarto"));
				quarto.setLocalizacao(rs.getString("localizacao"));
				quarto.setSituacao(rs.getInt("situacao"));
				quarto.setTipoDeQuarto(tipoDeQuartoDesejado);

				quartos[qtdDeQuartos] = quarto;
				qtdDeQuartos++;
			}
			
			return quartos;
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	

	//ARRUMAR / Se pa ta arrumado agora kakakaka
	public static void salvarReserva(Reserva reserva){

		try{
			//insere a reserva no banco de dados
			String query = "insert into reserva values(" + reserva.getIdReserva() + ", '23556987451', '" + reserva.getHospede().getCpf() + "', '" + reserva.getDataInicial() + "', '" + reserva.getDataFinal() + "', null, null, null, null)";

			alterarBD(query);

			// altera a situacao do quarto
			for (int a = 0; a < reserva.getQuarto().size(); a++) {
				query = "update quarto set situacao = 1 where codigoQuarto = " + reserva.getQuarto().get(a).getCodigoQuarto();
				alterarBD(query);
			}

			System.out.print("Reserva efetuada com sucesso!");
		} catch(Error e){
			System.out.println("Não foi possível cadastrar a reserva.");
		}

	}


	/**
	 * Busca todas as reservas relacionadas ao cpf passado como parametro e retorna um array com essas reservas
	 */
	public static Reserva[] buscarReservasPorCpf(String cpf){

		Reserva[] reservas = new Reserva[100];
		int qtdDeReservas = 0;

		try {

			Statement stm = conexao.createStatement();

			// recupera tudo da tabela reserva de acordo com o cpf passado
			String query = "select * from reserva where res_hos = '" + cpf + "'";

			ResultSet rs1 = stm.executeQuery(query);
			
			// recupera tudo de funcionario e pessoa de acordo com o cpf do funcionario responsavel pelas reservas recuperadas
			query = "select * from funcionario join pessoa on fcpf = cpf where fcpf in (select fcpf from reserva where fcpf = '" + rs1.getString("fcpf") + "')";
			
			ResultSet rs2 = conexao.createStatement().executeQuery(query);
			
			Funcionario funcionario = criaFuncionario(rs2);

			Hospede hospede = buscarHospede(cpf);

			// percorre cada reserva recuperada 
			while(rs1.next()) {

				// falta recuperar o tipo de quarto de cada quarto recuperado

				Reserva reserva = new Reserva();

				// recupera os quartos da reserva recuperada 
				query = "select * from quarto where codigoQuarto in (select codigoQuarto from reservaQuarto where reservaQuarto.idRes = " + rs1.getInt("idRes") + ")";

				ResultSet rs3 = conexao.createStatement().executeQuery(query);
				
				// percorre cada quarto recuperado e cria um instancia de Quarto e o adiciona ao array de quartos do objeto reserva
				while (rs3.next()) {
					Quarto quarto = new Quarto();
					quarto.setCodigoQuarto(rs3.getInt("codigoQuarto"));
					quarto.setSituacao(rs3.getInt("situacao"));
					quarto.setLocalizacao(rs3.getString("localizacao"));
					reserva.setQuarto(quarto);
				}
	
				reserva.setIdReserva(rs1.getInt("idRes"));
				reserva.setHospede(hospede);
				reserva.setFuncionario(funcionario);
				reserva.setDataInicial(rs1.getString("dataInicial"));
				reserva.setDataFinal(rs1.getString("dataFinal"));
				reserva.setPagamento(rs1.getString("pagamento"));
				reserva.setCheckin(rs1.getBoolean("checkin"));
				reserva.setDataCheckin(rs1.getString("dataCheckin"));
				reserva.setHoraCheckin(rs1.getString("horaCHeckin"));
				//System.out.println(reserva);

				reservas[qtdDeReservas] = reserva;
				
				qtdDeReservas++;
				
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		
		return reservas;
	}
	

	/**
	 * Cria e retorna uma instância de Funcionario com os dados que foram recuperados do BD
	 */
	public static Funcionario criaFuncionario(ResultSet rs){
		Funcionario funcionario = new Funcionario();

		try{
			funcionario.setNome(rs.getString("nome"));
			funcionario.setCpf(rs.getString("cpf"));
			funcionario.setDataNasc(rs.getString("dataNasc"));
			funcionario.setLogin(rs.getString("login"));
			funcionario.setSenha(rs.getString("senha"));
			funcionario.setCargo(rs.getString("cargo"));
			funcionario.setSalario(rs.getFloat("salario"));
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return funcionario;
	}

}