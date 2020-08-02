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
		response.setCharacterEncoding("utf-8");    //���� HttpServletResponseʹ��utf-8����
		response.setHeader("Content-Type", "text/html;charset=utf-8");    //֪ͨ�����ʹ��utf-8����
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	        request.setCharacterEncoding("utf-8");
	       
	        
	        try (PrintWriter out = response.getWriter()) {

	            //��������д������û���������
	          

	            //������֤���
	        	 String nian = request.getParameter("nian");
		            String yue = request.getParameter("yue");
	            
		            String ri = request.getParameter("ri");
	         
	         
	            JSONObject jsonObject = null;
				try {
					jsonObject = UserDao.getworld(nian,yue ,ri );
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
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
