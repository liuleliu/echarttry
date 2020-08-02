package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ctry
 */
@WebServlet("/ctry")
public class ctry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ctry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		System.out.println("1231");
		String name;
		name=(String)request.getParameter("name");
		System.out.println(name);
		
		   JSONObject json=new JSONObject();
		    ArrayList<String> dc=new ArrayList<String>();
		    dc.add("A");
		    dc.add("B");
		    
		    
		    ArrayList<Integer> dn=new ArrayList<Integer>();
		    dn.add(10);
		    dn.add(20);
		    
		    json.put("n", dn);
		    json.put("c",dc);
		
		
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		response.resetBuffer();
		response.setHeader("take", "666");
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
