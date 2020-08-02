package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.yiqing;
import net.sf.json.JSONObject;

public class UserDao {
	
	static Connection conn=DBUtil.DBUtil.getConnection();
	public static int searchPerson(String user,String password)throws SQLException, ClassNotFoundException{
			
		 
   
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rsst = stmt.executeQuery("select * from userdata");
        String s1,s2,s3;
        int x=-1;
        while(rsst.next())
        {
        	s1=rsst.getString(2);
        	s2=rsst.getString(3);
        	if(s1.equals(user)&&s2.equals(password)) {
        		s3=rsst.getString(3);
        		x=Integer.parseInt(s3);
        		break;}
        }
        
        
        
      return x;
    }
	
	
	
	public static String gettype(String name) throws SQLException
	{
		String s = null;
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rsst = stmt.executeQuery("select * from userdata where name ='"+name+"'");
        if(rsst.next()) {s=rsst.getString(4);}
		return s;
		
		
		
	}
	public static JSONObject getworld(String nian,String yue,String ri) throws SQLException 
	{
		JSONObject json=new JSONObject();
		String s =nian+"年"+yue+"月"+ri+"日";
		ArrayList<String> sheng=new ArrayList<String>();
		ArrayList<String> snow=new ArrayList<String>();
		ArrayList<String> snew=new ArrayList<String>();
		ArrayList<String> data=new ArrayList<String>();
		ArrayList<String> country=new ArrayList<String>();
		ArrayList<String> cnew=new ArrayList<String>();
		ArrayList<String> cnow=new ArrayList<String>();
		ArrayList<String> zhou=new ArrayList<String>();
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rsst = stmt.executeQuery("select * from sheng where date ='"+s+"'");
		while(rsst.next()) {
			sheng.add(rsst.getString(1));
			snew.add(rsst.getString(2));
			snow.add(rsst.getString(3));
			
			
		}
		rsst = stmt.executeQuery("select * from world where data ='"+s+"'");
		while(rsst.next()) {
			country.add(rsst.getString(1));
			cnew.add(rsst.getString(3));
			cnow.add(rsst.getString(4));
			zhou.add(rsst.getString(2));
			
		}
		json.put("data",s);
		json.put("sheng", sheng);
		json.put("snow", snow);
		json.put("snew", snew);
		json.put("country", country);
		json.put("cnow",cnow);
		json.put("cnew",cnew);
		json.put("zhou",zhou);
		return json;
		
	}
	
