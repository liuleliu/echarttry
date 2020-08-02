package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import jdk.nashorn.api.scripting.JSObject;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class json
 */
@WebServlet("/json")
public class json extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public json() {
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
	    HttpSession session = request.getSession(); 
	    JSONObject json=new JSONObject();
	    ArrayList<String> dc=new ArrayList<String>();
	    dc.add("A");
	    dc.add("B");
	    
	    
	    ArrayList<Integer> dn=new ArrayList<Integer>();
	    dn.add(10);
	    dn.add(20);
	    
	    json.put("n", dn);
	    json.put("c",dc);
	    JSONObject j=new JSONObject();
	    try {
			j=UserDao.getn("2020","03", "11");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	    session.setAttribute("json", j);
	    response.sendRedirect("chart1.jsp");
	    
	  	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
