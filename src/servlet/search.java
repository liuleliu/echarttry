package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.info;
import Bean.yiqing;
import DBUtil.DBUtil;
import Dao.UserDao;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(); 
		response.setCharacterEncoding("UTF-8");
		String nian,yue,ri;
		nian=(String)request.getParameter("nian");
		yue=(String)request.getParameter("yue");
		ri=(String)request.getParameter("ri");
		yiqing x = null;
		try {
			x=UserDao.getnow(nian, yue, ri);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String s=nian+"年"+yue+"月"+ri+"日";
		Connection con = null;
		con=DBUtil.getConnection();
		ArrayList<info> list = new ArrayList<info>(); 
		info y;
		Statement stmt;
		 ResultSet rsst = null ;
		try {
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			 rsst = stmt.executeQuery("select * from sheng where date = '"+s+"'");
		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		 try {
				while(rsst.next())
				
				{
					y=new info();
					y.setSheng(rsst.getString(1));
					y.setAd(rsst.getString(3));
					y.setData(s);
					y.setNow(rsst.getString(2));
					
					list.add(y);
					 
					
					 
					 
					 
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			 session.setAttribute("list", list);
		session.setAttribute("info", x);
		session.setAttribute("xxx", "???");
		 response.sendRedirect("chart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