	@SuppressWarnings("null")
	public static yiqing getnow(String nian,String yue,String ri) throws SQLException
	{yiqing x = new yiqing();
		String s =nian+"年"+yue+"月"+ri+"日";
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"广东省"+"'");
        if(rsst.next()) {x.setGuangdong(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"江苏省"+"'");
        if(rsst.next()) {x.setJiangsu(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"山东省"+"'");
        if(rsst.next()) {x.setShandong(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"浙江省"+"'");
        if(rsst.next()) {x.setZhejinag(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"江苏省"+"'");
        if(rsst.next()) {x.setJiangsu(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"河南省"+"'");
        if(rsst.next()) {x.setHenan(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"四川省"+"'");
        if(rsst.next()) {x.setSichuan(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"湖北省"+"'");
        if(rsst.next()) {x.setHubei(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"湖南省"+"'");
        if(rsst.next()) {x.setHunan(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"河北省"+"'");
        if(rsst.next()) {x.setHebei(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"福建省"+"'");
        if(rsst.next()) {x.setFujian(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"上海"+"'");
        if(rsst.next()) {x.setShanghai(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"北京"+"'");
        if(rsst.next()) {x.setBeijing(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"安徽省"+"'");
        if(rsst.next()) {x.setAnhui(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"辽宁省"+"'");
        if(rsst.next()) {x.setLiaoning(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"陕西省"+"'");
        if(rsst.next()) {x.setShanxi(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"江西省"+"'");
        if(rsst.next()) {x.setJiangxi(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"重庆"+"'");
        if(rsst.next()) {x.setChongqing(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"广西"+"'");
        if(rsst.next()) {x.setGuangxi(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"天津"+"'");
        if(rsst.next()) {x.setTianjin(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"云南"+"'");
        if(rsst.next()) {x.setYunnan(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"内蒙古"+"'");
        if(rsst.next()) {x.setNeimenggu(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"黑龙江省"+"'");
        if(rsst.next()) {x.setXishan(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"山西省"+"'");
        if(rsst.next()) {x.setJilin(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"吉林省"+"'");
        if(rsst.next()) {x.setJilin(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"贵州省"+"'");
        if(rsst.next()) {x.setGuizhou(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"新疆"+"'");
        if(rsst.next()) {x.setXinjiang(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"甘肃省"+"'");
        if(rsst.next()) {x.setGanxu(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"海南省"+"'");
        if(rsst.next()) {x.setHainan(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"宁夏省"+"'");
        if(rsst.next()) {x.setNingxia(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"青海省"+"'");
        if(rsst.next()) {x.setQinghai(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"西藏"+"'");
        if(rsst.next()) {x.setXizang(rsst.getString(2));}
		
        
        
        
        
        return x;
		
		
		
	}
	
	public static JSONObject getn(String nian,String yue,String ri) throws SQLException
	{yiqing x = new yiqing();
		JSONObject json=new JSONObject();
		String s =nian+"年"+yue+"月"+ri+"日";
		ArrayList<String> guonei=new ArrayList<String>();
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"广东省"+"'");
        if(rsst.next()) {x.setGuangdong(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"江苏省"+"'");
        if(rsst.next()) {x.setJiangsu(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"山东省"+"'");
        if(rsst.next()) {x.setShandong(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"浙江省"+"'");
        if(rsst.next()) {x.setZhejinag(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"江苏省"+"'");
        if(rsst.next()) {x.setJiangsu(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"河南省"+"'");
        if(rsst.next()) {x.setHenan(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"四川省"+"'");
        if(rsst.next()) {x.setSichuan(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"湖北省"+"'");
        if(rsst.next()) {x.setHubei(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"湖南省"+"'");
        if(rsst.next()) {x.setHunan(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"河北省"+"'");
        if(rsst.next()) {x.setHebei(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"福建省"+"'");
        if(rsst.next()) {x.setFujian(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"上海"+"'");
        if(rsst.next()) {x.setShanghai(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"北京"+"'");
        if(rsst.next()) {x.setBeijing(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"安徽省"+"'");
        if(rsst.next()) {x.setAnhui(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"辽宁省"+"'");
        if(rsst.next()) {x.setLiaoning(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"陕西省"+"'");
        if(rsst.next()) {x.setShanxi(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"江西省"+"'");
        if(rsst.next()) {x.setJiangxi(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"重庆"+"'");
        if(rsst.next()) {x.setChongqing(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"广西"+"'");
        if(rsst.next()) {x.setGuangxi(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"天津"+"'");
        if(rsst.next()) {x.setTianjin(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"云南"+"'");
        if(rsst.next()) {x.setYunnan(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"内蒙古"+"'");
        if(rsst.next()) {x.setNeimenggu(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"黑龙江省"+"'");
        if(rsst.next()) {x.setXishan(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"山西省"+"'");
        if(rsst.next()) {x.setJilin(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"吉林省"+"'");
        if(rsst.next()) {x.setJilin(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"贵州省"+"'");
        if(rsst.next()) {x.setGuizhou(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"新疆"+"'");
        if(rsst.next()) {x.setXinjiang(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"甘肃省"+"'");
        if(rsst.next()) {x.setGanxu(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"海南省"+"'");
        if(rsst.next()) {x.setHainan(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"宁夏省"+"'");
        if(rsst.next()) {x.setNingxia(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"青海省"+"'");
        if(rsst.next()) {x.setQinghai(rsst.getString(2));guonei.add(rsst.getString(2));}
        rsst = stmt.executeQuery("select * from sheng where date ='"+s+"' and sheng = '"+"西藏"+"'");
        if(rsst.next()) {x.setXizang(rsst.getString(2));guonei.add(rsst.getString(2));}
		
        
        json.put("guonei", guonei);
        
        
        return json;
		
		
		
	}
	
	static int getId() throws SQLException
	{int x=0;
	
	 Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
     ResultSet rsst = stmt.executeQuery("select * from report");
     String s1,s2;

     while(rsst.next())
     {
     	if(x<rsst.getInt(1)) {x=rsst.getInt(1);}
     	
     }

	return x;
		
	}
	
	public static int addreport(String owner,String name,String time,String text) throws SQLException
	{
		int x=0;
		int id=getId()+1;
		String sql = "insert into report values(?,?,?,?,?,?,?,?) ";  
		PreparedStatement pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
		
		
		pst.setInt(1, id);
		pst.setString(2, name);  
		pst.setString(3, time); 
		pst.setString(4, owner); 
		pst.setString(5, text);
		pst.setString(6, "0");
		pst.setString(7, "");
		pst.setString(8, "");
		x=pst.executeUpdate();
		if(x>0) {x=1;}else {x=0;}
		return x;
	}


	public static int changeteacher(String hao,String name,String yuan,String zhi,String sex) throws SQLException
	{
		int x=0;
		String sql = "update teacher set name = '"+name+"',yuan = '"+yuan+"',sex = '"+sex+"',zhi = '"+zhi+"' where hao= '"+hao+"'";  
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		x=stmt.executeUpdate(sql);

		if(x>0) {x=1;}else {x=0;}
			
		return x;
	}
	public static int changestudent(String hao,String name,String zhuan,String cls,String sex) throws SQLException
	{
		int x=0;
		String sql = "update student set name = '"+name+"',zhuan = '"+zhuan+"',sex = '"+sex+"',class = '"+cls+"' where hao= '"+hao+"'";  
		
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		x=stmt.executeUpdate(sql);

		if(x>0) {x=1;}else {x=0;}
			
		return x;
	}
	public static int deleteReporter(String id) throws SQLException
	{
		int x=0;
		String sql = "delete from report where id='"+id+"'";  
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		x=stmt.executeUpdate(sql);
		if(x>0) {x=1;}else {x=0;}
		
		
		
		return x;
	}
	public static int deletePerson(String name) throws SQLException
	{
		int x=0;
		String sql = "delete from userdata where name='"+name+"'";  
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		x=stmt.executeUpdate(sql);
		if(x>0) {x=1;}else {x=0;}
		
		
		
		return x;
	}
	public static int deletestudent(String hao) throws SQLException
	{
		int x=0;
		String sql = "delete from student where hao='"+hao+"'";  
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		x=stmt.executeUpdate(sql);
		sql= "delete from userdata where name='"+hao+"'";
		x=stmt.executeUpdate(sql);
		sql= "delete from relate where student='"+hao+"'";
		x=stmt.executeUpdate(sql);
		if(x>0) {x=1;}else {x=0;}
		
		
		
		return x;
	}
	public static int deleteteacher(String hao) throws SQLException
	{
		int x=0;
		String sql = "delete from teacher where hao='"+hao+"'";  
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		x=stmt.executeUpdate(sql);
		sql= "delete from userdata where name='"+hao+"'";
		x=stmt.executeUpdate(sql);
		if(x>0) {x=1;}else {x=0;}
		
		
		
		return x;
	}
	public static int addperson(String name,String password,String type) throws SQLException
	{
		int x=0;
		
		String sql = "insert into userdata values(?,?,?) ";  
		PreparedStatement pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
		
		
		pst.setString(1, name);
		pst.setString(2, password);  
		pst.setString(3, type); 
	
		x=pst.executeUpdate();
		if(x>0) {x=1;}else {x=0;}
		return x;
	}
	public static int addclass(String name,String teacher,String hao,String person,String tname) throws SQLException
	{
		int x=0;
		
		String sql = "insert into class values(?,?,?,?,?,?,?,?) ";  
		PreparedStatement pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
		
		
		pst.setString(1, "0");
		pst.setString(2, name);  
		pst.setString(3, teacher); 
		pst.setInt(4, Integer.parseInt(person)); 
		pst.setInt(5, 0); 
		pst.setString(6, hao); 
		pst.setString(7, "0"); 
		pst.setString(8,tname);
	
		x=pst.executeUpdate();
		if(x>0) {x=1;}else {x=0;}
		return x;
	}
	public static int cclass(String name,String hao) throws SQLException
	{
		int x=0;
		String s = null;int a=0,b=0;
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		 ResultSet rsst = stmt.executeQuery("select * from relate where student ='"+name+"' and class='"+hao+"'");
		 if(rsst.next()) {x=2;return x;}
		 else {   rsst = stmt.executeQuery("select * from class where hao ='"+hao+"'");
        if(rsst.next()) {a=rsst.getInt(5);b=rsst.getInt(4);}
        a++;
        String sql;

        if(a<b) {
        sql = "update class set chose ='"+a+"' where hao="+hao+"";  }
        else   sql = "update class set chose ='"+a+"',stand='1' where hao="+hao+""; 
		
	
		x=stmt.executeUpdate(sql);
        
        
		
	 sql = "insert into relate values(?,?) ";  
		PreparedStatement pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
		
		
		pst.setString(1, hao);
		pst.setString(2, name);  
	
	
		x=pst.executeUpdate();
		if(x>0) {x=1;}else {x=0;}
		return x;}
	}
	public static int addteacher(String name,String sex,String hao,String zhi,String yuan,String password) throws SQLException
	{
		int x=0;
		
		String sql = "insert into teacher values(?,?,?,?,?,?) ";  
		PreparedStatement pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
		
		
		pst.setString(1, "0");
		pst.setString(2, name);  
		pst.setString(3, sex); 
		pst.setString(4, yuan); 
		pst.setString(5, zhi); 
		pst.setString(6, hao); 
		x=pst.executeUpdate();
		
		sql = "insert into userdata values(?,?,?,?) ";  
		 pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
		
		
		pst.setString(1, "0");
		pst.setString(2, hao);  
		pst.setString(3, password); 
		pst.setString(4, "1"); 

	
		x=pst.executeUpdate();
		if(x>0) {x=1;}else {x=0;}
		return x;
	}
	
	public static int addstudent(String name,String sex,String hao,String zhuan,String clas,String password) throws SQLException
	{
		int x=0;
		
		String sql = "insert into student values(?,?,?,?,?) ";  
		PreparedStatement pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
		
		
		pst.setString(1, name);
		pst.setString(2, sex);  
		pst.setString(3, clas); 
		pst.setString(4, zhuan); 
		pst.setString(5, hao); 
		
		x=pst.executeUpdate();
		
		sql = "insert into userdata values(?,?,?,?) ";  
		 pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
		
		
		pst.setString(1, "0");
		pst.setString(2, hao);  
		pst.setString(3, password); 
		pst.setString(4, "2"); 

	
		x=pst.executeUpdate();
		if(x>0) {x=1;}else {x=0;}
		return x;
	}
	
	
	
	
	
	public static String getteachername(String hao) throws SQLException
	{
		String name = null;
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rsst = stmt.executeQuery("select * from teacher where hao ='"+hao+"'");
        if(rsst.next()) {
        	
        	
      name=rsst.getString(2);
        	
        	
        }
		return name;
	}
	
	
	
}