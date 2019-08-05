package admin.article;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jdbc.dao.impl.ArticleDAOImpl;
import jdbc.pojo.Article;

/**
 * Servlet implementation class ArticleEdit
 */
@MultipartConfig
@WebServlet("/admin/article/edit")
public class ArticleEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Article article = null;
	private ArticleDAOImpl articleImpl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleEdit() {
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
			Integer id = Integer.parseInt(request.getParameter("edit"));
			article = articleImpl.listById(id);
			request.setAttribute("article", article);
			request.getRequestDispatcher("/admin/article/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
		String time = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		String content = request.getParameter("content");
		String img = null;
		
		Article tmp = articleImpl.listById(id);
		String status = tmp.getStatus();
		
		Part articleImg = request.getPart("img");//获得图像文件
		
		if(articleImg.getSize() == 0) {  //判断用户是否上传头像，如果没有上传，则用用户当前头像作为参数
			img = tmp.getImg();
		} else {
			//下面两步获得文件后缀名
			String tmpStr = articleImg.getHeader("content-disposition").split("[.]")[1];
			String type = "." + tmpStr.substring(0, tmpStr.length() - 1);   //后缀名
			
			img = "" + id + new Date().getTime() + type;  //本地文件名为用户id加上传时的时间戳
			articleImg.write(request.getServletContext().getRealPath("articleimg") + "/" + img); //前面部分用于获得  articleimg 目录的真实路径
		}
		articleImpl.update(new Article(id, title, author, category, content, img, time, status));
		request.setAttribute("status", "修改成功");
		request.setAttribute("page", "文章编辑");
		request.setAttribute("url", "admin/article/edit?edit=" + article.getId());//更改后，跳转至对应文章的修改页面
		request.getRequestDispatcher("/admin/loading.jsp").forward(request, response);
	}

}
