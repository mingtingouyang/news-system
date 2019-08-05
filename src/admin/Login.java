package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.impl.UserDAOImpl;
import jdbc.pojo.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/admin/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private User user = null;
    private UserDAOImpl userImpl = null;
    private HttpSession session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		this.getServletContext().getRequestDispatcher("/admin/login.jsp").forward(request, response);
		session = request.getSession();
		session.removeAttribute("user");//每次进入登录界面，移除用户
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user = userImpl.listByUsername(request.getParameter("username"));
		session = request.getSession();
		if(user == null || !(user.getPassword().equals(request.getParameter("password")))) {
			request.setAttribute("status", "登录失败，账户密码错误");
			request.setAttribute("page", "登录");
			request.setAttribute("url", "admin/login");
			request.getRequestDispatcher("/admin/loading.jsp").forward(request, response);
		} else {
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/admin/index");
		}
	}

}
