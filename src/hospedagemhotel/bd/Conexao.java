package hospedagemhotel.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexao{

	private static Connection conexao;

	public static boolean conectar(){
		try{
			String url = "jdbc:sqlite:database.db";
			conexao = DriverManager.getConnection(url);
			return true;
		}catch(SQLException e){
			System.err.println(e.getMessage());
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

			stm.executeUpdate("DROP TABLE IF EXISTS pessoa");
			stm.executeUpdate("CREATE TABLE pessoa (" + 
				"cpf varchar (11) NOT NULL PRIMARY KEY," +
				"pes_end integer NOT NULL," +
				"nome varchar (255) NOT NULL," +
				"dataNasc date," +
				"telefone varchar(15)," +
				"foreign key (pes_end) references endereco(idEnd));");

			stm.executeUpdate("DROP TABLE IF EXISTS funcionario");
			stm.executeUpdate("CREATE TABLE funcionario (" + 		
				"fcpf varchar (11) NOT NULL primary key," +
				"login varchar (255) NOT NULL," +
				"senha varchar (15) NOT NULL," +
				"salario decimal (10) NOT NULL," +
				"cargo varchar (255) NOT NULL," +
				"FOREIGN KEY (fcpf) REFERENCES pessoa(cpf))");

			stm.executeUpdate("DROP TABLE IF EXISTS hospede");
			stm.executeUpdate("CREATE TABLE hospede (" + 			
				"hcpf varchar (11) NOT NULL primary key," +
				"hos_res integer NOT NULL," +
				"sexo char (1)," +
				"codigoConta integer NOT NULL," +
				"FOREIGN KEY (hcpf) REFERENCES pessoa(cpf)," +
				"FOREIGN KEY (hos_res) REFERENCES reserva(idRes))");

			stm.executeUpdate("DROP TABLE IF EXISTS p_telefone");
			stm.executeUpdate("CREATE TABLE p_telefone (" + 		
				"pcpf varchar (255) NOT NULL primary key," +
				"num_telefone varchar (11)," +
				"FOREIGN KEY (pcpf) REFERENCES pessoa(cpf))");

			stm.executeUpdate("DROP TABLE IF EXISTS reserva");
			stm.executeUpdate("CREATE TABLE reserva (" + 			
				"idRes integer NOT NULL primary key," +
				"fcpf varchar (255) NOT NULL," +
				"dataInicial date," +
				"dataFinal date," +
				"pagamento varchar (255)," + 
				"FOREIGN KEY (fcpf) REFERENCES funcionario (fcpf))"
				);

			stm.executeUpdate("DROP TABLE IF EXISTS reservaQuarto");
			stm.executeUpdate("CREATE TABLE reservaQuarto (" + 		
				"idRes integer NOT NULL," +
				"codigoQuarto integer NOT NULL primary key," +
				"FOREIGN KEY (idRes) REFERENCES reserva(idRes)," +
				"FOREIGN KEY (codigoQuarto) REFERENCES quarto(codigoQuarto))" 
				);

			stm.executeUpdate("DROP TABLE IF EXISTS quarto");
			stm.executeUpdate("CREATE TABLE quarto (" + 			
				"codigoQuarto integer NOT NULL primary key," +
				"qua_tip_quarto qua_tip_quarto integer NOT NULL," +
				"qua_hospedagem integer NOT NULL," +
				"localizao varchar (255)," +
				"situacao varchar (255)," +
				"FOREIGN KEY (qua_hospedagem) REFERENCES hospedagem(idHospedagem)," + 
				"FOREIGN KEY (qua_tip_quarto) REFERENCES tipoDeQuarto(idTipQuarto))"
				);
			
			stm.executeUpdate("DROP TABLE IF EXISTS hospedagem");
			stm.executeUpdate("CREATE TABLE hospedagem (" + 		
				"idHospedagem integer NOT NULL primary key," +
				"hos_res integer NOT NULL," +
				"fcpf varchar (11) NOT NULL," +
				"hcpf varchar (11) NOT NULL," + 
				"hdata date," + 
				"horario time," + 
				"FOREIGN KEY (fcpf) REFERENCES funcionario(fcpf)," + 
				"FOREIGN KEY (hos_res) REFERENCES reserva(idRes)," +
				"FOREIGN KEY (hcpf) REFERENCES hospede(hcpf))"
				);

			stm.executeUpdate("DROP TABLE IF EXISTS endereco");
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
			
			stm.executeUpdate("DROP TABLE IF EXISTS tipoDeQuarto");
			stm.executeUpdate("CREATE TABLE tipoDeQuarto (" + 		
				"idTipQuarto integer NOT NULL primary key," +
				"valor integer," +
				"descricao varchar (500))" 
				);

			stm.executeUpdate("DROP TABLE IF EXISTS itemServico");
			stm.executeUpdate("CREATE TABLE itemServico (" + 		
				"item_ser_hospedagem integer NOT NULL," +
				"idTipSer integer NOT NULL primary key," +
				"tipo varchar (255)," + 
				"valor integer," +
				"descricao varchar (255)," +
				"FOREIGN KEY (item_ser_hospedagem) REFERENCES hospedagem(idHospedagem))"
				);
			
			stm.executeUpdate("DROP TABLE IF EXISTS servico");
			stm.executeUpdate("CREATE TABLE servico (" + 			
				"codigo integer NOT NULL primary key," +
				"ser_tip_ser integer NOT NULL," +
				"FOREIGN KEY (ser_tip_ser) REFERENCES itemServico(idTipSer))"
				);

			// insere um endereço no bd
			stm.executeUpdate("INSERT INTO endereco VALUES(1, 'Rua 123', 2200, 'Vilas Boas', 12345678, 'Campo Grande', 'MS', 'Casa 1')");

			//insere uma pessoa 
			stm.executeUpdate("INSERT INTO pessoa VALUES('12345678910', 1, 'Maria', '2000-02-15', '55555-8888')");

			// insere uma pessoa 
			stm.executeUpdate("INSERT INTO pessoa VALUES('23556987451', 1, 'João', '1950-03-30', '65489-2354')");
			
			// insere um funcionario
			stm.executeUpdate("INSERT INTO funcionario VALUES('23556987451', 'joao123', '1234', 1200, 'Recepcionista')");

			// insere uma reserva
			stm.executeUpdate("INSERT INTO reserva VALUES(1, '23556987451', '2021-02-03', '2021-02-05', 'Dinheiro')");

			// insere um hospede
			stm.executeUpdate("INSERT INTO hospede VALUES( '12345678910', 1, 'F', 12)");


			stm.close();
			//System.out.println("FUNCIONA");

		} catch (SQLException e) {
			System.err.println("initBD" + " " + e.getMessage());
		}
	}

	/**
	 * Esse método faz qualquer alteração no BD, basta passar uma string (query) com as instruções em SQL
	 */
	public static void alterarBD(String query){
		try {
			conexao = getConexao();
			Statement stm = conexao.createStatement();

			stm.executeUpdate(query);
			stm.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		

	}

	/**
	 * Busca um hóspede no BD pelo cpf e, se o hóspede existir, retorna o nome dele. Se ele nã existir no bd ele retorna null
	 */
	public static String buscarHospede(String cpf){
		try{
			String query = "select nome from hospede join pessoa on " + cpf + " = pessoa.cpf";
			conexao = getConexao();
			Statement stm = conexao.createStatement();
			String nomeHospede = stm.executeQuery(query).getString("nome");
			return nomeHospede;
			
		}catch(SQLException e){
			return null;
		}
		
		
	}
	
	public static String buscarQuarto(int codigoQuarto){
		try{
			String query = "select codigoQuarto from quarto on " + codigoQuarto + " = quarto.codigoQuarto";
			conexao = getConexao();
			Statement stm = conexao.createStatement();
			return stm.executeQuery(query).getString("codigoQuarto");
			
		}catch(SQLException e){
			return null;
		}
	
	
	}
	
}