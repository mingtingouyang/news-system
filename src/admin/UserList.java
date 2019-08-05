package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.dao.impl.UserDAOImpl;
import jdbc.pojo.User;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/admin/userlist")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userImpl = null;
	private User tmp = null;
	private List<User> users = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
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
		users = userImpl.list();
		int totalUsers = users.size();
		int totalPage =(int) Math.ceil(totalUsers / 8.0);
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));;
		}
		if(page < totalPage) {
			users = users.subList((page - 1) * 8, page * 8);
		} else {
			users = users.subList((page - 1) * 8, users.size());
		}
		
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("users", users);
		request.setAttribute("totalUsers", totalUsers);
		request.getRequestDispatcher("/admin/userlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("susp") != null) {
			tmp = userImpl.listByUsername(request.getParameter("susp"));
			tmp.setPermission("normal");
			userImpl.update(tmp);
		} else if (request.getParameter("recv") != null) {
			tmp = userImpl.listByUsername(request.getParameter("recv"));
			tmp.setPermission("admin");
			userImpl.update(tmp);
		} else if (request.getParameter("del") != null) {
			String username = request.getParameter("del");
			userImpl.delete(username);
		} else if (!request.getParameter("search").equals("")) {
			List<User> users = userImpl.search(request.getParameter("search"));
			request.setAttribute("users", users);
			request.setAttribute("page", 1);
			request.setAttribute("totalPage", 1);
			request.setAttribute("totalUsers", users.size());
			request.getRequestDispatcher("/admin/userlist.jsp").forward(request, response);
		}
	}

}
