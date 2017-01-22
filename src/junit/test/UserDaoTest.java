package junit.test;

import java.util.Date;

import org.junit.Test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;

public class UserDaoTest {
	
	@Test
	public void testAdd(){
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("acccccd@sdf.com");
		user.setPassword("234");
		user.setUsername("");
		user.setId("null");
		
		UserDao dao = new UserDaoImpl();
		dao.add(user);
	
	}
	
	@Test
	public void testFind(){
		UserDao dao = new UserDaoImpl();
		//System.out.println(dao.find("Doriss"));
		//System.out.println(dao.find("l","234"));
	}
	
}
