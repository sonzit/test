package springbook.user.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.dao8.UserDao;
import springbook.user.domain.User;


public class UserDaoTest8 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		User user = new User();
		user.setId("something");
		user.setName("mr.son");
		user.setPassword("something");
		
		//changed point
//		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext2.xml");
//		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		dao.add(user);
		System.out.println("success registration");
		
		User user2 = dao.get("something");
		System.out.println("success search");
		System.out.println(user2);
		
		int result = dao.remove(user2.getId());
		if(result == 0) {
			System.out.println("remove failed");
		}else{
			System.out.println("remove success");
		}
	}
}
