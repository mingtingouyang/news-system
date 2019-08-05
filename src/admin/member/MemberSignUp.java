package admin.member;

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
 * Servlet implementation class MemberSignUp
 */
@WebServlet("/admin/member/signup")
public class MemberSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAOImpl memberImpl = null;
	private RelationDAOImpl relationImpl = null;
	private Member member = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSignUp() {
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
		request.getRequestDispatcher("/admin/member/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Calendar cal = Calendar.getInstance();
		String time = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
		if(memberImpl.listByUsername(username) == null) {
			member = new Member(username, password, time);
			memberImpl.signUp(member);
			relationImpl.insert(new Relation(username, "", ""));
			request.setAttribute("status", "注册成功！");
			request.setAttribute("page", "注册");
			request.setAttribute("url", "admin/member/signup");//跳转到登录界面
			request.getRequestDispatcher("/admin/loading.jsp").forward(request, response);
		}else {
			request.setAttribute("status", "注册失败，用户名已存在");
			request.setAttribute("page", "注册");
			request.setAttribute("url", "admin/member/signup");//跳转到注册界面
			request.getRequestDispatcher("/admin/loading.jsp").forward(request, response);
		}
	}

}
