package baidu.giftshop.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import baidu.giftshop.constants.BaiduPayConstants;
import baidu.giftshop.model.Base;
import baidu.giftshop.service.IOrderService;
import baidu.giftshop.util.CreatSignUtil;
import baidu.giftshop.util.HttpUtilsGet;
import baidu.giftshop.util.MD5Test;
import baidu.giftshop.util.MD5Util;
import baidu.giftshop.util.StringUtil;
/**
 * 百度钱包支付相关接口
 * @author tongwenli
 * @version 1.0
 */
@Controller
public class BaiduPayController {
	
	public static final Logger logger=LoggerFactory.getLogger(BaiduPayController.class);
	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	
	/**
	 * 获取sign 接口
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@ResponseBody
	@RequestMapping("/getSign")
	public Object getSign(HttpServletRequest request) throws IOException{
	
		String goods_name = request.getParameter("goods_name");
		goods_name = new String(goods_name.getBytes("UTF-8"),"GBK");
		String goods_desc = request.getParameter("goods_desc");
		goods_desc = new String(goods_desc.getBytes("UTF-8"),"GBK");

		String subbranchid= request.getParameter("subbranch_id");
		//配置请求参数
		SortedMap<String, String> signParams = new TreeMap<String,String>();
		signParams.put("service_code", BaiduPayConstants.SERVICE_CODE);//服务编号
		signParams.put("sp_no", BaiduPayConstants.SP_NO);//商户号
		signParams.put("order_create_time", request.getParameter("order_create_time"));
		signParams.put("order_no", request.getParameter("order_no"));
		signParams.put("goods_name", goods_name);
		signParams.put("goods_desc", goods_desc);		
		signParams.put("total_amount", request.getParameter("total_amount"));
		signParams.put("currency", BaiduPayConstants.CURRENCY);
		signParams.put("return_url", BaiduPayConstants.RETURN_URL);
		signParams.put("pay_type", BaiduPayConstants.PAY_TYPE);
		signParams.put("input_charset", "1");
		signParams.put("version", "2");
		signParams.put("sign_method", BaiduPayConstants.SIGN_METHOD);
		
		String sign1=CreatSignUtil.modifyString(signParams);
		
		String finalString=sign1+"key="+BaiduPayConstants.KEY;
		System.out.println(finalString);
		 
		//获取MD5加密
		String sign=MD5Test.MD5(finalString);
		System.out.println(sign);
		Map<String,String> paramMap=new HashMap<String, String>();
		paramMap.put("sign", sign);
		paramMap.put("sp_no", BaiduPayConstants.SP_NO);
		paramMap.put("return_url",BaiduPayConstants.RETURN_URL);
		Base base = new Base();
		base.setCode(101);
		base.setContent(paramMap);
		base.setResult("OK");
		return base;
	}

	/**
	 * 客户端获取服务器订单状态 根据订单号查询订单状态,如果是已支付返回 1 支付成功,如果是待支付,查询百度支付服务器
	 * 根据服务器返回的参数判断支付状态,进行操作
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/getOrderStatus")
	public Object getOrderStatus(HttpServletRequest request) throws IOException{
		String order_no = request.getParameter("order_no");
		String status = orderService.queryStatus(order_no);
		Base base = new Base();
		Map<String,String> paramMap=new HashMap<String, String>();

		if(status.equals("已支付")){
			paramMap.put("state", "1");//支付成功
			paramMap.put("order_no",order_no);
			base.setCode(101);
			base.setContent(paramMap);
			base.setResult("OK");
			return base;
		}if(status.equals("待支付")){
			String pay_result = (String) getBaiduPayOrderStatus(order_no);
			if( pay_result != ""){
				 String [] ss = pay_result.split(";");
				 String	pay_result1 = ss[0];
				 String pay_time = ss[1];
				 if(pay_result1.equals("1")){
				   	 orderService.changeOrderStatus(order_no,pay_time);
					 paramMap.put("state", "1");//支付成功
					 paramMap.put("order_no",order_no);
					 base.setCode(101);
					 base.setContent(paramMap);
					 base.setResult("OK");
					 return base;
				 }
				 if(pay_result1.equals("2")){
				     paramMap.put("state", "2");//等待支付
					 paramMap.put("order_no",order_no);
					 base.setCode(101);
					 base.setContent(paramMap);
					 base.setResult("OK");
					 return base;
					 }
			}else{
				 paramMap.put("state", "4");//支付异常
				 paramMap.put("order_no",order_no);
				 base.setCode(101);
				 base.setContent(paramMap);
				 base.setResult("error");
			}
			
		}
		
		return base;
	}
	
	
	
	
	/**
	 * 按订单号查询支付结果接口
	 * 客户端请求我的订单状态,会传给服务器的支付结果和订单号,服务器根据订单号查看支付结果,
	 * 假如不同,会请求百度服务器查看支付结果,判断支付状态,
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public  static Object getBaiduPayOrderStatus(String  order_no) throws IOException{

		SortedMap<String, String> signParams = new TreeMap<String,String>();
		signParams.put("service_code", "11");
		signParams.put("sp_no", BaiduPayConstants.SP_NO);
		signParams.put("order_no", order_no);
		signParams.put("output_type", "1");//响应格式
		signParams.put("output_charset", "1");//响应的字符编码
		signParams.put("version", "2");
		signParams.put("sign_method", "1");
		String sign1=CreatSignUtil.modifyString(signParams);
		String finalString=sign1+"key="+BaiduPayConstants.KEY;
		String sign=MD5Test.MD5(finalString);
		signParams.put("sign", sign);
		String url="https://www.baifubao.com/api/0/query/0/pay_result_by_order_no?"+CreatSignUtil.createUrlParam(signParams);
		System.out.println(url);
		//通过httpclient请求百度钱包服务器
		  try {
			String xml= HttpUtilsGet.doGet(url);
			SAXReader saxReader = new SAXReader();
			Document dom = saxReader.read(new ByteArrayInputStream(xml.getBytes()));
			Element  eleRoot = dom.getRootElement();
		    String query_status = eleRoot.elementText("query_status");//获取查询状态
		    if(query_status.equals("0")){
		        String pay_result = eleRoot.elementText("pay_result");//获取支付结果
		        String order_no1 = eleRoot.elementText("order_no");//获取订单号
 		        String pay_time= "1";
		        if(pay_result.equals("1")){
		        	pay_time = eleRoot.elementText("pay_time");//获取支付时间
		        }
		        if(order_no1.equals(order_no)){
		        	return pay_result+";"+pay_time;
		        }
		    }
		    System.out.println(query_status);
		    
		    
		} catch (Exception e) {
			logger.error("it is error when request baidupay server");
			e.printStackTrace();
		}
		
	return "";
	}
	
	/**
	 * 百度支付服务器异步返回的支付状态,根据支付状态改变本地的订单状态
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException 
	 */
	@RequestMapping("/payState")
	public Object changeOrderStatus(HttpServletRequest request,HttpServletResponse response) throws IOException, DocumentException{
		
		 String order_no= request.getParameter("order_no");
		 String pay_result= request.getParameter("pay_result");
		 String pay_time= request.getParameter("pay_time");
		
		 if(StringUtils.isNotEmpty(pay_result)&&pay_result.equals("1")){//当支付成功时
			 orderService.changeOrderStatus(order_no,pay_time);
			 
		 }
		
		
		 return "payreturn";
	}
	public static void main(String[] args) {
		BaiduPayController s=new BaiduPayController();
		 try {
			Object ss= s.getBaiduPayOrderStatus("11");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
