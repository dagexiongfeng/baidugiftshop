package baidu.giftshop.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import baidu.giftshop.constants.BaiduPayConstants;
import baidu.giftshop.util.CreatSignUtil;
import baidu.giftshop.util.MD5Util;
/**
 * 百度钱包支付的相关方法
 * @author tongwenli
 * 
 */
@Controller
@RequestMapping("/pay")
public class BaiduPayController {
	
	public static final Logger logger=LoggerFactory.getLogger(BaiduPayController.class);
	
	
	/**
	 * 对订单生成签名
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/getSign")
	public Object getSign(HttpServletRequest request) throws IOException{
	
		String goods_name = request.getParameter("goods_name");
		goods_name = new String(goods_name.getBytes("utf-8"),"GBK");
		String goods_desc = request.getParameter("goods_desc");
		goods_desc = new String(goods_desc.getBytes("utf-8"),"GBK");

		//设置支付参数
		SortedMap<String, String> signParams = new TreeMap<String,String>();
		signParams.put("service_code", BaiduPayConstants.SERVICE_CODE);
		signParams.put("sp_no", BaiduPayConstants.SP_NO);
		signParams.put("order_create_time", request.getParameter("order_create_time"));
		signParams.put("order_no", request.getParameter("order_no"));
		signParams.put("goods_name", goods_name);
		signParams.put("goods_desc", goods_desc);		
		signParams.put("total_amount", request.getParameter("total_amount"));
		signParams.put("currency", BaiduPayConstants.CURRENCY);
		signParams.put("return_url", request.getParameter("return_url"));
		signParams.put("pay_type", BaiduPayConstants.PAY_TYPE);
		signParams.put("input_charset", "1");
		signParams.put("version", "2");
		signParams.put("sign_method", BaiduPayConstants.SIGN_METHOD);
		signParams.put("key", BaiduPayConstants.SIGN_METHOD);
		
		//生成支付签名,采用MD5方式
		String sign=CreatSignUtil.createSign(signParams);
		 return null;
	}

	/**
	 * 根据客户端传回的订单号查询支付状态
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/getOrderStatus")
	public Object getOrderStatus(HttpServletRequest request) throws IOException{
	
		return null;
	}
	
	
	
	
	/**
	 * 当判断客户端请求我支付状态不同时
	 * 按订单号向百度支付服务器查询支付结果接口
	 * 当百度支付服务器与当前的后台服务器支付结果不同时,以百度支付服务器为准改变本地服务器支付状态
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public Object getBaiduPayOrderStatus(HttpServletRequest request) throws IOException{
	
		 return null;
	}
	
	/**
	 * 百度支付服务器异步返回的支付结果
	 * 根据支付结果改变订单状态
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public Object chuangeOrderStatus(HttpServletRequest request) throws IOException{
		
		 return null;
	}
}
