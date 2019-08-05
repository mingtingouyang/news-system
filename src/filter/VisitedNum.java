package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import jdbc.dao.VisitedNumDAO;
import jdbc.dao.impl.VisitedNumDAOImpl;

/**
 * Servlet Filter implementation class VisitedNum
 */
@WebFilter("/*")
public class VisitedNum implements Filter {
	
	private VisitedNumDAO visitImpl = null;
	private jdbc.pojo.VisitedNum obj = null;

    /**
     * Default constructor. 
     */
    public VisitedNum() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		if (request.getParameter("c") != null) {
			String category = new String(request.getParameter("c").getBytes("ISO-8859-1"), "utf-8");
			obj = visitImpl.listByCategory(category);
			if (obj != null) {
				obj.setNum(obj.getNum() + 1);
				visitImpl.update(obj);
			} else {
				obj = new jdbc.pojo.VisitedNum(category, 1);
				visitImpl.insert(obj);
			}
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		visitImpl = new VisitedNumDAOImpl();
	}

}
