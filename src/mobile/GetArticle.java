package mobile;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.dao.impl.ArticleDAOImpl;
import jdbc.pojo.Article;

/**
 * Servlet implementation class GetArticle
 */
@WebServlet("/mobile/getarticle")
public class GetArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDAOImpl articleImpl = null;
	private Article article = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetArticle() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		article = articleImpl.listById(id);
		request.setAttribute("article", article);
		request.getRequestDispatcher("/mobile/mobile_article.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
