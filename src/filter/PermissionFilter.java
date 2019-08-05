package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.pojo.User;

/**
 * Servlet Filter implementation class PermissionFilter
 */
@WebFilter(urlPatterns = {"/admin/*", "/admin"})
public class PermissionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PermissionFilter() {
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
		//将对象转换成 HttpServletXxxxx，以获得 session 和 重定向
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String curServlet = req.getServletPath();
		if(!curServlet.equals("/admin/login")){ //如果时登录和注册页面，则不考虑权限问题
			if(user == null) {
				req.setAttribute("status", "您还未登录，没有权限访问此页面");
				req.setAttribute("page", "登录");
				req.setAttribute("url", "admin/login");
				req.getRequestDispatcher("/admin/loading.jsp").forward(req, res);
				return;//直接跳转，不再经过过滤链
			} else if (!user.getPermission().equals("admin")) {
				req.setAttribute("status", "您的权限无法访问此页面，请联系管理员");
				req.setAttribute("page", "登录");
				req.setAttribute("url", "admin/login");
				req.getRequestDispatcher("/admin/loading.jsp").forward(req, res);
				return;//直接跳转，不再经过过滤链
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
