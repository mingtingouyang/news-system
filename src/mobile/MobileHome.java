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
 * Servlet implementation class MobileHome
 */
@WebServlet("/mobile/home")
public class MobileHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAOImpl memberImpl = null;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileHome() {
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
		//每次访问从数据更新session里面存储的对象
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		member = memberImpl.listByUsername(member.getUsername());
		session.setAttribute("member", member);
		request.getRequestDispatcher("/mobile/mobile_index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
