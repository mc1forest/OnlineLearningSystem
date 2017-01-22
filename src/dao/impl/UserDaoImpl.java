package dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import dao.UserDao;
import domain.User;
import utils.XmlUtils;

public class UserDaoImpl implements UserDao {
	public void add(User user){
		try {
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			
			Element user_tag = root.addElement("user");
			user_tag.setAttributeValue("id", user.getId());
			user_tag.setAttributeValue("username", user.getUsername());
			user_tag.setAttributeValue("password", user.getPassword());
			user_tag.setAttributeValue("email", user.getEmail());
			user_tag.setAttributeValue("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());
			
			XmlUtils.write2Xml(document);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public User find(String username, String password){
		
		try {
			Document document = XmlUtils.getDocument();//Xpath expression
			Element e=(Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
		
			if(e==null) return null;
			
			User user=new User();
			String birthday = e.attributeValue("birthday");
			if(birthday==null||birthday.equals("")){
				user.setBirthday(null);
			}
			else{
				SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
				user.setBirthday(df.parse(birthday));
			}
			
			user.setId(e.attributeValue("id"));
			user.setUsername(e.attributeValue("username"));
			user.setPassword(e.attributeValue("password"));
			user.setEmail(e.attributeValue("email"));
			
		
			return user;
		
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	
	}
	
	public boolean find(String username){
		try {
			Document document = XmlUtils.getDocument();
			Element e=(Element) document.selectSingleNode("//user[@username='"+username+"']");
		
			if(e==null) return false;
			
		
			return true;
		
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
