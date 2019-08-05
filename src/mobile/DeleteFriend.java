package mobile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import jdbc.dao.impl.RelationDAOImpl;
import jdbc.pojo.Member;
import jdbc.pojo.Relation;

/**
 * Servlet implementation class DeleteFriend
 */
@WebServlet("/mobile/delete")
public class DeleteFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RelationDAOImpl relationImpl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFriend() {
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("del");
		String myName = ((Member)request.getSession().getAttribute("member")).getUsername();
		//给对方删除好友
		Relation userRelation = relationImpl.listByMember(userName);
		JSONArray userFriend = JSON.parseArray(userRelation.getFriends());
		userFriend.remove(myName);
		String userString = JSON.toJSONString(userFriend);
		userRelation.setFriends(userString);
		relationImpl.update(userRelation);
		//给自己删除好友
		Relation myRelation = relationImpl.listByMember(myName);
		JSONArray myFriend = JSON.parseArray(myRelation.getFriends());
		myFriend.remove(userName);
		String myString = JSON.toJSONString(myFriend);
		myRelation.setFriends(myString);
		relationImpl.update(myRelation);
	}

}
