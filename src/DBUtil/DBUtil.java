package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBUtil {
	//��������������ݿ�����
    private final static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=yiqing";
    private static final String USER="sa";
    private static final String PASSWORD="1999";
    
    private static Connection conn=null;
    //��̬����飨�������������������ݿ���뾲̬���У�
    static{
        try {
            //1.������������
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.������ݿ������
            conn=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
   	 
        
    }
    
    //�����ṩһ����������ȡ���ݿ�����
    public static Connection getConnection(){
        return conn;
    }
}

