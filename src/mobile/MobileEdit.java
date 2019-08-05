package mobile;

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
 * Servlet implementation class MobileEdit
 */
@MultipartConfig
@WebServlet("/mobile/edit")
public class MobileEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAOImpl memberImpl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileEdit() {
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String userimg = null;
		Member member = memberImpl.listByUsername(username); //取出数据库内存储的对象
		String status = member.getStatus();
		String time = member.getTime();
		Integer id = member.getId();
		
		Part img = request.getPart("userimg");
		
		if(img.getSize() == 0) {  //判断用户是否上传头像，如果没有上传，则用用户当前头像作为参数
			userimg = member.getUserimg();
		} else {
			//下面两步获得文件后缀名
			String tmpStr = img.getHeader("content-disposition").split("[.]")[1];
			String type = "." + tmpStr.substring(0, tmpStr.length() - 1);   //后缀名
			
			userimg = "" + id + new Date().getTime() + type;  //本地文件名为用户id加上传时的时间戳
			img.write(request.getServletContext().getRealPath("userimg") + "/" + userimg); //前面部分用于获得 userimg 目录的真实路径
		}
		member = new Member(id, username, password, gender, phone, email, address, time, userimg, status);
		memberImpl.update(member);    //更新数据库
	}

}
