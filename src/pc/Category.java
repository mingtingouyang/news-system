package pc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.dao.impl.ArticleDAOImpl;
import jdbc.pojo.Article;

/**
 * Servlet implementation class Category
 */
@WebServlet("/category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDAOImpl articleImpl = null;
	private List<Article> articles = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Category() {
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
		String category = new String(request.getParameter("c").getBytes("ISO-8859-1"),"utf-8");
		articles = articleImpl.listCategory(category);
		//分页
		int totalArticle = articles.size();
		int totalPage =(int) Math.ceil(totalArticle / 5.0);
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));;
		}
		if(page < totalPage) {
			articles = articles.subList((page - 1) * 5, page * 5);
		} else {
			articles = articles.subList((page - 1) * 5, articles.size());
		}
		
		request.setAttribute("category", category);
		request.setAttribute("articles", articles);
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		
		request.getRequestDispatcher("/category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
