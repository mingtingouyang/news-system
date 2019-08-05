package mobile;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import jdbc.dao.impl.ArticleDAOImpl;
import jdbc.pojo.Article;

/**
 * Servlet implementation class GetNews
 */
@WebServlet("/mobile/getnews")
public class GetNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDAOImpl articleImpl = null;
	private List<Article> articles = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNews() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	articleImpl = new ArticleDAOImpl();
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		articles = articleImpl.list();
		String jsonString = JSON.toJSONString(articles);
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
