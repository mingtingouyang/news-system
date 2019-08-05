package mobile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import jdbc.dao.impl.MemberDAOImpl;
import jdbc.dao.impl.RelationDAOImpl;
import jdbc.pojo.Member;
import jdbc.pojo.Relation;

/**
 * Servlet implementation class SearchMember
 */
@WebServlet("/mobile/search")
public class SearchMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAOImpl memberImpl = null;
	private RelationDAOImpl relationImpl = null;
	private List<Member> members = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMember() {
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
		if(request.getParameter("username") != null) { //获取搜索结果
			String username = request.getParameter("username");
			members = memberImpl.search(username);
			request.setAttribute("members", members);
			request.getRequestDispatcher("/mobile/search.jsp").forward(request, response);
		} else if(request.getParameter("add") != null) { //添加好友请求
			String username = request.getParameter("add");
			String myName = ((Member)request.getSession().getAttribute("member")).getUsername();
			Relation myRelation = relationImpl.listByMember(myName);
			JSONArray myFriend = null;
			if (myRelation.getFriends() != null) {
				myFriend = JSON.parseArray(myRelation.getFriends());
			}
			//判断是否已经为好友
			if(myFriend != null && myFriend.contains(username)) {
				response.getWriter().print("no");
			} else {
				//向目标用户添加请求
				response.getWriter().print("yes");
				Relation relation = relationImpl.listByMember(username);
				if(relation.getRequest() == null) {
					List<String> requests = new ArrayList<String>();
					requests.add(myName);
					String jsonString = JSON.toJSONString(requests);
					relation.setRequest(jsonString);
					relationImpl.update(relation);
				}else {
					JSONArray requests = JSON.parseArray(relation.getRequest());
					requests.add(myName);
					String jsonString = JSON.toJSONString(requests);
					relation.setRequest(jsonString);
					relationImpl.update(relation);
				}
			}
		}
	}

}
