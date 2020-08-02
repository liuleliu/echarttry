package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UD;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class zhelet
 */
@WebServlet("/zhelet")
public class zhelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zhelet() {
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
		 Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy��MM��dd��");
	      String time=ft.format(dNow);
		
	        request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(); 
		response.setCharacterEncoding("UTF-8");
		JSONObject json=new JSONObject();
		try {
			json=UD.getzhe();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		
		response.resetBuffer();
		out.write(json.toString());
		out.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
