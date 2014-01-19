/**
 * 커넥?��?분을 ?�립?�인 ?�래?�로 만듬
 */
package springbook.user.dao8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;

import springbook.user.domain.User;

public class UserDao {
	
	private DataSource dataSource;
	
	public UserDao() {
	}
	
	
	
	public UserDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}



	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public int add(User user) throws  SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into users (id, password, name) values (?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getName());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}
	
	public User get(String id) throws SQLException  {
		User user = null;
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}else{
			throw new EmptyResultDataAccessException(1);
		}
		rs.close();
		ps.close();
		con.close();
		return user;
	}
	
	public int remove(String id) throws  SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from users where id = ?");
		ps.setString(1, id);
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}

	public int removeAll() throws  SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from users");
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}
	
	public int getCount() throws SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("select count(*) from users");
		ResultSet rs = ps.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		ps.close();
		con.close();
		return result;
	}

}
