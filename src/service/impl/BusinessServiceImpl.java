package service.impl;


import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import exception.UserExistException;
import utils.ServiceUtils;

public class BusinessServiceImpl {

	
	private UserDao dao=new UserDaoImpl();
	
	public void register(User user) throws UserExistException{
		boolean b=dao.find(user.getUsername());
		if(b){
			throw new UserExistException();
			
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
	}
	
	public User login(String username, String password){
		
		password=ServiceUtils.md5(password);
		
		return dao.find(username, password);
	}
}
