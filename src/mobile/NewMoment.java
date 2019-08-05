package mobile;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import jdbc.dao.impl.MomentDAOImpl;
import jdbc.pojo.Member;
import jdbc.pojo.Moment;

/**
 * Servlet implementation class NewMoment
 */
@WebServlet("/mobile/newmoment")
public class NewMoment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MomentDAOImpl momentImpl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewMoment() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	momentImpl = new MomentDAOImpl();
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
		Member member = (Member)request.getSession().getAttribute("member");
		String content = request.getParameter("content");
		String author = member.getUsername();
		String authorimg = member.getUserimg();
		//获取时间
		Calendar cal = Calendar.getInstance();
		String time = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
		//数据库插入数据
		momentImpl.insert(new Moment(author, content, time, authorimg));
		//发送json数据回去用于插入元素
		String[] info = {author, authorimg};
		String jsonString = JSON.toJSONString(info);
		
		response.setContentType("text/json");
		response.getWriter().println(jsonString);
	}

}
