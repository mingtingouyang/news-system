package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.dao.impl.MemberDAOImpl;
import jdbc.pojo.Member;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/admin/memberlist")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAOImpl memberImpl = null;
	private Member tmp = null;
	private List<Member> members = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberList() {
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
		members = memberImpl.list();
		int totalMembers = members.size();
		int totalPage =(int) Math.ceil(totalMembers / 8.0);
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));;
		}
		if(page < totalPage) {
			members = members.subList((page - 1) * 8, page * 8);
		} else {
			members = members.subList((page - 1) * 8, members.size());
		}
		
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("members", members);
		request.setAttribute("totalMembers", totalMembers);
		request.getRequestDispatcher("/admin/memberlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("susp") != null) {
			tmp = memberImpl.listByUsername(request.getParameter("susp"));
			tmp.setStatus("stop");
			memberImpl.update(tmp);
		} else if (request.getParameter("recv") != null) {
			tmp = memberImpl.listByUsername(request.getParameter("recv"));
			tmp.setStatus("active");
			memberImpl.update(tmp);
		} else if (request.getParameter("del") != null) {
			String username = request.getParameter("del");
			memberImpl.delete(username);
		} else if (!request.getParameter("search").equals("")) {
			List<Member> members = memberImpl.search(request.getParameter("search"));
			request.setAttribute("members", members);
			request.setAttribute("page", 1);
			request.setAttribute("totalPage", 1);
			request.setAttribute("totalMembers", members.size());
			request.getRequestDispatcher("/admin/memberlist.jsp").forward(request, response);
		}
	}

}
