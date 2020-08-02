package Bean;

import java.util.ArrayList;
import java.util.HashMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class www {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 JSONObject json=new JSONObject();
		    ArrayList<String> dc=new ArrayList<String>();
		    dc.add("A");
		    dc.add("B");
		    
		    JSONArray jsonarray;
		    ArrayList<Integer> dn=new ArrayList<Integer>();
		    dn.add(10);
		    dn.add(20);
		    
		    json.put("n", dn);
		    json.put("c",dc);
		    System.out.println(json.get("n"));
		    
		    ArrayList<HashMap<String, String>> l=new ArrayList<HashMap<String, String>>();
		    HashMap<String, String> map = new HashMap<>();
			map.put("zhang", "31");
			l.add(map);
			map = new HashMap<>();
			map.put("zhang", "33");
		    l.add(map);
		    json.put("l",l);
		    System.out.println(json.get("l").toString());
//		    jsonarray = JSONArray.fromObject(json.get("n"));
		    jsonarray=json.getJSONArray("n");
		    for(Object tmp:jsonarray){
		    	int i=(int) tmp;
	            System.out.println(i); 
	        }
		    
	}

}
