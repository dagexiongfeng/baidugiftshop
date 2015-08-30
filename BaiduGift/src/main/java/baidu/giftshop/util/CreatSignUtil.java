package baidu.giftshop.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
/**
 * 创建百度支付签名工具类
 * @author tongwenli
 *
 */
public class CreatSignUtil {

	public static String createSign(SortedMap<String, String> signParams) {
		StringBuffer sb=new StringBuffer();
		Set es=signParams.entrySet();
		Iterator it=es.iterator();
		while (it.hasNext()){
			Map.Entry entry=(Map.Entry)it.next();
			String k=(String) entry.getKey();
			String v=(String) entry.getValue();
			sb.append( k + "=" + v + "&");
		}
		String params = sb.substring(0,sb.lastIndexOf("&"));
		
		return MD5Util.MD5(params);
	}
}
