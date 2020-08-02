package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.cpack;
import Dao.UD;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class deadnum
 */
@WebServlet("/deadnum")
public class deadnum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deadnum() {
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
	    HttpSession session = request.getSession(); 
		JSONObject json=new JSONObject();
		ArrayList<cpack> list=new ArrayList<cpack>();
		 Connection conn=DBUtil.mysqllink.getConnection();
		 cpack x=new cpack();
		 Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		  //Ҫִ�е�SQL���
		  String num = null,country;
		  Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy��MM��dd��");
	      String time=ft.format(dNow);
		  try {
			num=UD.getnum(time);
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		  String sql = "select * from world where time ='"+time+"'  ";
		   //3.ResultSet�࣬������Ż�ȡ�Ľ��������

		 
		  ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

			try {
				while(rs.next()){
					//��ȡstuname��������
				    
				    //��ȡstuid��������
						x.setCountry(rs.getString(1));
						x.setNum(rs.getString(4));
						list.add(x);
						x=new cpack();				    //������
				  
								}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		 json.put("data", list);
		 json.put("num", num);
		 
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
