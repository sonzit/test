package springbook.user.dao3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

	//get connection
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java";
		String pass = "java";
		return DriverManager.getConnection(url, id, pass);
	}

}
