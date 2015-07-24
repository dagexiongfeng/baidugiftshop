package baidu.giftshop.util;

import java.util.HashMap;

import net.sf.json.JSONObject;

public class ConnectHttp {
	
	@SuppressWarnings("static-access")
	public String getuserid(String str){
		
        HttpUtilsPost httputilspost = new HttpUtilsPost();
		
		String url_path = "http://uuapauth.itebeta.baidu.com/v2/validateTicket";
		
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("appKey", "uuapclient-11-164fs4y6p3SxE3a5eqFQ");
		map.put("ticket", str);
		map.put("resultType", "json");
		
		String string = httputilspost.SendPostMessage(url_path, map);
		System.out.println(string);
		
		JSONObject jsonObj = JSONObject.fromObject(string);
		String username = (String) jsonObj.getJSONObject("user").get("username");
		System.out.println(jsonObj.getJSONObject("user").get("username"));
		
		return username;
				
	}

}
