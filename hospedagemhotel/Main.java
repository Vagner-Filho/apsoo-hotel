package hospedagemhotel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import bd.Connect;

public class Main {
	
    public static void main(String[] args) {
        System.out.println("Oi, gente");

		Connect conexao = new Connect();
		System.out.println(conexao.connect());
		

		
    }
}
