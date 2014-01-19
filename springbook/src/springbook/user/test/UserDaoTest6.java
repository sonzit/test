package springbook.user.test;

import java.sql.SQLException;

import springbook.user.dao6.DaoFactory;
import springbook.user.dao6.UserDao;
import springbook.user.domain.User;

public class UserDaoTest6 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		User user = new User();
		user.setId("something");
		user.setName("mr.son");
		user.setPassword("something");
		
		//changed point
		UserDao dao = new DaoFactory().userDao();
		
		dao.add(user);
		System.out.println("등록 성공");
		User user2 = dao.get("something");
		System.out.println("조회 성공");
		System.out.println(user2);
	}
}
