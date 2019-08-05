package mobile;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import jdbc.dao.impl.CommentDAOImpl;
import jdbc.pojo.Comment;

/**
 * Servlet implementation class GetComment
 */
@WebServlet("/mobile/getcomment")
public class GetComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDAOImpl commentImpl = null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetComment() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {	
    	commentImpl = new CommentDAOImpl();
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer articleid = Integer.parseInt(request.getParameter("id"));
		List<Comment> comments = commentImpl.list(articleid);
		String jsonString = JSON.toJSONString(comments);
		response.setContentType("text/json");
		response.getWriter().print(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
