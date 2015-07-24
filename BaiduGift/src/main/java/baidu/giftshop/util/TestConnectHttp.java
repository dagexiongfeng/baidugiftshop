package baidu.giftshop.util;

import java.util.HashMap;

import net.sf.json.JSONObject;

public class TestConnectHttp {
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		HttpUtilsPost httputilspost = new HttpUtilsPost();
		
		String url_path = "http://uuapauth.itebeta.baidu.com/v2/validateTicket";
		
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("appKey", "uuapclient-11-164fs4y6p3SxE3a5eqFQ");
		map.put("ticket", "AT-25-fgrb3DCFanQuwo9utEBT57yRFcB5Gm-uuapauth");
		map.put("resultType", "json");
		
		String str = httputilspost.SendPostMessage(url_path, map);
		System.out.println(str);
		
		JSONObject jsonObj = JSONObject.fromObject(str);
		System.out.println(jsonObj.getJSONObject("user").get("username"));
	}
}
