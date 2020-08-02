package Bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

import com.alibaba.fastjson.JSONArray;

public class mysqlworld {
	public static void main(String[] args) throws IOException, SQLException {
		getAreaStat();
	}

	// 根URL
	private static String httpRequset(String requesturl) throws IOException {
		StringBuffer buffer = null;
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		InputStream inputStream = null;
		HttpsURLConnection httpsURLConnection = null;
		try {
			URL url = new URL(requesturl);
			httpsURLConnection = (HttpsURLConnection) url.openConnection();
			httpsURLConnection.setDoInput(true);
			httpsURLConnection.setRequestMethod("GET");
			inputStream = httpsURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return buffer.toString();
	}

	/**
	 * 获取全国各个省市的确诊、死亡和治愈人数
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public static String getAreaStat() throws SQLException {
		String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
		String htmlResult = "";
		try {
			htmlResult = httpRequset(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(htmlResult);

		// 正则获取数据
		// 因为html的数据格式看着就像json格式，所以我们正则获取json
		String reg = " window.getListByCountryTypeService2true = (.*?)\\}(?=catch)";
		Pattern totalPattern = Pattern.compile(reg);
		Matcher totalMatcher = totalPattern.matcher(htmlResult);
		System.out.println(htmlResult);
		String result = "";
		if (totalMatcher.find()) {
			result = totalMatcher.group(1);
			System.out.println(result);
			// 各个省市的是一个列表List，如果想保存到数据库中，要遍历结果，下面是demo
			JSONArray array = JSONArray.parseArray(result);
			
			
			Connection conn=DBUtil.mysqllink.getConnection();
			String sql=null;
			PreparedStatement pst=null;
			sql = "insert into world values(?,?,?,?,?,?,?) ";  
			
			 Date dNow = new Date( );
		      SimpleDateFormat ft = new SimpleDateFormat ("yyyy年MM月dd日");
		      String time=ft.format(dNow);
			

				for (int i = 0; i < array.size(); i++) {

					com.alibaba.fastjson.JSONObject jsonObject =array.getJSONObject(i);
					String provinceName = jsonObject.getString("provinceName");
					
						String current = jsonObject.getString("currentConfirmedCount");
						String confirmed = jsonObject.getString("confirmedCount");
						String cured = jsonObject.getString("curedCount");
						String dead = jsonObject.getString("deadCount");
						String suspect = jsonObject.getString("suspectedCount");
						String zhou=jsonObject.getString("continents");
						System.out.println(provinceName);
						
						 pst = conn.prepareStatement(sql);  
						
							
						
							pst.setString(1, provinceName);  
							pst.setString(2,zhou );	
							pst.setString(3, current);
							pst.setString(4, confirmed);
							pst.setString(5, cured); 
							pst.setString(6, dead);
							pst.setString(7, time);
							pst.executeUpdate();
//						
//						
//						JSONArray array2 = jsonObject.getJSONArray("cities");
//						for (int j = 0; j < array2.size(); j++) {
//							com.alibaba.fastjson.JSONObject jsonObject2 =array2.getJSONObject(j);
//							String cityname = jsonObject2.getString("cityName");
//							String current2 = jsonObject2.getString("currentConfirmedCount");
//							String confirmed2 = jsonObject2.getString("confirmedCount");
//							String cured2 = jsonObject2.getString("curedCount");
//							String dead2 = jsonObject2.getString("deadCount");
//							String suspect2 = jsonObject2.getString("suspectedCount");
//							
//						}
				}
		}
		return result;
	}
}
