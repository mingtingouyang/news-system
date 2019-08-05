package mobile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import jdbc.dao.impl.MemberDAOImpl;
import jdbc.dao.impl.RelationDAOImpl;
import jdbc.pojo.Member;
import jdbc.pojo.Relation;



/**
 * Servlet implementation class GetUserList
 */
@WebServlet("/mobile/getfriend")
public class GetFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RelationDAOImpl relationImpl = null;
	private MemberDAOImpl memberImpl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFriend() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	relationImpl = new RelationDAOImpl();
    	memberImpl = new MemberDAOImpl();
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String myName = ((Member)session.getAttribute("member")).getUsername();
		Relation relation = relationImpl.listByMember(myName);
		if (relation.getFriends() != null && !relation.getFriends().equals("[]")) {
			JSONArray friends = JSON.parseArray(relation.getFriends());
			List<Member> members = new ArrayList<Member>();
			friends.forEach(obj -> {
				members.add(memberImpl.listByUsername((String)obj));
			});
			String jsonString = JSON.toJSONString(members);
			response.setContentType("text/json");
			response.getWriter().println(jsonString);
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
