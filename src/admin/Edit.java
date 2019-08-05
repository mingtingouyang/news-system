package admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import jdbc.dao.impl.UserDAOImpl;
import jdbc.pojo.User;

/**
 * Servlet implementation class Edit
 */
@MultipartConfig
@WebServlet("/admin/edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session = null;
	private UserDAOImpl userimpl = null;
	private User user = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	userimpl = new UserDAOImpl();
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("edit") != null) {
			String username = new String(request.getParameter("edit").getBytes("ISO-8859-1"),"utf-8");
			user = userimpl.listByUsername(username);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/admin/edit.jsp").forward(request, response);
		} else { //如果从 index 的用户信息进入，则是当前会话登录用户的修改界面
			session = request.getSession();
			user = (User)session.getAttribute("user");
			request.setAttribute("user", user);
			request.getRequestDispatcher("/admin/edit.jsp").forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		User tmp = userimpl.listByUsername(username); //获取表单对应的用户
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String permission = tmp.getPermission();
		String userimg = null;
		Integer id = tmp.getId();
		
		Part img = request.getPart("userimg");//获得图像文件
		
		if(img.getSize() == 0) {  //判断用户是否上传头像，如果没有上传，则用用户当前头像作为参数
			userimg = tmp.getUserimg();
		} else {
			//下面两步获得文件后缀名
			String tmpStr = img.getHeader("content-disposition").split("[.]")[1];
			String type = "." + tmpStr.substring(0, tmpStr.length() - 1);   //后缀名
			
			userimg = "" + id + new Date().getTime() + type;  //本地文件名为用户id加上传时的时间戳
			img.write(request.getServletContext().getRealPath("userimg") + "/" + userimg); //前面部分用于获得 userimg 目录的真实路径
		}
		user = new User(username, password, phone, gender, permission, userimg, id);
		userimpl.update(user); 
		request.setAttribute("status", "修改成功");
		request.setAttribute("page", "用户信息");
		request.setAttribute("url", "admin/edit?edit=" + user.getUsername());//更改头像后，跳转至对应用户的修改页面
		request.getRequestDispatcher("/admin/loading.jsp").forward(request, response);
	}

}
