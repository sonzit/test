/**
 * 커넥?��?분을 ?�립?�인 ?�래?�로 만듬
 */
package springbook.user.dao7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
	
	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker cm) {
		this.connectionMaker = cm;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection con = connectionMaker.makeNewConnection();
		PreparedStatement ps = con.prepareStatement("insert into users (id, password, name) values (?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getName());
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection con = connectionMaker.makeNewConnection();
		PreparedStatement ps = con.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		rs.close();
		ps.close();
		con.close();
		return user;
	}
	
	public int remove(String id) throws ClassNotFoundException, SQLException {
		Connection con = connectionMaker.makeNewConnection();
		PreparedStatement ps = con.prepareStatement("delete from users where id = ?");
		ps.setString(1, id);
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}

}
