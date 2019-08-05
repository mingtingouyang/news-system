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
 * Servlet implementation class Index
 */
@WebServlet("/admin/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session = null;
	private UserDAOImpl userImpl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
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
		//每次刷新页面，刷新 session 的用户
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		user = userImpl.listByUsername(user.getUsername());
		session.setAttribute("user", user);
		
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
