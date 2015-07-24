package baidu.giftshop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import baidu.giftshop.model.Base;
import baidu.giftshop.service.IOrderService;
import baidu.giftshop.service.IUserService;

@Controller
public class OrderController {
	
	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	/**
	 * 安卓端传递user_id,subbranch_id,goods_detail_id,num后实现对商品的一键下单
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/AddOrder")
	public void AddOrder(HttpServletRequest request,HttpServletResponse response){
		Base base = new Base();
		
		Integer user_id = userService.getUid(request.getParameter("user_id"));
		
		String subbranch_id = request.getParameter("subbranch_id");
		String goods_detail_id = request.getParameter("goods_detail_id");
		String num = request.getParameter("num");
		String state = "待付款";
		Integer addressid = Integer.parseInt(request.getParameter("addressid"));
		base = orderService.addOrder(user_id, subbranch_id, goods_detail_id, num, state, addressid);
		
		response.setContentType("text/javascript;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		   try {
			response.getWriter().print(JSON.toJSONString(base));
		} catch (IOException e) {
			e.printStackTrace();
		    }
	}
	
	/**
	 * 根据user_id查询某个用户的订单信息
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/QueryOrder")
	public void QueryOrder(HttpServletRequest request,HttpServletResponse response){
		Base base = new Base();
		
		Integer user_id = userService.getUid(request.getParameter("user_id"));
		
		//相对于安卓前端的分页查找结果
		Integer startIndex = Integer.parseInt(request.getParameter("startIndex"));
		Integer requestAmount = Integer.parseInt(request.getParameter("requestAmount"));
		base = orderService.queryOrder(user_id, startIndex, requestAmount);
		response.setContentType("text/javascript;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		   try {
			response.getWriter().print(JSON.toJSONString(base));
		} catch (IOException e) {
			e.printStackTrace();
		    }
	}
}
