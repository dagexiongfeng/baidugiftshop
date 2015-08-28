package baidu.giftshop.controller;

import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baidu.giftshop.constants.BaiduPayConstants;
/**
 * 百度钱包支付前获取签名接口
 * @author tongwenli
 * 
 */
public class BaiduPayController {
	
	private static final Integer service_code = 1;
	
	public static final Logger logger=LoggerFactory.getLogger(BaiduPayController.class);
	/*
	 * 对订单生成签名
	 */
	public Object getSign(HttpServletRequest request){
	
		String goods_name = request.getParameter("goods_name");
		String goods_desc = request.getParameter("goods_desc");
		String pay_type = request.getParameter("pay_type");
		String input_charset = request.getParameter("input_charset");
		String version = request.getParameter("version");
		String sign_method = request.getParameter("sign_method");
		
		//设置支付参数
		SortedMap<String, String> signParams = new TreeMap<String,String>();
		signParams.put("service_code", BaiduPayConstants.SERVICE_CODE);
		signParams.put("sp_no", BaiduPayConstants.SP_NO);
		signParams.put("order_create_time", request.getParameter("order_create_time"));
		signParams.put("order_no", request.getParameter("order_no"));
		signParams.put("goods_name", goods_name);
		signParams.put("service_code", goods_desc);		
		signParams.put("total_amount", request.getParameter("order_no"));
		signParams.put("currency", BaiduPayConstants.CURRENCY);
		signParams.put("return_url", request.getParameter("return_url"));
		signParams.put("pay_type", BaiduPayConstants.PAY_TYPE);
		signParams.put("input_charset", "1");
		signParams.put("version", "2");
		signParams.put("sign_method", BaiduPayConstants.SIGN_METHOD);
		signParams.put("key", BaiduPayConstants.SIGN_METHOD);
		
		 return null;
	}
	
	
}
