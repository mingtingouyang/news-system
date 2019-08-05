package admin.member;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jdbc.dao.impl.MemberDAOImpl;
import jdbc.pojo.Member;

/**
 * Servlet implementation class MemberEdit
 */
@MultipartConfig
@WebServlet("/admin/member/edit")
public class MemberEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Member member = null;
	private MemberDAOImpl memberImpl = null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEdit() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	memberImpl = new MemberDAOImpl();
    	super.init();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = new String(request.getParameter("edit").getBytes("ISO-8859-1"),"utf-8");
		member = memberImpl.listByUsername(username);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/admin/member/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		Member tmp = memberImpl.listByUsername(username); //获取表单对应的用户
		Integer id = tmp.getId();
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String status = tmp.getStatus();
		String userimg = null;
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String time = tmp.getTime();
		
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
		member = new Member(id, username, password, gender, phone, email, address, time, userimg, status);
		memberImpl.update(member); 
		request.setAttribute("status", "修改成功");
		request.setAttribute("page", "用户信息");
		request.setAttribute("url", "admin/member/edit?edit=" + member.getUsername());//更改后，跳转至对应用户的修改页面
		request.getRequestDispatcher("/admin/loading.jsp").forward(request, response);
	}

}
