package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class appget
 */
@WebServlet("/appget")
public class appget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public appget() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");    //设置 HttpServletResponse使用utf-8编码
		response.setHeader("Content-Type", "text/html;charset=utf-8");    //通知浏览器使用utf-8解码
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	        request.setCharacterEncoding("utf-8");
	       
	        
	        try (PrintWriter out = response.getWriter()) {

	            //获得请求中传来的用户名和密码
	          

	            //密码验证结果
	        	 String nian = request.getParameter("nian");
		            String yue = request.getParameter("yue");
	            
		            String ri = request.getParameter("ri");
	         
	         
	            JSONObject jsonObject = null;
				try {
					jsonObject = UserDao.getworld(nian,yue ,ri );
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
	            
	            System.out.println(jsonObject.toString());
	            response.resetBuffer();
	            out.write(jsonObject.toString());
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
