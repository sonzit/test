package springbook.user.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import springbook.user.dao8.UserDao;
import springbook.user.domain.User;

public class UserDaoTest10 {

	private UserDao userDao;
	
	@Before
	public void setup() {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext2.xml");
		userDao = context.getBean("userDao", UserDao.class);
	}
	
//	@Test
//	public void addAndGet() throws SQLException {
//		User user = new User("something", "mr.son", "something");
//		
//		userDao.removeAll();
//		assertEquals(userDao.getCount(), 0);
//		
//		assertTrue(userDao.add(user) != 0);
//		assertEquals(userDao.getCount(), 1);
//		assertEquals(user, userDao.get("something"));
//		
//	}
	
	@Test
	public void addAndGet2() throws SQLException {
		User user1 = new User("user1", "name1", "pass1");
		User user2 = new User("user2", "name2", "pass2");
		User user3 = new User("user3", "name3", "pass3");
		
		userDao.removeAll();
		assertEquals(userDao.getCount(), 0);
		
		userDao.add(user1);
		userDao.add(user2);
		userDao.add(user3);
		
		assertEquals(userDao.get(user1.getId()), user1);
		assertEquals(userDao.get(user2.getId()), user2);
		assertEquals(userDao.get(user3.getId()), user3);
	}
	
	@Test
	public void count() throws SQLException {
		User user1 = new User("user1", "name1", "pass1");
		User user2 = new User("user2", "name2", "pass2");
		User user3 = new User("user3", "name3", "pass3");
		
		userDao.removeAll();
		assertEquals(userDao.getCount(), 0);
		
		userDao.add(user1);
		assertEquals(userDao.getCount(), 1);
		
		userDao.add(user2);
		assertEquals(userDao.getCount(), 2);
		
		userDao.add(user3);
		assertEquals(userDao.getCount(), 3);
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException {
		userDao.removeAll();
		assertEquals(userDao.getCount(), 0);
		
		userDao.get("unknownId");
	}
}
