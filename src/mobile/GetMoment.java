package mobile;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import jdbc.dao.impl.MomentDAOImpl;
import jdbc.dao.impl.RelationDAOImpl;
import jdbc.pojo.Member;
import jdbc.pojo.Moment;

/**
 * Servlet implementation class GetMoment
 */
@WebServlet("/mobile/getmoment")
public class GetMoment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RelationDAOImpl realationImpl = null;
	private MomentDAOImpl momentImpl = null;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMoment() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	realationImpl = new RelationDAOImpl();
    	momentImpl = new MomentDAOImpl();
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member)request.getSession().getAttribute("member");
		String myName = member.getUsername();
		JSONArray myFriend = JSON.parseArray(realationImpl.listByMember(myName).getFriends());
		myFriend.add(myName);
		List<Moment> moments = momentImpl.listByAuthor(myFriend);
		String jsonString = JSON.toJSONString(moments);
		response.setContentType("text/json");
		response.getWriter().println(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
