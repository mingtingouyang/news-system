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
 * Servlet implementation class RequestList
 */
@WebServlet("/mobile/requestlist")
public class RequestList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RelationDAOImpl relationImpl = null;
	private MemberDAOImpl memberImpl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestList() {
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
		JSONArray requests = JSON.parseArray(relation.getRequest());
		List<Member> members = new ArrayList<Member>();
		requests.forEach(obj -> {
			members.add(memberImpl.listByUsername((String)obj));
		});
		request.setAttribute("requests", members);
		request.getRequestDispatcher("/mobile/request.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("confirm");
		String myName = ((Member)request.getSession().getAttribute("member")).getUsername();
		//给对方添加好友
		Relation userRelation = relationImpl.listByMember(userName);
		if (userRelation.getFriends() != null && !userRelation.getFriends().equals("[]")) {
			JSONArray userFriend = JSON.parseArray(userRelation.getFriends());
			userFriend.add(myName);
			String userString = JSON.toJSONString(userFriend);
			userRelation.setFriends(userString);
			relationImpl.update(userRelation);
		} else {
			List<String> userFriend= new ArrayList<String>();
			userFriend.add(myName);
			String userString = JSON.toJSONString(userFriend);
			userRelation.setFriends(userString);
			relationImpl.update(userRelation);
		}
		
		//给自己添加好友
		Relation myRelation = relationImpl.listByMember(myName);
		if (myRelation.getFriends() != null && !myRelation.getFriends().equals("[]")) {
			JSONArray myFriend = JSON.parseArray(myRelation.getFriends());
			myFriend.add(userName);
			String myString = JSON.toJSONString(myFriend);
			myRelation.setFriends(myString);
			//移除request
			JSONArray myRequest = JSON.parseArray(myRelation.getRequest());
			myRequest.remove(userName);
			String requestsString = JSON.toJSONString(myRequest);
			myRelation.setRequest(requestsString);
			relationImpl.update(myRelation);
		} else {
			List<String> myFriend = new ArrayList<String>();
			myFriend.add(userName);
			String myString = JSON.toJSONString(myFriend);
			myRelation.setFriends(myString);
			//移除request
			JSONArray myRequest = JSON.parseArray(myRelation.getRequest());
			myRequest.remove(userName);
			String requestsString = JSON.toJSONString(myRequest);
			myRelation.setRequest(requestsString);
			relationImpl.update(myRelation);
		}
	}

}
