package admin.echarts;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.dao.impl.VisitedNumDAOImpl;
import jdbc.pojo.VisitedNum;

/**
 * Servlet implementation class Pie
 */
@WebServlet("/admin/echarts/pie")
public class Pie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VisitedNumDAOImpl visitImpl = null;
	List<VisitedNum> objs = null;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pie() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	visitImpl = new VisitedNumDAOImpl();
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		objs = visitImpl.list();
		request.setAttribute("objs", objs);
		request.getRequestDispatcher("/admin/echarts/pie.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
