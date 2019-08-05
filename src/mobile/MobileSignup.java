package mobile;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.dao.impl.MemberDAOImpl;
import jdbc.dao.impl.RelationDAOImpl;
import jdbc.pojo.Member;
import jdbc.pojo.Relation;

/**
 * Servlet implementation class MobileSignup
 */
@WebServlet("/mobile/signup")
public class MobileSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Member member = null;
	private MemberDAOImpl memberImpl = null;
    private RelationDAOImpl relationImpl = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileSignup() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	memberImpl = new MemberDAOImpl();
    	relationImpl = new RelationDAOImpl();
    	super.init();
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		member = memberImpl.listByUsername(username);
		response.setContentType("text");
		if (member == null) {
			response.getWriter().print("yes");
			Calendar cal = Calendar.getInstance();
			String time = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
			Member member = new Member(username, password, time);
			memberImpl.signUp(member);
			relationImpl.insert(new Relation(username, "", ""));
		} else {
			response.getWriter().print("no");
		}
	}

}
