package mobile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.impl.MemberDAOImpl;
import jdbc.pojo.Member;

/**
 * Servlet implementation class MobileLogin
 */
@WebServlet("/mobile/login")
public class MobileLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Member member = null;
	MemberDAOImpl memberImpl = null;
	HttpSession session = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	memberImpl = new MemberDAOImpl();
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/mobile/mobile_login.jsp").forward(request, response);
		session = request.getSession();
		session.removeAttribute("member");//每次进入登录界面，移除用户
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		session = request.getSession();
		member = memberImpl.listByUsername(username);
		response.setContentType("text");
		if (member != null && member.getPassword().equals(password) && member.getStatus().equals("active")) {
			response.getWriter().print("yes");
			//验证正确，为 session 添加“用户”属性
			session.setAttribute("member", member);
		} else {
			response.getWriter().print("no");
		}
	}

}
