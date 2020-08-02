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
		response.setCharacterEncoding("utf-8");    //设置 HttpServletResponse使用utf-8编码
		response.setHeader("Content-Type", "text/html;charset=utf-8");    //通知浏览器使用utf-8解码
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
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		  //要执行的SQL语句
		  String num = null,country;
		  Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy年MM月dd日");
	      String time=ft.format(dNow);
		  try {
			num=UD.getnum(time);
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		  String sql = "select * from world where time ='"+time+"'  ";
		   //3.ResultSet类，用来存放获取的结果集！！

		 
		  ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

			try {
				while(rs.next()){
					//获取stuname这列数据
				    
				    //获取stuid这列数据
						x.setCountry(rs.getString(1));
						x.setNum(rs.getString(4));
						list.add(x);
						x=new cpack();				    //输出结果
				  
								}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
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
