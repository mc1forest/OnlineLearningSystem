package junit.test;

import java.util.Date;

import org.junit.Test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import exception.UserExistException;
import service.impl.BusinessServiceImpl;

public class ServiceTest {
	@Test
	public void testRegister(){
		User user = new User();
		user.setBirthday(new Date(1978,9,9));
		user.setEmail("aaaa@sdf.com");
		user.setPassword("234");
		user.setUsername("orsis");
		user.setId("null");
		
		BusinessServiceImpl service =new BusinessServiceImpl();
		try {
			service.register(user);
			System.out.println("register successfully!");
		} catch (UserExistException e) {
			
			System.out.println("user already exists!");
		}
		System.out.println(0000);
	}
	
	
	@Test
	public void testLogin(){
		BusinessServiceImpl service =new BusinessServiceImpl();
		System.out.println(service.login("Dorsis", "234"));
	}
}
