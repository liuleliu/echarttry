package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqllink {
	private static String driver = "com.mysql.jdbc.Driver";
    //URLָ��Ҫ���ʵ����ݿ���mydata
	private static String url = "jdbc:mysql://47.98.242.143:3306/payiqing";
 //MySQL����ʱ���û���
	private static String user = "root";
 //MySQL����ʱ������
	private static String password = "1999";
 private static Connection conn=null;
 //��̬����飨�������������������ݿ���뾲̬���У�
 static{
 	 try {
	            //������������
       Class.forName(driver);
     //1.getConnection()����������MySQL���ݿ⣡��
	             conn = DriverManager.getConnection(url,user,password);
      if(!conn.isClosed())
	                System.out.println("Succeeded connecting to the Database!");
 }
 	 catch(ClassNotFoundException e) {   
     //���ݿ��������쳣����
  System.out.println("Sorry,can`t find the Driver!");   
     e.printStackTrace();   
      } catch(SQLException e) {
      //���ݿ�����ʧ���쳣����
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
//	           //Ҫִ�е�SQL���
//            String sql = "select  * from info limit 1";
//	            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
//	             ResultSet rs = statement.executeQuery(sql);
//	             
//	             rs.close();
//			} catch (SQLException e1) {
//				// TODO �Զ����ɵ� catch ��
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
 //�����ṩһ����������ȡ���ݿ�����
 public static Connection getConnection(){
     return conn;
 }
}
