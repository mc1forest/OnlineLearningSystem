package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import exception.UserExistException;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;
import web.formbean.RegisterForm;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterForm form=WebUtils.request2Bean(request, RegisterForm.class);
		if(!form.validate()){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		User user=new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateId());
		
		BusinessServiceImpl service= new BusinessServiceImpl();
		try {
			service.register(user);
			request.setAttribute("message", "register successfully");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (UserExistException e) {
			form.getErrors().put("username", "Your registered username has existed.");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "Unsure server errors");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
