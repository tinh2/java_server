package net.ddns.thozz.classproject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/login"}, 
initParams = { 
		@WebInitParam(name="test", value = "1")
})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int failedCount = 1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs;
		String user = request.getParameter("username");
		String password = request.getParameter("pass");
		
		//is the  client behind a proxy or load balancer?
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if(ipAddress == null){
			ipAddress=request.getRemoteAddr();
		}
		System.out.println("Person using login servlet: " + ipAddress);
		
		try {
			UserDao userDao = new UserDaoImpl();
			
			if(userDao.authUser(new User(user,password))){
				rs = getServletContext().getRequestDispatcher("/welcome.jsp");
				request.setAttribute("message", "Welcome " + user + "! You've logged in.");
				rs.forward(request, response);
			}
			else{
				if(failedCount<=3){
					rs = getServletContext().getRequestDispatcher("/login.jsp");
					System.out.println("failed login attempt: " + failedCount + "! please enter username/password");
					failedCount++;
					rs.forward(request, response);	
				}
				else{
					System.out.println("Can no longer try to enter");
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		System.out.println("in loginServlet.destroy()");
		super.destroy();
	}

}
