package Bean;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;



public class ttt {
	static InputStream inputStream = null;
	static BufferedReader in = null;
	static StringBuilder htmlSource= new StringBuilder();
	static PrintStream out = null;
	static File file = new File("C:\\Users\\20514\\Desktop\\111.txt");

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
	public static void main(String[] args) throws FileNotFoundException {
		 out=new PrintStream(file);
	String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia?from=singlemessage&isappinstalled=0";
	
	
	
	
//	String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
	String htmlResult = "";
	try {
		htmlResult = httpRequset(url);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	out.println(htmlResult);
	
	try {
		//1.��ȡ��ַ
		URL u = new URL(url);
		//2.������
		URLConnection conn = u.openConnection();
		//3.��ȡ������
		inputStream = conn.getInputStream();
		//4.��Դ����д���ڴ�(���ñ���)
		in = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
		String str = "";
		
		String regularCity = "window.getAreaStat = (.*?)\\}(?=catch)";
		Pattern p = Pattern.compile(regularCity, Pattern.CASE_INSENSITIVE);
		Matcher m ;
		String result;
		String reg = "window.getAreaStat = (.*?)}(catch)";
		Pattern totalPattern = Pattern.compile(reg);
		Matcher totalMatcher = totalPattern.matcher(htmlResult);
		if (totalMatcher.find()) {
			result = totalMatcher.group(1);
			System.out.println(result);}

		
		while((str = in.readLine()) != null){
		htmlSource.append(str);
		
		
		totalMatcher = totalPattern.matcher(str);
//		if (totalMatcher.find()) {
//			result = totalMatcher.group(1);
//			System.out.println(result);}
		
		
		
		out.println(str);
		 m = p.matcher(str);
		
		if (m.find()) {
			// ���زɼ���������
			out.println(m.group(1));
			System.out.println(m.group(1));
		} else {
		}
		
		}
		} catch (Exception e) {
		e.printStackTrace();
		}finally{
		//�ر�I/o
		try {
		if(in != null)in.close();
		if(inputStream != null)inputStream.close();
		} catch (IOException e) {
		e.printStackTrace();
		}

		}
		
//		 String url="https://ncov.dxy.cn/ncovh5/view/pneumonia";
//	        //ģ������
//		 URLConnection httpPojo = new URLConnection();
//	        httpPojo.setHttpHost("ncov.dxy.cn");
//	        httpPojo.setHttpAccept("*/*");
//	        httpPojo.setHttpConnection("keep-alive");
//	        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
//	        httpPojo.setHttpReferer("https://ncov.dxy.cn");
//	        httpPojo.setHttpOrigin("https://ncov.dxy.cn");
//	        Map paramObj = new HashMap();
//	        String htmlResult = httpSendGet(url, paramObj, httpPojo); //����htmlҳ��
//	        //System.out.println(htmlResult);
//	 
//	        //�����ȡ����
//	        //��Ϊhtml�����ݸ�ʽ���ž���json��ʽ���������������ȡjson��{"id":1,"createTime":1579537899000,"modifyTime":1580571956000,"infectSource":"Ұ���������Ϊ�л���ͷ��","passWay":"����������ĭ���������ͨ���Ӵ�����","imgUrl":"https://img1.dxycdn.com/2020/0201/450/3394153392393266839-135.png","dailyPic":"https://img1.dxycdn.com/2020/0201/693/3394145745204021706-135.png","summary":"","deleted":false,"countRemark":"","confirmedCount":11901,"suspectedCount":17988,"curedCount":275,"deadCount":259,"virus":"���͹�״���� 2019-nCoV","remark1":"�׸���Ⱥ: ��Ⱥ�ձ��׸С������˼��л��������߸�Ⱦ������أ���ͯ��Ӥ�׶�Ҳ�з���","remark2":"Ǳ����: һ��Ϊ 3~7 �죬������� 14 �죬Ǳ�����ڴ��ڴ�Ⱦ��","remark3":"","remark4":"","remark5":"","generalRemark":"���Ʋ��������Թ�������ί���ݣ�ĿǰΪȫ�����ݣ�δ��ʡ����������","abroadRemark":""}
//	        String reg= "window.getStatisticsService = (.*?)\\}(?=catch)"; 
//	        Pattern totalPattern = Pattern.compile(reg);
//	        Matcher totalMatcher = totalPattern.matcher(htmlResult);
//	 
//	        String result="";
//	        if (totalMatcher.find()){
//	            result = totalMatcher.group(1);
//	            System.out.println(result);
//	            //JSONObject jsonObject = JSONObject.parseObject(result);
//	            //String modifyTime = jsonObject.getString("modifyTime");
//	            //System.out.println("modifyTime��"+modifyTime);
//	        }
//
//	
//	}

		

	}
	}




