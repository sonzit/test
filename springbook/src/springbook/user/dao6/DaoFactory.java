package springbook.user.dao6;

import springbook.user.dao6.UserDao;

public class DaoFactory {
	
	public UserDao userDao() {
		ConnectionMaker cm = new DConnectionMaker();
		return new UserDao(cm);
	}
}