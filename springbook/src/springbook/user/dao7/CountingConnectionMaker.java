package springbook.user.dao7;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker {

	private int counter;
	private ConnectionMaker realCm;
	
	public CountingConnectionMaker(ConnectionMaker realCm) {
		this.realCm = realCm;
	}
	
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
		counter++;
		return realCm.makeNewConnection();
	}
	
	public int getCounter() {
		return counter;
	}

}
