package springbook.user.test;

import java.sql.SQLException;

import springbook.user.dao5.UserDao;
import springbook.user.dao5.DConnectionMaker;
import springbook.user.domain.User;

public class UserDaoTest5 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		User user = new User();
		user.setId("something");
		user.setName("mr.son");
		user.setPassword("something");
		
		//changed point
		UserDao dao = new UserDao(new DConnectionMaker());
		
		dao.add(user);
		System.out.println("등록 성공");
		User user2 = dao.get("something");
		System.out.println("조회 성공");
		System.out.println(user2);
	}
}
