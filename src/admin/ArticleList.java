package admin;

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
 * Servlet implementation class ArticleList
 */
@WebServlet("/admin/articlelist")
public class ArticleList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDAOImpl articleImpl = null;
	private Article tmp = null;
	private List<Article> articles = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleList() {
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
		articles = articleImpl.list();
		int totalArticles = articles.size();
		int totalPage =(int) Math.ceil(totalArticles / 8.0);
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));;
		}
		if(page < totalPage) {
			articles = articles.subList((page - 1) * 8, page * 8);
		} else {
			articles = articles.subList((page - 1) * 8, articles.size());
		}
		
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("articles", articles);
		request.setAttribute("totalArticles", totalArticles);
		request.getRequestDispatcher("/admin/articlelist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("susp") != null) {
			tmp = articleImpl.listById(Integer.parseInt(request.getParameter("susp")));
			tmp.setStatus("stop");
			articleImpl.update(tmp);
		} else if (request.getParameter("recv") != null) {
			tmp = articleImpl.listById(Integer.parseInt(request.getParameter("recv")));
			tmp.setStatus("active");
			articleImpl.update(tmp);
		} else if (request.getParameter("del") != null) {
			int id = Integer.parseInt(request.getParameter("del"));
			articleImpl.delete(id);
		} else if (!request.getParameter("search").equals("")) {
			List<Article> articles = articleImpl.search(request.getParameter("search"));
			request.setAttribute("articles", articles);
			request.setAttribute("page", 1);
			request.setAttribute("totalPage", 1);
			request.setAttribute("totalArticles", articles.size());
			request.getRequestDispatcher("/admin/articlelist.jsp").forward(request, response);
		}
	}

}
