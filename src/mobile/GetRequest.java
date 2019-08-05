package mobile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.impl.RelationDAOImpl;
import jdbc.pojo.Member;
import jdbc.pojo.Relation;

/**
 * Servlet implementation class GetRequest
 */
@WebServlet("/mobile/getrequest")
public class GetRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RelationDAOImpl relationImpl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	relationImpl = new RelationDAOImpl();
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String myName = ((Member)session.getAttribute("member")).getUsername();
		Relation relation = relationImpl.listByMember(myName);
		if(relation.getRequest() != null && !relation.getRequest().equals("[]")) {
			response.getWriter().print("yes");
		}else {
			response.getWriter().print("no");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
