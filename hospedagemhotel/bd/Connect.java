package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect{

	private Connection conn;

	public boolean connect(){
		try{
			String url = "jdbc:sqlite:database.db";
			this.conn = DriverManager.getConnection(url);
			return true;
		}catch(SQLException e){
			System.err.println(e.getMessage());
			return false;
		}
		
	}

	public boolean desconnect(){
		try {
			if(this.conn.isClosed() == false){
				this.conn.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}

		return true;
	}

	

}