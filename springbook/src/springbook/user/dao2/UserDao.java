/**
 * 상속을 통해서 커넥션부분만 분리
 * 템플릿 패턴 또는 팩토리 메서드 패턴
 */

package springbook.user.dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public abstract class UserDao {
	private Connection con;
	
	public abstract Connection getConnection() throws ClassNotFoundException, SQLException ;
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String id = "java";
//		String pass = "java";
//		con = DriverManager.getConnection(url, id, pass);
		
//	}
	
	//add
	public void add(User user) throws ClassNotFoundException, SQLException {
		getConnection();
		PreparedStatement ps = con.prepareStatement("insert into users (id, password, name) values (?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getName());
		ps.execute();
		ps.close();
		con.close();
		
	}
	
	//get
	public User get(String id) throws ClassNotFoundException, SQLException {
		getConnection();
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
}
