package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import net.sf.json.JSONObject;

public class UD {

	static Connection conn=DBUtil.mysqllink.getConnection();
public static JSONObject getworld(String date) throws SQLException 
{
	JSONObject json=new JSONObject();
  Statement statement = conn.createStatement();
  //Ҫִ�е�SQL���
  String num,country;
  String sql = "select * from world where time ='"+date+"' ";
   //3.ResultSet�࣬������Ż�ȡ�Ľ��������
  ArrayList<HashMap<String, String>> l=new ArrayList<HashMap<String, String>>();
  HashMap<String, String> map = new HashMap<>();

 
  ResultSet rs = statement.executeQuery(sql);

	while(rs.next()){
		//��ȡstuname��������
        
        //��ȡstuid��������
        	num = rs.getString(4);
        	country= rs.getString(1);
        	map.put("name", country);
        	map.put("value", num);
        	l.add(map);
        	map = new HashMap<>();

        //������
      
					}
	json.put("world",l);
	rs.close();
return json;

}
public static JSONObject getzhe() throws SQLException 
{
	JSONObject json=new JSONObject();
  Statement statement = conn.createStatement();
  //Ҫִ�е�SQL���
  String num,time;
  String sql = "select sum(new),time from world group by time";
   //3.ResultSet�࣬������Ż�ȡ�Ľ��������
  ArrayList<String> t=new ArrayList< String>();
  ArrayList<String> n=new ArrayList< String>();
  HashMap<String, String> map = new HashMap<>();

 
  ResultSet rs = statement.executeQuery(sql);
  	t.add("2020��04��02��");
	n.add("601439");
	t.add("2020��04��03��");
	n.add("801562");

	while(rs.next()){
		//��ȡstuname��������
        
        //��ȡstuid��������
        	n.add(rs.getString(1));
        	t.add(rs.getString(2));
        	
        
        
        	

        //������
      
					}
	json.put("num", n);
	json.put("time",t);
	rs.close();
return json;

}
public static String getnum(String date) throws SQLException 
{
	JSONObject json=new JSONObject();
  Statement statement = conn.createStatement();
  //Ҫִ�е�SQL���
  String num = null,country;
  String sql = "select sum(new) from world where time ='"+date+"' ";
   //3.ResultSet�࣬������Ż�ȡ�Ľ��������


 
  ResultSet rs = statement.executeQuery(sql);

	if(rs.next()){
		num=rs.getString(1);
      
					}
	
	rs.close();
return num;

}
public static String getnumcured(String date) throws SQLException 
{
	JSONObject json=new JSONObject();
  Statement statement = conn.createStatement();
  //Ҫִ�е�SQL���
  String num = null,country;
  String sql = "select sum(cured) from world where time ='"+date+"' ";
   //3.ResultSet�࣬������Ż�ȡ�Ľ��������


 
  ResultSet rs = statement.executeQuery(sql);

	if(rs.next()){
		num=rs.getString(1);
      
					}
	
	rs.close();
return num;

}
public static String getdeadnum(String date) throws SQLException 
{
	JSONObject json=new JSONObject();
  Statement statement = conn.createStatement();
  //Ҫִ�е�SQL���
  String num = null,country;
  String sql = "select sum(dead) from world where time ='"+date+"' ";
   //3.ResultSet�࣬������Ż�ȡ�Ľ��������


 
  ResultSet rs = statement.executeQuery(sql);

	if(rs.next()){
		num=rs.getString(1);
      
					}
	
	rs.close();
return num;

}
}
