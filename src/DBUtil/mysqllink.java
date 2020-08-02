package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqllink {
	private static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
	private static String url = "jdbc:mysql://47.98.242.143:3306/payiqing";
 //MySQL配置时的用户名
	private static String user = "root";
 //MySQL配置时的密码
	private static String password = "1999";
 private static Connection conn=null;
 //静态代码块（将加载驱动、连接数据库放入静态块中）
 static{
 	 try {
	            //加载驱动程序
       Class.forName(driver);
     //1.getConnection()方法，连接MySQL数据库！！
	             conn = DriverManager.getConnection(url,user,password);
      if(!conn.isClosed())
	                System.out.println("Succeeded connecting to the Database!");
 }
 	 catch(ClassNotFoundException e) {   
     //数据库驱动类异常处理
  System.out.println("Sorry,can`t find the Driver!");   
     e.printStackTrace();   
      } catch(SQLException e) {
      //数据库连接失败异常处理
 e.printStackTrace();  
 }
// 	final long timeInterval = 1000*60;
//	Runnable runnable = new Runnable() {
//		public void run() {
//			while (true) {
//			   Statement statement;
//			try {
//				statement = conn.createStatement();
//			
//	           //要执行的SQL语句
//            String sql = "select  * from info limit 1";
//	            //3.ResultSet类，用来存放获取的结果集！！
//	             ResultSet rs = statement.executeQuery(sql);
//	             
//	             rs.close();
//			} catch (SQLException e1) {
//				// TODO 自动生成的 catch 块
//				e1.printStackTrace();
//			}
//				
//				try {
//					Thread.sleep(timeInterval);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	};
//	Thread thread = new Thread(runnable);
//	thread.start();
 }
 //对外提供一个方法来获取数据库连接
 public static Connection getConnection(){
     return conn;
 }
}
