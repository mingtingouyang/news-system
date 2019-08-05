package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.dao.impl.UserDAOImpl;
import jdbc.pojo.User;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/admin/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user = null;
	private UserDAOImpl userImpl = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	userImpl = new UserDAOImpl();
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/admin/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(userImpl.listByUsername(username) == null) {
			user = new User(username, password);
			userImpl.signUp(user);
			request.setAttribute("status", "注册成功！");
			request.setAttribute("page", "注册");
			request.setAttribute("url", "admin/signup");//跳转到登录界面
			request.getRequestDispatcher("/admin/loading.jsp").forward(request, response);
		}else {
			request.setAttribute("status", "注册失败，用户名已存在");
			request.setAttribute("page", "注册");
			request.setAttribute("url", "admin/signup");//跳转到注册界面
			request.getRequestDispatcher("/admin/loading.jsp").forward(request, response);
		}
		
	}
}
